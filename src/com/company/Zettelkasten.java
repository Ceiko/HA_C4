package com.company;

import java.util.ArrayList;
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


    @Override
    public Iterator iterator() {
        return myZettelkasten.iterator();
    }
}

