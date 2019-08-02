package cl.poc.scheduler.batch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * Listener ejecutado una vez termina el proceso
 * 
 * @author ccontrerasc
 *
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(JobCompletionNotificationListener.class);

	/**
	 * Se ejecuta despues del job
	 */
	@Override
	public void afterJob(JobExecution jobExecution) {

		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("Job Finalizado Exitosamente");
		} else

		if (jobExecution.getStatus() == BatchStatus.FAILED) {
			log.info("Job Finalizado con Errores");
		}

	}

}
