package com.java.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * ͨ�����䴴��һ����̬������
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
 * ����һ���ӿڣ��ṩ���󷽷���������д
 */
interface ClotheFactory{
	void makeClothe();
}
/*
 * ��ʵ�࣬��д�ӿڷ���
 */
class NikeFactory implements ClotheFactory{

	public void makeClothe() {
		System.out.println("Nike��װ�����·�");	
	}	
}
 
/*
 *�����࣬�����������ͨ������invoke������������ʵ��ķ����� 
 */
class ProxyFactory implements InvocationHandler{
	private Object obj;//����һ��Object����ָ���ӿ�����
		//�˷�����������ʵ���ʼ��
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
 * ͨ�����ഴ��һ�����������
 */
class MakeProxyFactory {
	ProxyFactory pf=new ProxyFactory();
	public  Object makeProxyFactory(Object obj){
	pf.setObj(obj);	//��ָ̬����ʵ�����
	return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), pf);
	}	
}
class StaticCode1{
	public void statiMethod(){
		System.out.println("��治ס��Ҫ����");
	}
	public void statiMehtod2(){
		System.out.println("������ֹͣ����");
	}
}
