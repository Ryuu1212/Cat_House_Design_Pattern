package main;

import decorateroom.DecorateRoomViewPanel;
import homemenu.HomeMenuPanel;
import selecttheme.ThemeSwitcherPanel;
import playgame.GamePanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author amarabjamal
 */
public class MainFrame extends JFrame {    
    CardLayout cardLayout;
    JPanel mainPanel;
    HomeMenuPanel homeMenuPanel;
    GamePanel gamePanel;
    DecorateRoomViewPanel decoratorPanel;
    ThemeSwitcherPanel themeSwitcherPanel;
    Sound backgroundSound;
    
    public MainFrame() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        gamePanel = new GamePanel();
        decoratorPanel = new DecorateRoomViewPanel();
        themeSwitcherPanel = new ThemeSwitcherPanel();
        homeMenuPanel = new HomeMenuPanel(mainPanel, cardLayout, gamePanel);
        mainPanel.add(homeMenuPanel, "HomeMenu");
        mainPanel.add(gamePanel, "PlayGame");
        mainPanel.add(decoratorPanel, "DecorateRoom");
        mainPanel.add(themeSwitcherPanel, "SelectTheme");
        
        //Creating the Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit program if close-window button clicked
        setTitle("Bing Chilling with Calico Cat");  // "super" JFrame sets title
        setSize(960, 690);   // "super" JFrame sets initial size 643, 690, 47
        setVisible(true);    // "super" JFrame shows
        setLocationRelativeTo(null);
        setResizable(false);
        
        backgroundSound = BackgroundSound.getInstance();
        backgroundSound.loop();
        
        //Creating the FooterPanel at bottom and adding components
        JPanel FooterPanel = new JPanel();
        //FooterPanel.setBackground(Color.lightGray);
        
        JButton volumeUpButton = new JButton("+");
        JButton volumeDownButton = new JButton("-");
        JButton volumeMuteButton = new JButton("Mute");
        JButton soundPlayButton = new JButton("Stop");
        JSlider volumeSlider = new JSlider(-40, 6);

        //Sound play/pause and volume controls
        FooterPanel.add(soundPlayButton);
        FooterPanel.add(volumeDownButton);
        FooterPanel.add(volumeSlider);
        FooterPanel.add(volumeUpButton);
        FooterPanel.add(volumeMuteButton);
        
        soundPlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(backgroundSound.isPlaying){
                    backgroundSound.stop();
                    backgroundSound.isPlaying = false;
                    soundPlayButton.setText("Play");
                } else {
                    backgroundSound.loop();
                    backgroundSound.isPlaying = true;
                    soundPlayButton.setText("Stop");
                }
            }
        });
        
        volumeUpButton.addActionListener((ActionEvent e) -> {
            backgroundSound.volumeUp(volumeSlider);
        });
        volumeDownButton.addActionListener((ActionEvent e) -> {
            backgroundSound.volumeDown(volumeSlider);
        });
        volumeMuteButton.addActionListener((ActionEvent e) -> {
            backgroundSound.volumeMute(volumeSlider);
            if(backgroundSound.isMute == true) {
                volumeMuteButton.setText("Unmute");
            } else {
                volumeMuteButton.setText("Mute");
            }
        });
        volumeSlider.addChangeListener((ChangeEvent e) -> {
            backgroundSound.currentVolume = volumeSlider.getValue();
            if(backgroundSound.currentVolume == -40) {
                backgroundSound.currentVolume = -80;
            }
            backgroundSound.floatControl.setValue(backgroundSound.currentVolume);
        });
        
        JButton homeMenuButton = new JButton("Home Menu");
        FooterPanel.add(homeMenuButton);
        homeMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "HomeMenu");
            }
        });
        
        //Adding Components to the frame
        Container cp = getContentPane(); 
        cp.setLayout(new BorderLayout());
        cp.add(mainPanel, BorderLayout.CENTER);
        cp.add(FooterPanel, BorderLayout.SOUTH);
    }
}
