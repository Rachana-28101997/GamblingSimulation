package com.bdlz.gambler;

import java.util.LinkedHashMap;
import java.util.Random;

public class GamblingSimulation {
	public static final int STAKE = 100;
	public static final int BET = 1;
	public static final float STAKE_VALUE = 0.5f;
	public static int winningAmount, losingAmount, stake, totalAmountEarned;
	static LinkedHashMap<Integer, Integer> daysWon = new LinkedHashMap<>();
	static LinkedHashMap<Integer, Integer> daysLoss = new LinkedHashMap<>();

	public void winOrLoss() {
		Random random = new Random();
		int value = random.nextInt(2);
		if (value == 1) {
			// System.out.println("Gambler won ");
			stake++;
		} else {
			// System.out.println("Gambler lost");
			stake--;
		}
	}

	public int resignStake(int day) {
		losingAmount = (int) Math.round(STAKE * STAKE_VALUE);
		winningAmount = (int) Math.round(STAKE + (STAKE * STAKE_VALUE));
		boolean stop = true;
		stake = STAKE;
		while (stop == true) {
			winOrLoss();
			if (stake == losingAmount) {
				daysLoss.put(day, stake);
				stop = false;
			}
			if (stake == winningAmount) {
				daysWon.put(day, stake);
				stop = false;
			}
		}

		return stake;
	}

	public int getTotalAmountWonOrLoss() {
		int daysPlaying = 20;
		int day_stake = 0;
		int day = 0;
		while (daysPlaying > 0) {
			day++;
			day_stake = resignStake(day);
			daysPlaying = daysPlaying - 1;
			totalAmountEarned = totalAmountEarned + day_stake;

		}

		System.out.println("Total Amount Earned or Loss by Gambler at End of given period:- " + totalAmountEarned);
		return totalAmountEarned;
	}

	public int calculateForMonth() {

		getTotalAmountWonOrLoss();
		System.out.println("****Days Won in  month****");
		printDaysWithValue(daysWon);
		System.out.println("****Days Loss in  month****");
		printDaysWithValue(daysLoss);

		return totalAmountEarned;
		
	}

	public void printDaysWithValue(LinkedHashMap<Integer, Integer> daysValue) {
		daysValue.forEach(((day, value) -> {
			System.out.println("Day:- " + day + " Earned:- " + value);
		}));
	}

	//public static void luckiestDay(LinkedHashMap<Integer, Integer> daysValue) {
		//daysValue.forEach(((day,value)->{
			//System.out.println("the lucciest day" +Math.max(day, stake)+ +day+ " " +stake);}));
		//}

	

	public static void main(String[] agrs) {
		GamblingSimulation simulation = new GamblingSimulation();
		// System.out.println(simulation.resignStake(20));
		simulation.calculateForMonth();
		//GamblingSimulation.luckiestDay(daysWon);
	}
}
