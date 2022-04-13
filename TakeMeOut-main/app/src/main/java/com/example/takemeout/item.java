package com.example.takemeout;

public class item {
    private int background;
    private String TitlosMagaziou;
    private String OdosMagaziou;
    private String key_id;
    private String favStatus;

    public item(){

    }
    // constructor
    public item(int background, String TitlosMagaziou, String OdosMagaziou, String key_id, String favStatus) {
        this.background = background;
        this.TitlosMagaziou = TitlosMagaziou;
        this.OdosMagaziou = OdosMagaziou;
        this.key_id = key_id;
        this.favStatus = favStatus;

    }

    //getters & setters
    public int getBackground() {
        return background;
    }

    public String getTitlosMagaziou() {
        return TitlosMagaziou;
    }

    public String getOdosMagaziou() {
        return OdosMagaziou;
    }

    public String getKey_id() {return key_id;}

    public String getFavStatus(){ return favStatus; }

    public void setBackground(int background) {
        this.background = background;
    }

    public void setTitlosMagaziou(String titlosMagaziou) {
        TitlosMagaziou = titlosMagaziou;
    }

    public void setOdosMagaziou(String odosMagaziou) {
        OdosMagaziou = odosMagaziou;
    }

    public void setKey_id(String key_id) {this.key_id = key_id;}

    public void setFavStatus(String favStatus) {this.favStatus = favStatus;}
}
