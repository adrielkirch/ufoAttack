package br.unisul.ufo.attack.models;
import br.unisul.ufo.attack.constants.GameConstants;
import br.unisul.ufo.attack.utils.ImagePool;
import br.unisul.ufo.attack.utils.RandomUtil;
import br.unisul.ufo.attack.utils.SoundPool;

/**
 *  Classe modelo de nave
 * @author Adriel Kirch
 */
public class Nave extends Sprite {
    
    //Constantes
    public static final int NAVE_LEVEL_1 = 1;
    public static final int NAVE_LEVEL_2 = 2;
    public static final int NAVE_LEVEL_3 = 3;
    public static final int NAVE_LEVEL_4 = 4;
    
    //Variáveis
    private boolean inverseX = false;
    private int tipoNave;
    private double angulo = 0.0;
    private int raio = 10;
    private int qtdOscilacao = RandomUtil.randomRange(2, 12);
    
    /**
     * Construir nave
     * @param coordenada
     * @param velocidade
     * @param tipoNave 
     */
    public Nave(Coordenada coordenada, int velocidade, int tipoNave) {
        super(ImagePool.getInstance().getImage("ovni"), coordenada, 100, 45, velocidade, 0);
        if (this.tipoNave == NAVE_LEVEL_1) {
            this.setVida(80);
        } else if (this.tipoNave == NAVE_LEVEL_2) {
            this.setVida(80);
        } else {
            this.setVida(100);
        }
        this.tipoNave = tipoNave;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getTipoNave() {
        return tipoNave;
    }

    public void setTipoNave(int tipoNave) {
        this.tipoNave = tipoNave;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
    
    /**
     * Atualizar estado da nave
     */
    @Override
    public synchronized void update() {

        if (getCoordenada().getX() <= 0) {
            this.inverseX = false;
        }

        if (getCoordenada().getX() >= GameConstants.WIDTH - getWidth()) {
            this.inverseX = true;
        }

        if (this.tipoNave == NAVE_LEVEL_1) {
            if (inverseX) {
                this.updatePosition(this.getCoordenada().getX() - getVelocidade(), this.getCoordenada().getY());
            } else {
                this.updatePosition(this.getCoordenada().getX() + getVelocidade(), this.getCoordenada().getY());
            }
        } else if (this.tipoNave == NAVE_LEVEL_2) {
            if (inverseX) {
                this.updatePosition(this.getCoordenada().getX() - RandomUtil.randomRange(6, 50), this.getCoordenada().getY());
            } else {
                this.updatePosition(this.getCoordenada().getX() + RandomUtil.randomRange(6, 50), this.getCoordenada().getY());
            }
        } else if (this.tipoNave == NAVE_LEVEL_3) {
            double sin = Math.sin(this.angulo * Math.PI / 180) * this.raio;
            int y = (int) Math.floor(this.getCoordenada().getY() + (int) sin);
            if (inverseX) {
                this.updatePosition(this.getCoordenada().getX() - getVelocidade(), y);
            } else {
                this.updatePosition(this.getCoordenada().getX() + getVelocidade(), y);
            }
            this.angulo += (GameConstants.WIDTH + getWidth()) / (360 / this.qtdOscilacao);
            this.angulo %= 360;
        } else {
             double sin = Math.sin(this.angulo * Math.PI / 180) * this.raio;
            int y = (int) Math.floor(this.getCoordenada().getY() + (int) sin);
            if (inverseX) {
                this.updatePosition(this.getCoordenada().getX() - RandomUtil.randomRange(6, 100), y);
            } else {
                this.updatePosition(this.getCoordenada().getX() + RandomUtil.randomRange(6, 100), y);
            }
            this.angulo += (GameConstants.WIDTH + getWidth()) / (360 / this.qtdOscilacao);
            this.angulo %= 360;
        }
    }

    @Override
    /**
     * Evento clique do mouse
     */
    public synchronized void eventoClique() {
        SoundPool.getInstance().playClip("laser");
       
        this.vida -= 10;
        
        if(this.vida <= 0) {
            SoundPool.getInstance().playClip("explosion");
            this.ocultarComponente();
        }
    }
}
