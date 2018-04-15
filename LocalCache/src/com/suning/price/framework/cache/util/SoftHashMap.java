package com.suning.price.framework.cache.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现自己的SoftMap，TTL的失效模式采用类似于Redis默认的失效模式。
 * 
 * @author 15040127
 *
 * @param <K>
 * @param <V>
 */
public class SoftHashMap<K,V> implements Map<K, V>{

	private static final String UNCHECKED = "unchecked";

	/**
	 * The default value of the RETENTION_SIZE attribute, equal to 150.
	 */
	private static final int DEFAULT_RETENTION_SIZE = 4;

	private final Map<K, SoftValue<V, K>> map;
	
	private final Map<K, Long> mapTTL;

	/**
	 * The number of strong references to hold internally, that is, the number
	 * of instances to prevent from being garbage collected automatically
	 * (unlike other soft references).
	 */
	private final int RETENTION_SIZE;

	/**
	 * The FIFO list of strong references (not to be garbage collected), order
	 * of last access.
	 */
	private final Queue<V> strongRef;

	private final ReentrantLock strongRefLock;

	/**
	 * Reference queue for cleared SoftReference objects.
	 */
	private final ReferenceQueue<? super V> queue;
	
	private final SoftReference<Map<K, Long>> ttlSoftRef;
	
	private final ReferenceQueue<? super Map<K, Long>> ttlQueue;
	
	 /**
     * Creates a new SoftHashMap with a default retention size size of
     * {@link #DEFAULT_RETENTION_SIZE DEFAULT_RETENTION_SIZE} (150 entries).
     *
     * @see #SoftHashMap(int)
     */
    public SoftHashMap() {
        this(DEFAULT_RETENTION_SIZE);
    }
    

	public SoftHashMap(int retentionSize) {
		super();
		RETENTION_SIZE = Math.max(0, retentionSize);
		queue = new ReferenceQueue<V>();
		strongRefLock = new ReentrantLock();
		map = new ConcurrentHashMap<K, SoftValue<V, K>>();
		strongRef = new ConcurrentLinkedQueue<V>();
		mapTTL = new HashMap<K, Long>();
		ttlQueue = new ReferenceQueue<Map<K, Long>>();
		ttlSoftRef = new SoftReference<Map<K,Long>>(mapTTL,ttlQueue);
	}
	


	@Override
	public void clear() {
		strongRefLock.lock();
		try {
			strongRef.clear();
			mapTTL.clear();
		} finally {
			strongRefLock.unlock();
		}
		processQueue(); // throw out garbage collected values
		map.clear();
		
	}
	
	 /**
     * Traverses the ReferenceQueue and removes garbage-collected SoftValue objects from the backing map
     * by looking them up using the SoftValue.key data member.
     */
	@SuppressWarnings(UNCHECKED)
    private void processQueue() {
        SoftValue sv;
        while ((sv = (SoftValue) queue.poll()) != null) {
            map.remove(sv.key); // we can access private data!
            /*
             * Special Attention: The value here is expired, do not represent redis data is expired.
             *  Can think of other ways to  implement.....[?]
             */
            mapTTL.remove(sv.key); 
        }
    }
    

	@Override
	public boolean containsKey(Object key) {
		processQueue();
		return map.containsKey(key);
	}

	@SuppressWarnings(UNCHECKED)
	@Override
	public boolean containsValue(Object value) {
		processQueue();
		Collection values = values();
		return values != null && values.contains(value);
	}

	@SuppressWarnings(UNCHECKED)
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		processQueue(); // throw out garbage collected values first
		Collection<K> keys = map.keySet();
		if (keys.isEmpty()) {
			// no inspection unchecked
			return Collections.EMPTY_SET;
		}

		Map<K, V> kvPairs = new HashMap<K, V>(keys.size());
		for (K key : keys) {
			V v = get(key);
			if (v != null) {
				kvPairs.put(key, v);
			}
		}
		return kvPairs.entrySet();
	}

	@Override
	public V get(Object key) {
		processQueue();
		V result = null;
		CheckTtlType ct = getTtlValueByKey(key);
		switch (ct) {
		case EXIST_TTL_KEY_EXPIRED:
			return result;
		default:
			break;
		}
		SoftValue<V, K> value = map.get(key);
		if (value != null) {
			// unwrap the 'real' value from the SoftReference
			result = value.get();
			if (result == null) {
				/*
				 * The wrapped value was garbage collected, so remove this entry from the backing map:
				 * no inspection Suspicious Method Calls
				 */
				map.remove(key);
			} else {
				/*
				 * Add this value to the beginning of the strong reference queue (FIFO).
				 */
				addToStrongReferences(result);
			}
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		processQueue();
		return map.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		processQueue();
		return map.keySet();
	}

	@Override
	public V put(K key, V value) {
		SoftValue<V, K> previous = putValueIntoCache(key, value);
		return previous != null ? previous.get() : null;
	}


	private SoftValue<V, K> putValueIntoCache(K key, V value) {
		processQueue(); // throw out garbage collected values first
		SoftValue<V, K> sv = new SoftValue<V, K>(value, key, queue);
		SoftValue<V, K> previous = map.put(key, sv);
		addToStrongReferences(value);
		return previous;
	}
	
	public V putWithTTL(K key, V value,long specTtlMillis) {
		SoftValue<V, K> previous = putValueIntoCache(key, value);
		setTTL(key, specTtlMillis);
		return previous != null ? previous.get() : null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		if (m == null || m.isEmpty()) {
			processQueue();
			return;
		}
		for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}

	}

	@Override
	public V remove(Object key) {
		processQueue(); // throw out garbage collected values first
		SoftValue<V, K> raw = map.remove(key);
		return raw != null ? raw.get() : null;
	}

	@Override
	public int size() {
		processQueue(); // throw out garbage collected values first
		return map.size();
	}

	@SuppressWarnings(UNCHECKED)
	@Override
	public Collection<V> values() {
		processQueue();
		Collection<K> keys = map.keySet();
		if (keys.isEmpty()) {
			return Collections.EMPTY_SET;
		}
		Collection<V> values = new ArrayList<V>(keys.size());
		for (K key : keys) {
			V v = get(key);
			if (v != null) {
				values.add(v);
			}
		}
		return values;
	}
	
	 private static class SoftValue<V, K> extends SoftReference<V> {

	        private final K key;

	        /**
	         * @param value the map value
	         * @param key   the map key
	         * @param queue the soft reference queue to poll to determine if the entry had been reaped by the GC.
	         */
	        private SoftValue(V value, K key, ReferenceQueue<? super V> queue) {
	            super(value, queue);
	            this.key = key;
	        }
	        

	    }
	 
	private void addToStrongReferences(V result) {
		strongRefLock.lock();
		try {
			strongRef.add(result);
			trimStrongReferencesIfNecessary();
		} finally {
			strongRefLock.unlock();
		}

	}
	
	
    private void trimStrongReferencesIfNecessary() {
        //trim the strong ref queue if necessary:
        while (strongRef.size() > RETENTION_SIZE) {
        	strongRef.poll();
        }
    }
    
    /**
     * check TTL.
     * @param key
     * @return
     */
    private CheckTtlType getTtlValueByKey(Object key) {
    	Map<K, Long> map = ttlSoftRef.get();
    	if( (null == map) || !(map.containsKey(key))  || (null == map.get(key))) {
    		return CheckTtlType.NOT_EXIST_TTL_KEY;
    	}
    	long currTime = DateUtils.currentTimeMillis();
    	long ttl = map.get(key);
    	if(currTime > ttl) {
    		return CheckTtlType.EXIST_TTL_KEY_EXPIRED;
    	}
    	return CheckTtlType.EXIST_TTL_VALID;
    }
    
    private void setTTL(K key,long specTtlMillis) {
    	strongRefLock.lock();
    	try {
    		mapTTL.put(key, DateUtils.addSpecTtlMillisForcurrentTime(specTtlMillis));
		} finally{
			strongRefLock.unlock();
		}
    }

}
