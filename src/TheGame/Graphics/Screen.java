package TheGame.Graphics;

import java.util.Random;
import TheGame.Levels.tiles.Tile;

/**
 * Programmer: Evan D'Elia
 * FileName: Screen.java
 * Created: Nov 13, 2012
 */

public class Screen {
	
	public int width;
	public int height;
	public int[] pixels;
	private Random random = new Random();
	private final int MAP_SIZE = 64;
	//private final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	public int xOffset, yOffset;
	
	public Screen(int w, int h){
		width = w;
		height = h;
		pixels = new int[width * height];
		
		for (int i = 0; i < tiles.length; i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear(){
		for (int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
	
	
	/*controls all movement in the game
	public void render(int xOffset, int yOffset){
		for (int y = 0; y < height; y++){
			int yp = y + yOffset;
			if (yp < 0 || yp >= height) continue;
			// FOR RANDOM COLORS  int yy = y + yOffset;
			//if (yy < 0 || yy >= height) break;
			for (int x = 0; x < width; x++){
				int xp = x + xOffset;
				if (xp < 0 || xp >= width) continue;
				// FOR RANDOM COLORS int xx = x + xOffset;
				//if (xx < 0 || xx >= width) break;
				// FOR RANDOM COLORS int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE; 
				// >> is a bit Operation meaning same as division except the 
				//number that follows it to the power of 2
				// & is also a bit wise operator that loops the screen 
				pixels[(xp) + (yp) * width] = Sprite.grass.pixels[(x&15) + (y&15) * Sprite.grass.SIZE];
			}
		}
	}
	*/
	
	public void renderTile(int xp, int yp, Tile tile){
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++){
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++){
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;

				if (xa < 0) xa = 0;
				int col = tile.sprite.pixels[x + y * tile.sprite.SIZE];
				if (col != 0xFFFF00FF){
					pixels[xa + ya * width] = col;
				}
			}
		}
	}
	
	public void renderMob(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 32; y++){
			int ya = y + yp;
			//int ys = y;
			for (int x = 0; x < 32; x++){
				int xa = x + xp;
				//int xs = 31 - x;
				//if sprite is being flipped you can use variables xs and ys and int flip with if statements
				if (xa < -32 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[x + y * 32];
				if (col != 0xFFFF00FF)
					pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void setOffset(int xOff, int yOff){
		xOffset = xOff;
		yOffset = yOff;
	}
}
