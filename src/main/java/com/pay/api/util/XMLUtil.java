package com.pay.api.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

/**
 * XML 工具
 * @author sunzhengqiang
 * @date 2016年11月18日
 */
public class XMLUtil {
	private static final Logger logger = Logger.getLogger(XMLUtil.class);
	/**
	 * 生成XML
	 * @param requestHolder
	 * @return
	 */
	public static String toXML(RequestParametersHolder requestHolder){
		Document document = DocumentHelper.createDocument();
		
		List<String> keys = new ArrayList<String>(requestHolder.getApplicationParams().keySet());
		Collections.sort(keys);
		Element root = document.addElement("xml");
		for(String key:keys){
			String value = requestHolder.getApplicationParams().get(key);
			if(key.equals("") || StringUtils.isEmpty(value)){
				continue;
			}
			Element ele = new BaseElement(key);
			if (key.equalsIgnoreCase("body")) {
				ele.addCDATA(value);
			} else {
				ele.setText(value);
			}
			root.add(ele);
		}
		logger.info("转换结果:" + document.asXML());
		return document.asXML();
	}
	
}
