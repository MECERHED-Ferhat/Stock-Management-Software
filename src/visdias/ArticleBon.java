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
public class ArticleBon {
    protected String designation;
    protected String unite;
    protected int quantite;
    protected double prixUT;
    protected double prixTT;
    protected double tva;
    protected double prixUTC;
    protected double prixTTC;

    protected String refArticle;

    public ArticleBon(String refArticle, String designation, String unite, int quantite, double prixUT, double prixTT, double tva, double prixUTC, double prixTTC) {
        this.designation = designation;
        this.unite = unite;
        this.quantite = quantite;
        this.prixUT = prixUT;
        this.prixTT = prixTT;
        this.tva = tva;
        this.refArticle = refArticle;
        this.prixUTC = prixUTC;
        this.prixTTC = prixTTC;
    }
    
    public static String[] colonne(){
        return new String[]{"Source","Désignation","Unité","Quantité","Prix unitaire HT","Prix total HT", "T.V.A(%)", "Prix unitaire TTC", "Prix total TTC"};
    }
    
    public static String[][] display(Bon bn){
        if(bn == null)
            return new String[0][9];
        String[][] lig = new String[bn.listArticleBon.size()][9];
        int j = 0;
        for(ArticleBon i : bn.listArticleBon){
            lig[j][0] = i.refArticle;
            lig[j][1] = i.designation;
            lig[j][2] = i.unite;
            lig[j][3] = VisDias.formatInt.format(i.quantite);
            lig[j][4] = VisDias.formatDouble.format(i.prixUT);
            lig[j][5] = VisDias.formatDouble.format(i.prixTT);
            lig[j][6] = VisDias.formatDouble.format(i.tva);
            lig[j][7] = VisDias.formatDouble.format(i.prixUTC);
            lig[j][8] = VisDias.formatDouble.format(i.prixTTC);
            j++;
        }
        return lig;
    }
    
}
