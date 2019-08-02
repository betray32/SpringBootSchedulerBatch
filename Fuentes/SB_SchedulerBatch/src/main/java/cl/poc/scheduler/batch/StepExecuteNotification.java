package cl.poc.scheduler.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.poc.scheduler.bean.ListadoMaestroNotificaciones;

/**
 * Step encargado de ejecutar toda la accion
 * 
 * @author ccontrerasc
 *
 */
@Component
public class StepExecuteNotification {

	@Autowired
	private ReaderNotification payment;
	
	@Autowired
	private ProcessorNotification processor;
	
	@Autowired
	private WriterNotification writer;

	/**
	 * Reader
	 * 
	 * @return
	 */
	public ItemReader<ListadoMaestroNotificaciones> readerNotification() {
		return payment.read();
	}

	/**
	 * Process
	 * 
	 * @return
	 */
	public ProcessorNotification processorNotification() {
		return processor;
	}

	/**
	 * Writer
	 * 
	 * @return
	 */
	public WriterNotification writerNotification() {
		return writer;
	}

}
