package com.company;

/**
 * Diese Klasse ist die Oberklasse, die anderen Klassen erben von ihr.
 */

public abstract class Medium implements Comparable<Medium> {
    private String titel;

    public Medium() {

    }

    public Medium(String titel) {
        setTitel(titel);
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        if (!(titel == null && titel.isBlank())){
            this.titel = titel;
        }else{
            throw new IllegalArgumentException("Titel darf nicht leer oder null sein!");
        }
    }

    /**
     * Diese Methode hängt an das Ende des Strings den Titel an
     *
     * @return String
     */
    public String calculateRepresentation() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append("Titel: ");
        sb.append(this.titel);
        return sb.toString();
    }

    public int compareTo (Medium medium){
        return this.getTitel().compareTo(medium.getTitel());

    }

}


