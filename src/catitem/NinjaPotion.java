package catitem;

import java.io.IOException;
import javax.imageio.ImageIO;
import playgame.GamePanel;

/**
 *
 * @author amarabjamal
 */
public class NinjaPotion extends CatItem {
    
    public NinjaPotion(GamePanel gp) {
        name = "Ninja Potion";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/catitem/ninja_potion.png"));
            utilityTool.scaleImage(image, gp.tileSize/2, gp.tileSize/2);
        } catch(IOException e) {
            
        }
        collision = true;
    }
}
