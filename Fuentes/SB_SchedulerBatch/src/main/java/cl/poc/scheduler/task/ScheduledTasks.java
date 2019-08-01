package cl.poc.scheduler.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	/**
	 * LOG
	 */
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	/**
	 * Formato
	 */
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	/**
	 * Agendado
	 */
	@Scheduled(fixedRate = 1000)
	public void reportCurrentTime() {
		log.info("The time is now {}", dateFormat.format(new Date()));
	}
	
}