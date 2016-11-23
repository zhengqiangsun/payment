package com.pay.api.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import com.pay.api.PayConstants;

/**
 * 纯字符串字典结构
 * @author sunzhengqiang
 * @date 2016年11月18日
 */
public class PayHashMap extends HashMap<String, String> {

	
	private static final long serialVersionUID = -94338459998866061L;
	
	public PayHashMap() {
		super();
	}

	public PayHashMap(Map<? extends String, ? extends String> m) {
		super(m);
	}
	
	public String put(String key, Object value) {
		String strValue;

		if (value == null) {
			strValue = null;
		} else if (value instanceof String) {
			strValue = (String) value;
		} else if (value instanceof Integer) {
			strValue = ((Integer) value).toString();
		} else if (value instanceof Long) {
			strValue = ((Long) value).toString();
		} else if (value instanceof Float) {
			strValue = ((Float) value).toString();
		} else if (value instanceof Double) {
			strValue = ((Double) value).toString();
		} else if (value instanceof Boolean) {
			strValue = ((Boolean) value).toString();
		} else if (value instanceof Date) {
            DateFormat format = new SimpleDateFormat(PayConstants.DATE_TIME_FORMAT);
            format.setTimeZone(TimeZone.getTimeZone(PayConstants.DATE_TIMEZONE));
			strValue = format.format((Date) value);
		} else {
			strValue = value.toString();
		}

		return this.put(key, strValue);
	}

	public String put(String key, String value) {
		if (key != null && value != null) {
			return super.put(key, value);
		} else {
			return null;
		}
	}
}
