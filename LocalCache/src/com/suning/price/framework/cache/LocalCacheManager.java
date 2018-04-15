package com.suning.price.framework.cache;

import java.util.HashMap;
import java.util.Map;

import com.suning.price.framework.cache.util.Contants;
import com.suning.price.framework.exception.ErrorMessage;
import com.suning.price.framework.exception.LocalCacheSystemException;

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
