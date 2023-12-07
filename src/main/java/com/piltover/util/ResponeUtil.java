package com.piltover.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.piltover.entity.Account;

@Component
public class ResponeUtil {
	Map<String, Object> responeMap = new HashMap<>();
	public void putRespone(String name, String content) {
		responeMap.put(name, content);
	}
	
	public void putRespone(String name, Account content) {
		responeMap.put(name, content);
	}
	
	public Map<String, Object> getRespone() {
		return responeMap;
	}
	
	public void clearRespone() {
        responeMap.clear();
    }
}
