package com.suning.price.framework.cache.util;

/**
 * Define the TTL possible form.
 * @author 15040127
 *
 */
public enum CheckTtlType { 

	/** The Key is not set TTL, or be removed   */
	NOT_EXIST_TTL_KEY,
	/** The Key is set the TTL, but already it was expired.  */
	EXIST_TTL_KEY_EXPIRED,
	/** The Key is set the TTL and effective.   */
	EXIST_TTL_VALID
}
