package com.hsm;

import java.util.ArrayList;
import java.util.Random;

public class Dealer {

	public static void main(String[] args) {
		ArrayList<String> newCards = getNewCards();
		//生成四个玩家
		Player player1 = new Player("Player_1");
		Player player2 = new Player("Player_2");
		Player player3 = new Player("Player_3");
		Player player4 = new Player("Player_4");
		Random ran = new Random();
		int CardsCount = 52;
		Player[] players = {player1,player2,player3,player4};
		//开始随机发牌
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
		//扑克牌的花色：方块、梅花、红桃、黑桃
		String[] suit = {"Diamond","Club","Heart","Spade"};
		ArrayList<String> newCards = new ArrayList<>(52);
		//构建一副新牌
		for(int j = 0;j < 4;j++){
			for(int i = 0;i < 13;i++){
				newCards.add(points[i]+"_"+suit[j]);
			}
		}
		return newCards;
	}
}
