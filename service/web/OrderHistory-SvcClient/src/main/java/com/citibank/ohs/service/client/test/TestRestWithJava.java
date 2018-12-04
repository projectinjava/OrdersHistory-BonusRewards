package com.citibank.ohs.service.client.test;

import com.citibank.ohs.service.client.OrderHistoryServiceClient;
import com.citibank.ohs.service.client.beans.CardDetails;
import com.citibank.ohs.service.client.beans.ClientContext;
import com.citibank.ohs.service.client.beans.DateRange;
import com.citibank.ohs.service.client.beans.OrderHistoryWebSvcReq;
import com.citibank.ohs.service.client.beans.OrderHistoryWebSvcRes;
import com.citibank.ohs.service.client.beans.OrdersInfo;
import com.citibank.ohs.service.client.beans.ServiceDetails;
import com.citibank.ohs.service.client.impl.OrderHistoryServiceClientImpl;


public class TestRestWithJava {

	public static void main(String[] args) {

		OrderHistoryServiceClient impl=new OrderHistoryServiceClientImpl();

		OrderHistoryWebSvcReq svcReq=new OrderHistoryWebSvcReq();
		
		ClientContext clientContext = new ClientContext();
		clientContext.setClientId("WEB");
		clientContext.setChannelId("online");
		clientContext.setRequestId("23453");

		CardDetails cardDetails = new CardDetails();
		cardDetails.setCardNumber("45673839038373");
		cardDetails.setCvvNum("36");
		cardDetails.setExpDate("12102018");
		cardDetails.setNameOnCard("XYZ");

		DateRange dateRange = new DateRange();
		dateRange.setStartDate("12102018");
		dateRange.setEndDate("31122019");

		OrdersInfo ordersInfo = new OrdersInfo();
		ordersInfo.setPrice(1234556);
		ordersInfo.setTypeOfOrder("electronic");

		ServiceDetails svcDetails = new ServiceDetails();
		svcDetails.setApiName("OrderHistoryService");
		svcDetails.setServiceName("OrderHistory");
		svcDetails.setVersion("1.1");

		svcReq.setCardDetails(cardDetails);
		svcReq.setClientContext(clientContext);
		svcReq.setDateRange(dateRange);
		svcReq.setOrdersInfo(ordersInfo);
		svcReq.setServiceDetails(svcDetails);
		
		System.out.println("TestRestWithJava : "+svcReq);
		OrderHistoryWebSvcRes svcResp=impl.getOrderHistory(svcReq);
		System.out.println("SvcResp : "+svcResp);

	}

}
