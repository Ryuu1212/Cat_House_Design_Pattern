package keycontrolaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import playgame.KeyHandler;

/**
 *
 * @author amarabjamal
 */
public class RightReleasedAction extends AbstractAction {
    KeyHandler kh;

    public RightReleasedAction(KeyHandler kh) {
        this.kh = kh;
    }

    public RightReleasedAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kh.rightPressed = false;
    }

}
