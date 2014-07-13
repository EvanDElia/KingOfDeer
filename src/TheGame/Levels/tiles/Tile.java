package TheGame.Levels.tiles;

import TheGame.Graphics.Screen;
import TheGame.Graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile grass_2 = new GrassTile(Sprite.grass_2);
	public static Tile sand = new GrassTile(Sprite.sand);
	public static Tile hell = new GrassTile(Sprite.hell);
	public static Tile hell_2 = new GrassTile(Sprite.hell_2);
	public static Tile road = new GrassTile(Sprite.road);
	public static Tile road_line = new GrassTile(Sprite.road_line);
	
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile flower2 = new FlowerTile(Sprite.flower2);
	
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile fire = new RockTile(Sprite.fire);
	public static Tile fire_purple = new RockTile(Sprite.fire_purple);
	public static Tile fire_out = new RockTile(Sprite.fire_out);
	public static Tile fire_sand = new RockTile(Sprite.fire_sand);
	public static Tile fire_hell = new RockTile(Sprite.fire_hell);
	public static Tile fire_road = new RockTile(Sprite.fire_road);
	public static Tile sand_rock = new RockTile(Sprite.sand_rock);
	public static Tile hell_rock = new RockTile(Sprite.hell_rock);
	public static Tile door_1 = new RockTile(Sprite.door_1);
	public static Tile door_2 = new RockTile(Sprite.door_2);
	public static Tile car_green = new RockTile(Sprite.car_green);
	public static Tile car_blue = new RockTile(Sprite.car_blue);
	public static Tile car_red = new RockTile(Sprite.car_red);
	
	public static Tile wall = new WallTile(Sprite.wall);
	public static Tile side_wall = new WallTile(Sprite.side_wall);
	public static Tile brick = new WallTile(Sprite.bricks);
	public static Tile floor = new WallTile(Sprite.floor);
	public static Tile hell_edge_1 = new WallTile(Sprite.hell_edge_1);
	public static Tile hell_edge_2 = new WallTile(Sprite.hell_edge_2);
	public static Tile hell_edge_3 = new WallTile(Sprite.hell_edge_3);
	public static Tile hell_edge_4 = new WallTile(Sprite.hell_edge_4);

	public static Tile health = new GrassTile(Sprite.health);
	public static Tile health_empty = new GrassTile(Sprite.health_empty);

	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile GameOver = new VoidTile(Sprite.GameOver);
	
	public Tile(Sprite sp){
		sprite = sp;
	}
	
	public void render(int x, int y, Screen screen){
		this.x = x;
		this.y = y;
	}
	
	public boolean isSolid(){
		return false;
	}
}
