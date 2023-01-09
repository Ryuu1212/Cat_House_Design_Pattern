package catitem;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author amarabjamal
 */
public class Treat extends CatItem {
    public Treat() {
        name = "Treat";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/catitem/treat.png"));
        } catch(IOException e) {
            
        }
        collision = true;
    }
}
