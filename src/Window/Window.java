package Window;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;

public abstract class Window {
    // coordinate
    final int x = 100;
    final int y = 100;
    public BufferedImage image;
    String filepathWindow;
    String name;

    public void draw(Graphics2D g2) {
        g2.drawImage(image, x, y, 100, 100, null);
    }

    public void getImage() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream(filepathWindow));
        } catch(IOException e) {
            
        }
    }


}
