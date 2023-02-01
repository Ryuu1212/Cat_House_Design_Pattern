/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furniture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
/**
 *
 * @author amiraanuar
 */
public class Bed {
     final int x = 125;
     final int y = 285;
     
     Graphics2D g2;
     public BufferedImage image;
      //String filepathWindow = "/resources/furniture/catbed.png";
      //String name = "Bed";
     
     //public void draw(Graphics2D g2){
     //    g2.drawImage(image, x,y, 150,150,null);
     //}
     
     public Bed() {
         

     }
     
     public void getImage(){
         try {
             image = ImageIO.read(getClass().getResourceAsStream("/resources/furniture/catbed.png"));
         } catch(IOException e) {

         }
     }
     
    
     
     
}
