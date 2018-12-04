package com.citibank.orders.info.service.beans;

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
		StringBuilder builder = new StringBuilder();
		builder.append("StatusBlock [respCode=");
		builder.append(respCode);
		builder.append(", respMessage=");
		builder.append(respMessage);
		builder.append("]");
		return builder.toString();
	}

}
