package com.imooc.pokerGame;

public class PokerGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Poker poker = new Poker();
		poker.creatPoker();*/
		
		PokerAction pa = new PokerAction();
		pa.OrganizePokerGame();
		pa.addPlayers();
		pa.sendCards();
		pa.comparePoker();
	}
}
