package table;

import java.io.IOException;

public class HelloBJ {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BJTable bj=new BJTable(2);
		bj.addPlayer(0, "Akash", 5000.0);
		bj.addPlayer(1, "Darshan", 4000.0);
		bj.askToBet();
		bj.drawCards();
		bj.askDecision();
		bj.dealerPlay();
		bj.WinOrLose();
	}
}
