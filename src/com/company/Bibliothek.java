package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Dieses Programm speichert Werte in einem Array und gibt diese auf der Konsole aus.
 * @author Nick Kudin
 * @version Aufgabe A11
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
        zettelkasten.sort("aufsteigend");
        for (Medium medium : zettelkasten) {
            System.out.println(medium.calculateRepresentation());}

        BinaryPersistency bp = new BinaryPersistency();
        bp.save(zettelkasten,"sichern");

        Zettelkasten zk1 = bp.load("sichern");
        for (Medium medium : zk1) {
            System.out.println(medium.calculateRepresentation());
        }
    }
}