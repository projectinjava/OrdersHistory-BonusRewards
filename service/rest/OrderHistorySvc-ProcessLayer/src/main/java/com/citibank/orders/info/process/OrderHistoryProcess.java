package com.citibank.orders.info.process;

import java.util.concurrent.ExecutionException;

import com.citibank.orders.info.process.beans.OrderHistoryProcessReqBean;
import com.citibank.orders.info.process.beans.OrderHistoryProcessResBean;

public interface OrderHistoryProcess {
	
	OrderHistoryProcessResBean getOrderHistory(OrderHistoryProcessReqBean processReq)throws InterruptedException, ExecutionException;

}
