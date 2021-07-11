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
public class Fournisseur extends Personne{
    public static int codeSeqFR = 10000;

    public Fournisseur(String code, String designation, String adresse, double chiffreAffaire, double resteRegler){
        super(designation, adresse, chiffreAffaire, resteRegler);
        this.code = code;
    }
    
    public Fournisseur(String designation, String adresse, double chiffreAffaire, double resteRegler) {
        super(designation, adresse, chiffreAffaire, resteRegler);
        codeSeqFR++;
        this.code = "FR"+codeSeqFR;
    }
    
    @Override
    void supprimer(){
        VisDias.listFournisseur.remove(this);
    }
    
    public static Fournisseur get(String code){
        for(Fournisseur i : VisDias.listFournisseur){
            if(i.code.equals(code))
                return i;
        }
        return null;
    }
    
    public static String[][] display(String desig, boolean rarNZ){
        ArrayList<Personne> list = new ArrayList<>();
        if(desig != null || rarNZ == true){
            for(Fournisseur i : VisDias.listFournisseur){
                if(desig != null)
                    if(!i.designation.toLowerCase().contains(desig.toLowerCase()))
                        continue;
                if(rarNZ == true)
                    if(i.resteRegler == 0)
                        continue;
                list.add(i);
            }
        }else{
            list.addAll(VisDias.listFournisseur);
        }
        return Personne.ligne(list);
    }
}