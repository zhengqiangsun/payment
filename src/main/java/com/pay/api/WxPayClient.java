package com.pay.api;

import com.pay.api.request.AlipayTradePwdRefundRequest;
import com.pay.api.request.PayRequest;
import com.pay.api.response.PayResponse;

/**
 * 支付客户端
 * @author sunzhengqiang
 * @date 2016年11月17日
 */
public interface WxPayClient {
	
    /**
     * 
     * 执行请求
     * @param <T>
     * @param request
     * @return
     * @throws AlipayApiException
     */
    public <T extends PayResponse> T execute(PayRequest<T> request);
    /**
     * 执行请求
     * @param request
     * @param certificatePath 证书地址 
     * @param certificatePass 证书密钥
     * @return
     */
    public <T extends PayResponse> T execute(PayRequest<T> request,String certificatePath,String certificatePass);
    
    
}
