
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
        x  += velx;
        y += vely;
        
        //Movimiento del jugador
        if(handler.isUp())vely = -5;
        else if(!handler.isDown()) vely = 0;
        
        if(handler.isDown()) vely = 5;
        else if(!handler.isUp()) vely = 0;
        
        if(handler.isRight()) velx = 5;
        else if(!handler.isLeft()) velx = 0;
        
        if(handler.isLeft()) velx = -5;
        else if(!handler.isRight()) velx = 0;
        
            
       
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 32, 64);
    }
    
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 64);
    }
    
}
