package TheGame.Levels;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import TheGame.Entity.Mob.Blob;
import TheGame.Entity.Mob.Demon;
import TheGame.Entity.Mob.Enemy;
import TheGame.Entity.Mob.Mob;
import TheGame.Entity.Mob.Spaceman;
import TheGame.Graphics.Screen;
import TheGame.Graphics.Sprite;
import TheGame.Input.MusicThread;
import TheGame.Levels.tiles.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	protected BufferedImage image;
	private int[] badX = {20};
	private int[] badY = {4, 8, 12};
	protected Screen screen;
	protected String path;
	private MusicThread BM = new MusicThread();
	
	public Mob turban_1 = new Enemy(4 * 16, 5 * 16, Sprite.turban, this);
	public Mob turban_2 = new Enemy(10 * 16, 5 * 16, Sprite.turban, this);
	public Mob turban_3 = new Enemy(3 * 16, 16 * 16, Sprite.turban, this);
	public Mob turban_4 = new Enemy(17 * 16, 16 * 20, Sprite.turban, this);
	public Mob turban_5 = new Enemy(8 * 16, 16 * 16, Sprite.turban, this);
	public Mob turban_6 = new Enemy(20 * 16, 8 * 16, Sprite.turban, this);
	private ArrayList<Mob> level_1 = new ArrayList<Mob>(Arrays.asList(turban_1, turban_2, turban_3, turban_4, turban_5, turban_6));
	
	public Mob spaceman_1 = new Spaceman(10 * 16, 8 * 16, Sprite.spaceman, this);
	public Mob spaceman_2 = new Spaceman(3 * 16, 8 * 16, Sprite.spaceman, this);
	public Mob spaceman_3 = new Spaceman(4 * 16, 12 * 16, Sprite.spaceman, this);
	public Mob spaceman_4 = new Spaceman(22 * 16, 6 * 16, Sprite.spaceman, this);
	public Mob spaceman_5 = new Spaceman(18 * 16, 10 * 16, Sprite.spaceman, this);
	private ArrayList<Mob> level_2 = new ArrayList<Mob>(Arrays.asList(spaceman_1, spaceman_2, spaceman_3, spaceman_4, spaceman_5));
	
	public Mob demon_1 = new Demon(5 * 16, 15 * 16, Sprite.demon, this);
	public Mob demon_2 = new Demon(4 * 16, 10 * 16, Sprite.demon, this);
	public Mob demon_3 = new Demon(8 * 16, 8 * 16, Sprite.demon, this);
	public Mob demon_4 = new Demon(8 * 16, 16 * 18, Sprite.demon, this);
	public Mob blob_1 = new Blob(10 * 16, 6 * 18, Sprite.blob, this);
	public Mob blob_2 = new Blob(15 * 16, 8 * 18, Sprite.blob, this);
	public Mob blob_3 = new Blob(10 * 16, 12 * 18, Sprite.blob, this);
	private ArrayList<Mob> level_3 = new ArrayList<Mob>(Arrays.asList(demon_1, demon_2, demon_3, demon_4, blob_1, blob_2, blob_3));
	
	public static final String[] paths = {"/levelOne.png", "/levelTwo.png", "/levelThree.png", "/level.png"};
	
	public static int grass = 0xff00ff00;
	public static int grass_2 = 0xff00ff80;
	public static int flower = 0xffffff00;
	public static int rock = 0xff7f7f00;
	public static int wall = 0xff404040;
	public static int flower2 = 0xffffffff;
	public static int side_wall = 0xffA0A0A0;
	public static int fire = 0xffff0000;
	public static int sand_rock = 0xffff8902;
	public static int sand = 0xffffc272;
	public static int fire_sand = 0xffff2b2f;
	public static int fire_hell = 0xffffa0aa;
	public static int hell = 0xffff000f;
	public static int hell_2 = 0xffff00aa;
	public static int hell_edge_1 = 0xffff0050;
	public static int hell_edge_2 = 0xffff0070;
	public static int hell_edge_3 = 0xffff0080;
	public static int hell_edge_4 = 0xffff0090;
	public static int road = 0xff808080;
	public static int road_line = 0xfffff39b;
	public static int fire_road = 0xffff82c2;
	public static int brick = 0xffffa18e;
	public static int hell_rock = 0xffff0990;
	public static int car_green = 0xff08f39b;
	public static int car_blue = 0xff191dff;
	public static int car_red = 0xffff4c00;
	
	public Level(int w, int h){
		width = w;
		height = h;
		tiles = new int[width * height]; 
		generateLevel();
	}

	public Level(String path, Screen s){
		screen = s;
		this.path = path;
		loadLevel(path);
	}
	
	protected void generateLevel(){
		
	}
	
	protected void loadLevel(String path){
		try{
			image = ImageIO.read(SpawnLevel.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		} catch (IOException e){
			e.printStackTrace();
			System.out.println("Excpetion! Could not load level file!");
		}
		if (path.equals("/level.png")){
			badX[0] = 20;
			badY[0] = 4;
			badY[1] = 8;
			badY[2] = 12;
		}
		else{
			badX[0] = 11;
			badY[0] = 16;
			badY[1] = -1;
			badY[2] = -1;
 		}
	}
	
	public void update(){
	}
	
	@SuppressWarnings("unused")
	private void time(){
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		for (int y = y0; y < y1; y++){
			for (int x = x0; x < x1; x++){
				//System.out.println(x + " " + y);
				//System.out.println(getTile(x, y));
				getTile(x, y).render(x, y, screen);
			}
		}
		ArrayList<Mob> Mobs = getMobs();
		for (int i = 0; i < Mobs.size(); i++){
			if (Mobs.get(i).getHealth() > 0){
				screen.renderMob(Mobs.get(i).getX(), Mobs.get(i).getY(), Mobs.get(i).getSprite());
			}
		}
		
		if (path.equals(paths[0])){
			screen.renderTile(10 * 16, 10 * 16, Tile.door_1);
			screen.renderTile(11 * 16, 10 * 16, Tile.door_2);
		}
	}
	
	public Tile getTile(int x, int y){
		if (levelBeaten() && x == 11 && y == 16) return getTile(10,15);
		if (x < 0 || x >= width || y < 0 || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == grass) return Tile.grass;
		if (tiles[x + y * width] == grass_2) return Tile.grass_2;
		if (tiles[x + y * width] == flower) return Tile.flower;
		if (tiles[x + y * width] == rock) return Tile.rock;
		if (tiles[x + y * width] == wall) return Tile.wall;
		if (tiles[x + y * width] == side_wall) return Tile.side_wall;
		if (tiles[x + y * width] == flower2) return Tile.flower2;
		if (tiles[x + y * width] == fire) return Tile.fire;
		if (tiles[x + y * width] == sand) return Tile.sand;
		if (tiles[x + y * width] == sand_rock) return Tile.sand_rock;
		if (tiles[x + y * width] == fire_sand) return Tile.fire_sand;
		if (tiles[x + y * width] == fire_hell) return Tile.fire_hell;
		if (tiles[x + y * width] == hell) return Tile.hell;
		if (tiles[x + y * width] == hell_2) return Tile.hell_2;
		if (tiles[x + y * width] == hell_edge_1) return Tile.hell_edge_1;
		if (tiles[x + y * width] == hell_edge_2) return Tile.hell_edge_2;
		if (tiles[x + y * width] == hell_edge_3) return Tile.hell_edge_3;
		if (tiles[x + y * width] == hell_edge_4) return Tile.hell_edge_4;	
		if (tiles[x + y * width] == hell_rock) return Tile.hell_rock;
		if (tiles[x + y * width] == road) return Tile.road;
		if (tiles[x + y * width] == road_line) return Tile.road_line;	
		if (tiles[x + y * width] == brick) return Tile.brick;
		if (tiles[x + y * width] == fire_road) return Tile.fire_road;
		if (tiles[x + y * width] == car_green) return Tile.car_green;
		if (tiles[x + y * width] == car_red) return Tile.car_red;
		if (tiles[x + y * width] == car_blue) return Tile.car_blue;
		return Tile.voidTile;
	}
	
	public void changePath(String path){
		loadLevel(path);
	}
	
	public void changePath(int i){
		loadLevel(paths[i]);
		path = paths[i];
		AudioClip a = null;
		try{
			a = Applet.newAudioClip(new URL("file:/Users/Evan/Music/Game Sound Effects/Teleport.wav"));
		} catch (IOException e){
			e.printStackTrace();
		}
		
		a.play();
	}
	
	public void setTrue(int i){
		//This method must be overridden in the SpawnLevel class
	}
	
	public int[] getBadX(){
		return badX;
	}
	
	public int[] getBadY(){
		return badY;
	}

	public ArrayList<Mob> getMobs(){
		if (path.equals(paths[3])){
			if (Mob.deer.getHealth() > 0) return new ArrayList<Mob>(Arrays.asList(Mob.deer));
		}
		else if (path.equals(paths[0])){
			if (turban_1.getHealth() > 0 || turban_2.getHealth() > 0 || turban_3.getHealth() > 0 ||turban_4.getHealth() > 0 || turban_5.getHealth() > 0 || turban_6.getHealth() > 0) return level_1;
			else setTrue(0);
		}
		else if (path.equals(paths[1])){
			if (spaceman_1.getHealth() > 0 || spaceman_2.getHealth() > 0 || spaceman_3.getHealth() > 0 || spaceman_4.getHealth() > 0 || spaceman_5.getHealth() > 0) return level_2;
			else setTrue(1);
		}
		else if (path.equals(paths[2])){
			if (demon_1.getHealth() > 0 || demon_2.getHealth() > 0 || demon_3.getHealth() > 0 ||demon_4.getHealth() > 0 ||blob_1.getHealth() > 0 || blob_2.getHealth() > 0 || blob_3.getHealth() > 0) return level_3;
			else setTrue(2);
		}
		return new ArrayList<Mob>();
	}
	
	public void playMusic(){
		if (BM.getState() == Thread.State.NEW) BM.start();
		else {
			BM.setFinished(false);
		}
	}
	
	public void stopMusic(){
		BM.setFinished(true);

	}
	
	public String getPath(){
		return path;
	}
	
	public boolean levelBeaten(){
		if (getMobs().size() == 0 && !path.equals(paths[3])) return true;
		else return false;
	}

}
