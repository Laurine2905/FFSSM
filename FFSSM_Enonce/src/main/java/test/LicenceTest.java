package test;

import static org.junit.jupiter.api.Assertions.*;

import FFSSM.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

public class LicenceTest {
    @Test
public void testLicenceEstValide(){
        Personne p = new Personne ("2", "Villatte", "Amandine", "Lyon", "123456", LocalDate.of(2001, 12, 7));
        Moniteur m = new Moniteur("67", "Champ", "Florine", "Epinal", "9", LocalDate.of(2000, 12, 7), 1, 3, GroupeSanguin.APLUS);
        Club c = new Club (m, "Porridge", "ailleur", "4567");
        Licence l = new Licence(p, "3", LocalDate.of(2021,5,7), c);
        assertTrue(l.estValide(LocalDate.of(2021, 12, 7)));
        assertFalse(l.estValide(LocalDate.of(2022, 5, 8)));
    }
}
