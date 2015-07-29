package com.imooc.pokerGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PokerAction {

	private Poker poker;
	
	private List<Poker> cardsList;
	private List<Player> playerList;
	
	private Scanner in;
	
	public PokerAction(){
		poker = new Poker();
		playerList = new ArrayList<Player>();
		in = new Scanner(System.in);
	}
	
	//添加两名玩家
	public void addPlayers(){
		for(int i = 0; i < 2; i++){
			try {
				System.out.println("请输入第" + (i+1) + "名玩家的id：");
			} catch (Exception e) {
				System.out.println("id必须为数字");
			}
			String playerId = in.next();
			System.out.println("请输入第" + (i+1) + "名玩家的姓名：");
			String playerName = in.next();
			Player player = new Player(playerId,playerName);
			playerList.add(player);
		}
		System.out.println("欢迎玩家");
		for (Player player : playerList) {
			System.out.print(player.getName() + "、");
		}
		System.out.println("进入游戏！");
	}
	
	//把扑克牌打乱
	public void OrganizePokerGame(){
		System.out.println("******************游戏开始*******************");
		//创建扑克牌
		System.out.println("********开始创建扑克牌*************");
		cardsList = poker.creatPoker();
		System.out.println("********扑克牌创建成功*************");
		System.out.println("********开始洗牌....*************");
		//打乱扑克牌顺序
		Collections.shuffle(cardsList);
		System.out.println("********洗牌完成，开始创建玩家***********");
	}
	
	//给玩家发牌
	public void sendCards(){
		//每名玩家发两张牌
		for(int j = 0; j < 2; j++){
			for (Player player : playerList) {
				System.out.println("    玩家" + player.getName() + "拿牌！");
				player.getHandCards().add(cardsList.get(0));
				//每次发完牌都要把第一张移出列表
				cardsList.remove(0);
			}
		}
		System.out.println("********发牌结束********");
	}
	
	//比较两名玩家的牌
	public void comparePoker(){
		List<Poker> maxPokerList = new ArrayList<Poker>();
		//获取两名玩家的手牌,并把各玩家的最大手牌放在另外的集合中
		for(Player player : playerList){
			List<Poker> handsPoker = player.getHandCards();
			//排序
			Collections.sort(handsPoker);
			//获取各玩家的最大手牌
			Poker maxPoker = handsPoker.get(1);
			System.out.println("玩家" + player.getName() + "的最大手牌：" + maxPoker.getColor() +
					maxPoker.getNum());
			maxPokerList.add(maxPoker);
		}
		//对两名玩家各自的最大手牌进行排序
		Collections.sort(maxPokerList);
		System.out.println("玩家" + playerList.get(0).getName() + "和玩家" + playerList.get(1).getName() + "较大的牌如下：");
		for (Poker poker : maxPokerList) {
			System.out.println(poker.getColor() + poker.getNum());
		}
		System.out.println("较大的手牌是：" + maxPokerList.get(1).getColor() 
				+ maxPokerList.get(1).getNum());
		
		//从玩家列表中判断最大的手牌是哪名玩家的，从而判断哪名玩家获胜
		for(Player player : playerList){
			if(player.getHandCards().contains(maxPokerList.get(1))){
				System.out.println("*******游戏结束，玩家" + player.getId() + "-" 
						+ player.getName() + "获胜********");
			}
		}
		
		//打印输出两名玩家的手牌信息
		for (Player player : playerList) {
			for(int i = 0; i<2;i++){
				System.out.println("玩家" + player.getName() + "的手牌：" 
						+ player.getHandCards().get(i).getColor() + player.getHandCards().get(i).getNum());
			}
		}
	}
	
	//扑克牌信息
	public void printPoker(List<Poker> pokerList){
		for (Poker poker : pokerList) {
			System.out.println(poker.getColor() + poker.getNum());
		}
	}
}
