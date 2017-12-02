package com.mikekunits;

import java.awt.Graphics;

public abstract class Gameobjects {

	protected int xBound, yBound;
	protected float x, y;
	protected float velx, vely;
	protected int width, height;
	
	public Gameobjects(int xBound, int yBound, float x, float y, float velx, float vely, int width, int height) {
		this.xBound = xBound;
		this.yBound = yBound;
		this.x = x;
		this.y = y;
		this.velx = velx;
		this.vely = vely;
		this.width = width;
		this.height = height;
		
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	public void setVelX(float velx) {
		this.velx = velx;
	}
	public void setVelY(float vely){
		this.vely = vely;
	}
	
	
	
}
