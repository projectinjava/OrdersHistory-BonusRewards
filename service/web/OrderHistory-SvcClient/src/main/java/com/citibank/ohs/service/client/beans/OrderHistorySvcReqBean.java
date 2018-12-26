package com.citibank.ohs.service.client.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderHistorySvcReqBean {

	private ClientContext clientContext;
	private CardDetails cardDetails;
	private DateRange dateRange;
	private OrdersInfo ordersInfo;
	private ServiceDetails svcDtls;
	public ClientContext getClientContext() {
		return clientContext;
	}
	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}
	public CardDetails getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}
	public DateRange getDateRange() {
		return dateRange;
	}
	public void setDateRange(DateRange dateRange) {
		this.dateRange = dateRange;
	}
	public OrdersInfo getOrdersInfo() {
		return ordersInfo;
	}
	public void setOrdersInfo(OrdersInfo ordersInfo) {
		this.ordersInfo = ordersInfo;
	}
	public ServiceDetails getSvcDtls() {
		return svcDtls;
	}
	public void setSvcDtls(ServiceDetails svcDtls) {
		this.svcDtls = svcDtls;
	}
	@Override
	public String toString() {
		return "OrderHistorySvcReqBean [clientContext=" + clientContext + ", cardDetails=" + cardDetails
				+ ", dateRange=" + dateRange + ", ordersInfo=" + ordersInfo + ", svcDtls=" + svcDtls + "]";
	}
	
	
}
