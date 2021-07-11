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
public class Client extends Personne {
    public static int codeSeqCL = 10000;

    public Client(String code, String designation, String adresse, double chiffreAffaire, double resteRegler){
        super(designation, adresse, chiffreAffaire, resteRegler);
        this.code = code;
    }
    
    public Client(String designation, String adresse, double chiffreAffaire, double resteRegler) {
        super(designation, adresse, chiffreAffaire, resteRegler);
        codeSeqCL++;
        this.code = "CL"+codeSeqCL;
    }
    
    @Override
    void supprimer(){
        VisDias.listClient.remove(this);
    }
    
    public static Client get(String code){
        for(Client i : VisDias.listClient){
            if(i.code.equals(code))
                return i;
        }
        return null;
    }
    
    public static String[][] display(String desig, boolean rarNZ){
        ArrayList<Personne> list = new ArrayList<>();
        if(desig != null || rarNZ == true){
            for(Client i : VisDias.listClient){
                if(desig != null)
                    if(!i.designation.toLowerCase().contains(desig.toLowerCase()))
                        continue;
                if(rarNZ == true)
                    if(i.resteRegler == 0)
                        continue;
                list.add(i);
            }
        }else{
            list.addAll(VisDias.listClient);
        }
        return Personne.ligne(list);
    }
}
