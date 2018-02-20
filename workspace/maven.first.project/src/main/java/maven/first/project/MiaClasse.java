package maven.first.project;

import org.apache.log4j.Logger;

public class MiaClasse {
	final static Logger logger = Logger.getLogger(MiaClasse.class);

	public MiaClasse() {
		logger.debug("Hai istanziato la classe MiaClasse...");
		logger.error("Hai istanziato la classe MiaClasse...");
		logger.fatal("Hai istanziato la classe MiaClasse...");
		logger.info("Hai istanziato la classe MiaClasse...");
	}
}
