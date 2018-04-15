package com.suning.price.framework.cache;

import java.util.*;

import com.suning.price.framework.cache.util.SoftHashMap;

/**
 * 
 * @author 15040127
 *
 */
class MapCache implements Cache {

	private static final long serialVersionUID = -8769084978422121909L;
	public static final String UNCHECKED = "unchecked";

//	private final SoftHashMap map;
	@SuppressWarnings(UNCHECKED)
	private final SoftHashMap map;

	private final String name;

	@SuppressWarnings(UNCHECKED)
	public MapCache(String name, SoftHashMap backingMap) {
		if (name == null) {
			throw new IllegalArgumentException("Cache name is not NULL.");
		}
		if (backingMap == null) {
			throw new IllegalArgumentException("Instance of backing cache is not NULL."  );
		}
		this.name = name;
		this.map = backingMap;
	}

	public Object get(Object key) {
		return map.get(key);
	}

	@SuppressWarnings( { UNCHECKED })
	public void put(Object key, Object value) {
		map.put(key, value);
	}
	
	/**
	 * implement function ttl of Redis 
	 */
	@SuppressWarnings( { UNCHECKED })
	public void put(Object key, Object value,long specTtlMillis) {
		//设置带有TTL的缓存
		map.putWithTTL(key, value, specTtlMillis);
	}

	public void remove(Object key) {
		map.remove(key);
	}

	public void clear() {
		map.clear();
	}

	public int size() {
		return map.size();
	}

	@SuppressWarnings( { UNCHECKED })
	public Set keys() {
		Set keys = map.keySet();
		if (!keys.isEmpty()) {
			return Collections.unmodifiableSet(keys);
		}
		return Collections.EMPTY_SET;
	}

	@SuppressWarnings( { "unchecked" })
	public Set values() {
		if (!map.isEmpty()) {
			Collection values = map.values();
			if (values instanceof Set) {
				return Collections.unmodifiableSet((Set) values);
			} else {
				return Collections.unmodifiableSet(new LinkedHashSet(values));
			}
		} else {
			return Collections.EMPTY_SET;
		}
	}

	public String toString() {
		return getClass().getName() + " : [" + name + "]";
	}
	
}
