package org.example;

import org.junit.Test;

import static org.example.Sein.bepaalKleur;
import static org.junit.Assert.assertEquals;

public class SeinTest {

    @Test
    public void whenSnelheidIsLowThenSeinIsGroen() {
        // given
        int snelheid = 29;

        // when
        String antwoord = bepaalKleur(snelheid);

        //then
        assertEquals("groen", antwoord);
    }

    @Test
    public void whenSnelheidIsMediumThenSeinIsOranje() {
        int snelheid = 29;
        String antwoord = bepaalKleur(snelheid);
        assertEquals("oranje", antwoord);
    }

    @Test
    public void whenSnelheidIsHighThenSeinIsRood() {
        int snelheid = 135;
        String antwoord = bepaalKleur(snelheid);
        assertEquals("rood", antwoord );
    }
}
