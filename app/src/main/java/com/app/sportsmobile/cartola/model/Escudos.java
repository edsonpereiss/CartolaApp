package com.app.sportsmobile.cartola.model;

/**
 * Created by Edson on 09/01/2017.
 */
public class Escudos {

    public String trinta = "30x30";
    public String quarenta_e_cinco = "45x45";
    public String sessenta = "60x60";
    public Escudos(){

    }

    public Escudos(String trinta,
                   String quarenta_e_cinco,
                   String sessenta)
    {
        this.trinta = trinta;
        this.quarenta_e_cinco = quarenta_e_cinco;
        this.sessenta = sessenta;
    }

    public String getTrinta() {
        return trinta;
    }

    public void setTrinta(String trinta) {
        this.trinta = trinta;
    }


    public String getQuarentaECinco() {
        return quarenta_e_cinco;
    }

    public void setQuarentaECinco(String quarenta_e_cinco) {
        this.quarenta_e_cinco = quarenta_e_cinco;
    }

    public String getSessenta() {
        return sessenta;
    }

    public void setSessenta(String sessenta) {
        this.sessenta = sessenta;
    }
}
