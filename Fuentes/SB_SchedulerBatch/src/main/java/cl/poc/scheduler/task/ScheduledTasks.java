package cl.poc.scheduler.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cl.poc.scheduler.properties.CustomYMLFile;

@Component
public class ScheduledTasks {

	/**
	 * LOG
	 */
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	/**
	 * yml
	 */
	@Autowired
	private CustomYMLFile yml;

	/**
	 * Agendado
	 */
	@Scheduled(fixedRateString = "#{obtenerParams.fixedRate}", initialDelayString = "#{obtenerParams.fixedDelay}")
	public void exec() {

		log.info("Ejecutando Automaticamente... ");
		log.info("Properties: " + yml);

	}

}