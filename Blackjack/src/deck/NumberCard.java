package deck;

public class NumberCard extends Card{

	int number=0;
	public NumberCard(Suit suit,int number) {
		super(suit);
		this.number=number;
	}
	
	public int getBlackJackValue(){
		return number;
	}
	
	public boolean isAce(){
		return number==1;
	}
	public String printCard(){
		return  ""+number;
	}
}
