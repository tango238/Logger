package com.plugram.logger;

public class LoggerFactory {

	public LoggerContext getLoggerContext(){
		return ConfigCommands.getContext();
	}
}
