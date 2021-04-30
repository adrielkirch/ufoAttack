
import br.unisul.ufo.attack.exceptions.GameException;
import br.unisul.ufo.attack.utils.ImagePool;
import br.unisul.ufo.attack.utils.SoundPool;
import java.io.File;
import javax.swing.ImageIcon;
import static junit.framework.Assert.*;
import org.junit.Test;


/**
 * Game engine
 *
 * @author Win10
 */
public class SoundPoolTest {

    public SoundPoolTest() {

    }

    @Test
    public void deveObterInstancia() {
        SoundPool soundPool = SoundPool.getInstance();
        assertNotNull(soundPool);
    }

    @Test
    public void deveSerSingleton() {
        SoundPool soundPool1 = SoundPool.getInstance();
        SoundPool soundPool2 = SoundPool.getInstance();
        assertEquals(soundPool1,soundPool2);
    }
    
    @Test
    public void deveExecutarOAudio() {
      boolean executado = SoundPool.getInstance().playClip("laser");
        assertTrue(executado);
    }
    
    @Test(expected = GameException.class)
    public void deveLancarExecessaoQuandoAudioNaoEncontrado() {
        SoundPool.getInstance().playClip("aliens999");
    }

}
