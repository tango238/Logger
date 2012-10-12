package com.plugram.logger;

public class Main {

	static Logger logger = LogManager.getManager().getLoggerContext().getLogger(Main.class);
	
	public static void main(String[] args){
		System.out.println(logger.getName());
	}
}
