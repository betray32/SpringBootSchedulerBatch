package cl.poc.scheduler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.poc.scheduler.bean.ListadoMaestroNotificaciones;

/**
 * Mapper
 * 
 * @author ccontrerasc
 *
 */
public class ListadoMaestroNotificacionesMapper implements RowMapper<ListadoMaestroNotificaciones> {

	/**
	 * Mapeo para la salida del procedimiento
	 */
	@Override
	public ListadoMaestroNotificaciones mapRow(ResultSet rs, int rowNum) throws SQLException {

		ListadoMaestroNotificaciones bean = new ListadoMaestroNotificaciones();
		bean.setRutCliente(rs.getString("NOT_RUT"));
		bean.setMovimiento(rs.getString("NOT_MOVIMIENTO"));

		return bean;
	}

}
