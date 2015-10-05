package sgd_import_xml.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
	
	@SuppressWarnings("rawtypes")
	public static void logErro(Class classeLog, String mensagemLog){
		final Logger logger = LoggerFactory.getLogger(classeLog);
		logger.info(mensagemLog);
	}

}
