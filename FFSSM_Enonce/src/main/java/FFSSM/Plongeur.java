package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

public class Plongeur extends Personne {

    public int niveau;
    private GroupeSanguin groupe;
    private TreeSet<Licence> lesLicences;
    // Je considère que les licences sont délivrées dans un ordre chronologique

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin groupe) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.groupe = groupe;
        lesLicences = new TreeSet<>();
    }

    public TreeSet<Licence> getLesLicences() {
        return lesLicences;
    }

    public void ajouterLicence(String numero, LocalDate delivrance, Club club) {
        Licence licence = new Licence(this, numero, delivrance, club);
        lesLicences.add(licence);
    }

    public Licence derniereLicence() {
        return lesLicences.last();
    }

}
