package org.zyj.framework.cache.test;

import org.zyj.framework.cache.Cache;
import org.zyj.framework.cache.LocalCacheFactory;
import org.zyj.framework.cache.util.CacheType;
import org.zyj.framework.cache.util.Contants;

public class Test2 {

//	static Cache cache = LocalCacheFactory.generateLocalCache(CacheType.SOFT_HASHMAP_CACHE, CacheStrategy.CREATE_NEW_CACHE);
	public static void main(String[] args) {
		f1();
	}
	
	public static void f1() {
		Cache cache = LocalCacheFactory.generateLocalCache(Contants.LOCAL_CACHE_MANAGER_STRING,CacheType.SOFT_HASHMAP_CACHE);
		MyObject obj1 = new MyObject(1);
		MyObject obj2 = new MyObject(2);
		MyObject obj3 = new MyObject(3);
		MyObject obj4 = new MyObject(4);
		MyObject obj5 = new MyObject(5);
		MyObject obj6 = new MyObject(6);
		byte[] arr2 = new byte[1024*49]; // test 1024*60
		cache.put("key-1", obj1);
		cache.put("key-2", obj2);
		cache.put("key-3", obj3);
		cache.put("key-4", obj4);
		cache.put("key-5", obj5);
		cache.put("key-6", obj6);
		obj1 = null;
		obj2 = null;
		obj3 = null;
		obj4 = null;
		obj5 = null;
		obj6 = null;
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.out.println(("key-1"+ " : "+ cache.get("key-1")));
		System.out.println(("key-2"+ " : "+ cache.get("key-2")));
		System.out.println(("key-3"+ " : "+ cache.get("key-3")));
		System.out.println(("key-4"+ " : "+ cache.get("key-4")));
		System.out.println(("key-5"+ " : "+ cache.get("key-5")));
		System.out.println(("key-6"+ " : "+ cache.get("key-6")));
		
		byte[] arr1 = new byte[1024*1024*6];
		System.out.println(("------key-1"+ " : "+ cache.get("key-1")));
		System.out.println(("------key-2"+ " : "+ cache.get("key-2")));
		System.out.println(("------key-3"+ " : "+ cache.get("key-3")));
		System.out.println(("------key-4"+ " : "+ cache.get("key-4")));
		System.out.println(("------key-5"+ " : "+ cache.get("key-5")));
		System.out.println(("------key-6"+ " : "+ cache.get("key-6")));
	}
	
}
