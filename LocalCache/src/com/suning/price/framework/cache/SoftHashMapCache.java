package com.suning.price.framework.cache;

import java.io.Serializable;

import com.suning.price.framework.cache.util.SoftHashMap;

/**
 * SoftHashMap is used to implement a Local Cache
 * @author 15040127
 *
 */
class SoftHashMapCache  extends MapCache implements Serializable {

	
	private static final String UNCHECKED = "unchecked";
	
	private static final long serialVersionUID = 1L;

	/**
     * Create a SoftHashMapCache with spec-name.
     * Can be extended to other cache by name, e.g. EHCache & OSCache etc.
     * @param name Cache name
     */
	@SuppressWarnings(UNCHECKED)
	public SoftHashMapCache(String name) {
        super(name, new SoftHashMap());
    }
}
