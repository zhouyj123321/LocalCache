package org.zyj.framework.cache.test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import org.zyj.framework.cache.Cache;
import org.zyj.framework.cache.CacheManagerFactory;
import org.zyj.framework.cache.util.CacheType;

public class MyObject {
	int count = 0;
	
	public MyObject(int count) {
		this.count = count;
	}

	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("========================MyObject "+count+" finalize method is called!");
	}
	
	public String toString() {
		return "I am MyObject " + count;
	}
	
	public static void main(String[] args) {
		f1();
	}
	
	public static void f1 () {
		MyObject obj = new MyObject(1);
		byte[] arr2 = new byte[1024*61]; // test 1024*60
		
		ReferenceQueue<MyObject> rq = new ReferenceQueue<MyObject>();
		SoftReference<MyObject> softRef = new SoftReference<MyObject>(obj,rq);
		obj = null;
		System.gc();
		
		System.out.println("====> "+softRef.get());
		byte[] arr1 = new byte[1024*1024*6];
		System.out.println("- - - - - - - --  - --  -- -  - -");
		
		System.out.println("--------->   "+softRef.get());
	}
	
	public static void f2 () {
		byte[] arr2 = new byte[1024*61]; // test 1024*60
		String s1 = "ZYJ";
		ReferenceQueue<String> rq = new ReferenceQueue<String>();
		SoftReference<String> softRef = new SoftReference<String>(s1,rq);
		s1 = null;
		System.gc();
		
		System.out.println("====> "+softRef.get());
		byte[] arr1 = new byte[1024*1024*6];
		System.out.println("- - - - - - - --  - --  -- -  - -");
		
		System.out.println("--------->   "+softRef.get());
	}
}
