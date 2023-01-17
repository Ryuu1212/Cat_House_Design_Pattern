package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import swingdemo.HomePanel;

public class HomeTileManager {
    HomePanel hp;
    Tile[] tile;
    int mapTileNum [][];

    public HomeTileManager(HomePanel hp) {
        this.hp = hp;
        
        tile = new Tile[10]; // array size of 10
        mapTileNum = new int [hp.maxScreenCol][hp.maxScreenRow];
        
        getTileImage();
        loadMap("/resources/maps/map02.txt");
    }
    
    public void loadMap(String filepath) {
        try {
            InputStream is = getClass().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while(col < hp.maxScreenCol && row < hp.maxScreenRow) {
                String line = br.readLine();
                
                while(col < hp.maxScreenCol) {
                    String numbers[] = line.split(" ");
                    
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                    
                    col++;
                }
                
                if(col == hp.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch(Exception e) {
            
        }
    }
    
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
    
    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        JButton themeAButton = new JButton("Theme A");
        themeAButton.setSize(100, 50);
        themeAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Theme A");
                
            }
        });
        
        while(col < hp.maxScreenCol && row < hp.maxScreenRow ) {
            
            int tileNum = mapTileNum[col][row];
            
            g2.drawImage(tile[tileNum].image, x, y, hp.tileSize, hp.tileSize, null); 
            
            col++;
            x += hp.tileSize;
            
            if(col == hp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += hp.tileSize;
            }
        }
        
        
    }
}
