package com.citibank.orders.info.service.validator;

import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

public class OrderHistoryServiceValidatorTest {

	OrderHistoryServiceValidator validator = null;
	OrderHistoryServiceReqBean req;

	@Before
	public void setUp() throws Exception {

		validator = new OrderHistoryServiceValidator();
		req = buildServiceReq();
	}

	@Test
	public void testRequestObject_Null_Scenrio() {
		try {

			validator.validateRequest(null);
		} catch (OrderHistorySvcInvalidException e) {
			Assert.assertEquals("OHS001", e.getResCode());
			//e.printStackTrace();

		}
	}

	@Test
	public void testClientContextRequest_Null_Scenrio() {
		req.setClientContext(null);
		try {

			validator.validateRequest(req);
		} catch (OrderHistorySvcInvalidException e) {
			Assert.assertEquals("OHS001", e.getResCode());
			//e.printStackTrace();

		}
	}

	@Test
	public void testClientIdRequest_Null_Scenrio() {

		//req.setClientC
		try {

			validator.validateRequest(req);
		} catch (OrderHistorySvcInvalidException e) {
			Assert.assertEquals("OHS002", e.getResCode());
			//e.printStackTrace();

		}

	}

	private OrderHistoryServiceReqBean buildServiceReq()
			throws InterruptedException, ExecutionException, OrderHistorySvcInvalidException {

		OrderHistoryService svcImpl = new OrderHistoryServiceImpl();
		OrderHistoryServiceReqBean svcReq = new OrderHistoryServiceReqBean();
		OrderHistoryServiceResBean svcRes = new OrderHistoryServiceResBean();

		ClientContext clientContext = new ClientContext();
		clientContext.setClientId("web");
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

		svcRes = svcImpl.getOrderHistory(svcReq, clientContext.getClientId(), clientContext.getChannelId(),
				clientContext.getRequestId());
		System.out.println(">>>>>>>" + svcReq);
		return svcReq;
	}

}