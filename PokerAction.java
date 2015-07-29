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
	
	//����������
	public void addPlayers(){
		for(int i = 0; i < 2; i++){
			try {
				System.out.println("�������" + (i+1) + "����ҵ�id��");
			} catch (Exception e) {
				System.out.println("id����Ϊ����");
			}
			String playerId = in.next();
			System.out.println("�������" + (i+1) + "����ҵ�������");
			String playerName = in.next();
			Player player = new Player(playerId,playerName);
			playerList.add(player);
		}
		System.out.println("��ӭ���");
		for (Player player : playerList) {
			System.out.print(player.getName() + "��");
		}
		System.out.println("������Ϸ��");
	}
	
	//���˿��ƴ���
	public void OrganizePokerGame(){
		System.out.println("******************��Ϸ��ʼ*******************");
		//�����˿���
		System.out.println("********��ʼ�����˿���*************");
		cardsList = poker.creatPoker();
		System.out.println("********�˿��ƴ����ɹ�*************");
		System.out.println("********��ʼϴ��....*************");
		//�����˿���˳��
		Collections.shuffle(cardsList);
		System.out.println("********ϴ����ɣ���ʼ�������***********");
	}
	
	//����ҷ���
	public void sendCards(){
		//ÿ����ҷ�������
		for(int j = 0; j < 2; j++){
			for (Player player : playerList) {
				System.out.println("    ���" + player.getName() + "���ƣ�");
				player.getHandCards().add(cardsList.get(0));
				//ÿ�η����ƶ�Ҫ�ѵ�һ���Ƴ��б�
				cardsList.remove(0);
			}
		}
		System.out.println("********���ƽ���********");
	}
	
	//�Ƚ�������ҵ���
	public void comparePoker(){
		List<Poker> maxPokerList = new ArrayList<Poker>();
		//��ȡ������ҵ�����,���Ѹ���ҵ�������Ʒ�������ļ�����
		for(Player player : playerList){
			List<Poker> handsPoker = player.getHandCards();
			//����
			Collections.sort(handsPoker);
			//��ȡ����ҵ��������
			Poker maxPoker = handsPoker.get(1);
			System.out.println("���" + player.getName() + "��������ƣ�" + maxPoker.getColor() +
					maxPoker.getNum());
			maxPokerList.add(maxPoker);
		}
		//��������Ҹ��Ե�������ƽ�������
		Collections.sort(maxPokerList);
		System.out.println("���" + playerList.get(0).getName() + "�����" + playerList.get(1).getName() + "�ϴ�������£�");
		for (Poker poker : maxPokerList) {
			System.out.println(poker.getColor() + poker.getNum());
		}
		System.out.println("�ϴ�������ǣ�" + maxPokerList.get(1).getColor() 
				+ maxPokerList.get(1).getNum());
		
		//������б����ж�����������������ҵģ��Ӷ��ж�������һ�ʤ
		for(Player player : playerList){
			if(player.getHandCards().contains(maxPokerList.get(1))){
				System.out.println("*******��Ϸ���������" + player.getId() + "-" 
						+ player.getName() + "��ʤ********");
			}
		}
		
		//��ӡ���������ҵ�������Ϣ
		for (Player player : playerList) {
			for(int i = 0; i<2;i++){
				System.out.println("���" + player.getName() + "�����ƣ�" 
						+ player.getHandCards().get(i).getColor() + player.getHandCards().get(i).getNum());
			}
		}
	}
	
	//�˿�����Ϣ
	public void printPoker(List<Poker> pokerList){
		for (Poker poker : pokerList) {
			System.out.println(poker.getColor() + poker.getNum());
		}
	}
}
