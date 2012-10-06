package com.plugram.logger.config;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultConfigurationTest {

	@Test
	public void testLevel() {
		DefaultConfiguration config = new DefaultConfiguration();
		config.start();
		// LogLevel
		LogLevel level = config.getLevel();
		assertThat(level, is(LogLevel.DEBUG));
		// Appender
	}

}
