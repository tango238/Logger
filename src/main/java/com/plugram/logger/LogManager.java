package com.plugram.logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LogManager {

	private static final String DEFAULT_NAME = "default"; 
	
	private static LogManager manager;
	
	private static Map<String, LoggerContext> contexts = new ConcurrentHashMap<String, LoggerContext>();
	
	static {
		 manager = new LogManager();
		 contexts.put(DEFAULT_NAME, new LoggerContext());
	}
	
	private Lock lock = new ReentrantLock();
	
	public static LogManager getManager() {
		return manager;
	}
	
	public LoggerContext getLoggerContext() {
		return this.getLoggerContext(DEFAULT_NAME);
	}
	
	public LoggerContext getLoggerContext(String name) {
		lock.lock();
		try {
			if(contexts.get(name) == null){
				LoggerContext context = new LoggerContext();
				contexts.put(name, context);
				return context;
			}
		} finally {
			lock.unlock();
		}
		return contexts.get(name);
	}
}
