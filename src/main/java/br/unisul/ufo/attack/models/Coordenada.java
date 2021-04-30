package br.unisul.ufo.attack.models;

/**
 * Classe de definição de coordenadas no plano do jogo.
 * @author Adriel Kirch
 */
public class Coordenada {
    private int x;
    private int y;
    
    /**
     * Criar nova coordenada
     * @param x
     * @param y 
     */
    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
