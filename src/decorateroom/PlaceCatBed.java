/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorateroom;




/**
 *
 * @author amiraanuar
 */
public class PlaceCatBed implements Command {
    CatBed catBed;
   
    
    
    public PlaceCatBed(CatBed catBed){
        this.catBed = catBed;
    }
    
    @Override
    public void execute(){
        catBed.place();
        
    }
    
    @Override
    public void undo(){
        catBed.remove();
    }
    
    


}
