
import java.awt.Graphics;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Handler {
    
    LinkedList<ObjetoG> obj = new LinkedList<ObjetoG>();
    
    public void tick(){
        for(int i=0; i < obj.size(); i++){
            ObjetoG tempObj = obj.get(i);
            
            tempObj.tick();
        }
    }
    
    public void render(Graphics g){
        for(int i=0; i < obj.size(); i++){
            ObjetoG tempObj = obj.get(i);
            
            tempObj.render(g);
        }
    }
    
    public void addObj(ObjetoG tempObj){
        obj.add(tempObj);
    }
    
    public void removeObject(ObjetoG tempObj){
        obj.remove(tempObj);
    }
}
