
import br.unisul.ufo.attack.models.Coordenada;
import br.unisul.ufo.attack.models.Nave;
import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 * Teeste unitário para modelo 'Nave'
 * @author Adriel Kirch
 */
public class NaveTest {

    private Nave nave;

    public NaveTest() {

    }

    @Before
    public void criarNovaNave() {
        this.nave = new Nave(new Coordenada(500, 500),10,Nave.NAVE_LEVEL_1);
    }

    @Test
    public void deveMoverANave() {
        int posicaoXAnterior = this.nave.getCoordenada().getX();
        this.nave.update();
        int posicaoXAtual = this.nave.getCoordenada().getX();
        assertEquals(posicaoXAnterior + this.nave.getVelocidade(), posicaoXAtual);
    }

    @Test
    public void deveRetirarVidaDaNave() {
        int vidaAnterior = this.nave.getVida();
        this.nave.eventoClique();
        int vidaAtual = this.nave.getVida();
        assertEquals(vidaAnterior - 10, vidaAtual);
    }

}
