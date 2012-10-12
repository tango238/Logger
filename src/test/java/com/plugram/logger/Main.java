package com.plugram.logger;

import com.plugram.logger.config.TraceConfiguration;

public class Main {

	public static void main(String[] args){
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new TraceConfiguration());
		Logger logger = context.getLogger(Main.class);
		System.out.println(logger.getName());
	}
}
