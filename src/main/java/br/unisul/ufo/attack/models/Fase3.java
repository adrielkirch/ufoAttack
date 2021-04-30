package br.unisul.ufo.attack.models;

import br.unisul.ufo.attack.utils.ImagePool;
import javax.swing.ImageIcon;

/**
 *
 * @author Win10
 */
public class Fase3 extends Fase {

    public Fase3() {
        super("Bem vindo a Area-51", ImagePool.getInstance().getImage("fase-3"));

        sprites.add(new Vaca(new Coordenada(100, 480)));
        sprites.add(new Vaca(new Coordenada(300, 480)));
        sprites.add(new Vaca(new Coordenada(500, 480)));
        sprites.add(new Vaca(new Coordenada(600, 480)));
        sprites.add(new Vaca(new Coordenada(700, 480)));

        sprites.add(new Nave(new Coordenada(0, 70), 35, Nave.NAVE_LEVEL_3));
        sprites.add(new Nave(new Coordenada(100, 80), 45, Nave.NAVE_LEVEL_3));
        sprites.add(new Nave(new Coordenada(400, 90), 40, Nave.NAVE_LEVEL_3));
        sprites.add(new Nave(new Coordenada(500, 90), 40, Nave.NAVE_LEVEL_3));


    }

    @Override
    public Fase getProximaFase() {
        return new Fase4();
    }

    @Override
    public Fase criarFase() {
        return new Fase3();
    }

}
