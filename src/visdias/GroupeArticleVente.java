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
public class GroupeArticleVente extends GroupeArticle{

    public static GroupeArticleVente groupeVenteActif = null;

    public GroupeArticleVente(String designation) {
        super(designation);
    }

    @Override
    void supprimer() {
        VisDias.listGroupeArticleVente.remove(this);
    }
    
    public static String[][] display(){
        String[][] lig = new String[VisDias.listGroupeArticleVente.size()][2];
        int j = 0;
        for(GroupeArticleVente i : VisDias.listGroupeArticleVente){
            lig[j][0] = i.designation;
            lig[j][1] = Integer.toString(i.refArticle.size());
            j++;
        }
        return lig;
    }
    
    public static String[] displayCombo(){
        String[] lig = new String[VisDias.listGroupeArticleVente.size()];
        int j = 0;
        for(GroupeArticleVente i : VisDias.listGroupeArticleVente){
            lig[j] = i.designation;
            j++;
        }
        return lig;
    }
    
    public static GroupeArticleVente get(String desig){
        int j = 0;
        for(GroupeArticleVente i : VisDias.listGroupeArticleVente){
            if(desig.equals(i.designation))
                return i;
        }
        return null;
    }
}
