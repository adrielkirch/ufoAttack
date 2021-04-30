package br.unisul.ufo.attack.views;

import br.unisul.ufo.attack.constants.GameConstants;
import br.unisul.ufo.attack.utils.SoundPool;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Tela do Jogo
 *
 * @author Win10
 */
public class Jogo extends javax.swing.JFrame {

    private JLabel imagemFundo = new JLabel();
    private JPanel tela = new JPanel();
    private String palavra = "";
    
    /**
     * Criar tela do jogo
     */
    public Jogo() {

        // Inicializar JFrame
        initComponents();
        this.setSize(GameConstants.WIDTH, GameConstants.HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Criar background
        this.imagemFundo.setSize(GameConstants.WIDTH, GameConstants.HEIGHT);
        this.painel.add(this.imagemFundo, new Integer(0));

        // Criar painle de renderização de sprites
        tela.setLayout(null);
        tela.setBounds(0, 0, GameConstants.WIDTH, GameConstants.HEIGHT);
        tela.setOpaque(false);
        painel.add(tela, new Integer(1));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JLayeredPane();
        nomeFase = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(GameConstants.GAME_NAME);
        setSize(new java.awt.Dimension(800, 600));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(null);

        painel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                painelMousePressed(evt);
            }
        });

        nomeFase.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        nomeFase.setText("Fase: 1");
        painel.add(nomeFase);
        nomeFase.setBounds(20, 30, 540, 17);

        getContentPane().add(painel);
        painel.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void painelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelMousePressed
        SoundPool.getInstance().playClip("laser");
    }//GEN-LAST:event_painelMousePressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        this.palavra += evt.getKeyChar();
        if(palavra.contains("et")){
            JOptionPane.showMessageDialog(this, " (◣_◢) Credits (◣_◢)\nDeveloper: Adriel\nMusic and sounds: Adriel\nMentor: Vini","Easter egg",JOptionPane.WARNING_MESSAGE);
            this.palavra = "";
        }
     
    }//GEN-LAST:event_formKeyTyped

    public JPanel getTela() {
        return tela;
    }

    public void setTela(JPanel tela) {
        this.tela = tela;
    }

    public JLabel getImagemFundo() {
        return imagemFundo;
    }

    public void setImagemFundo(JLabel imagemFundo) {
        this.imagemFundo = imagemFundo;
    }

    public JLabel getNomeFase() {
        return nomeFase;
    }

    public void setNomeFase(JLabel fase) {
        this.nomeFase = fase;
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nomeFase;
    private javax.swing.JLayeredPane painel;
    // End of variables declaration//GEN-END:variables
}
