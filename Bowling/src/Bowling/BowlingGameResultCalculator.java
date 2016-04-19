package Bowling;

public interface BowlingGameResultCalculator {
	public void roll(int numberOfPins);

	public int score();

	public boolean isFinished();
}
