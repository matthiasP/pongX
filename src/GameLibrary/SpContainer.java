/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLibrary;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * 
 */
public class SpContainer extends JPanel {
    
    /*private List<Paintable> elements;
    
    public SpContainer(){
        super();
        elements = new LinkedList<Paintable>();
    }
    
    public void add(Paintable p){
        if(!elements.contains(p))
            elements.add(p);
    }
    
    /*public void add(GameObject p){
        elements.add(p);
    }*/
    
    /*
    public void remove(Paintable p){
        elements.remove(p);
    }
    
    
    public void paint(Graphics g){
        super.paint(g);
        
        for(Paintable p :elements){
            p.paint(g);
        }
    }
    
    /*public void repaint(Paintable p){
        p.repaint();
    }*/
}
