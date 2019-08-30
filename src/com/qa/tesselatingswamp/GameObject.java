package com.qa.tesselatingswamp;

// Class for basic game object (Player)
public class GameObject {
	private int x;
	private int y;
	private String name;
	
	public int[] getXY() {
		int[] intArray = {x, y};
		return intArray;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
}
