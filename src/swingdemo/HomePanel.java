package swingdemo;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import tile.HomeTileManager;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {

    final int originalTileSize = 16; // 16*16 tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; // 48*48 tile
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 960 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    

    HomeTileManager homeTileManager = new HomeTileManager(this);
//    Sound sound = new Sound();
        BackgroundSound sound = BackgroundSound.getInstance();

    
    public HomePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        

        // TILE
        homeTileManager.draw(g2);
        
        
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
