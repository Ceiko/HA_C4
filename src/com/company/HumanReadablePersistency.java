package com.company;

import java.io.FileWriter;

public class HumanReadablePersistency implements Persistency {
    @Override
    public void save(Zettelkasten zk, String dateiname) {
        FileWriter fw = new FileWriter();
    }

    @Override
    public Zettelkasten load(String dateiname) {
        throw new UnsupportedOperationException();
    }
}

