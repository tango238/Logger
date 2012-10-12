Logger
======

A kind of Logger for practice

LogManager

  - シングルトン。常に同じインスタンスを返す

LoggerContext

  - 名前をつけて複数のLoggerContextを生成することができる

  - LogManager以外のロギングに必要なクラスはここから作成される

  - LogManagerからLoggerContextの呼び出しは弱参照で呼び出す


TODO

  - (クラスローダを作成してそれからLoggerContextを呼び出すようにする)



Configuration

  - それぞれのLoggerConfigの設定を持つ


Logger

  - LoggerConfigを持つ


LoggerConfig

  - Appenderを持つ

  - LogLevelを持つ


RootLoggerConfig

  - 固定

  - LogLevelはERROR



How to use
-------------

<pre><code>
package com.plugram.logger;

import static com.plugram.logger.ConfigCommands.*;

import com.plugram.logger.appender.ConsoleAppender;
import com.plugram.logger.config.LogLevel;

public class Main {

	static LoggerContext loggerContext = new LoggerFactory(){{
		addLoggerConfig("hoge.aaa.bbb", LogLevel.DEBUG, new ConsoleAppender());
		addLoggerConfig("hoge.bbb.ccc", LogLevel.WARN, new ConsoleAppender());
		addLoggerConfig("hoge.bbb.ccc", LogLevel.WARN, new ConsoleAppender());
		addLoggerConfig("com.plugram.logger", LogLevel.WARN, new ConsoleAppender());
		addLoggerConfig("com.plugram.logger.Main", LogLevel.ERROR, new ConsoleAppender());
	}}.getLoggerContext();
	
	static Logger logger = loggerContext.getLogger(Main.class);
	
	public static void main(String[] args){
		logger.trace("Trace message");
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warn message");
		logger.error("Error message");
		logger.fatal("Fatal message");
	}
}
</code></pre>
