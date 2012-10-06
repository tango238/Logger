package com.plugram.logger;

import com.plugram.logger.config.BaseConfiguration;
import com.plugram.logger.config.Configuration;

public class LoggerContext {
	
	/** The context name */
	private final String name;
	
	/* とりあえずConfigurationは固定 */
	private Configuration config = new BaseConfiguration();
	
	public LoggerContext(String name) {
		this.name = name;
	}

	public Logger getLogger(String name) {
		return new Logger();
	}

}
