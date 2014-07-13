package TheGame.Levels.tiles;

import TheGame.Graphics.Screen;
import TheGame.Graphics.Sprite;

public class GrassTile extends Tile{
	
	public GrassTile(Sprite sprite){
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean isSolid(){
		return false;
	}
	
}
