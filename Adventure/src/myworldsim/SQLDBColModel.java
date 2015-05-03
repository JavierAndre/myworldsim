package myworldsim;

public class SQLDBColModel {
	
	/*
	 * Class Instance Variables
	 * 
	 */

	private String	sqlDBColName;
	private Object	sqlDBColValue;
	
	/*
	 * Constructors
	 * 
	 */
	
	public SQLDBColModel(String name, Object value) {
		
		sqlDBColName 	= name;
		sqlDBColValue	= value;
	}

	/*
	 * Getters
	 * 
	 */
	
	public String getSqlDBColName() {
		return sqlDBColName;
	}

	public Object getSqlDBColValue() {
		return sqlDBColValue;
	}
}
