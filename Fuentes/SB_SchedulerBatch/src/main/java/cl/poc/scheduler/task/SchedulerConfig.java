package cl.poc.scheduler.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import cl.poc.scheduler.commandline.StartupApp;
import cl.poc.scheduler.properties.CustomYMLFile;

/**
 * SchedulerConfig
 * 
 * @author ccontrerasc
 *
 */
@Configuration
public class SchedulerConfig implements SchedulingConfigurer {
	
	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(StartupApp.class);

	/**
	 * Properties
	 */
	@Autowired
	private CustomYMLFile cons;

	/**
	 * Configurar las hebras del agendador
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

		threadPoolTaskScheduler.setPoolSize(cons.getTHREAD_POOL_SIZE());
		threadPoolTaskScheduler.setThreadNamePrefix("SB_scheduled-task-pool-notifications");
		threadPoolTaskScheduler.initialize();

		scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
		log.info("Scheduler Configurado OK");
	}

}
