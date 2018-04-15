package org.zyj.framework.cache.test;

import org.zyj.framework.cache.Cache;
import org.zyj.framework.cache.LocalCacheFactory;
import org.zyj.framework.cache.util.CacheType;
import org.zyj.framework.cache.util.Contants;

/**
 * Test TTL
 *
 */
public class Test {

	static Cache cache = LocalCacheFactory.generateLocalCache(Contants.LOCAL_CACHE_MANAGER_STRING,CacheType.SOFT_HASHMAP_CACHE);
	public static void main(String[] args) {
//		f1();
//		System.gc();
//		byte[] arr2 = new byte[1024*51]; // test 1024*60
//		byte[] arr = new byte[1024*1024*6];
//		try {
//			Thread.sleep(2000);
//			System.gc();
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		f2();
		f();
	}
	
	public static void f() {
		MyObject obj1 = new MyObject(1);
		MyObject obj2 = new MyObject(2);
		
		cache.put("key-1", obj1,2000);
		cache.put("key-2", obj2,3000);
		try {
			Thread.sleep(1000);
			System.gc();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(("------key-1"+ " : "+ cache.get("key-1")));
		System.out.println(("------key-2"+ " : "+ cache.get("key-2")));
	}
	
	public static void f1() {
//		cache.put("name-1", "ZYJ");
//		cache.put("name-2", "ZYJ-2");
//		cache.put("name-3", "ZYJ3");
//		cache.put("name-4", "ZYJ-4");
		for(int i = 100; i >= 1; i--) { //test 165
			cache.put("name-"+i, "ZhouYoujun - "+i);
		}
		System.out.println("===complete===");
		
	}
	
	public static void f2() {
		for(int i = 100; i >= 1; i--) {
			String key = "name-"+i;
//			cache.put("name-"+i, "ZhouYoujun - "+i);
			System.out.println(("name-"+i + " : "+ cache.get(key)));
		}
	}
}
