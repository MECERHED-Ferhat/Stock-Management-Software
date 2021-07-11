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
public class ArticleAchat extends SimpleArticle {
    public static int codeSeqAA = 10000;

    public ArticleAchat(String code, String designation, Date dateCreation, String unite, int quantiteCourante, double prixUT, double tva) {
        super(designation, dateCreation, unite, quantiteCourante, prixUT, tva);
        this.code = code;
    }
    
    public ArticleAchat(String designation, Date dateCreation, String unite, int quantiteCourante, double prixUT, double tva) {
        super(designation, dateCreation, unite, quantiteCourante, prixUT, tva);
        codeSeqAA++;
        this.code = "AA"+codeSeqAA; 
    }
    
    @Override
    void supprimer() {
        VisDias.listArticleAchat.remove(this);
    }
    
    public static ArticleAchat get(String code){
        for(ArticleAchat i : VisDias.listArticleAchat){
            if(i.code.equals(code))
                return i;
        }
        return null;
    }
    
    public static String[][] display(Object grp, String desig, Date dateMin, Date dateMax, boolean qt) {
        if(grp == null)
            return new String[0][8];
        ArrayList<SimpleArticle> list = new ArrayList<>();
        ArrayList<GroupeArticleAchat> listGrp = new ArrayList<>();
        if(grp.getClass() == GroupeArticleAchat.class){
            listGrp.add((GroupeArticleAchat)grp);
        }else{
            listGrp = (ArrayList<GroupeArticleAchat>) grp;
        }
        for(GroupeArticleAchat grpCr : listGrp){
            for(String i : grpCr.refArticle){
                ArticleAchat tmp = get(i);
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
