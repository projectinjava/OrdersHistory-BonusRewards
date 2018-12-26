package com.citibank.ohs.web.beans;

import java.util.List;

import com.citibank.ohs.service.client.beans.StatusBlock;

public class OrderHistoryWebResBeans {

	List<Orders> orders;
	private StatusBlock statusBlockWeb;
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public StatusBlock getStatusBlockWeb() {
		return statusBlockWeb;
	}
	public void setStatusBlockWeb(StatusBlock statusBlockWeb) {
		this.statusBlockWeb = statusBlockWeb;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHistoryWebResBeans [orders=");
		builder.append(orders);
		builder.append(", statusBlockWeb=");
		builder.append(statusBlockWeb);
		builder.append("]");
		return builder.toString();
	}
	
}