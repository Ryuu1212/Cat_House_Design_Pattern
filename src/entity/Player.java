package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import playgame.GamePanel;
import playgame.KeyHandler;
import main.UtilityTool;
import main.ViewScreenConfiguration;

/**
 *
 * @author amarabjamal
 */
public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyHandler;
    public int hasTreat = 0;
    double ninjaTimeCount = 0;
    double haywireTimeCount = 0;
    
    public Player(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.keyHandler = keyHandler;
        
        solidArea = new Rectangle(0, 0, 48, 48);
        solidAreaDefaultX = solidArea.x;
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public final void setDefaultValues() {
        playerX = 48;
        playerY = 9 * ViewScreenConfiguration.TILE_SIZE;
        speed = 4;
        direction = "down";
        moveBehavior = new UserControlledMove(gp, keyHandler, this);
    }
    
    public final void getPlayerImage() {        
        up1 = setup("calico_up_1");
        up2 = setup("calico_up_2");
        down1 = setup("calico_down_1");
        down2 = setup("calico_down_2");
        left1 = setup("calico_left_1");
        left2 = setup("calico_left_2");
        right1 = setup("calico_right_1");
        right2 = setup("calico_right_2");
        upLeft1 = setup("calico_upleft_1");
        upLeft2 = setup("calico_upleft_2");
        upRight1 = setup("calico_upright_1");
        upRight2 = setup("calico_upright_2");
        downLeft1 = setup("calico_downleft_1");
        downLeft2 = setup("calico_downleft_2");
        downRight1 = setup("calico_downright_1");
        downRight2 = setup("calico_downright_2");
    }
    
    public BufferedImage setup(String imageName) {
        UtilityTool utilityTool = new UtilityTool();
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/calico/" + imageName + ".png"));
            image = utilityTool.scaleImage(image, ViewScreenConfiguration.TILE_SIZE, ViewScreenConfiguration.TILE_SIZE);
        } catch(IOException e) {
            
        }
        
        return image;
    }
    
    
    public void move() {
        if(moveBehavior instanceof NinjaMove) {
            moveBehavior.move();
            ninjaTimeCount += (double) 1/60;
            gp.userInterface.showMessage("NINJA MODE!");
            if(ninjaTimeCount > 2) {
                setMoveBehavior(new UserControlledMove(gp, keyHandler, this));
                ninjaTimeCount = 0;
            }
        } else if(moveBehavior instanceof HaywireMove) {
            moveBehavior.move();
            haywireTimeCount += (double) 1/60;
            gp.userInterface.showMessage("POISON EFFECT!");
            if(haywireTimeCount > 4) {
                setMoveBehavior(new UserControlledMove(gp, keyHandler, this));
                haywireTimeCount = 0;
            }
        } else {
            moveBehavior.move();
        }
    }
    
    @Override
    public void pickUpItem(int i) {
        if(i != 999) {
            String itemName = gp.catItems[i].name;
            
            switch(itemName) {
                case "Treat": 
                    hasTreat++;
                    gp.catItems[i] = null;
                    gp.userInterface.showMessage("You got a treat!");
                    if(hasTreat == 10) {
                        gp.userInterface.gameFinished = true;
                    }
                    break;
                case "Ninja Potion":
                    gp.catItems[i] = null;
                    gp.userInterface.showMessage("You got a ninja potion!");
                    setMoveBehavior(new NinjaMove(gp, this));
                    break;
                case "Poison":
                    gp.catItems[i] = null;
                    gp.userInterface.showMessage("You got poisoned!");
                    setMoveBehavior(new HaywireMove(gp, this));
                    break;
            }
           
        }
    }
    
    public void draw(Graphics2D g2) {
          
        BufferedImage image = null;
        
        switch(direction) {
            case "up":
                if(spriteNum == 1) {    
                    image = up1;
                }
                if(spriteNum == 2) {    
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1) {    
                    image = down1;
                }
                if(spriteNum == 2) {    
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1) {    
                    image = left1;
                }
                if(spriteNum == 2) {    
                    image = left2;
                } 
                break;
            case "right":
                if(spriteNum == 1) {    
                    image = right1;
                }
                if(spriteNum == 2) {    
                    image = right2;
                }
                break;  
            case "upright":
                if(spriteNum == 1) {    
                    image = upRight1;
                }
                if(spriteNum == 2) {    
                    image = upRight2;
                }
                break;
            case "upleft":
                if(spriteNum == 1) {    
                    image = upLeft1;
                }
                if(spriteNum == 2) {    
                    image = upLeft2;
                }
                break;
            case "downright":
                if(spriteNum == 1) {    
                    image = downRight1;
                }
                if(spriteNum == 2) {    
                    image = downRight2;
                }
                break;
            case "downleft":
                if(spriteNum == 1) {    
                    image = downLeft1;
                }
                if(spriteNum == 2) {    
                    image = downLeft2;
                }
                break;
        }
        
        g2.drawImage(image, playerX, playerY, null);
        
    }
}
