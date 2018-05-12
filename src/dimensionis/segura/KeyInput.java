package dimensionis.segura;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class KeyInput extends KeyAdapter {

    Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.obj.size(); i++) {
            ObjetoG tempObj = handler.obj.get(i);

            if (tempObj.getId() == ID.Player) {
                //Movimiento ASWD
                if (key == KeyEvent.VK_W) {
                    handler.setUp(true);
                }
                if (key == KeyEvent.VK_A) {
                    handler.setLeft(true);
                }
                if (key == KeyEvent.VK_S) {
                    handler.setDown(true);
                }
                if (key == KeyEvent.VK_D) {
                    handler.setRight(true);
                }

                

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.obj.size(); i++) {
            ObjetoG tempObj = handler.obj.get(i);

            if (tempObj.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {
                    handler.setUp(false);
                }
                if (key == KeyEvent.VK_A) {
                    handler.setLeft(false);
                }
                if (key == KeyEvent.VK_S) {
                    handler.setDown(false);
                }
                if (key == KeyEvent.VK_D) {
                    handler.setRight(false);
                }
                
                //Disparo con las flechas 
                
                if (key == KeyEvent.VK_DOWN) {
                    handler.addObj(new Bala(tempObj.getX() + 32, tempObj.getY() + 64, ID.Bala, handler, 0, 10));
                }
                if (key == KeyEvent.VK_UP) {
                    handler.addObj(new Bala(tempObj.getX() + 32, tempObj.getY(), ID.Bala, handler, 0, -10));
                }
                if (key == KeyEvent.VK_RIGHT) {
                    handler.addObj(new Bala(tempObj.getX() + 64, tempObj.getY() + 32, ID.Bala, handler, 10, 0));
                }
                if (key == KeyEvent.VK_LEFT) {
                    handler.addObj(new Bala(tempObj.getX(), tempObj.getY() + 32, ID.Bala, handler, -10, 0));
                }
            }
        }
    }
}
