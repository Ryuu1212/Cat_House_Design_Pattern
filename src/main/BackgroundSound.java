package main;

/**
 *
 * @author chairiel
 */
public class BackgroundSound extends Sound{
    //Singleton
    private static BackgroundSound uniqueInstance;
    
    private BackgroundSound() {
        super("/resources/sound/background.wav");
    }
    
    public static BackgroundSound getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new BackgroundSound();
        }
        return uniqueInstance;
    }
}
