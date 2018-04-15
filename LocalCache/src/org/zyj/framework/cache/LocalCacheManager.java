package org.zyj.framework.cache;

import java.util.HashMap;
import java.util.Map;

import org.zyj.framework.cache.exception.ErrorMessage;
import org.zyj.framework.cache.exception.LocalCacheSystemException;
import org.zyj.framework.cache.util.Contants;

public class LocalCacheManager implements CacheManager {

	private static final Map<String, Cache> caches = new HashMap<String, Cache>();
	
	public Cache getCache(String name) {
		if (name == null) {
			throw new LocalCacheSystemException("LocalCache-0001", new ErrorMessage(Contants.CACHE_IS_NULL,"Cache name is not null."));
		}

		Cache cache;

		synchronized (caches) {
			cache = caches.get(name);
			if (cache == null) {
				cache = new SoftHashMapCache(name);
				caches.put(name, cache);
			}
		}

		return cache;
	}

	public void destroy(String name) throws LocalCacheSystemException {
		
		synchronized (caches) {		
				caches.remove(name);
			}
		}
}
