package table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import actors.Dealer;
import actors.Player;
import deck.BlackJackDeck;
import deck.Card;

public class BJTable {
	
	BlackJackDeck deck;
	Player[] players;
	Dealer dealer;
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public enum Decision{
		HIT,STAY,DOUBLEHIT,SPLIT
	}
	
	int maxSeats;
	
	public BJTable(int maxSeats){
		this.maxSeats=maxSeats;
		deck=new BlackJackDeck();
		players=new Player[maxSeats];
		dealer=new Dealer("Mr. X", 10000.0);
	}
	
	public void addPlayer(int slot,String name,double balance){
			players[slot]=new Player(name, balance);
	}
	public void removePlayer(int slot){
		players[slot]=null;
	}
	
	public void askToBet() throws NumberFormatException, IOException{
		// Ask To Bet
		for(int slot=0;slot<maxSeats;slot++){
			if(players[slot]!=null){
				System.out.print("Player["+slot+"], Bet ? ");
				players[slot].play(Double.parseDouble(br.readLine()));
			}
			System.out.println(players[slot].getAccount().getBalance());
		}		
	}
	public void drawCards(){
		for(int i=0;i<2;i++){
			for(int slot=0;slot<maxSeats;slot++){
				if(players[slot]!=null && players[slot].canPlay()){
					Card c=deck.drawCard();
					players[slot].getGame(0).addCard(c);
					System.out.print("Player["+slot+"] : ");
					c.printCard();
					System.out.println();
				}
			}
		}
		Card c=deck.drawCard();
		dealer.getGame().addCard(c);
		System.out.print("Dealer :");
		c.printCard();
		System.out.println();
	}
	public void askDecision() throws IOException{
		
		for(int slot=0;slot<maxSeats;slot++){
			if(players[slot]!=null){
				String decision=br.readLine();
				
				if(decision.contains("H")){
					System.out.println("Hit");
					players[slot].hit(0,deck.drawCard()); // Temp=0
				}
				else if(decision.contains("S")){
					players[slot].stay(0);
				}
				else if(decision.contains("D")){
					players[slot].doubleHit(0, deck.drawCard());
				}
			}
		}
	}
	
	public void dealerPlay(){
		// Dealer Reach To 17 Or Burst
		while(dealer.getGame().getMaxTotal()<17){
			dealer.getGame().addCard(deck.drawCard());
			if(dealer.getGame().burst)
				break;
			}
	}
	public void WinOrLose(){

		if(dealer.getGame().isBurst()){
			for(int slot=0;slot<maxSeats;slot++){
				if(players[slot]!=null){
					for(int i=0;i<players[slot].getGameCount();i++){
						players[slot].getAccount().addAmount(players[slot].getBet(i)*2);
					}
				}
			}
		}
		
		// Final : Win-Lose,Money Settlement
		int dealerTotal=dealer.getGame().getMaxTotal();
				
		for(int slot=0;slot<maxSeats;slot++){
			if(players[slot]!=null){
				for(int i=0;i<players[slot].getGameCount();i++){
					if(!players[slot].getGame(i).burst && players[slot].getGame(i).getMaxTotal()>dealerTotal){
						players[slot].getAccount().addAmount(players[slot].getBet(i)*2);
					}
				}
			}
			System.out.println(players[slot].getAccount().getBalance());
		}
		
	}
	
	public Decision askDecision(int slot){
		switch(slot){
		// Temporary
		case 1: return Decision.HIT;
		case 2: return Decision.STAY;
		case 3: return Decision.DOUBLEHIT;
		default:return null;
		}
	}
	public static void main(String[] args){
		
	}
}
