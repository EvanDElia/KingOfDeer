package TheGame.Entity.Mob;

import TheGame.Graphics.Sprite;
import TheGame.Levels.Level;

public class Blob extends Enemy{

	public Blob(int x, int y, Sprite sprite, Level l) {
		super(x, y, sprite, l);
	}
	
	public void render(){
		if (dir == 0){
			sprite = Sprite.blob;
				if (anim % 20 < 10){
					sprite = Sprite.blob_2;
				}
				else{
					sprite =Sprite.blob;
				}
		}
		if (dir == 2){
			sprite = Sprite.blob;
				if (anim % 20 < 10){
					sprite = Sprite.blob;
				}
				else{
					sprite =Sprite.blob_2;
				}
		}

	}

}
