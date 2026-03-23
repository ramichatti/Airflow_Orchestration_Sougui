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


package souguietl.fact_venteb2b_0_1;

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
 * Job: Fact_VenteB2B Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class Fact_VenteB2B implements TalendJob {

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
	private final String jobName = "Fact_VenteB2B";
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
				Fact_VenteB2B.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Fact_VenteB2B.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tLogRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
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
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_VenteB2B = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int Id_Produit;

				public int getId_Produit () {
					return this.Id_Produit;
				}
				
			    public int Id_Entreprise;

				public int getId_Entreprise () {
					return this.Id_Entreprise;
				}
				
			    public int Date_Key;

				public int getDate_Key () {
					return this.Date_Key;
				}
				
			    public String Num_facture;

				public String getNum_facture () {
					return this.Num_facture;
				}
				
			    public Integer Quantite;

				public Integer getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_Total_HT;

				public Float getPrix_Total_HT () {
					return this.Prix_Total_HT;
				}
				
			    public Float Montant_Total_HT;

				public Float getMontant_Total_HT () {
					return this.Montant_Total_HT;
				}
				
			    public Float TVA;

				public Float getTVA () {
					return this.TVA;
				}
				
			    public Float Timbre;

				public Float getTimbre () {
					return this.Timbre;
				}
				
			    public Float Total_TTC;

				public Float getTotal_TTC () {
					return this.Total_TTC;
				}
				
			    public String Type;

				public String getType () {
					return this.Type;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.Id_Produit;
						
							result = prime * result + (int) this.Id_Entreprise;
						
							result = prime * result + (int) this.Date_Key;
						
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
		
						if (this.Id_Produit != other.Id_Produit)
							return false;
					
						if (this.Id_Entreprise != other.Id_Entreprise)
							return false;
					
						if (this.Date_Key != other.Date_Key)
							return false;
					

		return true;
    }

	public void copyDataTo(ajoutStruct other) {

		other.Id_Produit = this.Id_Produit;
	            other.Id_Entreprise = this.Id_Entreprise;
	            other.Date_Key = this.Date_Key;
	            other.Num_facture = this.Num_facture;
	            other.Quantite = this.Quantite;
	            other.Prix_Total_HT = this.Prix_Total_HT;
	            other.Montant_Total_HT = this.Montant_Total_HT;
	            other.TVA = this.TVA;
	            other.Timbre = this.Timbre;
	            other.Total_TTC = this.Total_TTC;
	            other.Type = this.Type;
	            
	}

	public void copyKeysDataTo(ajoutStruct other) {

		other.Id_Produit = this.Id_Produit;
	            	other.Id_Entreprise = this.Id_Entreprise;
	            	other.Date_Key = this.Date_Key;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
			        this.Id_Produit = dis.readInt();
					
			        this.Id_Entreprise = dis.readInt();
					
			        this.Date_Key = dis.readInt();
					
					this.Num_facture = readString(dis);
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
			        this.Id_Produit = dis.readInt();
					
			        this.Id_Entreprise = dis.readInt();
					
			        this.Date_Key = dis.readInt();
					
					this.Num_facture = readString(dis);
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.Id_Produit);
					
					// int
				
		            	dos.writeInt(this.Id_Entreprise);
					
					// int
				
		            	dos.writeInt(this.Date_Key);
					
					// String
				
						writeString(this.Num_facture,dos);
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.Id_Produit);
					
					// int
				
		            	dos.writeInt(this.Id_Entreprise);
					
					// int
				
		            	dos.writeInt(this.Date_Key);
					
					// String
				
						writeString(this.Num_facture,dos);
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Id_Produit="+String.valueOf(Id_Produit));
		sb.append(",Id_Entreprise="+String.valueOf(Id_Entreprise));
		sb.append(",Date_Key="+String.valueOf(Date_Key));
		sb.append(",Num_facture="+Num_facture);
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_Total_HT="+String.valueOf(Prix_Total_HT));
		sb.append(",Montant_Total_HT="+String.valueOf(Montant_Total_HT));
		sb.append(",TVA="+String.valueOf(TVA));
		sb.append(",Timbre="+String.valueOf(Timbre));
		sb.append(",Total_TTC="+String.valueOf(Total_TTC));
		sb.append(",Type="+Type);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(ajoutStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Id_Produit, other.Id_Produit);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Id_Entreprise, other.Id_Entreprise);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Date_Key, other.Date_Key);
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

public static class fk_produitStruct implements routines.system.IPersistableRow<fk_produitStruct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_VenteB2B = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[0];

	
			    public int Id_Produit;

				public int getId_Produit () {
					return this.Id_Produit;
				}
				
			    public int Id_Client;

				public int getId_Client () {
					return this.Id_Client;
				}
				
			    public int Date_Key;

				public int getDate_Key () {
					return this.Date_Key;
				}
				
			    public String Num_facture;

				public String getNum_facture () {
					return this.Num_facture;
				}
				
			    public Integer Quantite;

				public Integer getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_Total_HT;

				public Float getPrix_Total_HT () {
					return this.Prix_Total_HT;
				}
				
			    public Float Montant_Total_HT;

				public Float getMontant_Total_HT () {
					return this.Montant_Total_HT;
				}
				
			    public Float TVA;

				public Float getTVA () {
					return this.TVA;
				}
				
			    public Float Timbre;

				public Float getTimbre () {
					return this.Timbre;
				}
				
			    public Float Total_TTC;

				public Float getTotal_TTC () {
					return this.Total_TTC;
				}
				
			    public String Type;

				public String getType () {
					return this.Type;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
			        this.Id_Produit = dis.readInt();
					
			        this.Id_Client = dis.readInt();
					
			        this.Date_Key = dis.readInt();
					
					this.Num_facture = readString(dis);
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
			        this.Id_Produit = dis.readInt();
					
			        this.Id_Client = dis.readInt();
					
			        this.Date_Key = dis.readInt();
					
					this.Num_facture = readString(dis);
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.Id_Produit);
					
					// int
				
		            	dos.writeInt(this.Id_Client);
					
					// int
				
		            	dos.writeInt(this.Date_Key);
					
					// String
				
						writeString(this.Num_facture,dos);
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.Id_Produit);
					
					// int
				
		            	dos.writeInt(this.Id_Client);
					
					// int
				
		            	dos.writeInt(this.Date_Key);
					
					// String
				
						writeString(this.Num_facture,dos);
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Id_Produit="+String.valueOf(Id_Produit));
		sb.append(",Id_Client="+String.valueOf(Id_Client));
		sb.append(",Date_Key="+String.valueOf(Date_Key));
		sb.append(",Num_facture="+Num_facture);
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_Total_HT="+String.valueOf(Prix_Total_HT));
		sb.append(",Montant_Total_HT="+String.valueOf(Montant_Total_HT));
		sb.append(",TVA="+String.valueOf(TVA));
		sb.append(",Timbre="+String.valueOf(Timbre));
		sb.append(",Total_TTC="+String.valueOf(Total_TTC));
		sb.append(",Type="+Type);
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
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_VenteB2B = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[0];

	
			    public int Id_Client;

				public int getId_Client () {
					return this.Id_Client;
				}
				
			    public int Date_Key;

				public int getDate_Key () {
					return this.Date_Key;
				}
				
			    public String Num_facture;

				public String getNum_facture () {
					return this.Num_facture;
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
				
			    public Integer Quantite;

				public Integer getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_Total_HT;

				public Float getPrix_Total_HT () {
					return this.Prix_Total_HT;
				}
				
			    public Float Montant_Total_HT;

				public Float getMontant_Total_HT () {
					return this.Montant_Total_HT;
				}
				
			    public Float TVA;

				public Float getTVA () {
					return this.TVA;
				}
				
			    public Float Timbre;

				public Float getTimbre () {
					return this.Timbre;
				}
				
			    public Float Total_TTC;

				public Float getTotal_TTC () {
					return this.Total_TTC;
				}
				
			    public String Type;

				public String getType () {
					return this.Type;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
			        this.Id_Client = dis.readInt();
					
			        this.Date_Key = dis.readInt();
					
					this.Num_facture = readString(dis);
					
					this.Reference = readString(dis);
					
					this.Description = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
			        this.Id_Client = dis.readInt();
					
			        this.Date_Key = dis.readInt();
					
					this.Num_facture = readString(dis);
					
					this.Reference = readString(dis);
					
					this.Description = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.Id_Client);
					
					// int
				
		            	dos.writeInt(this.Date_Key);
					
					// String
				
						writeString(this.Num_facture,dos);
					
					// String
				
						writeString(this.Reference,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// Float
				
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.Id_Client);
					
					// int
				
		            	dos.writeInt(this.Date_Key);
					
					// String
				
						writeString(this.Num_facture,dos);
					
					// String
				
						writeString(this.Reference,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// Float
				
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Id_Client="+String.valueOf(Id_Client));
		sb.append(",Date_Key="+String.valueOf(Date_Key));
		sb.append(",Num_facture="+Num_facture);
		sb.append(",Reference="+Reference);
		sb.append(",Description="+Description);
		sb.append(",PU_HT="+String.valueOf(PU_HT));
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_Total_HT="+String.valueOf(Prix_Total_HT));
		sb.append(",Montant_Total_HT="+String.valueOf(Montant_Total_HT));
		sb.append(",TVA="+String.valueOf(TVA));
		sb.append(",Timbre="+String.valueOf(Timbre));
		sb.append(",Total_TTC="+String.valueOf(Total_TTC));
		sb.append(",Type="+Type);
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

public static class fk_dateStruct implements routines.system.IPersistableRow<fk_dateStruct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_VenteB2B = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[0];

	
			    public int Date_Key;

				public int getDate_Key () {
					return this.Date_Key;
				}
				
			    public String Num_facture;

				public String getNum_facture () {
					return this.Num_facture;
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
				
			    public Integer Quantite;

				public Integer getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_Total_HT;

				public Float getPrix_Total_HT () {
					return this.Prix_Total_HT;
				}
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Matricule_fiscal;

				public String getMatricule_fiscal () {
					return this.Matricule_fiscal;
				}
				
			    public String Adresse;

				public String getAdresse () {
					return this.Adresse;
				}
				
			    public Float Montant_Total_HT;

				public Float getMontant_Total_HT () {
					return this.Montant_Total_HT;
				}
				
			    public Float TVA;

				public Float getTVA () {
					return this.TVA;
				}
				
			    public Float Timbre;

				public Float getTimbre () {
					return this.Timbre;
				}
				
			    public Float Total_TTC;

				public Float getTotal_TTC () {
					return this.Total_TTC;
				}
				
			    public String Type;

				public String getType () {
					return this.Type;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
			        this.Date_Key = dis.readInt();
					
					this.Num_facture = readString(dis);
					
					this.Reference = readString(dis);
					
					this.Description = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
					this.Nom = readString(dis);
					
					this.Matricule_fiscal = readString(dis);
					
					this.Adresse = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
			        this.Date_Key = dis.readInt();
					
					this.Num_facture = readString(dis);
					
					this.Reference = readString(dis);
					
					this.Description = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
					this.Nom = readString(dis);
					
					this.Matricule_fiscal = readString(dis);
					
					this.Adresse = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.Date_Key);
					
					// String
				
						writeString(this.Num_facture,dos);
					
					// String
				
						writeString(this.Reference,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// Float
				
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Matricule_fiscal,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.Date_Key);
					
					// String
				
						writeString(this.Num_facture,dos);
					
					// String
				
						writeString(this.Reference,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// Float
				
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Matricule_fiscal,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Date_Key="+String.valueOf(Date_Key));
		sb.append(",Num_facture="+Num_facture);
		sb.append(",Reference="+Reference);
		sb.append(",Description="+Description);
		sb.append(",PU_HT="+String.valueOf(PU_HT));
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_Total_HT="+String.valueOf(Prix_Total_HT));
		sb.append(",Nom="+Nom);
		sb.append(",Matricule_fiscal="+Matricule_fiscal);
		sb.append(",Adresse="+Adresse);
		sb.append(",Montant_Total_HT="+String.valueOf(Montant_Total_HT));
		sb.append(",TVA="+String.valueOf(TVA));
		sb.append(",Timbre="+String.valueOf(Timbre));
		sb.append(",Total_TTC="+String.valueOf(Total_TTC));
		sb.append(",Type="+Type);
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

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_VenteB2B = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[0];

	
			    public String Num_facture;

				public String getNum_facture () {
					return this.Num_facture;
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
				
			    public Integer Quantite;

				public Integer getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_Total_HT;

				public Float getPrix_Total_HT () {
					return this.Prix_Total_HT;
				}
				
			    public java.util.Date Date;

				public java.util.Date getDate () {
					return this.Date;
				}
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Matricule_fiscal;

				public String getMatricule_fiscal () {
					return this.Matricule_fiscal;
				}
				
			    public String Adresse;

				public String getAdresse () {
					return this.Adresse;
				}
				
			    public Float Montant_Total_HT;

				public Float getMontant_Total_HT () {
					return this.Montant_Total_HT;
				}
				
			    public Float TVA;

				public Float getTVA () {
					return this.TVA;
				}
				
			    public Float Timbre;

				public Float getTimbre () {
					return this.Timbre;
				}
				
			    public Float Total_TTC;

				public Float getTotal_TTC () {
					return this.Total_TTC;
				}
				
			    public String Type;

				public String getType () {
					return this.Type;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
					this.Num_facture = readString(dis);
					
					this.Reference = readString(dis);
					
					this.Description = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
					this.Date = readDate(dis);
					
					this.Nom = readString(dis);
					
					this.Matricule_fiscal = readString(dis);
					
					this.Adresse = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
					this.Num_facture = readString(dis);
					
					this.Reference = readString(dis);
					
					this.Description = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
					this.Date = readDate(dis);
					
					this.Nom = readString(dis);
					
					this.Matricule_fiscal = readString(dis);
					
					this.Adresse = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Num_facture,dos);
					
					// String
				
						writeString(this.Reference,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// Float
				
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// java.util.Date
				
						writeDate(this.Date,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Matricule_fiscal,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Num_facture,dos);
					
					// String
				
						writeString(this.Reference,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// Float
				
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// java.util.Date
				
						writeDate(this.Date,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Matricule_fiscal,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Num_facture="+Num_facture);
		sb.append(",Reference="+Reference);
		sb.append(",Description="+Description);
		sb.append(",PU_HT="+String.valueOf(PU_HT));
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_Total_HT="+String.valueOf(Prix_Total_HT));
		sb.append(",Date="+String.valueOf(Date));
		sb.append(",Nom="+Nom);
		sb.append(",Matricule_fiscal="+Matricule_fiscal);
		sb.append(",Adresse="+Adresse);
		sb.append(",Montant_Total_HT="+String.valueOf(Montant_Total_HT));
		sb.append(",TVA="+String.valueOf(TVA));
		sb.append(",Timbre="+String.valueOf(Timbre));
		sb.append(",Total_TTC="+String.valueOf(Total_TTC));
		sb.append(",Type="+Type);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

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
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_VenteB2B = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[0];

	
			    public String Num_facture;

				public String getNum_facture () {
					return this.Num_facture;
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
				
			    public Integer Quantite;

				public Integer getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_Total_HT;

				public Float getPrix_Total_HT () {
					return this.Prix_Total_HT;
				}
				
			    public java.util.Date Date;

				public java.util.Date getDate () {
					return this.Date;
				}
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Matricule_fiscal;

				public String getMatricule_fiscal () {
					return this.Matricule_fiscal;
				}
				
			    public String Adresse;

				public String getAdresse () {
					return this.Adresse;
				}
				
			    public Float Montant_Total_HT;

				public Float getMontant_Total_HT () {
					return this.Montant_Total_HT;
				}
				
			    public Float TVA;

				public Float getTVA () {
					return this.TVA;
				}
				
			    public Float Timbre;

				public Float getTimbre () {
					return this.Timbre;
				}
				
			    public Float Total_TTC;

				public Float getTotal_TTC () {
					return this.Total_TTC;
				}
				
			    public String Type;

				public String getType () {
					return this.Type;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
					this.Num_facture = readString(dis);
					
					this.Reference = readString(dis);
					
					this.Description = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
					this.Date = readDate(dis);
					
					this.Nom = readString(dis);
					
					this.Matricule_fiscal = readString(dis);
					
					this.Adresse = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
					this.Num_facture = readString(dis);
					
					this.Reference = readString(dis);
					
					this.Description = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
					this.Date = readDate(dis);
					
					this.Nom = readString(dis);
					
					this.Matricule_fiscal = readString(dis);
					
					this.Adresse = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Num_facture,dos);
					
					// String
				
						writeString(this.Reference,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// Float
				
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// java.util.Date
				
						writeDate(this.Date,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Matricule_fiscal,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Num_facture,dos);
					
					// String
				
						writeString(this.Reference,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// Float
				
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// java.util.Date
				
						writeDate(this.Date,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Matricule_fiscal,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Num_facture="+Num_facture);
		sb.append(",Reference="+Reference);
		sb.append(",Description="+Description);
		sb.append(",PU_HT="+String.valueOf(PU_HT));
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_Total_HT="+String.valueOf(Prix_Total_HT));
		sb.append(",Date="+String.valueOf(Date));
		sb.append(",Nom="+Nom);
		sb.append(",Matricule_fiscal="+Matricule_fiscal);
		sb.append(",Adresse="+Adresse);
		sb.append(",Montant_Total_HT="+String.valueOf(Montant_Total_HT));
		sb.append(",TVA="+String.valueOf(TVA));
		sb.append(",Timbre="+String.valueOf(Timbre));
		sb.append(",Total_TTC="+String.valueOf(Total_TTC));
		sb.append(",Type="+Type);
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
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_VenteB2B = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[0];

	
			    public String Num_facture;

				public String getNum_facture () {
					return this.Num_facture;
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
				
			    public Integer Quantite;

				public Integer getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_Total_HT;

				public Float getPrix_Total_HT () {
					return this.Prix_Total_HT;
				}
				
			    public String Date;

				public String getDate () {
					return this.Date;
				}
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Matricule_fiscal;

				public String getMatricule_fiscal () {
					return this.Matricule_fiscal;
				}
				
			    public String Adresse;

				public String getAdresse () {
					return this.Adresse;
				}
				
			    public Float Montant_Total_HT;

				public Float getMontant_Total_HT () {
					return this.Montant_Total_HT;
				}
				
			    public Float TVA;

				public Float getTVA () {
					return this.TVA;
				}
				
			    public Float Timbre;

				public Float getTimbre () {
					return this.Timbre;
				}
				
			    public Float Total_TTC;

				public Float getTotal_TTC () {
					return this.Total_TTC;
				}
				
			    public String Type;

				public String getType () {
					return this.Type;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
					this.Num_facture = readString(dis);
					
					this.Reference = readString(dis);
					
					this.Description = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
					this.Date = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Matricule_fiscal = readString(dis);
					
					this.Adresse = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
					this.Num_facture = readString(dis);
					
					this.Reference = readString(dis);
					
					this.Description = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
					this.Date = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Matricule_fiscal = readString(dis);
					
					this.Adresse = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Num_facture,dos);
					
					// String
				
						writeString(this.Reference,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// Float
				
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// String
				
						writeString(this.Date,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Matricule_fiscal,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Num_facture,dos);
					
					// String
				
						writeString(this.Reference,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// Float
				
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// String
				
						writeString(this.Date,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Matricule_fiscal,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Num_facture="+Num_facture);
		sb.append(",Reference="+Reference);
		sb.append(",Description="+Description);
		sb.append(",PU_HT="+String.valueOf(PU_HT));
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_Total_HT="+String.valueOf(Prix_Total_HT));
		sb.append(",Date="+Date);
		sb.append(",Nom="+Nom);
		sb.append(",Matricule_fiscal="+Matricule_fiscal);
		sb.append(",Adresse="+Adresse);
		sb.append(",Montant_Total_HT="+String.valueOf(Montant_Total_HT));
		sb.append(",TVA="+String.valueOf(TVA));
		sb.append(",Timbre="+String.valueOf(Timbre));
		sb.append(",Total_TTC="+String.valueOf(Total_TTC));
		sb.append(",Type="+Type);
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
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_VenteB2B = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[0];

	
			    public String Num_facture;

				public String getNum_facture () {
					return this.Num_facture;
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
				
			    public Integer Quantite;

				public Integer getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_Total_HT;

				public Float getPrix_Total_HT () {
					return this.Prix_Total_HT;
				}
				
			    public String Date;

				public String getDate () {
					return this.Date;
				}
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Matricule_fiscal;

				public String getMatricule_fiscal () {
					return this.Matricule_fiscal;
				}
				
			    public String Adresse;

				public String getAdresse () {
					return this.Adresse;
				}
				
			    public Float Montant_Total_HT;

				public Float getMontant_Total_HT () {
					return this.Montant_Total_HT;
				}
				
			    public Float TVA;

				public Float getTVA () {
					return this.TVA;
				}
				
			    public Float Timbre;

				public Float getTimbre () {
					return this.Timbre;
				}
				
			    public Float Total_TTC;

				public Float getTotal_TTC () {
					return this.Total_TTC;
				}
				
			    public String Type;

				public String getType () {
					return this.Type;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
					this.Num_facture = readString(dis);
					
					this.Reference = readString(dis);
					
					this.Description = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
					this.Date = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Matricule_fiscal = readString(dis);
					
					this.Adresse = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
					this.Num_facture = readString(dis);
					
					this.Reference = readString(dis);
					
					this.Description = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.PU_HT = null;
           				} else {
           			    	this.PU_HT = dis.readFloat();
           				}
					
						this.Quantite = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
					this.Date = readString(dis);
					
					this.Nom = readString(dis);
					
					this.Matricule_fiscal = readString(dis);
					
					this.Adresse = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
					this.Type = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Num_facture,dos);
					
					// String
				
						writeString(this.Reference,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// Float
				
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// String
				
						writeString(this.Date,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Matricule_fiscal,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Num_facture,dos);
					
					// String
				
						writeString(this.Reference,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// Float
				
						if(this.PU_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.PU_HT);
		            	}
					
					// Integer
				
						writeInteger(this.Quantite,dos);
					
					// Float
				
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
					// String
				
						writeString(this.Date,dos);
					
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Matricule_fiscal,dos);
					
					// String
				
						writeString(this.Adresse,dos);
					
					// Float
				
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
					// Float
				
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
					// Float
				
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
					// Float
				
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
					// String
				
						writeString(this.Type,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Num_facture="+Num_facture);
		sb.append(",Reference="+Reference);
		sb.append(",Description="+Description);
		sb.append(",PU_HT="+String.valueOf(PU_HT));
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_Total_HT="+String.valueOf(Prix_Total_HT));
		sb.append(",Date="+Date);
		sb.append(",Nom="+Nom);
		sb.append(",Matricule_fiscal="+Matricule_fiscal);
		sb.append(",Adresse="+Adresse);
		sb.append(",Montant_Total_HT="+String.valueOf(Montant_Total_HT));
		sb.append(",TVA="+String.valueOf(TVA));
		sb.append(",Timbre="+String.valueOf(Timbre));
		sb.append(",Total_TTC="+String.valueOf(Total_TTC));
		sb.append(",Type="+Type);
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

		row1Struct row1 = new row1Struct();
out1Struct out1 = new out1Struct();
out1Struct row2 = out1;
fk_dateStruct fk_date = new fk_dateStruct();
fk_entrepriseStruct fk_entreprise = new fk_entrepriseStruct();
fk_produitStruct fk_produit = new fk_produitStruct();
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:SesLh9vrWNn0aqJWwYCXBHAEINlfZ/3hRTaSrnL4EpbgGvCv");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;

   int batchSize_tDBOutput_1 = 10000;
   int batchSizeCounter_tDBOutput_1=0;

if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "Fact_Vente_B2B";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "Fact_Vente_B2B";
}
	int count_tDBOutput_1=0;

        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([Id_Produit],[Id_Entreprise],[Date_Key],[Num_facture],[Quantite],[Prix_Total_HT],[Montant_Total_HT],[TVA],[Timbre],[Total_TTC],[Type]) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"fk_produit");
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"fk_entreprise");
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
fk_produitStruct fk_produit_tmp = new fk_produitStruct();
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"fk_date");
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
fk_entrepriseStruct fk_entreprise_tmp = new fk_entrepriseStruct();
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
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
fk_dateStruct fk_date_tmp = new fk_dateStruct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_1", false);
		start_Hash.put("tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out1");
					}
				
		int tos_count_tLogRow_1 = 0;
		

	///////////////////////
	
		final String OUTPUT_FIELD_SEPARATOR_tLogRow_1 = "|";
		java.io.PrintStream consoleOut_tLogRow_1 = null;	

 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



/**
 * [tLogRow_1 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:AAI4N5EkrFcl6u2YpaIRZRttWJaBhXvhCGuoTg94Cbj6SqrW");
				
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

		    String dbquery_tDBInput_1 = "SELECT \n    l.Num_facture,\n    l.Reference,\n    l.Description,\n    l.PU_HT,\n    l.Quantite,\n    l.Prix_Total_HT,"
+"\n    e.Date,\n    e.Nom,\n    e.Matricule_fiscal,\n    e.Adresse,\n    e.Montant_Total_HT,\n    e.TVA,\n    e.Timbre,\n "
+"   e.Total_TTC,\n    e.Type\nFROM [Sougui_SA].[dbo].[Ligne_vente_SA] l\nINNER JOIN [Sougui_SA].[dbo].[Entete_vente_SA] e"
+"\n    ON l.Num_facture = e.Num_facture;";
		    

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
								row1.Num_facture = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(1);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Num_facture = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Num_facture = tmpContent_tDBInput_1;
                }
            } else {
                row1.Num_facture = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.Reference = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Reference = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Reference = tmpContent_tDBInput_1;
                }
            } else {
                row1.Reference = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.Description = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Description = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Description = tmpContent_tDBInput_1;
                }
            } else {
                row1.Description = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.PU_HT = null;
							} else {
		                          
            row1.PU_HT = rs_tDBInput_1.getFloat(4);
            if(rs_tDBInput_1.wasNull()){
                    row1.PU_HT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.Quantite = null;
							} else {
		                          
            row1.Quantite = rs_tDBInput_1.getInt(5);
            if(rs_tDBInput_1.wasNull()){
                    row1.Quantite = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.Prix_Total_HT = null;
							} else {
		                          
            row1.Prix_Total_HT = rs_tDBInput_1.getFloat(6);
            if(rs_tDBInput_1.wasNull()){
                    row1.Prix_Total_HT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.Date = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(7);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Date = tmpContent_tDBInput_1;
                }
            } else {
                row1.Date = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.Nom = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(8);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Nom = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Nom = tmpContent_tDBInput_1;
                }
            } else {
                row1.Nom = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.Matricule_fiscal = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(9);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Matricule_fiscal = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Matricule_fiscal = tmpContent_tDBInput_1;
                }
            } else {
                row1.Matricule_fiscal = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.Adresse = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(10);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Adresse = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Adresse = tmpContent_tDBInput_1;
                }
            } else {
                row1.Adresse = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.Montant_Total_HT = null;
							} else {
		                          
            row1.Montant_Total_HT = rs_tDBInput_1.getFloat(11);
            if(rs_tDBInput_1.wasNull()){
                    row1.Montant_Total_HT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.TVA = null;
							} else {
		                          
            row1.TVA = rs_tDBInput_1.getFloat(12);
            if(rs_tDBInput_1.wasNull()){
                    row1.TVA = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.Timbre = null;
							} else {
		                          
            row1.Timbre = rs_tDBInput_1.getFloat(13);
            if(rs_tDBInput_1.wasNull()){
                    row1.Timbre = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.Total_TTC = null;
							} else {
		                          
            row1.Total_TTC = rs_tDBInput_1.getFloat(14);
            if(rs_tDBInput_1.wasNull()){
                    row1.Total_TTC = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.Type = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(15);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Type = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Type = tmpContent_tDBInput_1;
                }
            } else {
                row1.Type = null;
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
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

out1 = null;


// # Output table : 'out1'
out1_tmp.Num_facture = row1.Num_facture ;
out1_tmp.Reference = row1.Reference ;
out1_tmp.Description = row1.Description ;
out1_tmp.PU_HT = row1.PU_HT ;
out1_tmp.Quantite = row1.Quantite ;
out1_tmp.Prix_Total_HT = row1.Prix_Total_HT ;
out1_tmp.Date = TalendDate.parseDate("dd/MM/yyyy", row1.Date) ;
out1_tmp.Nom = row1.Nom ;
out1_tmp.Matricule_fiscal = row1.Matricule_fiscal ;
out1_tmp.Adresse = row1.Adresse ;
out1_tmp.Montant_Total_HT = row1.Montant_Total_HT ;
out1_tmp.TVA = row1.TVA ;
out1_tmp.Timbre = row1.Timbre ;
out1_tmp.Total_TTC = row1.Total_TTC ;
out1_tmp.Type = row1.Type ;
out1 = out1_tmp;
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
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out1"
						
						);
					}
					
///////////////////////		
						



				strBuffer_tLogRow_1 = new StringBuilder();




   				
	    		if(out1.Num_facture != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(out1.Num_facture)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.Reference != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(out1.Reference)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.Description != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(out1.Description)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.PU_HT != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.formatUnwithE(out1.PU_HT)				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.Quantite != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(out1.Quantite)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.Prix_Total_HT != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.formatUnwithE(out1.Prix_Total_HT)				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.Date != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.format_Date(out1.Date, "yyyy/MM/dd")				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.Nom != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(out1.Nom)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.Matricule_fiscal != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(out1.Matricule_fiscal)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.Adresse != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(out1.Adresse)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.Montant_Total_HT != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.formatUnwithE(out1.Montant_Total_HT)				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.TVA != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.formatUnwithE(out1.TVA)				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.Timbre != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.formatUnwithE(out1.Timbre)				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.Total_TTC != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.formatUnwithE(out1.Total_TTC)				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(out1.Type != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(out1.Type)							
				);


							
	    		} //  			
 

                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    consoleOut_tLogRow_1.println(strBuffer_tLogRow_1.toString());
                    consoleOut_tLogRow_1.flush();
                    nb_line_tLogRow_1++;
//////

//////                    
                    
///////////////////////    			

 
     row2 = out1;


	tos_count_tLogRow_1++;

/**
 * [tLogRow_1 main ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
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
								
                        		    		    row3HashKey.Full_Date = row2.Date  == null ? null : new java.util.Date(row2.Date .getTime());
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row3.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_2 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.Full_Date = '" + row3HashKey.Full_Date + "'");
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

fk_date = null;

if(!rejectedInnerJoin_tMap_2 ) {

// # Output table : 'fk_date'
fk_date_tmp.Date_Key = row3.Date_Key;
fk_date_tmp.Num_facture = row2.Num_facture ;
fk_date_tmp.Reference = row2.Reference ;
fk_date_tmp.Description = row2.Description ;
fk_date_tmp.PU_HT = row2.PU_HT ;
fk_date_tmp.Quantite = row2.Quantite ;
fk_date_tmp.Prix_Total_HT = row2.Prix_Total_HT ;
fk_date_tmp.Nom = row2.Nom ;
fk_date_tmp.Matricule_fiscal = row2.Matricule_fiscal ;
fk_date_tmp.Adresse = row2.Adresse ;
fk_date_tmp.Montant_Total_HT = row2.Montant_Total_HT ;
fk_date_tmp.TVA = row2.TVA ;
fk_date_tmp.Timbre = row2.Timbre ;
fk_date_tmp.Total_TTC = row2.Total_TTC ;
fk_date_tmp.Type = row2.Type ;
fk_date = fk_date_tmp;
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
// Start of branch "fk_date"
if(fk_date != null) { 



	
	/**
	 * [tMap_3 main ] start
	 */

	

	
	
	currentComponent="tMap_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"fk_date"
						
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
								
                        		    		    row4HashKey.Nom = fk_date.Nom ;
                        		    		
                        		    		    row4HashKey.Matricule_fiscal = fk_date.Matricule_fiscal ;
                        		    		

								
		                        	row4HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row4.lookup( row4HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row4.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_3 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4' and it contains more one result from keys :  row4.Nom = '" + row4HashKey.Nom + "', row4.Matricule_fiscal = '" + row4HashKey.Matricule_fiscal + "'");
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

fk_entreprise = null;

if(!rejectedInnerJoin_tMap_3 ) {

// # Output table : 'fk_entreprise'
// # Filter conditions 
if( 

fk_date.Nom.equals(row4.Nom) && fk_date.Matricule_fiscal.equals(row4.Matricule_fiscal)

 ) {
fk_entreprise_tmp.Id_Client = row4.Id_Client ;
fk_entreprise_tmp.Date_Key = fk_date.Date_Key ;
fk_entreprise_tmp.Num_facture = fk_date.Num_facture ;
fk_entreprise_tmp.Reference = fk_date.Reference ;
fk_entreprise_tmp.Description = fk_date.Description ;
fk_entreprise_tmp.PU_HT = fk_date.PU_HT ;
fk_entreprise_tmp.Quantite = fk_date.Quantite ;
fk_entreprise_tmp.Prix_Total_HT = fk_date.Prix_Total_HT ;
fk_entreprise_tmp.Montant_Total_HT = fk_date.Montant_Total_HT ;
fk_entreprise_tmp.TVA = fk_date.TVA ;
fk_entreprise_tmp.Timbre = fk_date.Timbre ;
fk_entreprise_tmp.Total_TTC = fk_date.Total_TTC ;
fk_entreprise_tmp.Type = fk_date.Type ;
fk_entreprise = fk_entreprise_tmp;
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
// Start of branch "fk_entreprise"
if(fk_entreprise != null) { 



	
	/**
	 * [tMap_4 main ] start
	 */

	

	
	
	currentComponent="tMap_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"fk_entreprise"
						
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
								
                        		    		    row5HashKey.Reference = fk_entreprise.Reference ;
                        		    		

								
		                        	row5HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row5.lookup( row5HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row5.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_4 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row5 != null && tHash_Lookup_row5.getCount(row5HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row5' and it contains more one result from keys :  row5.Reference = '" + row5HashKey.Reference + "'");
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

fk_produit = null;

if(!rejectedInnerJoin_tMap_4 ) {

// # Output table : 'fk_produit'
// # Filter conditions 
if( 

fk_entreprise.Reference.equals(row5.Reference)

 ) {
fk_produit_tmp.Id_Produit = row5.Id_Produit ;
fk_produit_tmp.Id_Client = fk_entreprise.Id_Client ;
fk_produit_tmp.Date_Key = fk_entreprise.Date_Key ;
fk_produit_tmp.Num_facture = fk_entreprise.Num_facture ;
fk_produit_tmp.Quantite = fk_entreprise.Quantite ;
fk_produit_tmp.Prix_Total_HT = fk_entreprise.Prix_Total_HT ;
fk_produit_tmp.Montant_Total_HT = fk_entreprise.Montant_Total_HT ;
fk_produit_tmp.TVA = fk_entreprise.TVA ;
fk_produit_tmp.Timbre = fk_entreprise.Timbre ;
fk_produit_tmp.Total_TTC = fk_entreprise.Total_TTC ;
fk_produit_tmp.Type = fk_entreprise.Type ;
fk_produit = fk_produit_tmp;
} // closing filter/reject
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
// Start of branch "fk_produit"
if(fk_produit != null) { 



	
	/**
	 * [tMap_5 main ] start
	 */

	

	
	
	currentComponent="tMap_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"fk_produit"
						
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
								
	                        		    	Object exprKeyValue_row6__Date_Key = fk_produit.Date_Key ;
	                        		    	if(exprKeyValue_row6__Date_Key == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_5 = true;
	                        		    	} else {
                        		    			row6HashKey.Date_Key = (int)(Integer) exprKeyValue_row6__Date_Key;
                        		    		}
                        		    		
	                        		    	Object exprKeyValue_row6__Id_Entreprise = fk_produit.Id_Client ;
	                        		    	if(exprKeyValue_row6__Id_Entreprise == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_5 = true;
	                        		    	} else {
                        		    			row6HashKey.Id_Entreprise = (int)(Integer) exprKeyValue_row6__Id_Entreprise;
                        		    		}
                        		    		
	                        		    	Object exprKeyValue_row6__Id_Produit = fk_produit.Id_Produit ;
	                        		    	if(exprKeyValue_row6__Id_Produit == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_5 = true;
	                        		    	} else {
                        		    			row6HashKey.Id_Produit = (int)(Integer) exprKeyValue_row6__Id_Produit;
                        		    		}
                        		    		

								
		                        	row6HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_5) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row6.lookup( row6HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row6 != null && tHash_Lookup_row6.getCount(row6HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row6' and it contains more one result from keys :  row6.Date_Key = '" + row6HashKey.Date_Key + "', row6.Id_Entreprise = '" + row6HashKey.Id_Entreprise + "', row6.Id_Produit = '" + row6HashKey.Id_Produit + "'");
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

row6.Date_Key == 0
&& row6.Id_Entreprise == 0
&& row6.Id_Produit == 0

 ) {
ajout_tmp.Id_Produit = fk_produit.Id_Produit ;
ajout_tmp.Id_Entreprise = fk_produit.Id_Client ;
ajout_tmp.Date_Key = fk_produit.Date_Key ;
ajout_tmp.Num_facture = fk_produit.Num_facture ;
ajout_tmp.Quantite = fk_produit.Quantite ;
ajout_tmp.Prix_Total_HT = fk_produit.Prix_Total_HT ;
ajout_tmp.Montant_Total_HT = fk_produit.Montant_Total_HT ;
ajout_tmp.TVA = fk_produit.TVA ;
ajout_tmp.Timbre = fk_produit.Timbre ;
ajout_tmp.Total_TTC = fk_produit.Total_TTC ;
ajout_tmp.Type = fk_produit.Type ;
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
                    pstmt_tDBOutput_1.setInt(1, ajout.Id_Produit);

                    pstmt_tDBOutput_1.setInt(2, ajout.Id_Entreprise);

                    pstmt_tDBOutput_1.setInt(3, ajout.Date_Key);

                    if(ajout.Num_facture == null) {
pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(4, ajout.Num_facture);
}

                    if(ajout.Quantite == null) {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(5, ajout.Quantite);
}

                    if(ajout.Prix_Total_HT == null) {
pstmt_tDBOutput_1.setNull(6, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(6, ajout.Prix_Total_HT);
}

                    if(ajout.Montant_Total_HT == null) {
pstmt_tDBOutput_1.setNull(7, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(7, ajout.Montant_Total_HT);
}

                    if(ajout.TVA == null) {
pstmt_tDBOutput_1.setNull(8, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(8, ajout.TVA);
}

                    if(ajout.Timbre == null) {
pstmt_tDBOutput_1.setNull(9, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(9, ajout.Timbre);
}

                    if(ajout.Total_TTC == null) {
pstmt_tDBOutput_1.setNull(10, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(10, ajout.Total_TTC);
}

                    if(ajout.Type == null) {
pstmt_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(11, ajout.Type);
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

} // End of branch "fk_produit"




	
	/**
	 * [tMap_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_end ] stop
 */

} // End of branch "fk_entreprise"




	
	/**
	 * [tMap_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_end ] stop
 */

} // End of branch "fk_date"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_end ] stop
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
	 * [tLogRow_1 end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	


//////
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out1");
			  	}
			  	
 

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());




/**
 * [tLogRow_1 end ] stop
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"fk_date");
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"fk_entreprise");
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"fk_produit");
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
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 finally ] stop
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
	


public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_VenteB2B = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[0];
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
		final row3Struct other = (row3Struct) obj;
		
						if (this.Full_Date == null) {
							if (other.Full_Date != null)
								return false;
						
						} else if (!this.Full_Date.equals(other.Full_Date))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

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

	public void copyKeysDataTo(row3Struct other) {

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

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
					this.Full_Date = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

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
    public int compareTo(row3Struct other) {

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
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_2 - inputs:(row2,row3) outputs:(fk_date)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:a9PBsvoXQueyo/7qa7l2ZjzEHkqM3nIystSduarVzvFyEuFM");
				
				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;
				
		    String port_tDBInput_2 = "1433";
		    String dbname_tDBInput_2 = "Sougui_DWH" ;		    
		    String url_tDBInput_2 = "jdbc:sqlserver://" + "DESKTOP-LBCVIS5" ;
		    if (!"".equals(port_tDBInput_2)) {
		    	url_tDBInput_2 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_2)) {		    
		    	url_tDBInput_2 += ";databaseName=" + "Sougui_DWH"; 
		    }
		    url_tDBInput_2 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
		    String dbschema_tDBInput_2 = "dbo";
				
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2,dbUser_tDBInput_2,dbPwd_tDBInput_2);
		        
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT dbo.Dim_Date.Date_Key,\n		dbo.Dim_Date.Full_Date,\n		dbo.Dim_Date.Jour,\n		dbo.Dim_Date.Nom_Jour,\n		dbo.Dim_Date.Jo"
+"ur_Semaine,\n		dbo.Dim_Date.Semaine_Annee,\n		dbo.Dim_Date.Mois,\n		dbo.Dim_Date.Nom_Mois,\n		dbo.Dim_Date.Trimestre,\n		dbo."
+"Dim_Date.Annee,\n		dbo.Dim_Date.Est_Weekend\nFROM	dbo.Dim_Date";
		    

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
								row3.Date_Key = 0;
							} else {
		                          
            row3.Date_Key = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row3.Full_Date = null;
							} else {
										
			row3.Full_Date = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 2);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row3.Jour = null;
							} else {
		                          
            row3.Jour = rs_tDBInput_2.getInt(3);
            if(rs_tDBInput_2.wasNull()){
                    row3.Jour = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row3.Nom_Jour = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(4);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Nom_Jour = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.Nom_Jour = tmpContent_tDBInput_2;
                }
            } else {
                row3.Nom_Jour = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row3.Jour_Semaine = null;
							} else {
		                          
            row3.Jour_Semaine = rs_tDBInput_2.getInt(5);
            if(rs_tDBInput_2.wasNull()){
                    row3.Jour_Semaine = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row3.Semaine_Annee = null;
							} else {
		                          
            row3.Semaine_Annee = rs_tDBInput_2.getInt(6);
            if(rs_tDBInput_2.wasNull()){
                    row3.Semaine_Annee = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row3.Mois = null;
							} else {
		                          
            row3.Mois = rs_tDBInput_2.getInt(7);
            if(rs_tDBInput_2.wasNull()){
                    row3.Mois = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row3.Nom_Mois = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(8);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Nom_Mois = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.Nom_Mois = tmpContent_tDBInput_2;
                }
            } else {
                row3.Nom_Mois = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row3.Trimestre = null;
							} else {
		                          
            row3.Trimestre = rs_tDBInput_2.getInt(9);
            if(rs_tDBInput_2.wasNull()){
                    row3.Trimestre = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row3.Annee = null;
							} else {
		                          
            row3.Annee = rs_tDBInput_2.getInt(10);
            if(rs_tDBInput_2.wasNull()){
                    row3.Annee = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row3.Est_Weekend = null;
							} else {
	                         		
            row3.Est_Weekend = rs_tDBInput_2.getBoolean(11);
            if(rs_tDBInput_2.wasNull()){
                    row3.Est_Weekend = null;
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
	 * [tAdvancedHash_row3 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					


			   
			   

					row3Struct row3_HashRow = new row3Struct();
		   	   	   
				
				row3_HashRow.Date_Key = row3.Date_Key;
				
				row3_HashRow.Full_Date = row3.Full_Date;
				
				row3_HashRow.Jour = row3.Jour;
				
				row3_HashRow.Nom_Jour = row3.Nom_Jour;
				
				row3_HashRow.Jour_Semaine = row3.Jour_Semaine;
				
				row3_HashRow.Semaine_Annee = row3.Semaine_Annee;
				
				row3_HashRow.Mois = row3.Mois;
				
				row3_HashRow.Nom_Mois = row3.Nom_Mois;
				
				row3_HashRow.Trimestre = row3.Trimestre;
				
				row3_HashRow.Annee = row3.Annee;
				
				row3_HashRow.Est_Weekend = row3.Est_Weekend;
				
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
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
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
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_VenteB2B = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int Id_Client;

				public int getId_Client () {
					return this.Id_Client;
				}
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Matricule_fiscal;

				public String getMatricule_fiscal () {
					return this.Matricule_fiscal;
				}
				
			    public String Adresse;

				public String getAdresse () {
					return this.Adresse;
				}
				
			    public Double Latitude;

				public Double getLatitude () {
					return this.Latitude;
				}
				
			    public Double Longitude;

				public Double getLongitude () {
					return this.Longitude;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.Nom == null) ? 0 : this.Nom.hashCode());
					
						result = prime * result + ((this.Matricule_fiscal == null) ? 0 : this.Matricule_fiscal.hashCode());
					
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
		
						if (this.Nom == null) {
							if (other.Nom != null)
								return false;
						
						} else if (!this.Nom.equals(other.Nom))
						
							return false;
					
						if (this.Matricule_fiscal == null) {
							if (other.Matricule_fiscal != null)
								return false;
						
						} else if (!this.Matricule_fiscal.equals(other.Matricule_fiscal))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

		other.Id_Client = this.Id_Client;
	            other.Nom = this.Nom;
	            other.Matricule_fiscal = this.Matricule_fiscal;
	            other.Adresse = this.Adresse;
	            other.Latitude = this.Latitude;
	            other.Longitude = this.Longitude;
	            
	}

	public void copyKeysDataTo(row4Struct other) {

		other.Nom = this.Nom;
	            	other.Matricule_fiscal = this.Matricule_fiscal;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
					this.Nom = readString(dis);
					
					this.Matricule_fiscal = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
					this.Nom = readString(dis);
					
					this.Matricule_fiscal = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Matricule_fiscal,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Nom,dos);
					
					// String
				
						writeString(this.Matricule_fiscal,dos);
					
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
		
			            this.Id_Client = dis.readInt();
					
						this.Adresse = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Latitude = null;
           				} else {
           			    	this.Latitude = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Longitude = null;
           				} else {
           			    	this.Longitude = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.Id_Client = objectIn.readInt();
					
						this.Adresse = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Latitude = null;
           				} else {
           			    	this.Latitude = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Longitude = null;
           				} else {
           			    	this.Longitude = objectIn.readDouble();
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

		
		            	dos.writeInt(this.Id_Client);
					
						writeString(this.Adresse, dos, oos);
					
						if(this.Latitude == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.Latitude);
		            	}
					
						if(this.Longitude == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.Longitude);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.Id_Client);
					
						writeString(this.Adresse, dos, objectOut);
					
						if(this.Latitude == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.Latitude);
		            	}
					
						if(this.Longitude == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.Longitude);
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
		sb.append("Id_Client="+String.valueOf(Id_Client));
		sb.append(",Nom="+Nom);
		sb.append(",Matricule_fiscal="+Matricule_fiscal);
		sb.append(",Adresse="+Adresse);
		sb.append(",Latitude="+String.valueOf(Latitude));
		sb.append(",Longitude="+String.valueOf(Longitude));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Nom, other.Nom);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Matricule_fiscal, other.Matricule_fiscal);
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
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
			   		// linked node: tMap_3 - inputs:(fk_date,row4) outputs:(fk_entreprise)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row4Struct>getLookup(matchingModeEnum_row4);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row4 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:mJGnd8oRxrNRjv/qN3IhOeqp1LOWstLS2T6y97j439d4Po7X");
				
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

		    String dbquery_tDBInput_3 = "SELECT dbo.Dim_Entreprise.Id_Client,\n		dbo.Dim_Entreprise.Nom,\n		dbo.Dim_Entreprise.Matricule_fiscal,\n		dbo.Dim_Entrepr"
+"ise.Adresse\nFROM	dbo.Dim_Entreprise";
		    

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
								row4.Id_Client = 0;
							} else {
		                          
            row4.Id_Client = rs_tDBInput_3.getInt(1);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row4.Nom = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(2);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.Nom = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row4.Nom = tmpContent_tDBInput_3;
                }
            } else {
                row4.Nom = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								row4.Matricule_fiscal = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(3);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.Matricule_fiscal = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row4.Matricule_fiscal = tmpContent_tDBInput_3;
                }
            } else {
                row4.Matricule_fiscal = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								row4.Adresse = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(4);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.Adresse = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row4.Adresse = tmpContent_tDBInput_3;
                }
            } else {
                row4.Adresse = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								row4.Latitude = null;
							} else {
	                         		
            row4.Latitude = rs_tDBInput_3.getDouble(5);
            if(rs_tDBInput_3.wasNull()){
                    row4.Latitude = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 6) {
								row4.Longitude = null;
							} else {
	                         		
            row4.Longitude = rs_tDBInput_3.getDouble(6);
            if(rs_tDBInput_3.wasNull()){
                    row4.Longitude = null;
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
	 * [tAdvancedHash_row4 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					


			   
			   

					row4Struct row4_HashRow = new row4Struct();
		   	   	   
				
				row4_HashRow.Id_Client = row4.Id_Client;
				
				row4_HashRow.Nom = row4.Nom;
				
				row4_HashRow.Matricule_fiscal = row4.Matricule_fiscal;
				
				row4_HashRow.Adresse = row4.Adresse;
				
				row4_HashRow.Latitude = row4.Latitude;
				
				row4_HashRow.Longitude = row4.Longitude;
				
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
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
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
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class row5Struct implements routines.system.IPersistableComparableLookupRow<row5Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_VenteB2B = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[0];
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
				
			    public String Nom;

				public String getNom () {
					return this.Nom;
				}
				
			    public String Categorie;

				public String getCategorie () {
					return this.Categorie;
				}
				
			    public String Source;

				public String getSource () {
					return this.Source;
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
		final row5Struct other = (row5Struct) obj;
		
						if (this.Reference == null) {
							if (other.Reference != null)
								return false;
						
						} else if (!this.Reference.equals(other.Reference))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row5Struct other) {

		other.Id_Produit = this.Id_Produit;
	            other.Reference = this.Reference;
	            other.Description = this.Description;
	            other.PU_HT = this.PU_HT;
	            other.Nom = this.Nom;
	            other.Categorie = this.Categorie;
	            other.Source = this.Source;
	            
	}

	public void copyKeysDataTo(row5Struct other) {

		other.Reference = this.Reference;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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
			if(length > commonByteArray_SOUGUIETL_Fact_VenteB2B.length) {
				if(length < 1024 && commonByteArray_SOUGUIETL_Fact_VenteB2B.length == 0) {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[1024];
				} else {
   					commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length);
			strReturn = new String(commonByteArray_SOUGUIETL_Fact_VenteB2B, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
					this.Reference = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

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
					
						this.Nom = readString(dis,ois);
					
						this.Categorie = readString(dis,ois);
					
						this.Source = readString(dis,ois);
					
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
					
						this.Nom = readString(dis,objectIn);
					
						this.Categorie = readString(dis,objectIn);
					
						this.Source = readString(dis,objectIn);
					
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
					
						writeString(this.Nom, dos, oos);
					
						writeString(this.Categorie, dos, oos);
					
						writeString(this.Source, dos, oos);
					
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
					
						writeString(this.Nom, dos, objectOut);
					
						writeString(this.Categorie, dos, objectOut);
					
						writeString(this.Source, dos, objectOut);
					
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
		sb.append(",Nom="+Nom);
		sb.append(",Categorie="+Categorie);
		sb.append(",Source="+Source);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row5Struct other) {

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
			   		// source node:tDBInput_4 - inputs:(after_tDBInput_1) outputs:(row5,row5) | target node:tAdvancedHash_row5 - inputs:(row5) outputs:()
			   		// linked node: tMap_4 - inputs:(fk_entreprise,row5) outputs:(fk_produit)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row5 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row5Struct>getLookup(matchingModeEnum_row5);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row5", tHash_Lookup_row5);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row5 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:/2bR1M0gPr+F/irKD0n7KEh5zSr7hqNvFNKXrEFN2pHXc+N4");
				
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
								row5.Id_Produit = 0;
							} else {
		                          
            row5.Id_Produit = rs_tDBInput_4.getInt(1);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								row5.Reference = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(2);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.Reference = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row5.Reference = tmpContent_tDBInput_4;
                }
            } else {
                row5.Reference = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								row5.Description = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(3);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.Description = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row5.Description = tmpContent_tDBInput_4;
                }
            } else {
                row5.Description = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								row5.PU_HT = null;
							} else {
		                          
            row5.PU_HT = rs_tDBInput_4.getFloat(4);
            if(rs_tDBInput_4.wasNull()){
                    row5.PU_HT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 5) {
								row5.Nom = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(5);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.Nom = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row5.Nom = tmpContent_tDBInput_4;
                }
            } else {
                row5.Nom = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 6) {
								row5.Categorie = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(6);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.Categorie = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row5.Categorie = tmpContent_tDBInput_4;
                }
            } else {
                row5.Categorie = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 7) {
								row5.Source = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(7);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.Source = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row5.Source = tmpContent_tDBInput_4;
                }
            } else {
                row5.Source = null;
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
	 * [tAdvancedHash_row5 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					


			   
			   

					row5Struct row5_HashRow = new row5Struct();
		   	   	   
				
				row5_HashRow.Id_Produit = row5.Id_Produit;
				
				row5_HashRow.Reference = row5.Reference;
				
				row5_HashRow.Description = row5.Description;
				
				row5_HashRow.PU_HT = row5.PU_HT;
				
				row5_HashRow.Nom = row5.Nom;
				
				row5_HashRow.Categorie = row5.Categorie;
				
				row5_HashRow.Source = row5.Source;
				
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
	 * [tDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 finally ] stop
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
		

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public static class row6Struct implements routines.system.IPersistableComparableLookupRow<row6Struct> {
    final static byte[] commonByteArrayLock_SOUGUIETL_Fact_VenteB2B = new byte[0];
    static byte[] commonByteArray_SOUGUIETL_Fact_VenteB2B = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int Date_Key;

				public int getDate_Key () {
					return this.Date_Key;
				}
				
			    public int Id_Entreprise;

				public int getId_Entreprise () {
					return this.Id_Entreprise;
				}
				
			    public int Id_Produit;

				public int getId_Produit () {
					return this.Id_Produit;
				}
				
			    public String Num_facture;

				public String getNum_facture () {
					return this.Num_facture;
				}
				
			    public Float Quantite;

				public Float getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_Total_HT;

				public Float getPrix_Total_HT () {
					return this.Prix_Total_HT;
				}
				
			    public Float Montant_Total_HT;

				public Float getMontant_Total_HT () {
					return this.Montant_Total_HT;
				}
				
			    public Float TVA;

				public Float getTVA () {
					return this.TVA;
				}
				
			    public Float Timbre;

				public Float getTimbre () {
					return this.Timbre;
				}
				
			    public Float Total_TTC;

				public Float getTotal_TTC () {
					return this.Total_TTC;
				}
				
			    public String Type;

				public String getType () {
					return this.Type;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.Date_Key;
						
							result = prime * result + (int) this.Id_Entreprise;
						
							result = prime * result + (int) this.Id_Produit;
						
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
		
						if (this.Date_Key != other.Date_Key)
							return false;
					
						if (this.Id_Entreprise != other.Id_Entreprise)
							return false;
					
						if (this.Id_Produit != other.Id_Produit)
							return false;
					

		return true;
    }

	public void copyDataTo(row6Struct other) {

		other.Date_Key = this.Date_Key;
	            other.Id_Entreprise = this.Id_Entreprise;
	            other.Id_Produit = this.Id_Produit;
	            other.Num_facture = this.Num_facture;
	            other.Quantite = this.Quantite;
	            other.Prix_Total_HT = this.Prix_Total_HT;
	            other.Montant_Total_HT = this.Montant_Total_HT;
	            other.TVA = this.TVA;
	            other.Timbre = this.Timbre;
	            other.Total_TTC = this.Total_TTC;
	            other.Type = this.Type;
	            
	}

	public void copyKeysDataTo(row6Struct other) {

		other.Date_Key = this.Date_Key;
	            	other.Id_Entreprise = this.Id_Entreprise;
	            	other.Id_Produit = this.Id_Produit;
	            	
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

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
			        this.Date_Key = dis.readInt();
					
			        this.Id_Entreprise = dis.readInt();
					
			        this.Id_Produit = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SOUGUIETL_Fact_VenteB2B) {

        	try {

        		int length = 0;
		
			        this.Date_Key = dis.readInt();
					
			        this.Id_Entreprise = dis.readInt();
					
			        this.Id_Produit = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.Date_Key);
					
					// int
				
		            	dos.writeInt(this.Id_Entreprise);
					
					// int
				
		            	dos.writeInt(this.Id_Produit);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.Date_Key);
					
					// int
				
		            	dos.writeInt(this.Id_Entreprise);
					
					// int
				
		            	dos.writeInt(this.Id_Produit);
					
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
		
						this.Num_facture = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantite = null;
           				} else {
           			    	this.Quantite = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = dis.readFloat();
           				}
					
						this.Type = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.Num_facture = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Quantite = null;
           				} else {
           			    	this.Quantite = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Prix_Total_HT = null;
           				} else {
           			    	this.Prix_Total_HT = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Montant_Total_HT = null;
           				} else {
           			    	this.Montant_Total_HT = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.TVA = null;
           				} else {
           			    	this.TVA = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Timbre = null;
           				} else {
           			    	this.Timbre = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Total_TTC = null;
           				} else {
           			    	this.Total_TTC = objectIn.readFloat();
           				}
					
						this.Type = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.Num_facture, dos, oos);
					
						if(this.Quantite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Quantite);
		            	}
					
						if(this.Prix_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_Total_HT);
		            	}
					
						if(this.Montant_Total_HT == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant_Total_HT);
		            	}
					
						if(this.TVA == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.TVA);
		            	}
					
						if(this.Timbre == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Timbre);
		            	}
					
						if(this.Total_TTC == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Total_TTC);
		            	}
					
						writeString(this.Type, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.Num_facture, dos, objectOut);
					
						if(this.Quantite == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.Quantite);
		            	}
					
						if(this.Prix_Total_HT == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.Prix_Total_HT);
		            	}
					
						if(this.Montant_Total_HT == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.Montant_Total_HT);
		            	}
					
						if(this.TVA == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.TVA);
		            	}
					
						if(this.Timbre == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.Timbre);
		            	}
					
						if(this.Total_TTC == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.Total_TTC);
		            	}
					
						writeString(this.Type, dos, objectOut);
					
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
		sb.append(",Id_Entreprise="+String.valueOf(Id_Entreprise));
		sb.append(",Id_Produit="+String.valueOf(Id_Produit));
		sb.append(",Num_facture="+Num_facture);
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_Total_HT="+String.valueOf(Prix_Total_HT));
		sb.append(",Montant_Total_HT="+String.valueOf(Montant_Total_HT));
		sb.append(",TVA="+String.valueOf(TVA));
		sb.append(",Timbre="+String.valueOf(Timbre));
		sb.append(",Total_TTC="+String.valueOf(Total_TTC));
		sb.append(",Type="+Type);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row6Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Date_Key, other.Date_Key);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Id_Entreprise, other.Id_Entreprise);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Id_Produit, other.Id_Produit);
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
			   		// source node:tDBInput_5 - inputs:(after_tDBInput_1) outputs:(row6,row6) | target node:tAdvancedHash_row6 - inputs:(row6) outputs:()
			   		// linked node: tMap_5 - inputs:(fk_produit,row6) outputs:(ajout)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row6 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row6Struct>getLookup(matchingModeEnum_row6);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row6", tHash_Lookup_row6);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row6 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_5 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:6rfK5lCSuWGWwDfqq4niL0w79iw6K1/O5tjE/HPzJoaXmSif");
				
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

		    String dbquery_tDBInput_5 = "SELECT \n		dbo.Fact_Vente_B2B.Date_Key,\n		dbo.Fact_Vente_B2B.Id_Entreprise,\n		dbo.Fact_Vente_B2B.Id_Produit,\n		dbo.Fact_"
+"Vente_B2B.Num_facture,\n		dbo.Fact_Vente_B2B.Quantite,\n		dbo.Fact_Vente_B2B.Prix_Total_HT,\n		dbo.Fact_Vente_B2B.Montant_T"
+"otal_HT,\n		dbo.Fact_Vente_B2B.TVA,\n		dbo.Fact_Vente_B2B.Timbre,\n		dbo.Fact_Vente_B2B.Total_TTC,\n		dbo.Fact_Vente_B2B.Typ"
+"e\nFROM	dbo.Fact_Vente_B2B";
		    

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
								row6.Date_Key = 0;
							} else {
		                          
            row6.Date_Key = rs_tDBInput_5.getInt(1);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 2) {
								row6.Id_Entreprise = 0;
							} else {
		                          
            row6.Id_Entreprise = rs_tDBInput_5.getInt(2);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 3) {
								row6.Id_Produit = 0;
							} else {
		                          
            row6.Id_Produit = rs_tDBInput_5.getInt(3);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 4) {
								row6.Num_facture = null;
							} else {
	                         		
           		tmpContent_tDBInput_5 = rs_tDBInput_5.getString(4);
            if(tmpContent_tDBInput_5 != null) {
            	if (talendToDBList_tDBInput_5 .contains(rsmd_tDBInput_5.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row6.Num_facture = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
            	} else {
                	row6.Num_facture = tmpContent_tDBInput_5;
                }
            } else {
                row6.Num_facture = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 5) {
								row6.Quantite = null;
							} else {
		                          
            row6.Quantite = rs_tDBInput_5.getFloat(5);
            if(rs_tDBInput_5.wasNull()){
                    row6.Quantite = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 6) {
								row6.Prix_Total_HT = null;
							} else {
		                          
            row6.Prix_Total_HT = rs_tDBInput_5.getFloat(6);
            if(rs_tDBInput_5.wasNull()){
                    row6.Prix_Total_HT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 7) {
								row6.Montant_Total_HT = null;
							} else {
		                          
            row6.Montant_Total_HT = rs_tDBInput_5.getFloat(7);
            if(rs_tDBInput_5.wasNull()){
                    row6.Montant_Total_HT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 8) {
								row6.TVA = null;
							} else {
		                          
            row6.TVA = rs_tDBInput_5.getFloat(8);
            if(rs_tDBInput_5.wasNull()){
                    row6.TVA = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 9) {
								row6.Timbre = null;
							} else {
		                          
            row6.Timbre = rs_tDBInput_5.getFloat(9);
            if(rs_tDBInput_5.wasNull()){
                    row6.Timbre = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 10) {
								row6.Total_TTC = null;
							} else {
		                          
            row6.Total_TTC = rs_tDBInput_5.getFloat(10);
            if(rs_tDBInput_5.wasNull()){
                    row6.Total_TTC = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 11) {
								row6.Type = null;
							} else {
	                         		
           		tmpContent_tDBInput_5 = rs_tDBInput_5.getString(11);
            if(tmpContent_tDBInput_5 != null) {
            	if (talendToDBList_tDBInput_5 .contains(rsmd_tDBInput_5.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
            		row6.Type = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
            	} else {
                	row6.Type = tmpContent_tDBInput_5;
                }
            } else {
                row6.Type = null;
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
	 * [tAdvancedHash_row6 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row6"
						
						);
					}
					


			   
			   

					row6Struct row6_HashRow = new row6Struct();
		   	   	   
				
				row6_HashRow.Date_Key = row6.Date_Key;
				
				row6_HashRow.Id_Entreprise = row6.Id_Entreprise;
				
				row6_HashRow.Id_Produit = row6.Id_Produit;
				
				row6_HashRow.Num_facture = row6.Num_facture;
				
				row6_HashRow.Quantite = row6.Quantite;
				
				row6_HashRow.Prix_Total_HT = row6.Prix_Total_HT;
				
				row6_HashRow.Montant_Total_HT = row6.Montant_Total_HT;
				
				row6_HashRow.TVA = row6.TVA;
				
				row6_HashRow.Timbre = row6.Timbre;
				
				row6_HashRow.Total_TTC = row6.Total_TTC;
				
				row6_HashRow.Type = row6.Type;
				
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
	 * [tDBInput_5 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 finally ] stop
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
		

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
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
        final Fact_VenteB2B Fact_VenteB2BClass = new Fact_VenteB2B();

        int exitCode = Fact_VenteB2BClass.runJobInTOS(args);

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
            java.io.InputStream inContext = Fact_VenteB2B.class.getClassLoader().getResourceAsStream("souguietl/fact_venteb2b_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Fact_VenteB2B.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Fact_VenteB2B");
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
 *     322810 characters generated by Talend Open Studio for Data Integration 
 *     on the 22 mars 2026 à 16:45:14 WAT
 ************************************************************************************************/