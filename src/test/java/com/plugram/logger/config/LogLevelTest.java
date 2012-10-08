package com.plugram.logger.config;

import static org.junit.Assert.*;

import org.junit.Test;

public class LogLevelTest {

	@Test
	public void testIsLowerEquals() {
		assertFalse(LogLevel.ERROR.isLowerEquals(LogLevel.DEBUG));
		assertTrue(LogLevel.DEBUG.isLowerEquals(LogLevel.ERROR));
		assertTrue(LogLevel.DEBUG.isLowerEquals(LogLevel.DEBUG));
	}
	
	@Test
	public void testIsHigerThan() throws Exception {
		assertTrue(LogLevel.ERROR.isHigherThan(LogLevel.DEBUG));
		assertFalse(LogLevel.DEBUG.isHigherThan(LogLevel.ERROR));
		assertFalse(LogLevel.DEBUG.isHigherThan(LogLevel.DEBUG));
	}

}
