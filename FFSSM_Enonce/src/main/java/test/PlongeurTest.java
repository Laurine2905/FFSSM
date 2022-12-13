package test;

import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Moniteur;
import FFSSM.Plongeur;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlongeurTest {
    @Test
    public void testAjoutLicence(){
        Plongeur p = new Plongeur("67", "Champ", "Florine", "Epinal", "9", LocalDate.of(2000, 12, 7), 1, GroupeSanguin.APLUS);
        Moniteur m = new Moniteur("698", "Demarle", "Eliot", "Lille", "0988654", LocalDate.of(2000, 12, 7), 1, 3, GroupeSanguin.APLUS);
        Club c = new Club(m, "Porridge", "ailleur", "4567");
        assertEquals(0, p.getLesLicences().size());
        p.ajouterLicence("1", LocalDate.of(2021, 12, 7), c);
        assertEquals(1, p.getLesLicences().size());
        assertEquals("1", p.derniereLicence().getNumero());
        p.ajouterLicence("2", LocalDate.of(2021, 12, 8), c);
        assertEquals(2, p.getLesLicences().size());
        assertEquals("2", p.derniereLicence().getNumero());
    }
}
