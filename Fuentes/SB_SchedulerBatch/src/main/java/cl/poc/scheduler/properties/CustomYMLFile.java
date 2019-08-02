package cl.poc.scheduler.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * CustomYMLFile
 * 
 * @author ccontrerasc
 *
 */
@Component
@ConfigurationProperties
public class CustomYMLFile {

	private String VersionBatch;
	private int THREAD_POOL_SIZE;
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

	public int getTHREAD_POOL_SIZE() {
		return THREAD_POOL_SIZE;
	}

	public void setTHREAD_POOL_SIZE(int tHREAD_POOL_SIZE) {
		THREAD_POOL_SIZE = tHREAD_POOL_SIZE;
	}

	public Procedures getProcedures() {
		return Procedures;
	}

	public void setProcedures(Procedures procedures) {
		Procedures = procedures;
	}

	@Override
	public String toString() {
		return "CustomYMLFile [VersionBatch=" + VersionBatch + ", THREAD_POOL_SIZE=" + THREAD_POOL_SIZE + ", Procedures=" + Procedures + "]";
	}

}
