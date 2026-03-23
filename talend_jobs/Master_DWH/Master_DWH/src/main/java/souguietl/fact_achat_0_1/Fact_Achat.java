// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package souguietl.fact_achat_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: Fact_Achat Purpose: <br>
 * Description:  <br>
 * @author 
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class Fact_Achat implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "Fact_Achat";
	private final String projectName = "SOUGUIETL";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				Fact_Achat.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Fact_Achat.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class ajoutStruct implements routines.system.IPersistableRow<ajoutStruct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_Achat = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_Achat = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_fournisseur;

				public int getId_fournisseur () {
					return this.id_fournisseur;
				}
				
			    public int id_Produit;

				public int getId_Produit () {
					return this.id_Produit;
				}
				
			    public int date_Key;

				public int getDate_Key () {
					return this.date_Key;
				}
				
			    public String num_facture;

				public String getNum_facture () {
					return this.num_facture;
				}
				
			    public Float montant_ht_facture;

				public Float getMontant_ht_facture () {
					return this.montant_ht_facture;
				}
				
			    public Float tva;

				public Float getTva () {
					return this.tva;
				}
				
			    public Float timbre;

				public Float getTimbre () {
					return this.timbre;
				}
				
			    public Float montant_ttc_facture;

				public Float getMontant_ttc_facture () {
					return this.montant_ttc_facture;
				}
				
			    public Float reste_du;

				public Float getReste_du () {
					return this.reste_du;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public Float montant_ligne;

				public Float getMontant_ligne () {
					return this.montant_ligne;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.id_fournisseur;
						
							result = prime * result + (int) this.id_Produit;
						
							result = prime * result + (int) this.date_Key;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final ajoutStruct other = (ajoutStruct) obj;
		
						if (this.id_fournisseur != other.id_fournisseur)
							return false;
					
						if (this.id_Produit != other.id_Produit)
							return false;
					
						if (this.date_Key != other.date_Key)
							return false;
					

		return true;
    }

	public void copyDataTo(ajoutStruct other) {

		other.id_fournisseur = this.id_fournisseur;
	            other.id_Produit = this.id_Produit;
	            other.date_Key = this.date_Key;
	            other.num_facture = this.num_facture;
	            other.montant_ht_facture = this.montant_ht_facture;
	            other.tva = this.tva;
	            other.timbre = this.timbre;
	            other.montant_ttc_facture = this.montant_ttc_facture;
	            other.reste_du = this.reste_du;
	            other.quantite = this.quantite;
	            other.montant_ligne = this.montant_ligne;
	            
	}

	public void copyKeysDataTo(ajoutStruct other) {

		other.id_fournisseur = this.id_fournisseur;
	            	other.id_Produit = this.id_Produit;
	            	other.date_Key = this.date_Key;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
			        this.id_fournisseur = dis.readInt();
					
			        this.id_Produit = dis.readInt();
					
			        this.date_Key = dis.readInt();
					
					this.num_facture = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht_facture = null;
           				} else {
           			    	this.montant_ht_facture = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc_facture = null;
           				} else {
           			    	this.montant_ttc_facture = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
						this.quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ligne = null;
           				} else {
           			    	this.montant_ligne = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
			        this.id_fournisseur = dis.readInt();
					
			        this.id_Produit = dis.readInt();
					
			        this.date_Key = dis.readInt();
					
					this.num_facture = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht_facture = null;
           				} else {
           			    	this.montant_ht_facture = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc_facture = null;
           				} else {
           			    	this.montant_ttc_facture = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
						this.quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ligne = null;
           				} else {
           			    	this.montant_ligne = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fournisseur);
					
					// int
				
		            	dos.writeInt(this.id_Produit);
					
					// int
				
		            	dos.writeInt(this.date_Key);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// Float
				
						if(this.montant_ht_facture == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht_facture);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc_facture == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc_facture);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// Float
				
						if(this.montant_ligne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ligne);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fournisseur);
					
					// int
				
		            	dos.writeInt(this.id_Produit);
					
					// int
				
		            	dos.writeInt(this.date_Key);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// Float
				
						if(this.montant_ht_facture == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht_facture);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc_facture == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc_facture);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// Float
				
						if(this.montant_ligne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ligne);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_fournisseur="+String.valueOf(id_fournisseur));
		sb.append(",id_Produit="+String.valueOf(id_Produit));
		sb.append(",date_Key="+String.valueOf(date_Key));
		sb.append(",num_facture="+num_facture);
		sb.append(",montant_ht_facture="+String.valueOf(montant_ht_facture));
		sb.append(",tva="+String.valueOf(tva));
		sb.append(",timbre="+String.valueOf(timbre));
		sb.append(",montant_ttc_facture="+String.valueOf(montant_ttc_facture));
		sb.append(",reste_du="+String.valueOf(reste_du));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",montant_ligne="+String.valueOf(montant_ligne));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(ajoutStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_fournisseur, other.id_fournisseur);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.id_Produit, other.id_Produit);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.date_Key, other.date_Key);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class fk_dateStruct implements routines.system.IPersistableRow<fk_dateStruct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_Achat = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_Achat = new byte[0];

	
			    public int id_fournisseur;

				public int getId_fournisseur () {
					return this.id_fournisseur;
				}
				
			    public int Id_Produit;

				public int getId_Produit () {
					return this.Id_Produit;
				}
				
			    public int Date_Key;

				public int getDate_Key () {
					return this.Date_Key;
				}
				
			    public String num_facture;

				public String getNum_facture () {
					return this.num_facture;
				}
				
			    public Float montant_ht;

				public Float getMontant_ht () {
					return this.montant_ht;
				}
				
			    public Float tva;

				public Float getTva () {
					return this.tva;
				}
				
			    public Float timbre;

				public Float getTimbre () {
					return this.timbre;
				}
				
			    public Float montant_ttc;

				public Float getMontant_ttc () {
					return this.montant_ttc;
				}
				
			    public Float reste_du;

				public Float getReste_du () {
					return this.reste_du;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public Float montant_ligne;

				public Float getMontant_ligne () {
					return this.montant_ligne;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
			        this.id_fournisseur = dis.readInt();
					
			        this.Id_Produit = dis.readInt();
					
			        this.Date_Key = dis.readInt();
					
					this.num_facture = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht = null;
           				} else {
           			    	this.montant_ht = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc = null;
           				} else {
           			    	this.montant_ttc = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
						this.quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ligne = null;
           				} else {
           			    	this.montant_ligne = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
			        this.id_fournisseur = dis.readInt();
					
			        this.Id_Produit = dis.readInt();
					
			        this.Date_Key = dis.readInt();
					
					this.num_facture = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht = null;
           				} else {
           			    	this.montant_ht = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc = null;
           				} else {
           			    	this.montant_ttc = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
						this.quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ligne = null;
           				} else {
           			    	this.montant_ligne = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fournisseur);
					
					// int
				
		            	dos.writeInt(this.Id_Produit);
					
					// int
				
		            	dos.writeInt(this.Date_Key);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// Float
				
						if(this.montant_ht == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// Float
				
						if(this.montant_ligne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ligne);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fournisseur);
					
					// int
				
		            	dos.writeInt(this.Id_Produit);
					
					// int
				
		            	dos.writeInt(this.Date_Key);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// Float
				
						if(this.montant_ht == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// Float
				
						if(this.montant_ligne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ligne);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_fournisseur="+String.valueOf(id_fournisseur));
		sb.append(",Id_Produit="+String.valueOf(Id_Produit));
		sb.append(",Date_Key="+String.valueOf(Date_Key));
		sb.append(",num_facture="+num_facture);
		sb.append(",montant_ht="+String.valueOf(montant_ht));
		sb.append(",tva="+String.valueOf(tva));
		sb.append(",timbre="+String.valueOf(timbre));
		sb.append(",montant_ttc="+String.valueOf(montant_ttc));
		sb.append(",reste_du="+String.valueOf(reste_du));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",montant_ligne="+String.valueOf(montant_ligne));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(fk_dateStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class fk_produitStruct implements routines.system.IPersistableRow<fk_produitStruct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_Achat = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_Achat = new byte[0];

	
			    public int id_fournisseur;

				public int getId_fournisseur () {
					return this.id_fournisseur;
				}
				
			    public int Id_Produit;

				public int getId_Produit () {
					return this.Id_Produit;
				}
				
			    public String num_facture;

				public String getNum_facture () {
					return this.num_facture;
				}
				
			    public java.util.Date date_facture;

				public java.util.Date getDate_facture () {
					return this.date_facture;
				}
				
			    public Float montant_ht;

				public Float getMontant_ht () {
					return this.montant_ht;
				}
				
			    public Float tva;

				public Float getTva () {
					return this.tva;
				}
				
			    public Float timbre;

				public Float getTimbre () {
					return this.timbre;
				}
				
			    public Float montant_ttc;

				public Float getMontant_ttc () {
					return this.montant_ttc;
				}
				
			    public Float reste_du;

				public Float getReste_du () {
					return this.reste_du;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public Float montant_ligne;

				public Float getMontant_ligne () {
					return this.montant_ligne;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
			        this.id_fournisseur = dis.readInt();
					
			        this.Id_Produit = dis.readInt();
					
					this.num_facture = readString(dis);
					
					this.date_facture = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht = null;
           				} else {
           			    	this.montant_ht = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc = null;
           				} else {
           			    	this.montant_ttc = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
						this.quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ligne = null;
           				} else {
           			    	this.montant_ligne = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
			        this.id_fournisseur = dis.readInt();
					
			        this.Id_Produit = dis.readInt();
					
					this.num_facture = readString(dis);
					
					this.date_facture = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht = null;
           				} else {
           			    	this.montant_ht = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc = null;
           				} else {
           			    	this.montant_ttc = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
						this.quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ligne = null;
           				} else {
           			    	this.montant_ligne = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fournisseur);
					
					// int
				
		            	dos.writeInt(this.Id_Produit);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// java.util.Date
				
						writeDate(this.date_facture,dos);
					
					// Float
				
						if(this.montant_ht == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// Float
				
						if(this.montant_ligne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ligne);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fournisseur);
					
					// int
				
		            	dos.writeInt(this.Id_Produit);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// java.util.Date
				
						writeDate(this.date_facture,dos);
					
					// Float
				
						if(this.montant_ht == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// Float
				
						if(this.montant_ligne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ligne);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_fournisseur="+String.valueOf(id_fournisseur));
		sb.append(",Id_Produit="+String.valueOf(Id_Produit));
		sb.append(",num_facture="+num_facture);
		sb.append(",date_facture="+String.valueOf(date_facture));
		sb.append(",montant_ht="+String.valueOf(montant_ht));
		sb.append(",tva="+String.valueOf(tva));
		sb.append(",timbre="+String.valueOf(timbre));
		sb.append(",montant_ttc="+String.valueOf(montant_ttc));
		sb.append(",reste_du="+String.valueOf(reste_du));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",montant_ligne="+String.valueOf(montant_ligne));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(fk_produitStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class fk_entrepriseStruct implements routines.system.IPersistableRow<fk_entrepriseStruct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_Achat = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_Achat = new byte[0];

	
			    public int id_fournisseur;

				public int getId_fournisseur () {
					return this.id_fournisseur;
				}
				
			    public String num_facture;

				public String getNum_facture () {
					return this.num_facture;
				}
				
			    public String date_facture;

				public String getDate_facture () {
					return this.date_facture;
				}
				
			    public Float montant_ht;

				public Float getMontant_ht () {
					return this.montant_ht;
				}
				
			    public Float tva;

				public Float getTva () {
					return this.tva;
				}
				
			    public Float timbre;

				public Float getTimbre () {
					return this.timbre;
				}
				
			    public Float montant_ttc;

				public Float getMontant_ttc () {
					return this.montant_ttc;
				}
				
			    public Float reste_du;

				public Float getReste_du () {
					return this.reste_du;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public Float montant_ligne;

				public Float getMontant_ligne () {
					return this.montant_ligne;
				}
				
			    public Float prix_unitaire;

				public Float getPrix_unitaire () {
					return this.prix_unitaire;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
			        this.id_fournisseur = dis.readInt();
					
					this.num_facture = readString(dis);
					
					this.date_facture = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht = null;
           				} else {
           			    	this.montant_ht = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc = null;
           				} else {
           			    	this.montant_ttc = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
					this.reference = readString(dis);
					
					this.description = readString(dis);
					
						this.quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ligne = null;
           				} else {
           			    	this.montant_ligne = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.prix_unitaire = null;
           				} else {
           			    	this.prix_unitaire = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
			        this.id_fournisseur = dis.readInt();
					
					this.num_facture = readString(dis);
					
					this.date_facture = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht = null;
           				} else {
           			    	this.montant_ht = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc = null;
           				} else {
           			    	this.montant_ttc = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
					this.reference = readString(dis);
					
					this.description = readString(dis);
					
						this.quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ligne = null;
           				} else {
           			    	this.montant_ligne = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.prix_unitaire = null;
           				} else {
           			    	this.prix_unitaire = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fournisseur);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// String
				
						writeString(this.date_facture,dos);
					
					// Float
				
						if(this.montant_ht == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// Float
				
						if(this.montant_ligne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ligne);
		            	}
					
					// Float
				
						if(this.prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.prix_unitaire);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fournisseur);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// String
				
						writeString(this.date_facture,dos);
					
					// Float
				
						if(this.montant_ht == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// Float
				
						if(this.montant_ligne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ligne);
		            	}
					
					// Float
				
						if(this.prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.prix_unitaire);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_fournisseur="+String.valueOf(id_fournisseur));
		sb.append(",num_facture="+num_facture);
		sb.append(",date_facture="+date_facture);
		sb.append(",montant_ht="+String.valueOf(montant_ht));
		sb.append(",tva="+String.valueOf(tva));
		sb.append(",timbre="+String.valueOf(timbre));
		sb.append(",montant_ttc="+String.valueOf(montant_ttc));
		sb.append(",reste_du="+String.valueOf(reste_du));
		sb.append(",reference="+reference);
		sb.append(",description="+description);
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",montant_ligne="+String.valueOf(montant_ligne));
		sb.append(",prix_unitaire="+String.valueOf(prix_unitaire));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(fk_entrepriseStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_Achat = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_Achat = new byte[0];

	
			    public String fournisseur;

				public String getFournisseur () {
					return this.fournisseur;
				}
				
			    public String matricule_fiscal;

				public String getMatricule_fiscal () {
					return this.matricule_fiscal;
				}
				
			    public String telephones;

				public String getTelephones () {
					return this.telephones;
				}
				
			    public String num_facture;

				public String getNum_facture () {
					return this.num_facture;
				}
				
			    public String date_facture;

				public String getDate_facture () {
					return this.date_facture;
				}
				
			    public Float montant_ht;

				public Float getMontant_ht () {
					return this.montant_ht;
				}
				
			    public Float tva;

				public Float getTva () {
					return this.tva;
				}
				
			    public Float timbre;

				public Float getTimbre () {
					return this.timbre;
				}
				
			    public Float montant_ttc;

				public Float getMontant_ttc () {
					return this.montant_ttc;
				}
				
			    public Float reste_du;

				public Float getReste_du () {
					return this.reste_du;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public Float montant_ligne;

				public Float getMontant_ligne () {
					return this.montant_ligne;
				}
				
			    public Float prix_unitaire;

				public Float getPrix_unitaire () {
					return this.prix_unitaire;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.fournisseur = readString(dis);
					
					this.matricule_fiscal = readString(dis);
					
					this.telephones = readString(dis);
					
					this.num_facture = readString(dis);
					
					this.date_facture = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht = null;
           				} else {
           			    	this.montant_ht = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc = null;
           				} else {
           			    	this.montant_ttc = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
					this.reference = readString(dis);
					
					this.description = readString(dis);
					
						this.quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ligne = null;
           				} else {
           			    	this.montant_ligne = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.prix_unitaire = null;
           				} else {
           			    	this.prix_unitaire = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.fournisseur = readString(dis);
					
					this.matricule_fiscal = readString(dis);
					
					this.telephones = readString(dis);
					
					this.num_facture = readString(dis);
					
					this.date_facture = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht = null;
           				} else {
           			    	this.montant_ht = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc = null;
           				} else {
           			    	this.montant_ttc = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
					this.reference = readString(dis);
					
					this.description = readString(dis);
					
						this.quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ligne = null;
           				} else {
           			    	this.montant_ligne = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.prix_unitaire = null;
           				} else {
           			    	this.prix_unitaire = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.fournisseur,dos);
					
					// String
				
						writeString(this.matricule_fiscal,dos);
					
					// String
				
						writeString(this.telephones,dos);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// String
				
						writeString(this.date_facture,dos);
					
					// Float
				
						if(this.montant_ht == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// Float
				
						if(this.montant_ligne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ligne);
		            	}
					
					// Float
				
						if(this.prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.prix_unitaire);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.fournisseur,dos);
					
					// String
				
						writeString(this.matricule_fiscal,dos);
					
					// String
				
						writeString(this.telephones,dos);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// String
				
						writeString(this.date_facture,dos);
					
					// Float
				
						if(this.montant_ht == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// Float
				
						if(this.montant_ligne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ligne);
		            	}
					
					// Float
				
						if(this.prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.prix_unitaire);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("fournisseur="+fournisseur);
		sb.append(",matricule_fiscal="+matricule_fiscal);
		sb.append(",telephones="+telephones);
		sb.append(",num_facture="+num_facture);
		sb.append(",date_facture="+date_facture);
		sb.append(",montant_ht="+String.valueOf(montant_ht));
		sb.append(",tva="+String.valueOf(tva));
		sb.append(",timbre="+String.valueOf(timbre));
		sb.append(",montant_ttc="+String.valueOf(montant_ttc));
		sb.append(",reste_du="+String.valueOf(reste_du));
		sb.append(",reference="+reference);
		sb.append(",description="+description);
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",montant_ligne="+String.valueOf(montant_ligne));
		sb.append(",prix_unitaire="+String.valueOf(prix_unitaire));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_Achat = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_Achat = new byte[0];

	
			    public String fournisseur;

				public String getFournisseur () {
					return this.fournisseur;
				}
				
			    public String matricule_fiscal;

				public String getMatricule_fiscal () {
					return this.matricule_fiscal;
				}
				
			    public String telephones;

				public String getTelephones () {
					return this.telephones;
				}
				
			    public String num_facture;

				public String getNum_facture () {
					return this.num_facture;
				}
				
			    public String date_facture;

				public String getDate_facture () {
					return this.date_facture;
				}
				
			    public Float montant_ht;

				public Float getMontant_ht () {
					return this.montant_ht;
				}
				
			    public Float tva;

				public Float getTva () {
					return this.tva;
				}
				
			    public Float timbre;

				public Float getTimbre () {
					return this.timbre;
				}
				
			    public Float montant_ttc;

				public Float getMontant_ttc () {
					return this.montant_ttc;
				}
				
			    public Float reste_du;

				public Float getReste_du () {
					return this.reste_du;
				}
				
			    public String extraction_method;

				public String getExtraction_method () {
					return this.extraction_method;
				}
				
			    public Float confidence_score;

				public Float getConfidence_score () {
					return this.confidence_score;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.fournisseur = readString(dis);
					
					this.matricule_fiscal = readString(dis);
					
					this.telephones = readString(dis);
					
					this.num_facture = readString(dis);
					
					this.date_facture = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht = null;
           				} else {
           			    	this.montant_ht = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc = null;
           				} else {
           			    	this.montant_ttc = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
					this.extraction_method = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.confidence_score = null;
           				} else {
           			    	this.confidence_score = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.fournisseur = readString(dis);
					
					this.matricule_fiscal = readString(dis);
					
					this.telephones = readString(dis);
					
					this.num_facture = readString(dis);
					
					this.date_facture = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht = null;
           				} else {
           			    	this.montant_ht = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc = null;
           				} else {
           			    	this.montant_ttc = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
					this.extraction_method = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.confidence_score = null;
           				} else {
           			    	this.confidence_score = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.fournisseur,dos);
					
					// String
				
						writeString(this.matricule_fiscal,dos);
					
					// String
				
						writeString(this.telephones,dos);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// String
				
						writeString(this.date_facture,dos);
					
					// Float
				
						if(this.montant_ht == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// String
				
						writeString(this.extraction_method,dos);
					
					// Float
				
						if(this.confidence_score == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.confidence_score);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.fournisseur,dos);
					
					// String
				
						writeString(this.matricule_fiscal,dos);
					
					// String
				
						writeString(this.telephones,dos);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// String
				
						writeString(this.date_facture,dos);
					
					// Float
				
						if(this.montant_ht == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// String
				
						writeString(this.extraction_method,dos);
					
					// Float
				
						if(this.confidence_score == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.confidence_score);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("fournisseur="+fournisseur);
		sb.append(",matricule_fiscal="+matricule_fiscal);
		sb.append(",telephones="+telephones);
		sb.append(",num_facture="+num_facture);
		sb.append(",date_facture="+date_facture);
		sb.append(",montant_ht="+String.valueOf(montant_ht));
		sb.append(",tva="+String.valueOf(tva));
		sb.append(",timbre="+String.valueOf(timbre));
		sb.append(",montant_ttc="+String.valueOf(montant_ttc));
		sb.append(",reste_du="+String.valueOf(reste_du));
		sb.append(",extraction_method="+extraction_method);
		sb.append(",confidence_score="+String.valueOf(confidence_score));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_Achat = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_Achat = new byte[0];

	
			    public String fournisseur;

				public String getFournisseur () {
					return this.fournisseur;
				}
				
			    public String matricule_fiscal;

				public String getMatricule_fiscal () {
					return this.matricule_fiscal;
				}
				
			    public String telephones;

				public String getTelephones () {
					return this.telephones;
				}
				
			    public String num_facture;

				public String getNum_facture () {
					return this.num_facture;
				}
				
			    public String date_facture;

				public String getDate_facture () {
					return this.date_facture;
				}
				
			    public Float montant_ht;

				public Float getMontant_ht () {
					return this.montant_ht;
				}
				
			    public Float tva;

				public Float getTva () {
					return this.tva;
				}
				
			    public Float timbre;

				public Float getTimbre () {
					return this.timbre;
				}
				
			    public Float montant_ttc;

				public Float getMontant_ttc () {
					return this.montant_ttc;
				}
				
			    public Float reste_du;

				public Float getReste_du () {
					return this.reste_du;
				}
				
			    public String extraction_method;

				public String getExtraction_method () {
					return this.extraction_method;
				}
				
			    public Float confidence_score;

				public Float getConfidence_score () {
					return this.confidence_score;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.fournisseur = readString(dis);
					
					this.matricule_fiscal = readString(dis);
					
					this.telephones = readString(dis);
					
					this.num_facture = readString(dis);
					
					this.date_facture = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht = null;
           				} else {
           			    	this.montant_ht = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc = null;
           				} else {
           			    	this.montant_ttc = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
					this.extraction_method = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.confidence_score = null;
           				} else {
           			    	this.confidence_score = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.fournisseur = readString(dis);
					
					this.matricule_fiscal = readString(dis);
					
					this.telephones = readString(dis);
					
					this.num_facture = readString(dis);
					
					this.date_facture = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht = null;
           				} else {
           			    	this.montant_ht = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc = null;
           				} else {
           			    	this.montant_ttc = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
					this.extraction_method = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.confidence_score = null;
           				} else {
           			    	this.confidence_score = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.fournisseur,dos);
					
					// String
				
						writeString(this.matricule_fiscal,dos);
					
					// String
				
						writeString(this.telephones,dos);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// String
				
						writeString(this.date_facture,dos);
					
					// Float
				
						if(this.montant_ht == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// String
				
						writeString(this.extraction_method,dos);
					
					// Float
				
						if(this.confidence_score == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.confidence_score);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.fournisseur,dos);
					
					// String
				
						writeString(this.matricule_fiscal,dos);
					
					// String
				
						writeString(this.telephones,dos);
					
					// String
				
						writeString(this.num_facture,dos);
					
					// String
				
						writeString(this.date_facture,dos);
					
					// Float
				
						if(this.montant_ht == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht);
		            	}
					
					// Float
				
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
					// Float
				
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
					// Float
				
						if(this.montant_ttc == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc);
		            	}
					
					// Float
				
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
					// String
				
						writeString(this.extraction_method,dos);
					
					// Float
				
						if(this.confidence_score == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.confidence_score);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("fournisseur="+fournisseur);
		sb.append(",matricule_fiscal="+matricule_fiscal);
		sb.append(",telephones="+telephones);
		sb.append(",num_facture="+num_facture);
		sb.append(",date_facture="+date_facture);
		sb.append(",montant_ht="+String.valueOf(montant_ht));
		sb.append(",tva="+String.valueOf(tva));
		sb.append(",timbre="+String.valueOf(timbre));
		sb.append(",montant_ttc="+String.valueOf(montant_ttc));
		sb.append(",reste_du="+String.valueOf(reste_du));
		sb.append(",extraction_method="+extraction_method);
		sb.append(",confidence_score="+String.valueOf(confidence_score));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_2Process(globalMap);
		tDBInput_3Process(globalMap);
		tDBInput_4Process(globalMap);
		tDBInput_5Process(globalMap);
		tDBInput_6Process(globalMap);

		row1Struct row1 = new row1Struct();
out1Struct out1 = new out1Struct();
fk_entrepriseStruct fk_entreprise = new fk_entrepriseStruct();
fk_produitStruct fk_produit = new fk_produitStruct();
fk_dateStruct fk_date = new fk_dateStruct();
ajoutStruct ajout = new ajoutStruct();









	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"ajout");
					}
				
		int tos_count_tDBOutput_1 = 0;
		



int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;
String dbschema_tDBOutput_1 = null;
String tableName_tDBOutput_1 = null;
boolean whetherReject_tDBOutput_1 = false;

java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
long year1_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd","0001-01-01").getTime();
long year2_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd","1753-01-01").getTime();
long year10000_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss","9999-12-31 24:00:00").getTime();
long date_tDBOutput_1;

java.util.Calendar calendar_datetimeoffset_tDBOutput_1 = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));



	
java.sql.Connection conn_tDBOutput_1 = null;
String dbUser_tDBOutput_1 = null;
    dbschema_tDBOutput_1 = "dbo";
    String driverClass_tDBOutput_1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
    java.lang.Class.forName(driverClass_tDBOutput_1);
    String port_tDBOutput_1 = "1433";
    String dbname_tDBOutput_1 = "Sougui_DWH" ;
    String url_tDBOutput_1 = "jdbc:sqlserver://" + "DESKTOP-LBCVIS5" ; 
    if (!"".equals(port_tDBOutput_1)) {
    	url_tDBOutput_1 += ":" + "1433";
    }
    if (!"".equals(dbname_tDBOutput_1)) {		    
		    	url_tDBOutput_1 += ";databaseName=" + "Sougui_DWH"; 
	
    }
    url_tDBOutput_1 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
    dbUser_tDBOutput_1 = "sa";

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:tNC/uFUE1v/s9KgwpEYN2Wefdh9ihseaI+0L28xBjHpXXpEW");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;

   int batchSize_tDBOutput_1 = 10000;
   int batchSizeCounter_tDBOutput_1=0;

if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "Fact_Achat";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "Fact_Achat";
}
	int count_tDBOutput_1=0;

        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([id_fournisseur],[id_Produit],[date_Key],[num_facture],[montant_ht_facture],[tva],[timbre],[montant_ttc_facture],[reste_du],[quantite],[montant_ligne]) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);


 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_5", false);
		start_Hash.put("tMap_5", System.currentTimeMillis());
		
	
	currentComponent="tMap_5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"fk_date");
					}
				
		int tos_count_tMap_5 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) 
					globalMap.get( "tHash_Lookup_row6" ))
					;					
					
	

row6Struct row6HashKey = new row6Struct();
row6Struct row6Default = new row6Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_5__Struct  {
}
Var__tMap_5__Struct Var__tMap_5 = new Var__tMap_5__Struct();
// ###############################

// ###############################
// # Outputs initialization
ajoutStruct ajout_tmp = new ajoutStruct();
// ###############################

        
        



        









 



/**
 * [tMap_5 begin ] stop
 */



	
	/**
	 * [tMap_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_4", false);
		start_Hash.put("tMap_4", System.currentTimeMillis());
		
	
	currentComponent="tMap_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"fk_produit");
					}
				
		int tos_count_tMap_4 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) 
					globalMap.get( "tHash_Lookup_row5" ))
					;					
					
	

row5Struct row5HashKey = new row5Struct();
row5Struct row5Default = new row5Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_4__Struct  {
}
Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
fk_dateStruct fk_date_tmp = new fk_dateStruct();
// ###############################

        
        



        









 



/**
 * [tMap_4 begin ] stop
 */



	
	/**
	 * [tMap_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_3", false);
		start_Hash.put("tMap_3", System.currentTimeMillis());
		
	
	currentComponent="tMap_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"fk_entreprise");
					}
				
		int tos_count_tMap_3 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
					globalMap.get( "tHash_Lookup_row4" ))
					;					
					
	

row4Struct row4HashKey = new row4Struct();
row4Struct row4Default = new row4Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_3__Struct  {
}
Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
fk_produitStruct fk_produit_tmp = new fk_produitStruct();
// ###############################

        
        



        









 



/**
 * [tMap_3 begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out1");
					}
				
		int tos_count_tMap_2 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
					globalMap.get( "tHash_Lookup_row3" ))
					;					
					
	

row3Struct row3HashKey = new row3Struct();
row3Struct row3Default = new row3Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
fk_entrepriseStruct fk_entreprise_tmp = new fk_entrepriseStruct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
out1Struct out1_tmp = new out1Struct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";

	
		int tos_count_tDBInput_1 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_1 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_1  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_1, talendToDBArray_tDBInput_1); 
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "sa";
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:lB/+m+MKS48tEldIAI86dWaxO00QPcc34PsimruylWIP+gsa");
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
		    String port_tDBInput_1 = "1433";
		    String dbname_tDBInput_1 = "Sougui_SA" ;		    
		    String url_tDBInput_1 = "jdbc:sqlserver://" + "DESKTOP-LBCVIS5" ;
		    if (!"".equals(port_tDBInput_1)) {
		    	url_tDBInput_1 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_1)) {		    
		    	url_tDBInput_1 += ";databaseName=" + "Sougui_SA"; 
		    }
		    url_tDBInput_1 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
		    String dbschema_tDBInput_1 = "dbo";
				
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
		        
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT dbo.Entete_Achat_SA.fournisseur,\n		dbo.Entete_Achat_SA.matricule_fiscal,\n		dbo.Entete_Achat_SA.telephones,\n		dbo"
+".Entete_Achat_SA.num_facture,\n		dbo.Entete_Achat_SA.date_facture,\n		dbo.Entete_Achat_SA.montant_ht,\n		dbo.Entete_Achat_S"
+"A.tva,\n		dbo.Entete_Achat_SA.timbre,\n		dbo.Entete_Achat_SA.montant_ttc,\n		dbo.Entete_Achat_SA.reste_du,\n		dbo.Entete_Ach"
+"at_SA.extraction_method,\n		dbo.Entete_Achat_SA.confidence_score\nFROM	dbo.Entete_Achat_SA";
		    

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row1.fournisseur = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(1);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.fournisseur = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.fournisseur = tmpContent_tDBInput_1;
                }
            } else {
                row1.fournisseur = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.matricule_fiscal = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.matricule_fiscal = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.matricule_fiscal = tmpContent_tDBInput_1;
                }
            } else {
                row1.matricule_fiscal = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.telephones = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.telephones = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.telephones = tmpContent_tDBInput_1;
                }
            } else {
                row1.telephones = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.num_facture = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.num_facture = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.num_facture = tmpContent_tDBInput_1;
                }
            } else {
                row1.num_facture = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.date_facture = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(5);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.date_facture = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.date_facture = tmpContent_tDBInput_1;
                }
            } else {
                row1.date_facture = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.montant_ht = null;
							} else {
		                          
            row1.montant_ht = rs_tDBInput_1.getFloat(6);
            if(rs_tDBInput_1.wasNull()){
                    row1.montant_ht = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.tva = null;
							} else {
		                          
            row1.tva = rs_tDBInput_1.getFloat(7);
            if(rs_tDBInput_1.wasNull()){
                    row1.tva = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.timbre = null;
							} else {
		                          
            row1.timbre = rs_tDBInput_1.getFloat(8);
            if(rs_tDBInput_1.wasNull()){
                    row1.timbre = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.montant_ttc = null;
							} else {
		                          
            row1.montant_ttc = rs_tDBInput_1.getFloat(9);
            if(rs_tDBInput_1.wasNull()){
                    row1.montant_ttc = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.reste_du = null;
							} else {
		                          
            row1.reste_du = rs_tDBInput_1.getFloat(10);
            if(rs_tDBInput_1.wasNull()){
                    row1.reste_du = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.extraction_method = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(11);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.extraction_method = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.extraction_method = tmpContent_tDBInput_1;
                }
            } else {
                row1.extraction_method = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.confidence_score = null;
							} else {
		                          
            row1.confidence_score = rs_tDBInput_1.getFloat(12);
            if(rs_tDBInput_1.wasNull()){
                    row1.confidence_score = null;
            }
		                    }
					





 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row2" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow2 = false;
       		  	    	
       		  	    	
 							row2Struct row2ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row2HashKey.num_facture = row1.num_facture ;
                        		    		

								
		                        	row2HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2' and it contains more one result from keys :  row2.num_facture = '" + row2HashKey.num_facture + "'");
								} // G 071
							

							row2Struct row2 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row2Struct fromLookup_row2 = null;
							row2 = row2Default;
										 
							
								 
							
							
								if (tHash_Lookup_row2 !=null && tHash_Lookup_row2.hasNext()) { // G 099
								
							
								
								fromLookup_row2 = tHash_Lookup_row2.next();

							
							
								} // G 099
							
							

							if(fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

out1 = null;

if(!rejectedInnerJoin_tMap_1 ) {

// # Output table : 'out1'
out1_tmp.fournisseur = row1.fournisseur ;
out1_tmp.matricule_fiscal = row1.matricule_fiscal ;
out1_tmp.telephones = row1.telephones ;
out1_tmp.num_facture = row1.num_facture ;
out1_tmp.date_facture = row1.date_facture ;
out1_tmp.montant_ht = row1.montant_ht ;
out1_tmp.tva = row1.tva ;
out1_tmp.timbre = row1.timbre ;
out1_tmp.montant_ttc = row1.montant_ttc ;
out1_tmp.reste_du = row1.reste_du ;
out1_tmp.reference = row2.reference ;
out1_tmp.description = row2.description ;
out1_tmp.quantite = row2.quantite ;
out1_tmp.montant_ligne = row2.montant_ligne ;
out1_tmp.prix_unitaire = row2.prix_unitaire ;
out1 = out1_tmp;
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "out1"
if(out1 != null) { 



	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out1"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row3" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow3 = false;
       		  	    	
       		  	    	
 							row3Struct row3ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
                        		    		    row3HashKey.matricule_fiscal = out1.matricule_fiscal ;
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row3.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_2 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.matricule_fiscal = '" + row3HashKey.matricule_fiscal + "'");
								} // G 071
							

							row3Struct row3 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row3Struct fromLookup_row3 = null;
							row3 = row3Default;
										 
							
								 
							
							
								if (tHash_Lookup_row3 !=null && tHash_Lookup_row3.hasNext()) { // G 099
								
							
								
								fromLookup_row3 = tHash_Lookup_row3.next();

							
							
								} // G 099
							
							

							if(fromLookup_row3 != null) {
								row3 = fromLookup_row3;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

fk_entreprise = null;

if(!rejectedInnerJoin_tMap_2 ) {

// # Output table : 'fk_entreprise'
fk_entreprise_tmp.id_fournisseur = row3.id_fournisseur ;
fk_entreprise_tmp.num_facture = out1.num_facture ;
fk_entreprise_tmp.date_facture = out1.date_facture ;
fk_entreprise_tmp.montant_ht = out1.montant_ht ;
fk_entreprise_tmp.tva = out1.tva ;
fk_entreprise_tmp.timbre = out1.timbre ;
fk_entreprise_tmp.montant_ttc = out1.montant_ttc ;
fk_entreprise_tmp.reste_du = out1.reste_du ;
fk_entreprise_tmp.reference = out1.reference ;
fk_entreprise_tmp.description = out1.description ;
fk_entreprise_tmp.quantite = out1.quantite ;
fk_entreprise_tmp.montant_ligne = out1.montant_ligne ;
fk_entreprise_tmp.prix_unitaire = out1.prix_unitaire ;
fk_entreprise = fk_entreprise_tmp;
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_2 = false;










 


	tos_count_tMap_2++;

/**
 * [tMap_2 main ] stop
 */
	
	/**
	 * [tMap_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_begin ] stop
 */
// Start of branch "fk_entreprise"
if(fk_entreprise != null) { 



	
	/**
	 * [tMap_3 main ] start
	 */

	

	
	
	currentComponent="tMap_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"fk_entreprise"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_3 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_3 = false;
		  boolean mainRowRejected_tMap_3 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row4" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow4 = false;
       		  	    	
       		  	    	
 							row4Struct row4ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_3) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_3 = false;
								
                        		    		    row4HashKey.Reference = fk_entreprise.reference ;
                        		    		

								
		                        	row4HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row4.lookup( row4HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row4.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_3 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4' and it contains more one result from keys :  row4.Reference = '" + row4HashKey.Reference + "'");
								} // G 071
							

							row4Struct row4 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row4Struct fromLookup_row4 = null;
							row4 = row4Default;
										 
							
								 
							
							
								if (tHash_Lookup_row4 !=null && tHash_Lookup_row4.hasNext()) { // G 099
								
							
								
								fromLookup_row4 = tHash_Lookup_row4.next();

							
							
								} // G 099
							
							

							if(fromLookup_row4 != null) {
								row4 = fromLookup_row4;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_3__Struct Var = Var__tMap_3;// ###############################
        // ###############################
        // # Output tables

fk_produit = null;

if(!rejectedInnerJoin_tMap_3 ) {

// # Output table : 'fk_produit'
// # Filter conditions 
if( 

fk_entreprise.date_facture != null 
&& !"Non trouvé".equals(fk_entreprise.date_facture)
&& fk_entreprise.date_facture.matches("\\d{2}/\\d{2}/\\d{4}")

 ) {
fk_produit_tmp.id_fournisseur = fk_entreprise.id_fournisseur ;
fk_produit_tmp.Id_Produit = row4.Id_Produit ;
fk_produit_tmp.num_facture = fk_entreprise.num_facture ;
fk_produit_tmp.date_facture = TalendDate.parseDate("dd/MM/yyyy", fk_entreprise.date_facture) ;
fk_produit_tmp.montant_ht = fk_entreprise.montant_ht ;
fk_produit_tmp.tva = fk_entreprise.tva ;
fk_produit_tmp.timbre = fk_entreprise.timbre ;
fk_produit_tmp.montant_ttc = fk_entreprise.montant_ttc ;
fk_produit_tmp.reste_du = fk_entreprise.reste_du ;
fk_produit_tmp.quantite = fk_entreprise.quantite ;
fk_produit_tmp.montant_ligne = fk_entreprise.montant_ligne ;
fk_produit = fk_produit_tmp;
} // closing filter/reject
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_3 = false;










 


	tos_count_tMap_3++;

/**
 * [tMap_3 main ] stop
 */
	
	/**
	 * [tMap_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_begin ] stop
 */
// Start of branch "fk_produit"
if(fk_produit != null) { 



	
	/**
	 * [tMap_4 main ] start
	 */

	

	
	
	currentComponent="tMap_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"fk_produit"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_4 = false;
		  boolean mainRowRejected_tMap_4 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row5" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow5 = false;
       		  	    	
       		  	    	
 							row5Struct row5ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_4) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_4 = false;
								
                        		    		    row5HashKey.Full_Date = fk_produit.date_facture  == null ? null : new java.util.Date(fk_produit.date_facture .getTime());
                        		    		

								
		                        	row5HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row5.lookup( row5HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row5.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_4 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row5 != null && tHash_Lookup_row5.getCount(row5HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row5' and it contains more one result from keys :  row5.Full_Date = '" + row5HashKey.Full_Date + "'");
								} // G 071
							

							row5Struct row5 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row5Struct fromLookup_row5 = null;
							row5 = row5Default;
										 
							
								 
							
							
								if (tHash_Lookup_row5 !=null && tHash_Lookup_row5.hasNext()) { // G 099
								
							
								
								fromLookup_row5 = tHash_Lookup_row5.next();

							
							
								} // G 099
							
							

							if(fromLookup_row5 != null) {
								row5 = fromLookup_row5;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
        // ###############################
        // # Output tables

fk_date = null;

if(!rejectedInnerJoin_tMap_4 ) {

// # Output table : 'fk_date'
fk_date_tmp.id_fournisseur = fk_produit.id_fournisseur ;
fk_date_tmp.Id_Produit = fk_produit.Id_Produit ;
fk_date_tmp.Date_Key = row5.Date_Key ;
fk_date_tmp.num_facture = fk_produit.num_facture ;
fk_date_tmp.montant_ht = fk_produit.montant_ht ;
fk_date_tmp.tva = fk_produit.tva ;
fk_date_tmp.timbre = fk_produit.timbre ;
fk_date_tmp.montant_ttc = fk_produit.montant_ttc ;
fk_date_tmp.reste_du = fk_produit.reste_du ;
fk_date_tmp.quantite = fk_produit.quantite ;
fk_date_tmp.montant_ligne = fk_produit.montant_ligne ;
fk_date = fk_date_tmp;
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_4 = false;










 


	tos_count_tMap_4++;

/**
 * [tMap_4 main ] stop
 */
	
	/**
	 * [tMap_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_begin ] stop
 */
// Start of branch "fk_date"
if(fk_date != null) { 



	
	/**
	 * [tMap_5 main ] start
	 */

	

	
	
	currentComponent="tMap_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"fk_date"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_5 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_5 = false;
		  boolean mainRowRejected_tMap_5 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row6" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow6 = false;
       		  	    	
       		  	    	
 							row6Struct row6ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_5) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_5 = false;
								
	                        		    	Object exprKeyValue_row6__id_fournisseur = fk_date.id_fournisseur ;
	                        		    	if(exprKeyValue_row6__id_fournisseur == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_5 = true;
	                        		    	} else {
                        		    			row6HashKey.id_fournisseur = (int)(Integer) exprKeyValue_row6__id_fournisseur;
                        		    		}
                        		    		
	                        		    	Object exprKeyValue_row6__id_produit = fk_date.Id_Produit ;
	                        		    	if(exprKeyValue_row6__id_produit == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_5 = true;
	                        		    	} else {
                        		    			row6HashKey.id_produit = (int)(Integer) exprKeyValue_row6__id_produit;
                        		    		}
                        		    		
	                        		    	Object exprKeyValue_row6__date_key = fk_date.Date_Key ;
	                        		    	if(exprKeyValue_row6__date_key == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_5 = true;
	                        		    	} else {
                        		    			row6HashKey.date_key = (int)(Integer) exprKeyValue_row6__date_key;
                        		    		}
                        		    		

								
		                        	row6HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_5) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row6.lookup( row6HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row6 != null && tHash_Lookup_row6.getCount(row6HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row6' and it contains more one result from keys :  row6.id_fournisseur = '" + row6HashKey.id_fournisseur + "', row6.id_produit = '" + row6HashKey.id_produit + "', row6.date_key = '" + row6HashKey.date_key + "'");
								} // G 071
							

							row6Struct row6 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row6Struct fromLookup_row6 = null;
							row6 = row6Default;
										 
							
								 
							
							
								if (tHash_Lookup_row6 !=null && tHash_Lookup_row6.hasNext()) { // G 099
								
							
								
								fromLookup_row6 = tHash_Lookup_row6.next();

							
							
								} // G 099
							
							

							if(fromLookup_row6 != null) {
								row6 = fromLookup_row6;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_5__Struct Var = Var__tMap_5;// ###############################
        // ###############################
        // # Output tables

ajout = null;


// # Output table : 'ajout'
// # Filter conditions 
if( 

row6.date_key ==0 && row6.id_fournisseur == 0 && row6.id_produit == 0

 ) {
ajout_tmp.id_fournisseur = fk_date.id_fournisseur ;
ajout_tmp.id_Produit = fk_date.Id_Produit ;
ajout_tmp.date_Key = fk_date.Date_Key ;
ajout_tmp.num_facture = fk_date.num_facture ;
ajout_tmp.montant_ht_facture = fk_date.montant_ht ;
ajout_tmp.tva = fk_date.tva ;
ajout_tmp.timbre = fk_date.timbre ;
ajout_tmp.montant_ttc_facture = fk_date.montant_ttc ;
ajout_tmp.reste_du = fk_date.reste_du ;
ajout_tmp.quantite = fk_date.quantite ;
ajout_tmp.montant_ligne = fk_date.montant_ligne ;
ajout = ajout_tmp;
} // closing filter/reject
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_5 = false;










 


	tos_count_tMap_5++;

/**
 * [tMap_5 main ] stop
 */
	
	/**
	 * [tMap_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 process_data_begin ] stop
 */
// Start of branch "ajout"
if(ajout != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"ajout"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    pstmt_tDBOutput_1.setInt(1, ajout.id_fournisseur);

                    pstmt_tDBOutput_1.setInt(2, ajout.id_Produit);

                    pstmt_tDBOutput_1.setInt(3, ajout.date_Key);

                    if(ajout.num_facture == null) {
pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(4, ajout.num_facture);
}

                    if(ajout.montant_ht_facture == null) {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(5, ajout.montant_ht_facture);
}

                    if(ajout.tva == null) {
pstmt_tDBOutput_1.setNull(6, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(6, ajout.tva);
}

                    if(ajout.timbre == null) {
pstmt_tDBOutput_1.setNull(7, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(7, ajout.timbre);
}

                    if(ajout.montant_ttc_facture == null) {
pstmt_tDBOutput_1.setNull(8, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(8, ajout.montant_ttc_facture);
}

                    if(ajout.reste_du == null) {
pstmt_tDBOutput_1.setNull(9, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(9, ajout.reste_du);
}

                    if(ajout.quantite == null) {
pstmt_tDBOutput_1.setNull(10, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(10, ajout.quantite);
}

                    if(ajout.montant_ligne == null) {
pstmt_tDBOutput_1.setNull(11, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(11, ajout.montant_ligne);
}


        		pstmt_tDBOutput_1.addBatch();
        		nb_line_tDBOutput_1++;
        		
    		 
    		  batchSizeCounter_tDBOutput_1++;
    		
            	//////////batch execute by batch size///////
            	class LimitBytesHelper_tDBOutput_1{
            		public int limitBytePart1(int counter,java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
                try {
						
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							if(countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
								break;
							}
							counter += countEach_tDBOutput_1;
						}
						
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                	
                	int countSum_tDBOutput_1 = 0;
					for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
						counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
				
            	    	
                		System.err.println(e.getMessage());
                	
               			 }
    				return counter;
            	}
            	
            	public int limitBytePart2(int counter,java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
                try {
                		
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							if(countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
								break;
							}
							counter += countEach_tDBOutput_1;
						}
						
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                	
                	
					for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
						counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					
            	    	
                        System.err.println(e.getMessage());
                	
                		}	
                	return counter;	
            	}
            }
    		if ((batchSize_tDBOutput_1 > 0) && (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
    		
    		            
            	    		insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1().limitBytePart1(insertedCount_tDBOutput_1,pstmt_tDBOutput_1);
            	    		rowsToCommitCount_tDBOutput_1 = insertedCount_tDBOutput_1;
            	    	
    			
			    batchSizeCounter_tDBOutput_1 = 0;
			}
    		

    	////////////commit every////////////
    			
    		    commitCounter_tDBOutput_1++;
                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
                if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {
    		            
            	    		insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1().limitBytePart1(insertedCount_tDBOutput_1,pstmt_tDBOutput_1);
            	    	
            	batchSizeCounter_tDBOutput_1 = 0;
            	}
                if(rowsToCommitCount_tDBOutput_1 != 0){
                	
                }
                conn_tDBOutput_1.commit();
                if(rowsToCommitCount_tDBOutput_1 != 0){
                	
                	rowsToCommitCount_tDBOutput_1 = 0;	
                }
                commitCounter_tDBOutput_1=0;
                }

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "ajout"




	
	/**
	 * [tMap_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 process_data_end ] stop
 */

} // End of branch "fk_date"




	
	/**
	 * [tMap_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_end ] stop
 */

} // End of branch "fk_produit"




	
	/**
	 * [tMap_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_end ] stop
 */

} // End of branch "fk_entreprise"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */

} // End of branch "out1"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
		if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);

 

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row3 != null) {
						tHash_Lookup_row3.endGet();
					}
					globalMap.remove( "tHash_Lookup_row3" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out1");
			  	}
			  	
 

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */

	
	/**
	 * [tMap_3 end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row4 != null) {
						tHash_Lookup_row4.endGet();
					}
					globalMap.remove( "tHash_Lookup_row4" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"fk_entreprise");
			  	}
			  	
 

ok_Hash.put("tMap_3", true);
end_Hash.put("tMap_3", System.currentTimeMillis());




/**
 * [tMap_3 end ] stop
 */

	
	/**
	 * [tMap_4 end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row5 != null) {
						tHash_Lookup_row5.endGet();
					}
					globalMap.remove( "tHash_Lookup_row5" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"fk_produit");
			  	}
			  	
 

ok_Hash.put("tMap_4", true);
end_Hash.put("tMap_4", System.currentTimeMillis());




/**
 * [tMap_4 end ] stop
 */

	
	/**
	 * [tMap_5 end ] start
	 */

	

	
	
	currentComponent="tMap_5";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row6 != null) {
						tHash_Lookup_row6.endGet();
					}
					globalMap.remove( "tHash_Lookup_row6" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"fk_date");
			  	}
			  	
 

ok_Hash.put("tMap_5", true);
end_Hash.put("tMap_5", System.currentTimeMillis());




/**
 * [tMap_5 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



                try {
						int countSum_tDBOutput_1 = 0;
						if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {
							
							for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
								if(countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
									break;
								}
								countSum_tDBOutput_1 += countEach_tDBOutput_1;
							}
							rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
							
						}
            	    	
            	    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
            	    	
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                	
                	int countSum_tDBOutput_1 = 0;
					for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
					
            	    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
            	    	
                		System.err.println(e.getMessage());
                	
            	}
        if(pstmt_tDBOutput_1 != null) {
			
				pstmt_tDBOutput_1.close();
				resourceMap.remove("pstmt_tDBOutput_1");
			
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);
            if(rowsToCommitCount_tDBOutput_1 != 0){
            	
            }
            conn_tDBOutput_1.commit();
            if(rowsToCommitCount_tDBOutput_1 != 0){
            	
            	rowsToCommitCount_tDBOutput_1 = 0;
            }
            commitCounter_tDBOutput_1 = 0;
        conn_tDBOutput_1 .close();
        resourceMap.put("finish_tDBOutput_1", true);

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"ajout");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */


















				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_5"
					     			globalMap.remove("tHash_Lookup_row6"); 
				     			
					     			//free memory for "tMap_4"
					     			globalMap.remove("tHash_Lookup_row5"); 
				     			
					     			//free memory for "tMap_3"
					     			globalMap.remove("tHash_Lookup_row4"); 
				     			
					     			//free memory for "tMap_2"
					     			globalMap.remove("tHash_Lookup_row3"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 finally ] stop
 */

	
	/**
	 * [tMap_3 finally ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 finally ] stop
 */

	
	/**
	 * [tMap_4 finally ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 finally ] stop
 */

	
	/**
	 * [tMap_5 finally ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                    ctn_tDBOutput_1.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
        }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */


















				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_Achat = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_Achat = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String fournisseur;

				public String getFournisseur () {
					return this.fournisseur;
				}
				
			    public String num_facture;

				public String getNum_facture () {
					return this.num_facture;
				}
				
			    public String date_facture;

				public String getDate_facture () {
					return this.date_facture;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public Float prix_unitaire;

				public Float getPrix_unitaire () {
					return this.prix_unitaire;
				}
				
			    public Float montant_ligne;

				public Float getMontant_ligne () {
					return this.montant_ligne;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.num_facture == null) ? 0 : this.num_facture.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row2Struct other = (row2Struct) obj;
		
						if (this.num_facture == null) {
							if (other.num_facture != null)
								return false;
						
						} else if (!this.num_facture.equals(other.num_facture))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.fournisseur = this.fournisseur;
	            other.num_facture = this.num_facture;
	            other.date_facture = this.date_facture;
	            other.reference = this.reference;
	            other.description = this.description;
	            other.quantite = this.quantite;
	            other.prix_unitaire = this.prix_unitaire;
	            other.montant_ligne = this.montant_ligne;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.num_facture = this.num_facture;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.num_facture = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.num_facture = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.num_facture,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.num_facture,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.fournisseur = readString(dis,ois);
					
						this.date_facture = readString(dis,ois);
					
						this.reference = readString(dis,ois);
					
						this.description = readString(dis,ois);
					
						this.quantite = readInteger(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.prix_unitaire = null;
           				} else {
           			    	this.prix_unitaire = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ligne = null;
           				} else {
           			    	this.montant_ligne = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.fournisseur = readString(dis,objectIn);
					
						this.date_facture = readString(dis,objectIn);
					
						this.reference = readString(dis,objectIn);
					
						this.description = readString(dis,objectIn);
					
						this.quantite = readInteger(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.prix_unitaire = null;
           				} else {
           			    	this.prix_unitaire = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.montant_ligne = null;
           				} else {
           			    	this.montant_ligne = objectIn.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.fournisseur, dos, oos);
					
						writeString(this.date_facture, dos, oos);
					
						writeString(this.reference, dos, oos);
					
						writeString(this.description, dos, oos);
					
					writeInteger(this.quantite, dos, oos);
					
						if(this.prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.prix_unitaire);
		            	}
					
						if(this.montant_ligne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ligne);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.fournisseur, dos, objectOut);
					
						writeString(this.date_facture, dos, objectOut);
					
						writeString(this.reference, dos, objectOut);
					
						writeString(this.description, dos, objectOut);
					
					writeInteger(this.quantite, dos, objectOut);
					
						if(this.prix_unitaire == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.prix_unitaire);
		            	}
					
						if(this.montant_ligne == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.montant_ligne);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("fournisseur="+fournisseur);
		sb.append(",num_facture="+num_facture);
		sb.append(",date_facture="+date_facture);
		sb.append(",reference="+reference);
		sb.append(",description="+description);
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",prix_unitaire="+String.valueOf(prix_unitaire));
		sb.append(",montant_ligne="+String.valueOf(montant_ligne));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.num_facture, other.num_facture);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tAdvancedHash_row2 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row2", false);
		start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tAdvancedHash_row2 = 0;
		

			   		// connection name:row2
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row2 begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";

	
		int tos_count_tDBInput_2 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_2 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_2 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_2  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_2, talendToDBArray_tDBInput_2); 
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "sa";
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:5w8NYaR0zekYP/7KzSzwAHatEfNtaTVfyKo5LQkx5OHRf9Ug");
				
				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;
				
		    String port_tDBInput_2 = "1433";
		    String dbname_tDBInput_2 = "Sougui_SA" ;		    
		    String url_tDBInput_2 = "jdbc:sqlserver://" + "DESKTOP-LBCVIS5" ;
		    if (!"".equals(port_tDBInput_2)) {
		    	url_tDBInput_2 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_2)) {		    
		    	url_tDBInput_2 += ";databaseName=" + "Sougui_SA"; 
		    }
		    url_tDBInput_2 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
		    String dbschema_tDBInput_2 = "dbo";
				
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2,dbUser_tDBInput_2,dbPwd_tDBInput_2);
		        
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT dbo.Ligne_achat_SA.fournisseur,\n		dbo.Ligne_achat_SA.num_facture,\n		dbo.Ligne_achat_SA.date_facture,\n		dbo.Ligne"
+"_achat_SA.reference,\n		dbo.Ligne_achat_SA.description,\n		dbo.Ligne_achat_SA.quantite,\n		dbo.Ligne_achat_SA.prix_unitaire"
+",\n		dbo.Ligne_achat_SA.montant_ligne\nFROM	dbo.Ligne_achat_SA";
		    

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row2.fournisseur = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(1);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.fournisseur = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.fournisseur = tmpContent_tDBInput_2;
                }
            } else {
                row2.fournisseur = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row2.num_facture = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(2);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.num_facture = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.num_facture = tmpContent_tDBInput_2;
                }
            } else {
                row2.num_facture = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row2.date_facture = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(3);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.date_facture = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.date_facture = tmpContent_tDBInput_2;
                }
            } else {
                row2.date_facture = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row2.reference = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(4);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.reference = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.reference = tmpContent_tDBInput_2;
                }
            } else {
                row2.reference = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row2.description = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.description = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.description = tmpContent_tDBInput_2;
                }
            } else {
                row2.description = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row2.quantite = null;
							} else {
		                          
            row2.quantite = rs_tDBInput_2.getInt(6);
            if(rs_tDBInput_2.wasNull()){
                    row2.quantite = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row2.prix_unitaire = null;
							} else {
		                          
            row2.prix_unitaire = rs_tDBInput_2.getFloat(7);
            if(rs_tDBInput_2.wasNull()){
                    row2.prix_unitaire = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row2.montant_ligne = null;
							} else {
		                          
            row2.montant_ligne = rs_tDBInput_2.getFloat(8);
            if(rs_tDBInput_2.wasNull()){
                    row2.montant_ligne = null;
            }
		                    }
					





 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.fournisseur = row2.fournisseur;
				
				row2_HashRow.num_facture = row2.num_facture;
				
				row2_HashRow.date_facture = row2.date_facture;
				
				row2_HashRow.reference = row2.reference;
				
				row2_HashRow.description = row2.description;
				
				row2_HashRow.quantite = row2.quantite;
				
				row2_HashRow.prix_unitaire = row2.prix_unitaire;
				
				row2_HashRow.montant_ligne = row2.montant_ligne;
				
			tHash_Lookup_row2.put(row2_HashRow);
			
            




 


	tos_count_tAdvancedHash_row2++;

/**
 * [tAdvancedHash_row2 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
		if(conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {
			
			conn_tDBInput_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);

 

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

tHash_Lookup_row2.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row2", true);
end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());




/**
 * [tAdvancedHash_row2 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	


public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_Achat = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_Achat = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_fournisseur;

				public int getId_fournisseur () {
					return this.id_fournisseur;
				}
				
			    public String matricule_fiscal;

				public String getMatricule_fiscal () {
					return this.matricule_fiscal;
				}
				
			    public String nom_fournisseur;

				public String getNom_fournisseur () {
					return this.nom_fournisseur;
				}
				
			    public String telephone;

				public String getTelephone () {
					return this.telephone;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.matricule_fiscal == null) ? 0 : this.matricule_fiscal.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row3Struct other = (row3Struct) obj;
		
						if (this.matricule_fiscal == null) {
							if (other.matricule_fiscal != null)
								return false;
						
						} else if (!this.matricule_fiscal.equals(other.matricule_fiscal))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.id_fournisseur = this.id_fournisseur;
	            other.matricule_fiscal = this.matricule_fiscal;
	            other.nom_fournisseur = this.nom_fournisseur;
	            other.telephone = this.telephone;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.matricule_fiscal = this.matricule_fiscal;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.matricule_fiscal = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.matricule_fiscal = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.matricule_fiscal,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.matricule_fiscal,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.id_fournisseur = dis.readInt();
					
						this.nom_fournisseur = readString(dis,ois);
					
						this.telephone = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.id_fournisseur = objectIn.readInt();
					
						this.nom_fournisseur = readString(dis,objectIn);
					
						this.telephone = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.id_fournisseur);
					
						writeString(this.nom_fournisseur, dos, oos);
					
						writeString(this.telephone, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.id_fournisseur);
					
						writeString(this.nom_fournisseur, dos, objectOut);
					
						writeString(this.telephone, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_fournisseur="+String.valueOf(id_fournisseur));
		sb.append(",matricule_fiscal="+matricule_fiscal);
		sb.append(",nom_fournisseur="+nom_fournisseur);
		sb.append(",telephone="+telephone);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.matricule_fiscal, other.matricule_fiscal);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row3Struct row3 = new row3Struct();




	
	/**
	 * [tAdvancedHash_row3 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row3", false);
		start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tAdvancedHash_row3 = 0;
		

			   		// connection name:row3
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_2 - inputs:(out1,row3) outputs:(fk_entreprise)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
 */



	
	/**
	 * [tDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_3", false);
		start_Hash.put("tDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_3";

	
		int tos_count_tDBInput_3 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_3 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_3 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_3  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_3, talendToDBArray_tDBInput_3); 
		    int nb_line_tDBInput_3 = 0;
		    java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = "sa";
				
				 
	final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:RL3Lgt8Td90lZqIjoAsdfb0I5UYhFRqsSZvNPKIoAFrfFl3x");
				
				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;
				
		    String port_tDBInput_3 = "1433";
		    String dbname_tDBInput_3 = "Sougui_DWH" ;		    
		    String url_tDBInput_3 = "jdbc:sqlserver://" + "DESKTOP-LBCVIS5" ;
		    if (!"".equals(port_tDBInput_3)) {
		    	url_tDBInput_3 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_3)) {		    
		    	url_tDBInput_3 += ";databaseName=" + "Sougui_DWH"; 
		    }
		    url_tDBInput_3 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
		    String dbschema_tDBInput_3 = "dbo";
				
				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3,dbUser_tDBInput_3,dbPwd_tDBInput_3);
		        
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "SELECT dbo.Dim_fournisseur.id_fournisseur,\n		dbo.Dim_fournisseur.matricule_fiscal,\n		dbo.Dim_fournisseur.nom_fournisseu"
+"r,\n		dbo.Dim_fournisseur.telephone\nFROM	dbo.Dim_fournisseur";
		    

            	globalMap.put("tDBInput_3_QUERY",dbquery_tDBInput_3);
		    java.sql.ResultSet rs_tDBInput_3 = null;

		    try {
		    	rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
		    	int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

		    String tmpContent_tDBInput_3 = null;
		    
		    
		    while (rs_tDBInput_3.next()) {
		        nb_line_tDBInput_3++;
		        
							if(colQtyInRs_tDBInput_3 < 1) {
								row3.id_fournisseur = 0;
							} else {
		                          
            row3.id_fournisseur = rs_tDBInput_3.getInt(1);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row3.matricule_fiscal = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(2);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.matricule_fiscal = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.matricule_fiscal = tmpContent_tDBInput_3;
                }
            } else {
                row3.matricule_fiscal = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								row3.nom_fournisseur = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(3);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.nom_fournisseur = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.nom_fournisseur = tmpContent_tDBInput_3;
                }
            } else {
                row3.nom_fournisseur = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								row3.telephone = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(4);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.telephone = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.telephone = tmpContent_tDBInput_3;
                }
            } else {
                row3.telephone = null;
            }
		                    }
					





 



/**
 * [tDBInput_3 begin ] stop
 */
	
	/**
	 * [tDBInput_3 main ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 


	tos_count_tDBInput_3++;

/**
 * [tDBInput_3 main ] stop
 */
	
	/**
	 * [tDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					


			   
			   

					row3Struct row3_HashRow = new row3Struct();
		   	   	   
				
				row3_HashRow.id_fournisseur = row3.id_fournisseur;
				
				row3_HashRow.matricule_fiscal = row3.matricule_fiscal;
				
				row3_HashRow.nom_fournisseur = row3.nom_fournisseur;
				
				row3_HashRow.telephone = row3.telephone;
				
			tHash_Lookup_row3.put(row3_HashRow);
			
            




 


	tos_count_tAdvancedHash_row3++;

/**
 * [tAdvancedHash_row3 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

	}
}finally{
	if (rs_tDBInput_3 != null) {
		rs_tDBInput_3.close();
	}
	if (stmt_tDBInput_3 != null) {
		stmt_tDBInput_3.close();
	}
		if(conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {
			
			conn_tDBInput_3.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_3_NB_LINE",nb_line_tDBInput_3);

 

ok_Hash.put("tDBInput_3", true);
end_Hash.put("tDBInput_3", System.currentTimeMillis());




/**
 * [tDBInput_3 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

tHash_Lookup_row3.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row3", true);
end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());




/**
 * [tAdvancedHash_row3 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_Achat = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_Achat = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int Id_Produit;

				public int getId_Produit () {
					return this.Id_Produit;
				}
				
			    public String Reference;

				public String getReference () {
					return this.Reference;
				}
				
			    public String Description;

				public String getDescription () {
					return this.Description;
				}
				
			    public Float PU_HT;

				public Float getPU_HT () {
					return this.PU_HT;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.Reference == null) ? 0 : this.Reference.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row4Struct other = (row4Struct) obj;
		
						if (this.Reference == null) {
							if (other.Reference != null)
								return false;
						
						} else if (!this.Reference.equals(other.Reference))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

		other.Id_Produit = this.Id_Produit;
	            other.Reference = this.Reference;
	            other.Description = this.Description;
	            other.PU_HT = this.PU_HT;
	            
	}

	public void copyKeysDataTo(row4Struct other) {

		other.Reference = this.Reference;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_Achat.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_Achat.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_Achat = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_Achat, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_Achat, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.Reference = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.Reference = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Reference,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Reference,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.Id_Produit = dis.readInt();
					
						this.Description = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.Id_Produit = objectIn.readInt();
					
						this.Description = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = objectIn.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.Id_Produit);
					
						writeString(this.Description, dos, oos);
					
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.Id_Produit);
					
						writeString(this.Description, dos, objectOut);
					
						if(this.PU_HT == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.PU_HT);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Id_Produit="+String.valueOf(Id_Produit));
		sb.append(",Reference="+Reference);
		sb.append(",Description="+Description);
		sb.append(",PU_HT="+String.valueOf(PU_HT));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Reference, other.Reference);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row4Struct row4 = new row4Struct();




	
	/**
	 * [tAdvancedHash_row4 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row4", false);
		start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tAdvancedHash_row4 = 0;
		

			   		// connection name:row4
			   		// source node:tDBInput_4 - inputs:(after_tDBInput_1) outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
			   		// linked node: tMap_3 - inputs:(fk_entreprise,row4) outputs:(fk_produit)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row4Struct>getLookup(matchingModeEnum_row4);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row4 begin ] stop
 */



	
	/**
	 * [tDBInput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_4", false);
		start_Hash.put("tDBInput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_4";

	
		int tos_count_tDBInput_4 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_4 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_4 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_4  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_4, talendToDBArray_tDBInput_4); 
		    int nb_line_tDBInput_4 = 0;
		    java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = "sa";
				
				 
	final String decryptedPassword_tDBInput_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:J8TySXPEv7ZyPifyhgMdQELHmHIqYJLBuHCSrsvEuB6Yj3r7");
				
				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;
				
		    String port_tDBInput_4 = "1433";
		    String dbname_tDBInput_4 = "Sougui_DWH" ;		    
		    String url_tDBInput_4 = "jdbc:sqlserver://" + "DESKTOP-LBCVIS5" ;
		    if (!"".equals(port_tDBInput_4)) {
		    	url_tDBInput_4 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_4)) {		    
		    	url_tDBInput_4 += ";databaseName=" + "Sougui_DWH"; 
		    }
		    url_tDBInput_4 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
		    String dbschema_tDBInput_4 = "dbo";
				
				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4,dbUser_tDBInput_4,dbPwd_tDBInput_4);
		        
		    
			java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

		    String dbquery_tDBInput_4 = "SELECT dbo.Dim_Produit_Sougui.Id_Produit,\n		dbo.Dim_Produit_Sougui.Reference,\n		dbo.Dim_Produit_Sougui.Description,\n		d"
+"bo.Dim_Produit_Sougui.PU_HT\nFROM	dbo.Dim_Produit_Sougui";
		    

            	globalMap.put("tDBInput_4_QUERY",dbquery_tDBInput_4);
		    java.sql.ResultSet rs_tDBInput_4 = null;

		    try {
		    	rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
		    	int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

		    String tmpContent_tDBInput_4 = null;
		    
		    
		    while (rs_tDBInput_4.next()) {
		        nb_line_tDBInput_4++;
		        
							if(colQtyInRs_tDBInput_4 < 1) {
								row4.Id_Produit = 0;
							} else {
		                          
            row4.Id_Produit = rs_tDBInput_4.getInt(1);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								row4.Reference = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(2);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.Reference = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row4.Reference = tmpContent_tDBInput_4;
                }
            } else {
                row4.Reference = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								row4.Description = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(3);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.Description = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row4.Description = tmpContent_tDBInput_4;
                }
            } else {
                row4.Description = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								row4.PU_HT = null;
							} else {
		                          
            row4.PU_HT = rs_tDBInput_4.getFloat(4);
            if(rs_tDBInput_4.wasNull()){
                    row4.PU_HT = null;
            }
		                    }
					





 



/**
 * [tDBInput_4 begin ] stop
 */
	
	/**
	 * [tDBInput_4 main ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 


	tos_count_tDBInput_4++;

/**
 * [tDBInput_4 main ] stop
 */
	
	/**
	 * [tDBInput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					


			   
			   

					row4Struct row4_HashRow = new row4Struct();
		   	   	   
				
				row4_HashRow.Id_Produit = row4.Id_Produit;
				
				row4_HashRow.Reference = row4.Reference;
				
				row4_HashRow.Description = row4.Description;
				
				row4_HashRow.PU_HT = row4.PU_HT;
				
			tHash_Lookup_row4.put(row4_HashRow);
			
            




 


	tos_count_tAdvancedHash_row4++;

/**
 * [tAdvancedHash_row4 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_4 end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

	}
}finally{
	if (rs_tDBInput_4 != null) {
		rs_tDBInput_4.close();
	}
	if (stmt_tDBInput_4 != null) {
		stmt_tDBInput_4.close();
	}
		if(conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {
			
			conn_tDBInput_4.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_4_NB_LINE",nb_line_tDBInput_4);

 

ok_Hash.put("tDBInput_4", true);
end_Hash.put("tDBInput_4", System.currentTimeMillis());




/**
 * [tDBInput_4 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

tHash_Lookup_row4.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row4", true);
end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());




/**
 * [tAdvancedHash_row4 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public static class row5Struct implements routines.system.IPersistableComparableLookupRow<row5Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_Achat = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_Achat = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int Date_Key;

				public int getDate_Key () {
					return this.Date_Key;
				}
				
			    public java.util.Date Full_Date;

				public java.util.Date getFull_Date () {
					return this.Full_Date;
				}
				
			    public Integer Jour;

				public Integer getJour () {
					return this.Jour;
				}
				
			    public String Nom_Jour;

				public String getNom_Jour () {
					return this.Nom_Jour;
				}
				
			    public Integer Jour_Semaine;

				public Integer getJour_Semaine () {
					return this.Jour_Semaine;
				}
				
			    public Integer Semaine_Annee;

				public Integer getSemaine_Annee () {
					return this.Semaine_Annee;
				}
				
			    public Integer Mois;

				public Integer getMois () {
					return this.Mois;
				}
				
			    public String Nom_Mois;

				public String getNom_Mois () {
					return this.Nom_Mois;
				}
				
			    public Integer Trimestre;

				public Integer getTrimestre () {
					return this.Trimestre;
				}
				
			    public Integer Annee;

				public Integer getAnnee () {
					return this.Annee;
				}
				
			    public Boolean Est_Weekend;

				public Boolean getEst_Weekend () {
					return this.Est_Weekend;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.Full_Date == null) ? 0 : this.Full_Date.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row5Struct other = (row5Struct) obj;
		
						if (this.Full_Date == null) {
							if (other.Full_Date != null)
								return false;
						
						} else if (!this.Full_Date.equals(other.Full_Date))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row5Struct other) {

		other.Date_Key = this.Date_Key;
	            other.Full_Date = this.Full_Date;
	            other.Jour = this.Jour;
	            other.Nom_Jour = this.Nom_Jour;
	            other.Jour_Semaine = this.Jour_Semaine;
	            other.Semaine_Annee = this.Semaine_Annee;
	            other.Mois = this.Mois;
	            other.Nom_Mois = this.Nom_Mois;
	            other.Trimestre = this.Trimestre;
	            other.Annee = this.Annee;
	            other.Est_Weekend = this.Est_Weekend;
	            
	}

	public void copyKeysDataTo(row5Struct other) {

		other.Full_Date = this.Full_Date;
	            	
	}




	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }
	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.Full_Date = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
					this.Full_Date = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.Full_Date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.Full_Date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.Date_Key = dis.readInt();
					
						this.Jour = readInteger(dis,ois);
					
						this.Nom_Jour = readString(dis,ois);
					
						this.Jour_Semaine = readInteger(dis,ois);
					
						this.Semaine_Annee = readInteger(dis,ois);
					
						this.Mois = readInteger(dis,ois);
					
						this.Nom_Mois = readString(dis,ois);
					
						this.Trimestre = readInteger(dis,ois);
					
						this.Annee = readInteger(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Est_Weekend = null;
           				} else {
           			    	this.Est_Weekend = dis.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.Date_Key = objectIn.readInt();
					
						this.Jour = readInteger(dis,objectIn);
					
						this.Nom_Jour = readString(dis,objectIn);
					
						this.Jour_Semaine = readInteger(dis,objectIn);
					
						this.Semaine_Annee = readInteger(dis,objectIn);
					
						this.Mois = readInteger(dis,objectIn);
					
						this.Nom_Mois = readString(dis,objectIn);
					
						this.Trimestre = readInteger(dis,objectIn);
					
						this.Annee = readInteger(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Est_Weekend = null;
           				} else {
           			    	this.Est_Weekend = objectIn.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.Date_Key);
					
					writeInteger(this.Jour, dos, oos);
					
						writeString(this.Nom_Jour, dos, oos);
					
					writeInteger(this.Jour_Semaine, dos, oos);
					
					writeInteger(this.Semaine_Annee, dos, oos);
					
					writeInteger(this.Mois, dos, oos);
					
						writeString(this.Nom_Mois, dos, oos);
					
					writeInteger(this.Trimestre, dos, oos);
					
					writeInteger(this.Annee, dos, oos);
					
						if(this.Est_Weekend == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.Est_Weekend);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.Date_Key);
					
					writeInteger(this.Jour, dos, objectOut);
					
						writeString(this.Nom_Jour, dos, objectOut);
					
					writeInteger(this.Jour_Semaine, dos, objectOut);
					
					writeInteger(this.Semaine_Annee, dos, objectOut);
					
					writeInteger(this.Mois, dos, objectOut);
					
						writeString(this.Nom_Mois, dos, objectOut);
					
					writeInteger(this.Trimestre, dos, objectOut);
					
					writeInteger(this.Annee, dos, objectOut);
					
						if(this.Est_Weekend == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeBoolean(this.Est_Weekend);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Date_Key="+String.valueOf(Date_Key));
		sb.append(",Full_Date="+String.valueOf(Full_Date));
		sb.append(",Jour="+String.valueOf(Jour));
		sb.append(",Nom_Jour="+Nom_Jour);
		sb.append(",Jour_Semaine="+String.valueOf(Jour_Semaine));
		sb.append(",Semaine_Annee="+String.valueOf(Semaine_Annee));
		sb.append(",Mois="+String.valueOf(Mois));
		sb.append(",Nom_Mois="+Nom_Mois);
		sb.append(",Trimestre="+String.valueOf(Trimestre));
		sb.append(",Annee="+String.valueOf(Annee));
		sb.append(",Est_Weekend="+String.valueOf(Est_Weekend));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row5Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Full_Date, other.Full_Date);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_5_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row5Struct row5 = new row5Struct();




	
	/**
	 * [tAdvancedHash_row5 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row5", false);
		start_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row5");
					}
				
		int tos_count_tAdvancedHash_row5 = 0;
		

			   		// connection name:row5
			   		// source node:tDBInput_5 - inputs:(after_tDBInput_1) outputs:(row5,row5) | target node:tAdvancedHash_row5 - inputs:(row5) outputs:()
			   		// linked node: tMap_4 - inputs:(fk_produit,row5) outputs:(fk_date)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row5 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row5Struct>getLookup(matchingModeEnum_row5);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row5", tHash_Lookup_row5);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row5 begin ] stop
 */



	
	/**
	 * [tDBInput_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_5", false);
		start_Hash.put("tDBInput_5", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_5";

	
		int tos_count_tDBInput_5 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_5 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_5 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_5  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_5, talendToDBArray_tDBInput_5); 
		    int nb_line_tDBInput_5 = 0;
		    java.sql.Connection conn_tDBInput_5 = null;
				String driverClass_tDBInput_5 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    java.lang.Class jdbcclazz_tDBInput_5 = java.lang.Class.forName(driverClass_tDBInput_5);
				String dbUser_tDBInput_5 = "sa";
				
				 
	final String decryptedPassword_tDBInput_5 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:o1P6SKKDYc5b7pLdjzhB1WHZwwuhdu3vRT7w2OwVZimo5Ee4");
				
				String dbPwd_tDBInput_5 = decryptedPassword_tDBInput_5;
				
		    String port_tDBInput_5 = "1433";
		    String dbname_tDBInput_5 = "Sougui_DWH" ;		    
		    String url_tDBInput_5 = "jdbc:sqlserver://" + "DESKTOP-LBCVIS5" ;
		    if (!"".equals(port_tDBInput_5)) {
		    	url_tDBInput_5 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_5)) {		    
		    	url_tDBInput_5 += ";databaseName=" + "Sougui_DWH"; 
		    }
		    url_tDBInput_5 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
		    String dbschema_tDBInput_5 = "dbo";
				
				conn_tDBInput_5 = java.sql.DriverManager.getConnection(url_tDBInput_5,dbUser_tDBInput_5,dbPwd_tDBInput_5);
		        
		    
			java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

		    String dbquery_tDBInput_5 = "SELECT dbo.Dim_Date.Date_Key,\n		dbo.Dim_Date.Full_Date,\n		dbo.Dim_Date.Jour,\n		dbo.Dim_Date.Nom_Jour,\n		dbo.Dim_Date.Jo"
+"ur_Semaine,\n		dbo.Dim_Date.Semaine_Annee,\n		dbo.Dim_Date.Mois,\n		dbo.Dim_Date.Nom_Mois,\n		dbo.Dim_Date.Trimestre,\n		dbo."
+"Dim_Date.Annee,\n		dbo.Dim_Date.Est_Weekend\nFROM	dbo.Dim_Date";
		    

            	globalMap.put("tDBInput_5_QUERY",dbquery_tDBInput_5);
		    java.sql.ResultSet rs_tDBInput_5 = null;

		    try {
		    	rs_tDBInput_5 = stmt_tDBInput_5.executeQuery(dbquery_tDBInput_5);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_5 = rs_tDBInput_5.getMetaData();
		    	int colQtyInRs_tDBInput_5 = rsmd_tDBInput_5.getColumnCount();

		    String tmpContent_tDBInput_5 = null;
		    
		    
		    while (rs_tDBInput_5.next()) {
		        nb_line_tDBInput_5++;
		        
							if(colQtyInRs_tDBInput_5 < 1) {
								row5.Date_Key = 0;
							} else {
		                          
            row5.Date_Key = rs_tDBInput_5.getInt(1);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 2) {
								row5.Full_Date = null;
							} else {
										
			row5.Full_Date = mssqlGTU_tDBInput_5.getDate(rsmd_tDBInput_5, rs_tDBInput_5, 2);
			
		                    }
							if(colQtyInRs_tDBInput_5 < 3) {
								row5.Jour = null;
							} else {
		                          
            row5.Jour = rs_tDBInput_5.getInt(3);
            if(rs_tDBInput_5.wasNull()){
                    row5.Jour = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 4) {
								row5.Nom_Jour = null;
							} else {
	                         		
           		tmpContent_tDBInput_5 = rs_tDBInput_5.getString(4);
            if(tmpContent_tDBInput_5 != null) {
            	if (talendToDBList_tDBInput_5 .contains(rsmd_tDBInput_5.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.Nom_Jour = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
            	} else {
                	row5.Nom_Jour = tmpContent_tDBInput_5;
                }
            } else {
                row5.Nom_Jour = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 5) {
								row5.Jour_Semaine = null;
							} else {
		                          
            row5.Jour_Semaine = rs_tDBInput_5.getInt(5);
            if(rs_tDBInput_5.wasNull()){
                    row5.Jour_Semaine = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 6) {
								row5.Semaine_Annee = null;
							} else {
		                          
            row5.Semaine_Annee = rs_tDBInput_5.getInt(6);
            if(rs_tDBInput_5.wasNull()){
                    row5.Semaine_Annee = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 7) {
								row5.Mois = null;
							} else {
		                          
            row5.Mois = rs_tDBInput_5.getInt(7);
            if(rs_tDBInput_5.wasNull()){
                    row5.Mois = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 8) {
								row5.Nom_Mois = null;
							} else {
	                         		
           		tmpContent_tDBInput_5 = rs_tDBInput_5.getString(8);
            if(tmpContent_tDBInput_5 != null) {
            	if (talendToDBList_tDBInput_5 .contains(rsmd_tDBInput_5.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.Nom_Mois = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
            	} else {
                	row5.Nom_Mois = tmpContent_tDBInput_5;
                }
            } else {
                row5.Nom_Mois = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 9) {
								row5.Trimestre = null;
							} else {
		                          
            row5.Trimestre = rs_tDBInput_5.getInt(9);
            if(rs_tDBInput_5.wasNull()){
                    row5.Trimestre = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 10) {
								row5.Annee = null;
							} else {
		                          
            row5.Annee = rs_tDBInput_5.getInt(10);
            if(rs_tDBInput_5.wasNull()){
                    row5.Annee = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 11) {
								row5.Est_Weekend = null;
							} else {
	                         		
            row5.Est_Weekend = rs_tDBInput_5.getBoolean(11);
            if(rs_tDBInput_5.wasNull()){
                    row5.Est_Weekend = null;
            }
		                    }
					





 



/**
 * [tDBInput_5 begin ] stop
 */
	
	/**
	 * [tDBInput_5 main ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 


	tos_count_tDBInput_5++;

/**
 * [tDBInput_5 main ] stop
 */
	
	/**
	 * [tDBInput_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row5 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					


			   
			   

					row5Struct row5_HashRow = new row5Struct();
		   	   	   
				
				row5_HashRow.Date_Key = row5.Date_Key;
				
				row5_HashRow.Full_Date = row5.Full_Date;
				
				row5_HashRow.Jour = row5.Jour;
				
				row5_HashRow.Nom_Jour = row5.Nom_Jour;
				
				row5_HashRow.Jour_Semaine = row5.Jour_Semaine;
				
				row5_HashRow.Semaine_Annee = row5.Semaine_Annee;
				
				row5_HashRow.Mois = row5.Mois;
				
				row5_HashRow.Nom_Mois = row5.Nom_Mois;
				
				row5_HashRow.Trimestre = row5.Trimestre;
				
				row5_HashRow.Annee = row5.Annee;
				
				row5_HashRow.Est_Weekend = row5.Est_Weekend;
				
			tHash_Lookup_row5.put(row5_HashRow);
			
            




 


	tos_count_tAdvancedHash_row5++;

/**
 * [tAdvancedHash_row5 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	

 



/**
 * [tAdvancedHash_row5 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row5 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	

 



/**
 * [tAdvancedHash_row5 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_5 end ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

	}
}finally{
	if (rs_tDBInput_5 != null) {
		rs_tDBInput_5.close();
	}
	if (stmt_tDBInput_5 != null) {
		stmt_tDBInput_5.close();
	}
		if(conn_tDBInput_5 != null && !conn_tDBInput_5.isClosed()) {
			
			conn_tDBInput_5.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_5_NB_LINE",nb_line_tDBInput_5);

 

ok_Hash.put("tDBInput_5", true);
end_Hash.put("tDBInput_5", System.currentTimeMillis());




/**
 * [tDBInput_5 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row5 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	

tHash_Lookup_row5.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row5");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row5", true);
end_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());




/**
 * [tAdvancedHash_row5 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_5 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row5 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	

 



/**
 * [tAdvancedHash_row5 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
	}
	


public static class row6Struct implements routines.system.IPersistableComparableLookupRow<row6Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_Achat = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_Achat = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_fournisseur;

				public int getId_fournisseur () {
					return this.id_fournisseur;
				}
				
			    public int id_produit;

				public int getId_produit () {
					return this.id_produit;
				}
				
			    public int date_key;

				public int getDate_key () {
					return this.date_key;
				}
				
			    public String num_facture;

				public String getNum_facture () {
					return this.num_facture;
				}
				
			    public int quantite;

				public int getQuantite () {
					return this.quantite;
				}
				
			    public float montant_ligne;

				public float getMontant_ligne () {
					return this.montant_ligne;
				}
				
			    public Float montant_ht_facture;

				public Float getMontant_ht_facture () {
					return this.montant_ht_facture;
				}
				
			    public Float tva;

				public Float getTva () {
					return this.tva;
				}
				
			    public Float timbre;

				public Float getTimbre () {
					return this.timbre;
				}
				
			    public Float montant_ttc_facture;

				public Float getMontant_ttc_facture () {
					return this.montant_ttc_facture;
				}
				
			    public Float reste_du;

				public Float getReste_du () {
					return this.reste_du;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.id_fournisseur;
						
							result = prime * result + (int) this.id_produit;
						
							result = prime * result + (int) this.date_key;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row6Struct other = (row6Struct) obj;
		
						if (this.id_fournisseur != other.id_fournisseur)
							return false;
					
						if (this.id_produit != other.id_produit)
							return false;
					
						if (this.date_key != other.date_key)
							return false;
					

		return true;
    }

	public void copyDataTo(row6Struct other) {

		other.id_fournisseur = this.id_fournisseur;
	            other.id_produit = this.id_produit;
	            other.date_key = this.date_key;
	            other.num_facture = this.num_facture;
	            other.quantite = this.quantite;
	            other.montant_ligne = this.montant_ligne;
	            other.montant_ht_facture = this.montant_ht_facture;
	            other.tva = this.tva;
	            other.timbre = this.timbre;
	            other.montant_ttc_facture = this.montant_ttc_facture;
	            other.reste_du = this.reste_du;
	            
	}

	public void copyKeysDataTo(row6Struct other) {

		other.id_fournisseur = this.id_fournisseur;
	            	other.id_produit = this.id_produit;
	            	other.date_key = this.date_key;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
			        this.id_fournisseur = dis.readInt();
					
			        this.id_produit = dis.readInt();
					
			        this.date_key = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_Achat) {

        	try {

        		int length = 0;
		
			        this.id_fournisseur = dis.readInt();
					
			        this.id_produit = dis.readInt();
					
			        this.date_key = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fournisseur);
					
					// int
				
		            	dos.writeInt(this.id_produit);
					
					// int
				
		            	dos.writeInt(this.date_key);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fournisseur);
					
					// int
				
		            	dos.writeInt(this.id_produit);
					
					// int
				
		            	dos.writeInt(this.date_key);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.num_facture = readString(dis,ois);
					
			            this.quantite = dis.readInt();
					
			            this.montant_ligne = dis.readFloat();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ht_facture = null;
           				} else {
           			    	this.montant_ht_facture = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant_ttc_facture = null;
           				} else {
           			    	this.montant_ttc_facture = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.num_facture = readString(dis,objectIn);
					
			            this.quantite = objectIn.readInt();
					
			            this.montant_ligne = objectIn.readFloat();
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.montant_ht_facture = null;
           				} else {
           			    	this.montant_ht_facture = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.tva = null;
           				} else {
           			    	this.tva = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.timbre = null;
           				} else {
           			    	this.timbre = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.montant_ttc_facture = null;
           				} else {
           			    	this.montant_ttc_facture = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.reste_du = null;
           				} else {
           			    	this.reste_du = objectIn.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.num_facture, dos, oos);
					
		            	dos.writeInt(this.quantite);
					
		            	dos.writeFloat(this.montant_ligne);
					
						if(this.montant_ht_facture == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ht_facture);
		            	}
					
						if(this.tva == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.tva);
		            	}
					
						if(this.timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.timbre);
		            	}
					
						if(this.montant_ttc_facture == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.montant_ttc_facture);
		            	}
					
						if(this.reste_du == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.reste_du);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.num_facture, dos, objectOut);
					
					objectOut.writeInt(this.quantite);
					
					objectOut.writeFloat(this.montant_ligne);
					
						if(this.montant_ht_facture == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.montant_ht_facture);
		            	}
					
						if(this.tva == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.tva);
		            	}
					
						if(this.timbre == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.timbre);
		            	}
					
						if(this.montant_ttc_facture == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.montant_ttc_facture);
		            	}
					
						if(this.reste_du == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.reste_du);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_fournisseur="+String.valueOf(id_fournisseur));
		sb.append(",id_produit="+String.valueOf(id_produit));
		sb.append(",date_key="+String.valueOf(date_key));
		sb.append(",num_facture="+num_facture);
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",montant_ligne="+String.valueOf(montant_ligne));
		sb.append(",montant_ht_facture="+String.valueOf(montant_ht_facture));
		sb.append(",tva="+String.valueOf(tva));
		sb.append(",timbre="+String.valueOf(timbre));
		sb.append(",montant_ttc_facture="+String.valueOf(montant_ttc_facture));
		sb.append(",reste_du="+String.valueOf(reste_du));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row6Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_fournisseur, other.id_fournisseur);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.id_produit, other.id_produit);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.date_key, other.date_key);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_6_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row6Struct row6 = new row6Struct();




	
	/**
	 * [tAdvancedHash_row6 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row6", false);
		start_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row6";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row6");
					}
				
		int tos_count_tAdvancedHash_row6 = 0;
		

			   		// connection name:row6
			   		// source node:tDBInput_6 - inputs:(after_tDBInput_1) outputs:(row6,row6) | target node:tAdvancedHash_row6 - inputs:(row6) outputs:()
			   		// linked node: tMap_5 - inputs:(fk_date,row6) outputs:(ajout)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row6 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row6Struct>getLookup(matchingModeEnum_row6);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row6", tHash_Lookup_row6);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row6 begin ] stop
 */



	
	/**
	 * [tDBInput_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_6", false);
		start_Hash.put("tDBInput_6", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_6";

	
		int tos_count_tDBInput_6 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_6 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_6 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_6  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_6, talendToDBArray_tDBInput_6); 
		    int nb_line_tDBInput_6 = 0;
		    java.sql.Connection conn_tDBInput_6 = null;
				String driverClass_tDBInput_6 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    java.lang.Class jdbcclazz_tDBInput_6 = java.lang.Class.forName(driverClass_tDBInput_6);
				String dbUser_tDBInput_6 = "sa";
				
				 
	final String decryptedPassword_tDBInput_6 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:1c+e8OvtKZvH9yMpvS/TWG2gDjCBwqyZl7tQi/Upvcy7XgIE");
				
				String dbPwd_tDBInput_6 = decryptedPassword_tDBInput_6;
				
		    String port_tDBInput_6 = "1433";
		    String dbname_tDBInput_6 = "Sougui_DWH" ;		    
		    String url_tDBInput_6 = "jdbc:sqlserver://" + "DESKTOP-LBCVIS5" ;
		    if (!"".equals(port_tDBInput_6)) {
		    	url_tDBInput_6 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_6)) {		    
		    	url_tDBInput_6 += ";databaseName=" + "Sougui_DWH"; 
		    }
		    url_tDBInput_6 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
		    String dbschema_tDBInput_6 = "dbo";
				
				conn_tDBInput_6 = java.sql.DriverManager.getConnection(url_tDBInput_6,dbUser_tDBInput_6,dbPwd_tDBInput_6);
		        
		    
			java.sql.Statement stmt_tDBInput_6 = conn_tDBInput_6.createStatement();

		    String dbquery_tDBInput_6 = "SELECT dbo.Fact_Achat.id_fournisseur,\n		dbo.Fact_Achat.id_produit,\n		dbo.Fact_Achat.date_key,\n		dbo.Fact_Achat.num_fact"
+"ure,\n		dbo.Fact_Achat.quantite,\n		dbo.Fact_Achat.montant_ligne,\n		dbo.Fact_Achat.montant_ht_facture,\n		dbo.Fact_Achat.tv"
+"a,\n		dbo.Fact_Achat.timbre,\n		dbo.Fact_Achat.montant_ttc_facture,\n		dbo.Fact_Achat.reste_du\nFROM	dbo.Fact_Achat";
		    

            	globalMap.put("tDBInput_6_QUERY",dbquery_tDBInput_6);
		    java.sql.ResultSet rs_tDBInput_6 = null;

		    try {
		    	rs_tDBInput_6 = stmt_tDBInput_6.executeQuery(dbquery_tDBInput_6);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_6 = rs_tDBInput_6.getMetaData();
		    	int colQtyInRs_tDBInput_6 = rsmd_tDBInput_6.getColumnCount();

		    String tmpContent_tDBInput_6 = null;
		    
		    
		    while (rs_tDBInput_6.next()) {
		        nb_line_tDBInput_6++;
		        
							if(colQtyInRs_tDBInput_6 < 1) {
								row6.id_fournisseur = 0;
							} else {
		                          
            row6.id_fournisseur = rs_tDBInput_6.getInt(1);
            if(rs_tDBInput_6.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 2) {
								row6.id_produit = 0;
							} else {
		                          
            row6.id_produit = rs_tDBInput_6.getInt(2);
            if(rs_tDBInput_6.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 3) {
								row6.date_key = 0;
							} else {
		                          
            row6.date_key = rs_tDBInput_6.getInt(3);
            if(rs_tDBInput_6.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 4) {
								row6.num_facture = null;
							} else {
	                         		
           		tmpContent_tDBInput_6 = rs_tDBInput_6.getString(4);
            if(tmpContent_tDBInput_6 != null) {
            	if (talendToDBList_tDBInput_6 .contains(rsmd_tDBInput_6.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row6.num_facture = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
            	} else {
                	row6.num_facture = tmpContent_tDBInput_6;
                }
            } else {
                row6.num_facture = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 5) {
								row6.quantite = 0;
							} else {
		                          
            row6.quantite = rs_tDBInput_6.getInt(5);
            if(rs_tDBInput_6.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 6) {
								row6.montant_ligne = 0;
							} else {
		                          
            row6.montant_ligne = rs_tDBInput_6.getFloat(6);
            if(rs_tDBInput_6.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 7) {
								row6.montant_ht_facture = null;
							} else {
		                          
            row6.montant_ht_facture = rs_tDBInput_6.getFloat(7);
            if(rs_tDBInput_6.wasNull()){
                    row6.montant_ht_facture = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 8) {
								row6.tva = null;
							} else {
		                          
            row6.tva = rs_tDBInput_6.getFloat(8);
            if(rs_tDBInput_6.wasNull()){
                    row6.tva = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 9) {
								row6.timbre = null;
							} else {
		                          
            row6.timbre = rs_tDBInput_6.getFloat(9);
            if(rs_tDBInput_6.wasNull()){
                    row6.timbre = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 10) {
								row6.montant_ttc_facture = null;
							} else {
		                          
            row6.montant_ttc_facture = rs_tDBInput_6.getFloat(10);
            if(rs_tDBInput_6.wasNull()){
                    row6.montant_ttc_facture = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 11) {
								row6.reste_du = null;
							} else {
		                          
            row6.reste_du = rs_tDBInput_6.getFloat(11);
            if(rs_tDBInput_6.wasNull()){
                    row6.reste_du = null;
            }
		                    }
					





 



/**
 * [tDBInput_6 begin ] stop
 */
	
	/**
	 * [tDBInput_6 main ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 


	tos_count_tDBInput_6++;

/**
 * [tDBInput_6 main ] stop
 */
	
	/**
	 * [tDBInput_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 



/**
 * [tDBInput_6 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row6 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row6"
						
						);
					}
					


			   
			   

					row6Struct row6_HashRow = new row6Struct();
		   	   	   
				
				row6_HashRow.id_fournisseur = row6.id_fournisseur;
				
				row6_HashRow.id_produit = row6.id_produit;
				
				row6_HashRow.date_key = row6.date_key;
				
				row6_HashRow.num_facture = row6.num_facture;
				
				row6_HashRow.quantite = row6.quantite;
				
				row6_HashRow.montant_ligne = row6.montant_ligne;
				
				row6_HashRow.montant_ht_facture = row6.montant_ht_facture;
				
				row6_HashRow.tva = row6.tva;
				
				row6_HashRow.timbre = row6.timbre;
				
				row6_HashRow.montant_ttc_facture = row6.montant_ttc_facture;
				
				row6_HashRow.reste_du = row6.reste_du;
				
			tHash_Lookup_row6.put(row6_HashRow);
			
            




 


	tos_count_tAdvancedHash_row6++;

/**
 * [tAdvancedHash_row6 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	

 



/**
 * [tAdvancedHash_row6 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row6 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	

 



/**
 * [tAdvancedHash_row6 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 



/**
 * [tDBInput_6 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_6 end ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

	}
}finally{
	if (rs_tDBInput_6 != null) {
		rs_tDBInput_6.close();
	}
	if (stmt_tDBInput_6 != null) {
		stmt_tDBInput_6.close();
	}
		if(conn_tDBInput_6 != null && !conn_tDBInput_6.isClosed()) {
			
			conn_tDBInput_6.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_6_NB_LINE",nb_line_tDBInput_6);

 

ok_Hash.put("tDBInput_6", true);
end_Hash.put("tDBInput_6", System.currentTimeMillis());




/**
 * [tDBInput_6 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row6 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	

tHash_Lookup_row6.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row6");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row6", true);
end_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());




/**
 * [tAdvancedHash_row6 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_6 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 



/**
 * [tDBInput_6 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row6 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	

 



/**
 * [tAdvancedHash_row6 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_6_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final Fact_Achat Fact_AchatClass = new Fact_Achat();

        int exitCode = Fact_AchatClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = Fact_Achat.class.getClassLoader().getResourceAsStream("souguietl/fact_achat_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Fact_Achat.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob





this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tDBInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_1) {
globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

e_tDBInput_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Fact_Achat");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     319661 characters generated by Talend Open Studio for Data Integration 
 *     on the 22 mars 2026 à 16:45:15 WAT
 ************************************************************************************************/