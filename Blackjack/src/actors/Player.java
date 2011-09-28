package actors;


import java.util.ArrayList;
import java.util.HashMap;

import config.property;

import deck.Card;

import table.Game;


public class Player {

	String name;
	PlayerAccount account;
	ArrayList<Game> games;
	HashMap<Integer,Double> gameBetMap=new HashMap<Integer, Double>();
	
	boolean canPlay=false;
	
	public Player(String name,double balance){
		this.name=name;
		account=new PlayerAccount(balance);
		games=new ArrayList<Game>();
	}
	public void play(double bet){
		if(bet>=property.MINIMUMBET){
			addGame(bet);
			canPlay=true;
		}
		else
			System.out.println("Error : Minimum Bet Must");
	}
	public boolean canPlay(){
		return canPlay;
	}
	
	// Game
	public void addGame(double bet){
		Game game=new Game();
		games.add(game);
		gameBetMap.put(games.size()-1,bet);
		account.subtractAmount(bet);
	}
	public Game getGame(int index){
		return games.get(index);
	}
	public int getGameCount(){
		return games.size();
	}
	public Double getBet(int gameIndex){
		return gameBetMap.get(gameIndex);
	}
	// Account
	public PlayerAccount getAccount(){
		return account;
	}
	
	// Actions
	public void hit(int gameIndex,Card card){
		games.get(gameIndex).addCard(card);
	}
	public void doubleHit(int gameIndex,Card card){
		double bet=gameBetMap.get(gameIndex);
		account.subtractAmount(bet);
		gameBetMap.put(gameIndex,bet*2);
		hit(gameIndex,card);
	}
	public void stay(int gameIndex){
		games.get(gameIndex).doStay();
	}
	public void split(int gameIndex){
		if(games.get(gameIndex).isSplitabble()){
			Game game1=new Game();
			game1.addCard(games.get(gameIndex).getCard(0));
			Game game2=new Game();
			game2.addCard(games.get(gameIndex).getCard(1));
			
			double bet=gameBetMap.get(gameIndex);
			
			games.remove(gameIndex);
			gameBetMap.remove(gameIndex);
			
			games.add(game1);
			games.add(game2);
			account.subtractAmount(bet);
			gameBetMap.put(games.size()-1,bet);
			gameBetMap.put(games.size()-2,bet);
		}
		else{
			System.out.println("Error : Not Splittable");
		}
	}
}
