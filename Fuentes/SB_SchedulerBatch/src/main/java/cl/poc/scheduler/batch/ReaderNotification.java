package cl.poc.scheduler.batch;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.StoredProcedureItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import cl.poc.scheduler.bean.ListadoMaestroNotificaciones;
import cl.poc.scheduler.dao.ListadoMaestroNotificacionesMapper;
import cl.poc.scheduler.properties.CustomYMLFile;
import oracle.jdbc.OracleTypes;

/**
 * Leer data desde procedimiento almacenado oracle
 * 
 * @author ccontrerasc
 *
 */
@Repository
public class ReaderNotification {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(ReaderNotification.class);

	/*******************
	 * DI
	 */
	@Autowired
	private CustomYMLFile properties;

	@Autowired
	DataSource dataSource;

	/*******************/

	/**
	 * Lee los registros que contengan el estado indicado
	 * 
	 * @return
	 */
	public ItemReader<ListadoMaestroNotificaciones> read() {

		try {

			log.info("[READ] Executing...");

			StoredProcedureItemReader<ListadoMaestroNotificaciones> reader = new StoredProcedureItemReader<ListadoMaestroNotificaciones>();
			reader.setDataSource(dataSource);

			// Procedure
			reader.setProcedureName(properties.getProcedures().getObtieneMaestro());
			SqlParameter[] parameters = 
				{ 
						new SqlParameter("P_ESTADO", OracleTypes.VARCHAR), 
						new SqlParameter("OUT_ESTADO", OracleTypes.CURSOR) 
				};

			/*
			 * Le seteo al reader los parametros ya definidos. Ademas le digo que Mapper necesito para
			 * procesarlo como un objeto y le indico en que posicion esta el cursor
			 */
			reader.setParameters(parameters);
			reader.setRowMapper(new ListadoMaestroNotificacionesMapper());
			reader.setRefCursorPosition(3);

			return reader;

		} catch (Exception e) {
			log.error("Error al obtener lista de clientes a procesar, ERROR > ", e);
		}

		return null;

	}

}
