package com.java.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 通过反射创建一个动态代理类
 */
public class TestAOP {
	public static void main(String[] args) {
		NikeFactory nf=new NikeFactory();
		MakeProxyFactory mp=new MakeProxyFactory();
		Object obj=mp.makeProxyFactory(nf);
		ClotheFactory cf=(ClotheFactory)obj;
		cf.makeClothe();
	}
}
/*
 * 创建一个接口，提供抽象方法，供类重写
 */
interface ClotheFactory{
	void makeClothe();
}
/*
 * 真实类，重写接口方法
 */
class NikeFactory implements ClotheFactory{

	public void makeClothe() {
		System.out.println("Nike服装厂造衣服");	
	}	
}
 
/*
 *代理类，创建主类对象，通过重新invoke方法，调用真实类的方法。 
 */
class ProxyFactory implements InvocationHandler{
	private Object obj;//定义一个Object用来指定接口类型
		//此方法用来给真实类初始化
	public void setObj(Object obj){
		this.obj=obj;
	}
	StaticCode1 sc=new StaticCode1();
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		sc.statiMethod();
		Object returnObj=method.invoke(obj, args);
		sc.statiMehtod2();
		return returnObj;
	}
	
}
/*
 * 通过此类创建一个代理类对象
 */
class MakeProxyFactory {
	ProxyFactory pf=new ProxyFactory();
	public  Object makeProxyFactory(Object obj){
	pf.setObj(obj);	//动态指定真实类对象
	return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), pf);
	}	
}
class StaticCode1{
	public void statiMethod(){
		System.out.println("库存不住需要生产");
	}
	public void statiMehtod2(){
		System.out.println("足量，停止生产");
	}
}
