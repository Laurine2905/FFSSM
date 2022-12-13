/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    private List<Embauche> lesEmbauches;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int numeroDiplome, int niveau, GroupeSanguin groupe) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, groupe);
        this.numeroDiplome = numeroDiplome;
        lesEmbauches = new ArrayList<>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        Club c = null;
        for(Embauche e : lesEmbauches){
            if(!e.estTerminee()){
                c=e.getEmployeur();
            }
        }
        return Optional.ofNullable(c);

    }

    public void terminerEmbauche(LocalDate date){

    }

    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     *
     * @param employeur     le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) throws Exception {
        for(Embauche e : lesEmbauches){
            if(!e.estTerminee()){
                throw new Exception("Moniteur déjà employé");
            }
        }
        Embauche nouvelleEmbauche = new Embauche(debutNouvelle, this, employeur);
        lesEmbauches.add(nouvelleEmbauche);
    }

    public List<Embauche> emplois() {
        return lesEmbauches;
    }

}
