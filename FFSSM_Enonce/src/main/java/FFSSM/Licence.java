/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;

public class Licence {

    public Personne possesseur;

    public String numero;

    public LocalDate delivrance;

    public Club club;

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.club = club;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     *
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(LocalDate d) {
        boolean estValide = true;
        LocalDate finLicence = delivrance.plusYears(1);
        if (d.isAfter(finLicence)) {
            estValide = false;
        }
        if (d.isBefore(delivrance)) {
            estValide= false;
        }
        return estValide;
    }

    public int compareTo(Object o) {
        return delivrance.compareTo(((Licence) o).getDelivrance());
    }

}
