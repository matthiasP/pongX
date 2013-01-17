/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pongx;

import GameLibrary.GameObject;
import java.awt.*;
import java.util.Random;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.Graphics;
/**
 *
 * 
 */
public class Ball extends GameObject /*implements Runnable*/{
    
    //public final static int HEIGHT = 20;
    //public final static int WIDTH = 20;
    public final static int RAYON = 20;
    public final static int NORMAL_SPEED = 5;
    //private Component icon;
    //private Thread proc;
    private int speed;
    private Circle shape;
    //private int angle;
    private float a; // coef directeur y=ax+b
    private float b;
    
    public Ball(){
        super(true);
        /*Component icn = new Label();
        icn.setBackground(Color.yellow);
        icn.setBounds(100, 200, WIDTH, HEIGHT);
        
        setIcon(icn);*/
        speed = NORMAL_SPEED;
        a = 0.0f;
        b = 0.0f;      
    }

    
    public void init(){
        Random r = new Random();
        int angle = r.nextInt(180);
        calculateAffineFunction(angle);
        if(r.nextBoolean())//gauche ou droite
            speed = -speed;
    }
    
    public void calculateAffineFunction(int angle){
        /*Component icon = getIcon();
        int x = (int) (icon.getX() + (speed * Math.cos(Math.toRadians(angle))));
        int y = (int) (icon.getY() + (speed * Math.sin(Math.toRadians(angle))));

        
        a = (float)(icon.getX() - x) / (float)(icon.getY() - y);*/
        int x = (int) (getX() + (speed * Math.cos(Math.toRadians(angle))));
        int y = (int) (getY() + (speed * Math.sin(Math.toRadians(angle))));

        
        a = (float)(getX() - x) / (float)(getY() - y);
        b = -(a*x)+y;
    }
    
    public Point calculateNextPosition(){
        return calculateNextPosition(0);
    }
    
    public Point calculateNextPosition(int occurs){
       //Component icon = getIcon();
       /*int x = icon.getX()+speed,
           y = Math.round(a*x+b),
           xmax = x+icon.getWidth(),
           ymax = y+icon.getHeight();
       //Container ctn = icon.getParent();
       Container ctn = getParent();
       Point p = new Point(x, y);
        
       if(isOut(p) || isOut(new Point(xmax, ymax))){
            if(p.y<=ctn.getY() || ymax>=(ctn.getY()+ctn.getHeight()) || xmax>=(ctn.getX()+ctn.getWidth())){
                b = ((icon.getY()-b)*2.0f)+b;
            }*/
        int x = getX()+speed,
           y = Math.round(a*x+b),
           xmax = x+getWidth(),
           ymax = y+getHeight();
       //Container ctn = icon.getParent();
       //Container ctn = getParent();
       Rectangle ctn = getParent();
       Point p = new Point(x, y);
        
       if(isOut(p) || isOut(new Point(xmax, ymax))){
            if(p.y<=ctn.getY() || ymax>=(ctn.getY()+ctn.getHeight()) || xmax>=(ctn.getX()+ctn.getWidth())){
                b = ((getY()-b)*2.0f)+b;
            }
            if(p.x<=ctn.getX() || xmax>=(ctn.getX()+ctn.getWidth())){
                speed = -speed;
            }
            
            a = -a;

            p = calculateNextPosition(++occurs);
        }
        
        return p;
    }
    
    
    public void move(){
        Point p = calculateNextPosition();
        setLocation(p.x, p.y);
        reboundBall();
    }

    
    public boolean reboundBall(){
        //Component icon = getIcon();
        //Point p = icon.getLocation();
        Point p = getLocation();
        //Container ctn = icon.getParent();
       Rectangle ctn = getParent();
        int x = p.x,
            y = p.y,
            xmax = (int) (ctn.getX()+ctn.getWidth()),
            ymax = (int) (ctn.getY()+ctn.getHeight()); 
        
        if(!isOut())  
            return false;

        if(p.x<ctn.getX())
            x = (int) ctn.getX();
        else if( (p.x+RAYON) > xmax )
            x = xmax-RAYON;
        
        if(p.y<ctn.getY())
            y = (int) ctn.getY();
        else if( (p.y+RAYON) > ymax )
            y = ymax-RAYON;
        
        setLocation(x, y);
        return true;
    }
    
    public void paint(Graphics g){
        //super.paint(g);
        shape = new Circle(100.0f, 100.0f, (float)Math.toRadians(360.0));
        //g.setColor(Color.yellow);
        g.fillOval(getX(), getY(), RAYON, RAYON);
    }
    
    public void draw(){
        //super.paint(g);
        shape = new Circle(100.0f, 100.0f, (float)Math.toRadians(360.0));
        //g.setColor(Color.yellow);
        //g.fillOval(getX(), getY(), RAYON, RAYON);
    }


    public void process() {
        move();
        repaint();
    }

    /*@Override
    public void paint(org.newdawn.slick.Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }*/
}
