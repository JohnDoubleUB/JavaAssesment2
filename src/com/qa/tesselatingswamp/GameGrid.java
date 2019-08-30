package com.qa.tesselatingswamp;

public class GameGrid {
	private int gridX;
	private int gridY;
	
	public boolean setXY(int xy) {
		if (xy > 1) {
			gridX = xy;
			gridY = xy;
			return true;
		}
		return false;
	}
	
	
	public int getGridX() {
		return gridX;
	}
	
	public int getGridY() {
		return gridY;
	}
	
	
	
	
	public void setGridX(int gridX) {
		this.gridX = gridX;
	}
	
	public void setGridY(int gridY) {
		this.gridY = gridY;
	}
}
