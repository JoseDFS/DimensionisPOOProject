package dimensionis.segura;


import dimensionis.segura.ObjetoGInterface.ObjetoG;
import dimensionis.segura.spriteAd.SpriteSheet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Block extends ObjetoG {

    public Block(int x, int y, ID id,SpriteSheet ss) {
        super(x, y, id,ss);
    }

    
    public void tick() {
        
    }

   
    public void render(Graphics g) {
       
    }

   
    public Rectangle getBounds() {
        return new Rectangle(x, y, 34, 38);
    }
    
}
