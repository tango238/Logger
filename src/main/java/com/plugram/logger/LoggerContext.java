package com.plugram.logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.plugram.logger.config.Configuration;
import com.plugram.logger.config.DefaultConfiguration;
import com.plugram.logger.exception.LoggerNotRunningException;

public class LoggerContext {

	/** The context name */
	private final String name;

	private LoggerConfig root = new RootLoggerConfig();
	
	private Configuration config = new DefaultConfiguration();

	private Lock lock = new ReentrantLock();
	
//	private ConcurrentMap<String, Logger> loggers = new ConcurrentHashMap<String, Logger>();
	
	public enum Status {
		INITIALIZED, RUNNING, STOPPING, STOPPED
	}

	private volatile Status status = Status.INITIALIZED;

	public String getName(){
		return name;
	}
	
	public LoggerContext(String name) {
		this.name = name;
	}

	public Logger getLogger(Class<?> clazz){
		return getLogger(clazz.getName());
	}
	
	public Logger getLogger(String name) {
		// TODO The order of instantiation. 
		// [Configuration -> LoggerConfig -> Logger]
		LoggerConfig loggerConfig = config.getLoggerConfig(name);
		if(loggerConfig == null){
			return root.getLogger();
		}
		return loggerConfig.getLogger();
	}
	
	/**
	 * Returns the configuration.
	 * @return
	 */
	public Configuration getConfig() {
		return config;
	}

	public void start() {
		if (lock.tryLock()) {
			try {
				if (status == Status.INITIALIZED) {
					// TODO 設定ファイルから読み込む
					loadConfiguration();
					status = Status.RUNNING;
				}
			} finally {
				lock.unlock();
			}
		}
	}

	private synchronized void loadConfiguration() {
		// TODO we should surely dispose the previous configuration.
		// this.config.dispose();
		Configuration config = new DefaultConfiguration();
		config.start();
		this.config = config;
	}

	public void stop() {
		if(lock.tryLock()){
			try { 
				status = Status.STOPPING;
				destroyConfiguration();
				status = Status.STOPPED;
			} finally {
				lock.unlock();
			}
		}
	}

	private synchronized void destroyConfiguration() {
		System.out.println("destroyConfiguration.");
		config.stop();
	}

	/**
	 * Reloads the configuration.
	 * @param traceConfiguration
	 */
	public void reconfigure(Configuration configuration) {
		lock.lock();
		if(status != Status.RUNNING){
			throw new LoggerNotRunningException();
		}
		try {
			configuration.stop();
			configuration.start();
			this.config = configuration;
		} finally {
			lock.unlock();
		}
	}

}
