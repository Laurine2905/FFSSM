package test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import FFSSM.GroupeSanguin;
import org.junit.jupiter.api.*;


import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.Moniteur;

public class EmbaucheTest {

    @Test
    // On vérifie que lorsqu'on indique qu'un emploi est terminer il l'est vraiment
    public void testTerminer(){
        Moniteur m = new Moniteur("1", "Rat", "Laurine", "Castres", "9", LocalDate.of(2000, 12, 7), 1, 3, GroupeSanguin.AMOINS);
        Moniteur m2 = new Moniteur("2", "Lami", "Doriane", "Limoges", "7", LocalDate.of(2000, 5, 7), 2, 2, GroupeSanguin.BPLUS);
        Club c = new Club(m, "Club 1", "Limoges", "098765432");
        Embauche e = new Embauche(LocalDate.of(2021, 12, 6), m2, c);
        assertFalse(e.estTerminee());
        e.terminer(LocalDate.of(2021, 12, 7));
        assertTrue(e.estTerminee());
    }


}
