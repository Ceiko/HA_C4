package com.company;

/**
 * Dies ist eine Unterklasse und erbt von Medium, dies erkennt man an "extends".
 */

public class CD extends Medium {
    private String label;
    private String kuenstler;


    public CD(String titel, String label, String kuenstler) {
        super(titel);
        setLabel(label);
        setKuenstler(kuenstler);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        if (!(label == null && label.isBlank())){
            this.label = label;
        }else{
            throw new IllegalArgumentException("Label darf nicht leer oder null sein!");
        }
    }

    public String getKuenstler() {
        return kuenstler;
    }

    public void setKuenstler(String kuenstler) {
        if (!(kuenstler == null && kuenstler.isBlank())){
            this.kuenstler = kuenstler;
        }else{
            throw new IllegalArgumentException("Kuenstler darf nicht leer oder null sein!");
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
        sb.append("Label: ");
        sb.append(this.label);
        sb.append("\n");
        sb.append("Künstler: ");
        sb.append(this.kuenstler);
        return super.calculateRepresentation() + sb.toString();
    }
}
