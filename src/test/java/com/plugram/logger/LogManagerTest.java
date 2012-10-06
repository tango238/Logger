package com.plugram.logger;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LogManagerTest {

	@Test
	public void testLoadLogManager() throws Exception {
		// LogManagerをロード
		LogManager manager = LogManager.getManager();
		assertThat(manager, is(notNullValue()));
		// LogManagerは何回呼んでも同じインスタンスを取得
		LogManager manager2 = LogManager.getManager();
		assertEquals(manager, manager2);
	}

	@Test
	public void testLoad() throws Exception {
		// LogManagerをロード
		LogManager manager = LogManager.getManager();
		
		// LogContextを取得
		LoggerContext context = manager.getLoggerContext("default");
		assertThat(context, is(notNullValue()));
		// LoggerContextはgetLoggerContextの引数に与えられた名前に応じたものが返される
		LoggerContext context2 = manager.getLoggerContext("default");
		assertThat(context, is(context2));

		// LoggerContextはgetLoggerContextの引数に与えられた名前が違う場合は違うインスタンスを返す
		LoggerContext context3 = manager.getLoggerContext("default2");
		assertThat(context3, is(notNullValue()));
		assertThat(context, is(not(context3)));
		
		LoggerContext context4 = manager.getLoggerContext("default2");
		assertThat(context3, is(context4));
	}
}
