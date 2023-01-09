package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import swingdemo.GamePanel;
import swingdemo.KeyHandler;

/**
 *
 * @author amarabjamal
 */
public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyHandler;
    public int hasTreat = 0;
    
    
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
        playerY = 9 * gp.tileSize;
        speed = 4;
        direction = "down";
    }
    
    public final void getPlayerImage() {
        try {            
            up1 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_right_2.png"));
            
            upRight1 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_upright_1.png"));
            upRight2 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_upright_2.png"));
            upLeft1 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_upleft_1.png"));
            upLeft2 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_upleft_2.png"));
            downRight1 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_downright_1.png"));
            downRight2 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_downright_2.png"));
            downLeft1 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_downleft_1.png"));
            downLeft2 = ImageIO.read(getClass().getResourceAsStream("/resources/calico/calico_downleft_2.png"));
            
        } catch (IOException e) {
            
        }
    }
    
    public void update() {
        if(keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true) {
            if(keyHandler.upPressed == true) {
                direction = "up";
            }
            if(keyHandler.downPressed == true) {
                direction = "down";
            }
            if(keyHandler.leftPressed == true) {
                direction = "left";
            }
            if(keyHandler.rightPressed == true) {
                direction = "right";
            }
            
            if(keyHandler.upPressed == true && keyHandler.leftPressed == true) {
                direction = "upleft";
            }
            if(keyHandler.upPressed == true && keyHandler.rightPressed == true) {
                direction = "upright";
            }
            if(keyHandler.downPressed == true && keyHandler.leftPressed == true) {
                direction = "downleft";
            }
            if(keyHandler.downPressed == true && keyHandler.rightPressed == true) {
                direction = "downright";
            }
            
            
            // Check tile collision
            collisionOn = false;
            gp.collisionChecker.checkTile(this);
            
            // Check item collision
            int itemIndex = gp.collisionChecker.checkItem(this, true);
            pickUpItem(itemIndex);
            
            if(collisionOn == false) {
                switch(direction) {
                    case "up":
                        playerY -= speed;
                        break;
                    case "down":
                        playerY += speed;
                        break;
                    case "left":
                        playerX -= speed;
                        break;
                    case "right":
                        playerX += speed;
                        break;
                    case "upright":
                        playerY -= speed;
                        playerX += speed;
                        break;
                    case "upleft":
                        playerY -= speed;
                        playerX -= speed;
                        break;
                    case "downright":
                        playerY += speed;
                        playerX += speed;
                        break;
                    case "downleft":
                        playerY += speed;
                        playerX -= speed;
                        break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 13) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                } else if(spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 10;
            }
        }  
    }
    
    public void random() {
        Random random = new Random();
        
        int directionInteger = random.nextInt(8) + 1;
        int noOfSteps = random.nextInt(20) + 10;
            
        switch(directionInteger) {
            case 1:
                direction = "up";
                break;
            case 2:
                direction = "upright";
                break;
            case 3:
                direction = "right";
                break;
            case 4:
                direction = "downright";
                break;
            case 5:
                direction = "down";
                break;
            case 6:
                direction = "downleft";
                break;
            case 7:
                direction = "left";
                break;
            case 8:
                direction = "upleft";
                break;
        }
        
        for(int i = 0; i < noOfSteps; i++) {
            
            // Check tile collision
            collisionOn = false;
            gp.collisionChecker.checkTile(this);
            
            if(collisionOn == false) {
                switch(direction) {
                    case "up":
                        playerY -= speed;
                        break;
                    case "down":
                        playerY += speed;
                        break;
                    case "left":
                        playerX -= speed;
                        break;
                    case "right":
                        playerX += speed;
                        break;
                    case "upright":
                        playerY -= speed;
                        playerX += speed;
                        break;
                    case "upleft":
                        playerY -= speed;
                        playerX -= speed;
                        break;
                    case "downright":
                        playerY += speed;
                        playerX += speed;
                        break;
                    case "downleft":
                        playerY += speed;
                        playerX -= speed;
                        break;
                }
                
                gp.repaint();
            } else {
                break;
            }

            spriteCounter++;
            if(spriteCounter > 13) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                } else if(spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 10;
            }
        }
    }
    
    public void pickUpItem(int i) {
        if(i != 999) {
            String itemName = gp.catItem[i].name;
            
            switch(itemName) {
                case "Treat": 
                    hasTreat++;
                    gp.catItem[i] = null;
                    gp.userInterface.showMessage("You got a treat!");
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
        
        g2.drawImage(image, playerX, playerY, gp.tileSize, gp.tileSize, null);
        
    }
}
