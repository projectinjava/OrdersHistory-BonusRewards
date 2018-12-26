package com.citibank.orders.info.service;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.HeaderParam;

import com.citibank.orders.info.service.beans.OrderHistoryServiceReqBean;
import com.citibank.orders.info.service.beans.OrderHistoryServiceResBean;
import com.citibank.orders.info.service.exception.OrderHistorySvcInvalidException;

public interface OrderHistoryService {
	OrderHistoryServiceResBean getOrderHistory(OrderHistoryServiceReqBean serviceReq, @HeaderParam ("client_id") String client_id, @HeaderParam ("channel_id") String channel_id, @HeaderParam ("req_id") String req_id) throws InterruptedException, ExecutionException, OrderHistorySvcInvalidException;

}
