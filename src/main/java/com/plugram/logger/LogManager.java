package com.plugram.logger;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;


public class LogManager {

	private static final String DEFAULT_NAME = "default"; 
	
	private static LogManager manager;
	
	private static ConcurrentMap<String, AtomicReference<WeakReference<LoggerContext>>> contexts = new ConcurrentHashMap<String, AtomicReference<WeakReference<LoggerContext>>>();
	
	static {
		 manager = new LogManager();
		 WeakReference<LoggerContext> ref = new WeakReference<LoggerContext>(new LoggerContext(DEFAULT_NAME));
		 contexts.putIfAbsent(DEFAULT_NAME, new AtomicReference<WeakReference<LoggerContext>>(ref));
	}
	
	public static LogManager getManager() {
		return manager;
	}
	
	public LoggerContext getLoggerContext() {
		return this.getLoggerContext(DEFAULT_NAME);
	}
	
	public LoggerContext getLoggerContext(String name) {
		AtomicReference<WeakReference<LoggerContext>> ref = contexts.get(name);
		if(ref == null){
			LoggerContext context = new LoggerContext(name);
			WeakReference<LoggerContext> wr = new WeakReference<LoggerContext>(context);
			AtomicReference<WeakReference<LoggerContext>> r = new AtomicReference<WeakReference<LoggerContext>>(wr);
			contexts.putIfAbsent(name, r);
			return contexts.get(name).get().get();
		}
		return contexts.get(name).get().get();
	}
}
