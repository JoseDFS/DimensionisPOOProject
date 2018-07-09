package dimensionis.segura;

import dimensionis.segura.Handler;
import dimensionis.segura.ID;
import dimensionis.segura.ObjetoGInterface.ObjetoG;
import dimensionis.segura.animacion.Animation;
import dimensionis.segura.spriteAd.SpriteSheet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Anton extends ObjetoG {

    Handler handler;
    private BufferedImage[] anton_sprite = new BufferedImage[24];
    Animation animAbajo;
    Animation animArriba;
    Animation animDerecha;
    Animation animIzquierda;
    int dir = 0;
    private Game game;
    boolean run1 = true;

    public Anton(int x, int y, ID id, Handler handler, SpriteSheet ss, Game game) {
        super(x, y, id, ss);
        velx = 0;
        vely = 0;

        this.handler = handler;
        this.game = game;
        //Abajo
        anton_sprite[0] = ss.grabbImage(1, 1, 32, 64);
        anton_sprite[1] = ss.grabbImage(2, 1, 32, 64);
        anton_sprite[2] = ss.grabbImage(3, 1, 32, 64);
        anton_sprite[3] = ss.grabbImage(4, 1, 32, 64);
        anton_sprite[4] = ss.grabbImage(5, 1, 32, 64);
        anton_sprite[5] = ss.grabbImage(6, 1, 32, 64);

        //Arriba 
        anton_sprite[6] = ss.grabbImage(1, 2, 32, 64);
        anton_sprite[7] = ss.grabbImage(2, 2, 32, 64);
        anton_sprite[8] = ss.grabbImage(3, 2, 32, 64);
        anton_sprite[9] = ss.grabbImage(4, 2, 32, 64);
        anton_sprite[10] = ss.grabbImage(5, 2, 32, 64);
        anton_sprite[11] = ss.grabbImage(6, 2, 32, 64);

        //Derecha
        anton_sprite[12] = ss.grabbImage(1, 3, 32, 64);
        anton_sprite[13] = ss.grabbImage(2, 3, 32, 64);
        anton_sprite[14] = ss.grabbImage(3, 3, 32, 64);
        anton_sprite[15] = ss.grabbImage(4, 3, 32, 64);
        anton_sprite[16] = ss.grabbImage(5, 3, 32, 64);
        anton_sprite[17] = ss.grabbImage(6, 3, 32, 64);

        //Izquierda
        anton_sprite[18] = ss.grabbImage(1, 4, 32, 64);
        anton_sprite[19] = ss.grabbImage(2, 4, 32, 64);
        anton_sprite[20] = ss.grabbImage(3, 4, 32, 64);
        anton_sprite[21] = ss.grabbImage(4, 4, 32, 64);
        anton_sprite[22] = ss.grabbImage(5, 4, 32, 64);
        anton_sprite[23] = ss.grabbImage(6, 4, 32, 64);

        animAbajo = new Animation(5, anton_sprite[0], anton_sprite[1], anton_sprite[2], anton_sprite[3], anton_sprite[4], anton_sprite[5]);
        animArriba = new Animation(5, anton_sprite[6], anton_sprite[7], anton_sprite[8], anton_sprite[9], anton_sprite[10], anton_sprite[11]);
        animDerecha = new Animation(5, anton_sprite[12], anton_sprite[13], anton_sprite[14], anton_sprite[15], anton_sprite[16], anton_sprite[17]);
        animIzquierda = new Animation(5, anton_sprite[18], anton_sprite[19], anton_sprite[20], anton_sprite[21], anton_sprite[22], anton_sprite[23]);

    }

    @Override
    public void tick() {
        x += velx;
        y += vely;

        colision();

        //Movimiento del jugador
        if (handler.isUp()) {
            animArriba.runAnimation();
            dir = 1;
            if (handler.isSD() && game.energia > 0) {
                vely = -7;
                game.energia--;
            } else {
                vely = -3;
            }
        } else if (!handler.isDown()) {
            vely = 0;
        }

        if (handler.isDown()) {
            animAbajo.runAnimation();
            if (handler.isSD() && game.energia > 0) {
                vely = 7;
                game.energia--;
            } else {
                vely = 3;
            }
            dir = 2;
        } else if (!handler.isUp()) {
            vely = 0;
        }

        if (handler.isRight()) {
            animDerecha.runAnimation();
            dir = 3;
            if (handler.isSD() && game.energia > 0) {
                velx = 7;
                game.energia--;
            } else {
                velx = 3;
            }
        } else if (!handler.isLeft()) {
            velx = 0;
        }

        if (handler.isLeft()) {
            animIzquierda.runAnimation();
            if (handler.isSD() && game.energia > 0) {
                velx = -7;
                game.energia--;
            } else {
                velx = -3;
            }
            dir = 4;
        } else if (!handler.isRight()) {
            velx = 0;
        }
        if (game.vida <= 0) {
            handler.removeObject(this);
        }

    }

    private void colision() {
        for (int i = 0; i < handler.obj.size(); i++) {
            ObjetoG tempObj = handler.obj.get(i);

            if (tempObj.getId() == ID.Block) {

                if (getBounds().intersects(tempObj.getBounds())) {
                    x += velx * -1;
                    y += vely * -1;

                }
            }

            if (tempObj.getId() == ID.Enemy) {

                if (getBounds().intersects(tempObj.getBounds())) {
                    game.vida -= 5;

                    x += velx * -2;
                    y += vely * -2;

                }
            }

            if (tempObj.getId() == ID.Enemy) {

                if (getBounds().intersects(tempObj.getBounds())) {
                    game.vida -= 10;

                    x += velx * -2;
                    y += vely * -2;

                }
            }

            if (tempObj.getId() == ID.Boss) {

                if (getBounds().intersects(tempObj.getBounds())) {
                    game.vida -= 5;

                    x += velx * -1;
                    y += vely * -1;

                }
            }

            if (tempObj.getId() == ID.Portal) {

                if (getBounds().intersects(tempObj.getBounds())) {
                    game.pasarNivel = false;
                    handler.SwitchLevel();

                }
            }
            if (tempObj.getId() == ID.BalaEnemy) {

                if (getBounds().intersects(tempObj.getBounds())) {

                    game.energia = 0;

                }
            }

        }
    }

    @Override
    public void render(Graphics g) {

        if (velx == 0 && vely == 0) {
            g.drawImage(anton_sprite[0], x, y, null);
        } else {

            if (dir == 1) {
                animArriba.drawAnimation(g, x, y, 0);

            }

            if (dir == 2) {
                animAbajo.drawAnimation(g, x, y, 0);

            }

            if (dir == 3) {
                animDerecha.drawAnimation(g, x, y, 0);

            }

            if (dir == 4) {
                animIzquierda.drawAnimation(g, x, y, 0);
            }

        }

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 64);
    }

}
