package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Zettelkasten implements Iterable<Medium>{

    private ArrayList<Medium> myZettelkasten = new ArrayList<>();

    public void addMedium(Medium medium){
         myZettelkasten.add(medium);

    }

    public void dropMedium(String titel){
        for( int i = 0; i < myZettelkasten.size(); i++){
            if(myZettelkasten.get(i).getTitel().equals(titel)){
                myZettelkasten.remove(myZettelkasten.get(i));
            }else{
                System.err.println("Titel nicht gefunden");
            }
        }


    }

    public Medium findMedium(String titel){
        for (int i = 0; i < myZettelkasten.size(); i++){
            if (myZettelkasten.get(i).getTitel().equals(titel)){
                return  myZettelkasten.get(i);
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

    public void sort(String richtung){
        if (richtung.equals("absteigend")){
            for (int i = 0; i < myZettelkasten.size() - 1; i++){
                if (myZettelkasten.get( i + 1 ).compareTo(myZettelkasten.get(i)) < 0){
                    Collections.sort(myZettelkasten);
                    System.out.println("Wurde aufsteigend sortiert");
                }
            }

        }else if(richtung.equals("aufsteigend")){
            for (int i = 0; i < myZettelkasten.size() - 1; i++){ // -1 weil wir außerhalb des Index sind
                if (myZettelkasten.get(i + 1).compareTo(myZettelkasten.get(i)) > 0){
                    Collections.sort(myZettelkasten, Collections.reverseOrder()); // anders herum
                    System.out.println("Wurde absteigend sortiert");
                }
            }


        }

    }


    @Override
    public Iterator iterator() {
        return myZettelkasten.iterator();
    }
}

