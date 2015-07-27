package com.imooc.pokerGame;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String id;
	private String name;
	
	private List<Poker> handCards;

	public Player(String id, String name) {
		this.id = id;
		this.name = name;
		this.handCards = new ArrayList<Poker>();
	}

	/**
	 * @return the handCards
	 */
	public List<Poker> getHandCards() {
		return handCards;
	}

	/**
	 * @param handCards the handCards to set
	 */
	public void setHandCards(List<Poker> handCards) {
		this.handCards = handCards;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
