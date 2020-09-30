package com.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DetailsMain {

	public static void main(String[] args) {
		// In the below line we specify that the bean instantiation is in applicationcontext file.
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//calling the bean using the bean id
		OperatingSystemImplements os = (OperatingSystemImplements) context.getBean("operatingsystem",OperatingSystem.class);
		
		//Creating object for implements because fortune service is injected into this class
		LanguageImplements lang = (LanguageImplements) context.getBean("language", Language.class);
		
		
		//calling the interface method
		System.out.println("Today Fortune "+ lang.getFortuneService());
		System.out.println("Name "+lang.getName());
		System.out.println("Age "+ lang.getAge());
		System.out.println("Language Known "+lang.getlang());
		System.out.println("Operating System "+ os.getOs());
		System.out.println("OS Version " + os.getOsVersion());
	}

}
