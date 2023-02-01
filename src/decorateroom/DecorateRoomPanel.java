/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorateroom;

import furniture.Bed;
import furniture.CatToy;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author amiraanuar
 */
public class DecorateRoomPanel extends JPanel {
    DecorateRoomViewPanel decorateroomviewpanel;
    Button button = new Button();
    CatBed cb = new CatBed();
    CatToy ct = new CatToy();
    
    public DecorateRoomPanel(){
        decorateroomviewpanel = new DecorateRoomViewPanel();
        this.add(decorateroomviewpanel);
        addButton();
    }
    
    public final void addButton(){
        JLabel furnitureLabel = new JLabel("Choose your actions:");
        
        JButton addBed = new JButton("Add Bed");
        addBed.setSize(50,50);
        addBed.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Graphics g = decorateroomviewpanel.getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                BufferedImage image;
                try {
                    
                    image = ImageIO.read(getClass().getResourceAsStream("/resources/furniture/catbed.png"));
                    g2.drawImage(image, 200, 300,200,200, null);
                } catch (IOException ex) {
                    Logger.getLogger(DecorateRoomPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                button.setCommand(new PlaceCatBed(cb));
                button.addButtonWasPressed();
            }
        });
        
        JButton rotateBed = new JButton("Rotate Bed");
        rotateBed.setSize(50,50);
        rotateBed.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
                Graphics g = decorateroomviewpanel.getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                BufferedImage image;
                if (e.getClickCount()== 2 & !e.isConsumed()){
                try {
                    image = ImageIO.read(getClass().getResourceAsStream("/resources/furniture/nocatbed.png"));
             g2.drawImage(image, 0, 0, null);
                    image = ImageIO.read(getClass().getResourceAsStream("/resources/furniture/catbed2.png"));
                    g2.drawImage(image, 200, 300,200,200, null);
                } catch (IOException ex) {
                    Logger.getLogger(DecorateRoomPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                if (e.getClickCount()== 1 & !e.isConsumed()){
                try {
                     image = ImageIO.read(getClass().getResourceAsStream("/resources/furniture/nocatbed.png"));
             g2.drawImage(image, 0, 0, null);
                    image = ImageIO.read(getClass().getResourceAsStream("/resources/furniture/catbed3.png"));
                    g2.drawImage(image, 200, 300,200,200, null);
                } catch (IOException ex) {
                    Logger.getLogger(DecorateRoomPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                button.setCommand(new PlaceCatBed(cb));
                button.addButtonWasPressed();
            }
        });
        
        JButton addToy = new JButton("Add Toy");
        addToy.setSize(50,50);
        addToy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Graphics g = decorateroomviewpanel.getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                BufferedImage image2;
                try {
                    
                    image2 = ImageIO.read(getClass().getResourceAsStream("/resources/furniture/cattoy1.png"));
                    g2.drawImage(image2, 700, 400,100,100, null);
                } catch (IOException ex) {
                    Logger.getLogger(DecorateRoomPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                button.setCommand(new PlaceCatToy(ct));
                button.addButtonWasPressed();
            }
        });
        JButton resetImg = new JButton("Reset");
        resetImg.setSize(50,50);
        resetImg.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 Graphics g = decorateroomviewpanel.getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                BufferedImage image;
                try {
                    
                    image = ImageIO.read(getClass().getResourceAsStream("/resources/furniture/nocatbed.png"));
             g2.drawImage(image, 0, 0, null);

                } catch (IOException ex) {
                    Logger.getLogger(DecorateRoomPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                button.setCommand(new PlaceCatToy(ct));
                button.deleteButtonWasPressed();
            }
        });
//        JButton rotateToy = new JButton("Rotate Toy");
//        rotateToy.setSize(50,50);
//        
        this.add(furnitureLabel);
        //add bed button
        addBed.setVisible(true);
        this.add(addBed);
        //remove bed button
       
        rotateBed.setVisible(true);
        this.add(rotateBed);
        //add toy button
        addToy.setVisible(true);
        this.add(addToy);
        //remove toy button
        resetImg.setVisible(true);
        this.add(resetImg);
//         rotateToy.setVisible(true);
//        this.add(rotateToy);
        
    }
}
