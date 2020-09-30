package com.spring;

public class OperatingSystemImplements implements OperatingSystem {

	private OsVersion osVersion;
	
	
	//Constructor Injection since we inject osverison interface in contructor itself
	public OperatingSystemImplements(OsVersion osVersion) {
		super();
		this.osVersion = osVersion;
	}

	@Override
	public String getOs() {
		// TODO Auto-generated method stub
		return "Windows, Mac, Linux";
	}
	
	
	//Getting the osversion from the class that implements it
	public String getOsVersion() {
		return osVersion.getOsVersion();
	}

}
