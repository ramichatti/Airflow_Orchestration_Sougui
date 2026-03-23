FROM apache/airflow:3.1.8

USER root

RUN apt-get update && \
    apt-get install -y default-jdk && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

USER airflow

ENV JAVA_TOOL_OPTIONS="-Duser.dir=/opt/airflow"