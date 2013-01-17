package pongx;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */

import org.newdawn.slick.*;
public class PongX extends BasicGame
{
    public Ball ball;
    
    public PongX()
    {
        super("PongX");
        ball = new Ball();
    }

    @Override
    public void init(GameContainer gc) throws SlickException
    {
        gc.setMinimumLogicUpdateInterval(20);
        ball.init();
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException
    {
        ball.move();
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        g.drawString("Hello World", 100, 100);
        ball.paint(g);
    }

    public static void main(String[] args) throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new PongX());

        app.setDisplayMode(800, 600, false);
        app.start();
    }
}


/*import GameLibrary.GameContainer;
import java.awt.*;
import javax.swing.*;


public class PongX {

    static GameManager gm;

    public static void main(String[] args) {

        gm = new GameManager();
        gm.screenInit();
        gm.start();
    }
}
*/
