/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorateroom;
import furniture.Bed;
import java.awt.*;
import java.awt.image.BufferedImage;
import tile.TileManager;
import javax.swing.*;

/**
 *
 * @author amiraanuar
 */
public class CatBed extends Furniture{
    
    
    //Bed bed = new Bed();
    
    Object[][] orientations = new Object[3][3];
    
    public CatBed(){
        orientations[0][0] = 200;
        orientations[0][1] = 200;
        orientations[0][2] = "/resources/furniture/catbed3.png";

        orientations[1][0] = 100;
        orientations[1][1] = 100;
        orientations[1][2] = "/resources/furniture/cattoy1.png";

        xCoordinate = 200;
        yCoordinate  = 400;
        width = (int) orientations[0][0];
        height =(int) orientations[0][1];
        filePathName = (String) orientations[0][2];
        getImage();
        
    }
    
    
    
   
    public void place(){
//        DecorateRoomViewPanel drvp = new DecorateRoomViewPanel();
       // drvp.tileManager.changeBackground();
     

 
        
         
        
    }
    

  
    
    
    
    
}
