package hand;

import deck.Card;

public class HandPoints {
	
	private int softTotal=0;
	private int hardTotal=0;
	private int favorableTotal=0;
	
	public void updateHandPointsTotal(Card card){
	
		if(card.isAce()){
			if((softTotal + 11) <= 21)
				softTotal+=11;
			else
				softTotal+=card.getBlackJackValue();
		}
		else
			softTotal+=card.getBlackJackValue();
		
		hardTotal+=card.getBlackJackValue();
			
		// Favorable Total
		if(hardTotal>softTotal){
			if(hardTotal>21)
				favorableTotal=softTotal;
			else
				favorableTotal=hardTotal;
		}
		else{
			if(softTotal>21)
				favorableTotal=hardTotal;
			else
				favorableTotal=softTotal;
		}
	}
	
	public int getFavorableTotal(){
		return favorableTotal;
	}
}
