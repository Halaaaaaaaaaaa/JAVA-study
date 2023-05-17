package com.ezen.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		//1. ������ �����̳� ����
		//ȯ�� ���� ������ applicationContext.xml�� �ε��Ͽ� ������ �����̳� �� �ϳ��� GenericXmlApplicationContext�� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. ������ ��ü�̳ʿ��� �ʿ��� ��ü ��û = Lookup
		//applicationContext.xml���� ������ TV ��ü�� ���� �´�
		TV tv = (TV)container.getBean("tv");
			tv.powerOn();
			tv.powerOff();
			tv.volumeUp();
			tv.volumeDown();
			
		//prototype�̸� <bean>�� ��û�� ������ ��ü�� ��� �����ϰ� close�� ���ϱ� ������ destroy ���� ����
		//singleton�̸� <bean>�� ��û�� �� �ϳ��� ��ü�� �����ϰ� close�� ���ֱ� ������ destroy ����
		TV tv1 = (TV)container.getBean("tv");
		TV tv2 = (TV)container.getBean("tv");
			
		container.close();
	}

}