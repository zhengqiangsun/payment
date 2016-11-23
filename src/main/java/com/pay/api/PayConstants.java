package com.pay.api;

/**
 * 支付 常量
 * 
 * @author sunzhengqiang
 * @date 2016年11月17日
 */
public class PayConstants {

	public static final String SIGN_TYPE_RSA = "RSA";
	public static final String SIGN_TYPE_MD5 = "MD5";
	public static final String FEE_TYPE = "CNY";// 币种
	/** 默认时间格式 **/
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** Date默认时区 **/
	public static final String DATE_TIMEZONE = "GMT+8";
	
	/**
	 * 微信支付
	 */
	public static final String APPID = "appid";
	public static final String MCH_ID = "mch_id";
	public static final String DEVICE_INFO = "device_info";
	public static final String NONCE_STR = "nonce_str";
	public static final String SIGN = "sign";
	public static final String SIGN_TYPE = "sign_type";	
	public static final String KEY = "key";
	public static final String DEFAULT_CHARSET = "utf-8";
	public static final String FORMAT_XML = "xml";
	public static final String FORMAT_JSON = "json";
	
	/**
	 * 支付宝
	 */
	public static final String SERVICE = "service";
	public static final String PARTNER = "partner";
	public static final String INPUT_CHARSET = "_input_charset";
	public static final String NOTIFY_URL = "notify_url";
	public static final String RETURN_URL = "return_url";
	/**
	 * 
	 */
	public static final String REFUND_FASTPAY_BY_PLATFORM_PWD = "refund_fastpay_by_platform_pwd";
	
	
}
