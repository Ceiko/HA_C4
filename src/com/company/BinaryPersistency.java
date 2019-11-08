package com.company;

import java.io.*;
import java.util.ArrayList;

public class BinaryPersistency implements Persistency {
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
