package keycontrolaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import playgame.KeyHandler;

/**
 *
 * @author amarabjamal
 */
public class DownReleasedAction extends AbstractAction {
    KeyHandler kh;

    public DownReleasedAction(KeyHandler kh) {
        this.kh = kh;
    }

    public DownReleasedAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kh.downPressed = false;
    }


}
