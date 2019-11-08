package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class HumanReadablePersistency implements Persistency {
    @Override
    public void save(Zettelkasten zk, String dateiname) {
        try {
            FileWriter fw = new FileWriter("data/text.txt");
            for (Medium medium : zk) {
                fw.write(medium.calculateRepresentation());
            }

        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    @Override
    public Zettelkasten load(String dateiname) {
        throw new UnsupportedOperationException("Noch nicht implementiert");
    }
}

