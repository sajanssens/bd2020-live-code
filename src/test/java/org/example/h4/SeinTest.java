package org.example.h4;

import org.example.h3.SeinKleur;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SeinTest {

    @Test
    public void whenSnelheidIs110ThenGroen() throws Exception {
        // Given
        Sein target = new Sein();

        // When
        SeinKleur seinKleur = target.bepaalKleur(10);

        // Then
        assertEquals(SeinKleur.GROEN, seinKleur);
    }

    @Test(expected = Exception.class)
    public void whenSnelheidIsNegatiefThenExceptionIsThrown() throws Exception {
        // Given
        Sein target = new Sein();

        // // When
        // SeinKleur seinKleur = null;
        // try {
        //     seinKleur = target.bepaalKleur(-1);
        // } catch (Exception e) {
        //     // Then
        //     assertNull(seinKleur);
        // }

        target.bepaalKleur(-1);
    }

}
