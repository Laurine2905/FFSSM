package test;
import static org.junit.jupiter.api.Assertions.*;

import FFSSM.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

public class MoniteurTest {

    Moniteur m;
    Moniteur m2;
    Club c;
    @BeforeEach
    public void setVariable(){
        m = new Moniteur("67", "Champ", "Florine", "Epinal", "9", LocalDate.of(2000, 12, 7), 1, 3, GroupeSanguin.APLUS);
        c = new Club (m, "Porridge", "ailleur", "4567");
        m2 = new Moniteur("698", "Demarle", "Eliot", "Lille", "0988654", LocalDate.of(2000, 12, 7), 1, 3, GroupeSanguin.APLUS);
    }

    @Test
    public void testEmployeurActuel() throws Exception{
        assertTrue(m2.employeurActuel().isEmpty());
        m2.nouvelleEmbauche(c, LocalDate.of(2021, 12, 7));
        assertEquals(c, m2.employeurActuel().get());
    }

    @Test
    public void testNouvelleEmbauche() throws Exception{
        m2.nouvelleEmbauche(c, LocalDate.of(2021, 11, 7));
        try{
            m2.nouvelleEmbauche(c, LocalDate.of(2021, 12, 7));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        m2.emplois().get(0).terminer(LocalDate.of(2021, 12, 5));
        m2.nouvelleEmbauche(c, LocalDate.of(2021, 12, 7));
    }

}
