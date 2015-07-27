package com.imooc.pokerGame;

import java.util.ArrayList;
import java.util.List;

public class Poker implements Comparable<Poker>{

	private static String[] colors ={"����","����","÷��","��Ƭ"};
	private static String[] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	private String num;
	private String color;
	
	private String card;//ÿ������

	private List<Poker> pokerList;
	public Poker(){
		pokerList = new ArrayList<Poker>();
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public List<Poker> getPokerList() {
		return pokerList;
	}
	
	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Poker)) {
			return false;
		}
		Poker other = (Poker) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (num == null) {
			if (other.num != null) {
				return false;
			}
		} else if (!num.equals(other.num)) {
			return false;
		}
		return true;
	}

	//����һ���˿���
	public List<Poker> creatPoker(){
		for (String color : colors) {
			for (String number : numbers) {
				String tmp = card + number;
				Poker poker = new Poker();
				poker.setColor(color);
				poker.setNum(number);
//				poker.setCard(tmp);
				pokerList.add(poker);
			}
		}
		return pokerList;
	}

	public int compareTo(Poker otherPoker) {
		String pokerNum = "3,4,5,6,7,8,9,10,J,Q,K,A,2";
		String pokerColor = "��Ƭ,÷��,����,����";
		int result;
		result = pokerNum.indexOf(this.getNum()) - pokerNum.indexOf(otherPoker.getNum());
		//����������Ƶ�������ͬ����Ƚϻ�ɫ
		if(result == 0){
			result = pokerColor.indexOf(this.getColor()) - pokerColor.indexOf(otherPoker.getColor());
		}
		return result;
	}
}
