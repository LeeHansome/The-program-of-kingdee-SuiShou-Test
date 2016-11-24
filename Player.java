package com.hsm;

import java.util.ArrayList;

public class Player {
	//玩家手中持有的牌
	private ArrayList<String> poker = new ArrayList<String>(13);
	private String playerName;
	
	public Player(String name){
		this.playerName = name;
	}
	
	public void showPoker(){
		System.out.print(playerName+"'s poker is:");
		for(String p : poker)
			System.out.print(p + " ");
		System.out.println();
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public ArrayList<String> getPoker() {
		return poker;
	}

	public void setPoker(ArrayList<String> poker) {
		this.poker = poker;
	}
	
}
