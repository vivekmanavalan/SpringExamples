package com.spring;

import java.util.Random;

public class FortuneServiceImplements implements FortuneService {

	@Override
	public String getfortune() {
		String fortune [] = {"good", "bad", "very good"};
		Random r = new Random();
		int f = r.nextInt(fortune.length);
		return fortune[f];
	}

}
