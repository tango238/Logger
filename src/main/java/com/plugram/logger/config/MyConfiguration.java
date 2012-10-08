package com.plugram.logger.config;

import com.plugram.logger.LoggerConfig;

public class MyConfiguration extends BaseConfiguration {

	@Override
	public void start() {
		loggerConfigs.putIfAbsent("com.plugram.action", new LoggerConfig());
		loggerConfigs.putIfAbsent("com.plugram.service", new LoggerConfig());
		loggerConfigs.putIfAbsent("com.plugram.logic", new LoggerConfig());
		loggerConfigs.putIfAbsent("com.plugram.dao", new LoggerConfig());
	}
	
}
