package com.citibank.orders.info.service.validator;

import com.citibank.orders.info.service.beans.CardDetails;
import com.citibank.orders.info.service.beans.ClientContext;
import com.citibank.orders.info.service.beans.OrderHistoryServiceReqBean;
import com.citibank.orders.info.service.beans.OrdersInfo;
import com.citibank.orders.info.service.exception.OrderHistorySvcInvalidException;

public class OrderHistoryServiceValidator {

	public void validateRequest(OrderHistoryServiceReqBean serviceReq) throws OrderHistorySvcInvalidException {

		// checking req objects null or empty
		if (serviceReq == null || serviceReq.getCardDetails() == null || serviceReq.getOrdersInfo() == null
				|| serviceReq.getServiceDetails() == null || serviceReq.getClientContext() == null) {
			throw new OrderHistorySvcInvalidException("OHS000",
					"serviceReq or clientcontext or carddetails or orderdetails or serviceDtls is null");
		}
		// checking clientcontext elements null or empty
		ClientContext clientContext = serviceReq.getClientContext();

		if (clientContext.getChannelId() == null || "".equals(clientContext.getChannelId())) {
			throw new OrderHistorySvcInvalidException("OHS002", "channel ID Invalid");
		}
		if (clientContext.getClientId() == null || "".equals(clientContext.getClientId())) {
			throw new OrderHistorySvcInvalidException("OHS001", "client ID Invalid");
		}
		if (clientContext.getRequestId() == null || "".equals(clientContext.getRequestId())) {
			throw new OrderHistorySvcInvalidException("OHS004", "Request id Invalid");
		}
		// checking carddetails elements null or empty
		CardDetails cardDetails = serviceReq.getCardDetails();
		if (cardDetails.getCardNumber() == null || "".equals(cardDetails.getCardNumber())) {
			throw new OrderHistorySvcInvalidException("OHS005", "cardnumber ID Invalid");
		}
		if (cardDetails.getCvvNum() == null || "".equals(cardDetails.getCvvNum())) {
			throw new OrderHistorySvcInvalidException("OHS003", "cvv ID Invalid");
		}
		if (cardDetails.getNameOnCard() == null || "".equals(cardDetails.getNameOnCard())) {
			throw new OrderHistorySvcInvalidException("OHS006", "Name on card is invalid");
		}
		if (cardDetails.getExpDate() == null || "".equals(cardDetails.getExpDate())) {
			throw new OrderHistorySvcInvalidException("OHS007", "expdate is invalid");
		}
		// checking OrdersInfo elements null or empty
		OrdersInfo ordersInfo = serviceReq.getOrdersInfo();

		if (ordersInfo.getPrice() == 0.0 || "".equals(ordersInfo.getPrice())) {
			throw new OrderHistorySvcInvalidException("OHS009", "price is invalid");
		}
		if (ordersInfo.getTypeOfOrder() == null || "".equals(ordersInfo.getTypeOfOrder())) {
			throw new OrderHistorySvcInvalidException("OHS008", "Type of order is invalid");
		}

		/*
		 * //TODO validate all the mandatory elements //throws userdefined exception in
		 * case of any invalid element
		 * 
		 * if(serviceReq==null || serviceReq.getClientContext()==null ||
		 * serviceReq.getDateRange()==null || serviceReq.getOrdersInfo()==null ||
		 * serviceReq.getCardDetails()==null) { throw new
		 * OrderHistorySvcInvalidException("OHS001", "Request obj is null"); }
		 * 
		 * ClientContext clientContext =serviceReq.getClientContext();
		 * if(clientContext.getClientId()==null ||
		 * " ".equals(clientContext.getClientId())) { throw new
		 * OrderHistorySvcInvalidException("OHS002","Client id is invalid"); }
		 * if(clientContext.getChannelId()==null ||
		 * " ".equals(clientContext.getChannelId())) { throw new
		 * OrderHistorySvcInvalidException("OHS003","Channel id is invalid"); }
		 * 
		 * CardDetails cardDtls=serviceReq.getCardDetails();
		 * if(cardDtls.getCardNumber()==null || " ".equals(cardDtls.getCardNumber())) {
		 * throw new OrderHistorySvcInvalidException("OHS004","Card Number is invalid");
		 * }
		 */
	}

}
