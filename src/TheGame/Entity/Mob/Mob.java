package TheGame.Entity.Mob;

import TheGame.Entity.Entity;
import TheGame.Graphics.Sprite;

public abstract class Mob extends Entity{
	
	public static Mob deer = new Harmless(4 * 16, 8 * 16, Sprite.deer);
	
	protected Sprite sprite;
	protected int anim;
	protected int dir = 0;
	protected boolean moving = false;
	protected int health;
	protected boolean vulnerable = true;
	
	public void move(int xa, int ya){
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
		
		x += xa;
		y += ya;
	}
	
	
	public Sprite getSprite(){
		return sprite;
	}
	
	public void update(){
		
	}
	
	public boolean isSolid(){
		return true;
	}
	
	public void render(){
		
	}
	
	public void setSprite(Sprite s){
		sprite = s;
	}
	
	public int getDir(){
		return dir;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void hurt(){
		if (vulnerable) health--;
		vulnerable = false;
	}

	public int[] getXPoints(){
		return new int[]{x};
	}
	
	public int[] getYPoints(){
		return new int[]{y};
	}

	public void allowHurt() {
		vulnerable = true;
	}


	public void bossBattle() {
		
	}
}
