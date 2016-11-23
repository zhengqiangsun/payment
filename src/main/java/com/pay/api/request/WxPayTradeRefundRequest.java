package com.pay.api.request;

import java.util.Map;

import com.pay.api.response.WxPayTradeRefundResponse;
import com.pay.api.util.PayHashMap;

/**
 * 
 * @author sunzhengqiang
 * @date 2016年11月18日
 */
public class WxPayTradeRefundRequest implements PayRequest<WxPayTradeRefundResponse>{
	
	private String bizContent;
	
	@Override
	public String getApiMethodName() {
		return "https://api.mch.weixin.qq.com/secapi/pay/refund";
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
	public Class<WxPayTradeRefundResponse> getResponseClass() {
		return WxPayTradeRefundResponse.class;
	}
	
	

}
