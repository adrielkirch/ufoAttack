package br.unisul.ufo.attack.models;

import br.unisul.ufo.attack.constants.GameConstants;
import br.unisul.ufo.attack.utils.ImagePool;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Modelo da segunda fase do jogo
 *
 * @author Adriel
 */
public class Fase2 extends Fase {

    public Fase2() {
        super("A noite do chupa cabra", ImagePool.getInstance().getImage("fase-2"));

        sprites.add(new Vaca(new Coordenada(100, 480)));
        sprites.add(new Vaca(new Coordenada(300, 480)));
        sprites.add(new Vaca(new Coordenada(500, 480)));
        sprites.add(new Vaca(new Coordenada(600, 480)));
        sprites.add(new Vaca(new Coordenada(700, 480)));

        sprites.add(new Nave(new Coordenada(0, 50), 35, Nave.NAVE_LEVEL_2));
        sprites.add(new Nave(new Coordenada(300, 75), 45, Nave.NAVE_LEVEL_2));
        sprites.add(new Nave(new Coordenada(500, 90), 40, Nave.NAVE_LEVEL_2));
        setCorDoLabel(Color.WHITE);
    }

    @Override
    public Fase getProximaFase() {
       return new Fase3();
    }

    @Override
    public Fase criarFase() {
       return new Fase2();
    }

}
