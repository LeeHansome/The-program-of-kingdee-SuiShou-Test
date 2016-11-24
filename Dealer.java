package com.hsm;

import java.util.ArrayList;
import java.util.Random;

public class Dealer {

	public static void main(String[] args) {
		ArrayList<String> newCards = getNewCards();
		//�����ĸ����
		Player player1 = new Player("Player_1");
		Player player2 = new Player("Player_2");
		Player player3 = new Player("Player_3");
		Player player4 = new Player("Player_4");
		Random ran = new Random();
		int CardsCount = 52;
		Player[] players = {player1,player2,player3,player4};
		//��ʼ�������
		for(int i = 0; i < 52;i++){
			int pos = i % 4;
			int cardsIndex = ran.nextInt(CardsCount--);
			players[pos].getPoker().add(newCards.remove(cardsIndex));
		}
		for(Player player : players){
			player.showPoker();
		}

	}
	
	public static ArrayList<String> getNewCards(){
		String[] points = {"A","2","3","4","5","6","7","8","9","10","j","Q","K"};
		//�˿��ƵĻ�ɫ�����顢÷�������ҡ�����
		String[] suit = {"Diamond","Club","Heart","Spade"};
		ArrayList<String> newCards = new ArrayList<>(52);
		//����һ������
		for(int j = 0;j < 4;j++){
			for(int i = 0;i < 13;i++){
				newCards.add(points[i]+"_"+suit[j]);
			}
		}
		return newCards;
	}
}
