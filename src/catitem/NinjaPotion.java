package catitem;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.ViewScreenConfiguration;

/**
 *
 * @author amarabjamal
 */
public class NinjaPotion extends CatItem {
    
    public NinjaPotion() {
        name = "Ninja Potion";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/catitem/ninja_potion.png"));
            utilityTool.scaleImage(image, ViewScreenConfiguration.TILE_SIZE/2, ViewScreenConfiguration.TILE_SIZE/2);
        } catch(IOException e) {
            
        }
        collision = true;
    }
}
