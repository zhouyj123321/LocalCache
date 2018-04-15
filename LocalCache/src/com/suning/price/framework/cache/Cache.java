package com.suning.price.framework.cache;

import java.io.Serializable;
import java.util.Set;

/**
 * Cache interface
 * @author 15040127
 *
 */
public interface Cache extends Serializable {

	public Object get(Object key);

	public void put(Object key, Object value);
	
	/**
	 * Set value into cache with TTL
	 * @param key
	 * @param value
	 * @param ttl
	 */
	public void put(Object key, Object value,long ttl);

	public void remove(Object key);

	public void clear();

	public int size();

	public Set keys();

	public Set values();

}
