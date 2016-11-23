package com.pay.api.request;

import java.util.Map;

import com.pay.api.response.AlipayTradeDirectPayResponse;
import com.pay.api.util.PayHashMap;

public class AlipayTradeDirectPayRequest implements PayRequest<AlipayTradeDirectPayResponse>{

	private String bizContent;
	
	@Override
	public String getApiMethodName() {
		return "create_direct_pay_by_user";
	}

	@Override
	public Map<String, String> getTextParams() {
		PayHashMap payHashMap = new PayHashMap();
		return payHashMap;
	}

	@Override
	public void setBizContent(String bizContent) {
		this.bizContent = bizContent;
	}

	@Override
	public String getBizContent() {
		return this.bizContent;
	}

	@Override
	public Class<AlipayTradeDirectPayResponse> getResponseClass() {
		return AlipayTradeDirectPayResponse.class;
	}

}
