package com.java.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public  class StaticCode  {
	public static void staticMethod1(){
		System.out.println("++++静态方法开始+++++");
	}
	public static void staticMethod2(){
		System.out.println("+++静态方法结束+++++++");
	}
}
