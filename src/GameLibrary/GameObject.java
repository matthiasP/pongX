/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLibrary;

import java.awt.Component;
import java.awt.Dimension;
//import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * 
 */
public abstract class GameObject /*extends Component*/ implements Processable, Paintable {
    
    private Processus proc;
    
    //protected GameContainer gameParent;
    protected Rectangle gameParent;
    //protected GameContainer parent;
    private Component icon;
    private Point location;
    private Dimension size;
    protected boolean solid;
    private Sprite image;
    //protected boolean movable;
    
    
    public GameObject(){
        super();
        proc = new Processus(this);
        icon = null;
        solid = false;
        image = null;
        location = new Point();
        size = new Dimension();
        gameParent = new Rectangle(0,0,800,600);
    }
    
    public GameObject(boolean s){
        //super();
        proc = new Processus(this);
        icon = null;
        solid = s;
        image = null;
        location = new Point();
        size = new Dimension();
        gameParent = new Rectangle(0,0,800,600);
    }
    
    /*protected void setIcon(Component comp){
        if(gameParent==null){
            icon = comp;
        }
    }*/
    
    public Point getLocation(){
        return location;
    }
    
    public int getX(){
        return location.x;
    }
    
    public int getY(){
        return location.y;
    }
    
    public Dimension getSize(){
        return size;
    }
    
    public int getWidth(){
        return getSize().width;
    }
    
    public int getHeight(){
        return getSize().height;
    }
    
    
    public Rectangle getRectangle(){
        //if(icon==null)
        //    return null;
        
        //Rectangle rect = new Rectangle(icon.getLocation(), icon.getSize());
        Rectangle rect = new Rectangle(location, size);
        
        return rect;
    }
    
    /*protected SpContainer getParent(){
        return gameParent.getContainer();
    }*/
    
    protected Rectangle getParent(){
        return new Rectangle(0,0,800,600);
    }
    
    /*public GameContainer getGameParent(){
        return gameParent;
    }*/
    
    public Rectangle getGameParent(){
        return getParent();
    }
    
    /*protected void setGameParent(GameContainer gc){
        gameParent = gc;
    }*/
    
    public void setSize(int w, int h){
        size.width = w;
        size.height = h;
    }
    
    public void setLocation(Point p){
        setLocation(p.x, p.y);
    }
    
    /*public Point getLocation(){
        return icon.getLocation();
    }*/
    
    public void setLocation(int x, int y){
        location.x = x;
        location.y = y;
        //icon.setBounds(x, y, icon.getWidth(), icon.getHeight());
    }
    
    
    public boolean isSolid(){
        return solid;
    }
    
    public boolean isOut(Point p){
        //Container ctn = icon.getGameParent();
        
        return !gameParent.contains(p);
    }
    
    public boolean isOut(){
        /*Point p = getIcon().getLocation();
        int width = getIcon().getWidth(),
            height = getIcon().getHeight();*/
        Point p = getLocation();
        int width = getSize().width,
            height = getSize().height;
                
        
        return (isOut(p) || isOut(new Point(p.x+width, p.y+height)));
    }
    
    /*public void setVisible(boolean v){
        icon.setVisible(v);
    }*/
    
    
    public void start(){
        proc = new Processus(this);
        proc.start();
    }
    
    public void pause(){
        proc.pause();
    }
    
    public void resume(){
        proc.resume();
    }
    
    public void stop(){
        proc.stop();
    }
    
    public void repaint(){
        //Graphics g = getParent().getGraphics();
        //paint(g);
        //getParent().repaint(getRectangle());
        //getParent().repaint();
    }
}
