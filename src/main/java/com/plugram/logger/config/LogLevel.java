package com.plugram.logger.config;

public enum LogLevel {
	
	TRACE(0), DEBUG(1), INFO(2), WARN(3), ERROR(4), FATAL(5);

	private final int value;

	private LogLevel(int value) {
		this.value = value;
	}

	public int getIntLevel() {
		return value;
	}

	
}
