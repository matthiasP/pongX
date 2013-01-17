/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pongx;

import GameLibrary.GameObject;
import GameLibrary.MouseObserver;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * 
 */
public class GameBar extends GameObject implements MouseObserver{

    public final static int HEIGHT = 100;
    public final static int WIDTH = 10;
    public final static int NORMAL_SPEED = 10;
    
    private int speed;
    private int targetY;
    
    public GameBar(){
        super(true);
        /*Component icn = new Label();
        icn.setBackground(Color.blue);
        icn.setBounds(470, 300, WIDTH, HEIGHT);
        
        setIcon(icn);*/
        speed = NORMAL_SPEED;
        setLocation(470, 200);
        setSize(WIDTH, HEIGHT);
    }
    
    public void process() {
        if(needMove())
            move();
            
    }
    
    public boolean needMove(){
        Rectangle rect = getRectangle();
        Point p = getLocation();
        return (!rect.contains(new Point(p.x+1, targetY)));
    }
    
    public void move(){
        Point p = getLocation();
        p.y = 0;
        if(targetY>p.y)
            p.y+= speed;
        else
            p.y-= speed;
        setLocation(p);
        System.out.println("bar moved"+p);
    }

    @Override
    public void update(int x, int y) {
        targetY = y;
    }

    /*@Override
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }*/

    @Override
    public void paint(org.newdawn.slick.Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
