package com.pay.api.parser;

/**
 * 
 * @author sunzhengqiang
 * @date 2016年11月18日
 * @param <T>
 */
public interface Parser<T> {
	/**
     * 把响应字符串解释成相应的领域对象。
     * 
     * @param rsp 响应字符串
     * @return 领域对象
     */
	 public T parse(String rsp);
	 
}
