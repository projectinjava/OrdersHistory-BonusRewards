package com.citibank.orders.info.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("env", "dev");
		String env=System.getProperty("env");
		System.out.println("Environment is "+env);
		
		String file="/properties/orderhistory_"+env+"_db.properties";
		System.out.println("File "+file);
		Properties p=new Properties();
		InputStream is=TestProperties.class.getClassLoader().getResourceAsStream(file);
		//InputStream is=new FileInputStream("D:\Java Package\Project\OrdersHistory-BonusRewards\service\rest\OrderHistorySvc-IntgLayer\src\main\resources\orderhistory_dev_db.properties");
		p.load(is);
		
		String dburl=p.getProperty("db_url");
		System.out.println("db-url "+dburl);
		String uname=p.getProperty("uname");
		String pwd=p.getProperty("pwd");
	}
}
