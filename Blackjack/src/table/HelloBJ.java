package table;

import java.io.IOException;

public class HelloBJ {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BlackJackTable table=new BlackJackTable(5,10.0);
		table.addPlayer(0, "Akash", 5000.0);
		table.addPlayer(1, "xyz", 9000.0);
		BlackJackGame game=new BlackJackGame(table);
		game.askToPlaceBid();
		game.drawCardsToHand();
		game.askToPlay();
		game.dealerPlay();
		game.compareHands();
	}
}
