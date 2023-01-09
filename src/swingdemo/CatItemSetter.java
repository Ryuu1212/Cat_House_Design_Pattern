package swingdemo;

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
        
        for(int i = 0; i < gp.catItem.length; i++) {
            int randomX = ran.nextInt(960 - 24);
            int randomY = ran.nextInt(576 - 332) + 380;
            
            gp.catItem[i] = new Treat();
            gp.catItem[i].floorX = randomX;
            gp.catItem[i].floorY = randomY;
        }
        
//        gp.catItem[0] = new Treat();
//        gp.catItem[0].floorX = 100;
//        gp.catItem[0].floorY = 390;
//        
//        gp.catItem[1] = new Treat();
//        gp.catItem[1].floorX = 500;
//        gp.catItem[1].floorY = 450;
    }
}
