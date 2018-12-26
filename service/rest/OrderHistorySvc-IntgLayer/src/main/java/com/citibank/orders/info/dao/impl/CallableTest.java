package com.citibank.orders.info.dao.impl;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class CallableTest {
	private static Connection connection =null;
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
	
		connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/orderhistory", "root", "root");
		String sql = "{call GETOrderHistory(?,?,?,?,?)}";
		CallableStatement cs = connection.prepareCall(sql);

		cs.registerOutParameter(4, Types.VARCHAR);
		cs.registerOutParameter(5, Types.VARCHAR);

		cs.setString(1, "web");
		cs.setString(2, "online");
		cs.setString(3, "6661154");
		//System.out.println(cs.execute());
		cs.execute();
		
		//System.out.println(cs.getObject(4));
		//System.out.println(cs.getObject(5));
		ResultSet rs=cs.executeQuery();
		//System.out.println(rs.FETCH_UNKNOWN);
		if ((rs!=null)) {
			//System.out.println("rs");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "--" + rs.getString(2) + "--" + rs.getString(3));
			}
		}

		System.out.println(cs.getString(4));
		System.out.println(cs.getString(5));
	}

}

	


