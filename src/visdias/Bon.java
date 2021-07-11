/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visdias;

import java.util.ArrayList;
import java.util.Objects;


public abstract class Bon {
    //Références
    protected String refPersonne;
    
    protected String code;
    protected String designation;
    protected Date dateCreation;
    protected Double prixTT;
    protected Double prixTTC;
    
    protected ArrayList<ArticleBon> listArticleBon;
    
    public static Bon BonActif = null;
    public static Bon BonCourant;

    public Bon(String designation, Date dateCreation, String refPersonne) {
        this.designation = designation;
        this.dateCreation = dateCreation;
        this.prixTT = 0.0;
        this.prixTTC = 0.0;
        this.refPersonne = refPersonne;
        this.listArticleBon = new ArrayList<>();
    }
    
    public static String[] colonne(){
        return new String[]{"Code","Désignation","Date","Prix total HT", "Prix total TTC"};
    }
    
    public static String[][] ligne(ArrayList<Bon> list){
        String[][] lig = new String[list.size()][6];
        int j = 0;
        for(Bon i : list){
            lig[j][0] = i.code;
            lig[j][1] = i.designation;
            lig[j][2] = i.dateCreation.toString();
            lig[j][3] = VisDias.formatDouble.format(i.prixTT);
            lig[j][4] = VisDias.formatDouble.format(i.prixTTC);
            j++;
        }
        return lig;
    }
    
    public String[] displayRow(){
        return new String[]{this.code, this.designation, this.dateCreation.toString(), VisDias.formatDouble.format(this.prixTT), VisDias.formatDouble.format(this.prixTTC)};
    }
    
    void modifier(String designation, Date dateCreation, Double prixTT, Double prixTTC){
        if(designation != null)
            this.designation = designation;
        if(dateCreation != null)
            this.dateCreation = dateCreation;
        if(prixTT != -1)
            this.prixTT = prixTT;
        if(prixTTC != -1)
            this.prixTTC = prixTTC;
    }

    public boolean identique(Object obj){
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bon other = (Bon) obj;
        if (!Objects.equals(this.refPersonne, other.refPersonne)) {
            return false;
        }
        if (!Objects.equals(this.designation, other.designation)) {
            return false;
        }
        if (!Objects.equals(this.dateCreation, other.dateCreation)) {
            return false;
        }
        return Objects.equals(this.prixTT, other.prixTT);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bon other = (Bon) obj;
        return Objects.equals(this.code, other.code);
    }
    
    abstract void supprimer();
}
