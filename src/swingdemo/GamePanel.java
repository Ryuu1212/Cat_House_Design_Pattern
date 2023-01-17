package swingdemo;

import catitem.CatItem;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import tile.TileManager;

/**
 *
 * @author amarabjamal
 */
public class GamePanel extends JPanel implements Runnable {
    
    //Screen settings
    final int originalTileSize = 16; // 16*16 tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; // 48*48 tile
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 960 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    
    // FPS
    int FPS = 60;
    
    // SYSTEM
    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    Sound sound = new Sound();
    public CatItemSetter catItemSetter = new CatItemSetter(this);
    public UI userInterface = new UI(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    
    // ENTITY AND OBJECT
    Player player = new Player(this, keyHandler);
    public CatItem catItem[] = new CatItem[10];
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }
    
    public void setUpGame() {
        playMusic(0);
        catItemSetter.setObject();
    }
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS; // 0.01666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while(gameThread != null) {
            
            // 1 UPDATE: character's postions
            update();
            //random();
            
            double remainingTime = (nextDrawTime - System.nanoTime()) / 1000000;
            
            if(remainingTime < 0) {
                remainingTime = 0;
            }
            
            try {
                Thread.sleep((long) remainingTime);
                
                nextDrawTime += drawInterval;
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    public void update() {
        player.update();
        repaint();
    }
    
    public void random() {
        player.random();
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        // TILE
        tileManager.draw(g2);
        
        // CAT ITEMS
        for(int i = 0; i < catItem.length; i++) {
            if(catItem[i] != null) {
                catItem[i].draw(g2, this);
            }
        }
        
        // PLAYER
        // factory 
        player.draw(g2);
        
        // UI
        userInterface.draw(g2);
        
        g2.dispose();
    } 
    
    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    
    public void stopMusic() {
        sound.stop();
    }
}
