package myworldsim;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.util.*;

public class SQLDBModel {

	/*
	 * Class Instance Variables
	 * 
	 */
	
	private Connection 			connection;
	private Statement 			statement;
	private PreparedStatement 	preparedStatement;
	private CallableStatement	callableStatement;
	private ResultSet 			resultSet;
	
	/*
	 * Class Constants
	 * 
	 */
	
	public final String			SQL_SERVER 							= "localhost";
	public final String			COMMANDS_DATABASE 					= "commands";
	public final String			DEFAULT_USER_NAME					= "root";
	public final String			DEFAULT_PASSWORD					= "root";
	
	public static final String	COMMANDS_TABLE 						= "COMMANDS";
	
	public static final String	COMMANDS_TABLE_COMMAND_ID			= "COMMAND_ID";
	public static final String	COMMANDS_TABLE_COMMAND_NAME			= "COMMAND_NAME";
	public static final String	COMMANDS_TABLE_PRIMARY_COMMAND_ID	= "PRIMARY_COMMAND_ID";
	public static final String	COMMANDS_TABLE_COMMAND_TEXT			= "COMMAND_TEXT";
	public static final String	COMMANDS_TABLE_DATE_ADDED 			= "DATE_ADDED";
	public static final String	COMMANDS_TABLE_DATE_LAST_UPDATED 	= "DATE_LAST_UPDATED";
	public static final String	COMMANDS_TABLE_ACTIVE 				= "ACTIVE";
	
	public static final String	NO_OPERATOR							= "";
	public static final String	LESS_THAN							= " < ";
	public static final String	LESS_THAN_EQUAL						= " <= ";
	public static final String	EQUAL_TO							= " = ";
	public static final String	NOT_EQUAL_TO						= " != ";
	public static final String	GREATER_THAN_EQUAL					= " >= ";
	public static final String	GREATER_THAN						= " > ";
	public static final String	AND									= " AND ";
	public static final String	OR									= " OR ";
	public static final String	NOT									= " NOT ";
	
	/*
	 * Constructors
	 * 
	 */
	
	public SQLDBModel() {
		
	}
	
	/*
	 * Connect
	 * 
	 */
	
	public boolean connect() {
	
		boolean connected = false;
		
		// Locate the JDBC
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("SQLDatabase::connect(): MySQL JDBC Driver found.");
			
			// Connect to the MySQL Server
			try {
				connection = DriverManager.getConnection("jdbc:mysql://" + SQL_SERVER + "/" + COMMANDS_DATABASE + "?", DEFAULT_USER_NAME, DEFAULT_PASSWORD);
				System.out.println("SQLDatabase::connect(): MySQL Server connected.");
				connected = true;
			}
			catch (SQLException e) {
				System.out.println("SQLDatabase::connect(): MySQL Server not connected.");
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("SQLDatabase::connect(): MySQL JDBC Driver not found.");
		}
		
		return connected;
	}
	
	/*
	 * Disconnect
	 * 
	 */
	
	public void disconnect() {
	
		if (connection != null) {
			
			// No need for a try/catch. No SQL exception thrown if MySQL Server is down.
			try{
				connection.close();
				connection = null;
			}
			catch (SQLException e) {
				System.out.println("SQLDatabase::disconnect(): Unable to disconnect from MySQL Server.");
			}
		}
		else {
			System.out.println("SQLDatabase::disconnect(): System error. Null connection to MySQL Server.");
		}
	}
	
	/*
	 * Generic CRUD Operations
	 * 
	 */
	
	public boolean add(String tableName, List<SQLDBColModel> model) {
		
		boolean added = false;
		
		if (connect()) {

			try {
				statement = connection.createStatement();
				
				String insertQuery = "INSERT INTO " + COMMANDS_DATABASE + "." + COMMANDS_TABLE;
				
				// Must use back accent on tilde key for columnNames.
				// Must use apostrophe for values.
				String queryValues = " VALUES(";
				
				for (int index = 0; index < model.size() - 1; index++) {
					queryValues = queryValues + "'" + model.get(index).getSqlDBColValue().toString() + "'" + ", ";
				}
				
				queryValues = queryValues + "'" + model.get(model.size() - 1).getSqlDBColValue().toString() + "'" + ")";
				
				insertQuery = insertQuery + queryValues;
				
				System.out.println(insertQuery);
				
				// Must call executeUpdate for insert
				statement.executeUpdate(insertQuery);
				added = true;
				disconnect();
			}
			catch (SQLException e) {
				System.out.println("SQLDatabase::addNoseCone(): MySQL INSERT INTO " + tableName + " table failed.");
				disconnect();
			}
		}
		
		return added;
	}
	
	public List<Object> get(String tableName) {
		
		// Build a list of SQL table rows from the SQL ResultSet. Each "row" will contain a list of SQL table column objects.
		// It is up to each Model to unwrap its own "row" and cast the column values to their original types.
		List<Object> list = new LinkedList<Object>();
		
		if (connect()) {

			try {
				// Call a Stored Procedure rather than execute a query
				callableStatement = connection.prepareCall("{call get_commands()}");
				boolean result = callableStatement.execute();
				
				if (result) {
					resultSet = callableStatement.getResultSet();
					
					ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
				    int numberOfCols 					= resultSetMetaData.getColumnCount();				
				    			    
				    // For each ResultSet SQL table row
					while (resultSet.next()) {

						SQLDBRowModel sqlTableRow = new SQLDBRowModel();
						
						// Retrieve each of its columns and build a list of SQL table column objects
						for (int col = 1; col <= numberOfCols; col++) {

							// Do not use getArray(), exception occurs, not implemented in MySQL
							String sqlColumnName	= resultSetMetaData.getColumnName(col);
							Object sqlColumnValue 	= resultSet.getObject(col);

							// Add the current column to the list of SQL table columns for the current SQL table row
							sqlTableRow.add(sqlColumnName, sqlColumnValue);
						}

						// Add the current SQL table row to the list of SQL table rows
						list.add(sqlTableRow);
					}
					
					disconnect();
				}
				
				// Execute a query. Does not fill in the primary command name.
				//statement = connection.createStatement();				
				//String selectQuery = "SELECT * FROM " + COMMANDS_DATABASE + "." + tableName + " WHERE ACTIVE = 1";
				//resultSet = statement.executeQuery(selectQuery);
				
				// Should not be necessary. resultSet.getRow() returns 0.
				//resultSet.beforeFirst();
				
				/*
				 * How to get the number of rows in the ResultSet
				 * resultSet.last();
				 * int numberOfRows = resultSet.getRow();
				 * resultSet.beforeFirst();
				*/
			}
			catch (SQLException e) {
				System.out.println("SQLDatabase::get(): MySQL SELECT all rows from " + tableName + " table failed.");
				disconnect();
			}
		}
		
		return list;
	}

	public List<Object> get(String tableName, String columnName, Object searchValue, String operator) {
		
		// Build a list of SQL table rows from the SQL ResultSet. Each "row" will contain a list of SQL table column objects.
		// It is up to each Model to unwrap its own "row" and cast the column values to their original types.
		List<Object> list = new LinkedList<Object>();
		
		if (connect()) {

			try {
				statement = connection.createStatement();
				
				String selectQuery = "SELECT * FROM " + COMMANDS_DATABASE + "." + COMMANDS_TABLE + " WHERE " + columnName + operator + "'" + searchValue + "'" + " AND ACTIVE = 1";			
				resultSet 	= statement.executeQuery(selectQuery);

				// Should not be necessary. resultSet.getRow() returns 0.
				//resultSet.beforeFirst();
				
				/*
				 * How to get the number of rows in the ResultSet
				 * resultSet.last();
				 * int numberOfRows = resultSet.getRow();
				 * resultSet.beforeFirst();
				*/

				ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			    int numberOfCols 					= resultSetMetaData.getColumnCount();				
			    			    
			    // For each ResultSet SQL table row
				while (resultSet.next()) {

					SQLDBRowModel sqlTableRow = new SQLDBRowModel();
					
					// Retrieve each of its columns and build a list of SQL table column objects
					for (int col = 1; col <= numberOfCols; col++) {

						// Do not use getArray(), exception occurs, not implemented in MySQL
						String sqlColumnName	= resultSetMetaData.getColumnName(col);
						Object sqlColumnValue 	= resultSet.getObject(col);

						// Add the current column to the list of SQL table columns for the current SQL table row
						sqlTableRow.add(sqlColumnName, sqlColumnValue);
					}

					// Add the current SQL table row to the list of SQL table rows
					list.add(sqlTableRow);
				}
				
				disconnect();
			}
			catch (SQLException e) {
				System.out.println("SQLDatabase::get(): MySQL SELECT from " + tableName + " WHERE " + columnName + " = '" + searchValue + "'" + " failed.");
				disconnect();
			}
		}
		
		return list;
	}
}
