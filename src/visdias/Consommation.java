/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visdias;

import java.util.ArrayList;
import java.util.Objects;


public class Consommation {
    public static int codeSeqCS = 10000;
    
    protected String refArticle;
    protected String code;
    protected String designation;
    protected Date dateConso;
    protected String unite;
    protected int quantite;
    protected double prixUT;
    protected double prixTT;
    protected int typeConso;
    protected int quantiteUT;
    
    public static final int[] TYPE_CONV = {-1, 2500, 1041, 1724, 1315, 1612, 1470, 1162};
    
    public static Consommation consoCourant = null;


    public Consommation(String refArticle, String code, String designation, Date dateConso, String unite, int quantite, double prixUT, double prixTT, int typeConso, int quantiteUT) {
        this.refArticle = refArticle;
        this.code = code;
        this.designation = designation;
        this.dateConso = dateConso;
        this.unite = unite;
        this.quantite = quantite;
        this.prixUT = prixUT;
        this.prixTT = prixTT;
        this.typeConso = typeConso;
        this.quantiteUT = quantiteUT;
    }
    public Consommation(String refArticle, String designation, Date dateConso, String unite, int quantite, double prixUT, double prixTT, int typeConso, int quantiteUT) {
        this.refArticle = refArticle;
        this.designation = designation;
        this.dateConso = dateConso;
        this.unite = unite;
        this.quantite = quantite;
        this.prixUT = prixUT;
        this.prixTT = prixTT;
        this.typeConso = typeConso;
        this.quantiteUT = quantiteUT;
        
        codeSeqCS++;
        this.code = "CS"+codeSeqCS;
    }

    public static String[] colonne(){
        return new String[]{"Code", "Désignation", "Date", "Unité", "Quantité", "QT unitaire", "Prix unitaire TTC", "Prix total TTC"};
    }

    public static Consommation get(String code){
        for(Consommation i : VisDias.listConsommation){
            if(i.code.equals(code)){
                return i;
            }
        }
        return null;
    }
    
    public static String[][] display(Object grp, String desig, Date dateMin, Date dateMax){
        if(grp == null)
            return new String[0][8];
        ArrayList<Consommation> list = new ArrayList<>();
        ArrayList<GroupeConso> listGrp = new ArrayList<>();
        if(grp.getClass() == GroupeConso.class){
            listGrp.add((GroupeConso)grp);
        }else{
            listGrp = (ArrayList<GroupeConso>)grp;
        }
        for(GroupeConso grpCr : listGrp){
            for(String i : grpCr.refArticle){
                Consommation tmp = get(i);
                if(tmp == null)
                    continue;
                if(desig != null)
                    if(!tmp.designation.toLowerCase().contains(desig.toLowerCase()))
                        continue;
                if(dateMin != null)
                    if(tmp.dateConso.compareTo(dateMin)==-1)
                        continue;
                if(dateMax != null)
                    if(tmp.dateConso.compareTo(dateMax)==1)
                        continue;
                list.add(tmp);
            }
        }
        String[][] lig = new String[list.size()][8];
        int j = 0;
        
        for(Consommation i : list){
            lig[j][0] = i.code;
            lig[j][1] = i.designation;
            lig[j][2] = i.dateConso.toString();
            lig[j][3] = i.unite;
            lig[j][4] = VisDias.formatInt.format(i.quantite);
            if(i.typeConso == -1)
                lig[j][5] = "";
            else
                lig[j][5] = VisDias.formatInt.format(i.quantiteUT);
            lig[j][6] = VisDias.formatDouble.format(i.prixUT);
            lig[j][7] = VisDias.formatDouble.format(i.prixTT);
            j++;
        }
        return lig;
    }
    
    public String[] displayRow(){
        return new String[]{this.code, this.designation, this.dateConso.toString(),
            this.unite, VisDias.formatInt.format(this.quantite),
            VisDias.formatDouble.format(this.prixUT), VisDias.formatDouble.format(this.prixTT)
        };
    }
    
    void modifier(String designation, Date dateConso, String unite, int quantite, int typeConso, int qtut, double prixUT, double prixTT){
        if(designation != null)
            this.designation = designation;
        if(dateConso != null)
            this.dateConso = dateConso;
        if(unite != null)
            this.unite = unite;
        if(quantite != -1)
            this.quantite = quantite;
        if(prixUT != -1)
            this.prixUT = prixUT;
        if(prixTT != -1)
            this.prixTT = prixTT;
        this.typeConso = typeConso;
        this.quantiteUT = qtut;
    }
    
    void supprimer(){
        if(this.refArticle != null && ArticleAchat.get(this.refArticle) != null){
            ArticleAchat.get(this.refArticle).quantiteStock += this.quantite;
        }
        VisDias.listConsommation.remove(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consommation other = (Consommation) obj;
        return Objects.equals(this.code, other.code);
    }
}
