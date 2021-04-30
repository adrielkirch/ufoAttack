
import br.unisul.ufo.attack.models.Coordenada;
import br.unisul.ufo.attack.models.Vaca;
import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 * Teeste unitário para modelo 'Vaca'
 * @author Adriel Kirch
 */
public class VacaTest {

    private Vaca vaca;

    public VacaTest() {

    }

    @Before
    public void criarNovaVaca() {
        this.vaca = new Vaca(new Coordenada(500, 500));
    }

    @Test
    public void deveMoverAVaca() {
        int posicaoXAnterior = this.vaca.getCoordenada().getX();
        this.vaca.update();
        int posicaoXAtual = this.vaca.getCoordenada().getX();
        assertEquals(posicaoXAnterior + this.vaca.getVelocidade(), posicaoXAtual);
    }

    @Test
    public void deveRetirarVidaDaVaca() {
        int vidaAnterior = this.vaca.getVida();
        this.vaca.eventoClique();
        int vidaAtual = this.vaca.getVida();
        assertEquals(vidaAnterior - 10, vidaAtual);
    }

}
