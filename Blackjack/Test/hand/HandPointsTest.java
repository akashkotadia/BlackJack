package hand;

import junit.framework.TestCase;

import org.junit.Test;

import deck.FaceCard;
import deck.NumberCard;
import deck.Card.Suit;
import deck.FaceCard.Faces;

public class HandPointsTest extends TestCase {

	HandPoints points;
	
	@Override
	protected void setUp(){
		points=new HandPoints();
	}
	@Test
	public void testUpdateHandPointsTotal() {
		points.updateHandPointsTotal(new FaceCard(Suit.Spades, Faces.King));
		points.updateHandPointsTotal(new NumberCard(Suit.Diamond, 1));
		assertEquals(21, points.getFavorableTotal());
		
		setUp();
		points.updateHandPointsTotal(new NumberCard(Suit.Diamond, 1));
		points.updateHandPointsTotal(new FaceCard(Suit.Spades, Faces.King));
		points.updateHandPointsTotal(new NumberCard(Suit.Spades, 9));
		assertEquals(20, points.getFavorableTotal());
		
		setUp();
		points.updateHandPointsTotal(new NumberCard(Suit.Diamond, 1));
		points.updateHandPointsTotal(new NumberCard(Suit.Spades, 1));
		assertEquals(12, points.getFavorableTotal());
	}

}
