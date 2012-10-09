package com.plugram.logger.config;

public enum LogLevel {
	
	TRACE(0), DEBUG(1), WARN(2), ERROR(3), FATAL(4);

	private final int value;

	private LogLevel(int value) {
		this.value = value;
	}

	public int getIntLevel() {
		return value;
	}

	
}
