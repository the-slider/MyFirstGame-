package com.mikekunits;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.mikekmain.Game;
import com.mikekmain.Hud;
import com.mikekmain.Mainwindow;

public class Player extends Gameobjects{

	private Game game;
	private BasicEnemy basicenemy;
	
	public Player(int xBound, int yBound, float x, float y, float velx, float vely, int width, int height, Game game, BasicEnemy basicenemy) {
		super(xBound, yBound, x, y, velx, vely, width, height);
		
		this.basicenemy = basicenemy;
		
	}

	@Override
	public void update() {
		x += velx;
		y += vely;
		
		if (x > Mainwindow.WIDTH - 32) {
			x = Mainwindow.WIDTH - 32;
		}
		
		if ( x < 0) {
			x = 0;
		}
		
		if (y > Mainwindow.HEIGHT - 54) {
			y = Mainwindow.HEIGHT - 54;
			
		}
		
		if ( y < 0) {
			y = 0;
		}
		//Collision Detection
		if (this.getBounds().intersects(basicenemy.getbounds())){
			Hud.HealthPoints -= Hud.Damage;		}
		
	}

	@Override
	public void render(Graphics graphics) {
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics.setColor(Color.BLACK);
		graphics.fillRect((int) x, (int) y, width, height);
		graphics2d.draw(getBounds());
		
	}

	public Rectangle getBounds() {
		return new Rectangle ((int) x, (int) y, 32, 32);
	}

}
