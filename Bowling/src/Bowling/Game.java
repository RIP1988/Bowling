package Bowling;

import java.util.LinkedList;

public class Game implements BowlingGameResultCalculator {
	private LinkedList<Round> rounds = new LinkedList<Round>();

	public Game() {
		LinkedList<Round> tempRounds = new LinkedList<Round>();
		LastRound lastRound = new LastRound();
		for (int i = 0; i < 9; i++) {
			tempRounds.add(new Round());
		}
		tempRounds.add(lastRound);
		for (int i = 0; i < 9; i++) {
			tempRounds.get(i).setNextRound(tempRounds.get(i + 1));
		}
		for (Round round : tempRounds) {
			rounds.add(round);
		}
	}

	public void roll(int numberOfPins) {
		try {
			if (numberOfPins<0 || numberOfPins>10) {
				throw new Exception();
			}
		}
		catch (Exception e) {
			System.out.println("Niepoprawna warto�� rzutu!");
			throw new RuntimeException();
		}
		rounds.get(0).roll(numberOfPins);
	}

	public int score() {
		int score = 0;
		for (Round round : rounds) {
			score += round.getRoundScore();
		}
		return score;
	}

	public boolean isFinished() {
		return rounds.getLast().isFinished();
	}

}
