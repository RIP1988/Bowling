package Bowling;

import java.util.List;
import java.util.LinkedList;

public class Game implements BowlingGameResultCalculator {
	private LinkedList<Round> allRounds = new LinkedList<Round>();

	public Game() {
		allRounds = giveAll10Rounds();
	}

	public void roll(int numberOfPins) {
		if (numberOfPins < 0 || numberOfPins > 10) {
			throw new IllegalArgumentException("Niepoprawna ilosc kregli");
		}
		allRounds.get(0).roll(numberOfPins);
	}

	public int score() {
		int score = 0;
		for (Round round : allRounds) {
			score += round.getRoundScore();
		}
		return score;
	}

	public boolean isFinished() {
		return allRounds.getLast().isFinished();
	}

	private LinkedList<Round> giveAll10Rounds() {
		List<Round> tempRounds = new LinkedList<Round>();
		LastRound lastRound = new LastRound();
		LinkedList<Round> rounds = new LinkedList<Round>();
		for (int i = 0; i < 9; i++) {
			tempRounds.add(new Round());
		}
		tempRounds.add(lastRound);
		for (int i = 0; i < 9; i++) {
			tempRounds.get(i).setNextRound(tempRounds.get(i + 1));
		}
		rounds.addAll(tempRounds);

		return rounds;
	}

}
