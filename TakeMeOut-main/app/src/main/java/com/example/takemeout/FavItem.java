package com.example.takemeout;

public class FavItem {

    private int background;
    private String TitlosMagaziou;
    private String OdosMagaziou;
    private String key_id;
    private String favStatus;

    public FavItem(){

    }

    public FavItem(int background, String TitlosMagaziou, String OdosMagaziou, String key_id, String favStatus) {
        this.background = background;
        this.TitlosMagaziou = TitlosMagaziou;
        this.OdosMagaziou = OdosMagaziou;
        this.key_id = key_id;
        this.favStatus = favStatus;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public String getTitlosMagaziou() {
        return TitlosMagaziou;
    }

    public void setTitlosMagaziou(String titlosMagaziou) {
        TitlosMagaziou = titlosMagaziou;
    }

    public String getOdosMagaziou() {
        return OdosMagaziou;
    }

    public void setOdosMagaziou(String odosMagaziou) {
        OdosMagaziou = odosMagaziou;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }
}
