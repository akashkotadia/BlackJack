package actors;

import table.Game;

public class Dealer {

	String name;
	double balance;
	Game game;
	
	public Dealer(String name,double balance){
		this.name=name;
		this.balance=balance;
		game=new Game();
	}
	
	public Game getGame(){
		return game;
	}
}
