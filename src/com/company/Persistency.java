package com.company;

/**
 * Dieses Interface enthält die Methoden save und load.
 * @author Nick Kudin
 */

public interface Persistency {
    public void save (Zettelkasten zk, String dateiname) ;
    public Zettelkasten load (String dateiname) ;
}
