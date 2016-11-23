package com.pay.api.util;

/**
 * 请求参数-持有
 * @author sunzhengqiang
 * @date 2016年11月18日
 */
public class RequestParametersHolder {
	private PayHashMap protocalMustParams;//协议必须参数
	private PayHashMap protocalOptParams;//可选参数
	private PayHashMap applicationParams = new PayHashMap();//应用参数

	public PayHashMap getProtocalMustParams() {
		return protocalMustParams;
	}
	public void setProtocalMustParams(PayHashMap protocalMustParams) {
		this.protocalMustParams = protocalMustParams;
	}
	public PayHashMap getProtocalOptParams() {
		return protocalOptParams;
	}
	public void setProtocalOptParams(PayHashMap protocalOptParams) {
		this.protocalOptParams = protocalOptParams;
	}
	public PayHashMap getApplicationParams() {
		return applicationParams;
	}
	public void setApplicationParams(PayHashMap applicationParams) {
		this.applicationParams = applicationParams;
	}
}
