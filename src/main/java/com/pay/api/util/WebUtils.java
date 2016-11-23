package com.pay.api.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.pay.api.PayConstants;

public class WebUtils {

	private static final Logger logger = Logger.getLogger(WebUtils.class);
	
    //表示请求器是否已经做了初始化工作
    private boolean hasInit = false;
    private CloseableHttpClient client;
	private String keyStorePath;//密钥库路径
	private String keyStorepass;//密钥库密码
    
    public WebUtils(){
    	init();
    }
    
    public WebUtils(String keyStorePath,String keyStorepass){
    	this.keyStorePath = keyStorePath;
    	this.keyStorepass = keyStorepass;
    	init();
    }
    
    private void init(){
    	CustomHttpClientBuilder customHttpClientBuilder = CustomHttpClientBuilder.create();
    	if(Stringutils.areNotEmpty(keyStorepass,keyStorePath)){
    		try {
				customHttpClientBuilder.ssl(keyStorePath, keyStorepass);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("初始化失败",e);
			}
    	}
    	client = customHttpClientBuilder.build();
    }
    
    public String post(String uri,String postData){
    	
    	if(!hasInit){init();}
    	
    	String result = null;
    	try{
	    	HttpPost postReq = new HttpPost(uri);
			// 得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
			StringEntity postEntity = new StringEntity(postData, PayConstants.DEFAULT_CHARSET);
			logger.info("API，POST过去的数据是：\n" + postData);
			
			postReq.addHeader("Content-Type", "text/xml");
			postReq.setEntity(postEntity);
			
			CloseableHttpResponse httpRsp = client.execute(postReq);
			HttpEntity entity = httpRsp.getEntity();
			result = EntityUtils.toString(entity, PayConstants.DEFAULT_CHARSET);
    	} catch(Exception e){
    		e.printStackTrace();
    		logger.error("post 失败",e);
    	}
		return result;
    }
    

}
