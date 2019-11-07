package com.company;

import java.io.*;
import java.util.ArrayList;

public class BinaryPersistency implements Persistency{
    @Override
    public void save(Zettelkasten zk, String dateiname) throws IOException {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(dateiname));
        out.writeObject(zk);
        out.close();
    }

    @Override
    public Zettelkasten load(String dateiname) throws IOException, ClassNotFoundException {
        ObjectInput in = new ObjectInputStream(new FileInputStream(dateiname));
        Zettelkasten zk = (Zettelkasten) in.readObject();
        in.close();
        return zk;
    }
}
