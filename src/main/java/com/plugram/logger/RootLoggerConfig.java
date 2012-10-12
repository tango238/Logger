package com.plugram.logger;

import com.plugram.logger.appender.ConsoleAppender;

public class RootLoggerConfig extends LoggerConfig {

	public RootLoggerConfig() {
		super(null, null, new ConsoleAppender());
	}

}
