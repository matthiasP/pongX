/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pongx;

import GameLibrary.Chronometre;
import GameLibrary.GameContainer;
import GameLibrary.MouseManager;
import GameLibrary.MouseObserver;
import GameLibrary.SpContainer;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * 
 */
public class GameManager implements Runnable {
    private Fenetre window;
    private Ball ball;
    private Chronometre chrono;
    private GameContainer currentScreen;
    private Thread th;
    private boolean playing;
    
    
    public GameManager(){
        window = new Fenetre("PongX");
        ball = null;
        currentScreen = null;
        th = new Thread(this);
        playing = false;
        chrono = new Chronometre();
    }
    
    
    public boolean inGame(){
        return playing;
    }
        
    
    public void start(){
        if(!inGame()){
            playing = true;
            screenGame();
            currentScreen.start();
            chrono.start();
        }
    }
    
    public void pause(){
        if(inGame()){
            currentScreen.pause();
            chrono.pause();
        }
    }
    
    public void resume(){
        currentScreen.resume();
    }
    
    
    public void stop(){
        if(inGame()){
            playing = false;
            currentScreen.stop();
            chrono.stop();
            screenEnd();
        }
    }
    
    public void screenInit(){
        //JPanel panel = new JPanel();
        SpContainer panel = new SpContainer();
        panel.setLayout(null);
        panel.setBounds(0, 0, window.getWidth(), window.getHeight());
        panel.setBackground(Color.blue);
        if(currentScreen!=null)
            currentScreen.stop();
        
        currentScreen = new GameContainer(panel);
        window.setContentPane(panel);
        window.invoke();
    }
    
    public void screenGame(){
        SpContainer sc = new SpContainer();
        sc.setLayout(null);
        sc.setBounds(0, 0, window.getWidth(), window.getHeight());
        sc.setBackground(Color.red);
        /*JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, window.getWidth(), window.getHeight());
        panel.setBackground(Color.red);*/
        
        //game init
        currentScreen.stop();
        //currentScreen = new GameContainer(panel);
        currentScreen = new GameContainer(sc);
        ball = new Ball();
        GameBar gb = new GameBar();
        //currentScreen.add(ball);
        //currentScreen.bind(gb);
        //currentScreen.add(gb);
        
        
        //window.setContentPane(panel);
        window.setContentPane(sc);
        ball.init();
    }
    
    public void screenEnd(){
        
    }
    
    public void run(){
        
    }
}
