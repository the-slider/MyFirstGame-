package com.mikekunits;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.mikekmain.Game;
import com.mikekmain.Mainwindow;

public class BasicEnemy extends Gameobjects{

	private Game game;
	
	public BasicEnemy(int xBound, int yBound, float x, float y, float velx, float vely, int width, int height, Game game) {
		super(xBound, yBound, x, y, velx, vely, width, height);
		
	}

	@Override
	public void update() {
		x += velx;
		y += vely;
		
		if (x > Mainwindow.WIDTH - 16) {
			velx *= -1;
		}
		
		if ( x < 0) {
			velx *= -1;
		}
		
		if (y > Mainwindow.HEIGHT - 16) {
			vely *= -1;
			
		}
		
		if ( y < 0) {
			vely *= -1;
		}
		
	}

	@Override
	public void render(Graphics graphics) {
		
		Graphics2D graphics2d = (Graphics2D) graphics;
		
		graphics.setColor(Color.RED);
		graphics.fillRect((int) x, (int) y, width, height);
		graphics2d.draw(getbounds());
	}
	
	public Rectangle getbounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}
	
	

	

}
