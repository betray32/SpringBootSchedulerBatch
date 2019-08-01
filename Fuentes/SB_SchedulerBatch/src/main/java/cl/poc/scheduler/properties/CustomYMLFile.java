package cl.poc.scheduler.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * CustomYMLFile
 * 
 * @author ccontrerasc
 *
 */
@ConfigurationProperties
@Component
public class CustomYMLFile {

	private String VersionBatch;
	private Procedures Procedures;

	/**
	 * Procedimientos
	 * 
	 * @author ccontrerasc
	 *
	 */
	public static class Procedures {
		private String ObtieneMaestro;

		public String getObtieneMaestro() {
			return ObtieneMaestro;
		}

		public void setObtieneMaestro(String obtieneMaestro) {
			ObtieneMaestro = obtieneMaestro;
		}

	}

	/** GET Y SET **/
	public String getVersionBatch() {
		return VersionBatch;
	}

	public void setVersionBatch(String versionBatch) {
		VersionBatch = versionBatch;
	}

	public Procedures getProcedures() {
		return Procedures;
	}

	public void setProcedures(Procedures procedures) {
		Procedures = procedures;
	}

}
