package com.pay.api.request;

import java.util.Map;

import com.pay.api.response.PayResponse;

public interface PayRequest<T extends PayResponse> {
	
    /**
     * 获取TOP的API名称。
     * 
     * @return API名称
     */
    public String getApiMethodName();
    
    /**
     * 获取所有的Key-Value形式的文本请求参数集合。其中：
     * <ul>
     * <li>Key: 请求参数名</li>
     * <li>Value: 请求参数值</li>
     * </ul>
     * 
     * @return 文本请求参数集合
     */
    public Map<String, String> getTextParams();
    
    /**
     * 设置业务Json格式数据
     * @param bizContent
     */
	public void setBizContent(String bizContent);
	/**
	 * 取得业务Json格式数据
	 * @return
	 */
	public String getBizContent();
	
    /**
     * 得到当前API的响应结果类型
     * 
     * @return 响应类型
     */
    public Class<T> getResponseClass();
    
}
