package com.pay.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pay.api.request.AlipayTradeDirectPayRequest;
import com.pay.api.request.AlipayTradePwdRefundRequest;
import com.pay.api.request.PayRequest;
import com.pay.api.response.PayResponse;
import com.pay.api.util.DateUtils;
import com.pay.api.util.PaySignature;
import com.pay.api.util.RequestParametersHolder;

/**
 * 支付宝-客户端
 * @author sunzhengqiang
 * @date 2016年11月22日
 */
public class DefaultAlipayClient implements AlipayClient {
	
//	private String appId;
	private String privateKey;
	private String publicKey;
	private String partner;
	private String notifyUrl;
	private String returnUrl;
	private String signType = PayConstants.SIGN_TYPE_RSA;
	private String charset = PayConstants.DEFAULT_CHARSET;
//	private String format = PayConstants.FORMAT_JSON;
	private String alipayGateWay = "https://mapi.alipay.com/gateway.do?";
	
	
	public DefaultAlipayClient(){}
	
	public DefaultAlipayClient(String partner,String privateKey,String notifyUrl){
		this.partner = partner;
		this.privateKey = privateKey;
		this.notifyUrl = notifyUrl;
	}
	public DefaultAlipayClient(String partner,String privateKey,String notifyUrl,String returnUrl){
		this.partner = partner;
		this.privateKey = privateKey;
		this.notifyUrl = notifyUrl;
		this.returnUrl = returnUrl;
	}
	
	private <T extends PayResponse> String doGen(PayRequest<T> request){
		RequestParametersHolder requestHolder = getRequestHolderWithSign(request);
		return buildRequest(requestHolder.getApplicationParams(), "get", "确认");
	}
	
	private <T extends PayResponse> RequestParametersHolder getRequestHolderWithSign(PayRequest<T> request) {
		RequestParametersHolder requestHolder = new RequestParametersHolder();
		
		if(!StringUtils.isNotEmpty(request.getBizContent())){
			throw new PayApiException("请设置bizContent");
		}
		
		//	获取bizContent
		@SuppressWarnings("unchecked")
		Map<String,String> bizContent = (Map<String,String>)JSON.parse(request.getBizContent());
		
		requestHolder.getApplicationParams().putAll(bizContent);
		
		//	设置必要参数
		requestHolder.getApplicationParams().put(PayConstants.SERVICE, request.getApiMethodName());
		requestHolder.getApplicationParams().put(PayConstants.PARTNER, this.partner);
		requestHolder.getApplicationParams().put(PayConstants.INPUT_CHARSET, this.charset);
		requestHolder.getApplicationParams().put(PayConstants.NOTIFY_URL, this.notifyUrl);
		//	设置非必要参数 (如果有)
		requestHolder.getApplicationParams().put(PayConstants.RETURN_URL,this.returnUrl);
		// 签名
		if(this.signType.equals(PayConstants.SIGN_TYPE_RSA)){
			String content = PaySignature.getSignatureContent(requestHolder);
			String sign = PaySignature.signWithRSA(content, this.privateKey, this.charset);
			requestHolder.getApplicationParams().put(PayConstants.SIGN, sign);
			requestHolder.getApplicationParams().put(PayConstants.SIGN_TYPE, this.signType);
		}
		return requestHolder;
	}
	
	
	public String buildRequest(Map<String, String> sPara, String strMethod, String strButtonName) {
		// 待请求参数数组
		List<String> keys = new ArrayList<String>(sPara.keySet());

		StringBuffer sbHtml = new StringBuffer();

		sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + alipayGateWay
				+ "_input_charset=" + charset + "\" method=\"" + strMethod + "\">");

		for (int i = 0; i < keys.size(); i++) {
			String name = (String) keys.get(i);
			String value = (String) sPara.get(name);

			sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
		}

		// submit按钮控件请不要含有name属性
		sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
		sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

		return sbHtml.toString();
	}

	@Override
	public <T extends PayResponse> String specialExecute(PayRequest<T> request) {
		return doGen(request);
	}
	
	public static void main(String[] args) {
		
	}
	
}
