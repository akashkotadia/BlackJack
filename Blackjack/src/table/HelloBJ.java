package table;

import java.io.IOException;

public class HelloBJ {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		while(true){
			BlackJackTable table=new BlackJackTable(5,10.0); //temporary
			table.addPlayer(0, "Akash", 5000.0);
			table.addPlayer(1, "xyz", 9000.0);
			BlackJackGameConsole game=new BlackJackGameConsole(table);
			System.out.println("==============================");
			System.out.println("	Ask For Bid");
			System.out.println("==============================");
			game.askToPlaceBid();
			System.out.println("==============================");
			System.out.println("	Drawing Cards");
			System.out.println("==============================");
			game.drawCardsToHand();
			System.out.println("==============================");
			System.out.println("	Take Action");
			System.out.println("==============================");
			game.askToPlay();
			System.out.println("==============================");
			System.out.println("	Dealer Play");
			System.out.println("==============================");
			game.dealerPlay();
			System.out.println("==============================");
			System.out.println("	Final Balance");
			System.out.println("==============================");
			game.compareHands(); // Temporary
			game=null;
		}
	}
}
