package cl.poc.scheduler.launcher;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Carga inicial
 * 
 * @author ccontrerasc
 *
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan
(
	{ 
		"cl.poc.scheduler.commandline"
		, "cl.poc.scheduler.dao"
		, "cl.poc.scheduler.properties"
		, "cl.poc.scheduler.task"
	}
)
public class SbSchedulerBatchApplication {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(SbSchedulerBatchApplication.class);

	/**
	 * MAIN
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
		log.info("Inicializando - SbSchedulerBatchApplication");
		log.info("> Started at: " + date);

		SpringApplication.run(SbSchedulerBatchApplication.class, args);
	}

}
