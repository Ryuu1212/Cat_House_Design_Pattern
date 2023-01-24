package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author amarabjamal
 */
public abstract class Entity {
    public int playerX, playerY;
    public int speed;
    public MoveBehavior moveBehavior;
    
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, upRight1, upRight2, upLeft1, upLeft2, downRight1, downRight2, downLeft1, downLeft2;
    public String direction;
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    
    public abstract void pickUpItem(int i);

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }
}
