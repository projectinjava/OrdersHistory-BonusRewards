package com.citibank.orders.info.dao.util;

public enum ServiceErrorCodesEnum {
      
	OHS001("OHS001","100","client ID Invalid"),
	OHS002("OHS002","101","channel ID Invalid"),
	OHS003("OHS003","102","cvv ID Invalid"),
	OHS004("OHS005","103","cardnumber Invalid"),
	OHS005("OHS004","104","Request id Invalid"),
	OHS006("OHS006","105","Name on card is invalid"),
	OHS007("OHS007","106","expdate is invalid"),
	OHS008("OHS008","107","Type of order is invalid"),
	OHS009("OHS009","108","price is invalid"),
	OHS010("OHS010","109","please provide valid date");
	private String svcCode;
	private String backCode;
	private String errorMsg;
	
	ServiceErrorCodesEnum(String svcCode,String backCode,String errorMsg){
		this.svcCode=svcCode;
		this.backCode=backCode;
		this.errorMsg=errorMsg;
	}
	public static String reqcheckErrorCode(String svcCode){
		//if error code is preset in enum then return correspond svcerrorcode
		System.out.println(svcCode);
		
		for(ServiceErrorCodesEnum errorCodeValues:ServiceErrorCodesEnum.values()){
		if(errorCodeValues.svcCode.equals(svcCode)){
			return errorCodeValues.svcCode;
		}
			
		}
		return null;
	}
	public static String reqcheckErrorMsg(String message,String svcCode){
		//if error code is preset in enum then return crrespond svcerrorcode
		
		
		for(ServiceErrorCodesEnum errorCodeValues:ServiceErrorCodesEnum.values()){
		if(errorCodeValues.errorMsg.equals(message)&&errorCodeValues.svcCode.equals(svcCode)){
			return errorCodeValues.errorMsg;
			
		}
			
		}
		return null;
	}
	public static String checkErrorCode(String backCode){
		//if error code is preset in enum then return correspond svcerrorcode
		
		
		for(ServiceErrorCodesEnum errorCodeValues:ServiceErrorCodesEnum.values()){
		if(errorCodeValues.backCode.equals(backCode)){
			return errorCodeValues.svcCode;
		}
			
		}
	return null;
	}
	public static String checkErrorMsg(String message,String backCode){
		//if error code is preset in enum then return crrespond svcerrorcode
		
		
		for(ServiceErrorCodesEnum errorCodeValues:ServiceErrorCodesEnum.values()){
		if(errorCodeValues.errorMsg.equals(message)&&errorCodeValues.backCode.equals(backCode)){
			return errorCodeValues.errorMsg;
			
		}
			
		}
		return null;
	}
	public static void main(String [] args)
	{
		String code=ServiceErrorCodesEnum.checkErrorCode("101");
		System.out.println(code);
		String msg=ServiceErrorCodesEnum.checkErrorMsg("channel ID Invalid", "101");
		System.out.println(msg);
	}
}
