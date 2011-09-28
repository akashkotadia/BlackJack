package deck;

import java.util.LinkedList;

import deck.Card.Suit;
import deck.FaceCard.Faces;

public class Deck {

	protected LinkedList<Card> cards=new LinkedList<Card>();
	public Deck(){
		
		Suit suit;
		
		// Build Deck
		for(int suitIndex=1;suitIndex<=4;suitIndex++){
			suit=Card.getSuitByIndex(suitIndex);
			
			// Build Number Card
			for(int number=1;number<=10;number++){
				cards.add(new NumberCard(suit, number));
			}
			
			// Build Face Card
			cards.add(new FaceCard(suit,Faces.Jack));
			cards.add(new FaceCard(suit,Faces.Queen));
			cards.add(new FaceCard(suit,Faces.King));
		}
	}
	public void printDeck(){
		for(Card card:cards){
			card.printCard();
		}
	}
	public Card removeCardByIndex(int index){
		Card tmp = cards.get(index);
		cards.remove(index);
		return tmp;
	}
}
