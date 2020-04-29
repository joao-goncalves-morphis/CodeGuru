package cgd;

import morphis.framework.utils.ConfigUtils;

public class Config extends morphis.framework.configuration.Config {
	/** CORS configuration */
	public static final CORS cors = new CORS();
	
	static {
		ConfigUtils.initFromYaml(Config.class, CONFIG_FILE);
	}
	
	/**
	 * CORS configuration
	 */
	public static class CORS {
		public String urlPattern = "/**";
		public String allowedOrigins = "*";
		public boolean allowCredentials = true;
	}
}
