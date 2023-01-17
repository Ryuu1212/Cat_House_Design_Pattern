package swingdemo;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author amarabjamal
 */
public abstract class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];
    int state = 1;
    
    public Sound() {
//        soundURL[0] = getClass().getResource("/resources/sound/background.wav");
    }
    
//    public void setFile(int i) {
//        try {
//            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
//            clip = AudioSystem.getClip();
//            clip.open(ais);
//        } catch(Exception e) {
//            
//        }
//    }
    public abstract void setFile(int i);
    
    public int getState(){
        return state;
    }
    public void setState(int state){
        state = this.state;
    }
    
    public void play() {
        clip.start();
        state = 1;
    }
    
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop() {
        clip.stop();
        state = 2;
    }
}
