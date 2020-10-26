package com.bdlz.gambler;

import java.util.Random;

public class GamblingSimulation {
public static final int STAKE=100;
public static final int BET=1;

public void winOrLoss() {
	Random random = new Random();
	int value=random.nextInt(2);
	if(value==1) {
		System.out.println("Gambler won ");
	}
	else {
		System.out.println("Gambler lost");
	}
}
}
