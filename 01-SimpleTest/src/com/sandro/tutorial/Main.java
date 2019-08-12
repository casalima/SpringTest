package com.sandro.tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("sca-beans.xml");
		
		Student godito = context.getBean("aRoeStudent",com.sandro.tutorial.Student.class);
		godito.showInfo();
	}

}
