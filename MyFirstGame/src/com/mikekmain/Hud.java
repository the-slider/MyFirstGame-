package com.mikekmain;

import java.awt.Color;
import java.awt.Graphics;

public class Hud {

	private Game game;
	public static int HealthPoints;
	public static int Damage;
	private Color color;
	
	public Hud(Game game) {
		this.game = game;
		// initializing health and damage
		
		HealthPoints = 5;
		Damage = 1;
	}
	
	public void update () {
		
	}
	
	public void render (Graphics graphics) {
	
		// Set Color
		if(HealthPoints >= 3 || HealthPoints <= 5) {
			color = Color.GREEN;
		}
		else if(HealthPoints == 2) {
			color = Color.YELLOW;
		}
		else {
			color = Color.RED;
		}
		
		// Draw Bar
		graphics.setColor(color);
		graphics.fillRect(2, 2, HealthPoints * 30, 15);
		}
	
	
}
