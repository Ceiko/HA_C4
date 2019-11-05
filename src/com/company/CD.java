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
        if (!(label == null || label.isEmpty())){
            this.label = label;
        }else{
            System.err.println("Label darf nicht leer oder null sein!");
        }
    }

    public String getKuenstler() {
        return kuenstler;
    }

    public void setKuenstler(String kuenstler) {
        if (!(kuenstler == null || kuenstler.isEmpty())){
            this.kuenstler = kuenstler;
        }else{
            System.err.println("Kuenstler darf nicht leer oder null sein!");
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
