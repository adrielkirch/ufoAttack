package br.unisul.ufo.attack.models;

import br.unisul.ufo.attack.constants.GameConstants;
import br.unisul.ufo.attack.utils.ImagePool;
import br.unisul.ufo.attack.utils.RandomUtil;
import br.unisul.ufo.attack.utils.SoundPool;
import java.util.Random;

/**
 * Modelo Vaca, classe filha de Sprite
 * @author Win10
 */
public class Vaca extends Sprite {
    
    //Variáveis
    private boolean inverse = false;
    
    /**
     * Construir vaca.
     * @param coordenada 
     */
    public Vaca(Coordenada coordenada) {
        super(ImagePool.getInstance().getImage("vaca"), coordenada, 128, 97, RandomUtil.randomRange(5, 12), RandomUtil.randomRange(50, 200));
    }

    
    /**
     * Atualizar estado da vaca
     */
    @Override
    public void update() {
        if (this.vida > 0) {
            int vidaPerdida = RandomUtil.randomRange(0, 2);
            this.vida -= vidaPerdida;
            if (this.vida <= 0) {
                SoundPool.getInstance().playClip("cow");
                this.ocultarComponente();
            }
            if (this.getCoordenada().getX() >= GameConstants.WIDTH - getWidth()) {
                inverse = true;
                this.setImagem(ImagePool.getInstance().getImage("vaca-mirrored"));
            }
            if (this.getCoordenada().getX() <= 0) {
                inverse = false;
                this.setImagem(ImagePool.getInstance().getImage("vaca"));
            }
            if (!inverse) {
                this.updatePosition(
                        this.getCoordenada().getX() + this.getVelocidade(),
                        this.getCoordenada().getY()
                );
            } else {
                this.updatePosition(
                        this.getCoordenada().getX() - this.getVelocidade(),
                        this.getCoordenada().getY()
                );
            }
        }

    }
    
    /**
     * Evento de clique do mouse */
    @Override
    public void eventoClique() {
        SoundPool.getInstance().playClip("laser");
        SoundPool.getInstance().playClip("cow");
        this.vida -= 10;
        if (this.vida <= 0) {
            this.ocultarComponente();
        }

    }
}
