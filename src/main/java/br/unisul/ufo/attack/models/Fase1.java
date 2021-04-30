package br.unisul.ufo.attack.models;

import br.unisul.ufo.attack.utils.ImagePool;
import javax.swing.ImageIcon;

/**
 * @author Adriel Kirch
 */
public class Fase1 extends Fase {

    public Fase1() {
        super("Dia ensolarado na fazenda", ImagePool.getInstance().getImage("fase-1"));

        sprites.add(new Vaca(new Coordenada(100, 480)));
        sprites.add(new Vaca(new Coordenada(300, 480)));
        sprites.add(new Vaca(new Coordenada(500, 480)));
        sprites.add(new Vaca(new Coordenada(600, 480)));
        sprites.add(new Vaca(new Coordenada(700, 480)));
        
        sprites.add(new Nave(new Coordenada(0, 70), 20, Nave.NAVE_LEVEL_1));
        sprites.add(new Nave(new Coordenada(200, 80), 20, Nave.NAVE_LEVEL_1));
        
    }

    @Override
    public Fase getProximaFase() {
        return new Fase2();
    }

    @Override
    public Fase criarFase() {
       return new Fase1();
    }

}
