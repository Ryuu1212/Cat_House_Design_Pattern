package swingdemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Background.Background;
import swingdemo.ThemeSwitcherViewPanel;
import tile.HomeTileManager;

public class ThemeSwitcherPanel extends JPanel {
    ThemeSwitcherViewPanel hp;
    
    public ThemeSwitcherPanel() {
        hp = new ThemeSwitcherViewPanel();
        this.add(hp);
        addFactoryChoiceButton();
    }

    public void addFactoryChoiceButton() {
        JButton themeAButton = new JButton("Theme A");
        themeAButton.setSize(100, 50);
        themeAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hp.homeTileManager.changeBackground(1); 
                hp.updateTheme();          
            }
        });
        JButton themeBButton = new JButton("Theme B");
        themeBButton.setSize(100, 50);
        themeBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hp.homeTileManager.changeBackground(2);
                hp.updateTheme();   
            }
        });

        themeAButton.setVisible(true);
        this.add(themeAButton);
        themeBButton.setVisible(true);
        this.add(themeBButton);
        
    }
    
}
