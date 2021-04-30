
import br.unisul.ufo.attack.exceptions.GameException;
import br.unisul.ufo.attack.utils.ImagePool;
import javax.swing.ImageIcon;
import static junit.framework.Assert.*;
import org.junit.Test;


/**
 * Game engine
 *
 * @author Win10
 */
public class ImagePoolTest {

    public ImagePoolTest() {

    }

    @Test
    public void deveObterInstancia() {
        ImagePool imagePool = ImagePool.getInstance();
        assertNotNull(imagePool);
    }

    @Test
    public void deveSerSingleton() {
        ImagePool imagePool1 = ImagePool.getInstance();
        ImagePool imagePool2 = ImagePool.getInstance();
        assertEquals(imagePool1,imagePool2);
    }
    
    @Test
    public void deveObterImagem() {
        ImageIcon image1 = ImagePool.getInstance().getImage("fase-1");
        assertNotNull(image1); 
    }
    
    @Test(expected = GameException.class)
    public void deveLancarExecessaoQuandoImagemNaoEncontrada() {
        ImagePool.getInstance().getImage("fase-99999");
    }

}
