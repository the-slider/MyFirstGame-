package com.mikekmain;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Mainwindow extends Canvas{
	
	public final static int WIDTH = 500;
	public final static int HEIGHT = 500;

	public Mainwindow(String title, Game game) {
		
		// Starts\ the main window
		JFrame window = new JFrame("Arcade Game!");
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.add(game);
		game.start();
	
	}
	
	public static void main(String[] args) {
		// Start game panel
		new Game();
	
		
	}
	
}
