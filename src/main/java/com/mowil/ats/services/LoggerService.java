package com.mowil.ats.services;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class LoggerService {

	public void debugLog(Logger logger, String msg) {
		if (logger.isDebugEnabled()) {
			logger.debug(msg);
		}
	}

	public void errorLog(Logger logger, String msg) {
		if (logger.isErrorEnabled()) {
			logger.error(msg);
		}
	}

	public void infoLog(Logger logger, String msg) {
		if (logger.isInfoEnabled()) {
			logger.info(msg);
		}
	}

	public void warnLog(Logger logger, String msg) {
		if (logger.isWarnEnabled()) {
			logger.warn(msg);
		}
	}
}
