package swingdemo;

import catitem.Treat;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 *
 * @author amarabjamal
 */
public class UI {
    GamePanel gp;
    Font arial_25;
    Font arcadeClassic_25;
    Font arcadeClassic;
    BufferedImage treatImage;
    GraphicsEnvironment ge;
    
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    
    public UI(GamePanel gp) {
        this.gp = gp;
        
//        try {
//            arcadeClassic = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/resources/font/ARCADECLASSIC.TTF"));
//            ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            ge.registerFont(arcadeClassic);
//        } catch (IOException|FontFormatException e) {
//            System.out.println("error!");
//            e.getStackTrace();
//        }
        try {
            InputStream stream = getClass().getResourceAsStream("/resources/font/ARCADECLASSIC.TTF");
            arcadeClassic_25 = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(30F);
        } catch (IOException|FontFormatException e) {
            e.getStackTrace();
        }
        
        arial_25 = new Font("Arial", Font.PLAIN, 25);
        Treat treat = new Treat();
        treatImage = treat.image;
    }
    
    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }
    
    public void draw(Graphics2D g2) {
        g2.setFont(arcadeClassic_25);
        g2.setColor(Color.white);
        g2.drawImage(treatImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize/2, gp.tileSize/2, null);
        g2.drawString("x " + gp.player.hasTreat, 55, 47);
        
        // Dispaly message
        if(messageOn == true) {
            g2.setFont(arcadeClassic_25);
            g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
            
            messageCounter++;
            
            if(messageCounter > 120) {
                messageCounter = 0;
                messageOn = false;
            }
        }
    }
}
