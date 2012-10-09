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
	
	private boolean isLogLevelEnabled(LogLevel level) {
		return loggerConfig.getLevel().compareTo(level) >= 0;		
	}
	
	public boolean isTraceEnabled() {
		return isLogLevelEnabled(LogLevel.TRACE);
	}

	public boolean isDebugEnabled() {
		return isLogLevelEnabled(LogLevel.DEBUG);
	}

	public Boolean isWarnEnabled() {
		return isLogLevelEnabled(LogLevel.WARN);
	}

	public Boolean isErrorEnabled() {
		return isLogLevelEnabled(LogLevel.ERROR);
	}

	public Boolean isFatalEnabled() {
		return isLogLevelEnabled(LogLevel.FATAL);
	}
}
