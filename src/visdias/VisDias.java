/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visdias;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;

public class VisDias {
    // Méthode sauvegarde
    private static Object[] saveCoordonnee(Coordonnee crd){
        return new Object[]{crd.cevilite, crd.designation, crd.adresse, crd.nTel, crd.nRC, crd.nArt, crd.NIF, crd.NIS, crd.compteBancaire, crd.Fonction};
    }
    private static Object[] saveArticleBon(ArticleBon artB){
        return new Object[]{artB.refArticle, artB.designation, artB.unite, artB.quantite, artB.prixUT, artB.prixTT, artB.tva, artB.prixUTC, artB.prixTTC};
    } 
    private static Object[] saveDate(Date date){
        return new Object[]{date.day, date.month, date.year};
    }
    private static Object[] saveCompteFinance(CompteFinance cpt){
        return new Object[]{cpt.getIdentifiant(), cpt.getPassword(), saveCoordonnee(cpt.getCrd())};
    }
    private static Object[] saveListCompteFinance(){
        Object[] out = new Object[listCompteFinance.size()];
        int j = 0;
        for(CompteFinance i : listCompteFinance){
            out[j] = saveCompteFinance(i);
            j++;
        }
        return out;
    }
    private static Object[] savePersonne(Personne per){
        Object[] out = new Object[per.listPayement.size()];
        int j = 0;
        for (Payement i : per.listPayement) {
            out[j] = savePayement(i);
            j++;
        }
        return new Object[]{per.code, per.designation, per.adresse, per.chiffreAffaire, per.resteRegler, saveCoordonnee(per.crd), out};
    }
    private static Object[] saveListClient(){
        Object[] out = new Object[listClient.size()];
        int j = 0;
        for(Client i : listClient){
            out[j] = savePersonne(i);
            j++;
        }
        return out;
    } 
    private static Object[] saveListFournisseur(){
        Object[] out = new Object[listFournisseur.size()];
        int j = 0;
        for(Fournisseur i : listFournisseur){
            out[j] = savePersonne(i);
            j++;
        }
        return out;
    }
    private static Object[] saveArticleUnite(){
        Object[] unite = new Object[SimpleArticle.listUnite.size()];
        int j = 0;
        for(String i : SimpleArticle.listUnite){
            unite[j] = i;
            j++;
        }
        return unite;
    }
    private static Object[] saveSimpleArticle(SimpleArticle sa){
        return new Object[]{sa.code, sa.designation, saveDate(sa.dateCreation), sa.unite, sa.quantiteStock, sa.prixUT, sa.tva};
    }
    private static Object[] saveListArticleAchat(){
        Object[] out = new Object[listArticleAchat.size()];
        int j = 0;
        for(ArticleAchat i : listArticleAchat){
            out[j] = saveSimpleArticle(i);
            j++;
        }
        return out;
    }
    private static Object[] saveListArticleVente(){
        Object[] out = new Object[listArticleVente.size()];
        int j = 0;
        for(ArticleVente i : listArticleVente){
            out[j] = saveSimpleArticle(i);
            j++;
        }
        return out;
    }
    private static Object[] saveBon(Bon bon){
        Object[][] refArt = new Object[bon.listArticleBon.size()][9];
        int j = 0;
        for(ArticleBon i : bon.listArticleBon){
            refArt[j] = saveArticleBon(i);
            j++;
        }
        return new Object[]{bon.code, bon.designation, saveDate(bon.dateCreation), bon.refPersonne, bon.prixTT, bon.prixTTC, refArt};
    }
    private static Object[] saveListBonAchat(){
        Object[] out = new Object[listBonAchat.size()];
        int j = 0;
        for(BonAchat i : listBonAchat){
            out[j] = saveBon(i);
            j++;
        }
        return out;
    }
    private static Object[] saveListBonVente(){
        Object[] out = new Object[listBonVente.size()];
        int j = 0;
        for(BonVente i : listBonVente){
            out[j] = saveBon(i);
            j++;
        }
        return out;
    }
    private static Object[] saveGroupe(GroupeArticle grp){
        Object[] refArt = new Object[grp.refArticle.size()];
        int j = 0;
        for(String i : grp.refArticle){
            refArt[j] = i;
            j++;
        }
        return new Object[]{grp.designation, refArt};
    }
    private static Object[] saveListGroupeAchat(){
        Object[] out = new Object[listGroupeArticleAchat.size()];
        int j = 0;
        for(GroupeArticleAchat i : listGroupeArticleAchat){
            out[j] = saveGroupe(i);
            j++;
        }
        return out;
    }
    private static Object[] saveListGroupeVente(){
        Object[] out = new Object[listGroupeArticleVente.size()];
        int j = 0;
        for(GroupeArticleVente i : listGroupeArticleVente){
            out[j] = saveGroupe(i);
            j++;
        }
        return out;
    }
    private static Object[] saveConso(Consommation cs){
        return new Object[]{cs.refArticle, cs.code, cs.designation, saveDate(cs.dateConso), cs.unite, cs.quantite, cs.prixUT, cs.prixTT, cs.typeConso, cs.quantiteUT};
    }
    private static Object[] saveListConso(){
        Object[] out = new Object[listConsommation.size()];
        int j = 0;
        for(Consommation i : listConsommation){
            out[j] = saveConso(i);
            j++;
        }
        return out;
    }
    private static Object[] saveListGroupeConso(){
        Object[] out = new Object[listGroupeConso.size()];
        int j = 0;
        for(GroupeConso i : listGroupeConso){
            out[j] = saveGroupe(i);
            j++;
        }
        return out;
    }
    private static Object[] saveCompteBanquaire(CompteBanquaire cb){
        return new Object[]{cb.code, cb.banque, cb.agence, cb.numCompte};
    }
    private static Object[] saveReglement(Reglement reg){
        return new Object[]{reg.code, reg.designation, reg.personne, saveDate(reg.date), reg.montant, reg.modeReg, reg.refCB};
    }
    private static Object[] saveReglementMode(){
        Object[] out = new Object[Reglement.listModeReg.size()];
        int j = 0;
        for(String i : Reglement.listModeReg){
            out[j] = i;
            j++;
        }
        return out;
    }
    private static Object[] saveListCompteBanquaire(){
        Object[] out = new Object[listCompteBanquaire.size()];
        int j = 0;
        for(CompteBanquaire i : listCompteBanquaire){
            out[j] = saveCompteBanquaire(i);
            j++;
        }
        return out;
    }
    private static Object[] saveListRecette(){
        Object[] out = new Object[listRecette.size()];
        int j = 0;
        for(Recette i : listRecette){
            out[j] = saveReglement(i);
            j++;
        }
        return out;
    }
    private static Object[] saveListDepense(){
        Object[] out = new Object[listDepense.size()];
        int j = 0;
        for(Depense i : listDepense){
            out[j] = saveReglement(i);
            j++;
        }
        return out;
    }
    private static Object[] savePayement(Payement pay){
        return new Object[]{pay.code, saveDate(pay.date), pay.modeReg, pay.montant};
    }
    
    public static void sauvegardeCompte(){
        try{
            ObjectOutputStream compte = new ObjectOutputStream(new FileOutputStream("comptes/listCompte.dat"));
            compte.writeObject(saveListCompteFinance());
            compte.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void sauvegarde(String path){
        try{
            ObjectOutputStream client = new ObjectOutputStream(new FileOutputStream(path+"/client.dat"));
            client.writeObject(Client.codeSeqCL);
            client.writeObject(saveListClient());
            client.close();
            ObjectOutputStream fournisseur = new ObjectOutputStream(new FileOutputStream(path+"/fournisseur.dat"));
            fournisseur.writeObject(Fournisseur.codeSeqFR);
            fournisseur.writeObject(saveListFournisseur());
            fournisseur.close();
            ObjectOutputStream groupeAchat = new ObjectOutputStream(new FileOutputStream(path+"/groupeAchat.dat"));
            groupeAchat.writeObject(saveListGroupeAchat());
            groupeAchat.close();
            ObjectOutputStream groupeVente = new ObjectOutputStream(new FileOutputStream(path+"/groupeVente.dat"));
            groupeVente.writeObject(saveListGroupeVente());
            groupeVente.close();
            ObjectOutputStream articleUnite = new ObjectOutputStream(new FileOutputStream(path+"/articleUnite.dat"));
            articleUnite.writeObject(saveArticleUnite());
            articleUnite.close();
            ObjectOutputStream articleAchat = new ObjectOutputStream(new FileOutputStream(path+"/articleAchat.dat"));
            articleAchat.writeObject(ArticleAchat.codeSeqAA);
            articleAchat.writeObject(saveListArticleAchat());
            articleAchat.close();
            ObjectOutputStream articleVente = new ObjectOutputStream(new FileOutputStream(path+"/articleVente.dat"));
            articleVente.writeObject(ArticleVente.codeSeqAV);
            articleVente.writeObject(saveListArticleVente());
            articleVente.close();
            ObjectOutputStream bonAchat = new ObjectOutputStream(new FileOutputStream(path+"/bonAchat.dat"));
            bonAchat.writeObject(BonAchat.codeSeqBA);
            bonAchat.writeObject(saveListBonAchat());
            bonAchat.close();
            ObjectOutputStream bonVente = new ObjectOutputStream(new FileOutputStream(path+"/bonVente.dat"));
            bonVente.writeObject(BonVente.codeSeqBV);
            bonVente.writeObject(saveListBonVente());
            bonVente.close();
            ObjectOutputStream conso = new ObjectOutputStream(new FileOutputStream(path+"/consommation.dat"));
            conso.writeObject(Consommation.codeSeqCS);
            conso.writeObject(saveListConso());
            conso.close();
            ObjectOutputStream groupeConso = new ObjectOutputStream(new FileOutputStream(path+"/groupeConso.dat"));
            groupeConso.writeObject(saveListGroupeConso());
            groupeConso.close();
            ObjectOutputStream regleMode = new ObjectOutputStream(new FileOutputStream(path+"/reglementMode.dat"));
            regleMode.writeObject(saveReglementMode());
            regleMode.close();
            ObjectOutputStream cpt = new ObjectOutputStream(new FileOutputStream(path+"/compteBanquaire.dat"));
            cpt.writeObject(CompteBanquaire.codeSeqCB);
            cpt.writeObject(saveListCompteBanquaire());
            cpt.close();
            ObjectOutputStream rec = new ObjectOutputStream(new FileOutputStream(path+"/recette.dat"));
            rec.writeObject(Recette.codeSeqRC);
            rec.writeObject(saveListRecette());
            rec.close();
            ObjectOutputStream dep = new ObjectOutputStream(new FileOutputStream(path+"/depense.dat"));
            dep.writeObject(Depense.codeSeqDP);
            dep.writeObject(saveListDepense());
            dep.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // Méthode restoration
    private static Coordonnee restoCoordonnee(Object[] in){
        return new Coordonnee((String)in[0], (String)in[1], (String)in[2], (String)in[3], (String)in[4],
                              (String)in[5], (String)in[6], (String)in[7], (String)in[8], (String)in[9]);
    }
    private static ArticleBon restoArticleBon(Object[] in){
        return new ArticleBon((String)in[0], (String)in[1], (String)in[2], (int)in[3], (double)in[4],
                              (double)in[5], (double)in[6], (double)in[7], (double)in[8]);
    }
    private static Date restoDate(Object[] in){
        return new Date((int)in[0], (int)in[1], (int)in[2]);
    }
    private static CompteFinance restoCompteFinance(Object[] in){
        CompteFinance cpt = new CompteFinance((String)in[0], (String)in[1]);
        cpt.setCrd(restoCoordonnee((Object[])in[2]));
        return cpt;
    }
    private static void restoListCompteFinance(Object[] in){
        for(Object i : in){
            listCompteFinance.add(restoCompteFinance((Object[])i));
        }
    }
    private static Client restoClient(Object[] in){
        Client cl = new Client((String)in[0], (String)in[1], (String)in[2], (double)in[3], (double)in[4]);
        cl.crd =  restoCoordonnee((Object[])in[5]);
        for (Object i : (Object[])in[6]) {
            cl.listPayement.add(restoPayement((Object[])i));
        }
        return cl;
    }
    private static void restoListClient(Object[] in){
        for(Object i : in){
            listClient.add(restoClient((Object[])i));
        }
    }
    private static Fournisseur restoFournisseur(Object[] in){
        Fournisseur fr = new Fournisseur((String) in[0], (String)in[1], (String)in[2], (double)in[3], (double)in[4]);
        fr.crd = restoCoordonnee((Object[])in[5]);
        for (Object i : (Object[])in[6]) {
            fr.listPayement.add(restoPayement((Object[])i));
        }
        return fr;
    }
    private static void restoListFournisseur(Object[] in){
        for(Object i : in){
            listFournisseur.add(restoFournisseur((Object[])i));
        }
    }
    private static void restoArticleUnite(Object[] in){
        for(Object i : (Object[])in){
            SimpleArticle.listUnite.add((String)i);
        }
    }
    private static ArticleAchat restoArticleAchat(Object[] in){
        return new ArticleAchat((String)in[0], (String)in[1], restoDate((Object[])in[2]), (String)in[3], (int)in[4], (double)in[5], (double)in[6]);
    }
    private static void restoListArticleAchat(Object[] in){
        for(Object i : in){
            listArticleAchat.add(restoArticleAchat((Object[])i));
        }
    }
    private static ArticleVente restoArticleVente(Object[] in){
        return new ArticleVente((String)in[0], (String)in[1], restoDate((Object[])in[2]), (String)in[3], (int)in[4], (double)in[5], (double)in[6]);        
    }
    private static void restoListArticleVente(Object[] in){
        for(Object i : in){
            listArticleVente.add(restoArticleVente((Object[])i));
        }
    }
    private static BonAchat restoBonAchat(Object[] in){
        BonAchat bonA = new BonAchat((String)in[0], (String)in[1], restoDate((Object[])in[2]), (String)in[3]);
        bonA.prixTT = (double)in[4];
        bonA.prixTTC = (double)in[5];
        for(Object[] i : (Object[][])in[6]){
            bonA.listArticleBon.add(restoArticleBon(i));
        }
        return bonA;
    }
    private static void restoListBonAchat(Object[] in){
        for(Object i : in){
            listBonAchat.add(restoBonAchat((Object[])i));
        }
    }   
    private static BonVente restoBonVente(Object[] in){
        BonVente bonV = new BonVente((String)in[0], (String)in[1], restoDate((Object[])in[2]), (String)in[3]);
        bonV.prixTT = (double)in[4];
        bonV.prixTTC = (double)in[5];
        for(Object[] i : (Object[][])in[6]){
            bonV.listArticleBon.add(restoArticleBon(i));
        }
        return bonV;
    }
    private static void restoListBonVente(Object[] in){
        for(Object i : in){
            listBonVente.add(restoBonVente((Object[])i));
        }
    }
    private static GroupeArticleAchat restoGroupeAchat(Object[] in){
        GroupeArticleAchat grpA = new GroupeArticleAchat((String)in[0]);
        for(Object i : (Object[])in[1]){
            grpA.refArticle.add((String)i);
        }
        return grpA;
    }
    private static void restoListGroupeAchat(Object[] in){
        for(Object i : in){
            listGroupeArticleAchat.add(restoGroupeAchat((Object[])i));
        }
    }
    private static GroupeArticleVente restoGroupeVente(Object[] in){
        GroupeArticleVente grpV = new GroupeArticleVente((String)in[0]);
        for(Object i : (Object[])in[1]){
            grpV.refArticle.add((String)i);
        }
        return grpV;
    }
    private static void restoListGroupeVente(Object[] in){
        for(Object i : in){
            listGroupeArticleVente.add(restoGroupeVente((Object[])i));
        }
    }
    private static GroupeConso restoGroupeConso(Object[] in){
        GroupeConso grpCS = new GroupeConso((String)in[0]);
        for(Object i : (Object[])in[1]){
            grpCS.refArticle.add((String)i);
        }
        return grpCS;
    }
    private static void restoListGroupeConso(Object[] in){
        for(Object i : in){
            listGroupeConso.add(restoGroupeConso((Object[])i));
        }
    }
    private static Consommation restoConso(Object[] in){
        return new Consommation((String)in[0], (String)in[1], (String)in[2], restoDate((Object[])in[3]), (String)in[4], (int)in[5], (double)in[6], (double)in[7], (int)in[8], (int)in[9]);
    }
    private static void restoListConso(Object[] in){
        for(Object i : in){
            listConsommation.add(restoConso((Object[])i));
        }
    }
    private static CompteBanquaire restoCompteBanquaire(Object[] in){
        return new CompteBanquaire((String)in[0], (String)in[1], (String)in[2], (String)in[3]);
    }
    private static Recette restoRecette(Object[] in){
        return new Recette((String)in[0], (String)in[1], (String)in[2], restoDate((Object[])in[3]), (double)in[4], (String)in[5], (String)in[6]);
    }
    private static Depense restoDepense(Object[] in){
        return new Depense((String)in[0], (String)in[1], (String)in[2], restoDate((Object[])in[3]), (double)in[4], (String)in[5], (String)in[6]);
    }
    private static void restoReglementMode(Object[] in){
        for(Object i : in){
            Reglement.listModeReg.add((String)i);
        }
    }
    private static void restoListCompteBanquaire(Object[] in){
        for(Object i : in){
            listCompteBanquaire.add(restoCompteBanquaire((Object[])i));
        }
    }
    private static void restoListRecette(Object[] in){
        for(Object i : in){
            listRecette.add(restoRecette((Object[])i));
        }
    }
    private static void restoListDepense(Object[] in){
        for(Object i : in){
            listDepense.add(restoDepense((Object[])i));
        }
    }
    private static Payement restoPayement(Object[] in) {
        return new Payement((String)in[0], restoDate((Object[])in[1]), (String)in[2], (double)in[3]);
    }
    
    public static void restorationCompte(){
        listCompteFinance = new ArrayList<CompteFinance>();
        try{
            ObjectInputStream compte = new ObjectInputStream(new FileInputStream("comptes/listCompte.dat"));
            restoListCompteFinance((Object[])compte.readObject());
            compte.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void restoration(String path){
        listCorbeille = new Stack<Object>();
        listFournisseur = new ArrayList<Fournisseur>();
        listClient = new ArrayList<Client>();
        listArticleAchat = new ArrayList<ArticleAchat>();
        listArticleVente = new ArrayList<ArticleVente>();
        listBonAchat = new ArrayList<BonAchat>();
        listBonVente = new ArrayList<BonVente>();
        listGroupeArticleAchat = new ArrayList<GroupeArticleAchat>();
        listGroupeArticleVente = new ArrayList<GroupeArticleVente>();
        listConsommation = new ArrayList<Consommation>();
        listGroupeConso = new ArrayList<GroupeConso>();
        listCompteBanquaire = new ArrayList<CompteBanquaire>();
        listRecette = new ArrayList<Recette>();
        listDepense = new ArrayList<Depense>();
        try{
            ObjectInputStream client = new ObjectInputStream(new FileInputStream(path+"/client.dat"));
            Client.codeSeqCL = (int)client.readObject();
            restoListClient((Object[])client.readObject());
            client.close();
            ObjectInputStream fournisseur = new ObjectInputStream(new FileInputStream(path+"/fournisseur.dat"));
            Fournisseur.codeSeqFR = (int)fournisseur.readObject();
            restoListFournisseur((Object[])fournisseur.readObject());
            fournisseur.close();
            ObjectInputStream groupeAchat = new ObjectInputStream(new FileInputStream(path+"/groupeAchat.dat"));
            restoListGroupeAchat((Object[])groupeAchat.readObject());
            groupeAchat.close();
            ObjectInputStream groupeVente = new ObjectInputStream(new FileInputStream(path+"/groupeVente.dat"));
            restoListGroupeVente((Object[])groupeVente.readObject());
            groupeVente.close();
            ObjectInputStream articleUnite = new ObjectInputStream(new FileInputStream(path+"/articleUnite.dat"));
            restoArticleUnite((Object[])articleUnite.readObject());
            articleUnite.close();
            ObjectInputStream articleAchat = new ObjectInputStream(new FileInputStream(path+"/articleAchat.dat"));
            ArticleAchat.codeSeqAA = (int)articleAchat.readObject();
            restoListArticleAchat((Object[])articleAchat.readObject());
            articleAchat.close();
            ObjectInputStream articleVente = new ObjectInputStream(new FileInputStream(path+"/articleVente.dat"));
            ArticleVente.codeSeqAV = (int)articleVente.readObject();
            restoListArticleVente((Object[])articleVente.readObject());
            articleVente.close();
            ObjectInputStream bonAchat = new ObjectInputStream(new FileInputStream(path+"/bonAchat.dat"));
            BonAchat.codeSeqBA = (int)bonAchat.readObject();
            restoListBonAchat((Object[])bonAchat.readObject());
            bonAchat.close();
            ObjectInputStream bonVente = new ObjectInputStream(new FileInputStream(path+"/bonVente.dat"));
            BonVente.codeSeqBV = (int)bonVente.readObject();
            restoListBonVente((Object[])bonVente.readObject());
            bonVente.close();
            ObjectInputStream conso = new ObjectInputStream(new FileInputStream(path+"/consommation.dat"));
            Consommation.codeSeqCS = (int)conso.readObject();
            restoListConso((Object[])conso.readObject());
            conso.close();
            ObjectInputStream groupeConso = new ObjectInputStream(new FileInputStream(path+"/groupeConso.dat"));
            restoListGroupeConso((Object[])groupeConso.readObject());
            groupeConso.close();
            ObjectInputStream regMode = new ObjectInputStream(new FileInputStream(path+"/reglementMode.dat"));
            restoReglementMode((Object[])regMode.readObject());
            regMode.close();
            ObjectInputStream cpt = new ObjectInputStream(new FileInputStream(path+"/compteBanquaire.dat"));
            CompteBanquaire.codeSeqCB = (int)cpt.readObject();
            restoListCompteBanquaire((Object[])cpt.readObject());
            cpt.close();
            ObjectInputStream rec = new ObjectInputStream(new FileInputStream(path+"/recette.dat"));
            Recette.codeSeqRC = (int)rec.readObject();
            restoListRecette((Object[])rec.readObject());
            rec.close();
            ObjectInputStream dep = new ObjectInputStream(new FileInputStream(path+"/depense.dat"));
            Depense.codeSeqDP = (int)dep.readObject();
            restoListDepense((Object[])dep.readObject());
            dep.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // Variables ArrayList
    public static Stack<Object> listCorbeille;
    
    public static ArrayList<Fournisseur> listFournisseur;
    public static ArrayList<Client> listClient;
    
    public static ArrayList<ArticleAchat> listArticleAchat;
    public static ArrayList<ArticleVente> listArticleVente;
    
    public static ArrayList<BonAchat> listBonAchat;
    public static ArrayList<BonVente> listBonVente;
    
    public static ArrayList<GroupeArticleAchat> listGroupeArticleAchat;
    public static ArrayList<GroupeArticleVente> listGroupeArticleVente;
    
    public static ArrayList<Consommation> listConsommation;
    public static ArrayList<GroupeConso> listGroupeConso;
    
    public static ArrayList<CompteFinance> listCompteFinance;
    
    public static ArrayList<CompteBanquaire> listCompteBanquaire;
    public static ArrayList<Recette> listRecette;
    public static ArrayList<Depense> listDepense;
    // End of Variables ArrayList
    
    public static void createFiles(String path){
        Object[] listSet = new Object[]{Client.codeSeqCL, Fournisseur.codeSeqFR, ArticleAchat.codeSeqAA, ArticleVente.codeSeqAV,
                                        BonAchat.codeSeqBA, BonVente.codeSeqBV, Consommation.codeSeqCS, SimpleArticle.listUnite,
                                        Reglement.listModeReg, CompteBanquaire.codeSeqCB, Recette.codeSeqRC, Depense.codeSeqDP};
        Object[] listObj = new Object[]{listClient, listFournisseur, listGroupeArticleAchat, listGroupeArticleVente,
                                        listArticleAchat, listArticleVente, listBonAchat, listBonVente, listConsommation,
                                        listGroupeConso, listCompteBanquaire, listRecette, listDepense};
        SimpleArticle.listUnite = new ArrayList<String>();
        Reglement.listModeReg = new ArrayList<String>();
        Client.codeSeqCL = 10000;
        Fournisseur.codeSeqFR = 10000;
        ArticleAchat.codeSeqAA = 10000;
        ArticleVente.codeSeqAV = 10000;
        BonAchat.codeSeqBA = 10000;
        BonVente.codeSeqBV = 10000;
        Consommation.codeSeqCS = 10000;
        CompteBanquaire.codeSeqCB = 10000;
        Recette.codeSeqRC = 10000;
        Depense.codeSeqDP = 10000;
        
        listClient = new ArrayList<Client>();
        listFournisseur = new ArrayList<Fournisseur>();
        
        listGroupeArticleAchat = new ArrayList<GroupeArticleAchat>();
        listGroupeArticleAchat.add(new GroupeArticleAchat("Autre"));
        
        listGroupeArticleVente = new ArrayList<GroupeArticleVente>();
        listGroupeArticleVente.add(new GroupeArticleVente("Autre"));
        
        listArticleAchat = new ArrayList<ArticleAchat>();
        listArticleVente = new ArrayList<ArticleVente>();
        
        listBonAchat = new ArrayList<BonAchat>();
        listBonVente = new ArrayList<BonVente>();
        
        listGroupeConso = new ArrayList<GroupeConso>();
        listGroupeConso.add(new GroupeConso("Autre"));
        
        listConsommation = new ArrayList<Consommation>();
        
        listCompteBanquaire = new ArrayList<CompteBanquaire>();
        listRecette = new ArrayList<Recette>();
        listDepense = new ArrayList<Depense>();
        
        sauvegarde(path);
        
        SimpleArticle.listUnite = (ArrayList<String>)listSet[7];
        Reglement.listModeReg = (ArrayList<String>)listSet[8];
        Client.codeSeqCL = (int)listSet[0];
        Fournisseur.codeSeqFR = (int)listSet[1];
        ArticleAchat.codeSeqAA = (int)listSet[2];
        ArticleVente.codeSeqAV = (int)listSet[3];
        BonAchat.codeSeqBA = (int)listSet[4];
        BonVente.codeSeqBV = (int)listSet[5];
        Consommation.codeSeqCS = (int)listSet[6];
        CompteBanquaire.codeSeqCB = (int)listSet[9];
        Recette.codeSeqRC = (int)listSet[10];
        Depense.codeSeqDP = (int)listSet[11];
        listClient = (ArrayList<Client>)listObj[0];
        listFournisseur = (ArrayList<Fournisseur>)listObj[1];
        listGroupeArticleAchat = (ArrayList<GroupeArticleAchat>)listObj[2];
        listGroupeArticleVente = (ArrayList<GroupeArticleVente>)listObj[3];
        listArticleAchat = (ArrayList<ArticleAchat>)listObj[4];
        listArticleVente = (ArrayList<ArticleVente>)listObj[5];
        listBonAchat = (ArrayList<BonAchat>)listObj[6];
        listBonVente = (ArrayList<BonVente>)listObj[7];
        listConsommation = (ArrayList<Consommation>)listObj[8];
        listGroupeConso = (ArrayList<GroupeConso>)listObj[9];
        listCompteBanquaire = (ArrayList<CompteBanquaire>)listObj[10];
        listRecette = (ArrayList<Recette>)listObj[11];
        listDepense = (ArrayList<Depense>)listObj[12];
    }
    public static void addDir(String path){
        try{
            File tmpDir = new File(path);
            if(!tmpDir.mkdir())
                JOptionPane.showMessageDialog(null, "Erreur! Impossible de créer le dossier");
            else{
                createFiles(path);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void removeDir(String path){
        try{
            File tmpDir = new File(path);
            String[] files = tmpDir.list();
            File tmpFile;
            if(files != null){
                for(String i : files){
                    tmpFile = new File(path,i);
                    tmpFile.delete();
                }
                tmpDir.delete();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static DecimalFormat formatInt;
    public static DecimalFormat formatDouble;
    
    public static void main(String[] args) {
        
        restorationCompte();
        
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator(' ');
        
        formatInt = new DecimalFormat("###,##0", symbols);
        formatDouble = new DecimalFormat("###,##0.00", symbols);
        
        VisDiasGUI.main(args);
        
    }
}
