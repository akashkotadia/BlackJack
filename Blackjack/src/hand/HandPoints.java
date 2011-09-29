package hand;

import deck.Card;
import deck.Card.Suit;
import deck.FaceCard.Faces;
import deck.FaceCard;
import deck.NumberCard;

public class HandPoints {
	
	private int softTotal=0;
	private int hardTotal=0;
	private int favorableTotal=0;
	
	public void updateHandPointsTotal(Card card){
	
			updateSoftTotal(card);
			updateHardTotal(card);
			
			// Favorable Total
			if(hardTotal>softTotal){
				if(hardTotal>21)
					favorableTotal=softTotal;
				else
					favorableTotal=hardTotal;
			}
			else
				favorableTotal=softTotal;
	}
	public void updateSoftTotal(Card card){
		if(card.isAce()){
			if((softTotal + 11) <= 21){
				softTotal+=11;
				return;
			}
		}
		softTotal+=card.getBlackJackValue();
	}
	public void updateHardTotal(Card card){
		hardTotal+=card.getBlackJackValue();
	}
	public int getFavorableTotal(){
		return favorableTotal;
	}
	public static void main(String[] args){
		HandPoints points=new HandPoints();
		points.updateHandPointsTotal(new FaceCard(Suit.Spades, Faces.King));
		points.updateHandPointsTotal(new NumberCard(Suit.Diamond, 1));
		System.out.println(points.getFavorableTotal());
	}
}
