package com.qa.tesselatingswamp;

//Class that deals with translating information from the player
public class ChoiceInterpreter {
	
	public int[] stringToDirection(String instruction){
		instruction = instruction.toLowerCase();
		int[] result = {0, 0};
		switch(instruction) {
		case "north": // up
			result[1] = 1;
			break;
		case "south": // down
			result[1] = -1;
			break;
		case "east":
			result[0] = 1;
			break;
		case "west":
			result[0] = -1;
			break;
		}
		return result;
	}
	
	
}
