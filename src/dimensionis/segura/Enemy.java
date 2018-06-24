/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dimensionis.segura;

import dimensionis.segura.ObjetoGInterface.ObjetoG;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Enemy extends ObjetoG {

    private Handler handler;

    Random r = new Random();
    int choose = 0;
    int vida = 100;

    public Enemy(int x, int y, ID id, Handler handler) {

        super(x, y, id);

        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velx;
        y += vely;

        choose = r.nextInt(250);

        for (int i = 0; i < handler.obj.size(); i++) {
            ObjetoG tempObj = handler.obj.get(i);

            if (tempObj.getId() == ID.Block || (tempObj != this && tempObj.getId() == ID.Enemy)) {
                if (getBoundsB().intersects(tempObj.getBounds())) {
                    x += (velx * 1) * -1;
                    y += (vely * 1) * -1;
                    velx *= -1;
                    vely *= -1;
                } else if (choose == 11 ) {
                    velx = (r.nextInt(1 - -1) +  (r.nextInt(1 - -3)/3)* r.nextInt(1));
                    vely = (r.nextInt(1 - -1) + r.nextInt(0 - -1)* r.nextInt(1));
                }
            }
            if(tempObj.getId() == ID.Bala){
                if(getBounds().intersects(tempObj.getBounds())){
                    vida -=10;
                    handler.removeObject(tempObj);
                }
            }

        }
        
        if(vida <=0) handler.removeObject(this);

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {

        return new Rectangle(x, y, 32, 32);
    }

    public Rectangle getBoundsB() {

        return new Rectangle(x - 16, y - 16, 64, 64);
    }

}
