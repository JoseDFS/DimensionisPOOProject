package dimensionis.segura;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
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
    private BufferedImage level = null;
    
    public Game() {
        Window window = new Window(1600, 768, "Dimensionis", this);
        start();
        
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput(handler));
        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/Level1.png");
        
        loadlevel(level);
    }

  
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
        
        g.setColor(Color.red);
        g.fillRect(0, 0, 1600, 768);
        
       
        
        handler.render(g); //pongo el render de los objetos aqui para q esten por encima del fondo
        
        
        ////////////////////////////////////////////////
        g.dispose();
        bs.show();
    }
    
    //Cargando nivel
    private void loadlevel(BufferedImage image){
        int h = image.getHeight();
        int w = image.getWidth();
        
        for(int xx = 0; xx < w; xx++){
            for(int yy = 0; yy < h; yy++){
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                
                if(red == 255)
                    handler.addObj(new Block(xx*32, yy*32, ID.Block));
                
                if(blue == 255)
                   handler.addObj(new Anton(xx*32, yy*32, ID.Player,handler)); 
            }
        }
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
