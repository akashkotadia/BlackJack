package table;

import java.util.ArrayList;

import deck.Card;

public class Game {

	ArrayList<Card> cards;
	
	boolean burst=false;
	boolean stay=false;
	boolean blackJack=false;
	
	int favourableTotal=0;
	
	public Game(){
		cards=new ArrayList<Card>();
	}
	public void addCard(Card card){
		cards.add(card);
		favourableTotal=getMaxTotal();
		if(favourableTotal>21){
			System.out.println("Burst");
			burst=true;
		}
		if(favourableTotal==21 && cards.size()==2)
			blackJack=true;
		System.out.print("--" + favourableTotal + "--");
	}
	public Card getCard(int cardIndex){
		return cards.get(cardIndex);
	}
	public boolean isSplitabble(){
		if(cards.size()==2 && cards.get(0).getBlackJackValue()==cards.get(1).getBlackJackValue()){
			return true;
		}
		return false;
	}
	public boolean isBlackJack(){
		return blackJack;
	}
	
	public boolean isBurst(){
		return burst;
	}
	
	public void doStay(){
		stay=true;
	}
	public int getHardTotal(){
		int total=0;
		for(Card card:cards){
			total+=card.getBlackJackValue();
		}
		return total;
	}
	public int getSoftTotal(){
		int total=0;
		for(Card card:cards){
			if(card.isAce()){
				if((total+11)<=21){
					total+=11;
					continue;
				}
				else{
					total+=1;
					continue;
				}
			}
			total+=card.getBlackJackValue();
		}
		return total;
	}
	
	public int getMaxTotal(){
		int hardTotal=getHardTotal();
		int softTotal=getSoftTotal();
		if(hardTotal>softTotal){
			if(hardTotal>21)
				return softTotal;
		
			return hardTotal;
		}
		else
			return softTotal;
	}
	
	public boolean includeAce(){
		for(Card card:cards){
			if(card.isAce())
				return true;
		}
		return false;
	}
}
