/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visdias;

import java.util.Objects;

public class CompteFinance {
    private final String identifiant;
    private final String password;
    private Coordonnee crd;
    
    public final static int MODE_COMPTE_LOG = 0;
    public final static int MODE_COMPTE_REMOVE = 1;
    public static int MODE_COMPTE;
    public static CompteFinance compteActif = null;
    
    public CompteFinance(String identifiant, String password) {
        this.identifiant = identifiant;
        this.password = password;
        this.crd = new Coordonnee("", "", "", "", "", "", "", "", "", "");
    }
    
    public boolean authentification(String pass){
        return this.password.equals(pass);
    }

    public static String[] display(){
        String[] lig = new String[VisDias.listCompteFinance.size()];
        int j = 0;
        for(CompteFinance i : VisDias.listCompteFinance){
            lig[j] = i.identifiant;
            j+=1;
        }
        return lig;
    }
    
    public static CompteFinance get(String identifiant){
        for(CompteFinance i : VisDias.listCompteFinance){
            if(i.identifiant.equals(identifiant))
                return i;
        }
        return null;
    }
    
    public void supprimer(){
        VisDias.listCompteFinance.remove(this);
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getPassword() {
        return password;
    }

    public Coordonnee getCrd() {
        return crd;
    }

    public void setCrd(Coordonnee crd) {
        this.crd = crd;
    }
    
}
