package actors;


import hand.Hand;

import java.util.ArrayList;

import deck.Card;

public class Player {

	private String name;
	private PlayerAccount account;
	private ArrayList<Hand> hands;
	
	public Player(String name,double balance){
		this.name=name;
		account=new PlayerAccount(balance);
		hands=new ArrayList<Hand>();
	}
	
	// Add - get Hand
	public Hand createHand(double bet){
		Hand hand=new Hand(bet);
		hands.add(hand);
		account.withdrawl(bet);
		return hand;
	}
	public Hand getHand(int handIndex){
		return hands.get(handIndex);
	}
	public ArrayList<Hand> getAllhands(){
		return hands;
	}
	
	// Action On Hand
	public void hit(Hand hand,Card card){
		hand.addCard(card);
		System.out.println(card.printCard());
	}
	public void doubleHit(Hand hand,Card card){
		hand.addCard(card);
		account.withdrawl(hand.getBet());
		System.out.println(card.printCard());
	}
	public void split(Hand hand){
		if(hand.isSplittable()){
			createHand(hand.getBet()).addCard(hand.getCard(0));
			createHand(hand.getBet()).addCard(hand.getCard(1));
			hands.remove(hand);
			account.deposit(hand.getBet());
		}
	}
	
	// Name
	public String getName(){
		return name;
	}
	// Account
	public PlayerAccount getAccount(){
		return account;
	}
}
