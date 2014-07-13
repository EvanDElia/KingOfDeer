package TheGame.Levels.tiles;

import TheGame.Graphics.Screen;
import TheGame.Graphics.Sprite;

public class WallTile extends Tile {
	
	public WallTile(Sprite sp) {
		super(sp);
	}
	
	public void render(int x, int y, Screen screen){
		super.render(x, y, screen);
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean isSolid(){
		return true;
	}
}
