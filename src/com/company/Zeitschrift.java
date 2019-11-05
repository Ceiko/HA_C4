package com.company;

/**
 * Dies ist eine Unterklasse und erbt von Medium, dies erkennt man an "extends".
 */
public class Zeitschrift extends Medium {
    private String issn;
    private int volume;
    private int nummer;

    public Zeitschrift(String titel, String issn, int volume, int nummer) {
        super(titel);
        setIssn(issn);
        setVolume(volume);
        setNummer(nummer);
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        if (!(issn == null || issn.isEmpty())){
            this.issn = issn;
        }else{
            System.err.println("Issn darf nicht leer oder null sein!");
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (!(volume == 0 )){
            this.volume = volume;
        }else{
            System.err.println("Volume darf nicht null sein!");
        }
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        if (!(nummer == 0 )){
            this.nummer = nummer;
        }else{
            System.err.println("Nummer darf nicht null sein!");
        }
    }

    /**
     * Diese Methode hängt an das Ende des Strings den Titel und die restlichen Variablen.
     *
     * @return String
     */
    @Override
    public String calculateRepresentation() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append("ISSN: ");
        sb.append(this.issn);
        sb.append("\n");
        sb.append("Volume: ");
        sb.append(this.volume);
        sb.append("\n");
        sb.append("Nummer: ");
        sb.append(this.nummer);
        return super.calculateRepresentation() + sb.toString();
    }
}