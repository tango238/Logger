package com.plugram.logger.config;

import com.plugram.logger.LoggerConfig;

public class BaseLogLevelConfiguration extends AbstractConfiguration {

	private LogLevel level;
	
	public BaseLogLevelConfiguration(LogLevel level) {
		this.level = level;
	}

	@Override
	public void start() {
		LoggerConfig loggerConfig = new LoggerConfig("com.plugram.logger.Main", level);
		loggerConfigs.putIfAbsent("com.plugram.logger.Main", loggerConfig);
	}

}
