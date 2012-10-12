package com.plugram.logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import com.plugram.logger.appender.Appender;
import com.plugram.logger.config.AbstractConfiguration;
import com.plugram.logger.config.Configuration;
import com.plugram.logger.config.LogLevel;

public class ConfigCommands {

	private static LoggerContext context = LogManager.getManager().getLoggerContext();
	
	private static List<LoggerConfig> configs = new ArrayList<LoggerConfig>();
	
	private static AtomicBoolean initialized = new AtomicBoolean(false);
	
	private ConfigCommands () {
	}
	
	public static void addLoggerConfig(String name, LogLevel level, Appender appender) {
		configs.add(new LoggerConfig(name, level, appender));
	}
	
	static LoggerContext getContext() {
		if(!initialized.get()){
			Configuration configuration = new AbstractConfiguration() {
				@Override
				public void start() {
					for(LoggerConfig config : configs) {
						addLoggerConfig(config);
					}
				}
			};
			context.reconfigure(configuration);
		}
		initialized.set(true);
		return context;
	}
}
