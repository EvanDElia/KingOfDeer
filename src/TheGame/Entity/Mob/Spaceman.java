package TheGame.Entity.Mob;

import TheGame.Graphics.Sprite;
import TheGame.Levels.Level;

public class Spaceman extends Enemy{

	public Spaceman(int x, int y, Sprite sprite, Level l) {
		super(x, y, sprite, l);
	}
	
	public void render(){
		if (dir == 0){
			sprite = Sprite.spaceman_up_1;
			if (anim % 30 < 10){
				sprite = Sprite.spaceman_up_1;
			}
			else if (anim % 30 < 20){
				sprite =Sprite.spaceman_up_2;
			}
			else{
				sprite = Sprite.spaceman_up_3;
			}
		}
		if (dir == 2){
			sprite = Sprite.spaceman;
			if (anim % 30 < 10){
				sprite = Sprite.spaceman_down_1;
			}
			else if (anim % 30 < 20){
				sprite =Sprite.spaceman;
			}
			else{
				sprite = Sprite.spaceman_down_2;
			}
		}
	}

}
