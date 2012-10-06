package com.plugram.logger.config;

public interface Configuration {

	public void start();
	
	public void stop();
	
	public LogLevel getLevel();
	
}
