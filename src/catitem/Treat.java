package catitem;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.ViewScreenConfiguration;

/**
 *
 * @author amarabjamal
 */
public class Treat extends CatItem {
    
    public Treat() {
        name = "Treat";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/catitem/treat.png"));
            utilityTool.scaleImage(image, ViewScreenConfiguration.TILE_SIZE/2, ViewScreenConfiguration.TILE_SIZE/2);
        } catch(IOException e) {
            
        }
        collision = true;
    }
}
