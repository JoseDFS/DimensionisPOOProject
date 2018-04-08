
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jose Segura <com.segura.jd>
 */
public class Game extends Canvas implements Runnable {
    
    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;
    
    public Game() {
        Window window = new Window(1000, 563, "Dimensionis", this);
        start();
        
        handler = new Handler();
        
        handler.addObj(new Box(100,100,ID.Block));
    }

    @Override
    public void run() {
        //Bucle de refrescamiento de frames programado por Jebb el creador de Minecraft
        isRunning = true;
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                //updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
                //updates = 0;
            }
        }
        stop();
    }

    public void tick(){
        handler.tick();
    }
    
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        /////// Aca pa dibujar cosas en pantalla///////
        
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 1000, 563);
        
        handler.render(g); //pongo el render de los objetos aqui para q esten por encima del fondo
        
        
        ////////////////////////////////////////////////
        g.dispose();
        bs.show();
    }
    
    public void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String... args) {
        Game game = new Game();
    }
}
