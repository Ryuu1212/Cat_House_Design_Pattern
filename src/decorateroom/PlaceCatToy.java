/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorateroom;
import furniture.CatToy;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author amiraanuar
 */
public class PlaceCatToy implements Command {
    
    CatToy catToy;
        JFrame j = new JFrame();
    JPanel p = new JPanel();
    PlaceCatToy(CatToy catToy){
        this.catToy=catToy;
    }
    @Override
    public void execute(){
     
    
    }
    
    @Override
    public void undo(){
        
    }
}
