package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Log;
import com.piltover.repository.LogRepository;
import com.piltover.service.LogService;

@Service
public class LogServiceImpl implements LogService{
	
	@Autowired
	LogRepository logRepository;

	@Override
	public List<Log> getAllLogByID(Long accID) {
		
		return logRepository.findLogsByAccountId(accID);
	}

	@Override
	public void addLog(Log log) {
		logRepository.saveAndFlush(log);
	}

	@Override
	public List<Log> getAllLog() {
		// TODO Auto-generated method stub
		return logRepository.findAll();
	}

}
