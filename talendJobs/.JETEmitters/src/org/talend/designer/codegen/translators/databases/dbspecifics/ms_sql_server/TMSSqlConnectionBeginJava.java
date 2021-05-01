package org.talend.designer.codegen.translators.databases.dbspecifics.ms_sql_server;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMSSqlConnectionBeginJava
{
  protected static String nl;
  public static synchronized TMSSqlConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMSSqlConnectionBeginJava result = new TMSSqlConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\tString driverClass_";
  protected final String TEXT_3 = " = \"";
  protected final String TEXT_4 = "\";" + NL + "\t\t\tjava.lang.Class jdbcclazz_";
  protected final String TEXT_5 = " = java.lang.Class.forName(driverClass_";
  protected final String TEXT_6 = ");" + NL + "\t\t\tglobalMap.put(\"driverClass_";
  protected final String TEXT_7 = "\", driverClass_";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\t\t\tSharedDBConnectionLog4j.initLogger(log.getName(),\"";
  protected final String TEXT_10 = "\");";
  protected final String TEXT_11 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_14 = ".getDBConnection(\"";
  protected final String TEXT_15 = "\",url_";
  protected final String TEXT_16 = ",dbUser_";
  protected final String TEXT_17 = " , dbPwd_";
  protected final String TEXT_18 = " , sharedConnectionName_";
  protected final String TEXT_19 = NL + "\t\t\tconn_";
  protected final String TEXT_20 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_21 = ",dbPwd_";
  protected final String TEXT_22 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_23 = " - Connection is set auto commit to '";
  protected final String TEXT_24 = "'.\");";
  protected final String TEXT_25 = ".setAutoCommit(";
  protected final String TEXT_26 = NL + "\t\t\tString url_";
  protected final String TEXT_27 = " = \"jdbc:jtds:sqlserver://\" + ";
  protected final String TEXT_28 = " ;";
  protected final String TEXT_29 = "\t\t    " + NL + "\t\t    String url_";
  protected final String TEXT_30 = " = \"jdbc:sqlserver://\" + ";
  protected final String TEXT_31 = NL + "\t\tString port_";
  protected final String TEXT_32 = ";" + NL + "\t\tString dbname_";
  protected final String TEXT_33 = " ;" + NL + "    \tif (!\"\".equals(port_";
  protected final String TEXT_34 = ")) {" + NL + "    \t\turl_";
  protected final String TEXT_35 = " += \":\" + ";
  protected final String TEXT_36 = ";" + NL + "    \t}" + NL + "    \tif (!\"\".equals(dbname_";
  protected final String TEXT_37 = ")) {" + NL + "    \t\t";
  protected final String TEXT_38 = NL + "\t\t\t\turl_";
  protected final String TEXT_39 = " += \"//\" + ";
  protected final String TEXT_40 = "; ";
  protected final String TEXT_41 = "\t\t    " + NL + "\t\t    \turl_";
  protected final String TEXT_42 = " += \";databaseName=\" + ";
  protected final String TEXT_43 = NL + "    \t}" + NL + "\t\turl_";
  protected final String TEXT_44 = " += \";appName=\" + projectName + \";\" + ";
  protected final String TEXT_45 = ";  ";
  protected final String TEXT_46 = NL + NL + "\t";
  protected final String TEXT_47 = NL + "\tString dbUser_";
  protected final String TEXT_48 = ";";
  protected final String TEXT_49 = NL + "\t" + NL + "\t";
  protected final String TEXT_50 = NL + "\t\tString dbPwd_";
  protected final String TEXT_51 = " = null;" + NL + "\t";
  protected final String TEXT_52 = NL + "\t\t";
  protected final String TEXT_53 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_54 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_55 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_56 = " = decryptedPassword_";
  protected final String TEXT_57 = ";" + NL + "\t";
  protected final String TEXT_58 = NL + "\t" + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_59 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_60 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_61 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_62 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_63 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_64 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_65 = " - Written records count: \" + nb_line_";
  protected final String TEXT_66 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_67 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_68 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_69 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_70 = " - Writing the record \" + nb_line_";
  protected final String TEXT_71 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_72 = " - Processing the record \" + nb_line_";
  protected final String TEXT_73 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_74 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_75 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_76 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_77 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_79 = " - Uses an existing connection ";
  protected final String TEXT_80 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_82 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_83 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_84 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_86 = ", dbUser_";
  protected final String TEXT_87 = ", dbPwd_";
  protected final String TEXT_88 = ");" + NL + "\t\t\t";
  protected final String TEXT_89 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_90 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_91 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\tif(\"com.mysql.cj.jdbc.Driver\".equals((String)globalMap.get(\"driverClass_";
  protected final String TEXT_93 = "\"))" + NL + "\t\t\t    && routines.system.BundleUtils.inOSGi()) {" + NL + "\t\t\t        Class.forName(\"com.mysql.cj.jdbc.AbandonedConnectionCleanupThread\")." + NL + "\t\t\t            getMethod(\"checkedShutdown\").invoke(null, (Object[]) null);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\tconn_";
  protected final String TEXT_95 = NL + "\t\t\t\tlog.";
  protected final String TEXT_96 = "(\"";
  protected final String TEXT_97 = " - \" + ";
  protected final String TEXT_98 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_99 = NL + "\t    \t\tlog.";
  protected final String TEXT_100 = "\");" + NL + "\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_102 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_104 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_105 = ": pstmt_";
  protected final String TEXT_106 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_107 = " += (countEach_";
  protected final String TEXT_108 = " < 0 ? 0 : ";
  protected final String TEXT_109 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_110 = NL + "\t";
  protected final String TEXT_111 = NL + "\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_112 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\tif (dataSources_";
  protected final String TEXT_113 = " == null) {";
  protected final String TEXT_114 = NL + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_115 = "\", conn_";
  protected final String TEXT_116 = NL + "\t} else {" + NL + "\t\tString dsAlias_";
  protected final String TEXT_117 = ";" + NL + "\t\tif (dataSources_";
  protected final String TEXT_118 = ".get(dsAlias_";
  protected final String TEXT_119 = ") == null) {" + NL + "   \t\t\tthrow new Exception(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_120 = " + \" available!\");" + NL + "      \t}" + NL + "\t\tconn_";
  protected final String TEXT_121 = " = dataSources_";
  protected final String TEXT_122 = ").getConnection();" + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_123 = ");" + NL + "\t}";
  protected final String TEXT_124 = NL + "\tif (null != conn_";
  protected final String TEXT_125 = ") {" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t}";
  protected final String TEXT_127 = NL + NL + "\tglobalMap.put(\"dbschema_";
  protected final String TEXT_128 = "\", ";
  protected final String TEXT_129 = ");" + NL + "" + NL + "\tglobalMap.put(\"db_";
  protected final String TEXT_130 = "\",  ";
  protected final String TEXT_131 = ");" + NL + "" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_132 = "\",conn_";
  protected final String TEXT_133 = ");" + NL + "\t" + NL + "\tglobalMap.put(\"shareIdentitySetting_";
  protected final String TEXT_134 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	class DefaultConnectionUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected boolean isLog4jEnabled;
	    
	    public void beforeComponentProcess(INode node){
	    }
	    
		public void createURL(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
		
		public void classForName(INode node){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
			newInstance(node);
		}
		
		protected void newInstance(INode node) {
			//do nothing as default
			//for sybase jdbc in java 11, we have to call jdbcclazz.newInstance method
		}
		
		//for example, postgresql jdbc and redshift jdbc both can process the url : jdbc:postgresql://, 
		//we need to adjust the register order to make sure to use postgresql jdbc to process it
		public void adjustDriverRegisterOrderForConflcit() {
		
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");
			String shareDBClass = "SharedDBConnection";
			if(isLog4jEnabled){
				shareDBClass = "SharedDBConnectionLog4j";

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
		}
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_24);
    
			}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_8);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    
	class ConnectionUtil extends DefaultConnectionUtil{
	
		public void createURL(INode node) {
			super.createURL(node);
			String driver = ElementParameterParser.getValue(node, "__DRIVER__");

    
			if(driver.equals("JTDS")) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_28);
    
			} else {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_28);
    
			}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
			if(driver.equals("JTDS")) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_40);
    
			} else {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_40);
    
			}

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_45);
    	
		}
	
		public String getDirverClassName(INode node){
			String driver = ElementParameterParser.getValue(node, "__DRIVER__");
			if(driver.equals("JTDS")) {
				return "net.sourceforge.jtds.jdbc.Driver";
			}
			return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		}
		
	}//end class
	
	connUtil = new ConnectionUtil();

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_46);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    if(dbschema == null||dbschema.trim().length()==0) {
    	 dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
    }
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));

    
	connUtil.beforeComponentProcess(node);
	connUtil.createURL(node);

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_48);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_49);
    if(dbpass != null && dbpass.trim().length() == 0) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    } else {
		String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_52);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    } else {
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_60);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_69);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_80);
    } else {
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
			connect_end();
		}
		
		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
     /* TESB-24900 - graceful shutdown for MYSQL connection */ 
    stringBuffer.append(TEXT_92);
    stringBuffer.append((connection!=null)?connection.replaceAll("'","").trim():"");
    stringBuffer.append(TEXT_93);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_88);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_95);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_98);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_99);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_100);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_109);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	connUtil.adjustDriverRegisterOrderForConflcit();
	
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_110);
    connUtil.useShareConnection(node);
    
	} else {
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
		}

    stringBuffer.append(TEXT_52);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_52);
    
		log4jCodeGenerateUtil.debugConnectionParams(node);
		log4jCodeGenerateUtil.connect_begin();
        connUtil.createConnection(node);
		
		log4jCodeGenerateUtil.connect_end();
		
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
		}
	}

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_126);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SHARE_IDENTITY_SETTING__"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_134);
    return stringBuffer.toString();
  }
}
