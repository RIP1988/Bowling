package Bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingTest {

	@Test (expected = Exception.class)
	public void shouldThrowExceptionIfIncorrectNumberOfPinsInRow() {
		Game game = new Game();
		game.roll(-5);
	}
	
	@Test
	public void test1() {
		Game game = new Game();
		game.roll(5);
		int score = game.score();
		assertEquals(5, score);
	}

	@Test
	public void test2() {
		Game game = new Game();
		int[] results = { 5, 1 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(6, score);
	}

	@Test
	public void test3() {
		Game game = new Game();
		int[] results = { 5, 4, 5 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(14, score);
	}

	@Test
	public void test4() {
		Game game = new Game();
		int[] results = { 5, 5, 4, 2 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(20, score);
	}

	@Test
	public void test5() {
		Game game = new Game();
		int[] results = { 10, 2, 3 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(20, score);
	}

	@Test
	public void test6() {
		Game game = new Game();
		int[] results = { 10, 10, 10 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(60, score);
	}

	@Test
	public void test7() {
		Game game = new Game();
		int[] results = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(300, score);
	}

	@Test
	public void test8() {
		Game game = new Game();
		boolean isFinished = game.isFinished();
		assertFalse(isFinished);
	}

	@Test
	public void test9() {
		Game game = new Game();
		int[] results = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 2 };
		for (int result : results) {
			game.roll(result);
		}
		boolean isFinished = game.isFinished();
		assertTrue(isFinished);
	}

	@Test
	public void test10() {
		Game game = new Game();
		int[] results = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5 };
		for (int result : results) {
			game.roll(result);
		}
		boolean isFinished = game.isFinished();
		assertFalse(isFinished);
	}

	@Test
	public void test11() {
		Game game = new Game();
		int[] results = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 5 };
		for (int result : results) {
			game.roll(result);
		}
		boolean isFinished = game.isFinished();
		assertFalse(isFinished);
	}

	@Test
	public void test12() {
		Game game = new Game();
		int[] results = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		for (int result : results) {
			game.roll(result);
		}
		boolean isFinished = game.isFinished();
		assertTrue(isFinished);
	}

	@Test
	public void test13() {
		Game game = new Game();
		int[] results = { 10, 10, 8, 2, 3, 0, 3, 4, 8, 1, 4, 4, 4, 4, 4, 4, 10, 10, 10 };
		for (int result : results) {
			game.roll(result);
		}
		int score = game.score();
		assertEquals(134, score);
	}
}
