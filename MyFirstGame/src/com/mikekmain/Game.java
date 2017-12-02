package com.mikekmain;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.naming.ldap.ExtendedRequest;

import com.mikekunits.BasicEnemy;
import com.mikekunits.ChaosEnemy;
import com.mikekunits.KeyboardInput;
import com.mikekunits.Player;

public class Game extends Canvas implements Runnable {

	private Thread thread;
	private boolean running = false;
	private Player player;
	private BasicEnemy basicenemy;
	private ChaosEnemy chaosenemy;
	private Hud hud;

	public Game() {
		super();

		// Start Canvas
		setFocusable(true);
		requestFocus();
		setPreferredSize(new Dimension(Mainwindow.WIDTH, Mainwindow.HEIGHT));

		// Start the main window panel
		new Mainwindow("Arcade Game!", this);

		// Load all game elements
		init();
		
		addKeyListener(new KeyboardInput(player));
		requestFocus();

	}

	// Load Game Elements
	public void init() {
		
		basicenemy = new BasicEnemy(0, 0, 100, 100, 15, 15, 16, 16, this);
		player = new Player(0, 0, 150, 150, 0, 0, 32, 32,this, basicenemy);
		chaosenemy = new ChaosEnemy(0, 0, 100, 100, 15, 15, 16, 16, this);
		hud = new Hud(this); 
	}

	// Thread stuff
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	public void run() {
		// Variables to keep track of time
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;

		// Main Loop
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			// Updates
			while (delta >= 1) {
				update();
				delta--;
			}

			// Optimize Game Loop
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Draw all objects to the screen
			render();

			// Update FPS + Print FPS
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}

		}

		// Engine Stop
		stop();
	}

	// Update + Render
	public void update() {
		player.update();
		basicenemy.update();
		chaosenemy.update();
		hud.update();
	}

	public void render() {
		// Start Graphics
		BufferStrategy bStrategy = this.getBufferStrategy();
		if (bStrategy == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics graphics = bStrategy.getDrawGraphics();
		// Set Background
		graphics.setColor(Color.YELLOW);

		graphics.fillRect(0, 0, Mainwindow.WIDTH, Mainwindow.HEIGHT);
		
		//Draw player
		player.render(graphics);
		basicenemy.render(graphics);
		chaosenemy.render(graphics);
		hud.render(graphics);
		
		graphics.dispose();
		bStrategy.show();

	}

}
