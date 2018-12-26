package com.citibank.ohs.service.client.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.citibank.ohs.service.client.OrderHistoryServiceClient;
import com.citibank.ohs.service.client.beans.OrderHistoryWebSvcReq;
import com.citibank.ohs.service.client.beans.OrderHistoryWebSvcRes;

public class OrderHistoryServiceClientImpl implements OrderHistoryServiceClient {

	@Override
	public OrderHistoryWebSvcRes getOrderHistory(OrderHistoryWebSvcReq svcReq) {

		String uri = "http://localhost:2525/OrderHistorySvc-war/rest/orderhistory/v1/orders";

		RestTemplate template = new RestTemplate();
		// set message converter

		List<HttpMessageConverter<?>> messageConverter = new ArrayList<HttpMessageConverter<?>>();
		messageConverter.add(new MappingJackson2HttpMessageConverter());
		template.setMessageConverters(messageConverter);

		// set req headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		List<MediaType> acceList = new ArrayList<MediaType>();
		acceList.add(MediaType.APPLICATION_JSON);
		headers.setAccept(acceList);
		headers.set("client_id", "web");
		headers.set("channel_id", "online");
		headers.set("req_id", UUID.randomUUID().toString());

		// create HttpEntity obj

		HttpEntity<OrderHistoryWebSvcReq> request = new HttpEntity<OrderHistoryWebSvcReq>(svcReq, headers);
		
		OrderHistoryWebSvcRes webSvcResponse = template.postForObject(uri, request, OrderHistoryWebSvcRes.class);
		System.out.println("Exit from service client "+webSvcResponse);
		return webSvcResponse;
		
	}
	
}
