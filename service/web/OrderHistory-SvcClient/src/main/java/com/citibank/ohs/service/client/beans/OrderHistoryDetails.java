package com.citibank.ohs.service.client.beans;

import java.util.List;

public class OrderHistoryDetails {
	private List<OrderHistory> orderHistory;

	public List<OrderHistory> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(List<OrderHistory> orderHistory) {
		this.orderHistory = orderHistory;
	}

	@Override
	public String toString() {
		return "OrderHistoryDetails [orderHistory=" + orderHistory + "]";
	}
	


	
}
