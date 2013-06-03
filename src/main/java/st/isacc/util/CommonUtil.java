/**
 * 
 */
package st.isacc.util;

import java.io.InputStream;

/**
 * @author jinzhou
 *
 */
public final class CommonUtil {
	
	private static final String KEY_STORE_PATH = "push.p12";
	
	public static InputStream getKeyStoreStream(){
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(KEY_STORE_PATH);
	}

}
