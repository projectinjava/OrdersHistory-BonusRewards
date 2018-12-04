package com.citibank.orders.info.process.beans;

import java.util.List;

public class OrderHistoryProcessResBean {
	
	private List<OrderDetailsProcessBean> orderDetailsProcessBean;
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
	
	
	public List<OrderDetailsProcessBean> getOrderDetailsProcessBean() {
		return orderDetailsProcessBean;
	}
	public void setOrderDetailsProcessBean(List<OrderDetailsProcessBean> orderDetailsProcessBean) {
		this.orderDetailsProcessBean = orderDetailsProcessBean;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHistoryProcessResBean [orderDetailsProcessBean=");
		builder.append(orderDetailsProcessBean);
		builder.append(", respCode=");
		builder.append(respCode);
		builder.append(", respMesssage=");
		builder.append(respMesssage);
		builder.append("]");
		return builder.toString();
	}
	
	


}
