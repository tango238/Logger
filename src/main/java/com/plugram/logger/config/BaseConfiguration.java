package com.plugram.logger.config;

public class BaseConfiguration implements Configuration {

	
	@Override
	public LogLevel getLevel() {
		return LogLevel.DEBUG;
	}

	@Override
	public void start() {
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

}
