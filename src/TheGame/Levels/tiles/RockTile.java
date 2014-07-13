package TheGame.Levels.tiles;

import TheGame.Graphics.Screen;
import TheGame.Graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sp) {
		super(sp);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean isSolid(){
		return true;
	}

}
