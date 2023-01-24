package main;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JSlider;

/**
 *
 * @author amarabjamal
 */
public class Sound {
    Clip clip;
    URL soundURL;
    float previousVolume = 0;
    float currentVolume = -17;
    FloatControl floatControl;
    boolean isMute = false;
    boolean isPlaying = true;
    
    public Sound(String soundPath) {
        soundURL = getClass().getResource(soundPath);
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(ais);
            floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch(IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            
        }
    }
    
    public void play() {
        floatControl.setValue(currentVolume);
        clip.start();
    }
    
    public void loop() {
        floatControl.setValue(currentVolume);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop() {
        clip.stop();
    }
    
    public void volumeUp(JSlider volumeSlider) {
        
        if(currentVolume >= 6.0f) {
            currentVolume = 6.0f;
        } else {
            if(currentVolume == -80.0f) {
                currentVolume = -40.0f;
            }
            currentVolume += 1.0f;
        }
        floatControl.setValue(currentVolume);
        
        if(currentVolume == -80.0f) {
            volumeSlider.setValue(-40);
        } else {
            volumeSlider.setValue((int) currentVolume);
        }
    }
    
    public void volumeDown(JSlider volumeSlider) {
        
        if(currentVolume <= -80.0f) {
            currentVolume = -80.0f;
        } else {
            currentVolume -= 1.0f;
        }
        
        if(currentVolume == -80.0f) { 
            floatControl.setValue(currentVolume);
        }
        
        if(currentVolume == -80.0f) {
            volumeSlider.setValue(-40);
        } else {
            volumeSlider.setValue((int) currentVolume);
        }
    }
    
    public void volumeMute(JSlider volumeSlider) {
        if(isMute == false) {
            previousVolume = currentVolume;
            currentVolume = -80.0f;
            floatControl.setValue(currentVolume);
            isMute = true;
            
            volumeSlider.setValue(volumeSlider.getMinimum());
            
        } else if(isMute == true) {
            currentVolume = previousVolume;
            volumeSlider.setValue((int) currentVolume);
            floatControl.setValue(currentVolume);
            isMute = false;
        }
    }
}
