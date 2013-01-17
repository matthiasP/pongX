/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLibrary;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 
 */
public class GameContainer extends GameObject{

    protected SpContainer ctn;
    private List<GameObject> elements;
    private MouseManager mouse;
    
    public GameContainer(SpContainer c){
        super();
        mouse = new MouseManager();
        elements = new LinkedList();
        ctn = c;
        c.addMouseMotionListener(mouse);
    }
    
    public SpContainer getContainer(){
        return ctn;
    }
    
    /////////////////////
    public void setBackGround(Image img){
        
    }
    
    
    public void bind(MouseObserver mo){
        mouse.bind(mo);
    }
    
    /*public void add(GameObject go){
        if(contains(go))
            return ;
        
        elements.add(go);
        //ctn.add(go.getIcon());
        ctn.add(go);
        //go.paint(ctn.getGraphics());
        go.setGameParent(this);
    }
    
    public void remove(GameObject go){
        if(!contains(go))
            return ;
        
        elements.remove(go);
        //ctn.remove(go.getIcon());
        ctn.remove(go);
        go.setGameParent(null);
    }

    public void merge(GameContainer gc){
        Iterator<GameObject> it = gc.getElements().iterator();
        GameObject go = null;
        
        while(it.hasNext()){
            go = it.next();
            gc.remove(go);
            add(go);
        }
    }*/
    
    public List<GameObject> getElements(){
        return elements;
    }
    
    public boolean collision(GameObject go){
        if(!contains(go) || !go.isSolid())
            return false;
        
        Iterator<GameObject> it = elements.iterator();
        GameObject go2;
        do{
            go2 = it.next();
        }while(!collision(go, go2) && it.hasNext());
        
        return (it.hasNext() || collision(go, go2));
    }
    
    
    public boolean collision(GameObject go, GameObject go2){
        Rectangle icon;
        
        //l'un des deux n'appartient pas au conteneur ou n'est pas un solide
        if(!contains(go) || !contains(go2) || !go.isSolid() || !go2.isSolid())
            return false;
        
        icon = go.getRectangle();
    
        return icon.intersects(go2.getRectangle());
    }
    
    public void process() {
        ;
    }
    
    public void start(){
        super.start();
       
        Iterator<GameObject> it = elements.iterator();
        GameObject go = null;
        
        while(it.hasNext()){
            go = it.next();
            go.start();
        }
    }
    
    public void pause(){
        super.pause();
        
        Iterator<GameObject> it = elements.iterator();
        GameObject go = null;
        
        while(it.hasNext()){
            go = it.next();
            go.pause();
        }
    }
    
    public void resume(){
        super.resume();
        
        Iterator<GameObject> it = elements.iterator();
        GameObject go = null;
        
        while(it.hasNext()){
            go = it.next();
            go.resume();
        }
    }
    
    public void stop(){
        super.stop();
        
        Iterator<GameObject> it = elements.iterator();
        GameObject go = null;
        
        while(it.hasNext()){
            go = it.next();
            go.stop();
        }
    }
    
    public boolean contains(GameObject go){
        return elements.contains(go);
    }
    
    public boolean contains(Point p){
        return ctn.contains(p);
    }

    /*@Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }*/

    @Override
    public void repaint() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void paint(org.newdawn.slick.Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
