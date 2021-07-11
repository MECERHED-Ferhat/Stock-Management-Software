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
public class BonAchat extends Bon {
    
    public static int codeSeqBA = 10000;

    public BonAchat(String code, String designation, Date dateCreation, String refPersonne) {
        super(designation, dateCreation, refPersonne);
        this.code = code;
    }
    
    public BonAchat(String designation, Date dateCreation, String refPersonne) {
        super(designation, dateCreation, refPersonne);
        codeSeqBA++;
        this.code = "BA" + codeSeqBA;
    }

    @Override
    void supprimer() {
        ArticleAchat tmpArt;
        for(ArticleBon i : this.listArticleBon){
            tmpArt = ArticleAchat.get(i.refArticle);
            if(tmpArt != null){
                tmpArt.quantiteStock -= i.quantite;
            }
        }
        Fournisseur tmpFr = Fournisseur.get(this.refPersonne);
        if(tmpFr != null){
            tmpFr.chiffreAffaire -= this.prixTTC;
        }
        VisDias.listBonAchat.remove(this);
    }

    public static String[][] display(String desig, Date dateMin, Date dateMax, String refPer) {
        ArrayList<Bon> list = new ArrayList<>();
        if(desig != null || dateMin != null || dateMax != null || refPer != null){
            for(BonAchat i : VisDias.listBonAchat){
                if(desig != null)
                    if(!i.designation.toLowerCase().contains(desig.toLowerCase()))
                        continue;
                if(dateMin != null)
                    if(i.dateCreation.compareTo(dateMin)==-1)
                        continue;
                if(dateMax != null)
                    if(i.dateCreation.compareTo(dateMax)==1)
                        continue;
                if(refPer != null)
                    if(!i.refPersonne.equals(refPer))
                        continue;
                list.add(i);
            }
        }else{
            list.addAll(VisDias.listBonAchat);
        }
        return Bon.ligne(list);
    }
    
    public static BonAchat get(String code){
        int j = 0;
        for(BonAchat i : VisDias.listBonAchat){
            if(i.code.equals(code))
                return i;
        }
        return null;
    }
}
