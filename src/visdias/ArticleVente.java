/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visdias;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ArticleVente extends SimpleArticle{
    public static int codeSeqAV = 10000;

    public ArticleVente(String code, String designation, Date dateCreation, String unite, int quantiteCourante, double prixUT, double tva) {
        super(designation, dateCreation, unite, quantiteCourante, prixUT, tva);
        this.code = code;
    }
    
    public ArticleVente(String designation, Date dateCreation, String unite, int quantiteCourante, double prixUT, double tva) {
        super(designation, dateCreation, unite, quantiteCourante, prixUT, tva);
        codeSeqAV++;
        this.code = "AV" + codeSeqAV;
    }
    
    @Override
    void supprimer() {
        VisDias.listArticleVente.remove(this);
    }
    
    public static ArticleVente get(String code){
        for(ArticleVente i : VisDias.listArticleVente){
            if(i.code.equals(code))
                return i;
        }
        return null;
    }
    
    public static String[][] display(Object grp, String desig, Date dateMin, Date dateMax, boolean qt) {
        if(grp == null)
            return new String[0][8];
        ArrayList<SimpleArticle> list = new ArrayList<>();
        ArrayList<GroupeArticleVente> listGrp = new ArrayList<>();
        if(grp.getClass() == GroupeArticleVente.class){
            listGrp.add((GroupeArticleVente)grp);
        }else{
            listGrp = (ArrayList<GroupeArticleVente>)grp;
        }
        for(GroupeArticleVente grpCr : listGrp){
            for(String i : grpCr.refArticle){
                ArticleVente tmp = get(i);
                if(tmp == null)
                    continue;
                if(desig != null)
                    if(!tmp.designation.toLowerCase().contains(desig.toLowerCase()))
                        continue;
                if(dateMin != null)
                    if(tmp.dateCreation.compareTo(dateMin)==-1)
                        continue;
                if(dateMax != null)
                    if(tmp.dateCreation.compareTo(dateMax)==1)
                        continue;
                if(qt)
                    if(tmp.quantiteStock > 0)
                        continue;
                list.add(tmp);
            }
        }
        return SimpleArticle.ligne(list);
    }
}
