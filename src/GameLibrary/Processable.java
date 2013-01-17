/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLibrary;

/**
 *
 * @author shigeru-naki
 */
public interface Processable {
    
    public void start();
    public void pause();
    public void resume();
    public void stop();
    public void process();
}
