package main;

import javax.swing.SwingUtilities;

/**
 *
 * @author amarabjamal
 */
public class MainDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new MainFrame();  // Let the constructor do the job
         }
      });
    }

}
