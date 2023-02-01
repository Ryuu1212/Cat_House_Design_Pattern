package catitem;

import java.io.IOException;
import javax.imageio.ImageIO;
import playgame.GamePanel;

/**
 *
 * @author amarabjamal
 */
public class Poison extends CatItem {

    public Poison(GamePanel gp) {
        name = "Poison";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/catitem/bomb.png"));
            utilityTool.scaleImage(image, gp.tileSize/2, gp.tileSize/2);
        } catch(IOException e) {
            
        }
        collision = true;
    }
}
