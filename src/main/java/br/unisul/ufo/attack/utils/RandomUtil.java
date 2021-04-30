
package br.unisul.ufo.attack.utils;

/**
 * Classe para gerar inteiros randômicos entre um intervalo
 * @author Adriel Kirch
 */
public class RandomUtil {
    public static int randomRange (int min,int max) {
        
        if(min > max) {
            return 0;
        }
        return (int) ((Math.random() * (max - min)) + min);
    }

   
}
