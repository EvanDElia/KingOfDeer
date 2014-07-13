package TheGame.Levels;

import TheGame.Entity.Mob.Mob;
import TheGame.Graphics.Screen;
import TheGame.Levels.tiles.Tile;

public class SpawnLevel extends Level {
	
	private boolean[] fires = {false, false, false};
	
	public SpawnLevel (String path, Screen s){
		super(path, s);
	}
	
	protected void generateLevel(){
	}
	
	public Tile getTile(int x, int y){
		Tile temp = super.getTile(x, y);
		if (temp.equals(Tile.fire)){
			if (y == 4 && fires[0]) return Tile.fire_purple;
			else if (y == 8 && fires[1]) return Tile.fire_purple;
			else if (y == 12 && fires[2]) return Tile.fire_purple;
		}
		return temp;
	}
	
	public void render(int xScroll, int yScroll, Screen screen){
		super.render(xScroll, yScroll, screen);
		
		if (fires[0] && fires[1] && fires[2]){
			Mob.deer.bossBattle();
		}
	}
	
	public void setTrue(int i){
		fires[i] = true;
	}
	
}
