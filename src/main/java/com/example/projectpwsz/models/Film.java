package com.example.projectpwsz.models;


public class Film {

  private long id;
  private String tytul;
  private String rok;
  private long czasTrwania;
  private String gatunek;
  private String nazwaStudia;

  public Film(long id, String tytul, String rok, long czasTrwania, String gatunek, String nazwaStudia) {
    this.id = id;
    this.tytul = tytul;
    this.rok = rok;
    this.czasTrwania = czasTrwania;
    this.gatunek = gatunek;
    this.nazwaStudia = nazwaStudia;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTytul() {
    return tytul;
  }

  public void setTytul(String tytul) {
    this.tytul = tytul;
  }


  public String getRok() {
    return rok;
  }

  public void setRok(String rok) {
    this.rok = rok;
  }


  public long getCzasTrwania() {
    return czasTrwania;
  }

  public void setCzasTrwania(long czasTrwania) {
    this.czasTrwania = czasTrwania;
  }


  public String getGatunek() {
    return gatunek;
  }

  public void setGatunek(String gatunek) {
    this.gatunek = gatunek;
  }


  public String getNazwaStudia() {
    return nazwaStudia;
  }

  public void setNazwaStudia(String nazwaStudia) {
    this.nazwaStudia = nazwaStudia;
  }

}
