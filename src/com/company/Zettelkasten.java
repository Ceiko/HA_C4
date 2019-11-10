package com.company;

/**
 * Diese Klasse enthält Methoden zur Verwaltung von Medien
 * @author Nick Kudin
 *
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Zettelkasten implements Iterable<Medium>, Serializable {

    private ArrayList<Medium> myZettelkasten = new ArrayList<>();

    /**
     * Diese Methode fügt Medien zum Zettelkasen hinzu.
     * @param medium
     */
    public void addMedium(Medium medium) {
        myZettelkasten.add(medium);

    }
    /**
     * Diese Methode löscht ein Medium anhand des Titels falls dieser nicht gefunden wurde.
     * @param titel
     * @return true oder false
     */
    public boolean dropMedium(String titel) {
        for (int i = 0; i < myZettelkasten.size(); i++) {
            if (myZettelkasten.get(i).getTitel().equals(titel)) {
                myZettelkasten.remove(myZettelkasten.get(i));
                return true;
            }
        } return false;
    }

    /**
     * Diese Methode sucht anhand des Titels nach einem Medium, falls dieser nicht vorhanden ist, wird null ausgegeben.
     * @param titel
     * @return null
     */
    public Medium findMedium(String titel) {
        for (int i = 0; i < myZettelkasten.size(); i++) {
            if (myZettelkasten.get(i).getTitel().equals(titel)) {
                return myZettelkasten.get(i);
            }
        }
        return null;
    }

    /**
     * Diese Methode vergleicht ob das aktuelle Medium größer ist als das vorherige, wenn nicht dann werden sie sortiert.
     * Im zweiten Teil genau andersherum.
     *
     * @param richtung
     */

    public void sort(String richtung) {
        if (richtung.equals("absteigend")) {
            for (int i = 0; i < myZettelkasten.size() - 1; i++) {
                if (myZettelkasten.get(i + 1).compareTo(myZettelkasten.get(i)) < 0) {
                    Collections.sort(myZettelkasten);
                    System.out.println("\nWurde aufsteigend sortiert");
                }
            }

        } else if (richtung.equals("aufsteigend")) {
            for (int i = 0; i < myZettelkasten.size() - 1; i++) { // -1 weil wir außerhalb des Index sind
                if (myZettelkasten.get(i + 1).compareTo(myZettelkasten.get(i)) > 0) {
                    Collections.sort(myZettelkasten, Collections.reverseOrder()); // anders herum
                    System.out.println("\nWurde absteigend sortiert");
                }
            }


        }

    }

    @Override
    public Iterator iterator() {
        return myZettelkasten.iterator();
    }
}

