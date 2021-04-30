package br.unisul.ufo.attack.models;

import br.unisul.ufo.attack.utils.ImagePool;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Modelo Fase 4
 *
 * @author Win10
 */
public class Fase4 extends Fase {

    public Fase4() {
        super("Opa, fomos levados para lua!", ImagePool.getInstance().getImage("fase-4"));

        sprites.add(new Vaca(new Coordenada(100, 480)));
        sprites.add(new Vaca(new Coordenada(300, 480)));
        sprites.add(new Vaca(new Coordenada(500, 480)));
        sprites.add(new Vaca(new Coordenada(600, 480)));
        sprites.add(new Vaca(new Coordenada(700, 480)));

        sprites.add(new Nave(new Coordenada(0, 70), 35, Nave.NAVE_LEVEL_4));
        sprites.add(new Nave(new Coordenada(0, 80), 25, Nave.NAVE_LEVEL_4));
        sprites.add(new Nave(new Coordenada(0, 90), 28, Nave.NAVE_LEVEL_4));
        sprites.add(new Nave(new Coordenada(0, 90), 35, Nave.NAVE_LEVEL_4));
        sprites.add(new Nave(new Coordenada(0, 90), 40, Nave.NAVE_LEVEL_4));
        
        setCorDoLabel(Color.WHITE);
    }

    @Override
    public Fase criarFase() {
        return new Fase4();
    }

    @Override
    public Fase getProximaFase() {
       return null;
    }

}
