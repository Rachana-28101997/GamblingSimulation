package com.bdlz.gambler;

import java.util.Random;

public class GamblingSimulation {
	public static final int STAKE = 100;
	public static final int BET = 1;
	public static final float STAKE_VALUE=0.5f;
	public int winningAmount,losingAmount,stake,totalAmountEarned;
	public void winOrLoss() {
		Random random = new Random();
		int value = random.nextInt(2);
		if (value == 1) {
			System.out.println("Gambler won ");
		} else {
			System.out.println("Gambler lost");
		}
	}
	public int resignStake() {
        losingAmount = (int) Math.round(STAKE * STAKE_VALUE);
        winningAmount = (int) Math.round(STAKE + (STAKE * STAKE_VALUE));
        boolean stop = true;
        stake = STAKE;
        while (stop == true) {
            winOrLoss();
            if (stake == losingAmount) {
               stop = false;
            }
            if (stake == winningAmount) {
                stop = false;
            }
        }

        return stake;
    }

public static void main(String[] agrs) {
GamblingSimulation simulation=new GamblingSimulation();
System.out.println(simulation.resignStake());
}
}

