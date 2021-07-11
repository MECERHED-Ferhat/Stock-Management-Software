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
public class Recette extends Reglement{
    public static int codeSeqRC = 10000;

    public Recette(String designation, String personne, Date date, double montant, String modeReg, String refCB) {
        super(designation, personne, date, montant, modeReg, refCB);
        codeSeqRC++;
        this.code = "RC"+codeSeqRC;
    }

    public Recette(String code, String designation, String personne, Date date, double montant, String modeReg, String refCB) {
        super(code, designation, personne, date, montant, modeReg, refCB);
    }
    
    public static String[] colonne(){
        return new String[]{"Code", "Objet", "Client", "Date", "Montant", "Mode réglement", "Banque"};
    }
    
    public static String[][] display(String desig, String refPer, Date dateMin, Date dateMax, String mode){
        ArrayList<Reglement> list = new ArrayList<Reglement>();
        if(desig != null || dateMin != null || dateMax != null || mode != null || refPer != null){
            for(Recette i : VisDias.listRecette){
                if(desig != null)
                    if(!i.designation.toLowerCase().contains(desig.toLowerCase()))
                        continue;
                if(dateMin != null)
                    if(i.date.compareTo(dateMin) == -1)
                        continue;
                if(dateMax != null)
                    if(i.date.compareTo(dateMax) == 1)
                        continue;
                if(mode != null)
                    if(!i.modeReg.equals(mode))
                        continue;
                if(refPer != null)
                    if(!i.personne.toLowerCase().equals(refPer.toLowerCase()))
                        continue;
                list.add(i);
            }
        }else{
            list.addAll(VisDias.listRecette);
        }
        return Reglement.ligne(list);
    }

    public static Recette get(String code){
        for(Recette i : VisDias.listRecette){
            if(i.code.equals(code))
                return i;
        }
        return null;
    }

    public void supprimer(){
        VisDias.listRecette.remove(this);
    }
}
