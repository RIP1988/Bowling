package Bowling;

import java.util.ArrayList;
import java.lang.Exception;

public class LastRound extends Round {
	private ArrayList<Integer> rolls = new ArrayList<Integer>();
	private final int MAX_NUMBER_OF_PINS_IN_ROUND = 10;

	public LastRound() {
	}

	public int give1stRollScore() {
		if (rolls.size() > 0)
			return rolls.get(0);
		return 0;
	}

	public int giveScoreFrom2Rolls() {
		int score = 0;
		if (rolls.size() == 1) {
			score += rolls.get(0);
		} else if (rolls.size() > 1) {
			for (int i = 0; i < 2; i++) {
				score += rolls.get(i);
			}
		}
		return score;
	}

	public void roll(Integer roll) {
			if (!isFinished()) {
				rolls.add(roll);
			} else
				throw new RuntimeException("Za duzo rzutow. Gra ju¿ siê skonczyla.");
		} 
	

	public boolean isFinished() {
		int score = 0;
		for (Integer roll : rolls) {
			score += roll;
		}
		return ((rolls.size() == 2 && score < MAX_NUMBER_OF_PINS_IN_ROUND) || rolls.size() == 3);	 
	}

	public int getRoundScore() {
		int score = 0;
		for (Integer roll : rolls) {
			score += roll;
		}
		return score;
	}
}
