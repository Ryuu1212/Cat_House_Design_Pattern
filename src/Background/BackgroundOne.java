package Background;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import swingdemo.HomePanel;
import tile.Tile;

public class BackgroundOne implements Background{
    Tile[] tile;
    int mapTileNum [][];
    
    
    @Override
    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/brown_tile.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/beidge_wall.png"));
            tile[1].collision = true;
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/water.png"));
            tile[2].collision = true;
        } catch (IOException e) {
            
        }
    }
    
    @Override
    public void setTileMapFilePath() {
        // TODO Auto-generated method stub
        
    }
    
}
