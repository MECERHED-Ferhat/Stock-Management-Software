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
public class GroupeArticleAchat extends GroupeArticle {

    public static GroupeArticleAchat groupeAchatActif = null;
    
    public GroupeArticleAchat(String designation) {
        super(designation);
    }

    @Override
    void supprimer() {
        VisDias.listGroupeArticleAchat.remove(this);
    }
    
    public static String[][] display(){
        String[][] lig = new String[VisDias.listGroupeArticleAchat.size()][2];
        int j = 0;
        for(GroupeArticleAchat i : VisDias.listGroupeArticleAchat){
            lig[j][0] = i.designation;
            lig[j][1] = Integer.toString(i.refArticle.size());
            j++;
        }
        return lig;
    }
    
    public static String[] displayCombo(){
        String[] lig = new String[VisDias.listGroupeArticleAchat.size()];
        int j = 0;
        for(GroupeArticleAchat i : VisDias.listGroupeArticleAchat){
            lig[j] = i.designation;
            j++;
        }
        return lig;
    }
    
    public static GroupeArticleAchat get(String desig){
        for(GroupeArticleAchat i : VisDias.listGroupeArticleAchat){
            if(desig.equals(i.designation))
                return i;
        }
        return null;
    }
}
