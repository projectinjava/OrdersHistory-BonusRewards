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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestRestWithJava {

	public static void main(String[] args) throws JsonProcessingException {

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
		
		/*ObjectMapper mapper=new ObjectMapper();
		System.out.println(mapper.writeValueAsString(svcResp));*/
		
		for(int i=0;i<3;i++) {
		String price=svcResp.getOrderHistoryDetails().getOrderHistory().get(i).getPrice();
		String oid=svcResp.getOrderHistoryDetails().getOrderHistory().get(i).getOid();
		System.out.println("Price : "+price+" Oid : "+oid);
		}
		
		System.out.println("SvcResp : "+svcResp);

	}

}
