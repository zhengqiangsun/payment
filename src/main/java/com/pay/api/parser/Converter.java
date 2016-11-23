package com.pay.api.parser;

import com.pay.api.response.PayResponse;

public interface Converter {
	
	/**
	 * 把字符串转换为响应对象
	 * @param rsp
	 * @param clazz
	 * @return
	 */
	public <T extends PayResponse> T toResponse(String rsp, Class<T> clazz);
	
}
