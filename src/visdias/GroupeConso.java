/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visdias;


public class GroupeConso extends GroupeArticle {
    public static GroupeConso GroupeConsoActif = null;

    public GroupeConso(String designation) {
        super(designation);
    }
    
    @Override
    void supprimer(){
        VisDias.listGroupeConso.remove(this);
    }

    public static String[][] display(){
        String[][] lig = new String[VisDias.listGroupeConso.size()][2];
        int j = 0;
        
        for(GroupeConso i : VisDias.listGroupeConso){
            lig[j][0] = i.designation;
            lig[j][1] = Integer.toString(i.refArticle.size());
            j++;            
        }
        return lig;
    }
    
    public static String[] displayCombo(){
        String[] lig = new String[VisDias.listGroupeConso.size()];
        int j = 0;
        
        for(GroupeConso i : VisDias.listGroupeConso){
            lig[j] = i.designation;
            j++;
        }
        
        return lig;
    }

    public static GroupeConso get(String desig){
        for(GroupeConso i : VisDias.listGroupeConso){
            if(desig.equals(i.designation)){
                return i;
            }
        }
        return null;
    }



}
