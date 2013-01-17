/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLibrary;

import java.awt.Graphics;
import java.awt.Point;


public class Sprite implements Processable, Paintable{

    private SpImage sprite;
    private Processus proc;
    private Point location;
    private int width;
    private int height;
    private int hgap;
    private int vgap;
    private int curpos;
    private boolean animated;
    //private int maxpos;
    
    
    public Sprite(String sprite_path, int w, int h){
        sprite = new SpImage(sprite_path);
        proc = null;
        animated = false;
        curpos = 0;
        vgap = 0;
        hgap = 0;
        width = w;
        height = h;
        location = new Point(0, 0);
        
        //if(isAnimated())
        //    proc = new Processus(this);
    }
    
    //public Image getSprite(int i){
        
    //}
    
    public boolean isAnimated(){
        return animated;
    }
    
    @Override
    public void process() {
        
    }

    @Override
    public void start() {
        if(isAnimated()){
            if(proc!=null)
                proc.stop();
            proc = new Processus(this);
            proc.start();
        }
    }

    @Override
    public void pause() {
        if(proc!=null)
            proc.pause();
    }

    @Override
    public void resume() {
        if(proc!=null)
            proc.resume();
    }

    @Override
    public void stop() {
        if(proc!=null)
            proc.stop();
    }

    public void setLocation(int x, int y){
       location = new Point(x, y); 
    }
    
    /*@Override
    public void paint(Graphics g) {
        g.drawImage(sprite.getImage(), location.x, location.y, null);
    }*/

    @Override
    public void paint(org.newdawn.slick.Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void repaint() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
