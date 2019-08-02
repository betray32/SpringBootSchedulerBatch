package cl.poc.scheduler.batch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import cl.poc.scheduler.bean.ListadoMaestroNotificaciones;

/**
 * Writer get data
 * 
 * @author ccontrerasc
 *
 */
@Repository
public class WriterNotification implements ItemWriter<ListadoMaestroNotificaciones>, InitializingBean {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(WriterNotification.class);

	/**
	 * Conector con la base de datos
	 */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(entityManager, "An EntityManagerFactory is required");

	}

	/**
	 * Write
	 */
	@Override
	public void write(List<? extends ListadoMaestroNotificaciones> items) throws Exception {

		log.info("-----------------------------");
		log.info("[WRITER PAYMENT] Executing...");
		log.info("-----------------------------");

		/*
		 * Necesario al terminar la ejecucion
		 */
		log.info("Procediendo a sincronizar la conexion a la BD");
		entityManager.flush();
		log.info("Objeto de base de datos sincronizado");

	}

}
