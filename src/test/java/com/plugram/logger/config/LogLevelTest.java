package com.plugram.logger.config;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LogLevelTest {

	@Test
	public void testIsLowerEquals() {
		assertFalse(LogLevel.ERROR.isLowerEquals(LogLevel.DEBUG));
		assertTrue(LogLevel.DEBUG.isLowerEquals(LogLevel.ERROR));
		assertTrue(LogLevel.DEBUG.isLowerEquals(LogLevel.DEBUG));
	}

}
