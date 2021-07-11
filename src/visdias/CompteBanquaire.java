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
public class CompteBanquaire {
    protected String code;
    protected String banque;
    protected String agence;
    protected String numCompte;
    
    public static int codeSeqCB = 10000;

    public CompteBanquaire(String banque, String agence, String numCompte) {
        this.banque = banque;
        this.agence = agence;
        this.numCompte = numCompte;
        codeSeqCB++;
        this.code = "CB" + codeSeqCB;
    }

    public CompteBanquaire(String code, String banque, String agence, String numCompte) {
        this.code = code;
        this.banque = banque;
        this.agence = agence;
        this.numCompte = numCompte;
    }
    
    
    
    public static CompteBanquaire get(String code){
        int j = 0;
        for(CompteBanquaire i : VisDias.listCompteBanquaire){
            if(i.code.equals(code))
                return i;
        }
        return null;
    }
    
    public static String[] colonne(){
        return new String[]{"Code", "Banque", "Agence", "Numéro compte"};
    }
    
    public static String[][] display(){
        String[][] out = new String[VisDias.listCompteBanquaire.size()][];
        int j = 0;
        for(CompteBanquaire i : VisDias.listCompteBanquaire){
            out[j] = displayRow(i);
            j++;
        }
        return out;
    }
    
    public static String[] displayRow(CompteBanquaire cpt){
        return new String[]{cpt.code, cpt.banque, cpt.agence, cpt.numCompte};
    }
}
