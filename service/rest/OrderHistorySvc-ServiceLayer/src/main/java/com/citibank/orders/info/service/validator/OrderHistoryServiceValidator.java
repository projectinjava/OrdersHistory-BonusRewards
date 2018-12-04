package com.citibank.orders.info.service.validator;

import com.citibank.orders.info.service.beans.CardDetails;
import com.citibank.orders.info.service.beans.ClientContext;
import com.citibank.orders.info.service.beans.OrderHistoryServiceReqBean;
import com.citibank.orders.info.service.exception.OrderHistorySvcInvalidException;

public class OrderHistoryServiceValidator {

	public void validateRequest(OrderHistoryServiceReqBean serviceReq) throws OrderHistorySvcInvalidException {

		//TODO validate all the mandatory elements
		//throws userdefined exception in case of any invalid element
		
		if(serviceReq==null && serviceReq.getClientContext()==null && serviceReq.getDateRange()==null && serviceReq.getOrdersInfo()==null && serviceReq.getCardDetails()==null) {
			throw new OrderHistorySvcInvalidException("OHS001", "Request obj is null");
		}
		
		ClientContext clientContext =serviceReq.getClientContext();
		if(clientContext.getClientId()==null || " ".equals(clientContext.getClientId())) {
			throw new OrderHistorySvcInvalidException("OHS002","Client id is invalid");
		}
		if(clientContext.getChannelId()==null || " ".equals(clientContext.getChannelId())) {
			throw new OrderHistorySvcInvalidException("OHS003","Channel id is invalid");
		}
		
		CardDetails cardDtls=serviceReq.getCardDetails();
		if(cardDtls.getCardNumber()==null && " ".equals(cardDtls.getCardNumber())) {
			throw new OrderHistorySvcInvalidException("OHS004","Card Number is invalid");
		}
	}

}
