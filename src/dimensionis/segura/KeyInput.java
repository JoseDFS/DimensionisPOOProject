package dimensionis.segura;

import dimensionis.segura.ObjetoGInterface.ObjetoG;
import dimensionis.segura.spriteAd.SpriteSheet;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;
    private Game game;
    private boolean shoot = false;
    private boolean dash = false;
    private SpriteSheet ss;

    public KeyInput(Handler handler, Game game, SpriteSheet ss) {
        this.handler = handler;
        this.game = game;
        this.ss = ss;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (game.State == Game.STATE.Game) {

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
                    if (key == KeyEvent.VK_SPACE && !dash) {
                        handler.setSD(true);
                        dash = true;

                    }

                    if (key == KeyEvent.VK_DOWN && !shoot) {
                        shoot = true;
                        handler.addObj(new Bala(tempObj.getX() + 12, tempObj.getY() + 12, ID.Bala, handler, 0, 10, ss));

                    } else if (key == KeyEvent.VK_UP && !shoot) {
                        shoot = true;
                        handler.addObj(new Bala(tempObj.getX() + 12, tempObj.getY() + 12, ID.Bala, handler, 0, -10, ss));
                    } else if (key == KeyEvent.VK_RIGHT && !shoot) {
                        shoot = true;
                        handler.addObj(new Bala(tempObj.getX(), tempObj.getY() + 32, ID.Bala, handler, 10, 0, ss));
                    } else if (key == KeyEvent.VK_LEFT && !shoot) {
                        shoot = true;
                        handler.addObj(new Bala(tempObj.getX() + 12, tempObj.getY() + 32, ID.Bala, handler, -10, 0, ss));
                    }

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
                if (key == KeyEvent.VK_SPACE) {
                    handler.setSD(false);
                    dash = false;
                }

                //Disparo con las flechas 
                if (key == KeyEvent.VK_DOWN) {
                    shoot = false;

                } else if (key == KeyEvent.VK_UP) {
                    shoot = false;
                } else if (key == KeyEvent.VK_RIGHT) {
                    shoot = false;
                } else if (key == KeyEvent.VK_LEFT) {
                    shoot = false;
                }
            }
        }
    }
}
