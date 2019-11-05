package com.company;

import java.net.URL;

/**
 * Dies ist eine Unterklasse und erbt von Medium, dies erkennt man an "extends".
 */

public class ElektronischesMedium extends Medium {
    private String url;

    public ElektronischesMedium(String titel, String url) {
        super(titel);
        setUrl(url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {

        if (checkURL(url)) {
            if (!(url == null || url.isEmpty())){
                this.url = url;
            }else{
                System.err.println("Url darf nicht leer oder null sein!");
            }
        } else {
            System.out.println("falche URL");
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
        sb.append("URL: ");
        sb.append(this.url);
        return super.calculateRepresentation() + sb.toString();
    }

    /**
     * Prüfroutine für URL.
     *
     * @param urlString als String
     * @return String
     */

    private static boolean checkURL(String urlString) {
        try {
            URL url = new URL(urlString);
            url.toURI();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}