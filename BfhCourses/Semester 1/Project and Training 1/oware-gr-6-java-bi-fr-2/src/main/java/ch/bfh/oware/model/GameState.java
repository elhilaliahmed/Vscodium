/*
 * Project and Training 1: Oware Game - Computer Science, Berner Fachhochschule
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

import java.util.Hashtable;
import java.util.concurrent.ThreadLocalRandom;
import ch.bfh.oware.model.Player.State;


public class GameState  {
	/**
	 * the GameState class has:
	 *  a boolean param withIA to indicate if the computer is playing or not
	 *  a player hashtable
	 *  a pots hashtable: 12pots in total
	 */
	private boolean withIA;
	private boolean hard = true;
	private int seeds;

	static Hashtable<Integer, Player>
	thePlayers = new Hashtable<Integer, Player>();


	static Hashtable<Integer, Pot>
	thePots = new Hashtable<Integer, Pot>();


	// CONSTRUCTOR
	/**
	 * initialises the game 
	 * @param withIA
	 */
	public GameState (boolean withIA, int seeds) {
		
		this.seeds = seeds;
		this.withIA = withIA;

		thePlayers.put(1, new Player (1));
		thePlayers.put(2, new Player (2));

		reset ();
	}
	
	public GameState (boolean withIA, boolean hard, int seeds) {
		
		this.seeds = seeds;
		this.withIA = withIA;
		this.hard = hard;

		thePlayers.put(1, new Player (1));
		thePlayers.put(2, new Player (2));

		reset ();
	}

	//METHODS

	/*
	 * method used in constructor and to reset the game
	 * gives id to pots from 0 to 11 
	 * sets the score to 0
	 * the game always starts with player 1 hence his state is activ
	 * player 2 state is inactiv
	 * 
	 */
	public void reset () {

		for(int i = 0 ; i < 6; i++) {
			Pot pot = new Pot(i, 1, this.seeds);
			thePots.put(i, pot);
		}

		for(int j = 6 ; j < 12; j++) {
			Pot pot = new Pot(j, 2, this.seeds);
			thePots.put(j, pot);
		}

		getPlayer(1).score = 0;
		getPlayer(2).score = 0;
		getPlayer(1).state = State.ACTIV;
		getPlayer(2).state = State.INACTIV;
	}


	/**
	 * this method returns the ID of the current player 
	 * */
	public int nowPlayer(Pot pots) {
		if (pots.getID()  > 6) {
			return 2;
		}
		else {
			return 1;
		}
	}

	/**
	 *  this method is supposed to return the number of seeds in the pot 
	 *  */
	public String getSeedsOfPot (int potID) {
		return Integer.toString(thePots.get(potID % 12).getSeeds());
	}

	/**
	 * this method checks the score of the game to see if there is a winner or not 
	 * and checks if there is seeds to be recolted after each played move
	 * @param potId the pot chosen to play from
	 * @param seeds number of seeds in that pot
	 */
	public void checkMove (int potId, int seeds) {
		Pot pot = thePots.get(potId);
		Player player = thePlayers.get(pot.getPlayerID());
		int playerId = pot.getPlayerID();

		int inter = ((potId + seeds) % thePots.size());

		if (playerId == 1 && getPlayer(1).state == State.ACTIV) {
			if(inter < 6 && seeds > 6) {
				inter = 11;
			}
			else if(seeds >= 12) {
				inter = 11;
			}
			for (int i = 6 ; i <= inter ; i++) {
				if (thePots.get(i).getSeeds() == 2) {
					thePots.get(i).pickSeed();
					player.alterScore();
				}
			}
		}
		else if(playerId == 2 && getPlayer(2).state == State.ACTIV)  {
			if(inter > 5 && seeds > 6) {
				inter = 5; 
			}
			else if(seeds >= 12) {
				inter = 5;
			}
			else if( (potId + seeds) < 12) {
				inter = -1;
			}
			for (int i = 0 ; i <= inter ; i++) {
				if (thePots.get(i).getSeeds() == 2) {
					thePots.get(i).pickSeed();
					player.alterScore();
				}
			}
		}
	}

	/**
	 * check if there is a winner 
	 * @return a boolean variable true is there is a winner 
	 */
	public boolean winner() {
		boolean isAwinnner = false;

		if ((getPlayer(1).getScore() + getPlayer(2).getScore()) >= 46 ) {
			isAwinnner = true; 
			if (getPlayer(1).getScore() > getPlayer(2).getScore()) {
				getPlayer(1).state =State.WINNER;
			}
			else {
				getPlayer(2).state =State.WINNER;
			}
		}

		if(getPlayer(1).state == State.WINNER) {
			
		}
		else if(getPlayer(2).state == State.WINNER) {
			
		}

		return isAwinnner;
	}


	/**
	 * a method to see if the player have any seeds,
	 * if he doesn't he can't play and have to pass his turn
	 * * @param playerId
	 * 
	 */
	public boolean canPlay(int playerId) {
		boolean canPlay = true;

		int addition = 0;

		if(playerId == 1) {
			for(int i = 0; i < 6; i++) {
				addition += thePots.get(i).getSeeds();
			}
		}
		else if(playerId == 2) {
			for(int i = 6; i < 12; i++) {
				addition += thePots.get(i).getSeeds();
			}
		}

		if( addition == 0) {
			canPlay = false;
		}
	
		return canPlay;

	}

	/**
	 * distribute seeds to pots
	 * @param potID
	 */
	public void addSeeds(int potID){

		//Get id du pot en parametre
		int IDpotEnParametre = potID ; 

		//Get nbr de seed du pot en parametre
		int nbrDeSeedsQuiResteAjouter = getPotWId(potID).getSeeds();

		do {
			//+ 1 a l'id pour pointer sur le pots suivant
			IDpotEnParametre = ((IDpotEnParametre + 1 )% thePots.size());

			//ajouter a ce pot 1 seed
			thePots.get(IDpotEnParametre).addSeed();

			//soustraire 1 au nbr de seeds qui reste a ajouter
			nbrDeSeedsQuiResteAjouter--;

			//si nbr de seeds qui reste a ajouter est >0 alors refaire
		} while (nbrDeSeedsQuiResteAjouter > 0);

		getPotWId(potID).pickSeed();
	}


	/**
	 * plays a move only if it can be played (legal)
	 */
	public void play (int potId) {
		Pot pot = getPotWId(potId);
		int seeds = 0;

		Player player = getPlayer(pot.getPlayerID()) ;
		Player playerOff;

		if(player.getId() == 1) {
			playerOff = getPlayer(2);	
		}
		else {				
			playerOff = getPlayer(1);	
		}

		if (canPlay (pot.getPlayerID())) {
			if (player.state == State.ACTIV  &&  pot.getSeeds() != 0) {
				seeds = pot.getSeeds();
				addSeeds(potId);

				checkMove (potId, seeds);

				winner();

				if(!winner()) {
					playerOff.state = State.ACTIV;
					player.state = State.INACTIV;
				}
				else if(!canPlay(1) && withIA) {
					getPlayer(1).state = State.INACTIV;
					getPlayer(2).state = State.ACTIV;
				}

					
				if(withIA && player.getId() == 1 && !winner() && hard) {
					play(computerPlay2());
				}
				else if(withIA && player.getId() == 1 && !winner() && !hard) {
					play(computerPlay1());
				}
			} 
		}
		else {
			playerOff.state = State.ACTIV;
			player.state = State.INACTIV;
		} 
		
		//sécurité 
		if(withIA && !canPlay(1)) {
			getPlayer(1).state = State.INACTIV;
			getPlayer(2).state = State.ACTIV;
		}
		
		if(!canPlay(1) && withIA && !winner() && hard && getPlayer(2).state == State.ACTIV) {
			do {
				play(computerPlay2());	
			}
			while(!canPlay(1));				
		}
		
		if(!canPlay(1) && withIA && !winner() && !hard && getPlayer(2).state == State.ACTIV) {
			do {
				play(computerPlay1());	
			}
			while(!canPlay(1));						
		}
	}

	/**
	 * chooses a random pot to play from the pots of player 2
	 * 
	 */
	public int computerPlay1 () {
		int randomId = ThreadLocalRandom.current().nextInt(6, 12);

		if(canPlay(2)) {
			while(getPotWId(randomId).getSeeds() == 0) {
				randomId = ThreadLocalRandom.current().nextInt(6, 12);
			}
		}		
		return randomId;
	}


	public int computerPlay2() {
		int potid1 = -1;
		int potid2 = 0;
		potid2 = ThreadLocalRandom.current().nextInt(6, 12);
		int seeds = 0;
		for( int i = 0; i <= 5; i++) {
			if(getPotWId(i).getSeeds() == 1) {
				potid1 = i;				
			}
		}
		//System.out.println("potid1 : " + potid1);
		
		for( int i = 11; i >= 6; i--) {	
			if(getPotWId(i).getSeeds() >= seeds) {
				seeds = getPotWId(i).getSeeds();
				potid2 = i;
			}
		}

		
		for( int i = 11; i >= 6; i--) {
			if(((getPotWId(i).getSeeds() + i) % thePots.size()) >= potid1 && (getPotWId(i).getSeeds() + i) >= 12 && potid1 != -1) {
				potid2 = i;
				//System.out.println("potid2 for 1 : " + potid2);
			}
		}
		
		//System.out.println("potid2 : " + potid2);
		
		return potid2;
	}

	/**
	 *  this method returns the score of a player	in a string
	 */
	public String getScore (int playerId) {
		return  Integer.toString(thePlayers.get(playerId).score);
	}

	/**
	 * returns the Pot with its given ID
	 */
	public Pot getPotWId (int id) {
		return thePots.get(id );
	}

	/**
	 * this method return the player who's state is activ
	 */
	public Player activPlayer() {
		for(int i = 1; 1 < 3; i++) {
			if(thePlayers.get(i).state == State.ACTIV) {
				return thePlayers.get(i);
			}
		}
	}
	/**
	 * gets the player from its id
	 * @param id
	 * @return the player
	 */
	public Player getPlayer(int id) {
		return thePlayers.get(id);
	}
	
	/**
	 * gets the withIA variable
	 */
	public boolean getWithIA() {
		return this.withIA;
	}
	
}





