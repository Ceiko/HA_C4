package com.company;

import java.io.*;

/**
 * Diese Klasse Serialisiert und Deserialisiert Objekte.
 * @author Nick Kudin
 */


public class BinaryPersistency implements Persistency {

    /**
     * Diese Methode speichert Zettelkasten in einer Datei.
     * @param zk
     * @param dateiname
     */
    @Override
    public void save(Zettelkasten zk, String dateiname) {

        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(dateiname));
            out.writeObject(zk);
            out.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

    }

    /**
     * Diese Methode lädt Zettelkasten aus einer Datei
     * @param dateiname
     * @return null
     */
    @Override
    public Zettelkasten load(String dateiname) {

        try {
            ObjectInput in = new ObjectInputStream(new FileInputStream(dateiname));
            Zettelkasten zk = (Zettelkasten) in.readObject();
            in.close();
            return zk;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Klasse nicht gefunden");
        }
        return null;

    }
}
