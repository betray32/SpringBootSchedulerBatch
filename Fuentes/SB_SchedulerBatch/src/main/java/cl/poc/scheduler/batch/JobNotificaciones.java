package cl.poc.scheduler.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import cl.poc.scheduler.bean.ListadoMaestroNotificaciones;
import net.bytebuddy.utility.RandomString;

/**
 * Spring batch de notificaciones
 * 
 * @author ccontrerasc
 *
 */
@Configuration
@EnableBatchProcessing
public class JobNotificaciones {

	/******************
	 * Factories
	 */
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private JobCompletionNotificationListener postListener;
	
	/***************************************
	 * Manejadores de los steps
	 */
	@Autowired
	private StepExecuteNotification step;
	/***************************************/
	
	/**
	 * JOB
	 * 
	 * Punto de entrada para comenzar la ejecucion del batch
	 * 
	 * @param listener
	 * @param evaluarData
	 * @param ejecutarAccion
	 * @return
	 */
	@Bean
	@Scope("singleton")
	public Job executeBatchProcessing()	 {

		return jobBuilderFactory
				.get(RandomString.make(15).toUpperCase())
				.listener(postListener)
				.preventRestart()
				.incrementer(new RunIdIncrementer())
				.start(stepNotification())
				.build();
	}
	
	/**
	 * STEP
	 * 
	 * Pago PAC
	 * 
	 * @return
	 */
	@Bean
	public Step stepNotification() {
		

		return stepBuilderFactory.get("stepNotification")
				.<ListadoMaestroNotificaciones, ListadoMaestroNotificaciones>chunk(10)
				.reader(step.readerNotification())
				.processor(step.processorNotification())
				.writer(step.writerNotification())
				.build();

	}

	
}
