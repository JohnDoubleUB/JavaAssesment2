package com.qa.tesselatingswamp;


public class App {
	public static void main(String[] args) {
		GameMaster gm = new GameMaster();
		
		//Set a valid grid size
		gm.setValidGameGrid();
		
		//Randomly generate player position
//		System.out.println((int)(Math.random()*100));
//		System.out.println((int)(Math.random()*100));
		
		//Generate player and Chest locations
		gm.generatePlayerLocation();
		gm.generateChestLocation();
		
		
		
		//Randomly generate chest position
		//int[] test1 = {1, 3};
		//int[] test2 = {3, 4};
		
		
		
		//System.out.println(gm.distanceFrom(test1, test2));
		
		//System.out.println(gm.distance(2, 4));
		
		//Intro to the game
		gm.intro();
		
		
		//Main game loop!
		do {
			//Prompt player for input
			gm.playerPrompt();
			
			if(gm.isChestFound()) {
				System.out.println("You found the chest! You are free!");
			}
		} while(!gm.isChestFound());
		
		System.out.println("Game has ended!");
		
		//Check if the player is on the chest!
		
		
		// Player is given brief
	}
	
	
	
}
