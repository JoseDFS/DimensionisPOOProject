
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
public class Box extends ObjetoG{

    public Box(int x, int y, ID id) {
        super(x, y, id);
        
    }

   
    @Override
    public void tick() {
        x += velx;
        y += vely;
    }

    
    @Override
    public void render(Graphics g) {
       g.setColor(Color.black);
       g.fillRect(x, y, 32, 32);
    }

    
    @Override
    public Rectangle getBounds(){
        return null;
        
    }
    
}
