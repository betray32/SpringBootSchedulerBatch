package cl.poc.scheduler.batch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import cl.poc.scheduler.bean.ListadoMaestroNotificaciones;

/**
 * Preparar la data del pago
 * 
 * @author ccontrerasc
 *
 */
@Service
public class ProcessorNotification implements ItemProcessor<ListadoMaestroNotificaciones, ListadoMaestroNotificaciones> {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(ProcessorNotification.class);

	/**
	 * Procesamiento
	 */
	@Override
	public ListadoMaestroNotificaciones process(ListadoMaestroNotificaciones itemMaestro) throws Exception {

		log.info("-----------------------------");
		log.info("[PROCESS PAYMENT] Executing...");
		log.info("-----------------------------");

		return null;

	}

}
