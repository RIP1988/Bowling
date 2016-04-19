package Bowling;

import java.util.ArrayList;

public class Round {
	private ArrayList<Integer> rolls = new ArrayList<Integer>();
	private final int MAX_NUMBER_OF_PINS_IN_ROUND = 10;
	private Round nextRound;

	public Round() {
	}

	public void setNextRound(Round nextRound) {
		this.nextRound = nextRound;
	}

	public void roll(Integer roll) {
		if (!isFinished()) {
			rolls.add(roll);
		} else
			nextRound.roll(roll);
	}

	public boolean isFinished() {
		if (rolls.size() == 2 || (rolls.size() > 0 && rolls.get(0) == 10)) {
			return true;
		}
		return false;
	}

	public int give1stRollScore() {
		int score = 0;
		if (rolls.size() > 0)
			score += rolls.get(0);
		return score;
	}

	public int giveScoreFrom2Rolls() {
		int score = 0;
		if (rolls.size() == 2) {
			for (int roll: rolls) {
				score += roll;
			}
		} else if (rolls.size() == 1 && rolls.get(0) == 10) {
			score += rolls.get(0);
			score += nextRound.give1stRollScore();
		} else if (rolls.size() > 0) {
			score += rolls.get(0);
		} 
		return score;
	}

	public int getRoundScore() {
		int score = 0;
		for (Integer roll : rolls) {
			score += roll;
		}
		if (rolls.size() == 2 && score == MAX_NUMBER_OF_PINS_IN_ROUND) {
			score += nextRound.give1stRollScore();
		} else if (rolls.size() == 1 && score == MAX_NUMBER_OF_PINS_IN_ROUND) {
			score += nextRound.giveScoreFrom2Rolls();
		}
		return score;
	}

}
