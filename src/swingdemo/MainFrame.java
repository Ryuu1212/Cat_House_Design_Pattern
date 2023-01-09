package swingdemo;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author amarabjamal
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        
        //Creating the Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit program if close-window button clicked
        setTitle("Bing Chilling with Calico Cat");  // "super" JFrame sets title
        setSize(960, 672);   // "super" JFrame sets initial size
        setVisible(true);    // "super" JFrame shows
        setLocationRelativeTo(null);
        
        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);
        
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        panel.add(new JLabel("Hello, Player X!"));
        panel.add(new JButton("Start"));
        panel.add(new JButton("Pause"));
        
        GamePanel gamePanel = new GamePanel();
        
        //Adding Components to the frame
        Container cp = getContentPane(); 
        cp.setLayout(new BorderLayout());
        cp.add(BorderLayout.NORTH,mb);
        cp.add(BorderLayout.CENTER, gamePanel);
        cp.add(BorderLayout.SOUTH, panel);
        
        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}
