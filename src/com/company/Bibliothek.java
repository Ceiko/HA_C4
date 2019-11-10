package com.company;


/**
 * Diese Klasse instaziert die Medien.
 * @author Nick Kudin
 * @version Aufgabe C4 -C6
 */
public class Bibliothek {

    public static void main(String[] args) {

        Zettelkasten zettelkasten = new Zettelkasten();

        try {
            zettelkasten.addMedium(new CD("Live at Wembley", "Parlophone (EMI)", "Queen"));
        }catch (IllegalArgumentException iae){
            System.err.println(iae.getMessage());
        }
        try{
            zettelkasten.addMedium(new Buch("Duden 01. Die deutsche Rechtschreibung ", 2004, "Bibliographisches Institut, Mannheim ", "3-411-04013-0", "-"));
        }catch (IllegalArgumentException iae){
            System.err.println(iae.getMessage());
        }
        try {
            zettelkasten.addMedium(new Zeitschrift("Der Spiegel", "0038-7452 ", 54, 6));
        }catch (IllegalArgumentException iae){
            System.err.println(iae.getMessage());
        }
        try {
            zettelkasten.addMedium(new ElektronischesMedium("Hochschule Stralsund ", "http://www.hochschule-stralsund.de"));
        }catch (IllegalArgumentException iae){
            System.err.println(iae.getMessage());
        }

        for (Medium medium : zettelkasten) {
            System.out.println(medium.calculateRepresentation());

            }
        // Test für falschen Titel
        try {
            if(zettelkasten.dropMedium( "Der Spiege") == false){
                System.err.println("\nTitel nicht gefunden.");
            }
        }catch (IllegalArgumentException iae){
            System.err.println(iae.getMessage());
        }
        // Test für falschen Titel
        try {
            System.out.println(zettelkasten.findMedium("Live at Wemble").calculateRepresentation());
        }catch (NullPointerException npe){
            System.err.println(npe.getMessage());

        }
        // aufsteigen sortieren
        zettelkasten.sort("aufsteigend");
        for (Medium medium : zettelkasten) {
            System.out.println(medium.calculateRepresentation());}

        // HumanReadable speichern
        HumanReadablePersistency hrp = new HumanReadablePersistency();
        hrp.save(zettelkasten, "data/human.ser");

        //HumanReadable laden
        try {
            hrp.load("data/human.ser");
        }catch (UnsupportedOperationException uoe){
            System.err.println(uoe.getMessage());
        }

        //BinaryPersistency speichern
        BinaryPersistency bp = new BinaryPersistency();
        bp.save(zettelkasten,"data/sichern.ser");

        // BinaryPersistency laden
        Zettelkasten zk1 = bp.load("data/sichern.ser");
        for (Medium medium : zk1) {
            System.out.println(medium.calculateRepresentation());
        }
    }
}