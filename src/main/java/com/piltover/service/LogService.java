package com.piltover.service;

import java.util.List;

import com.piltover.entity.Log;

public interface LogService {
	// Lấy tất cả log
	List<Log> getAllLog();
	
	
	// Lấy log theo accID
	List<Log> getAllLogByID(Long accID);
	
	// Thêm log
	void addLog(Log log);
}
