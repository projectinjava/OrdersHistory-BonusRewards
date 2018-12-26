package com.citibank.orders.info.service.util;

import java.util.Date;

public class OrderHistoryServiceDateCaluclation {

	// TODO Auto-generated method stub
	public static long daysBetween(Date one, Date two) {
		long difference = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(difference);
	}
}
