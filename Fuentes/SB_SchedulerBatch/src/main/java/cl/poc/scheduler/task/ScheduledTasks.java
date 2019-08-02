package cl.poc.scheduler.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	/**
	 * LOG
	 */
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	@Autowired
	JobLauncher jobLauncher;

	@Value("#{executeBatchProcessing}")
	Job job;

	@Value("#{obtenerParams.enabled}")
	private int enabled;

	/**
	 * Agendamiento
	 */
	@Scheduled(fixedRateString = "#{obtenerParams.fixedRate}", initialDelayString = "#{obtenerParams.fixedDelay}")
	public void exec() {

		/*
		 * Solo si esta activada la funcion desde la BD se inicializa
		 */
		if (enabled == 1) {

			log.info("[INFO] Ejecutando Automaticamente... ");
			
			/**************************************
			 * Inicio automatico del JOB BATCH
			 */
			JobParameters params = new JobParametersBuilder().addString("jobNotification", String.valueOf(System.currentTimeMillis())).toJobParameters();
			try {
				jobLauncher.run(job, params);
			} catch (Exception e) {
				log.error("Error en la ejecucion del JOB, Detalle > " + e.getMessage());
			}
			/**************************************/

			log.info("[INFO] Iteracion Finalizada");

		} else {
			log.info("Proceso Batch de Notificaciones Desactivado... Esperando");
		}

	}

}