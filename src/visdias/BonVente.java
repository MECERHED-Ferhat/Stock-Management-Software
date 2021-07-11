/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visdias;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class BonVente extends Bon{
    
    public static int codeSeqBV = 10000;
    
    public BonVente(String code, String designation, Date dateCreation, String refPersonne) {
        super(designation, dateCreation, refPersonne);
        this.code = code;
    }
    
    public BonVente(String designation, Date dateCreation, String refPersonne) {
        super(designation, dateCreation, refPersonne);
        codeSeqBV++;
        this.code = "BV" + codeSeqBV;
    }

    @Override
    void supprimer() {
        ArticleVente tmpArt;
        for(ArticleBon i : this.listArticleBon){
            tmpArt = ArticleVente.get(i.refArticle);
            if(tmpArt != null){
                tmpArt.quantiteStock += i.quantite;
            }
        }
        Client tmpCl = Client.get(this.refPersonne);
        if(tmpCl != null){
            tmpCl.chiffreAffaire -= this.prixTTC;
        }
        VisDias.listBonVente.remove(this);
    }

    public static String[][] display(String desig, Date dateMin, Date dateMax, String refPer) {
        ArrayList<Bon> list = new ArrayList<>();
        if(desig != null || dateMin != null || dateMax != null || refPer != null){
            for(BonVente i : VisDias.listBonVente){
                if(desig != null)
                    if(!i.designation.toLowerCase().contains(desig.toLowerCase()))
                        continue;
                if(dateMin != null)
                    if(i.dateCreation.compareTo(dateMin)==-1)
                        continue;
                if(dateMax != null)
                    if(i.dateCreation.compareTo(dateMax)==1)
                        continue;
                if(refPer != null)
                    if(!i.refPersonne.equals(refPer))
                        continue;
                list.add(i);
            }
        }else{
            list.addAll(VisDias.listBonVente);
        }
        return Bon.ligne(list);
    }
    
    public static BonVente get(String code){
        int j = 0;
        for(BonVente i : VisDias.listBonVente){
            if(i.code.equals(code))
                return i;
        }
        return null;
    }
    
    public boolean imprimer(String typeBon){
        if(Client.get(this.refPersonne) == null)
            return false;
        Coordonnee crdAdmin = CompteFinance.compteActif.getCrd();
        Coordonnee crdClient = Client.get(this.refPersonne).crd;
        Document document = new Document();
        try{
            PdfWriter.getInstance(document, new FileOutputStream("Rapport.pdf"));
            document.open();
            //INIT
            Chunk glue = new Chunk(new VerticalPositionMark());
            Font fontBold = FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.BOLD);
            Font font = FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL);
            Font fontMin = FontFactory.getFont(FontFactory.defaultEncoding, 8, Font.NORMAL);
            
            Paragraph title = new Paragraph();
            title.add(new Chunk(typeBon, FontFactory.getFont(FontFactory.defaultEncoding, 20, Font.BOLD)));
            title.add(new Chunk(glue));
            title.add(new Chunk("Alger  le "+this.dateCreation.toStringFr(), FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.NORMAL)));
            
            PdfPTable header = new PdfPTable(new float[]{5, 3});
            header.setWidthPercentage(90);
            PdfPCell cell1 = new PdfPCell();
            cell1.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell2 = new PdfPCell();
            cell2.setBorder(Rectangle.NO_BORDER);
            cell2.setPaddingLeft(10);
            cell2.setPaddingBottom(10);
            Paragraph text1 = new Paragraph();
            text1.setLeading(0,1.5f);
            Paragraph text2 = new Paragraph();
            text2.setLeading(0,1.5f);
            
            PdfPTable body = new PdfPTable(new float[]{1,3,1,2,2});
            body.setWidthPercentage(100);
            PdfPCell col0 = new PdfPCell(new Phrase("Code", fontBold));
            col0.setFixedHeight(20);
            col0.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
            col0.setVerticalAlignment(Rectangle.ALIGN_MIDDLE);
            col0.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell col1 = new PdfPCell(new Phrase("Désignation", fontBold));
            col1.setFixedHeight(20);
            col1.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
            col1.setVerticalAlignment(Rectangle.ALIGN_MIDDLE);
            col1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell col2 = new PdfPCell(new Phrase("Qté", fontBold));
            col2.setFixedHeight(20);
            col2.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
            col2.setVerticalAlignment(Rectangle.ALIGN_MIDDLE);
            col2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell col3 = new PdfPCell(new Phrase("Prix unitaire TTC", fontBold));
            col3.setFixedHeight(20);
            col3.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
            col3.setVerticalAlignment(Rectangle.ALIGN_MIDDLE);
            col3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell col4 = new PdfPCell(new Phrase("Montant TTC", fontBold));
            col4.setFixedHeight(20);
            col4.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
            col4.setVerticalAlignment(Rectangle.ALIGN_MIDDLE);
            col4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            body.addCell(col0);
            body.addCell(col1);
            body.addCell(col2);
            body.addCell(col3);
            body.addCell(col4);
            
            //TRAITEMENT
            text1.add(new Chunk("ENTREPRISE ARTISANALE\n", FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.UNDERLINE)));
            text2.add(new Chunk("CLIENT\n", FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.UNDERLINE)));
            
            Coordonnee crd = crdAdmin;
            for(Paragraph i : new Paragraph[]{text1, text2}){
                if(!crd.designation.isEmpty())
                    i.add(new Chunk(crd.cevilite+"  "+crd.designation+"\n", font));
                if(!crd.adresse.isEmpty())
                    i.add(new Chunk("  "+crd.adresse+"\n", font));
                if(!crd.nTel.isEmpty())
                    i.add(new Chunk("N°Tél : "+crd.nTel+"\n", fontMin));
                if(!crd.nArt.isEmpty())
                    i.add(new Chunk("N°Art : "+crd.nArt+"\n", fontMin));
                if(!crd.NIF.isEmpty())
                    i.add(new Chunk("N.I.F : "+crd.NIF+"\n", fontMin));
                if(!crd.NIS.isEmpty())
                    i.add(new Chunk("N.I.S : "+crd.NIS+"\n", fontMin));
                if(!crd.compteBancaire.isEmpty())
                    i.add(new Chunk("N°Compte Bancaire : "+crd.compteBancaire+"\n", fontMin));
                crd = crdClient;            
            }
            
            PdfPCell row0 = new PdfPCell(), row1 = new PdfPCell(), row2 = new PdfPCell(), row3 = new PdfPCell(), row4 = new PdfPCell();
            row0.setVerticalAlignment(Rectangle.ALIGN_MIDDLE);
            row0.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
            row0.setFixedHeight(20);
            row1.setVerticalAlignment(Rectangle.ALIGN_MIDDLE);
            row1.setHorizontalAlignment(Rectangle.ALIGN_LEFT);
            row1.setFixedHeight(20);
            row2.setVerticalAlignment(Rectangle.ALIGN_MIDDLE);
            row2.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
            row2.setFixedHeight(20);
            row3.setVerticalAlignment(Rectangle.ALIGN_MIDDLE);
            row3.setHorizontalAlignment(Rectangle.ALIGN_RIGHT);
            row3.setFixedHeight(20);
            row4.setVerticalAlignment(Rectangle.ALIGN_MIDDLE);
            row4.setHorizontalAlignment(Rectangle.ALIGN_RIGHT);
            row4.setFixedHeight(20);
            for(ArticleBon i : this.listArticleBon){
                row0.setPhrase(new Phrase(i.refArticle, font));
                row1.setPhrase(new Phrase(i.designation, font));
                row2.setPhrase(new Phrase(Integer.toString(i.quantite), font));
                row3.setPhrase(new Phrase(VisDias.formatDouble.format(i.prixUTC), font));
                row4.setPhrase(new Phrase(VisDias.formatDouble.format(i.prixTTC), font));
                body.addCell(row0); body.addCell(row1); body.addCell(row2); body.addCell(row3); body.addCell(row4);
            }
            PdfPCell trouG = new PdfPCell(new Phrase(" "));
            trouG.setFixedHeight(20);
            trouG.setColspan(5);
            trouG.setBorder(Rectangle.NO_BORDER);
            body.addCell(trouG);
            PdfPCell trou = new PdfPCell(new Phrase(""));
            trouG.setFixedHeight(20);
            trou.setColspan(3);
            trou.setBorder(Rectangle.NO_BORDER);
            
            PdfPCell TTC = new PdfPCell(new Phrase("Total TTC", fontBold));
            TTC.setFixedHeight(20);
            TTC.setVerticalAlignment(Rectangle.ALIGN_MIDDLE);
            TTC.setBackgroundColor(BaseColor.LIGHT_GRAY);
            row4.setPhrase(new Phrase(VisDias.formatDouble.format(this.prixTTC), font));
            body.addCell(trou);  body.addCell(TTC);  body.addCell(row4);
            
            PdfPCell sig = new PdfPCell(new Phrase(crdAdmin.Fonction, FontFactory.getFont(FontFactory.defaultEncoding, 11, Font.UNDERLINE)));
            sig.setColspan(2);
            sig.setFixedHeight(20);
            sig.setBorder(Rectangle.NO_BORDER);
            sig.setVerticalAlignment(Rectangle.ALIGN_MIDDLE);
            sig.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
            body.addCell(trouG);    body.addCell(trouG);    body.addCell(trou);  body.addCell(sig);
            
            //POST
            document.add(title);
            
            document.add(new Chunk());
            
            cell1.addElement(text1);
            cell2.addElement(text2);
            header.addCell(cell1);
            header.addCell(cell2);
            PdfPCell tmpCell = new PdfPCell(new Phrase("\n"));
            tmpCell.setColspan(2);      tmpCell.setBorder(Rectangle.NO_BORDER);
            header.addCell(tmpCell);
            document.add(header);
            
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            
            document.add(body);
            
            document.close();
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
}
