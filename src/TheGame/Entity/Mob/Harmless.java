package TheGame.Entity.Mob;

import TheGame.Graphics.Sprite;

public class Harmless extends Mob{
	
	public Harmless(int i, int j, Sprite sprite) {
		x = i;
		y = j;
		setSprite(sprite);
		health = 10;
	}
	
	public void hurt(){
		super.hurt();
		if (health % 2 != 0)
			setSprite(Sprite.deer_2);
		else
			setSprite(Sprite.deer);
	}
	
	public int[] getXPoints(){
		return new int[]{x, x + 7, x + 16, x + 24, x + 31};
	}
	
	public int[] getYPoints(){
		return new int[]{y, y + 7, y + 16, y + 24};
	}
}
