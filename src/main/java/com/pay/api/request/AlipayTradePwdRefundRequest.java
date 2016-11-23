package com.pay.api.request;

import java.util.Map;

import com.pay.api.response.AlipayTradePwdRefundResponse;
import com.pay.api.util.PayHashMap;

/**
 * 支付宝-有密退款
 * @author sunzhengqiang
 * @date 2016年11月22日
 */
public class AlipayTradePwdRefundRequest implements PayRequest<AlipayTradePwdRefundResponse>{
	
	private String bizContent;
	
	@Override
	public String getApiMethodName() {
		return "refund_fastpay_by_platform_pwd";
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
	public Class<AlipayTradePwdRefundResponse> getResponseClass() {
		return AlipayTradePwdRefundResponse.class;
	}
	
}
