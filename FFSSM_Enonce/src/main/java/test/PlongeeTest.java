package test;

import FFSSM.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlongeeTest {
    @Test
    public void testAjouterPlongeur() throws Exception{
        Plongeur p = new Plongeur("67", "Champ", "Florine", "Epinal", "9", LocalDate.of(2000, 12, 7), 1, GroupeSanguin.APLUS);

        Moniteur m = new Moniteur("698", "Demarle", "Eliot", "Lille", "0988654", LocalDate.of(2000, 12, 7), 1, 3, GroupeSanguin.APLUS);
        Club c = new Club(m, "Porridge", "ailleur", "4567");
        Plongee pl = new Plongee(new Site("site", "details"), m, LocalDate.of(2021, 12, 12), 10, 120);

        try{
            pl.ajouteParticipant(p);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        p.ajouterLicence("1", LocalDate.of(2021, 12, 7), c);
        pl.ajouteParticipant(p);
        assertTrue(pl.estConforme());

    }
}
