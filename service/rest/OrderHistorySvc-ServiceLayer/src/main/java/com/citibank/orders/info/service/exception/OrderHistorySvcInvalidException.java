package com.citibank.orders.info.service.exception;

public class OrderHistorySvcInvalidException extends Exception {

	private String resCode;
	private String resMsg;

	public OrderHistorySvcInvalidException(String resCode, String resMsg) {
		this.resCode = resCode;
		this.resMsg = resMsg;
	}

	public String getResCode() {
		return resCode;
	}

	public String getResMsg() {
		return resMsg;
	}

}
