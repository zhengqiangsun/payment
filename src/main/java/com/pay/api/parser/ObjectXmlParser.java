package com.pay.api.parser;

import com.pay.api.parser.xml.XmlConverter;
import com.pay.api.response.PayResponse;

public class ObjectXmlParser<T extends PayResponse> implements Parser<T>{
    private Class<T> clazz;
    
    
    public ObjectXmlParser(Class<T> clazz){
    	this.clazz = clazz;
    }
    
	@Override
	public T parse(String rsp) {
		Converter converter = new XmlConverter();
		return converter.toResponse(rsp, clazz);
	}
    
}
