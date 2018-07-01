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
public class Block1 extends ObjetoG {

    public Block1(int x, int y, ID id,SpriteSheet ss) {
        super(x, y, id,ss);
    }

    
    public void tick() {
        
    }

   
    public void render(Graphics g) {
        
    }

   
    public Rectangle getBounds() {
        return new Rectangle(x, y, 31, 30);
    }
    
}
