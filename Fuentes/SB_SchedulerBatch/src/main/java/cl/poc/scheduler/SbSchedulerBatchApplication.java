package cl.poc.scheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Carga inicial
 * 
 * @author ccontrerasc
 *
 */
@SpringBootApplication
@ComponentScan({ "cl.poc.scheduler.commandline", "cl.poc.scheduler.dao", "cl.poc.scheduler.properties" })
public class SbSchedulerBatchApplication {

	private static final Log log = LogFactory.getLog(SbSchedulerBatchApplication.class);

	/**
	 * MAIN
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
		log.info("Inicializando - Quartz Spring Boot");
		log.info("> Started at: " + date);

		SpringApplication.run(SbSchedulerBatchApplication.class, args);
	}

}
