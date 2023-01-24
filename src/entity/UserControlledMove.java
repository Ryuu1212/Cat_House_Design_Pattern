package entity;

import playgame.GamePanel;
import playgame.KeyHandler;


/**
 *
 * @author amarabjamal
 */
public class UserControlledMove implements MoveBehavior {
    GamePanel gp;
    KeyHandler keyHandler;
    Entity entity;
    
    public UserControlledMove(GamePanel gp, KeyHandler keyHandler, Entity entity) {
        this.gp = gp;
        this.keyHandler = keyHandler;
        this.entity = entity;   
    }

    @Override
    public void move() {
        if(keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true) {
            if(keyHandler.upPressed == true) {
                entity.direction = "up";
            }
            if(keyHandler.downPressed == true) {
                entity.direction = "down";
            }
            if(keyHandler.leftPressed == true) {
                entity.direction = "left";
            }
            if(keyHandler.rightPressed == true) {
                entity.direction = "right";
            }

            if(keyHandler.upPressed == true && keyHandler.leftPressed == true) {
                entity.direction = "upleft";
            }
            if(keyHandler.upPressed == true && keyHandler.rightPressed == true) {
                entity.direction = "upright";
            }
            if(keyHandler.downPressed == true && keyHandler.leftPressed == true) {
                entity.direction = "downleft";
            }
            if(keyHandler.downPressed == true && keyHandler.rightPressed == true) {
                entity.direction = "downright";
            }
            
            // Check tile collision
            entity.collisionOn = false;
            gp.collisionChecker.checkTile(entity);
            
            // Check item collision
            int itemIndex = gp.collisionChecker.checkItem(entity, true);
            entity.pickUpItem(itemIndex);
            
            if(entity.collisionOn == false) {
                switch(entity.direction) {
                    case "up":
                        entity.playerY -= entity.speed;
                        break;
                    case "down":
                        entity.playerY += entity.speed;
                        break;
                    case "left":
                        entity.playerX -= entity.speed;
                        break;
                    case "right":
                        entity.playerX += entity.speed;
                        break;
                    case "upright":
                        entity.playerY -= entity.speed;
                        entity.playerX += entity.speed;
                        break;
                    case "upleft":
                        entity.playerY -= entity.speed;
                        entity.playerX -= entity.speed;
                        break;
                    case "downright":
                        entity.playerY += entity.speed;
                        entity.playerX += entity.speed;
                        break;
                    case "downleft":
                        entity.playerY += entity.speed;
                        entity.playerX -= entity.speed;
                        break;
                }
            }

            entity.spriteCounter++;
            if(entity.spriteCounter > 13) {
                if(entity.spriteNum == 1) {
                    entity.spriteNum = 2;
                } else if(entity.spriteNum == 2) {
                    entity.spriteNum = 1;
                }
                entity.spriteCounter = 10;
            }
        }
    }
}
