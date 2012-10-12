package com.plugram.logger.config;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.plugram.logger.LoggerConfig;
import com.plugram.logger.appender.Appender;

public abstract class AbstractConfiguration implements Configuration {

	protected ConcurrentMap<String, Appender> appenders = new ConcurrentHashMap<String, Appender>();

	protected ConcurrentMap<String, LoggerConfig> loggerConfigs = new ConcurrentHashMap<String, LoggerConfig>();
	
	
	@Override
	public LoggerConfig getLoggerConfig(String name) {
		return loggerConfigs.get(name);
	}

	@Override
	public void addLoggerConfig(String name, LogLevel level, Appender appender) {
		LoggerConfig loggerConfig = new LoggerConfig(name, level, appender);
		addLoggerConfig(loggerConfig);
	}

	@Override
	public void addLoggerConfig(LoggerConfig loggerConfig) {
		loggerConfigs.putIfAbsent(loggerConfig.getName(), loggerConfig);
	}

	@Override
	public Map<String, LoggerConfig> getLoggerConfigs() {
		return Collections.unmodifiableMap(loggerConfigs);
	}
	
	/** 
	 * Adds appenders to the configuration.
	 * 
	 * @param name
	 * @param appender
	 */
	public void addAppender(String name, Appender appender) {
		appenders.putIfAbsent(name,appender);
	}
	
	/**
	 * Returns appenders.
	 * 
	 * @return 
	 */
	public Map<String, Appender> getAppenders() {
		return Collections.unmodifiableMap(appenders);
	}
	

	@Override
	public void start() {
		
	}
	
	@Override
	public void stop() {
		loggerConfigs.clear();
		appenders.clear();
	}

}
