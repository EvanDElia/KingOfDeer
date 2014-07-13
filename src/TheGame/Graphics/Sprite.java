package TheGame.Graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite grass_2 = new Sprite(16, 1, 1, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite flower2 = new Sprite(16, 4, 0, SpriteSheet.tiles);
	public static Sprite fire = new Sprite(16, 6, 0, SpriteSheet.tiles);
	public static Sprite fire_purple = new Sprite(16, 6, 1, SpriteSheet.tiles);
	public static Sprite fire_out = new Sprite(16, 6, 2, SpriteSheet.tiles);
	public static Sprite fire_sand = new Sprite(16, 7, 1, SpriteSheet.tiles);
	public static Sprite fire_hell = new Sprite(16, 8, 1, SpriteSheet.tiles);
	public static Sprite sand = new Sprite(16, 2, 1, SpriteSheet.tiles);
	public static Sprite sand_rock = new Sprite(16, 4, 2, SpriteSheet.tiles);
	public static Sprite ladder = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite bricks = new Sprite(16, 5, 0, SpriteSheet.tiles);
	public static Sprite floor = new Sprite(16, 7, 0, SpriteSheet.tiles);
	public static Sprite wall = new Sprite(16, 8, 0, SpriteSheet.tiles);
	public static Sprite side_wall = new Sprite(16, 10, 0, SpriteSheet.tiles);
	public static Sprite hell_rock = new Sprite(16, 5, 2, SpriteSheet.tiles);
	public static Sprite hell = new Sprite(16, 3, 1, SpriteSheet.tiles);
	public static Sprite hell_2 = new Sprite(16, 4, 1, SpriteSheet.tiles);
	public static Sprite hell_edge_1 = new Sprite(16, 10, 1, SpriteSheet.tiles);
	public static Sprite hell_edge_2 = new Sprite(16, 9, 1, SpriteSheet.tiles);
	public static Sprite hell_edge_3 = new Sprite(16, 9, 2, SpriteSheet.tiles);
	public static Sprite hell_edge_4 = new Sprite(16, 10, 2, SpriteSheet.tiles);
	public static Sprite road = new Sprite(16, 4, 3, SpriteSheet.tiles);
	public static Sprite road_line = new Sprite(16, 4, 4, SpriteSheet.tiles);
	public static Sprite fire_road = new Sprite(16, 5, 1, SpriteSheet.tiles);
	public static Sprite car_green = new Sprite(16, 5, 3, SpriteSheet.tiles);
	public static Sprite car_blue = new Sprite(16, 5, 4, SpriteSheet.tiles);
	public static Sprite car_red = new Sprite(16, 5, 5, SpriteSheet.tiles);
	
	public static Sprite health = new Sprite(16, 11, 0, SpriteSheet.tiles);
	public static Sprite health_empty = new Sprite(16, 12, 0, SpriteSheet.tiles);
	
	public static Sprite door_1 = new Sprite(48, 2, 1, SpriteSheet.tiles);
	public static Sprite door_2 = new Sprite(48, 3, 1, SpriteSheet.tiles);

	public static Sprite voidSprite = new Sprite(16, 9, 0, SpriteSheet.tiles);
	public static Sprite GameOver = new Sprite(160, 0, 0, SpriteSheet.GameOver);
	
	public static Sprite deer = new Sprite(32, 0, 1, SpriteSheet.tiles);
	public static Sprite deer_2 = new Sprite(32, 0, 2, SpriteSheet.tiles);
	
	public static Sprite turban = new Sprite(32, 3, 8, SpriteSheet.tiles);
	public static Sprite turban_up_1 = new Sprite(32, 4, 8, SpriteSheet.tiles);
	public static Sprite turban_up_2 = new Sprite(32, 4, 9, SpriteSheet.tiles);
	public static Sprite turban_up_3 = new Sprite(32, 4, 10, SpriteSheet.tiles);
	public static Sprite turban_down_1 = new Sprite(32, 3, 9, SpriteSheet.tiles);
	public static Sprite turban_down_2 = new Sprite(32, 3, 10, SpriteSheet.tiles);
	
	public static Sprite demon = new Sprite(32, 5, 8, SpriteSheet.tiles);
	public static Sprite demon_down_1 = new Sprite(32, 5, 9, SpriteSheet.tiles);
	public static Sprite demon_down_2 = new Sprite(32, 5, 10, SpriteSheet.tiles);
	public static Sprite demon_up_1 = new Sprite(32, 6, 8, SpriteSheet.tiles);
	public static Sprite demon_up_2 = new Sprite(32, 6, 9, SpriteSheet.tiles);
	public static Sprite demon_up_3 = new Sprite(32, 6, 10, SpriteSheet.tiles);
	
	public static Sprite blob = new Sprite(32, 0, 8, SpriteSheet.tiles);
	public static Sprite blob_2 = new Sprite(32, 1, 8, SpriteSheet.tiles);
	
	public static Sprite spaceman = new Sprite(32, 7, 8, SpriteSheet.tiles);
	public static Sprite spaceman_down_1 = new Sprite(32, 7, 9, SpriteSheet.tiles);
	public static Sprite spaceman_down_2 = new Sprite(32, 7, 10, SpriteSheet.tiles);
	public static Sprite spaceman_up_1 = new Sprite(32, 8, 8, SpriteSheet.tiles);
	public static Sprite spaceman_up_2 = new Sprite(32, 8, 9, SpriteSheet.tiles);
	public static Sprite spaceman_up_3 = new Sprite(32, 8, 10, SpriteSheet.tiles);

	/*
	public static Sprite player0 = new Sprite(16, 0, 8, SpriteSheet.tiles);
	public static Sprite player1 = new Sprite(16, 1, 8, SpriteSheet.tiles);
	public static Sprite player2 = new Sprite(16, 0, 9, SpriteSheet.tiles);
	public static Sprite player3 = new Sprite(16, 1, 9, SpriteSheet.tiles);
	*/
	public static Sprite player_up = new Sprite(32, 0, 4, SpriteSheet.tiles);
	public static Sprite player_down = new Sprite(32, 2, 4, SpriteSheet.tiles);
	public static Sprite player_left = new Sprite(32, 3, 4, SpriteSheet.tiles);
	public static Sprite player_right = new Sprite(32, 1, 4, SpriteSheet.tiles);
	public static Sprite player_hurt = new Sprite (32, 6, 4, SpriteSheet.tiles);
	
	public static Sprite player_up_1 = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite player_up_2 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	
	public static Sprite player_down_1 = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite player_down_2 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	
	public static Sprite player_left_1 = new Sprite(32, 3, 5, SpriteSheet.tiles);
	public static Sprite player_left_2 = new Sprite(32, 3, 6, SpriteSheet.tiles);
	
	public static Sprite player_right_1 = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite player_right_2 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	
	public static Sprite player_right_sword_1 = new Sprite(32, 4, 4, SpriteSheet.tiles);
	public static Sprite player_right_sword_2 = new Sprite(32, 4, 5, SpriteSheet.tiles);
	public static Sprite player_right_sword_3 = new Sprite(32, 4, 6, SpriteSheet.tiles);
	
	public static Sprite player_left_sword_1 = new Sprite(32, 5, 4, SpriteSheet.tiles);
	public static Sprite player_left_sword_2 = new Sprite(32, 5, 5, SpriteSheet.tiles);
	public static Sprite player_left_sword_3 = new Sprite(32, 5, 6, SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet s){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		sheet = s;
		load();
	}
	
	public Sprite(int size, int color){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		for (int i = 0; i < pixels.length; i++){
			pixels[i] = color;
		}
	}
	
	private void load(){
		for (int y = 0; y < SIZE; y++){
			for (int x = 0; x < SIZE; x++){
				pixels[x + y * SIZE] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}

}
