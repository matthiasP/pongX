
package pongx;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import java.awt.Dimension;



public class Fenetre extends JFrame implements Runnable{        

    
    /**
     * @param titre Titre de la fenêtre 
     */
    public Fenetre(String titre){
        super(titre);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
    /**
     * @param titre Titre de la fenêtre
     * @param width Largeur de la fenêtre
     * @param height Hauteur de la fenêtre
     */
    public Fenetre(String titre,int width,int height){
        super(titre);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
    public Fenetre(String titre,int width,int height, boolean exit_on_close){
        super(titre);
        setSize(width,height);
        setLocationRelativeTo(null);

        if(exit_on_close)
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        else
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);  
    }
    
    
    public void run(){
        setVisible(true);
    }

    
    /**
     * Permet d'invoquer la fenêtre dans le JVM
     */
    public void invoke(){
        SwingUtilities.invokeLater(this);
    }
    
    
    /**
     * Définit la taille minimal de la fenêtre
     * @param width Largeur de la fenêtre
     * @param height Hauteur de la fenêtre
     */
    public void setMinimumSize(int width, int height){
        this.setMinimumSize(new Dimension(width, height));
    }
    
    public void refresh(){
        int w = getWidth(), h = getHeight();
        
        //setSize(getWidth(), getHeight());
        //getContentPane().setSize(getWidth(), getHeight());
        pack();
        
        setSize(w, h);
    } 
}