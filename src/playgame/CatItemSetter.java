package playgame;

import playgame.GamePanel;
import catitem.NinjaPotion;
import catitem.Poison;
import catitem.Treat;
import java.util.Random;

/**
 *
 * @author amarabjamal
 */
public class CatItemSetter {
    GamePanel gp;
    
//    floorUpperBoundary = 380;
//    floorLowerBoundary = 576;
//    floorRightBoundary = 960;
//    floorLeftBoundary = 0;
    
    public CatItemSetter(GamePanel gp) {
        this.gp = gp;
    }
    
    public void setObject() {
        Random ran = new Random();
        int randomX = ran.nextInt(960 - 48);
        int randomY = ran.nextInt(528 - 380 + 1) + 380;
        
        gp.catItems[0] = new NinjaPotion();
        gp.catItems[0].floorX = randomX;
        gp.catItems[0].floorY = randomY;
        
        for(int i = 1; i < 4; i++) {
            randomX = ran.nextInt(960 - 48);
            randomY = ran.nextInt(528 - 380 + 1) + 380;
            
            gp.catItems[i] = new Poison();
            gp.catItems[i].floorX = randomX;
            gp.catItems[i].floorY = randomY;
        }

        
        for(int i = 4; i < gp.catItems.length; i++) {
            randomX = ran.nextInt(960 - 48);
            randomY = ran.nextInt(528 - 380 + 1) + 380;
            
            gp.catItems[i] = new Treat();
            gp.catItems[i].floorX = randomX;
            gp.catItems[i].floorY = randomY;
        }
    }
}