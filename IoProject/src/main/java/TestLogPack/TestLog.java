package TestLogPack;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestLog {
	private static final Log log = LogFactory.getLog(TestLog.class);
	
	public static void main(String[] args) {
		log.debug("Exemple debug message");
		log.info("Exemple info message");
		log.warn("Exemple error message");
		log.error("Exemple error message");
		log.fatal("Exemple fatal message");
	}

}
