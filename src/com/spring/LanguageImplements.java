package com.spring;

public class LanguageImplements implements Language {
	
	
	private String name;
	private String age;
	private FortuneService fortuneService;

	//Here we call the fortuneservice method inturn it checks which class has implemented it and renders values
	public String getFortuneService() {
		return fortuneService.getfortune();
	}

	//This is called setter injection here we inject the fortune service using setter
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getlang() {
		// TODO Auto-generated method stub
		return "Java, PHP, Javascript";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
