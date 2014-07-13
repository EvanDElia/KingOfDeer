package TheGame.Entity.Mob;

import java.util.Random;

import TheGame.Game;
import TheGame.Graphics.Sprite;
import TheGame.Levels.Level;

public class Enemy extends Mob{
	protected int counter;
	private Level level;
	protected Random r = new Random();
	
	public Enemy(int x, int y, Sprite sprite, Level l) {
		this.x = x;
		this.y = y;
		setSprite(sprite);
		health = 3;
		level = l;
		counter = r.nextInt(139);
	}
	
	public void update(){
		if (anim < 6000) anim++; else anim = 0;
		
		if (Game.getPlayer().getX() - (x + 7) < 60 && Math.abs(Game.getPlayer().getY() - y) < 50){
			if (Game.getPlayer().getX() > x && !collision(1,0)) move(1,0);
			//else if (!collision(-1,0)) move(-1,0);
		}
		
		if (counter < 70 && !collision(0,1)) move(0,1);
		else if (!collision(0,-1)) move(0,-1);
		if (counter == 139) counter = 0;
		counter++;
		
		if (collision(0, 0) && vulnerable) hurt();
	}
	
	private boolean collision(int xa, int ya) {
		for (int i = 0; i < getXPoints().length; i++){
			for (int j = 0; j < getYPoints().length; j++){
				if (level.getTile((getXPoints()[i] + xa) >> 4,(getYPoints()[j] + ya) >> 4).isSolid())
					return true;
				if (Math.abs(Game.getPlayer().getX() - x) < 10 && Math.abs(Game.getPlayer().getY() - y) < 10)
					return true;
			}
		}
		return false;
	}

	public void render(){
		if (dir == 0){
			sprite = Sprite.turban_up_1;
				if (anim % 20 < 10){
					sprite = Sprite.turban_up_2;
				}
				else{
					sprite =Sprite.turban_up_3;
				}
		}
		if (dir == 2){
			sprite = Sprite.turban;
				if (anim % 20 < 10){
					sprite = Sprite.turban_down_1;
				}
				else{
					sprite =Sprite.turban_down_2;
				}
		}

	}
	
	public void move(int xa, int ya){
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
		if (anim % 2 == 0){
			x += xa;
			y += ya;
		}
	}
	
	public int[] getXPoints(){
		return new int[]{x + 7, x + 16};
	}
	
	public int[] getYPoints(){
		return new int[]{y, y + 7, y + 16, y + 24};
	}
}
