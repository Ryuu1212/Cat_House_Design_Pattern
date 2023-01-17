/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdemo;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

/**
 *
 * @author chairiel
 */
public class BackgroundSound extends Sound{
    //Singleton
    URL soundURL[] = new URL[30];
    private static BackgroundSound uniqueInstance;
    private BackgroundSound() {
        soundURL[0] = getClass().getResource("/resources/sound/background.wav");// TUKAR JADI SINGLETON, EXTEND SOUND
    }
    public static BackgroundSound getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new BackgroundSound();
        }
        return uniqueInstance;
    }
    
    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch(Exception e) {
            
        }
    }
}
