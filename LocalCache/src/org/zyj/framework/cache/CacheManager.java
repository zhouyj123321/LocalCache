package org.zyj.framework.cache;

import org.zyj.framework.cache.exception.LocalCacheSystemException;
/**
 * For extended use.
 *
 */
public interface CacheManager {
	
	public Cache getCache(String name)  throws LocalCacheSystemException;
	
	public void destroy(String name) throws LocalCacheSystemException;
}
