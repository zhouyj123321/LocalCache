package org.zyj.framework.cache;

import java.util.HashMap;
import java.util.Map;

import org.zyj.framework.cache.exception.LocalCacheSystemException;

/**
 * You can extend the  DefaultCacheManager to support other cache.
 *
 */
public class DefaultCacheManager implements CacheManager {

	private static final Map<String, Cache> caches = new HashMap<String, Cache>();
	
	@Override
	public Cache getCache(String name) throws LocalCacheSystemException {
		throw new UnsupportedOperationException("Not Implemented.Temporary does not support this operation.");
	}

	@Override
	public void destroy(String name) throws LocalCacheSystemException {
		throw new UnsupportedOperationException("Not Implemented.Temporary does not support this operation.");
	}

}
