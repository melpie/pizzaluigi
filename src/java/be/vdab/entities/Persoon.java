/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.entities;

/**
 *
 * @author pieter.mels
 */
public class Persoon {
    
    private String voornaam;
    private String familienaam;
    private int aantalKinderen;
    private boolean gehuwd;
    private Adres adres;
    
    public String getVoornaam() {
        return voornaam;
    }
    
    public String getFamilienaam() {
        return familienaam;
    }
    
    public int getAantalKinderen() {
        return aantalKinderen;
    }
    
    public boolean isGehuwd() {
        return gehuwd;
    }
    
    public void setVoornaam(String voornaam) {
        if (voornaam == null || voornaam.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.voornaam = voornaam;
    }
    
    public void setFamilienaam(String familienaam) {
        if (familienaam == null || familienaam.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.familienaam = familienaam;
    }
    
    public void setAantalKinderen(int aantalKinderen) {
        if (aantalKinderen < 0) {
            throw new IllegalArgumentException();
        }
        this.aantalKinderen = aantalKinderen;
    }
    
    public void setGehuwd(boolean gehuwd) {
        this.gehuwd = gehuwd;
    }
    
    public String getNaam() {
        return voornaam + ' ' + familienaam;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
       
}
