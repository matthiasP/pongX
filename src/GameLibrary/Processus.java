/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLibrary;

/**
 *
 * 
 */
public class Processus implements Runnable {
    
    final static int SLEEP_TIME = 50;
    
    boolean active;
    boolean end;
    Thread exe;
    Processable proc;
    
    public Processus(Processable p){
        exe = null;
        active = false;
        proc = p;
        end = false;
    }
    
    public boolean isActive(){
        return active;
    }
    
    public boolean isEnded(){
        return end;
    }
    
    public void start(){
        stop();
        
        exe = new Thread(this);
        active = true;
        exe.start();
        end = false;
    }
    
    public void pause(){
        active = false;
    }
    
    public void resume(){
        active = true;
    }
    
    public void stop(){
        active = false;
        end = true;
        if(exe!=null)
            exe.interrupt();
        
        exe = null;
    }
    
    public  void run(){
        while(!end){
            
            if(isActive())
                proc.process();
            try{
                Thread.sleep(SLEEP_TIME);
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
            
        }
    }
}
