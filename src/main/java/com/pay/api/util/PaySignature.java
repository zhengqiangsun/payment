package com.pay.api.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;



/**
 * 签名
 * @author sunzhengqiang
 * @date 2016年11月18日
 */
public class PaySignature {
	
	public static final String  SIGN_ALGORITHMS = "SHA1WithRSA";
	
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d","e", "f" };
	
	private static final Logger logger = Logger.getLogger(PaySignature.class);
	
	private static final String[] EXCLUDE_KEY = new String[]{"sign","sign_type","privateKey"};
	
	/**
	 * 签名内容
	 * @param requestHolder
	 * @return
	 */
	public static String getSignatureContent(RequestParametersHolder requestHolder){
		return getSignContent(getSortedMap(requestHolder));
	}
	
	/**
	 * 取得字典序 排序Map
	 * @param requestHolder
	 * @return
	 */
	public static Map<String, String> getSortedMap(RequestParametersHolder requestHolder){
		Map<String, String> sortedParams = new TreeMap<String, String>();
		PayHashMap appParams = requestHolder.getApplicationParams();
		
        if (appParams != null && appParams.size() > 0) {
            sortedParams.putAll(appParams);
        }
        
        PayHashMap protocalMustParams = requestHolder.getProtocalMustParams();
        if (protocalMustParams != null && protocalMustParams.size() > 0) {
            sortedParams.putAll(protocalMustParams);
        }
        PayHashMap protocalOptParams = requestHolder.getProtocalOptParams();
        if (protocalOptParams != null && protocalOptParams.size() > 0) {
            sortedParams.putAll(protocalOptParams);
        }

        return sortedParams;
	}
	
	/**
	 * 待签名字段
	 * @param sortedParams
	 * @return
	 */
    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = sortedParams.get(key);
            //	排除字段
            for(String ek:EXCLUDE_KEY){
        		if(ek.equals(key)){
        			logger.info("排除字段:" + ek);
        			continue;
        		}
        	}
            if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }
	
	/**
	 * MD5签名
	 * @param content
	 * @param privateKey
	 * @return
	 */
	public static String signWithMD5(String content,String charset) {
		return MD5Encode(content, charset).toUpperCase();
	}
	
	/**
	 * MD5加密
	 * 
	 * @param origin
	 * @param charsetname
	 * @return
	 */
	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(exception.getMessage());
		}
		return resultString;
	}
	
	
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));
		return resultSb.toString();
	}
	
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
	/**
	 * 生成签名结果
	 * @param content
	 * @param privateKey
	 * @param charset
	 * @return
	 */
	public static String signWithRSA(String content,String privateKey,String charset) {
		String mysign = "";
		
		mysign = RSA.sign(content, privateKey, charset);
		
		return mysign;
	}
	
}
