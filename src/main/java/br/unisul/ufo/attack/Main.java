package br.unisul.ufo.attack;

import br.unisul.ufo.attack.models.Fase;
import br.unisul.ufo.attack.models.Fase1;
import br.unisul.ufo.attack.services.GameEngine;
import br.unisul.ufo.attack.utils.SoundPool;
import br.unisul.ufo.attack.views.Jogo;
import javax.swing.JOptionPane;

/**
 * Classe principal
 * @author Adriel Kirch
 */
public class Main {
    
    public static void main(String[] args)  {
        SoundPool.getInstance().playClipLoop("song");
        GameEngine engine = new GameEngine();
        JOptionPane.showMessageDialog(null, "Bem vindo ao UFO ATTACK \nDestrua os ovnis clicando neles antes que suas vacas sejam abduzidas.");
        engine.setFase(new Fase1());
        engine.iniciarJogo();
    }
}
