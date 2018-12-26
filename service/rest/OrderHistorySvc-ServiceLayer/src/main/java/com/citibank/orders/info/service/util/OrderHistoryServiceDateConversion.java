package com.citibank.orders.info.service.util;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class OrderHistoryServiceDateConversion {

	public Date dateConversion(){
		Date today = new Date();
		System.out.println(today);
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_MONTH, -30);
		Date today30 = cal.getTime();
		cal.add(Calendar.DATE, -60);
		Date today60 = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, -90);
		Date today90 = cal.getTime();
		return today60;
	}
	public LocalDate dateCon(){
		LocalDate now = LocalDate.now();
		System.out.println(now);
		LocalDate thirty = now.minusDays( 30 );
		LocalDate sixty = now.minusDays( 60 );
		LocalDate ninety = now.minusDays( 90 );
		return sixty;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OrderHistoryServiceDateConversion sdc=new OrderHistoryServiceDateConversion();
		//System.out.println(sdc.dateConversion());
	System.out.println(sdc.dateCon());
		//System.out.println("end date ="+today);
		
	}

}
