package hand;

public class HandStatus {
	
	private boolean burst;
	private boolean blackJack;
	
	public void updateStatus(HandPoints points,int noOfCards){
		int favorableTotal=points.getFavorableTotal();
		
		if(favorableTotal>21)
			burst=true;
		
		if(noOfCards==2 && favorableTotal==21)
			blackJack=true;
	}
	
	public boolean isBurst(){
		return burst;
	}
	
	public boolean isBlackJack(){
		return blackJack;
	}
}
