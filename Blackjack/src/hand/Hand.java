package hand;

import java.util.ArrayList;

import deck.Card;

public class Hand {

	private ArrayList<Card> cards;
	private HandPoints points;
	private HandStatus status;
	private double bet;
	
	public Hand(double bet){
		this.bet=bet;
		cards=new ArrayList<Card>();
		points=new HandPoints();
		status=new HandStatus();
	}
	public Hand(){
		cards=new ArrayList<Card>();
		points=new HandPoints();
		status=new HandStatus();
	}
	// Add-Get Card From Hand
	public void addCard(Card card){
		if(!status.isBurst() && !status.isBlackJack()){
			cards.add(card);
			points.updateHandPointsTotal(card);
			status.updateStatus(points,cards.size());
		}
	}
	public Card getCard(int cardIndex){
		return cards.get(cardIndex);
	}
	public ArrayList<Card> getAllCard(){
		return cards;
	}
	
	// Get - Update bet
	public double getBet(){
		return bet;
	}
	public void doubleTheBet(){
		bet*=2;
	}
	
	// Points 
	public HandPoints getPoints(){
		return points;
	}
	// Status
	public HandStatus getStatus(){
		return status;
	}
	// Check On Hand
	public boolean isSplittable(){
		if(cards.size()==2 && cards.get(0).getBlackJackValue()==cards.get(1).getBlackJackValue()){
			return true;
		}
		return false;
	}
	public boolean isBurst(){
		return status.isBurst();
	}
}
