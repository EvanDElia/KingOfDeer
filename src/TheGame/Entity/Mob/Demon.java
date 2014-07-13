package TheGame.Entity.Mob;

import TheGame.Graphics.Sprite;
import TheGame.Levels.Level;

public class Demon extends Enemy{

	public Demon(int x, int y, Sprite sprite, Level l) {
		super(x, y, sprite, l);
	}
	
	public void render(){
		if (dir == 0){
			sprite = Sprite.demon_up_1;
			if (anim % 30 < 10){
				sprite = Sprite.demon_up_1;
			}
			else if (anim % 30 < 20){
				sprite =Sprite.demon_up_2;
			}
			else{
				sprite = Sprite.demon_up_3;
			}
		}
		if (dir == 2){
			sprite = Sprite.demon;
			if (anim % 30 < 10){
				sprite = Sprite.demon_down_1;
			}
			else if (anim % 30 < 20){
				sprite =Sprite.demon;
			}
			else{
				sprite = Sprite.demon_down_2;
			}
		}
	}
	
}
