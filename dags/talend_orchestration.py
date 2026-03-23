from airflow import DAG
from airflow.providers.standard.operators.bash import BashOperator
from datetime import datetime, timedelta

default_args = {
    'owner': 'airflow',
    'retries': 1,
    'retry_delay': timedelta(minutes=30),
    'email_on_failure': False,
}

with DAG(
    dag_id='talend_master_orchestration',
    default_args=default_args,
    start_date=datetime(2026, 1, 1),
    schedule='0 9 * * 2',
    catchup=False,
    description="Orchestration d'un pipeline ETL : Master_SA puis Master_DWH",
    tags=['talend'],
) as dag:

    master_sa = BashOperator(
        task_id='Master_SA',
        bash_command='bash /opt/talend/jobs/Master_SA/Master_SA/Master_SA_run.sh ',
        env={
            'JAVA_TOOL_OPTIONS': '-Duser.dir=/opt/airflow',
            'HOME': '/opt/airflow',
        },
        execution_timeout=timedelta(minutes=60),
   )

    master_dwh = BashOperator(
        task_id='Master_DWH',
        bash_command='bash /opt/talend/jobs/Master_DWH/Master_DWH/Master_DWH_run.sh ',
        execution_timeout=timedelta(minutes=60),
    )

    master_sa >> master_dwh