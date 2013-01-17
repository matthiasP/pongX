/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLibrary;

import java.awt.Label;

/**
 *
 * 
 */
public class Chronometre implements Processable, Displayable{

    Processus proc;
    long timestamp;
    Label lbl;
    
    public Chronometre(){
        timestamp = 0L;
        proc = new Processus(this);
        lbl = null;
    }
    
    public String getTime(){
        if(timestampNull())
            return "0:00";

        return getMinutes()+":"+getSeconds();
    }
    
    private boolean timestampNull(){
        long end = System.currentTimeMillis();
        
        return (timestamp==0L || end>=timestamp);
    }
    
    public long getCurrentTime(){
        long end = System.currentTimeMillis(), current;
        if(timestampNull())
            return 0L;
        
        current = end-timestamp;
        return current;
    }
    
    public int getMinutes(){
        long current = getCurrentTime();
        int min;
        if(current<60000L)
            return 0;
       
        min = (int)current/60000;

        return min;
    }
    
    public int getSeconds(){
        long current = getCurrentTime();
        int sec;
        if(current==0L)
            return 0;
        
        sec = ((int)current/1000)-(getMinutes()*60);
        
        return sec;
    }
    
    @Override
    public void start() {
        timestamp = System.currentTimeMillis();
        proc.start();
    }

    @Override
    public void pause() {
        proc.pause();
    }

    @Override
    public void resume() {
        proc.resume();
    }

    @Override
    public void stop() {
        proc.stop();
    }

    @Override
    public void process() {
        if(lbl!=null)
            lbl.setText(getTime());
    }

    @Override
    public void bindDisplayable(Label l) {
        lbl = l;
    }
    
}
