package keycontrolaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import playgame.KeyHandler;

/**
 *
 * @author amarabjamal
 */
public class RightPressedAction extends AbstractAction {
    KeyHandler kh;

    public RightPressedAction(KeyHandler kh) {
        this.kh = kh;
    }

    public RightPressedAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kh.rightPressed = true;
    }

}
