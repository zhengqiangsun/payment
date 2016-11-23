package com.pay.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class WxPayTradeCreateResponse extends WxPayResponse{

	private static final long serialVersionUID = 1294575627257762869L;
	@XStreamAlias("trade_type")
	private String tradeType;
	@XStreamAlias("prepay_id")
	private String prepayId;
	@XStreamAlias("code_url")
	private String codeUrl;
	
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getPrepayId() {
		return prepayId;
	}
	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}
	public String getCodeUrl() {
		return codeUrl;
	}
	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}
	
	
	
}
