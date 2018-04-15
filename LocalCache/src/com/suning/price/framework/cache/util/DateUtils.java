package com.suning.price.framework.cache.util;

/**
 * @author 15040127
 *
 */
public class DateUtils {
	
	public static Long currentTimeMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 
	 * @param specTtlMillis TTL specified number of milliseconds
	 * @return
	 */
	public static Long addSpecTtlMillisForcurrentTime(long specTtlMillis) {
		return System.currentTimeMillis() + specTtlMillis;
	}
	
	
}
