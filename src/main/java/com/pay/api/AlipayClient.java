package com.pay.api;

import com.pay.api.request.PayRequest;
import com.pay.api.response.PayResponse;

/**
 * 支付宝客户端
 * @author sunzhengqiang
 * @date 2016年11月22日
 */
public interface AlipayClient {
	
	
	/**
	 * 支付宝-即时到账有密退款接口
	 * 支付宝-即时到账交易接口
	 * @param request
	 * @return
	 * ps:此方法是即时到账系列特殊处理
	 */
	public <T extends PayResponse> String specialExecute(PayRequest<T> request);
	
	
}
