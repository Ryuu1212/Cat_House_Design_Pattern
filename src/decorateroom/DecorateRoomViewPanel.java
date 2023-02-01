package decorateroom;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import main.ViewScreenConfiguration;
import tile.TileManager;
import decorateroom.CatBed;
import decorateroom.Furniture;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class DecorateRoomViewPanel extends JPanel {

    TileManager tileManager = TileManager.getInstance();
    
    
    
    Furniture[] furnitures = new Furniture[2];
    
    public DecorateRoomViewPanel() {
        this.setPreferredSize(new Dimension(ViewScreenConfiguration.SCREEN_WIDTH, ViewScreenConfiguration.SCREEN_HEIGHT));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        furnitures[0] = new CatBed();
//        furnitures[1] = new CatToy();
        
    }
    
    

    @Override
    public void paintComponent(Graphics g) {
        
            
            Graphics2D g2 = (Graphics2D) g;
            
            // TILE
            BufferedImage image;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/furniture/nocatbed.png"));
             g2.drawImage(image, 0, 0, this);
        } catch (IOException ex) {
            Logger.getLogger(DecorateRoomViewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
          //  g2.drawImage(image, WIDTH, WIDTH, this)
            
                    // Draw Bed
                    // furnitures[0].draw(g2);
//        furnitures[1].draw(g2);
                    
                  
        }
     

    public void updateTheme() {
        repaint();
    }
}
