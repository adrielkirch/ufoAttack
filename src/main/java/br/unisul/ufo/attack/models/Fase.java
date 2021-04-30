package br.unisul.ufo.attack.models;

import br.unisul.ufo.attack.models.Sprite;
import br.unisul.ufo.attack.utils.ImagePool;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Modelo de Fase
 *
 * @author Adriel Kirch
 */
public abstract class Fase {

    private ImageIcon imagemFundo;
    protected ArrayList<Sprite> sprites = new ArrayList();
    private String nome;
    private Color corDoLabel = Color.BLACK;
    
    public Fase(String nome, ImageIcon imagemFundo) {
        this.nome = nome;
        this.imagemFundo = imagemFundo;
    }

    public abstract Fase criarFase();
    public abstract Fase getProximaFase();

    public ImageIcon getImagemFundo() {
        return imagemFundo;
    }

    public void setImagemFundo(ImageIcon imagemFundo) {
        this.imagemFundo = imagemFundo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }

    public void setSprites(ArrayList<Sprite> sprites) {
        this.sprites = sprites;
    }

    public int countSpriteOf(String name) {
        int counter = 0;

        for (int i = 0; i < sprites.size(); i++) {
            if (sprites.get(i) instanceof Vaca && name.equals("Vaca")) {
                counter++;
            } else if (sprites.get(i) instanceof Vaca && name.equals("Nave")) {
                counter++;
            }
        }

        return counter;
    }

    public boolean perdeuFase() {
        for (Sprite sprite : this.sprites) {
            if (sprite instanceof Vaca && sprite.getVida() > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean venceuFase() {
        for (Sprite sprite : this.sprites) {
            if (sprite instanceof Nave && sprite.getVida() > 0) {
                return false;
            }
        }
        return true;
    }

    public Color getCorDoLabel() {
        return corDoLabel;
    }

    public void setCorDoLabel(Color corDoLabel) {
        this.corDoLabel = corDoLabel;
    }

}
