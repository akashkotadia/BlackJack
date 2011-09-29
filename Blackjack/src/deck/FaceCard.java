package deck;

public class FaceCard extends Card{

	Faces face;
	final int faceValue=10;

	public enum Faces{
		Jack,Queen,King
	}
	public FaceCard(Suit suit,Faces face) {
		super(suit);
		this.face=face;
		// TODO Auto-generated constructor stub
	}
	public int getBlackJackValue(){
		return faceValue;
	}
	
	public String printCard(){
		return suit.name() +"  " + face.name();
	}
}
