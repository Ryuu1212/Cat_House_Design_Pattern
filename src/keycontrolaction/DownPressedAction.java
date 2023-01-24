package keycontrolaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import playgame.KeyHandler;

/**
 *
 * @author amarabjamal
 */
public class DownPressedAction extends AbstractAction {
    KeyHandler kh;

    public DownPressedAction(KeyHandler kh) {
        this.kh = kh;
    }

    public DownPressedAction() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kh.downPressed = true;
    }

}
