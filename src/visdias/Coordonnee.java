/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visdias;

/**
 *
 * @author USER
 */
public class Coordonnee {
    protected String cevilite;
    protected String designation;
    protected String adresse;
    protected String nTel;
    protected String nRC;
    protected String nArt;
    protected String NIF;
    protected String NIS;
    protected String compteBancaire;
    protected String Fonction;

    public Coordonnee(String cevilite, String designation, String adresse, String nTel, String nRC, String nArt, String NIF, String NIS, String compteBancaire, String Fonction) {
        this.cevilite = cevilite;
        this.designation = designation;
        this.adresse = adresse;
        this.nTel = nTel;
        this.nRC = nRC;
        this.nArt = nArt;
        this.NIF = NIF;
        this.NIS = NIS;
        this.compteBancaire = compteBancaire;
        this.Fonction = Fonction;
    }
    
    void modifier(String cevilite, String designation, String adresse, String nTel, String nRC, String nArt, String NIF, String NIS, String compteBancaire, String Fonction){
        this.cevilite = cevilite;
        this.designation = designation;
        this.adresse = adresse;
        this.nTel = nTel;
        this.nRC = nRC;
        this.nArt = nArt;
        this.NIF = NIF;
        this.NIS = NIS;
        this.compteBancaire = compteBancaire;
        this.Fonction = Fonction;
    }
    
    
}
