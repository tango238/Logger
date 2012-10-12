package com.plugram.logger;

import com.plugram.logger.appender.ConsoleAppender;
import com.plugram.logger.config.LogLevel;

public class RootLoggerConfig extends LoggerConfig {

	public RootLoggerConfig() {
		super(null, LogLevel.ERROR, new ConsoleAppender());
	}

}
