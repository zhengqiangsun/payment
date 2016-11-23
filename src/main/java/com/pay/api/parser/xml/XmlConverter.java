package com.pay.api.parser.xml;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.pay.api.parser.Converter;
import com.pay.api.parser.ObjectXmlParser;
import com.pay.api.parser.Parser;
import com.pay.api.response.PayResponse;
import com.pay.api.response.WxPayTradeRefundResponse;
import com.thoughtworks.xstream.XStream;

public class XmlConverter implements Converter{
	
	private static final Logger logger = Logger.getLogger(XmlConverter.class);
	@Override
	public <T extends PayResponse> T toResponse(String rsp, Class<T> clazz) {
		logger.info("param {rsp= " + rsp + ", clazz = " + clazz.getName() + "}");
		XStream xStream = new XStream();
		// 处理根路径别名
		xStream.alias("xml", clazz);
		xStream.autodetectAnnotations(true);
		xStream.ignoreUnknownElements();
		T t = (T) xStream.fromXML(rsp);
		return t;
	}
	
	public static void main(String[] args) {
		String xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><appid><![CDATA[wx2421b1c4370ec43b]]></appid></xml>";
		Parser<WxPayTradeRefundResponse> parser = new ObjectXmlParser<WxPayTradeRefundResponse>(WxPayTradeRefundResponse.class);
		WxPayTradeRefundResponse rsp = parser.parse(xml);
		System.out.println(JSON.toJSONString(rsp));
	}

}
