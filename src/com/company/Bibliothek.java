package com.company;

/**
 * Dieses Programm speichert Werte in einem Array und gibt diese auf der Konsole aus.
 * @author Nick Kudin
 * @version Aufgabe A11
 */
public class Bibliothek {

    public static void main(String[] args) {

        Zettelkasten zettelkasten = new Zettelkasten();
        zettelkasten.addMedium(new CD("Live At Wembley", "Parlophone (EMI)", "Queen"));
        zettelkasten.addMedium(new Buch("Duden 01. Die deutsche Rechtschreibung ", 2004, "Bibliographisches Institut, Mannheim ", "3-411-04013-0", "-"));
        zettelkasten.addMedium(new Zeitschrift("Der Spiegel", "0038-7452 ", 54, 6));
        zettelkasten.addMedium(new ElektronischesMedium("Hochschule Stralsund ", "http://www.hochschule-stralsund.de"));

        for (Medium medium : zettelkasten) {
            System.out.println(medium.calculateRepresentation());

            }
        zettelkasten.sort("aufsteigend");
        for (Medium medium : zettelkasten) {
            System.out.println(medium.calculateRepresentation());}
    }
}