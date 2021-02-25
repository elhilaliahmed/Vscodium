/*
 * Project and Training 1: Oware Game - Computer Science, Berner Fachhochschule
 */
package ch.bfh.oware.model;

public class Player {
	/**
	 * the class player represents a player of the oware game
	 * every player has a state, an id, and a score
	 *
	 */

	public enum State {
		ACTIV,INACTIV,WINNER
	}
	public int id;
	public int score;
	public State state;

	//CONSTRUCTOR
	/**
	 * sets the player ID
	 * @param id
	 * @throws IllegalArgumentException if the player ID is different than 1 or 2
	 */
	public Player(int id) throws IllegalArgumentException{

		if(id < 1 || id > 2) {
			throw new IllegalArgumentException("there is only 2 players so there id can be only 1 or 2");
		}
		else {
			this.id = id;
		}
		this.state =State.INACTIV;
	}


	//METHODS
	/**
	 * @return the playerID
	 */

	public int getId() {
		return this.id;
	}
	/**
	 * @return the player's score
	 */
	public int getScore() {
		return this.score;
	}
	/**
	 * adds 2 to the score (because a player can only increase his score if there is 2 seeds in the enemy's pot
	 */
	public void alterScore() {
		this.score += 2;
	}

	/**
	 * sets the score to a given one
	 * @param score
	 */
	public void setscore(int score) {
		this.score = score;
	}
}