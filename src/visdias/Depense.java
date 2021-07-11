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
public class Depense extends Reglement{
    public static int codeSeqDP = 10000;

    public Depense(String designation, String personne, Date date, double montant, String modeReg, String refDP) {
        super(designation, personne, date, montant, modeReg, refDP);
        codeSeqDP++;
        this.code = "DP"+codeSeqDP;
    }

    public Depense(String code, String designation, String personne, Date date, double montant, String modeReg, String refCB) {
        super(code, designation, personne, date, montant, modeReg, refCB);
    }
    
    public static String[] colonne(){
        return new String[]{"Code", "Objet", "Fournisseur", "Date", "Montant", "Mode réglement", "Banque"};
    }
    
    public static String[][] display(String desig, String refPer, Date dateMin, Date dateMax, String mode){
        ArrayList<Reglement> list = new ArrayList<Reglement>();
        if(desig != null || dateMin != null || dateMax != null || mode != null || refPer != null){
            for(Depense i : VisDias.listDepense){
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
            list.addAll(VisDias.listDepense);
        }
        return Reglement.ligne(list);
    }

    public static Depense get(String code){
        for(Depense i : VisDias.listDepense){
            if(i.code.equals(code))
                return i;
        }
        return null;
    }

    public void supprimer(){
        VisDias.listDepense.remove(this);
    }
}
