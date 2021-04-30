package br.unisul.ufo.attack.services;

import br.unisul.ufo.attack.constants.GameConstants;
import br.unisul.ufo.attack.models.Fase;
import br.unisul.ufo.attack.models.Fase1;
import br.unisul.ufo.attack.models.Sprite;
import br.unisul.ufo.attack.views.Jogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * Motor de processamento do jogo
 * @author Win10
 */
public class GameEngine {
    
    //Variáveis
    private Fase fase;
    private Jogo jogo;
    private Timer timer;

    /**
     * Construir Game Engine.
     */
    public GameEngine() {}

    /**
     * Atualiza os sprites em cada ciclo.
     */
    private void atualizaEstado() {
        for (Sprite sprite : fase.getSprites()) {
            sprite.update();
        }
    }

    /**
     * Desenha o plano de fundo da fase e renderiza os sprites.
     */
    private void desenhaTela() {
        // Renderizar Imagem de fundo 
        jogo.getImagemFundo().setIcon(fase.getImagemFundo());
        jogo.getNomeFase().setForeground(fase.getCorDoLabel());
        // Renderizar sprites
        for (Sprite sprite : fase.getSprites()) {
            jogo.getTela().add(sprite.getSpriteRect());
        }
    }

    /**
     * Executa ciclo do jogo
     */
    public void loop() {
        this.timer = new Timer(GameConstants.DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizaEstado();
                jogo.repaint();
                if(fase.perdeuFase()) {
                    timer.stop();
                    perdeuJogo();
                }
                if(fase.venceuFase()) {
                    timer.stop();
                    proximaFase();
                }
            }
        });
        timer.start();
    }
    
    /**
     * Mostra caixa de confirmação quando perdeu o jogo.
     */
    private void perdeuJogo() {
        int option = JOptionPane.showConfirmDialog(jogo,"Você perdeu o jogo. Deseja tentar novamente?", "Confirmação",JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.OK_OPTION) {
          this.fase = this.fase.criarFase();
            jogo.dispose();
            iniciarJogo();
        } else {
            System.exit(0);
        }
    }
    
    /**
     * Seleciona a próxima fase´após o vencimento da fase.
     */
    private void proximaFase(){
        JOptionPane.showMessageDialog(jogo, "Parabéns, você salvou o rebanho do ataque alienígena.");
        Fase proximaFase = this.fase.getProximaFase();
        if(proximaFase == null) {
            JOptionPane.showMessageDialog(jogo, "Parabéns, você expulsou permanentemente os aliens de suas propriedades.");
            System.exit(0);
        }
        this.fase = proximaFase;
        jogo.dispose();
        iniciarJogo();     
    }
    
    /**
     * Criar tela e iniciar jogo0
     */
    public void iniciarJogo() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jogo = new Jogo();
                jogo.getNomeFase().setText("Fase: " + getFase().getNome());
                jogo.setVisible(true);
                desenhaTela();
                loop();
            }
        });
        
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}
