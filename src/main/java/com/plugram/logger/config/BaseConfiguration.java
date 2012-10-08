package com.plugram.logger.config;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.plugram.logger.LoggerConfig;
import com.plugram.logger.appender.Appender;

public class BaseConfiguration implements Configuration {

	protected ConcurrentMap<String, Appender> appenders = new ConcurrentHashMap<String, Appender>();

	protected ConcurrentMap<String, LoggerConfig> loggerConfigs = new ConcurrentHashMap<String, LoggerConfig>();
	
	@Override
	public LoggerConfig getLoggerConfig(String name) {
		return loggerConfigs.get(name);
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
	 * @return Map&lt;String, Appender&gt; appenders
	 */
	public Map<String, Appender> getAppenders() {
		return Collections.unmodifiableMap(appenders);
	}

	@Override
	public LogLevel getLevel() {
		return LogLevel.ERROR;
	}

	@Override
	public void start() {
	}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

}
