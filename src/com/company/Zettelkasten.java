package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Zettelkasten implements Iterable<Medium>{

    private ArrayList<Medium> myZettelkasten = new ArrayList<>();

    public void addMedium(Medium medium){
         myZettelkasten.add(medium);

    }

    public void dropMedium(){

    }

    public void findMedium(){

    }


    @Override
    public Iterator iterator() {
        return myZettelkasten.iterator();
    }
}

