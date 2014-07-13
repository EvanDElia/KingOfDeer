package TheGame.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Programmer: Evan D'Elia
 * FileName: Keyboard.java
 * Created: Nov 20, 2012
 */

public class Keyboard implements KeyListener{

	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right;
	public boolean fire, interact, mute, play, suicide;
	
	public void update(){
		//movement
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		
		//fire
		fire = keys[KeyEvent.VK_SPACE];
		
		//interaction button
		interact = keys[KeyEvent.VK_T];
		
		//mute & play
		mute = keys[KeyEvent.VK_M];
		play = keys[KeyEvent.VK_N];
		
		//suicide
		suicide = keys[KeyEvent.VK_Z];

	}
	
	public void keyPressed(KeyEvent e) {
		if (!fire)
			keys[e.getKeyCode()] = true;
	}

	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	
	public void keyTyped(KeyEvent e) {
		
	}
}
