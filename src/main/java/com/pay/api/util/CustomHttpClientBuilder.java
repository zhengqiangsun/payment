package com.pay.api.util;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class CustomHttpClientBuilder extends HttpClientBuilder{
	
	private String keyStorePath;//密钥库路径
	private String keyStorepass;//密钥库密码
	
    protected CustomHttpClientBuilder() {
        super();
    }
	
    public static CustomHttpClientBuilder create() {
        return new CustomHttpClientBuilder();
    }
    
    public CustomHttpClientBuilder ssl(String keyStorePath,String keyStorepass) throws Exception{
    	this.keyStorePath = keyStorePath;
    	this.keyStorepass = keyStorepass;
    	ssl();
    	return this;
    }
    
    private CustomHttpClientBuilder ssl() throws Exception{
    	KeyStore keyStore = KeyStore.getInstance("PKCS12");
		FileInputStream fis = new FileInputStream(new File(this.keyStorePath));
		keyStore.load(fis, this.keyStorepass.toCharArray());
		SSLContext ctx = org.apache.http.ssl.SSLContexts.custom().loadKeyMaterial(keyStore, this.keyStorepass.toCharArray()).build();
		this.setSSLContext(ctx);
		return this;
    }
    
    public static void main(String[] args) throws Exception {
    	CustomHttpClientBuilder builder = CustomHttpClientBuilder.create().ssl("path", "pass");
    	CloseableHttpClient client = builder.build();
    	
	}
}
