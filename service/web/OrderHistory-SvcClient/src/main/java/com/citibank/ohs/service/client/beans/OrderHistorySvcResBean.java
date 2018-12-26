package com.citibank.ohs.service.client.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class OrderHistorySvcResBean {
	
	private StatusBlock statusBlock;
	
	private List<OrderHistory> orderHistory;
	public StatusBlock getStatusBlock() {
		return statusBlock;
	}
	public void setStatusBlock(StatusBlock statusBlock) {
		this.statusBlock = statusBlock;
	}

	
	
	public List<OrderHistory> getOrderHistory() {
		return orderHistory;
	}
	public void setOrderHistory(List<OrderHistory> orderHistory) {
		this.orderHistory = orderHistory;
	}
	@Override
	public String toString() {
		return "OrderHistorySvcResBean [statusBlock=" + statusBlock + ", orderHistory=" + orderHistory + "]";
	}
	
	
	}
	
	


