package resource.commonutils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class RestLogger {

	public static Logger log = Logger.getLogger(RestLogger.class.getName());

	public static void initLogger() {
		PropertyConfigurator.configure("log4j.properties");
	}

	public static Logger getLogger() {
		return log;
	}

	public static void startTestCase(String sTestCaseName) {

		log.info("*****************************************************");
		log.info("*****************************************************");
		log.info("$$$$$$$$$$$$$$$$$" + sTestCaseName + "$$$$$$$$$$$$$$$");
		log.info("*****************************************************");
		log.info("*****************************************************");
	}

	public static void endTestCase() {

		log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		log.info("XXXXXXXXXXXXXXX" + "E---N---D" + "XXXXXXXXXXXXXXXX");
		log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		log.info("X");
		log.info("X");
		log.info("X");
		log.info("X");
		log.info("X");
	}

	public static void info(String msg) {
		log.info(msg);
	}

	public static void ward(String msg) {
		log.warn(msg);
	}

	public static void err(String msg) {
		log.error(msg);
	}

	public static void debug(String msg) {
		log.debug(msg);
	}

	public static void fatal(String msg) {
		log.fatal(msg);
	}

}
