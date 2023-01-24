package entity;

import java.util.Random;
import playgame.GamePanel;


/**
 *
 * @author amarabjamal
 */
public class NinjaMove implements MoveBehavior {
    GamePanel gp;
    Entity entity;
    
    public NinjaMove(GamePanel gp, Entity entity) {
        this.gp = gp;
        this.entity = entity;
    }

    @Override
    public void move() {
        Random random = new Random();
        
        int directionInteger = random.nextInt(8) + 1;
        int noOfSteps = random.nextInt(20) + 10;
            
        switch(directionInteger) {
            case 1:
                entity.direction = "up";
                break;
            case 2:
                entity.direction = "upright";
                break;
            case 3:
                entity.direction = "right";
                break;
            case 4:
                entity.direction = "downright";
                break;
            case 5:
                entity.direction = "down";
                break;
            case 6:
                entity.direction = "downleft";
                break;
            case 7:
                entity.direction = "left";
                break;
            case 8:
                entity.direction = "upleft";
                break;
        }
        
        for(int i = 0; i < noOfSteps; i++) {
            
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
                
                gp.repaint();
            } else {
                break;
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
