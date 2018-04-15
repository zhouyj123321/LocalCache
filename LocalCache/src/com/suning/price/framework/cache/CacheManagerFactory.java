package com.suning.price.framework.cache;

import com.suning.price.framework.cache.util.Contants;
import com.suning.price.framework.exception.ErrorMessage;
import com.suning.price.framework.exception.LocalCacheSystemException;

/**
 * CacheManager factory
 * @author 15040127
 */
public class CacheManagerFactory {

	private static CacheManager cacheManager;
	
	private static Object lock = new Object();
	
	public static CacheManager getCacheManager(String cacheFullClassName) {
		synchronized (lock) {
			if (cacheManager == null) {
				try {
					cacheManager = (CacheManager)Class.forName(cacheFullClassName).newInstance();
				} catch (InstantiationException e) {
					e.printStackTrace();
					throw new LocalCacheSystemException(Contants.CACHE_INIT_ERROR, 
							new ErrorMessage(Contants.CACHE_INIT_ERROR,"Cache manager instantiation error.",e.getMessage()));
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					throw new LocalCacheSystemException(Contants.CACHE_INIT_ERROR, 
							new ErrorMessage(Contants.CACHE_INIT_ERROR,"Cache manager instantiation error.",e.getMessage()));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					throw new LocalCacheSystemException(Contants.CACHE_INIT_ERROR, 
							new ErrorMessage(Contants.CACHE_INIT_ERROR,"Not Found the cacheManager name(Full-Name).",e.getMessage()));
				}
			}
		}
		return cacheManager;
	}
	
}
