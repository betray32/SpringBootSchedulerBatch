package cl.poc.scheduler.dao;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.poc.scheduler.bean.ParametricaBean;
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
	public ParametricaBean obtenerParametros() {

		
		ParametricaBean res = null;
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
					.registerStoredProcedureParameter(2, Long.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(3, Long.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);

			log.info("Ejecutando SP");
			query.execute();
			log.info("Procedimiento ejecutado OK");

			res = new ParametricaBean();
			res.setEnabled((Integer) query.getOutputParameterValue(1));
			res.setFixedRate((Long) query.getOutputParameterValue(2));
			res.setFixedDelay((Long) query.getOutputParameterValue(3));
			res.setEstado((String) query.getOutputParameterValue(4));
	
			return res;

		} catch (Exception e) {
			log.error("Error en la ejecucion, ERROR > ", e);
		}

		return res;

	}

}
