package com.company;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Die Klasse erstellt und lädt Zettelkasten der für Menschen lesbar ist.
 * @author Nick Kudin
 */

public class HumanReadablePersistency implements Persistency {
    /**
     * Diese Methode speichert Zettelkasten unter dem angegeben Pfad.
     * @param zk
     * @param dateiname
     */
    @Override
    public void save(Zettelkasten zk, String dateiname) {
        try {
            FileWriter fw = new FileWriter(dateiname);
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

