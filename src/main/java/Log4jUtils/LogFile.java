package Log4jUtils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LogFile {

	public static Logger logger = LogManager.getLogger(LogFile.class);
	
	// We can use it when starting tests
	public static void startLog(String testClassName) {
		logger.info("******************Test is Starting...**********************");
	}

	// We can use it when ending tests
	public static void endLog(String testClassName) {
		logger.info("Test is Ending...");
	}

	// Info Level Logs
	public static void info(String message) {
		logger.info(message);
	}

	// Warn Level Logs
	public static void warn(String message) {
		logger.warn(message);
	}

	// Error Level Logs
	public static void error(String message) {
		logger.error(message);
	}

	// Fatal Level Logs
	public static void fatal(String message) {
		logger.fatal(message);
	}

	// Debug Level Logs
	public static void debug(String message) {
		logger.debug(message);
	}
}