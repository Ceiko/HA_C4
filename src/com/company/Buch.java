package com.company;

/**
 * Dies ist eine Unterklasse und erbt von Medium, dies erkennt man an "extends".
 */

public class Buch extends Medium {
    private int erscheinungsjahr;
    private String verlag;
    private String isbn;
    private String verfasser;

    public Buch(String titel, int erscheinungsjahr, String verlag, String isbn, String verfasser) {
        super(titel);
        setErscheinungsjahr(erscheinungsjahr);
        setVerlag(verlag);
        setIsbn(isbn);
        setVerfasser(verfasser);
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        if (!(erscheinungsjahr == 0 )){
            this.erscheinungsjahr = erscheinungsjahr;
        }else{
            System.err.println("Erscheinungsjahr darf nicht null sein!");
        }
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String verlag) {
        if (!(verlag == null || verlag.isEmpty())){
            this.verlag = verlag;
        }else{
            System.err.println("Verlag darf nicht leer oder null sein!");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    /**
     * checkt die ISBN und gibt im Fehlerfall "falsche ISBN" auf der Konsole aus.
     *
     * @param isbn als String
     */
    public void setIsbn(String isbn) {
        String[] tmpISBN = isbn.replaceAll("-", "").split("(?!^)");
        int[] ints = new int[tmpISBN.length];

        for (int i = 0; i < tmpISBN.length; i++) {
            ints[i] = Integer.parseInt(tmpISBN[i]);
        }

        if (checkISBN10(ints) || checkISBN13(ints)) {
            this.isbn = isbn;
        } else {
            System.err.println("falsche ISBN");
        }


    }

    public String getVerfasser() {
        return verfasser;
    }

    public void setVerfasser(String verfasser) {
        if (!(verfasser == null || verfasser.isEmpty())){
            this.verfasser = verfasser;
        }else{
            System.err.println("Verfasser darf nicht leer oder null sein!");
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
        sb.append("Erscheinungsjahr: ");
        sb.append(this.erscheinungsjahr);
        sb.append("\n");
        sb.append("Verlag: ");
        sb.append(this.verlag);
        sb.append("\n");
        sb.append("ISBN: ");
        sb.append(this.isbn);
        sb.append("\n");
        sb.append("Verfasser: ");
        sb.append(this.verfasser);
        return super.calculateRepresentation() + sb.toString();
    }

    /**
     * Dies sind die Prüfroutinen für ISBN10 und ISBN13
     *
     * @param isbn als int
     * @return integer
     */
    private static boolean checkISBN10(int[] isbn) {
        int sum = 0;
        for (int i = 1; i <= isbn.length; i++) {
            sum += i * isbn[i - 1];
        }
        if (sum % 11 == 0) {
            return true;
        } else {

            return false;
        }

    }

    private static boolean checkISBN13(int[] isbn) {
        int sum = 0;
        for (int i = 1; i < isbn.length; i++) {
            if (i % 2 == 0) {
                sum += isbn[i - 1] * 3;
            } else {
                sum += isbn[i - 1];
            }
        }

        int lastDigit = sum % 10;

        int check = (10 - lastDigit) % 10;

        if (isbn[isbn.length - 1] == check) {
            return true;
        } else {
            return false;
        }
    }
}
