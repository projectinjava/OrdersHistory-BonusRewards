package com.citibank.orders.info.service.beans;

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
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHistoryDetails [orderHistory=");
		builder.append(orderHistory);
		builder.append("]");
		return builder.toString();
	}

	
}
