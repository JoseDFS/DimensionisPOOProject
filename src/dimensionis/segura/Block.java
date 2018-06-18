package dimensionis.segura;


import dimensionis.segura.ObjetoGInterface.ObjetoG;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Block extends ObjetoG {

    public Block(int x, int y, ID id) {
        super(x, y, id);
    }

    
    public void tick() {
        
    }

   
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 32, 32);
    }

   
    public Rectangle getBounds() {
        return new Rectangle(x, y, 31, 30);
    }
    
}
