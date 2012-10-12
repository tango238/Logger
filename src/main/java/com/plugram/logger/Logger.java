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
		return loggerConfig.getLevel().compareTo(level) <= 0;		
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
	
	public void trace(String msg) {
		if(isTraceEnabled()) 
			loggerConfig.log(msg);
	}
	
	public void debug(String msg) {
		if(isDebugEnabled()) 
			loggerConfig.log(msg);
	}
	
	public void warn(String msg) {
		if(isWarnEnabled()) 
			loggerConfig.log(msg);
	}
	
	public void error(String msg) {
		if(isErrorEnabled()) 
			loggerConfig.log(msg);
	}
	
	public void fatal(String msg) {
		if(isFatalEnabled()) 
			loggerConfig.log(msg);
	}
}
