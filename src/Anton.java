
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Anton extends ObjetoG{
    
    Handler handler;

    public Anton(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velx;
        y += vely;
        
        colission();
        
        //Movimiento del jugador
        if(handler.isUp())vely = -3;
        else if(!handler.isDown()) vely = 0;
        
        if(handler.isDown()) vely = 3;
        else if(!handler.isUp()) vely = 0;
        
        if(handler.isRight()) velx = 3;
        else if(!handler.isLeft()) velx = 0;
        
        if(handler.isLeft()) velx = -3;
        else if(!handler.isRight()) velx = 0;
        
            
       
    }
    
    private void colission(){
        for(int i = 0; i < handler.obj.size(); i++){
            ObjetoG tempObj = handler.obj.get(i);
            
            if(tempObj.getId() == ID.Block){
                
                if(getBounds().intersects(tempObj.getBounds())){
                   x += velx * -1;
                   y += vely * -1;
                   
                }
            }
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 64, 64);
    }
    
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 63, 64);
    }
    
}
