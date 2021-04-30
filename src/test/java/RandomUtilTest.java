
import br.unisul.ufo.attack.utils.RandomUtil;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 * Teste unitário para RandomUtil
 *
 * @author Adriel Kirch
 */
public class RandomUtilTest {

    @Test
    public void deveTestarIntervalo() {
        int val1 = RandomUtil.randomRange(0, 100);
        int val2 = RandomUtil.randomRange(100, 0);
        int val3 = RandomUtil.randomRange(5, 5);

        assertTrue(val1 > 0 && val1 < 100);
        assertEquals(0, val2);
        assertEquals(5, val3);
    }
}
