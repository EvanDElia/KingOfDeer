package TheGame.Levels;

import java.util.Random;

public class RandomLevel extends Level{

	private static final Random random = new Random();
	
	public RandomLevel(int w, int h) {
		super(w, h);
	}

	protected void generateLevel(){
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
				tiles[x + y * width] = random.nextInt(4);
			}
		}
	}
}
