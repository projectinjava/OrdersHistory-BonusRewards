package com.citibank.orders.info.dao.beans;

import java.util.List;

public class OrderHistoryDAOResBean {
	
	private List<OrderDetailsDAO> orderDetails;
	private String respCode;
	private String respMesssage;
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMesssage() {
		return respMesssage;
	}
	public void setRespMesssage(String respMesssage) {
		this.respMesssage = respMesssage;
	}
	@Override
	public String toString() {
		return "OrderHistoryDAOResBean [orderDetails=" + orderDetails + ", respCode=" + respCode + ", respMesssage="
				+ respMesssage + "]";
	}
	public  List<OrderDetailsDAO> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetailsDAO> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	

}
