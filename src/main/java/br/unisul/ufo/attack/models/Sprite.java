
package br.unisul.ufo.attack.models;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * Define o medelo de Sprite
 * @author Adriel Kirch
 */
public abstract class Sprite {
    private ImageIcon imagem;
    private Coordenada coordenada;
    private int width;
    private int height;
    private final JLabel componente;
    private int velocidade;
    protected int vida;
    /**
     *  Construir Sprite
     * @param imagem 
     * @param coordenada 
     * @param width
     * @param height
     * @param velocidade
     * @param vidaCons 
     */
    public Sprite(ImageIcon imagem, Coordenada coordenada, int width, int height, int velocidade, int vida) {
        this.imagem = imagem;
        this.coordenada = coordenada;
        this.width = width;
        this.height = height;
        this.velocidade = velocidade;
        this.componente = new JLabel();
        this.componente.setBounds(coordenada.getX(), coordenada.getY(), width, height);
        this.componente.setIcon(this.imagem);
        this.vida = vida ;
      
        
        //Event
       componente.addMouseListener(new MouseListener() {
           
             @Override
            public void mousePressed(MouseEvent e) {
                 eventoClique();
            }
           
            @Override
            public void mouseClicked(MouseEvent e) {
               
            }     

         
            @Override
            public void mouseReleased(MouseEvent e) {
              
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
       });
    }
    
    /**
     * Método abstrato de atualização de estado
     */
    public  abstract void update();
    
    /**
     * Evento de clique do mouse
     */
    public  abstract  void eventoClique ();
    
    protected void atualizarPosicaoComponente() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 componente.setLocation(coordenada.getX(), coordenada.getY());
            }
        });
        
    }
    
    /**
     * Atualizar imagem do sprite
     */
    protected void atualizarImagemComponente() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 componente.setIcon(imagem);
            }
        });
    }
    
    /**
     * Ocultar da tela o sprite 
     */
    protected void ocultarComponente() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 componente.setVisible(false);
            }
        });
    }
     
    public ImageIcon getImagem() {
        return imagem;
    }
        
    public void setImagem(ImageIcon imagem) {
        this.imagem = imagem;
        atualizarImagemComponente();
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
        this.atualizarPosicaoComponente();
    }
    
    public void updatePosition(int x, int y) {
        this.coordenada.setX(x);
        this.coordenada.setY(y);
        this.atualizarPosicaoComponente();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public JLabel getSpriteRect() {
        return componente;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    
}

