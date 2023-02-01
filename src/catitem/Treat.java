package catitem;

import java.io.IOException;
import javax.imageio.ImageIO;
import playgame.GamePanel;

/**
 *
 * @author amarabjamal
 */
public class Treat extends CatItem {
    
    public Treat(GamePanel gp) {
        name = "Treat";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/catitem/treat.png"));
            utilityTool.scaleImage(image, gp.tileSize/2, gp.tileSize/2);
        } catch(IOException e) {
            
        }
        collision = true;
    }
}
