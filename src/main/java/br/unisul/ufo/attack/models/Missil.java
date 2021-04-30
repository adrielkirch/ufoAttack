
package br.unisul.ufo.attack.models;

/**
 * Modelo de classe de míssil
 * @author Adriel Kirch
 */
public class Missil {
    private int velocidade;
    private int dano;

    public Missil(int velocidade, int dano) {
        this.velocidade = velocidade;
        this.dano = dano;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
    
}
