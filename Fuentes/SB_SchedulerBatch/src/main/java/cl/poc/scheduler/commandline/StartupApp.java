package cl.poc.scheduler.commandline;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * StartupApp
 * 
 * @author ccontrerasc
 *
 */
@Component
public class StartupApp implements CommandLineRunner {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(StartupApp.class);

	/**
	 * Ejecucion automatica
	 */
	@Override
	public void run(String... args) throws Exception {

		log.info("Run Automatico desde [CommandLineRunner]");

	}

}
