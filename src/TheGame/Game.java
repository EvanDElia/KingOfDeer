package TheGame;
 

import java.awt.Canvas;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JFrame;

import TheGame.Entity.Mob.Mob;
import TheGame.Entity.Mob.Player;
import TheGame.Graphics.Screen;
import TheGame.Input.Keyboard;
import TheGame.Levels.*;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	
	public static int width = 300;
	private static int height = width / 16 * 9;
	private static int scale = 3;
	private Thread thread;
	private boolean running = false;
	private Screen screen;
	private Level level;
	private Keyboard key;
	private static Player player;
	private JFrame frame;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game(){
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = new SpawnLevel("/level.png", screen);
		level.playMusic();
		player = new Player(16 * 8, 16 * 4, key, level);
		
		addKeyListener(key);
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
		
	}
	
	public synchronized void stop(){
		running = false;
		try{
			thread.join();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.00 / 60.00;
		double delta = 0;
		int frames = 0; int updates = 0;
		requestFocus();
		while (running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1){
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frame.setTitle("The Game   |   " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
		
	public void update(){
		key.update();
		if (key.mute) level.stopMusic();
		else if (key.play) level.playMusic();
		
		if (player.getHealth() <= 0){
			endGame();
			try{
				Thread.sleep(100); //this was only put here to ensure that player is updated and GAME OVER is rendered
			}catch(Exception e){
				
			}
		}
		
		player.update();
		ArrayList<Mob> mobs = level.getMobs();
		for (int i = 0; i < mobs.size(); i++){
			mobs.get(i).render();
			mobs.get(i).update();
		}
	}
	
	private void endGame() {
		level.stopMusic();
		SourceDataLine soundLine = null;
	     int BUFFER_SIZE = 64*1024;  // 64 KB

	      // Set up an audio input stream piped from the sound file.
	      try {
	         File soundFile = new File("res/End.wav");
	         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
	         AudioFormat audioFormat = audioInputStream.getFormat();
	         DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
	         soundLine = (SourceDataLine) AudioSystem.getLine(info);
	         soundLine.open(audioFormat);
	         soundLine.start();
	         int nBytesRead = 0;
	         byte[] sampledData = new byte[BUFFER_SIZE];
	         while (nBytesRead != -1) {
	            nBytesRead = audioInputStream.read(sampledData, 0, sampledData.length);
	            if (nBytesRead >= 0) {
	               // Writes audio data to the mixer via this source data line.
	               soundLine.write(sampledData, 0, nBytesRead);
	            }
	         }
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } finally {
	         soundLine.drain();
	         soundLine.close();
	      }
	      stop();
	      return;
	      
	}

	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		player.displayHealth(screen);

		
		for (int i = 0; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		/*
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.dispose();
		*/
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		bs.show();
	}
	
	public static void main (String[] args){
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("Rain");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();
	}
	
	public static Player getPlayer(){
		return player;
	}

}
