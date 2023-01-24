package decorateroom;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import main.ViewScreenConfiguration;
import tile.TileManager;

public class DecorateRoomViewPanel extends JPanel {

    TileManager tileManager = TileManager.getInstance();

    public DecorateRoomViewPanel() {
        this.setPreferredSize(new Dimension(ViewScreenConfiguration.SCREEN_WIDTH, ViewScreenConfiguration.SCREEN_HEIGHT));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // TILE
        tileManager.draw(g2);

        g2.dispose();
    } 

    public void updateTheme() {
        repaint();
    }
}
