/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visdias;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author USER
 */
public abstract class SimpleArticle {
    protected String code;
    protected String designation;
    protected Date dateCreation;
    protected String unite;
    protected int quantiteStock;
    protected double prixUT;
    protected double tva;
    protected double prixTTC;
    
    public static SimpleArticle articleCourant;
    public static ArrayList<String> listUnite = new ArrayList<String>();
    
    public SimpleArticle(String designation, Date dateCreation, String unite, int quantiteStock, double prixUT, double tva) {
        this.designation = designation;
        this.dateCreation = dateCreation;
        this.unite = unite;
        this.quantiteStock = quantiteStock;
        this.prixUT = prixUT;
        this.tva = tva;
        this.prixTTC = prixUT + prixUT*tva/100;
    }
    
    public static String[] colonne(){
        return new String[]{"Code","Désignation","Date de création","Unité","Quantité","Prix unitaire HT", "T.V.A(%)", "Prix unitaire TTC"};
    }
    
    public static String[][] ligne(ArrayList<SimpleArticle> list){
        String[][] lig = new String[list.size()][8];
        int j = 0;
        for(SimpleArticle i : list){
            lig[j][0] = i.code;
            lig[j][1] = i.designation;
            lig[j][2] = i.dateCreation.toString();
            lig[j][3] = i.unite;
            lig[j][4] = VisDias.formatInt.format(i.quantiteStock);
            lig[j][5] = VisDias.formatDouble.format(i.prixUT);
            lig[j][6] = VisDias.formatDouble.format(i.tva);
            lig[j][7] = VisDias.formatDouble.format(i.prixTTC);
            j+=1;
        }
        return lig;
    }
    
    public String[] displayRow(){
        return new String[]{this.code, this.designation, this.dateCreation.toString(), this.unite, VisDias.formatInt.format(this.quantiteStock), VisDias.formatDouble.format(this.prixUT), VisDias.formatDouble.format(this.tva), VisDias.formatDouble.format(this.prixTTC)};
    }
    
    void modifier(String designation, Date dateCreation, String unite, int quantiteStock, double prixUT, double tva, double prixTTC){
        if(designation != null)
            this.designation = designation;
        if(dateCreation != null)
            this.dateCreation = dateCreation;
        if(unite != null)
            this.unite = unite;
        if(quantiteStock != -1)
            this.quantiteStock = quantiteStock;
        if(prixUT != -1)
            this.prixUT = prixUT;
        if(tva != -1)
            this.tva = tva;
        if(prixTTC != -1)
            this.prixTTC = prixTTC;
    }
    
    abstract void supprimer();

    public boolean identique(Object obj){
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimpleArticle other = (SimpleArticle) obj;
        if (!Objects.equals(this.designation, other.designation)) {
            return false;
        }
        if (!Objects.equals(this.dateCreation, other.dateCreation)) {
            return false;
        }
        if (!Objects.equals(this.unite, other.unite)) {
            return false;
        }
        if (this.quantiteStock != other.quantiteStock) {
            return false;
        }
        if(this.tva != other.tva){
            return false;
        }
        return Double.doubleToLongBits(this.prixUT) == Double.doubleToLongBits(other.prixUT);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimpleArticle other = (SimpleArticle) obj;
        return Objects.equals(this.code, other.code);
    }
    
    
    public static void RajouterUnite(String ut){
        listUnite.add(ut);
    }
    
    public static boolean SupprimerUnite(String ut){
        return listUnite.remove(ut);
    }
    
    public static Object[] displayUnite(){
        return listUnite.toArray();
    }
}
