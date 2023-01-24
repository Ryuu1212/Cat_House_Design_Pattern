package selecttheme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThemeSwitcherPanel extends JPanel {
    ThemeSwitcherViewPanel themeSwitcherViewPanel;

    public ThemeSwitcherPanel() {
        themeSwitcherViewPanel = new ThemeSwitcherViewPanel();
        this.add(themeSwitcherViewPanel);
        addFactoryChoiceButton();
    }

    public final void addFactoryChoiceButton() {
        JLabel themeLabel = new JLabel("Select your theme: ");
        
        JButton themeAButton = new JButton("Classic");
        themeAButton.setSize(100, 50);
        themeAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themeSwitcherViewPanel.tileManager.changeBackground(1); 
                themeSwitcherViewPanel.updateTheme();          
            }
        });
        JButton themeBButton = new JButton("Cherry Blossom");
        themeBButton.setSize(100, 50);
        themeBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themeSwitcherViewPanel.tileManager.changeBackground(2);
                themeSwitcherViewPanel.updateTheme();   
            }
        });

        this.add(themeLabel);
        themeAButton.setVisible(true);
        this.add(themeAButton);
        themeBButton.setVisible(true);
        this.add(themeBButton);
    }
}
