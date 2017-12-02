package com.mikekunits;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.mikekmain.Game;
import com.mikekmain.Mainwindow;

public class ChaosEnemy extends Gameobjects{

	private Game game;
	private Random random;
	
	public ChaosEnemy(int xBound, int yBound, float x, float y, float velx, float vely, int width, int height, Game game) {
		super(xBound, yBound, x, y, velx, vely, width, height);
		
		this.game = game;
		random = new Random();
		
		
	}

	@Override
	public void update() {
		x += velx;
		y += vely;
		
		if (x > Mainwindow.WIDTH - 16) {
			velx *= -1 * (random.nextInt(5) + 5);
		}
		
		if ( x < 0) {
			velx *= -1;
			velx *= (random.nextInt(5) + 5);
		}
		
		if (y > Mainwindow.HEIGHT - 16) {
			vely *= -1 * (random.nextInt(5) + 5);
			
		}
		
		if ( y < 0) {
			vely *= -1;
			vely *= (random.nextInt(5) + 5);
		}
		
	}

	@Override
	public void render(Graphics graphics) {
		graphics.setColor(Color.BLUE);
		graphics.fillRect((int) x, (int) y, width, height);
		
	}

	

}
