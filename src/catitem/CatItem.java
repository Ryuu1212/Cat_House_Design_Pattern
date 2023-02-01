package catitem;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.UtilityTool;
import main.ViewScreenConfiguration;

/**
 *
 * @author amarabjamal
 */
public class CatItem {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int floorX, floorY;
    public Rectangle solidArea = new Rectangle(0, 0, 24, 24);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    UtilityTool utilityTool = new UtilityTool();
    
    int floorUpperBoundary = 380;
    int floorLowerBoundary = 576;
    int floorRightBoundary = 960;
    int floorLeftBoundary = 0;
    
    
    public void draw(Graphics2D g2) {
        int catItemLeft = floorX;
        int catItemRight = floorX + ViewScreenConfiguration.TILE_SIZE/2;
        int catItemTop = floorY;
        int catItemBottom = floorY + ViewScreenConfiguration.TILE_SIZE/2;
        
        if(catItemLeft > floorLeftBoundary && catItemRight < floorRightBoundary && catItemTop > floorUpperBoundary && catItemBottom < floorLowerBoundary) {        
            g2.drawImage(image, floorX, floorY, null);
        }   
    }
}
