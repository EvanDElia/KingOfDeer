package TheGame.Input;

import TheGame.Entity.Mob.Player;
import TheGame.Graphics.Sprite;

public class FireThread extends Thread{
	private Player p;
	private long count = 0;
	
	public FireThread(){
		p = null;
	}
	
	public FireThread(Player x){
		p = x;
	}
	
	public void run(){
		long start = System.currentTimeMillis();
		int dir = p.getDir();
		while (count < 300){
			count = System.currentTimeMillis() - start;
			if (dir == 0){
				if (count < 100){
					p.setSprite(Sprite.player_left_sword_1);
				}
				else if (count < 200){
					p.setSprite(Sprite.player_left_sword_2);
				}
				else{
					p.setSprite(Sprite.player_left_sword_3);
				}
			}
			if (dir == 2){
				if (count < 100){
					p.setSprite(Sprite.player_right_sword_1);
				}
				else if (count < 200){
					p.setSprite(Sprite.player_right_sword_2);
				}
				else{
					p.setSprite(Sprite.player_right_sword_3);
				}
			}
			if (dir == 3){
				if (count < 100){
					p.setSprite(Sprite.player_left_sword_1);
				}
				else if (count < 200){
					p.setSprite(Sprite.player_left_sword_2);
				}
				else{
					p.setSprite(Sprite.player_left_sword_3);
				}
			}
			if (dir == 1){
				if (count < 100){
					p.setSprite(Sprite.player_right_sword_1);
				}
				else if (count < 200){
					p.setSprite(Sprite.player_right_sword_2);
				}
				else{
					p.setSprite(Sprite.player_right_sword_3);
				}
			}
		}
		p.setFire();
	}
}
