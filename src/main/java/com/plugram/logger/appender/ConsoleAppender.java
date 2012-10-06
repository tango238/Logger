package com.plugram.logger.appender;

public class ConsoleAppender implements Appender {

	
	@Override
	public void write(byte[] buffer) {
		System.out.println(new String(buffer));
	}

}
