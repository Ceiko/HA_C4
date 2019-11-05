package com.company;

/**
 * Diese Klasse ist die Oberklasse, die anderen Klassen erben von ihr.
 */

public abstract class Medium {
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
        if (!(titel == null || titel.isEmpty())){
            this.titel = titel;
        }else{
            System.err.println("Titel darf nicht leer oder null sein!");
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

}


