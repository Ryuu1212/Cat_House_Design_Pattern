package swingdemo;

import entity.Entity;

/**
 *
 * @author amarabjamal
 */
public class CollisionChecker {
    GamePanel gp;
    int floorUpperBoundary;
    int floorLowerBoundary;
    int floowRightBoundary;
    
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
        floorUpperBoundary = gp.tileSize * 8 - gp.tileSize/2;
        floorLowerBoundary = gp.screenHeight;
        floowRightBoundary = gp.screenWidth;
    }
    
    public void checkTile(Entity entity) {
        int entityLeftPlayerX = entity.playerX;
        int entityRightPlayerX = entity.playerX + gp.tileSize;
        int entityTopPlayerY = entity.playerY;
        int entityBottomPlayerY = entity.playerY + gp.tileSize;
        
        switch(entity.direction) {
            case "up":
                entityTopPlayerY -= entity.speed;
                
                if(entityTopPlayerY <= floorUpperBoundary) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomPlayerY += entity.speed;
                
                if(entityBottomPlayerY >= floorLowerBoundary) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftPlayerX -= entity.speed;
                
                if(entityLeftPlayerX <= 0) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightPlayerX += entity.speed;
                
                if(entityRightPlayerX >= floowRightBoundary) {
                    entity.collisionOn = true;
                }
                break;
            case "upright":
                entityTopPlayerY -= entity.speed;
                entityRightPlayerX += entity.speed;
                
                if(entityTopPlayerY <= floorUpperBoundary || entityRightPlayerX >= floowRightBoundary) {
                    entity.collisionOn = true;
                }
                break;
            case "upleft":
                entityTopPlayerY -= entity.speed;
                entityLeftPlayerX -= entity.speed;
                
                if(entityTopPlayerY <= floorUpperBoundary || entityLeftPlayerX <= 0) {
                    entity.collisionOn = true;
                }
                break;
            case "downright":
                entityBottomPlayerY += entity.speed;
                entityRightPlayerX += entity.speed;
                
                if(entityBottomPlayerY >= floorLowerBoundary || entityRightPlayerX >= floowRightBoundary) {
                    entity.collisionOn = true;
                }
                break;
            case "downleft":
                entityBottomPlayerY += entity.speed;
                entityLeftPlayerX -= entity.speed;
                
                if(entityBottomPlayerY >= floorLowerBoundary || entityLeftPlayerX <= 0) {
                    entity.collisionOn = true;
                }
                break;
        }
    }
    
    public int checkItem(Entity entity, boolean player) {
        int index = 999;
        
        for(int i = 0; i < gp.catItem.length; i++) {
            
            if(gp.catItem[i] != null) {
                
                // Get entity's solid area position
                entity.solidArea.x = entity.playerX + entity.solidArea.x;
                entity.solidArea.y = entity.playerY + entity.solidArea.y;

                // Get item's solid object position
                gp.catItem[i].solidArea.x = gp.catItem[i].floorX + gp.catItem[i].solidArea.x;
                gp.catItem[i].solidArea.y = gp.catItem[i].floorY + gp.catItem[i].solidArea.y;

                switch(entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.catItem[i].solidArea)) {
                            if(gp.catItem[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.catItem[i].solidArea)) {
                            if(gp.catItem[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.catItem[i].solidArea)) {
                            if(gp.catItem[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.catItem[i].solidArea)) {
                            if(gp.catItem[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "upleft":
                        entity.solidArea.y -= entity.speed;
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.catItem[i].solidArea)) {
                            if(gp.catItem[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "upright":
                        entity.solidArea.y -= entity.speed;
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.catItem[i].solidArea)) {
                            if(gp.catItem[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "downleft":
                        entity.solidArea.y += entity.speed;
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.catItem[i].solidArea)) {
                            if(gp.catItem[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "downright":
                        entity.solidArea.y += entity.speed;
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.catItem[i].solidArea)) {
                            if(gp.catItem[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                }

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.catItem[i].solidArea.x = gp.catItem[i].solidAreaDefaultX;
                gp.catItem[i].solidArea.y = gp.catItem[i].solidAreaDefaultY;
            }
        }
        
        return index;
    }
    
}
