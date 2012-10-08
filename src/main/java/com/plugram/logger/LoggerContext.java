package com.plugram.logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.plugram.logger.config.BaseConfiguration;
import com.plugram.logger.config.Configuration;
import com.plugram.logger.config.DefaultConfiguration;
import com.plugram.logger.config.MyConfiguration;

public class LoggerContext {

	/** The context name */
	private final String name;

	private Configuration config = new BaseConfiguration();

	private Lock lock = new ReentrantLock();
	
	private ConcurrentMap<String, Logger> loggers = new ConcurrentHashMap<String, Logger>();
	
	public enum Status {
		INITIALIZED, STARTED, STOPPING, STOPPED
	}

	private volatile Status status = Status.INITIALIZED;

	public String getName(){
		return name;
	}
	
	public LoggerContext(String name) {
		this.name = name;
	}

	public Logger getLogger(String name) {
		Logger logger = loggers.get(name);
		if(logger != null){
			return logger;
		}
		logger = createLogger(name);
		Logger prev = loggers.putIfAbsent(name, logger);
		return prev == null ? logger : prev;
	}
	
	/**
	 * Returns the configuration.
	 * @return
	 */
	public Configuration getConfig() {
		return config;
	}

	protected Logger createLogger(String name) {
		return new Logger(name, this);
	}

	public void start() {
		if (lock.tryLock()) {
			try {
				if (status == Status.INITIALIZED) {
					// TODO 設定ファイルから読み込む
					loadConfiguration();
					status = Status.STARTED;
				}
			} finally {
				lock.unlock();
			}
		}
	}

	private synchronized void loadConfiguration() {
		// TODO we should surely dispose the previous configuration.
		// this.config.dispose();
		Configuration config = new MyConfiguration();
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
		config.stop();
	}

}
