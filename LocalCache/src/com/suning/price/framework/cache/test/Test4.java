package com.suning.price.framework.cache.test;

import java.util.HashMap;
import java.util.Map;

import com.suning.price.framework.cache.Cache;
import com.suning.price.framework.cache.LocalCacheFactory;
import com.suning.price.framework.cache.util.CacheType;
import com.suning.price.framework.cache.util.Contants;

public class Test4 {

	static Map<String, MyObject> map = new HashMap<String, MyObject>();
	public static void main(String[] args) {
		f1();
		byte[] arr2 = new byte[1024*41]; // test 1024*41
		f2();
		
	}
	
	public static void f1() {
		
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
		
		MyObject obj21 = new MyObject(21);
		
//		byte[] arr2 = new byte[1024*33]; // test 1024*60
		map.put("key-1", obj1);
		map.put("key-2", obj2);
		map.put("key-3", obj3);
		map.put("key-4", obj4);
		map.put("key-5", obj5);
		
		map.put("key-6", obj6);
		map.put("key-7", obj7);
		map.put("key-8", obj8);
		map.put("key-9", obj9);
		map.put("key-10", obj10);
		
		map.put("key-11", obj11);
		map.put("key-12", obj12);
		map.put("key-13", obj13);
		map.put("key-14", obj14);
		map.put("key-15", obj15);
		
		map.put("key-16", obj16);
		map.put("key-17", obj17);
		map.put("key-18", obj18);
		map.put("key-19", obj19);
		map.put("key-20", obj20);
		

		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		
		
		System.out.println(("key-1"+ " : "+ map.get("key-1")));
		System.out.println(("key-2"+ " : "+ map.get("key-2")));
		System.out.println(("key-3"+ " : "+ map.get("key-3")));
		System.out.println(("key-4"+ " : "+ map.get("key-4")));
		System.out.println(("key-5"+ " : "+ map.get("key-5")));
		System.out.println(("key-6"+ " : "+ map.get("key-6")));
		System.out.println(("key-7"+ " : "+ map.get("key-7")));
		System.out.println(("key-8"+ " : "+ map.get("key-8")));
		System.out.println(("key-9"+ " : "+ map.get("key-9")));
		System.out.println(("key-10"+ " : "+ map.get("key-10")));
		System.out.println(("key-11"+ " : "+ map.get("key-11")));
		System.out.println(("key-12"+ " : "+ map.get("key-12")));
		System.out.println(("key-13"+ " : "+ map.get("key-13")));
		System.out.println(("key-14"+ " : "+ map.get("key-14")));
		System.out.println(("key-15"+ " : "+ map.get("key-15")));
		
		System.out.println(("key-16"+ " : "+ map.get("key-16")));
		System.out.println(("key-17"+ " : "+ map.get("key-17")));
		System.out.println(("key-18"+ " : "+ map.get("key-18")));
		System.out.println(("key-19"+ " : "+ map.get("key-19")));
		System.out.println(("key-20"+ " : "+ map.get("key-20")));
		
	}
	
	public static void f2() {
		System.gc();
		byte[] arr2 = new byte[1024*60]; // test 1024*60
		byte[] arr1 = new byte[1024*1024*7];
		System.out.println(("------key-1"+ " : "+ map.get("key-1")));
		System.out.println(("------key-2"+ " : "+ map.get("key-2")));
		System.out.println(("------key-3"+ " : "+ map.get("key-3")));
		System.out.println(("------key-4"+ " : "+ map.get("key-4")));
		System.out.println(("------key-5"+ " : "+ map.get("key-5")));
		System.out.println(("------key-6"+ " : "+ map.get("key-6")));
		System.out.println(("------key-7"+ " : "+ map.get("key-7")));
		System.out.println(("------key-8"+ " : "+ map.get("key-8")));
		System.out.println(("------key-9"+ " : "+ map.get("key-9")));
		System.out.println(("------key-10"+ " : "+ map.get("key-10")));
		System.out.println(("------key-11"+ " : "+ map.get("key-11")));
		System.out.println(("------key-12"+ " : "+ map.get("key-12")));
		System.out.println(("------key-13"+ " : "+ map.get("key-13")));
		System.out.println(("------key-14"+ " : "+ map.get("key-14")));
		System.out.println(("------key-15"+ " : "+ map.get("key-15")));
		
		System.out.println(("------key-16"+ " : "+ map.get("key-16")));
		System.out.println(("------key-17"+ " : "+ map.get("key-17")));
		System.out.println(("------key-18"+ " : "+ map.get("key-18")));
		System.out.println(("------key-19"+ " : "+ map.get("key-19")));
		System.out.println(("------key-20"+ " : "+ map.get("key-20")));
	}
	
}
