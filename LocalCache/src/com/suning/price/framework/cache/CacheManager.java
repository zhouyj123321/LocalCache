package com.suning.price.framework.cache;

import com.suning.price.framework.exception.LocalCacheSystemException;
/**
 * For extended use.
 * @author 15040127
 *
 */
public interface CacheManager {
	
	public Cache getCache(String name)  throws LocalCacheSystemException;
	
	public void destroy(String name) throws LocalCacheSystemException;
}
