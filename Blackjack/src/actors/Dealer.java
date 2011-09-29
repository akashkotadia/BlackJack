package actors;

import hand.Hand;

public class Dealer {

	String name;
	Hand hand;
	
	public Dealer(){
		hand=new Hand();
	}
	
	public Hand getHand(){
		return hand;
	}
}
