package deck;

public class Card {

	public enum Suit{
		Club,Spades,Hearts,Diamond
	}
	
	public static Suit getSuitByIndex(int index){
		switch(index){
		
		case 1: return Suit.Club;
		case 2: return Suit.Spades;
		case 3: return Suit.Hearts;
		case 4: return Suit.Diamond;
		
		default : return null;
		}
	}
	Suit suit;
	public Card(Suit suit){
		this.suit=suit;
	}
	public String printCard(){return null;}
	public int getBlackJackValue(){return 0;}
	public boolean isAce(){return false;}
}
