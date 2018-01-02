package com.machinelearningtests.util;

import java.util.Random;

public class RandomGen {
	
	Random rand = new Random();
	
	public RandomGen(){
		
	}
	public int randInt(int min, int max){
		// ex 5,10
		int r = rand.nextInt(max - min) + min;
		return r;
	}
}
