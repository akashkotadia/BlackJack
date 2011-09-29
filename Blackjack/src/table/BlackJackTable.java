package table;


import java.util.ArrayList;

import actors.Dealer;
import actors.Player;

import deck.BlackJackDeck;

public class BlackJackTable {

	private BlackJackDeck deck;
	private Player[] players;
	private Dealer dealer;
	int maxSeats;
	double minimumBet;
	
	public BlackJackTable(int maxSeats,double minimumBet){
		this.maxSeats=maxSeats;
		this.minimumBet=minimumBet;
		deck=new BlackJackDeck();
		players=new Player[maxSeats];
		dealer=new Dealer();
	}
	// Deck
	public BlackJackDeck getBJDeck(){
		return deck;
	}
	// Players
	public void addPlayer(int slot,String name,double balance){
		players[slot]=new Player(name,balance);
	}
	public void removePlayer(int slot){
		players[slot]=null;
	}
	public ArrayList<Player> getAllLivePlayer(){
		ArrayList<Player> playerList=new ArrayList<Player>();
		for(int slot=0;slot<maxSeats;slot++){
			if(players[slot]!=null){
				playerList.add(players[slot]);
			}
		}
		return playerList;
	}
	// Dealer
	public Dealer getDealer(){
		return dealer;
	}
	public double getMinimumBet(){
		return minimumBet;
	}
}
