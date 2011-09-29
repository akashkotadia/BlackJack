package table;

import hand.Hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import actors.Dealer;
import actors.Player;

import deck.BlackJackDeck;
import deck.Card;

public class BlackJackGame {

	ArrayList<Player> players;
	BlackJackDeck deck;
	Dealer dealer;
	double minimumBet;
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public BlackJackGame(BlackJackTable table){
		players=table.getAllLivePlayer();
		deck=table.getBJDeck();
		dealer=table.getDealer();
		minimumBet=table.minimumBet;
	}
	
	// 1. Ask To Place Bet
	public void askToPlaceBid() throws NumberFormatException, IOException{
		for(Player player:players){
			System.out.print(player.getName() +", Enter Bet : ");
			player.createHand(Double.parseDouble(br.readLine())); // Core
		}
	}
	// 2. Draw Cards
	public void drawCardsToHand(){
		for(int i=0;i<2;i++){							// Core --
			for(Player player:players){
				for(Hand hand:player.getAllhands()){
					hand.addCard(deck.drawCard());
				}
			}
			dealer.getHand().addCard(deck.drawCard());
		}												// -- Core
		// Print Cards
		for(Player player:players){
			for(Hand hand:player.getAllhands()){
				System.out.print(player.getName() + ":["+ hand.getCard(0).printCard()+","+hand.getCard(1).printCard()+"] \n");
			}
		}
		System.out.print("Dealer" + ":["+ dealer.getHand().getCard(0).printCard());
	}
	// 3. Decision : Split/Hit/Stay/Double
	public void askToPlay() throws NumberFormatException, IOException{
		System.out.println("[H : HIT , S : STAY , D : DOUBLE , P : SPLIT ]");
		for(Player player:players){
			for(Hand hand:player.getAllhands()){
				String decision;
				do{
					System.out.print(player.getName() +", ");
					decision=br.readLine();
					
					if(decision.contains("H"))
						player.hit(hand, deck.drawCard());
					else if(decision.contains("D"))
						player.doubleHit(hand,deck.drawCard());
					else if(decision.contains("P"))
						player.split(hand);
					else if(!decision.contains("S")){
						System.out.println("Invalid Input");
						break;
					}
				}while(!decision.contains("S") && !hand.isBurst());
			}
		}
		System.out.println("\n\n");
		// Print Cards
				for(Player player:players){
					for(Hand hand:player.getAllhands()){
						System.out.print(player.getName() + ":["+ hand.getCard(0).printCard()+","+hand.getCard(1).printCard()+"] \n");
					}
				}
	}
	// 4. Dealer Play up to 17
	public void dealerPlay(){
		System.out.print("Dealer" + ":["+ dealer.getHand().getCard(0).printCard() + "," + dealer.getHand().getCard(1).printCard());
		while(!dealer.getHand().isBurst() && dealer.getHand().getPoints().getFavorableTotal()<17){
			Card c=deck.drawCard();
			dealer.getHand().addCard(c);
			c.printCard();
		}
		if(dealer.getHand().isBurst()){
			System.out.println("Dealer Burst");
		}
		else{
			System.out.println("Dealer Score : " + dealer.getHand().getPoints().getFavorableTotal());
		}
	}
	// 5. Compare Hands
	public void compareHands(){
		if(dealer.getHand().getStatus().isBurst()){
			for(Player player:players){
				for(Hand hand:player.getAllhands()){
					player.getAccount().deposit(hand.getBet()*2);
				}
			}
		}
		else{
			for(Player player:players){
				for(Hand hand:player.getAllhands()){
					if(dealer.getHand().getPoints().getFavorableTotal() < hand.getPoints().getFavorableTotal()){
						player.getAccount().deposit(hand.getBet()*2);
					}
					else if (dealer.getHand().getPoints().getFavorableTotal() == hand.getPoints().getFavorableTotal()){
						player.getAccount().deposit(hand.getBet());
					}
				}
			}
		}
		
		System.out.println("\n============ FINAL BALANCE ==============");
		for(Player player:players){
			System.out.print(player.getName() +" : " + player.getAccount().getBalance());
		}
		System.out.println("========================================================");
	}
}
