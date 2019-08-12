package com.sandro.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
		
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("sca-beans.xml");
		
		JdbcConn jdbcConn = context.getBean("jdbcConn",com.sandro.test.JdbcConn.class);
		jdbcConn.showInfo();
		
		Main tester = new Main();
		tester.getJdbcConnection(jdbcConn);
	}

	public void getJdbcConnection (JdbcConn jdbcConn) {
		
		try {
			Class.forName(jdbcConn.getDriver());

			//Connection conn = DriverManager.getConnection(jdbcConn.getUrl(), jdbcConn.getUser(), jdbcConn.getPassw());
			Connection conn = DriverManager.getConnection(jdbcConn.getUrl(), jdbcConn.getProperties());			

            preparedStatement = conn.prepareStatement("SELECT CUSTOMER_ID, FIRST_NAME, LAST_NAME, ADDRESS_ID from CUSTOMER");
			System.out.println("\nConnection successful - " + conn + "\n");

			resultSet = preparedStatement.executeQuery();

            writeResultSet(resultSet);			
			
		} catch (Exception ex) {
			System.out.println("Problem: " + ex.toString());
		}
		
	}
	
    private void writeResultSet(ResultSet resultSet) throws SQLException {

        System.out.println("CUSTOMER_ID   FIRST_NAME  LAST_NAME  ADDRESS_ID");

        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int customerId = resultSet.getInt("CUSTOMER_ID");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int addressId = resultSet.getInt("ADDRESS_ID");
            System.out.println(customerId + "   " + firstName + "  " + lastName + "  " + addressId);
        }
    }	
	
}
