package com.plugram.logger;

import com.plugram.logger.config.LogLevel;

public class Logger {

	private LoggerConfig loggerConfig; 
	
	public Logger(LoggerConfig loggerConfig) {
		this.loggerConfig = loggerConfig;
	}

	/**
	 * Returns the name of the Logger.
	 * @return
	 */
	public String getName() {
		return loggerConfig.getName();
	}

	public boolean isTraceEnabled() {
		return isLogLevelEnabled(LogLevel.TRACE);
	}

	public boolean isDebugEnabled() {
		
		return isLogLevelEnabled(LogLevel.DEBUG);
	}

	private boolean isLogLevelEnabled(LogLevel level) {
		return loggerConfig.getLevel().compareTo(level) >= 0;		
	}
}
