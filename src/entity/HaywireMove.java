package entity;

import java.util.Random;
import playgame.GamePanel;


/**
 *
 * @author amarabjamal
 */
public class HaywireMove implements MoveBehavior {
    GamePanel gp;
    Entity entity;
    
    public HaywireMove(GamePanel gp, Entity entity) {
        this.gp = gp;
        this.entity = entity;
    }

    @Override
    public void move() {
        Random random = new Random();
        
        int directionInteger = random.nextInt(8) + 1;
            
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
        
            
        // Check tile collision
        entity.collisionOn = false;
        gp.collisionChecker.checkTile(entity);

        if(entity.collisionOn == false) {           
            gp.repaint();
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
