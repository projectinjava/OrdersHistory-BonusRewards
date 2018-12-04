package com.citibank.orders.info.service;

import java.util.concurrent.ExecutionException;

import com.citibank.orders.info.service.beans.OrderHistoryServiceReqBean;
import com.citibank.orders.info.service.beans.OrderHistoryServiceResBean;
import com.citibank.orders.info.service.exception.OrderHistorySvcInvalidException;

public interface OrderHistoryService {
	OrderHistoryServiceResBean getOrderHistory(OrderHistoryServiceReqBean serviceReq, String client_id, String channel_id, String req_id) throws InterruptedException, ExecutionException, OrderHistorySvcInvalidException;

}
