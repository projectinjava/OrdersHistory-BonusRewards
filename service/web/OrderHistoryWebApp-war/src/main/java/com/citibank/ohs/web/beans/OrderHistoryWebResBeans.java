package com.citibank.ohs.web.beans;

import java.util.List;

public class OrderHistoryWebResBeans {

	List<Orders> orders;

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHistoryWebResBeans [orders=");
		builder.append(orders);
		builder.append("]");
		return builder.toString();
	}

}
