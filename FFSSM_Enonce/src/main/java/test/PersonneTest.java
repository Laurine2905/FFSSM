package test;

import FFSSM.Personne;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PersonneTest {
    @Test
    public void testNumINSEE(){
        try{
            Personne p = new Personne(null, "toto", "toto", "ici", "4", LocalDate.of(2021, 12, 7));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        Personne p = new Personne("6", "toto", "toto", "ici", "4", LocalDate.of(2021, 12, 7));
    }
}
