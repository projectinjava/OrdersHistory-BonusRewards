package com.citibank.ohs.service.client;

import com.citibank.ohs.service.client.beans.OrderHistoryWebSvcReq;
import com.citibank.ohs.service.client.beans.OrderHistoryWebSvcRes;

public interface OrderHistoryServiceClient {
	
	public OrderHistoryWebSvcRes getOrderHistory(OrderHistoryWebSvcReq svcReq);

}
