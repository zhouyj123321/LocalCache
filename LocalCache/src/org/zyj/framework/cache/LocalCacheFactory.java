package org.zyj.framework.cache;

import org.zyj.framework.cache.util.CacheType;
import org.zyj.framework.cache.util.Contants;

public class LocalCacheFactory {
	private static CacheManager cm;
	public static Cache generateLocalCache(String cacheFullClassName,CacheType ctype) {
		switch (ctype) {
		case SOFT_HASHMAP_CACHE:
			if(null == cm || !LocalCacheManager.class.isInstance(cm)) {
				cm = CacheManagerFactory.getCacheManager(cacheFullClassName);
			}
			return cm.getCache(Contants.SOFT_HASHMAP_CACHE);

		default:
			break;
		}
		return null;
	}

	/*
	private static final SoftHashMapCache softHashMapCache = new SoftHashMapCache("LocalCache");
	
	public static Cache generateLocalCache(CacheType ctype) {
		switch (ctype) {
		case SOFT_HASHMAP_CACHE:
			return softHashMapCache;
		default:
			break;
		}
		return null;
	}
	*/
}
