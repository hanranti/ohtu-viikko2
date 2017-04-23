
package ohtu.intjoukkosovellus;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoKaksiparametrisellaKonstruktorillaTest extends IntJoukkoTest {
    
    @Before
    public void setUp() {
        joukko = new IntJoukko(4, 2);
        joukko.lisaaLuku(10);
        joukko.lisaaLuku(3);
    }

    @Test
    public void negatiivisellaKapasiteetillaLuodunJoukonTaulukkoOnNull() {
        IntJoukko joukko2 = new IntJoukko(-1, 2);
    }

    @Test
    public void lukuaJotaEiOleLukuJonossaEiPoisteta() {
        assertFalse(joukko.poistaLuku(5));
    }
}
