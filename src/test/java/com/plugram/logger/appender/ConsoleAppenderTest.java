package com.plugram.logger.appender;

import org.junit.Test;

public class ConsoleAppenderTest {

	@Test
	public void testWrite() {
		String str = "こんにちは世界";
		byte[] buffer = str.getBytes();
		ConsoleAppender console = new ConsoleAppender();
		console.write(buffer);
		// TODO 目視確認・・・
	}

}
