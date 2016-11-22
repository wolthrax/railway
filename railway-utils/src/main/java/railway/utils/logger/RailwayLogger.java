package railway.utils.logger;

import org.apache.log4j.Logger;

public class RailwayLogger {
	
	private static Logger log;
	
	@SuppressWarnings("rawtypes")
	public static void logError(Class clazz, String message){
		log = Logger.getLogger(clazz);
		log.error(message);
	}

}