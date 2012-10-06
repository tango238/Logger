package com.plugram.logger.config;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.plugram.logger.appender.ConsoleAppender;

public class BaseConfigurationTest {

	@Test
	public void testAppenders() {
		BaseConfiguration config = new BaseConfiguration();
		config.addAppender("A1", new ConsoleAppender());
		config.addAppender("A2", new ConsoleAppender());
		assertThat(config.getAppenders().size(), is(2));
		config.addAppender("A3", new ConsoleAppender());
		assertThat(config.getAppenders().size(), is(3));
		// 同じ名前のAppenderは上書きされる
		config.addAppender("A3", new ConsoleAppender());
		assertThat(config.getAppenders().size(), is(3));
	}

}
