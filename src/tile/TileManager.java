package tile;

import background.Background;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.ViewScreenConfiguration;
import selecttheme.AbstractThemeFactory;
import selecttheme.ThemeAFactory;
import selecttheme.ThemeBFactory;
import window.Window;

/**
 *
 * @author amarabjamal
 */
public final class TileManager {
    private static final TileManager uniqueInstance = new TileManager();
    Tile[] tile;
    int mapTileNum[][];
    AbstractThemeFactory themeFactory;
    Background background;
    Window window;
    String filepath;
    
    private TileManager() {
        themeFactory = new ThemeAFactory();
        background = themeFactory.createBackground();
        filepath = background.getfilePath();
        window = themeFactory.createWindow();
        tile = new Tile[15];
        mapTileNum = new int [ViewScreenConfiguration.MAX_SCREEN_COL][ViewScreenConfiguration.MAX_SCREEN_ROW];
        
        getTileImage();
        loadMap();
    }
    
    public static TileManager getInstance() {
        return uniqueInstance;
    }
    
    public void changeBackground(int i) {
        if (i == 2) {
            themeFactory = new ThemeBFactory();
        } else {
            themeFactory = new ThemeAFactory();
        }
        background = themeFactory.createBackground();
        window = themeFactory.createWindow();
        filepath = background.getfilePath();
        loadMap();
    }
    
    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while(col < ViewScreenConfiguration.MAX_SCREEN_COL && row < ViewScreenConfiguration.MAX_SCREEN_ROW) {
                String line = br.readLine();
                
                while(col < ViewScreenConfiguration.MAX_SCREEN_COL) {
                    String numbers[] = line.split(" ");
                    
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                    
                    col++;
                }
                
                if(col == ViewScreenConfiguration.MAX_SCREEN_COL) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch(IOException | NumberFormatException e) {
            
        }
    }
    
    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/brown_tile.png"));
            tile[0].label = "Brown floor";
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/beidge_wall.png"));
            tile[1].label = "Beidge wall";
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/brown_floor_with_pawprints.png"));
            tile[3].label = "Brown floor with paw prints";
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/beidge_floor.png"));
            tile[4].label = "Beidge floor";
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/beidge_floor_with_pawprints.png"));
            tile[5].label = "Beidge floor with paw prints";
            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/sakura_wall_footer_bottom.png"));
            tile[6].label = "Sakura wall footer bottom";
            
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/sakura_wall_paw_rainbow.png"));
            tile[7].label = "Sakura wall with rainbow paw print";
            
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/sakura_wall_pink_paw_small.png"));
            tile[8].label = "Sakura wall with pink paw print";
            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/sakura_wall.png"));
            tile[9].label = "Sakura wall";
            
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/sakura_wall_footer_top.png"));
            tile[10].label = "Sakura wall footer top";   
            
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/classic_wall_footer_top.png"));
            tile[11].label = "Classic wall footer top";   
            
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/classic_wall_footer_bottom.png"));
            tile[12].label = "Classic wall footer bottom";             
        } catch (IOException e) {
            
        }
    }
    
    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        
        while(col < ViewScreenConfiguration.MAX_SCREEN_COL && row < ViewScreenConfiguration.MAX_SCREEN_ROW ) {
            
            int tileNum = mapTileNum[col][row];
            
            g2.drawImage(tile[tileNum].image, x, y, ViewScreenConfiguration.TILE_SIZE, ViewScreenConfiguration.TILE_SIZE, null); 
            
            col++;
            x += ViewScreenConfiguration.TILE_SIZE;
            
            if(col == ViewScreenConfiguration.MAX_SCREEN_COL) {
                col = 0;
                x = 0;
                row++;
                y += ViewScreenConfiguration.TILE_SIZE;
            }
        }
        
        window.draw(g2);
        
    }
}
