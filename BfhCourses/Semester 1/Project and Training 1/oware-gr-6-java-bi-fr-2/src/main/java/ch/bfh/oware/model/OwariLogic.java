/*
 * Project and Training 1: Oware Game - Computer Science, Berner Fachhochschule
 * 
 * This is the required implementation.
 * 
 * As you will see, we didn't use your model implementation for our javaFX application.
 * Even thought we did it.
 * The reason is we didn't knew how to implement the computer player in the required implementation.
 * But found a solution for the way we finally implemented it.
 * The number of pots is fix, we weren't able to made the javaFX pot display flexible.
 * You can change the number of seeds in each pot (at the start) in:
 * 	ch.bfh.oware.JavaFXApp; 
 */
package ch.bfh.oware.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OwariLogic implements Board {

	private final int numberOfPits;
	private final int numberOfSeeds;
	private static int totalNumberOfSeeds;
	private int playerAScore;
	private int playerBScore;
	private int[] houses;

	/**
	 * The constructor initializes the numberOfPits, numberOfSeeds, totalNumberOfSeeds and the houses array, it also fills the houses with the right number of seeds.
	 * @param pits	number of pits
	 * @param seeds number of seeds
	 */
	public OwariLogic(int pits, int seeds) {
		this.numberOfPits = pits;
		this.numberOfSeeds = seeds;
		houses = new int[numberOfPits * 2 + 1];
		Arrays.fill(houses, numberOfSeeds);
		totalNumberOfSeeds = numberOfPits * numberOfSeeds * 2;
	}

	/**
	 * Number of pits.
	 * @return number of pits
	 */
	@Override
	public int getSize() {
		return numberOfPits;
	}

	/**
	 * Number of seeds.
	 * @return number of seeds
	 */
	@Override
	public int getInitialSeeds() {
		return numberOfSeeds;
	}

	/**
	 * Returns the current number of seeds at any specific pit.
	 * @param row The row number
	 * @param pit The pit number
	 * @return the current number of seeds
	 */
	@Override
	public int countSeeds(int row, int pit) {
		return (row == 1) ? houses[pit] : houses[pit + numberOfPits];
	}

	/**
	 * Returns the score of each player.
	 * @param row The row number
	 * @return the player's score
	 */
	@Override
	public int getScore(int row) {
		return (row == 1) ? playerAScore : playerBScore;
	}

	/**
	 * Checks if the player has a legal move.
	 * @param row The row number
	 * @return true if the player has a legal move, otherwise false
	 */
	@Override
	public boolean hasMoves(int row) {
		return (row == 1) ? playerAValidMove() : playerBValidMove();
	}

	/**
	 * Returns a list of legal moves that a player can play.
	 * @param row The row number
	 * @return a list of legal moves
	 */
	public List<Integer> getMoves(int row) {
		return (row == 1) ? playerALegalMoves() : playerBLegalMoves();
	}

	/**
	 * Conducts a move at a specific pit and row according to the Oware game rules.
	 * @param row The row number
	 * @param pit The pit number
	 */
	@Override
	public void play(int row, int pit) {
		int numberOfIterations = 0;
		int actualPit = pit;
		int i = 1;
		if (row == 1) {
			numberOfIterations = houses[pit];
			houses[pit] = 0;
		}

		else {
			actualPit += numberOfPits;
			numberOfIterations = houses[actualPit];
			houses[actualPit] = 0;
		}

		while (i <= numberOfIterations) {

			if (actualPit < numberOfPits * 2) {
				countScore (row, ++actualPit);
			}

			else {
				actualPit = 1;
				countScore (row, actualPit);
			}
			i++;
		}
	}

	/**
	 * This method updates the score of the players and the total number of seeds.
	 * @param row The row number
	 * @param pit The pit number
	 */
	private void countScore(int row, int pit) {
		if (row == 1 && pit > numberOfPits) {
			if (houses[pit] == 1) {
				houses[pit] = 0;
				playerAScore += 2;
				totalNumberOfSeeds -= 2;
				return;
			}
		}

		if (row == 2 && pit <= numberOfPits) {
			if (houses[pit] == 1) {
				houses[pit] = 0;
				playerBScore += 2;
				totalNumberOfSeeds -= 2;
				return;
			}
		}
		houses[pit] += 1;
	}

	/**
	 * Checks if the game is over by using the total number of seeds.
	 * @return true if the game is over, and false otherwise
	 */
	@Override
	public boolean gameOver() {
		return totalNumberOfSeeds <= 2;
	}

	/**
	 * Checks if the number of seeds in a given pit is strictly greater than zero.
	 * @return true if the player A has a valid move (the number of seeds > 0), otherwise false
	 */
	private boolean playerAValidMove() {
		for (int i = 1; i <= numberOfPits; i++) {
			if (houses[i] > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the number of seeds in a given pit is strictly greater than zero.
	 * @return true if the player B has a valid move (the number of seeds > 0), otherwise false
	 */
	private boolean playerBValidMove() {
		for (int i = 1; i <= numberOfPits; i++) {
			if (houses[i + numberOfPits] > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Goes through all the pits that belong to player A and checks if the number of seeds in them is strictly greater than zero.
	 * @return a list of the legal moves that the player A has.
	 */
	private List<Integer> playerALegalMoves() {
		List<Integer> legalMoves = new ArrayList<>();
		for (int i = 1; i <= numberOfPits; i++) {
			if (houses[i] > 0) {
				legalMoves.add (i);
			}
		}
		return legalMoves;
	}

	/**
	 * Goes through all the pits that belong to player B and checks if the number of seeds in them is strictly greater than zero.
	 * @return a list of the legal moves that the player B has
	 */
	private List<Integer> playerBLegalMoves() {
		List<Integer> legalMoves = new ArrayList<>();
		for (int i = 1; i <= numberOfPits; i++) {
			if (houses[i + numberOfPits] > 0) {
				legalMoves.add(i);
			}
		}
		return legalMoves;
	}
}