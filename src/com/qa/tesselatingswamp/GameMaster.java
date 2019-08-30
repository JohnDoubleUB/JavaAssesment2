package com.qa.tesselatingswamp;

import java.util.Scanner;

public class GameMaster extends ChoiceInterpreter{
	// This will contain all the logic for determining distance from the object, along with
	private GameGrid gameGrid = new GameGrid();
	private Player p1 = new Player();
	private GameObject rewardChest = new GameObject();
	private Scanner sc = new Scanner(System.in);
	
	
	public void intro() {
		System.out.println("You are surrounded by swamp on all sides,\n"
				+ "a wizard emerges right in front of you, waves his hand and your vision goes dark\n"
				+ "you feel a metal object be put into your hand, a voice, presumably the wizards speaks\n"
				+ "devilishly. 'In your hand is a magic compass, it will speak how close you are to a chest\n"
				+ "containing both your vision and your freedom!, find it and both will be returned to you\n"
				+ "fail and be blind and lost forever!'");
		
		System.out.println("\nWith a strong gust of wind, you sense that the wizard is gone, not far enough to not witness your plight, but far enough.");
	}
	
	
	// Getters
	public Player getP1() {
		return p1;
	}
	
	public GameObject getRewardChest() {
		return rewardChest;
	}
	
	
	//Generate locations!
	public void generatePlayerLocation() {
		do {
			p1.setX((int)(Math.random()*gameGrid.getGridX()));
			p1.setY((int)(Math.random()*gameGrid.getGridX()));
		} 
		while(locationMatch(p1.getXY(), rewardChest.getXY()));
	}
	
	
	
	public boolean isChestFound() {
		boolean result = (p1.getX() == rewardChest.getX()) && (p1.getY() == rewardChest.getY());
		if(result) {
			sc.close();
		}
		
		return result;
	}
	
	
	
	public void generateChestLocation() {
		do {
			rewardChest.setX((int)(Math.random()*gameGrid.getGridX()));
			rewardChest.setY((int)(Math.random()*gameGrid.getGridX()));
		} 
		while(locationMatch(p1.getXY(), rewardChest.getXY()));
	}
	
	public void playerPrompt() {
		boolean validResponse = false;
		
		double currentDistance = distanceFrom(p1.getXY(), rewardChest.getXY());
		
		while(!validResponse) {
			System.out.println("");
			System.out.println("You hear a voice from the Compass!\n");
			System.out.println("It says:");
			System.out.println("You are currently: " + currentDistance + " Away from the chest!");
			System.out.println("Please choose a direction: North, South, East or West!");
			
			String choice = sc.nextLine();
			
			validResponse = movePlayerBy(stringToDirection(choice));
		}
	}
	
	private boolean movePlayerBy(int[] movement) {
		if(movement[0] == movement[1]) {
			return false;
		}
		
		//If adding movement to x would cause the value to be greater than grid size
		if(p1.getX() + movement[0] > gameGrid.getGridX()) { // X is greater than max grid
			p1.setX(0);
		} else if (p1.getX() + movement[0] < 0) { // X is less than min grid
			p1.setX(gameGrid.getGridX());
		} else { // X is fine
			p1.setX(p1.getX()+movement[0]);
		}
		
		//If adding movement to y would cause the value to be greater than grid size
		if(p1.getY() + movement[1] > gameGrid.getGridY()) { // Y is greater than max grid
			p1.setY(0);
		} else if (p1.getY() + movement[1] < 0) { // Y is less than min grid
			p1.setY(gameGrid.getGridY());
		} else { // Y is fine
			p1.setY(p1.getY()+movement[1]);
		}
		return true;
	}
	
	public double distanceFrom(int[] item1, int[] item2) {
		//get distance x
		int xDistance = distance(item1[0], item2[0]);
		//get distance y
		int yDistance = distance(item1[1], item2[1]);
		
		//multiply each by itself
		xDistance = xDistance * xDistance;
		yDistance = yDistance * yDistance;
		
		return Math.sqrt((double)(xDistance + yDistance));
	}
	
	private int distance(int no1, int no2) {
		if(no1 >= no2) {
			return no1 - no2;
		} else {
			return no2 - no1;
		}
	}
	
	//Position Comparitor
	//Check if locations match!
	private boolean locationMatch(int[] item1, int[] item2) {
		if(item1[0] == item2[0] && item1[1] == item2[1]) {
			return true;
		}
		
		return false;
	}
	
	
	//Keep here
	//Set game grid
	public void setValidGameGrid() {
		
		//Make Scanner
		
		boolean sizeGiven = false;
		
		//Player is asked for grid size
		System.out.println("Please give a grid size!");
		
		//Size is checked
		while(!sizeGiven) {			
			String gridSize = sc.nextLine();
			
			try {
				//If its a valid grid then returns true!
				if(gameGrid.setXY(Integer.parseInt(gridSize))) {
					sizeGiven = true;
				} else {
					System.out.println("Please provide a larger grid size than 1!");
				}
				
				//Check if the grid makes any sense larger than 2
			} catch (NumberFormatException e) {
				System.out.println("Please provide a valid grid size!");
				}
		}
	}
}
