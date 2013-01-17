/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLibrary;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 
 */
public class MouseManager  implements MouseMotionListener{

    private List<MouseObserver> observers;
    private boolean dragged;
    private boolean motion;
    private boolean click;
    
    public MouseManager(){
        observers = new LinkedList<MouseObserver>();
        dragged = false;
        motion = false;
        click = false;
    }
    
    
    public void bind(MouseObserver mo){
        if(!observers.contains(mo))
            observers.add(mo);
    }
    
    public void unbind(MouseObserver mo){
        observers.remove(mo);
    }
    
    public void notifyObservers(MouseEvent me){
        if(motion){
            for(MouseObserver mo : observers){
                mo.update(me.getX(), me.getY());
            }
            motion = false;
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        motion = true;
        //System.out.println("mouseMoved");
        notifyObservers(me);
    }
    
}
