package br.unisul.ufo.attack.models;

/**
 * Define o modelo de classe para personagem
 * @author Adriel Kirch
 */
public class Personagem extends Sprite{

    private int energia;
    
    /**
     * Construir personagem
     * @param energia 
     */
    public Personagem(int energia) {
        super(null, null, 0, 0, 0,100);
        this.energia = energia;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    @Override
    public void update() {
        // Nada
    }

    @Override
    public void eventoClique() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
