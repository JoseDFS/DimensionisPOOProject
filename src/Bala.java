
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
public class Bala extends ObjetoG {

    private Handler handler;

    public Bala(int x, int y, ID id) {
        super(x, y, id);
        this.handler = handler;
    }

    Bala(int x, int y, ID id, Handler handler, int mx, int my) {
        super(x, y, id);
        this.handler = handler;

        velx = (mx - x) / 10;
        vely = (my - y) / 10;
    }

    @Override
    public void tick() {
        x += velx;
        y += vely;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y, 8, 8);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 8, 8);

    }

}
