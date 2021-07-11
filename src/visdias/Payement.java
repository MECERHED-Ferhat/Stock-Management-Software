/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visdias;

/**
 *
 * @author MECERHED Ferhat
 */
public class Payement {
    public static int codeSeqPY = 10000;
    
    protected String code;
    protected Date date;
    protected String modeReg;
    protected double montant;

    public Payement(Date date, String modeReg, double montant) {
        this.date = date;
        this.modeReg = modeReg;
        this.montant = montant;
        codeSeqPY++;
        this.code = "PY" + codeSeqPY;
    }

    public Payement(String code, Date date, String modeReg, double montant) {
        this.code = code;
        this.date = date;
        this.modeReg = modeReg;
        this.montant = montant;
    }
    
    public static String[] colonne() {
        return new String[]{"code", "Date", "Mode réglement", "Montant"};
    }
    
    public String[] displayRow() {
        return new String[]{this.code, this.date.toString(), this.modeReg, VisDias.formatDouble.format(this.montant)};
    }
    
    public static String[][] display(Personne per) {
        if (per == null)
            return new String[0][4];
        String[][] lig = new String[per.listPayement.size()][4];
        int j = 0;
        for (Payement i : per.listPayement) {
            lig[j] = i.displayRow();
            j++;
        }
        return lig;
    }
    
    public static Payement get(Personne per, String code) {
        for (Payement i : per.listPayement) {
            if (i.code.equals(code))
                return i;
        }
        return null;
    }
}
