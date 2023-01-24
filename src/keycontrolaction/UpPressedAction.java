package keycontrolaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import playgame.KeyHandler;

/**
 *
 * @author amarabjamal
 */
public class UpPressedAction extends AbstractAction {
    KeyHandler kh;

    public UpPressedAction() {
        
    }
    
    public UpPressedAction(KeyHandler kh) {
        this.kh = kh;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kh.upPressed = true;
    }
    
}
