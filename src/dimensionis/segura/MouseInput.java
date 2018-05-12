package dimensionis.segura;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class MouseInput extends MouseAdapter {

    private Handler handler;

    public MouseInput(Handler handler) {
        this.handler = handler;
    }
}
   /*public void mousePressed(MouseEvent e) {
        int mx = (int) e.getX();
        int my = (int) e.getY();
        
        for (int i = 0; i < handler.obj.size(); i++) {
            ObjetoG tempObj = handler.obj.get(i);

            if (tempObj.getId() == ID.Player) {
                handler.addObj(new Bala(tempObj.getX() + 16, tempObj.getY(), ID.Bala, handler, mx, my));
            }
        }
    }
*/