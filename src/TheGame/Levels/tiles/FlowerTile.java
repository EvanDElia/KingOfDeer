package TheGame.Levels.tiles;

import TheGame.Graphics.Screen;
import TheGame.Graphics.Sprite;

public class FlowerTile extends Tile {

	public FlowerTile(Sprite sp) {
		super(sp);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}

}
