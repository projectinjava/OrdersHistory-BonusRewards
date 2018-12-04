package com.citibank.ohs.service.client.beans;

public class ClientContext {
	private String clientId;
	private String channelId;
	private String requestId;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	@Override
	public String toString() {
		return "ClientContext [clientId=" + clientId + ", channelId=" + channelId + ", requestId=" + requestId + "]";
	}
	

	
}
