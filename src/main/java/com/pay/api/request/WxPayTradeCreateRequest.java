package com.pay.api.request;

import java.util.Map;

import com.pay.api.response.WxPayTradeCreateResponse;
import com.pay.api.util.PayHashMap;

public class WxPayTradeCreateRequest implements PayRequest<WxPayTradeCreateResponse> {
	
	private String bizContent;
	
	@Override
	public String getApiMethodName() {
		return "https://api.mch.weixin.qq.com/pay/unifiedorder";
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
	public Class<WxPayTradeCreateResponse> getResponseClass() {
		
		return WxPayTradeCreateResponse.class;
	}

}
