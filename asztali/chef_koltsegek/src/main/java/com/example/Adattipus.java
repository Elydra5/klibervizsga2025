package com.example;

import java.sql.Date;

public class Adattipus {
    public int id;
    public String chefname;
    public Date datum;
    public String kategoria;
    public int osszeg;
    public String megjegyzes;

    public Adattipus(int id, String chefname, Date datum, String kategoria, int osszeg, String megjegyzes) {
        this.id = id;
        this.chefname = chefname;
        this.datum = datum;
        this.kategoria = kategoria;
        this.osszeg = osszeg;
        this.megjegyzes = megjegyzes;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getChefname() {
        return chefname;
    }
    public void setChefname(String chefname) {
        this.chefname = chefname;
    }
    public Date getDatum() {
        return datum;
    }
    public void setDatum(Date datum) {
        this.datum = datum;
    }
    public String getKategoria() {
        return kategoria;
    }
    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
    public int getOsszeg() {
        return osszeg;
    }
    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }
    public String getMegjegyzes() {
        return megjegyzes;
    }
    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }

    public Adattipus(String string){
        String[] parts = string.split(";");
        this.id = Integer.parseInt(parts[0]);
        this.chefname = parts[1];
        this.datum = Date.valueOf(parts[2]);
        this.kategoria = parts[3];
        this.osszeg = Integer.parseInt(parts[4]);
        this.megjegyzes = parts[5];
    }
}
