package com.suning.price.framework.cache.test;

import com.suning.price.framework.cache.Cache;
import com.suning.price.framework.cache.LocalCacheFactory;
import com.suning.price.framework.cache.util.CacheType;
import com.suning.price.framework.cache.util.Contants;

public class Test3 {

	static Cache cache = LocalCacheFactory.generateLocalCache(Contants.LOCAL_CACHE_MANAGER_STRING,CacheType.SOFT_HASHMAP_CACHE);
	public static void main(String[] args) {
		f1();
		byte[] arr2 = new byte[1024*41]; // test 1024*41
		f2();
		
//		double a = Math.max(0, 12.3);
//		System.out.println(a);
	}
	
	public static void f1() {
//		Cache cache = LocalCacheFactory.generateLocalCache(CacheType.SOFT_HASHMAP_CACHE);
		MyObject obj1 = new MyObject(1);
		MyObject obj2 = new MyObject(2);
		MyObject obj3 = new MyObject(3);
		MyObject obj4 = new MyObject(4);
		MyObject obj5 = new MyObject(5);
		MyObject obj6 = new MyObject(6);
		MyObject obj7 = new MyObject(7);
		MyObject obj8 = new MyObject(8);
		MyObject obj9 = new MyObject(9);
		MyObject obj10 = new MyObject(10);
		MyObject obj11 = new MyObject(11);
		MyObject obj12 = new MyObject(12);
		MyObject obj13 = new MyObject(13);
		MyObject obj14 = new MyObject(14);
		MyObject obj15 = new MyObject(15);
		
		MyObject obj16 = new MyObject(16);
		MyObject obj17 = new MyObject(17);
		MyObject obj18 = new MyObject(18);
		MyObject obj19 = new MyObject(19);
		MyObject obj20 = new MyObject(20);
		
//		byte[] arr2 = new byte[1024*33]; // test 1024*60
		cache.put("key-1", obj1);
		cache.put("key-2", obj2);
		cache.put("key-3", obj3);
		cache.put("key-4", obj4);
		cache.put("key-5", obj5);
		
		cache.put("key-6", obj6);
		cache.put("key-7", obj7);
		cache.put("key-8", obj8);
		cache.put("key-9", obj9);
		cache.put("key-10", obj10);
		
		cache.put("key-11", obj11);
		cache.put("key-12", obj12);
		cache.put("key-13", obj13);
		cache.put("key-14", obj14);
		cache.put("key-15", obj15);
		
		cache.put("key-16", obj16);
		cache.put("key-17", obj17);
		cache.put("key-18", obj18);
		cache.put("key-19", obj19);
		cache.put("key-20", obj20);
		

		System.gc();
		System.gc();
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
		System.out.println(("key-7"+ " : "+ cache.get("key-7")));
		System.out.println(("key-8"+ " : "+ cache.get("key-8")));
		System.out.println(("key-9"+ " : "+ cache.get("key-9")));
		System.out.println(("key-10"+ " : "+ cache.get("key-10")));
		System.out.println(("key-11"+ " : "+ cache.get("key-11")));
		System.out.println(("key-12"+ " : "+ cache.get("key-12")));
		System.out.println(("key-13"+ " : "+ cache.get("key-13")));
		System.out.println(("key-14"+ " : "+ cache.get("key-14")));
		System.out.println(("key-15"+ " : "+ cache.get("key-15")));
		
		System.out.println(("key-16"+ " : "+ cache.get("key-16")));
		System.out.println(("key-17"+ " : "+ cache.get("key-17")));
		System.out.println(("key-18"+ " : "+ cache.get("key-18")));
		System.out.println(("key-19"+ " : "+ cache.get("key-19")));
		System.out.println(("key-20"+ " : "+ cache.get("key-20")));
		
	}
	
	public static void f2() {
		System.gc();
		
		byte[] arr1 = new byte[1024*1024*6];
		System.out.println(("------key-1"+ " : "+ cache.get("key-1")));
		System.out.println(("------key-2"+ " : "+ cache.get("key-2")));
		System.out.println(("------key-3"+ " : "+ cache.get("key-3")));
		System.out.println(("------key-4"+ " : "+ cache.get("key-4")));
		System.out.println(("------key-5"+ " : "+ cache.get("key-5")));
		System.out.println(("------key-6"+ " : "+ cache.get("key-6")));
		System.out.println(("------key-7"+ " : "+ cache.get("key-7")));
		System.out.println(("------key-8"+ " : "+ cache.get("key-8")));
		System.out.println(("------key-9"+ " : "+ cache.get("key-9")));
		System.out.println(("------key-10"+ " : "+ cache.get("key-10")));
		System.out.println(("------key-11"+ " : "+ cache.get("key-11")));
		System.out.println(("------key-12"+ " : "+ cache.get("key-12")));
		System.out.println(("------key-13"+ " : "+ cache.get("key-13")));
		System.out.println(("------key-14"+ " : "+ cache.get("key-14")));
		System.out.println(("------key-15"+ " : "+ cache.get("key-15")));
		
		System.out.println(("------key-16"+ " : "+ cache.get("key-16")));
		System.out.println(("------key-17"+ " : "+ cache.get("key-17")));
		System.out.println(("------key-18"+ " : "+ cache.get("key-18")));
		System.out.println(("------key-19"+ " : "+ cache.get("key-19")));
		System.out.println(("------key-20"+ " : "+ cache.get("key-20")));
	}
	
}
