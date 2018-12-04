package com.citibank.orders.info.service.impl;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.citibank.orders.info.process.OrderHistoryProcess;
import com.citibank.orders.info.process.beans.OrderHistoryProcessReqBean;
import com.citibank.orders.info.process.beans.OrderHistoryProcessResBean;
import com.citibank.orders.info.process.impl.OrderHistoryProcessImpl;
import com.citibank.orders.info.service.OrderHistoryService;
import com.citibank.orders.info.service.beans.ClientContext;
import com.citibank.orders.info.service.beans.OrderHistoryServiceReqBean;
import com.citibank.orders.info.service.beans.OrderHistoryServiceResBean;
import com.citibank.orders.info.service.beans.StatusBlock;
import com.citibank.orders.info.service.builder.OrderHistoryServiceReqBuilder;
import com.citibank.orders.info.service.builder.OrderHistoryServiceResBuilder;
import com.citibank.orders.info.service.exception.OrderHistorySvcInvalidException;
import com.citibank.orders.info.service.validator.OrderHistoryServiceValidator;

@Path("/orderhistory")
public class OrderHistoryServiceImpl implements OrderHistoryService {

	@Path("/v1/orders")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public OrderHistoryServiceResBean getOrderHistory(OrderHistoryServiceReqBean serviceReq,
			@HeaderParam("client_id") String client_id, @HeaderParam("channel_id") String channel_id,
			@HeaderParam("req_id") String req_id)
			throws InterruptedException, ExecutionException, OrderHistorySvcInvalidException {

		System.out.println("enter into OrderHistoryServiceImpl Layer " + serviceReq);

		ClientContext clientContext = new ClientContext();
		clientContext.setClientId(client_id);
		clientContext.setChannelId(channel_id);
		clientContext.setRequestId(req_id);

		serviceReq.setClientContext(clientContext);

		OrderHistoryServiceResBean serviceResp = null;
		OrderHistoryProcessResBean processResp = null;

		try {
			// 1. get the request from consumer
			// 2. validate the request
			OrderHistoryServiceValidator validator = new OrderHistoryServiceValidator();
			validator.validateRequest(serviceReq);
			// 3. prepare the process request
			OrderHistoryServiceReqBuilder reqBuilder = new OrderHistoryServiceReqBuilder();

			OrderHistoryProcessReqBean processReq = reqBuilder.buildProcessReq(serviceReq);
			// 4. create the process object
			OrderHistoryProcess process = new OrderHistoryProcessImpl();
			// 5. call the processorder method and get the response
			processResp = process.getOrderHistory(processReq);
			OrderHistoryServiceResBuilder respBuilder = new OrderHistoryServiceResBuilder();
			serviceResp = respBuilder.buildServiceResponse(processResp);
		} catch (OrderHistorySvcInvalidException e) {

			serviceResp = new OrderHistoryServiceResBean();
			StatusBlock statusBlock = new StatusBlock();
			statusBlock.setRespCode(e.getResCode());
			statusBlock.setRespMessage(e.getResMsg());
			serviceResp.setStatusBlock(statusBlock);
			e.printStackTrace();
		} catch (Exception e) {

			serviceResp = new OrderHistoryServiceResBean();
			StatusBlock statusBlock = new StatusBlock();
			statusBlock.setRespCode("8888");
			statusBlock.setRespMessage("Unknown Error");
			serviceResp.setStatusBlock(statusBlock);
			e.printStackTrace();
		}

		System.out.println("Exit from OrderHistoryServiceImpl Layer : " + serviceResp);
		return serviceResp;
	}

}
