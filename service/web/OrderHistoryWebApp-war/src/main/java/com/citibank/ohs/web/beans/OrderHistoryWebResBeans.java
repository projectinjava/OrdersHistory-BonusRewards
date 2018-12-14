package com.citibank.ohs.web.beans;

import java.util.List;

public class OrderHistoryWebResBeans {

	List<Orders> orders;
	private String respCode;
	private String respmsg;

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespmsg() {
		return respmsg;
	}

	public void setRespmsg(String respmsg) {
		this.respmsg = respmsg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHistoryWebResBeans [orders=");
		builder.append(orders);
		builder.append(", respCode=");
		builder.append(respCode);
		builder.append(", respmsg=");
		builder.append(respmsg);
		builder.append("]");
		return builder.toString();
	}

}