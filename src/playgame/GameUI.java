package playgame;

import playgame.GamePanel;
import catitem.Treat;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

/**
 *
 * @author amarabjamal
 */
public class GameUI {
    GamePanel gp;
    Font arial_25;
    Font arcadeClassic_30;
    BufferedImage treatImage;
    Graphics2D g2;
    public boolean gameFinished = false;
    double playTime;
    double countDown = 30;
    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    
    public GameUI(GamePanel gp) {
        this.gp = gp;
        
        try {
            InputStream stream = getClass().getResourceAsStream("/resources/font/ARCADECLASSIC.TTF");
            arcadeClassic_30 = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(30F);
        } catch (IOException|FontFormatException e) {
            e.getStackTrace();
        }
        
        arial_25 = new Font("Arial", Font.PLAIN, 25);
        
        Treat treat = new Treat(gp);
        treatImage = treat.image;
    }
    
    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }
    
    public void draw(Graphics2D g2) {
        
        this.g2 = g2;
        g2.setFont(arcadeClassic_30);
        g2.setColor(Color.GRAY);
        
        if(gameFinished == true || countDown <= 0) {
            String text;
            int x, y;
            
            if(gameFinished == true) {
                text = "You got all the treats!";
                x = getXforCenteredText(text);
                y = gp.screenHeight/2 - 3*gp.tileSize;
                g2.drawString(text, x, y);
                
                g2.setFont(arial_25);
                x = getXforCenteredText(text);
                y = gp.screenHeight/2 - 2*gp.tileSize;
                text = "Time taken: " + decimalFormat.format(playTime) + "s";
                g2.drawString(text, x, y);
            } else if(countDown <= 0) {
                text = "Game Over";
                x = getXforCenteredText(text);
                y = gp.screenHeight/2 - 3*gp.tileSize;
                g2.drawString(text, x, y);
            }
            
            gp.gameThread = null;
        } else {
            // TIME
            playTime += (double) 1/60;
            countDown -= (double) 1/60;
            
            if(countDown <= 5 ) {
                g2.setColor(Color.red);
            } else if(countDown <= 10) {
                g2.setColor(Color.yellow);
            } else {
                g2.setColor(Color.GRAY);
            }
            
            g2.setFont(arial_25);
            g2.drawString("Time: "+decimalFormat.format(countDown), gp.tileSize*16 , 48);
            
            g2.setFont(arcadeClassic_30);
            g2.setColor(Color.GRAY);
            g2.drawImage(treatImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize/2, gp.tileSize/2, null);
            g2.drawString("x " + gp.player.hasTreat, 55, 47);


            if(gp.gameState == gp.playState) {
                // Dispaly message
                if(messageOn == true) {
                    g2.setFont(arcadeClassic_30);
                    g2.drawString(message, gp.tileSize/2, gp.tileSize*5);

                    messageCounter++;

                    if(messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;
                    }
                }
            } else if(gp.gameState == gp.pauseState) {
                drawPausedScreen();
            }
        }
    }
    
    public void drawPausedScreen() {
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        
        g2.drawString(text, x, y);
    }
    
    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}