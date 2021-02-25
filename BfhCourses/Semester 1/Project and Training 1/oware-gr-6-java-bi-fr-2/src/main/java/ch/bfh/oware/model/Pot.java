/*
 * Project and Training 1: Oware Game - Computer Science, Berner Fachhochschule
 */
package ch.bfh.oware.model;


public class Pot {
	
	/**
	 * The pot class represents the pots of the game board
	 */
	static int ID;
	private int playerID;
	private int seeds;

	//CONSTRUCTOR


	/**
	 * the constructor takes 2 arguments : 
	 * ID :int the pots on the gameBoard are numbered
	 * playerID: every set of pots (6 pots)  belongs to a player
	 * a pot starts with 4 seeds inside  
	 */

	public Pot (int ID, int playerID, int seeds) throws IllegalArgumentException {
		if(ID > 11 || ID < 0) {
			throw new IllegalArgumentException("Has to be bigger then zero or samller then 11");
		}else {
			Pot.setID(ID);
		}
		setSeeds(seeds);
		this.setPlayerID(playerID);
	}
	//METHODS

	/**
	 * to get the number of seeds in a pot
	 * @return an int that represents the number of seeds
	 */

	public int getSeeds () {
		return this.seeds;
	}


	/**
	 * this methods adds one seed to a pot
	 */
	public void addSeed () {
		this.seeds += 1;
	}

	/**
	 * sets the number of seeds in a pot to 0 
	 * @return the number of seeds in the pot
	 */
	public int pickSeed () {
		int movingseeds = 0;
		movingseeds = this.getSeeds();
		this.setSeeds(0);
		return movingseeds;
	}

	/**
	 * 
	 * @return the playerID
	 */
	public int getPlayerID() {
		return playerID;
	}

	/**
	 * sets the player ID to a given ID 
	 * @param playerID
	 */
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	/*
	 * gets the ID of the pot
	 */
	public int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}
	/**
	 * set the seeds in a pot
	 * @param seeds
	 */
	public void setSeeds(int seeds) {
		this.seeds = seeds;
	}


}