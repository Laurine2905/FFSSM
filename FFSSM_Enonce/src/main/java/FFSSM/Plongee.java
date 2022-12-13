/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public LocalDate date;

    public int profondeur;

    public int duree;

    private Set<Plongeur> laPalanquee;

    public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
        laPalanquee = new HashSet<>();
    }

    public void ajouteParticipant(Plongeur participant) throws Exception {
        if (participant.derniereLicence().estValide(date)) {
            laPalanquee.add(participant);
        } else {
            throw new Exception("Le participant n'a pas de licence valide");
        }

    }

    public LocalDate getDate() {
        return date;
    }

    /**
     * Détermine si la plongée est conforme.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une
     * licence valide à la date de la plongée
     *
     * @return vrai si la plongée est conforme
     */
    public boolean estConforme() {
        boolean conforme = true;
        for (Plongeur p : laPalanquee) {
            if (!p.derniereLicence().estValide(date)) {
                conforme = false;
            }
        }
        return conforme;
    }
}
