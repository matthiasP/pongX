package GameLibrary;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;


/**
 * 
 * classe permettant de gérer les effets sur les images
 * @see Image
 * @see ImageIcon
 * @see BufferedImage
 * @see Graphics2D
 */
public class SpImage{
    /**
     * Version original de l'image
     */
    private Image original;
    private ImageIcon image;
    private String src;
    
    
    /**
     * Crée une SpImage à partir du chemin du fichier
     * @param path Chemin absolu ou relatif de l'image
     */
    public SpImage(String path){
        src = path;
        image = new ImageIcon(path);
        original = image.getImage();
    }
    
    
    /**
     * Crée un SpImage à partir d'un objet Image
     * @param img objet Image que l'on souhaite avoir en SpImage
     */
    public SpImage(Image img){
        src = "";
        image = new ImageIcon(img);
        original = image.getImage();
    }
    
    public String getSrc(){
        return src;
    }
    
    public Image getImage(){
        return original;
    }
    
    
    /**
     * Redonne son apparence initial à l'SpImage
     */
    public void reset(){
        image.setImage(original);
    }
    
    
    /**
     * Redimensionne une image
     * @param w nouvelle longueur
     * @param h nouvelle hauteur
     */
    public void resize(int w, int h){
        Image resized;
        
        resized = image.getImage().getScaledInstance(w, h, Image.SCALE_FAST);
        image.setImage(resized);
    }
}
