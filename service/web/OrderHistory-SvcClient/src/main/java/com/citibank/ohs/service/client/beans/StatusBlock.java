package com.citibank.ohs.service.client.beans;

public class StatusBlock {
	
	private String respCode;
	private String respMessage;
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMessage() {
		return respMessage;
	}
	public void setRespMessage(String respMessage) {
		this.respMessage = respMessage;
	}
	@Override
	public String toString() {
		return "StatusBlock [respCode=" + respCode + ", respMessage=" + respMessage + "]";
	}
	


}
