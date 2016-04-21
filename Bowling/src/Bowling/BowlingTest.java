package Bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingTest {

	@Test (expected = Exception.class)
	public void shouldThrowExceptionIfIncorrectNumberOfPinsInRow() {
		Game game = new Game();
		game.roll(-5);
	}
	
	@Test (expected = Exception.class)
	public void shouldThrowExceptionIfTooManyRollsInGame() {
		Game game = new Game();
		int[] results = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		for (int result : results) {
			game.roll(result);
		}
	}
	
	@Test
	public void shouldReturn5After1RollWith5Pins() {
		Game game = new Game();
		game.roll(5);
		int score = game.score();
		assertEquals(5, score);
	}

	@Test
	public void shouldReturn6After2RollsWith5And1Pins() {
		Game game = new Game();
		int[] results = { 5, 1 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(6, score);
	}

	@Test
	public void shouldReturn14After3SpecificRolls() {
		Game game = new Game();
		int[] results = { 5, 4, 5 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(14, score);
	}

	@Test
	public void shouldReturn20After4RollsWithSpareInFirstRound() {
		Game game = new Game();
		int[] results = { 5, 5, 4, 2 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(20, score);
	}

	@Test
	public void shouldReturn20After3RollsWithStrikeInFirstRound() {
		Game game = new Game();
		int[] results = { 10, 2, 3 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(20, score);
	}

	@Test
	public void shouldReturn60After3StrikesInRow() {
		Game game = new Game();
		int[] results = { 10, 10, 10 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(60, score);
	}

	@Test
	public void shouldReturn300AfterPerfectGame() {
		Game game = new Game();
		int[] results = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(300, score);
	}

	@Test
	public void shouldReturnFalseForNotFinishedGame() {
		Game game = new Game();
		boolean isFinished = game.isFinished();
		assertFalse(isFinished);
	}

	@Test
	public void shouldReturnTrueForIsGameFinishedAfter2WeakRollsInLastRound() {
		Game game = new Game();
		int[] results = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 2 };
		for (int result : results) {
			game.roll(result);
		}
		boolean isFinished = game.isFinished();
		assertTrue(isFinished);
	}

	@Test
	public void shouldReturnfalseForIsFinishedAfterStrikeAnd5PinsInLastRound() {
		Game game = new Game();
		int[] results = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5 };
		for (int result : results) {
			game.roll(result);
		}
		boolean isFinished = game.isFinished();
		assertFalse(isFinished);
	}

	@Test
	public void shouldReturnFalseForIsFinishedAfterSpareInFirstTwoRolls() {
		Game game = new Game();
		int[] results = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 5 };
		for (int result : results) {
			game.roll(result);
		}
		boolean isFinished = game.isFinished();
		assertFalse(isFinished);
	}

	@Test
	public void shouldReturnTrueForIsFinishedAfterPerfectGame() {
		Game game = new Game();
		int[] results = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		for (int result : results) {
			game.roll(result);
		}
		boolean isFinished = game.isFinished();
		assertTrue(isFinished);
	}

}
