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
//    private static final JPanel cards = new JPanel(new CardLayout());
    
    CardLayout cardLayout;
    JPanel mainPanel;
    ControlPanel controlPanel;
    GamePanel gamePanel;
    DecoratorPanel decoratorPanel;
    
    public MainFrame() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        controlPanel = new ControlPanel();
        gamePanel = new GamePanel();
        decoratorPanel = new DecoratorPanel();
        mainPanel.add(controlPanel, "control");
        mainPanel.add(gamePanel, "game");
        mainPanel.add(decoratorPanel, "decorator");
        
        //Creating the Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit program if close-window button clicked
        setTitle("Bing Chilling with Calico Cat");  // "super" JFrame sets title
        setSize(960, 700);   // "super" JFrame sets initial size
        setVisible(true);    // "super" JFrame shows
        setLocationRelativeTo(null);
        
//        ControlPanel control = new ControlPanel();
//        control.setVisible(true);
//        DecoratorPanel decorator = new DecoratorPanel();
//        cards.add(control);
//        cards.add(decorator);
        
        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        JMenu m3 = new JMenu("Menu");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);
        
        MenuListener al1 = new MenuListener(){
            @Override
            public void menuSelected(MenuEvent e) {
//                control.setVisible(true);
                controlPanel.setVisible(true);
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
//        m3.addActionListener(al1);
        
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        panel.add(new JLabel("Hello, Player X!"));
        panel.add(new JButton("Start"));
        panel.add(new JButton("Pause"));


        
        // GamePanel gamePanel = new GamePanel();
//        cards.add(gamePanel);
        
        JToggleButton musicToggle = new JToggleButton("Toogle Music");
        panel.add(musicToggle);
        musicToggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button was clicked!");
                BackgroundSound sound =BackgroundSound.getInstance();
                if(sound.getState()==1){
                    gamePanel.stopMusic();
                    sound.setState(2);
                }
                else if(sound.getState()==2){
                    gamePanel.playMusic(0);
                    sound.setState(1);
        }
            }
        });
        
        JButton goGame = new JButton("Go TO Game");
        panel.add(goGame);
        goGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "game");
            }
        });
        
//        panel.add(new JButton(new AbstractAction("\u22b2Prev") {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CardLayout cl = (CardLayout) cards.getLayout();
//                cl.previous(cards);
//            }
//        }));
//        panel.add(new JButton(new AbstractAction("Next\u22b3") {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CardLayout cl = (CardLayout) cards.getLayout();
//                cl.next(cards);
//            }
//        }));
        // HomePanel homePanel = new HomePanel();
        ThemeSwitcherPanel homeButtonPanel = new ThemeSwitcherPanel();


        
        //Adding Components to the frame
        Container cp = getContentPane(); 
        cp.setLayout(new BorderLayout());
//        cp.add(BorderLayout.CENTER,cards);
        cp.add(BorderLayout.NORTH,mb);
//        // cp.add(BorderLayout.CENTER, gamePanel);
        cp.add(BorderLayout.CENTER, homeButtonPanel);
        cp.add(BorderLayout.SOUTH, panel);
//        cp.add(BorderLayout.WEST, control);
//        cp.add(BorderLayout.CENTER, control);
        

        // add(mainPanel);
        
        // gamePanel.setUpGame();
        // gamePanel.startGameThread();
    }
}
