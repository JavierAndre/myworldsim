package myworldsim;

import java.util.LinkedList;
import java.util.List;

public class SQLDBRowModel {

	/*
	 * Class Instance Variables
	 * 
	 */
	
	private List<SQLDBColModel> sqlTableRow;
	
	/*
	 * Constructor
	 * 
	 */
	
	public SQLDBRowModel() {
		
		sqlTableRow = new LinkedList<SQLDBColModel>();
	}
	
	/*
	 * Getters and Setters
	 * 
	 */
	
	public List<SQLDBColModel> getRow() {
		return sqlTableRow;
	}
	
	public void add(String name, Object object) {
		SQLDBColModel sqlDBColModel = new SQLDBColModel(name, object);
		sqlTableRow.add(sqlDBColModel);
	}
}
