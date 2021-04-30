
package br.unisul.ufo.attack.utils;
import br.unisul.ufo.attack.exceptions.GameException;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 * Armazenador de imagens
 * @author Adriel Kirch
 */
public class ImagePool {
    //Variáveis
    private static ImagePool instance = null;
    private HashMap <String,ImageIcon> images = new HashMap ();
   
    /**
     * Construir ImagePool
     */
    private ImagePool() {
        registerImages();
    }
   /**
    * Obter instância 
    * @return 
    */
   public static ImagePool getInstance () {
       if(instance == null) {
           ImagePool imagePool = new ImagePool();
           instance = imagePool;
       }
       return instance;
   }
   
   public ImageIcon getImage (String key) {
       ImageIcon img = images.get(key);
       
       if(img == null){
           throw new GameException("Imagem não encontrada");
       }
       return img;
   }
   
   /**
    * Registrar imagens
    */
   private void registerImages () {
       images.put("fase-1", new ImageIcon("src//main//java//br//unisul//ufo//attack//resources//level1-1280-720.png"));
       images.put("fase-2", new ImageIcon("src//main//java//br//unisul//ufo//attack//resources//level-2-800-600.jpg"));
       images.put("fase-3", new ImageIcon("src//main//java//br//unisul//ufo//attack//resources//level3-800-600.jpg"));
       images.put("fase-4", new ImageIcon("src//main//java//br//unisul//ufo//attack//resources//level4-800-600.jpg"));
       images.put("ovni", new ImageIcon("src//main//java//br//unisul//ufo//attack//resources//ovni_100.png"));
       images.put("vaca", new ImageIcon("src//main//java//br//unisul//ufo//attack//resources//vaca_128.png"));
       images.put("mira", new ImageIcon("src//main//java//br//unisul//ufo//attack//resources//mira.png"));
       images.put("vaca-mirrored", new ImageIcon("src//main//java//br//unisul//ufo//attack//resources//vara_128_mirrored.png"));
   }
}
