package com.citibank.orders.info.carddetailsdao.beans;

import java.util.List;

public class CardResponse {

	private String respCode;
	private String respMessage;
	private List<String> cardList;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMessage() {
		return respMessage;
	}

	public void setRespMessage(String respMessage) {
		this.respMessage = respMessage;
	}

	public List<String> getCardList() {
		return cardList;
	}

	public void setCardList(List<String> cardList) {
		this.cardList = cardList;
	}

	@Override
	public String toString() {
		return "CardResponse [respCode=" + respCode + ", respMessage=" + respMessage + ", cardList=" + cardList + "]";
	}

}
