package com.citibank.orders.info.service.test;

import java.util.concurrent.ExecutionException;

import com.citibank.orders.info.service.OrderHistoryService;
import com.citibank.orders.info.service.beans.CardDetails;
import com.citibank.orders.info.service.beans.ClientContext;
import com.citibank.orders.info.service.beans.DateRange;
import com.citibank.orders.info.service.beans.OrderHistoryServiceReqBean;
import com.citibank.orders.info.service.beans.OrderHistoryServiceResBean;
import com.citibank.orders.info.service.beans.OrdersInfo;
import com.citibank.orders.info.service.beans.ServiceDetails;
import com.citibank.orders.info.service.exception.OrderHistorySvcInvalidException;
import com.citibank.orders.info.service.impl.OrderHistoryServiceImpl;

public class TestMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException, OrderHistorySvcInvalidException {
		
		OrderHistoryService svcImpl = new OrderHistoryServiceImpl();
		OrderHistoryServiceReqBean svcReq = new OrderHistoryServiceReqBean();
		OrderHistoryServiceResBean svcRes = new OrderHistoryServiceResBean();

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

		svcReq.setClientContext(clientContext);
		svcReq.setCardDetails(cardDetails);
		svcReq.setDateRange(dateRange);
		svcReq.setOrdersInfo(ordersInfo);
		svcReq.setServiceDetails(svcDetails);

		svcRes = svcImpl.getOrderHistory(svcReq, clientContext.getClientId(), clientContext.getChannelId(), clientContext.getRequestId());
		System.out.println("Response : "+svcRes);

	}

}
