package com.pay.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 退款
 * @author sunzhengqiang
 * @date 2016年11月18日
 */
public class WxPayTradeRefundResponse extends WxPayResponse{
	
	private static final long serialVersionUID = -4893616820926059980L;
	
	@XStreamAlias("transaction_id")
	private String transactionId;
	@XStreamAlias("out_trade_no")
	private String outTradeNo;
	@XStreamAlias("out_refund_no")
	private String outRefundNo;
	@XStreamAlias("refund_id")
	private String refundId;
	@XStreamAlias("refund_channel")
	private String refundChannel;
	@XStreamAlias("refund_fee")
	private String refundFee;
	@XStreamAlias("settlement_refund_fee")
	private String settlementRefundFee;
	@XStreamAlias("total_fee")
	private String totalFee;
	@XStreamAlias("settlement_total_fee")
	private String settlementTotalFee;
	@XStreamAlias("fee_type")
	private String feeType;
	@XStreamAlias("cash_fee")
	private String cashFee;
	@XStreamAlias("cash_refund_fee")
	private String cashRefundFee;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getOutRefundNo() {
		return outRefundNo;
	}
	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}
	public String getRefundId() {
		return refundId;
	}
	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}
	public String getRefundChannel() {
		return refundChannel;
	}
	public void setRefundChannel(String refundChannel) {
		this.refundChannel = refundChannel;
	}
	public String getRefundFee() {
		return refundFee;
	}
	public void setRefundFee(String refundFee) {
		this.refundFee = refundFee;
	}
	public String getSettlementRefundFee() {
		return settlementRefundFee;
	}
	public void setSettlementRefundFee(String settlementRefundFee) {
		this.settlementRefundFee = settlementRefundFee;
	}
	public String getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}
	public String getSettlementTotalFee() {
		return settlementTotalFee;
	}
	public void setSettlementTotalFee(String settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getCashFee() {
		return cashFee;
	}
	public void setCashFee(String cashFee) {
		this.cashFee = cashFee;
	}
	public String getCashRefundFee() {
		return cashRefundFee;
	}
	public void setCashRefundFee(String cashRefundFee) {
		this.cashRefundFee = cashRefundFee;
	}
	
	
	
	
}
