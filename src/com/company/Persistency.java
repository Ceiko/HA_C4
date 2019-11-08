package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Persistency {
    public void save (Zettelkasten zk, String dateiname) ;
    public Zettelkasten load (String dateiname) ;
}
