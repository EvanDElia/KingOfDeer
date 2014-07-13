package TheGame.Entity.Mob;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import TheGame.Graphics.Screen;
import TheGame.Graphics.Sprite;
import TheGame.Input.FireThread;
import TheGame.Input.Keyboard;
import TheGame.Levels.Level;
import TheGame.Levels.tiles.Tile;

public class Player extends Mob{
	
	private Keyboard input;
	private boolean walking = false;
	private FireThread fire;
	private boolean firing = false;
	private Level level;
	private boolean hurt = false;
	private int hurt_counter;
	private int k, l;
	
	
	public Player(Keyboard in){
		input = in;
		health = 3;
	}
	
	public Player(int x, int y, Keyboard in, Level l){
		this.x = x;
		this.y = y;
		input = in;
		health = 3;
		level = l;
	}
	
	public void hurt(){
		health--;
		hurt = true;
		hurt_counter = 0;
	}
	
	public void hurt(int i, int j){
		health--;
		hurt = true;
		hurt_counter = 0;
		k = i;
		l = j;
	}
	
	public void update(){
		if (input.suicide) health = 0;
		
		int xa = 0, ya = 0;
		if (anim < 6000) anim++; else anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (!firing && !hurt){
			if (xa != 0 || ya !=0) walking = true;
			else walking = false;
			if (xa != 0 && ya != 0){
				if (!collision(xa, 0)) move(xa, 0);
				if (!collision(0, ya)) move(0, ya);
			}
			else if (!collision(xa, ya)) move(xa, ya);
		}
		
		
		if (hurt){
			if (k > 2 && !collision(1, 0)) x++;
			else if (!collision(-1, 0)) x--;
			if (l <= 3 && !collision(0, -1))y--;
			else if (!collision(0, 1)) y++;
			hurt_counter++;
			if (hurt_counter == 40) hurt = false;
		}
		
		int[] x1 = level.getBadX();
		int[] y1 = level.getBadY();
		
		if (input.interact){
			for (int i = 0; i < x1.length; i++){
				for (int j = 0; j < y1.length; j++){
					if (x1[i] == x >> 4 && y1[j] == y >> 4){
						level.changePath((y >> 4) / 4 - 1);
						String path = level.getPath();
						if (path.equals(Level.paths[3])){
							x = 16 * 8;
							y = 16 * 4;
						}
						else if (path.equals(Level.paths[0])){
							x = 16 * 12;
							y = 16 * 23;
						}
						else if (path.equals(Level.paths[1])){
							x = 16 * 5;
							y = 16 * 5;
						}
						else if (path.equals(Level.paths[2])){
							x = 16 * 12;
							y = 16 * 12;
						}
					}		
				}
			}
		}
		
		if (firing){
			for (int i = 0; i < level.getMobs().size(); i++){
				level.getMobs().get(i).allowHurt();
			}
			if (getDir() == 3){
				if ((collision(-4, 0) || collision(-5, 0)) && level.getMobs().size() > 0){
					setFire();
				}
			}
			else if (getDir() == 1)
				if ((collision(3, 0) || collision(2, 0)) && level.getMobs().size() > 0){
					setFire();
				}
		}
	}
	
	public void render(Screen screen){
		if (input.fire && !firing) fire();
		else if (!firing && !hurt){
		if (dir == 0){
			sprite = Sprite.player_up;
			if (walking){
				if (anim % 20 < 10){
					sprite = Sprite.player_up_1;
				}
				else{
					sprite =Sprite.player_up_2;
				}
			}
		}
		if (dir == 2){
			sprite = Sprite.player_down;
			if (walking){
				if (anim % 20 < 10){
					sprite = Sprite.player_down_1;
				}
				else{
					sprite =Sprite.player_down_2;
				}
			}
		}
		if (dir == 3){
			sprite = Sprite.player_left;
			if (walking){
				if (anim % 30 < 10){
					sprite = Sprite.player_left_1;
				}
				else if (anim % 30 < 20){
					sprite = Sprite.player_left;
				}
				else{
					sprite =Sprite.player_left_2;
				}
			}
		}
		if (dir == 1){
			sprite = Sprite.player_right;
			if (walking){
				if (anim % 30 < 10){
					sprite = Sprite.player_right_1;
				}
				else if (anim % 30 < 20){
					sprite = Sprite.player_right;
				}
				else{
					sprite =Sprite.player_right_2;
				}
			}
		}
		}
		else if (hurt){
			if (hurt_counter % 5 > 1){
				sprite = Sprite.player_hurt;
			}
			else sprite = Sprite.player_down;
		}
		
		screen.renderMob(x - 16, y - 16, sprite);

		/*
		screen.renderPlayer(xx, yy, Sprite.player0);
		screen.renderPlayer(xx + 16, yy, Sprite.player1);
		screen.renderPlayer(xx, yy + 16, Sprite.player2);
		screen.renderPlayer(xx + 16, yy + 16, Sprite.player3);
		*/

		
	}
	
	
	public boolean collision(int xa, int ya){
		//I am calling this system of hit detection....point intersection
		int[] XPoints = {x, x + 5, x + 10, x - 5, x - 10,};
		int[] YPoints = {y, y + 5, y + 10,  y + 15, y - 5, y - 10};
		//these arrays create a total of 9 points around the player if any of these points hits a solid tile the method returns true!!!!
		for (int i = 0; i < XPoints.length; i++){
			for (int j = 0; j < YPoints.length; j++){
				if (level.getTile((XPoints[i] + xa) >> 4,(YPoints[j] + ya) >> 4).isSolid())
					return true;
				ArrayList<Mob> mobs = level.getMobs();
				if (mobs != null){
					for (int c = 0; c < mobs.size(); c++){
						int[] MobX = mobs.get(c).getXPoints();
						int[] MobY = mobs.get(c).getYPoints();
						for (int m = 0; m < MobX.length; m++){
							for (int n = 0; n < MobY.length; n++){
								if (mobs.get(c).getHealth() > 0 && (MobX[m] >> 2 == (XPoints[i] + xa) >> 2 && MobY[n] >> 2 == (YPoints[j] + ya) >> 2))
								{	
									if ((xa < 2 && xa > -2 && ya > -2 && ya < 2) && mobs.get(c) instanceof Enemy){
										if (!hurt) hurt(i, j);
									}
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public void fire(){
		/*if (dir == 1){
			if (anim % 30 < 10) sprite = Sprite.player_right_shotgun_1;
			else if (anim % 30 < 20 ) sprite = Sprite.player_right_shotgun_2;
			else sprite = Sprite.player_right_shotgun_3;
		}
		else if (dir == 3){
			if (anim % 30 < 10) sprite = Sprite.player_left_shotgun_1;
			else if (anim % 30 < 20 ) sprite = Sprite.player_left_shotgun_2;
			else sprite = Sprite.player_left_shotgun_3;
		}
		*/
		firing = true;
		fire = new FireThread(this);
		fire.start();
		AudioClip a = null;
		try{
			a = Applet.newAudioClip(new URL("file:/Users/Evan/Music/Game Sound Effects/Damage_1.wav"));
		} catch (IOException e){
			e.printStackTrace();
		}
		
		a.play();
	}
	
	public void setFire(){
		firing = false;
	}

	public void displayHealth(Screen screen) {
		if (health <= 0) screen.renderTile((x - screen.width/2) + 4  * 16, y - screen.height/2, Tile.GameOver);

		for (int i = 0; i < health; i++){
			screen.renderTile((x - screen.width/2) + i * 16, y - screen.height/2, Tile.health);	
		}
		for (int i = 3; i > health; i--){
			screen.renderTile((x - screen.width/2) + (i - 1) * 16, y - screen.height/2, Tile.health_empty);

		}
	}
	
	public int[] getXPoints(){
		return new int[]{x, x + 5, x + 10, x - 5, x - 10,};
	}
	
	public int[] getYPoints(){
		return new int[]{y, y + 5, y + 10,  y + 15, y - 5, y - 10};
	}
	
}
