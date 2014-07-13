package TheGame.Input;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class MusicThread extends Thread{
	
	volatile boolean finished = false;
	
	public void run(){
     SourceDataLine soundLine = null;
     int BUFFER_SIZE = 64*1024;  // 64 KB

      // Set up an audio input stream piped from the sound file.
      try {
         File soundFile = new File("res/Little Respect.wav");
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
         AudioFormat audioFormat = audioInputStream.getFormat();
         DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
         soundLine = (SourceDataLine) AudioSystem.getLine(info);
         soundLine.open(audioFormat);
         soundLine.start();
         int nBytesRead = 0;
         byte[] sampledData = new byte[BUFFER_SIZE];
         while (nBytesRead != -1) {
        	 while (!finished){
            nBytesRead = audioInputStream.read(sampledData, 0, sampledData.length);
            if (nBytesRead >= 0) {
               // Writes audio data to the mixer via this source data line.
               soundLine.write(sampledData, 0, nBytesRead);
            }
        	 }
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         soundLine.drain();
         soundLine.close();
      }
      return;
	}
	
	public void setFinished(boolean b){
		finished = b;
	}
}
