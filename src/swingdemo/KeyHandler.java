package swingdemo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author amarabjamal
 */
public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W) {
            upPressed = true;
            System.out.println("W pressed");
        }
        if(code == KeyEvent.VK_S) {
            downPressed = true;
            System.out.println("S pressed");
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = true;
            System.out.println("A pressed");
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = true;
            System.out.println("D pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }

}
