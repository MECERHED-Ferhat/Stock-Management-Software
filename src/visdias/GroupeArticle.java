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
public abstract class GroupeArticle {
    //Référence
    ArrayList<String> refArticle;
    
    protected String designation;
    
    public static GroupeArticle groupeCourant;
    
    public GroupeArticle(String designation){
        this.designation = designation;
        refArticle = new ArrayList<String>();
    }
    
    public static String[] colonne(){
        return new String[]{"Désignation","Nombre d'article"};
    }
    
    public String[] displayRow(){
        return new String[]{this.designation, Integer.toString(this.refArticle.size())};
    }
    
    void modifier(String designation){
        if(designation != null)
            this.designation = designation;
    }
    
    abstract void supprimer();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GroupeArticle other = (GroupeArticle) obj;
        return Objects.equals(this.designation, other.designation);
    }
    
    
}
