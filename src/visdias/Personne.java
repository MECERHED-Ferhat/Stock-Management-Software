/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visdias;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public abstract class Personne {
    protected String code;
    protected String designation;
    protected String adresse;
    protected double chiffreAffaire;
    protected double resteRegler;
    
    protected Coordonnee crd;
    protected ArrayList<Payement> listPayement;
    
    public static Personne personneCourante;

    public Personne(String designation, String adresse, double chiffreAffaire, double resteRegler) {  
        this.designation = designation;
        this.adresse = adresse;
        this.chiffreAffaire = chiffreAffaire;
        this.resteRegler = resteRegler;
        this.crd = new Coordonnee("", this.designation, this.adresse, "", "", "", "", "", "", "");
        this.listPayement = new ArrayList<>();
    }
    
    public static String[] colonne(){
        return new String[]{"Code","Désignation","Adresse","Chiffre d'affaire","Reste à régler"};
    }
    
    public static String[][] ligne(ArrayList<Personne> list){
        String[][] lig = new String[list.size()][5];
        int j = 0;
        for(Personne i : list){
            lig[j][0] = i.code;
            lig[j][1] = i.designation;
            lig[j][2] = i.adresse;
            lig[j][3] = VisDias.formatDouble.format(i.chiffreAffaire);
            lig[j][4] = VisDias.formatDouble.format(i.resteRegler);
            j++;
        }
        return lig;
    }
    
    void modifier(String designation, String adresse, double chiffreAffaire, double resteRegler){
        if(designation!=null)
            this.designation = designation;
        if(adresse!=null)
            this.adresse = adresse;
        if(chiffreAffaire != -1)
            this.chiffreAffaire = chiffreAffaire;
        if(resteRegler != -1)
            this.resteRegler = resteRegler;
    }
    
    public boolean identique(Object obj){
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        return this.designation.equals(other.designation) && this.adresse.equals(other.adresse)
                && this.chiffreAffaire==other.chiffreAffaire && this.resteRegler==other.resteRegler;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        return Objects.equals(this.code, other.code);
    }
    
    public String[] displayRow(){
        return new String[]{this.code,this.designation,this.adresse,VisDias.formatDouble.format(this.chiffreAffaire),VisDias.formatDouble.format(this.resteRegler)};
    }
    
    abstract void supprimer();
    
}
