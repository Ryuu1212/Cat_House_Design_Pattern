package playgame;

import catitem.CatItem;
import entity.Player;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import keycontrolaction.DownPressedAction;
import keycontrolaction.DownReleasedAction;
import keycontrolaction.LeftPressedAction;
import keycontrolaction.LeftReleasedAction;
import keycontrolaction.RightPressedAction;
import keycontrolaction.RightReleasedAction;
import keycontrolaction.UpPressedAction;
import keycontrolaction.UpReleasedAction;
import main.Sound;
import main.ViewScreenConfiguration;
import tile.TileManager;

/**
 *
 * @author amarabjamal
 */
public class GamePanel extends JPanel implements Runnable {
    
    //Screen settings    
    public final int tileSize = ViewScreenConfiguration.TILE_SIZE;
    public final int maxScreenCol = ViewScreenConfiguration.MAX_SCREEN_COL;
    public final int maxScreenRow = ViewScreenConfiguration.MAX_SCREEN_ROW;
    public final int screenWidth = ViewScreenConfiguration.SCREEN_WIDTH;
    public final int screenHeight = ViewScreenConfiguration.SCREEN_HEIGHT;
    
    // FPS
    int FPS = 60;
    
    // SYSTEM
    TileManager tileManager = TileManager.getInstance();
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    public Sound sound = new Sound("/resources/sound/background.wav");
    public CatItemSetter catItemSetter = new CatItemSetter(this);
    public GameUI userInterface = new GameUI(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    
    // ENTITY AND OBJECT
    Player player = new Player(this, keyHandler);
    public CatItem[] catItems = new CatItem[14];
    
    // GAME STATE
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        keyInputBinding();
    }
    
    public final void keyInputBinding() {
        // KEY PRESSED
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "upPressedAction");
        this.getActionMap().put("upPressedAction",new UpPressedAction(keyHandler));
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "downPressedAction");
        this.getActionMap().put("downPressedAction", new DownPressedAction(keyHandler));
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "leftPressedAction");
        this.getActionMap().put("leftPressedAction", new LeftPressedAction(keyHandler));
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "righPressedtAction");
        this.getActionMap().put("righPressedtAction", new RightPressedAction(keyHandler));
        
        // KEY RELEASED
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released W"), "upReleasedAction");
        this.getActionMap().put("upReleasedAction", new UpReleasedAction(keyHandler));
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released S"), "downReleasedAction");
        this.getActionMap().put("downReleasedAction", new DownReleasedAction(keyHandler));
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released A"), "leftReleasedAction");
        this.getActionMap().put("leftReleasedAction", new LeftReleasedAction(keyHandler));
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released D"), "rightReleasedAction");
        this.getActionMap().put("rightReleasedAction", new RightReleasedAction(keyHandler));
    }
    
    public void setUpGame() {
        catItemSetter.setObject();
        gameState = playState;
    }
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void restart() {
        catItemSetter.setObject();
        gameState = playState;
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; // 0.01666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while(gameThread != null) {
            move();
            repaint();
            
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
    
    public void move() {
        if(gameState == playState) {
            player.move();
        } 
        if(gameState == pauseState) {
            
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        // TILE
        tileManager.draw(g2);
        
        // CAT ITEMS
        for (CatItem catItem : catItems) {
            if (catItem != null) {
                catItem.draw(g2, this);
            }
        }
        
        // PLAYER
        player.draw(g2);
        
        // GameUI
        userInterface.draw(g2);
        
        g2.dispose();
    } 
}