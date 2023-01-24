package keycontrolaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import playgame.KeyHandler;

/**
 *
 * @author amarabjamal
 */
public class LeftPressedAction extends AbstractAction {
    KeyHandler kh;

    public LeftPressedAction(KeyHandler kh) {
        this.kh = kh;
    }

    public LeftPressedAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kh.leftPressed = true;
    }

}
