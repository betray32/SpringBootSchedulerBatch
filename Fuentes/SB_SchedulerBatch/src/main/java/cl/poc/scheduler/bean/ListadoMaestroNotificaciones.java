package cl.poc.scheduler.bean;

/**
 * Listado obtenido desde la BD
 * 
 * @author ccontrerasc
 *
 */
public class ListadoMaestroNotificaciones {

	private String rutCliente;
	private String movimiento;

	/** GET Y SET **/
	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}

}
