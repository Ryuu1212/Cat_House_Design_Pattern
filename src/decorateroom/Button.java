/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorateroom;

/**
 *
 * @author amiraanuar
 */
public class Button {
    Command slot;
    
    public void setCommand(Command command){
        slot = command;
    }
    
    public void addButtonWasPressed(){
        slot.execute();
    }
    
    public void deleteButtonWasPressed(){
        slot.undo();
    }
}
