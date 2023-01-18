package swingdemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author amarabjamal
 */
public class MainFrame extends JFrame {    
    CardLayout cardLayout;
    JPanel mainPanel;
    ControlPanel controlPanel;
    GamePanel gamePanel;
    DecoratorPanel decoratorPanel;
    HomePanel homePanel;
    
    public MainFrame() {
        KeyHandler keyHandler = new KeyHandler();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
//        controlPanel = new ControlPanel();
        gamePanel = new GamePanel();
        decoratorPanel = new DecoratorPanel();
        homePanel = new HomePanel();
        controlPanel = new ControlPanel(mainPanel, cardLayout, gamePanel);
        mainPanel.add(controlPanel, "control");
        mainPanel.add(gamePanel, "game");
        mainPanel.add(decoratorPanel, "decorator");
        mainPanel.add(homePanel, "change");
        
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
        JMenu m3 = new JMenu("Menu");
//        mb.add(m1);
//        mb.add(m2);
        mb.add(m3);
//        JMenuItem m11 = new JMenuItem("Open");
//        JMenuItem m22 = new JMenuItem("Save as");
//        m1.add(m11);
//        m1.add(m22);
        
        MenuListener al1 = new MenuListener(){
            @Override
            public void menuSelected(MenuEvent e) {
                controlPanel.setVisible(true);
                gamePanel.setVisible(false);
                decoratorPanel.setVisible(false);
                homePanel.setVisible(false);
                System.out.println("Menu selected");
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                System.out.println("Menu deselected");
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        m3.addMenuListener(al1);
        
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        panel.setBackground(Color.lightGray);
        panel.add(new JLabel("Hello, Player X!"));
        panel.add(new JButton("Start"));
        panel.add(new JButton("Pause"));
        
        JToggleButton musicToggle = new JToggleButton("\uD83D\uDD0AToggle");
        panel.add(musicToggle);
        musicToggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BackgroundSound sound =BackgroundSound.getInstance();
                if(sound.getState()==1){
                    System.out.println("Stop music!");
//                    gamePanel.stopMusic();
                    controlPanel.stopMusic();
                    sound.setState(2);
                }
                else if(sound.getState()==2){
                    System.out.println("Play music!");
//                    gamePanel.playMusic(0);
                    controlPanel.playMusic(0);
                    sound.setState(1);
        }
            }
        });
        
        JButton goGame = new JButton("Back");
        panel.add(goGame);
        goGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "control");
//                gamePanel.addKeyListener(keyHandler);
            }
        });
        
        //Adding Components to the frame
        Container cp = getContentPane(); 
        cp.setLayout(new BorderLayout());
        cp.add(BorderLayout.NORTH,mb);
        cp.add(BorderLayout.SOUTH, panel);
        add(mainPanel);
//        cp.add(BorderLayout.CENTER, gamePanel);
//        cp.add(BorderLayout.CENTER, homePanel);
//        cp.add(BorderLayout.WEST, controlPanel);
//        cp.add(BorderLayout.CENTER, control);

//        gamePanel.setUpGame();
//        gamePanel.startGameThread();
    }
}
