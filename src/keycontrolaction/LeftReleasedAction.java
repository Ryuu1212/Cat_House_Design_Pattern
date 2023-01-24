package keycontrolaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import playgame.KeyHandler;

/**
 *
 * @author amarabjamal
 */
public class LeftReleasedAction extends AbstractAction {
    KeyHandler kh;

    public LeftReleasedAction(KeyHandler kh) {
        this.kh = kh;
    }

    public LeftReleasedAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kh.leftPressed = false;
    }


}
