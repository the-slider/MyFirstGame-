package com.mikekunits;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

	private Player player;
	private boolean[] keys;

	

	public KeyboardInput(Player player) {
		this.player = player;
		keys = new boolean[4];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
	
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		
		if (key == KeyEvent.VK_ESCAPE) {
				System.exit(0);
		}
		
		if (key == KeyEvent.VK_UP && !keys[0]){
			player.setVelY(-12);
			keys[0]= true;
		}
		
		if (key == KeyEvent.VK_DOWN && !keys[1]){
			player.setVelY(12);
			keys[1]= true;
		}	
		
		if (key == KeyEvent.VK_RIGHT && !keys[2]){
			player.setVelX(12);
			keys[2]= true;
		}
		
		if (key == KeyEvent.VK_LEFT && !keys[3]){
			player.setVelX(-12);
			keys[3]= true;	
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		
		if (key == KeyEvent.VK_UP && keys[0]){
			player.setVelY(0);
			keys[0]= false;
		}
		
		if (key == KeyEvent.VK_DOWN && keys[1]){
			player.setVelY(0);
			keys[1]= false;
		}	
		
		if (key == KeyEvent.VK_RIGHT && keys[2]){
			player.setVelX(0);
			keys[2]= false;
		}
		
		if (key == KeyEvent.VK_LEFT && keys[3]){
			player.setVelX(0);
			keys[3]= false;	
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
