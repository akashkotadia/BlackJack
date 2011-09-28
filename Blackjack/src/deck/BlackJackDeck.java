package deck;

import java.util.Random;
import java.util.Stack;

public class BlackJackDeck extends Deck{

	Stack<Card> blackJackDeck=new Stack<Card>();

	public BlackJackDeck(){
		shuffle();
	}
	
	public void shuffle(){			
		Random random=new Random();
		for(int size=52;size>0;size--){
			int randomIndex=random.nextInt(size);
			blackJackDeck.push(removeCardByIndex(randomIndex));
		}
	}
	
	public Card drawCard(){
		return blackJackDeck.pop();
	}
	public static void main(String[] args){
		BlackJackDeck obj=new BlackJackDeck();
		obj.drawCard().printCard();
	}
}
 