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
public class Reglement {
    protected String code;
    protected String designation;
    protected String personne;
    protected Date date;
    protected double montant;
    protected String modeReg;
    protected String refCB;
    
    public static Reglement reglementCourant;
    public static ArrayList<String> listModeReg = new ArrayList<String>();

    public Reglement(String designation, String personne, Date date, double montant, String modeReg, String refCB) {
        this.designation = designation;
        this.personne = personne;
        this.date = date;
        this.montant = montant;
        this.modeReg = modeReg;
        this.refCB = refCB;
    }
    public Reglement(String code, String designation, String personne, Date date, double montant, String modeReg, String refCB) {
        this.code = code;
        this.designation = designation;
        this.personne = personne;
        this.date = date;
        this.montant = montant;
        this.modeReg = modeReg;
        this.refCB = refCB;
    }
    
    public void Modifier(String designation, String personne, Date date, double montant, String modeReg, String refCB) {
        if(designation != null)
            this.designation = designation;
        if(personne != null)
            this.personne = personne;
        if(date != null)
            this.date = date;
        if(montant != -1)
            this.montant = montant;
        if(modeReg != null)
            this.modeReg = modeReg;
        if(refCB != null)
            this.refCB = refCB;
    }
    
    public static String[][] ligne(ArrayList<Reglement> list){
        String[][] out = new String[list.size()][7];
        int j = 0;
        for(Reglement i : list){
            out[j] = displayRow(i);
            j++;
        }
        return out;
    }
    
    public static String[] displayRow(Reglement reg){
        CompteBanquaire cpt = CompteBanquaire.get(reg.refCB);
        if(cpt != null)
            return new String[]{reg.code, reg.designation, reg.personne, reg.date.toString(),
                                VisDias.formatDouble.format(reg.montant), reg.modeReg, cpt.banque};
        return new String[]{reg.code, reg.designation, reg.personne, reg.date.toString(),
                            VisDias.formatDouble.format(reg.montant), reg.modeReg, ""};
    }
    
    public static Object[] displayMode(){
        return listModeReg.toArray();
    }
}
