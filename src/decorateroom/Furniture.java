/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorateroom;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author amiraanuar
 */
public abstract class Furniture {
    int xCoordinate;
    int yCoordinate;
    int width;
    int height;
    BufferedImage image;
    String filePathName;
    
    public final void drawImage(Graphics2D g2){
        getImage();
        draw( g2);
//        changeOrientation();
      
        
    }
    
//     abstract void  changeOrientation();
        
    
    
      void  draw(Graphics2D g2){
        g2.drawImage(image, xCoordinate, yCoordinate, width, height, null);
    }
    
     void  getImage() {
         try {
             image = ImageIO.read(getClass().getResourceAsStream(filePathName));
         } catch(IOException e) {

         }
     }
     
      void  remove(){
          
      }
}
