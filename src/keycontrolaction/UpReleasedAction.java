package keycontrolaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import playgame.KeyHandler;

/**
 *
 * @author amarabjamal
 */
public class UpReleasedAction extends AbstractAction {
    KeyHandler kh;

    public UpReleasedAction(KeyHandler kh) {
        this.kh = kh;
    }

    public UpReleasedAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kh.upPressed = false;
    }

}
