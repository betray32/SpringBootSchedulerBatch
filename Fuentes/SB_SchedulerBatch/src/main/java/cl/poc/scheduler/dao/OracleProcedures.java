package cl.poc.scheduler.dao;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.poc.scheduler.properties.CustomYMLFile;

/**
 * Permite pagar en fisa
 * 
 * @author ccontrerasc
 *
 */
@Repository
public class OracleProcedures {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(OracleProcedures.class);

	/**
	 * Conector con la base de datos
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/************************************
	 * DI
	 */
	@Autowired
	private CustomYMLFile properties;

	/***********************************/

	/**
	 * Pagar en FISA
	 * 
	 * @param registro
	 * @return
	 */
	public int obtenerTiempoReinvocacion() {

		try {

			String procedure = properties.getProcedures().getObtieneMaestro();
			log.info("Iniciando llamada al SP: " + procedure);
			StoredProcedureQuery query = entityManager
					/*
					 * Procedimiento
					 */
					.createStoredProcedureQuery(procedure)
					/*
					 * Salidas
					 */
					.registerStoredProcedureParameter(1, Integer.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(4, Integer.class, ParameterMode.OUT);

			log.info("Ejecutando SP");
			query.execute();
			log.info("Procedimiento ejecutado OK");

			int codigoSalida = (Integer) query.getOutputParameterValue(1);

			if (codigoSalida == 0) {
				int minutosIntervalo = (Integer) query.getOutputParameterValue(4);
				return minutosIntervalo;
			} else {
				log.error("Ha ocurrido un error al obtener los parametros desde BD");
			}

		} catch (Exception e) {
			log.error("Error en la ejecucion, ERROR > ", e);
		}

		return -1;

	}
	
}
