package visdias;

import com.sun.glass.events.KeyEvent;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author MECERHED Ferhat
 */
public class VisDiasGUI extends javax.swing.JFrame {
    
    public void centerScreen() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        centerX = screenSize.width/2;
        centerY = screenSize.height/2;
    }
    
    public void rightAlignCell(JTable table, int[] cols){
        for(int col : cols)
            table.getColumnModel().getColumn(col).setCellRenderer(rightRenderer);
    }
    public void centerAlignCell(JTable table, int[] cols){
        for(int col : cols)
            table.getColumnModel().getColumn(col).setCellRenderer(centerRenderer);
    }
    public void centerHeader(JTable table){
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }
    
    private void setup(){
        jButtonAccueilCompte = new javax.swing.JButton();
        jButtonAccueilAddCompte = new javax.swing.JButton();
        jButtonAccueilEditCompte = new javax.swing.JButton();
        jButtonAccueilRemoveCompte = new javax.swing.JButton();
        jButtonAccueilCompte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAccueilAddCompte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAccueilEditCompte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAccueilRemoveCompte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAccueilCompte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/File_Log.png"))); // NOI18N
        jButtonAccueilAddCompte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Add_Unite.png"))); // NOI18N
        jButtonAccueilEditCompte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Crd_Small.png"))); // NOI18N
        jButtonAccueilRemoveCompte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Remove_Unite.png"))); // NOI18N
        jButtonAccueilCompte.setText("S'authentifier à un compte");
        jButtonAccueilAddCompte.setText("Créer un compte");
        jButtonAccueilEditCompte.setText("Modifier/Consulter un compte");
        jButtonAccueilRemoveCompte.setText("Supprimer un compte");
        jButtonAccueilCompte.setIconTextGap(10);
        jButtonAccueilAddCompte.setIconTextGap(10);
        jButtonAccueilEditCompte.setIconTextGap(10);
        jButtonAccueilRemoveCompte.setIconTextGap(10);
        jButtonAccueilCompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccueilCompteActionPerformed(evt);
            }
        });
        jButtonAccueilAddCompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccueilAddCompteActionPerformed(evt);
            }
        });
        jButtonAccueilEditCompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccueilEditCompteActionPerformed(evt);
            }
        });
        jButtonAccueilRemoveCompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccueilRemoveCompteActionPerformed(evt);
            }
        });    
        
        jButtonAccueilEditCompte.setEnabled(false);
        
        jScrollPaneBig = new javax.swing.JScrollPane();
        jTableBig = new javax.swing.JTable();
        jTableBig.setFont(new Font("Segoe UI", 0, 12));
        jTableBig.getTableHeader().setFont(new Font("Segoe UI", 0, 12));
        jTableBig.setRowHeight(30);
        jTableBig.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTableBig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(jTableBig.getSelectedRow() != -1)
                    if(evt.getClickCount() == 2)
                        jTableBigDoubleClick(jTableBig.getSelectedRow());
                        
            }
        });
        jTableBig.setAutoCreateRowSorter(true);
        jScrollPaneBig.setViewportView(jTableBig);
        
        jScrollPaneSmall1 = new javax.swing.JScrollPane();
        jTableSmall1 = new javax.swing.JTable();
        jTableSmall1.setFont(new Font("Segoe UI", 0, 12));
        jTableSmall1.getTableHeader().setFont(new Font("Segoe UI", 0, 11));
        jTableSmall1.setRowHeight(30);
        jTableSmall1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTableSmall1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(jTableSmall1.getSelectedRow() != -1)
                    jTableSmall2.clearSelection();
                    if(evt.getClickCount() == 2)
                        jTableSmall1DoubleClick(jTableSmall1.getSelectedRow());     
            }
        });
        jTableSmall1.setAutoCreateRowSorter(true);
        jScrollPaneSmall1.setViewportView(jTableSmall1);
        
        jScrollPaneSmall2 = new javax.swing.JScrollPane();
        jTableSmall2 = new javax.swing.JTable();
        jTableSmall2.setFont(new Font("Segoe UI", 0, 12));
        jTableSmall2.getTableHeader().setFont(new Font("Segoe UI", 0, 11));
        jTableSmall2.setRowHeight(30);
        jTableSmall2.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTableSmall2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(jTableSmall2.getSelectedRow() != -1)
                    jTableSmall1.clearSelection();   
            }
        });
        jTableSmall2.setAutoCreateRowSorter(true);
        jScrollPaneSmall2.setViewportView(jTableSmall2);
    }   
    
    private void setupAccueil(){
        jButtonImprimer.setEnabled(false);
        jButtonAdd.setEnabled(false);
        jButtonRemove.setEnabled(false);
        jButtonEdit.setEnabled(false);
        jButtonRapport.setEnabled(false);
        jScrollPaneBig.setVisible(false);
        jScrollPaneSmall1.setVisible(false);
        jScrollPaneSmall2.setVisible(false);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBarOutils, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBarRubriques, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
            .addComponent(jLabelRubriqueCourante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonAccueilCompte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonAccueilAddCompte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonAccueilEditCompte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonAccueilRemoveCompte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBarOutils, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBarRubriques, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRubriqueCourante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButtonAccueilCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAccueilAddCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAccueilEditCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAccueilRemoveCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jButtonAccueilCompte.setVisible(true);
        jButtonAccueilAddCompte.setVisible(true);
        jButtonAccueilEditCompte.setVisible(true);
        jButtonAccueilRemoveCompte.setVisible(true);
    }
    
    private void setupOneTable(){
        jButtonImprimer.setEnabled(false);
        jButtonAdd.setEnabled(true);
        jButtonRemove.setEnabled(true);
        jButtonEdit.setEnabled(true);
        jButtonRapport.setEnabled(true);
        jButtonAccueilCompte.setVisible(false);
        jButtonAccueilAddCompte.setVisible(false);
        jButtonAccueilEditCompte.setVisible(false);
        jButtonAccueilRemoveCompte.setVisible(false);
        jScrollPaneSmall1.setVisible(false);
        jScrollPaneSmall2.setVisible(false);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBarOutils, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBarRubriques, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
            .addComponent(jLabelRubriqueCourante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPaneBig)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBarOutils, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBarRubriques, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRubriqueCourante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneBig, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
        );
        jScrollPaneBig.setVisible(true);
    }
    private void setupClient(String desig, boolean rarNZ){
        jTableBig.setModel(new javax.swing.table.DefaultTableModel(
                Client.display(desig, rarNZ),
                Client.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, false, false};
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTableBig.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableBig, new int[]{0});
        rightAlignCell(jTableBig, new int[]{3, 4});
        centerHeader(jTableBig);
        if (jTableBig.getColumnModel().getColumnCount() > 0) {
            jTableBig.getColumnModel().getColumn(0).setResizable(false);
            jTableBig.getColumnModel().getColumn(0).setMaxWidth(65);
        }
    }
    private void setupFournisseur(String desig, boolean rarNZ){
        jTableBig.setModel(new javax.swing.table.DefaultTableModel(
                Fournisseur.display(desig, rarNZ),
                Fournisseur.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
                
            }
        );
        jTableBig.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableBig, new int[]{0});
        rightAlignCell(jTableBig, new int[]{3, 4});
        centerHeader(jTableBig);
        if (jTableBig.getColumnModel().getColumnCount() > 0) {
            jTableBig.getColumnModel().getColumn(0).setResizable(false);
            jTableBig.getColumnModel().getColumn(0).setMaxWidth(65);
        }
    }
    
    private void setupTwoTable(int size){
        if(MODE == MODE_BON_VENTE)
            jButtonImprimer.setEnabled(true);
        else
            jButtonImprimer.setEnabled(false);
        jButtonAdd.setEnabled(true);
        jButtonRemove.setEnabled(true);
        jButtonEdit.setEnabled(true);
        jButtonRapport.setEnabled(true);
        jButtonAccueilCompte.setVisible(false);
        jButtonAccueilAddCompte.setVisible(false);
        jButtonAccueilEditCompte.setVisible(false);
        jButtonAccueilRemoveCompte.setVisible(false); 
        jScrollPaneBig.setVisible(false);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBarOutils, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBarRubriques, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
            .addComponent(jLabelRubriqueCourante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPaneSmall1, javax.swing.GroupLayout.PREFERRED_SIZE, size, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSmall2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBarOutils, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBarRubriques, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRubriqueCourante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneSmall1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(jScrollPaneSmall2)))
        );
        jScrollPaneSmall1.setVisible(true);
        jScrollPaneSmall2.setVisible(true);
    }
    private void setupGroupeAchat(GroupeArticleAchat grpA, String desig, Date dateMin, Date dateMax, boolean qt, boolean afficheArticle){
        jTableSmall1.setModel(new javax.swing.table.DefaultTableModel(
                GroupeArticleAchat.display(),
                GroupeArticle.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTableSmall1.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableSmall1, new int[]{1});
        centerHeader(jTableSmall1);
        if(afficheArticle)
            setupArticleAchat(grpA, desig, dateMin, dateMax, qt);
    }
    private void setupArticleAchat(Object grpA, String desig, Date dateMin, Date dateMax, boolean qt){
        jTableSmall2.setModel(new javax.swing.table.DefaultTableModel(
                ArticleAchat.display(grpA, desig, dateMin, dateMax, qt),
                ArticleAchat.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTableSmall2.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableSmall2, new int[]{0, 2, 3, 4, 6});
        rightAlignCell(jTableSmall2, new int[]{5, 7});
        centerHeader(jTableSmall2);
        if (jTableSmall2.getColumnModel().getColumnCount() > 0) {
            jTableSmall2.getColumnModel().getColumn(0).setResizable(false);
            jTableSmall2.getColumnModel().getColumn(0).setMaxWidth(65);
            jTableSmall2.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTableSmall2.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTableSmall2.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTableSmall2.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTableSmall2.getColumnModel().getColumn(6).setPreferredWidth(70);
        }
    }
    
    private void setupGroupeVente(GroupeArticleVente grpA, String desig, Date dateMin, Date dateMax, boolean qt, boolean afficheArticle){
        jTableSmall1.setModel(new javax.swing.table.DefaultTableModel(
                GroupeArticleVente.display(),
                GroupeArticle.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTableSmall1.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableSmall1, new int[]{1});
        centerHeader(jTableSmall1);
        if(afficheArticle)
            setupArticleVente(grpA, desig, dateMin, dateMax, qt);
    }
    private void setupArticleVente(Object grpA, String desig, Date dateMin, Date dateMax, boolean qt){
        jTableSmall2.setModel(new javax.swing.table.DefaultTableModel(
                ArticleVente.display(grpA, desig, dateMin, dateMax, qt),
                ArticleVente.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTableSmall2.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableSmall2, new int[]{0, 2, 3, 4, 6});
        rightAlignCell(jTableSmall2, new int[]{5, 7});
        centerHeader(jTableSmall2);
        if (jTableSmall2.getColumnModel().getColumnCount() > 0) {
            jTableSmall2.getColumnModel().getColumn(0).setResizable(false);
            jTableSmall2.getColumnModel().getColumn(0).setMaxWidth(65);
            jTableSmall2.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTableSmall2.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTableSmall2.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTableSmall2.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTableSmall2.getColumnModel().getColumn(6).setPreferredWidth(70);
        }
    }
    private void setupAddArticle(String icon, String label, String[] tmpCombo, GroupeArticle grp, String desig, Date tmpDate, String unite, String qt, String pu, String tva){
        jLabelAddArticlePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/"+icon+".png")));
        jLabelAddArticlePrincipal.setText(label);
        jComboBoxAddArticleGroupe.setModel(new javax.swing.DefaultComboBoxModel(tmpCombo));
        jComboBoxAddArticleGroupe.setSelectedItem(grp.designation);
        jSpinnerAddArticleJour.setValue(tmpDate.day);
        jSpinnerAddArticleMois.setValue(tmpDate.month);
        jSpinnerAddArticleAnnee.setValue(tmpDate.year);
        jTextFieldAddArticleDesignation.setText(desig);
        jComboBoxAddArticleUnite.setModel(new javax.swing.DefaultComboBoxModel(SimpleArticle.displayUnite()));
        if(unite != null){
            if(!SimpleArticle.listUnite.contains(unite)){
                jComboBoxAddArticleUnite.addItem(unite);
                SimpleArticle.listUnite.add(unite);
            }
            jComboBoxAddArticleUnite.setSelectedItem(unite);
        }
        jTextFieldAddArticleAddUnite.setText("");
        jTextFieldAddArticleQT.setText(qt);
        jTextFieldAddArticlePU.setText(pu);
        jTextFieldAddArticleTVA.setText(tva);
        
        jDialogAddArticle.setVisible(true);
    }
    
    private void setupGroupeConso(GroupeConso grpCS, String desig, Date dateMin, Date dateMax, boolean afficheConso){
        jTableSmall1.setModel(new javax.swing.table.DefaultTableModel(
                GroupeConso.display(),
                GroupeArticle.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTableSmall1.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableSmall1, new int[]{1});
        centerHeader(jTableSmall1);
        if(afficheConso)
            setupConsommation(grpCS, desig, dateMin, dateMax);
    }
    private void setupConsommation(Object grpCS, String desig, Date dateMin, Date dateMax){
        jTableSmall2.setModel(new javax.swing.table.DefaultTableModel(
                Consommation.display(grpCS, desig, dateMin, dateMax),
                Consommation.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTableSmall2.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableSmall2, new int[]{0, 2, 3, 4});
        rightAlignCell(jTableSmall2, new int[]{5, 6, 7});
        centerHeader(jTableSmall2);
        if (jTableSmall2.getColumnModel().getColumnCount() > 0) {
            jTableSmall2.getColumnModel().getColumn(0).setResizable(false);
            jTableSmall2.getColumnModel().getColumn(0).setMaxWidth(65);
            jTableSmall2.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTableSmall2.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTableSmall2.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTableSmall2.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTableSmall2.getColumnModel().getColumn(6).setPreferredWidth(70);
        }
    }
    private void setupAddConso(String label){
        jLabelAddConsoPrincipal.setText(label);
        jCheckBoxAddConsoArticle.setSelected(false);
        jComboBoxAddConsoGroupeArticle.setModel(new javax.swing.DefaultComboBoxModel(GroupeArticleAchat.displayCombo()));
        jComboBoxAddConsoGroupeArticle.setEnabled(false);
        jComboBoxAddConsoGroupeArticle.setSelectedIndex(0);
        
        jTableAddConsoArticle.setEnabled(false);
        
        jDialogAddConso1.getRootPane().setDefaultButton(jButtonAddConsoConfirmer);
        jDialogAddConso.setVisible(true);
    }
    private void setupAddConso1(String label, String grpCombo, Date date, String desig, String unite, String quantite, int typeConso, String qtut, String prixUT, String prixTT, boolean unitModif){
        jLabelAddConsoPrincipal1.setText(label);
        jComboBoxAddConsoGroupe.setModel(new javax.swing.DefaultComboBoxModel(GroupeConso.displayCombo()));
        if(grpCombo != null)
            jComboBoxAddConsoGroupe.setSelectedItem(grpCombo);
        jSpinnerAddConsoJour.setValue(date.day);
        jSpinnerAddConsoMois.setValue(date.month);
        jSpinnerAddConsoAnnee.setValue(date.year);
        jTextFieldAddConsoDesignation.setText(desig);
        jComboBoxAddConsoUnite.setModel(new javax.swing.DefaultComboBoxModel(SimpleArticle.displayUnite()));
        if(unite != null){
            if(!SimpleArticle.listUnite.contains(unite)){
                jComboBoxAddConsoUnite.addItem(unite);
                SimpleArticle.listUnite.add(unite);
            }
            jComboBoxAddConsoUnite.setSelectedItem(unite);
        }
        jComboBoxAddConsoUnite.setEnabled(unitModif);
        jTextFieldAddConsoQT.setText(quantite);
        if(typeConso >= 0){
            jCheckBoxAddConsoQtUT.setSelected(true);
            jComboBoxAddConsoQtUT.setEnabled(true);
            jTextFieldAddConsoQtUT.setText(qtut);
            jTextFieldAddConsoQtUT.setEditable(true);
            jComboBoxAddConsoQtUT.setSelectedIndex(typeConso);
        }else{
            jCheckBoxAddConsoQtUT.setSelected(false);
            jComboBoxAddConsoQtUT.setEnabled(false);
            jTextFieldAddConsoQtUT.setText("");
            jTextFieldAddConsoQtUT.setEditable(false);
            jComboBoxAddConsoQtUT.setSelectedIndex(0);
        }
        jTextFieldAddConsoPU.setText(prixUT);
        jTextFieldAddConsoPT.setText(prixTT);
        
        jDialogAddConso1.setVisible(true);
    }
    
    private void setupRecette(String desig, Date dateMin, Date dateMax, String mode, String refPer){
        jLabelReglePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Recette.png")));
        jTableBig.setModel(new javax.swing.table.DefaultTableModel(
                Recette.display(desig, refPer, dateMin, dateMax, mode),
                Recette.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false};
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTableBig.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableBig, new int[]{0, 3, 5, 6});
        rightAlignCell(jTableBig, new int[]{4});
        centerHeader(jTableBig);
        if (jTableBig.getColumnModel().getColumnCount() > 0) {
            jTableBig.getColumnModel().getColumn(0).setResizable(false);
            jTableBig.getColumnModel().getColumn(0).setMaxWidth(65);
        }
    }
    private void setupDepense(String desig, Date dateMin, Date dateMax, String mode, String refPer){
        jLabelReglePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Debit.png")));
        jTableBig.setModel(new javax.swing.table.DefaultTableModel(
                Depense.display(desig, refPer, dateMin, dateMax, mode),
                Depense.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false};
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTableBig.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableBig, new int[]{0, 3, 5, 6});
        rightAlignCell(jTableBig, new int[]{4});
        centerHeader(jTableBig);
        if (jTableBig.getColumnModel().getColumnCount() > 0) {
            jTableBig.getColumnModel().getColumn(0).setResizable(false);
            jTableBig.getColumnModel().getColumn(0).setMaxWidth(65);
        }
    }
    private void setupAddReglement(String desig, String personne, Date tmpDate, String montant, String mode, String refCB){
        jTextFieldRegleDesig.setText(desig);
        jComboBoxReglePersonne.setModel(new javax.swing.DefaultComboBoxModel());
        if(personne != null)
            jComboBoxReglePersonne.setSelectedItem(personne);
        jSpinnerRegleJour.setValue(tmpDate.day);
        jSpinnerRegleMois.setValue(tmpDate.month);
        jSpinnerRegleAnnee.setValue(tmpDate.year);
        jTextFieldRegleMontant.setText(montant);
        jComboBoxRegleMode.setModel(new javax.swing.DefaultComboBoxModel(Reglement.displayMode()));
        jTextFieldRegleModeAdd.setText("");
        if(mode != null){
            if(!Reglement.listModeReg.contains(mode)){
                Reglement.listModeReg.add(mode);
                jComboBoxRegleMode.addItem(mode);
            }
            jComboBoxRegleMode.setSelectedItem(mode);
        }
        if(MODE == MODE_RECETTE){
            jLabelReglePrincipal.setText("Nouveau crédit");
            jLabelReglePersonne.setText("Créancier");
            for(Client i : VisDias.listClient)
                jComboBoxReglePersonne.addItem(i.designation);
        }else{
            jLabelReglePrincipal.setText("Nouveau Débit");
            jLabelReglePersonne.setText("Débiteur");
            for(Fournisseur i : VisDias.listFournisseur)
                jComboBoxReglePersonne.addItem(i.designation);
        }
        jTableRegleCB.setModel(new javax.swing.table.DefaultTableModel(
            CompteBanquaire.display(),
            CompteBanquaire.colonne()
            ){boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false};
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            });
        jTableRegleCB.setAutoCreateRowSorter(true);
        jTableRegleCB.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableRegleCB, new int[]{0, 3});
        centerHeader(jTableRegleCB);
        if (jTableRegleCB.getColumnModel().getColumnCount() > 0) {
            jTableBonArticle1.getColumnModel().getColumn(0).setResizable(false);
            jTableBonArticle1.getColumnModel().getColumn(0).setMaxWidth(75);
        }
        if(refCB != null){
            for(int i=0; i<jTableRegleCB.getRowCount(); i++){
                if(((String)jTableRegleCB.getValueAt(i, 0)).equals(refCB)){
                    jTableRegleCB.setRowSelectionInterval(i, i);
                    break;
                }
            }
        }
        
        jDialogRegle.getRootPane().setDefaultButton(jButtonRegleConfirmer);
        jDialogRegle.setVisible(true);
    }
    
    private void setupAchat(String desig, Date dateMin, Date dateMax, boolean afficheArticle, String refPer){
        jTableSmall1.setModel(new javax.swing.table.DefaultTableModel(
                BonAchat.display(desig, dateMin, dateMax, refPer),
                Bon.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTableSmall1.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableSmall1, new int[]{0, 2});
        rightAlignCell(jTableSmall1, new int[]{3, 4});
        centerHeader(jTableSmall1);
        if (jTableSmall1.getColumnModel().getColumnCount() > 0) {
            jTableSmall1.getColumnModel().getColumn(0).setResizable(false);
            jTableSmall1.getColumnModel().getColumn(0).setMaxWidth(65);
            jTableSmall1.getColumnModel().getColumn(1).setPreferredWidth(150);
            
        }
        if(afficheArticle){
            jTableSmall2.setModel(new javax.swing.table.DefaultTableModel(
                    ArticleBon.display(Bon.BonActif),
                    ArticleBon.colonne()
                )
                {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false, false, false};
                    public boolean isCellEditable(int rowIndex, int columnIndex){
                        return canEdit [columnIndex];
                    }
                }
            );
            jTableSmall2.getTableHeader().setReorderingAllowed(false);
            centerAlignCell(jTableSmall2, new int[]{0, 2, 3, 6});
            rightAlignCell(jTableSmall2, new int[]{4, 5, 7, 8});
            centerHeader(jTableSmall2);
            if (jTableSmall2.getColumnModel().getColumnCount() > 0) {
                jTableSmall2.getColumnModel().getColumn(0).setResizable(false);
                jTableSmall2.getColumnModel().getColumn(0).setMaxWidth(70);
                jTableSmall2.getColumnModel().getColumn(1).setPreferredWidth(200);
            }
        }
    }
    private void setupVente(String desig, Date dateMin, Date dateMax, boolean afficheArticle, String refPer){
        jTableSmall1.setModel(new javax.swing.table.DefaultTableModel(
                BonVente.display(desig, dateMin, dateMax, refPer),
                Bon.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTableSmall1.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableSmall1, new int[]{0, 2});
        rightAlignCell(jTableSmall1, new int[]{3, 4});
        centerHeader(jTableSmall1);
        if (jTableSmall1.getColumnModel().getColumnCount() > 0) {
            jTableSmall1.getColumnModel().getColumn(0).setResizable(false);
            jTableSmall1.getColumnModel().getColumn(0).setMaxWidth(65);
            jTableSmall1.getColumnModel().getColumn(1).setPreferredWidth(150);
        }
        if(afficheArticle){
            jTableSmall2.setModel(new javax.swing.table.DefaultTableModel(
                    ArticleBon.display(Bon.BonActif),
                    ArticleBon.colonne()
                )
                {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false, false, false};
                    public boolean isCellEditable(int rowIndex, int columnIndex){
                        return canEdit [columnIndex];
                    }
                }
            );
            jTableSmall2.getTableHeader().setReorderingAllowed(false);
            centerAlignCell(jTableSmall2, new int[]{0, 2, 3, 6});
            rightAlignCell(jTableSmall2, new int[]{4, 5, 7, 8});
            centerHeader(jTableSmall2);
            if (jTableSmall2.getColumnModel().getColumnCount() > 0) {
                jTableSmall2.getColumnModel().getColumn(0).setResizable(false);
                jTableSmall2.getColumnModel().getColumn(0).setMaxWidth(70);
                jTableSmall2.getColumnModel().getColumn(1).setPreferredWidth(200);
            }
        }
    }    
    private void setupBon(Bon bn, GroupeArticle grp, double SomHT, double SomTTC, boolean edit){
        if(MODE == MODE_BON_ACHAT){
            jComboBoxBonArticleGroupe.setModel(new javax.swing.DefaultComboBoxModel(GroupeArticleAchat.displayCombo()));
            jComboBoxBonArticleGroupe.setSelectedItem(grp.designation);
            jTableBonArticle1.setModel(new javax.swing.table.DefaultTableModel(
                    ArticleAchat.display(grp, null, null, null, false),
                    SimpleArticle.colonne()
                )
                {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false, false};
                    public boolean isCellEditable(int rowIndex, int columnIndex){
                        return canEdit [columnIndex];
                    }
                }
            );
            jTableBonArticle1.setAutoCreateRowSorter(true);
            jTableBonArticle1.getTableHeader().setReorderingAllowed(false);
            centerAlignCell(jTableBonArticle1, new int[]{0, 2, 3, 4, 6});
            rightAlignCell(jTableBonArticle1, new int[]{5, 7});
            centerHeader(jTableBonArticle1);
            if (jTableBonArticle1.getColumnModel().getColumnCount() > 0) {
                jTableBonArticle1.getColumnModel().getColumn(0).setResizable(false);
                jTableBonArticle1.getColumnModel().getColumn(0).setMaxWidth(100);
            }
        }else if(MODE == MODE_BON_VENTE){
            jComboBoxBonArticleGroupe.setModel(new javax.swing.DefaultComboBoxModel(GroupeArticleVente.displayCombo()));
            jComboBoxBonArticleGroupe.setSelectedItem(grp.designation);
            jTableBonArticle1.setModel(new javax.swing.table.DefaultTableModel(
                    ArticleVente.display(grp, null, null, null, false),
                    SimpleArticle.colonne()
                )
                {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false, false};
                    public boolean isCellEditable(int rowIndex, int columnIndex){
                        return canEdit [columnIndex];
                    }
                }
            );
            jTableBonArticle1.setAutoCreateRowSorter(true);
            jTableBonArticle1.getTableHeader().setReorderingAllowed(false);
            centerAlignCell(jTableBonArticle1, new int[]{0, 2, 3, 4, 6});
            rightAlignCell(jTableBonArticle1, new int[]{5, 7});
            centerHeader(jTableBonArticle1);
            if (jTableBonArticle1.getColumnModel().getColumnCount() > 0) {
                jTableBonArticle1.getColumnModel().getColumn(0).setResizable(false);
                jTableBonArticle1.getColumnModel().getColumn(0).setMaxWidth(100);
            }
        }
        
        jTableBonArticle2.setModel(new javax.swing.table.DefaultTableModel(
                    ArticleBon.display(bn),
                    ArticleBon.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, true, true, true, false, false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTableBonArticle2.setAutoCreateRowSorter(true);
        jTableBonArticle2.getTableHeader().setReorderingAllowed(false);
            centerAlignCell(jTableBonArticle2, new int[]{0, 2, 3, 6});
            rightAlignCell(jTableBonArticle2, new int[]{4, 5, 7, 8});
            centerHeader(jTableBonArticle2);
        if (jTableBonArticle2.getColumnModel().getColumnCount() > 0) {
            jTableBonArticle2.getColumnModel().getColumn(0).setResizable(false);
            jTableBonArticle2.getColumnModel().getColumn(0).setMaxWidth(100);
        }
        if(SomHT != -1){            
            jTextFieldBonArticleSomHT.setText(VisDias.formatDouble.format(SomHT));
        }else{
            jTextFieldBonArticleSomHT.setText(VisDias.formatDouble.format(calculBon(5)));
        }
        if(SomTTC != -1){
            jTextFieldBonArticleSomTTC.setText(VisDias.formatDouble.format(SomTTC));
        }else{
            jTextFieldBonArticleSomTTC.setText(VisDias.formatDouble.format(calculBon(8)));
        }
        jCheckBoxBonArticleTimbre.setSelected(false);
        jCheckBoxBonArticleRAR.setSelected(false);
        jCheckBoxBonArticleRAR.setEnabled(!edit);
    }
    private void setupBonPersonne(String label, Date tmpDate, String desig, String codePer, boolean showTablePersonne){
        String[][] tmpTab;
        jLabelBonPersonnePrincipal.setText(label);
        jSpinnerBonPersonneJour.setValue(tmpDate.day);
        jSpinnerBonPersonneMois.setValue(tmpDate.month);
        jSpinnerBonPersonneAnnee.setValue(tmpDate.year);
        jTextFieldBonPersonneDesignation.setText(desig);
        if(MODE == MODE_BON_ACHAT){
            tmpTab = Fournisseur.display(null, false);
            jTableBonPersonne.setModel(new javax.swing.table.DefaultTableModel(
                    tmpTab,
                    Personne.colonne()
                )
                {boolean[] canEdit = new boolean [] {false, false, false, false, false};
                    public boolean isCellEditable(int rowIndex, int columnIndex){
                        return canEdit [columnIndex];
                    }
                }
            );
        }else{
            tmpTab = Client.display(null, false);
            jTableBonPersonne.setModel(new javax.swing.table.DefaultTableModel(
                    tmpTab,
                    Personne.colonne()
                )
                {boolean[] canEdit = new boolean [] {false, false, false, false, false};
                    public boolean isCellEditable(int rowIndex, int columnIndex){
                        return canEdit [columnIndex];
                    }
                }
            );
        }
        jTableBonPersonne.setAutoCreateRowSorter(true);
        jTableBonPersonne.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableBonPersonne, new int[]{0});
        rightAlignCell(jTableBonPersonne, new int[]{3, 4});
        centerHeader(jTableBonPersonne);
        if (jTableBonPersonne.getColumnModel().getColumnCount() > 0) {
            jTableBonPersonne.getColumnModel().getColumn(0).setResizable(false);
            jTableBonPersonne.getColumnModel().getColumn(0).setMaxWidth(65);
        }
        if(codePer != null){
            for(int i = 0; i<tmpTab.length; i++){
                if(tmpTab[i][0].equals(codePer)){
                    jTableBonPersonne.setRowSelectionInterval(i, i);
                    break;
                }
            }
        }
        jTableBonPersonne.setEnabled(showTablePersonne);
        
        jDialogBonPersonne.getRootPane().setDefaultButton(jButtonBonPersonneSuivant);
        jDialogBonPersonne.setVisible(true);
    }

    private void setupCoordonnee(Coordonnee crd){
        jTextFieldCoordonneeDesignation.setText(crd.designation);
        jTextFieldCoordonneeCevilite.setText(crd.cevilite);
        jTextFieldCoordonneeAdresse.setText(crd.adresse);
        jTextFieldCoordonneeTel.setText(crd.nTel);
        jTextFieldCoordonneeRC.setText(crd.nRC);
        jTextFieldCoordonneeArt.setText(crd.nArt);
        jTextFieldCoordonneeNIF.setText(crd.NIF);
        jTextFieldCoordonneeNIS.setText(crd.NIS);
        jTextFieldCoordonneeFonction.setText(crd.Fonction);
        jTextFieldCoordonneeCptBanque.setText(crd.compteBancaire);
        
        jDialogCoordonnee.getRootPane().setDefaultButton(jButtonCoordonneConfirmer);
        jDialogCoordonnee.setVisible(true);
    }
    private void setupPayement(Personne per){
        jTextFieldPersonneCrDesignation.setText(per.crd.designation);
        jTextFieldPersonneCrCevilite.setText(per.crd.cevilite);
        jTextFieldPersonneCrAdresse.setText(per.crd.adresse);
        jTextFieldPersonneCrTel.setText(per.crd.nTel);
        jTextFieldPersonneCrRC.setText(per.crd.nRC);
        jTextFieldPersonneCrArt.setText(per.crd.nArt);
        jTextFieldPersonneCrNIF.setText(per.crd.NIF);
        jTextFieldPersonneCrNIS.setText(per.crd.NIS);
        jTextFieldPersonneCrFonction.setText(per.crd.Fonction);        
        jTextFieldPersonneCrCptBanque.setText(per.crd.compteBancaire);
        
        
        jTablePersonnePay.setModel(new javax.swing.table.DefaultTableModel(
                Payement.display(per),
                Payement.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        jTablePersonnePay.setAutoCreateRowSorter(true);
        jTablePersonnePay.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTablePersonnePay, new int[]{0, 1, 2});
        rightAlignCell(jTablePersonnePay, new int[]{3});
        centerHeader(jTablePersonnePay);
        if (jTablePersonnePay.getColumnModel().getColumnCount() > 0) {
            jTablePersonnePay.getColumnModel().getColumn(0).setResizable(false);
            jTablePersonnePay.getColumnModel().getColumn(0).setMaxWidth(100);
        }
        
        jDialogPersonneInfo.setVisible(true);
    }
    
    private int confirmationRemove(){
        String[] buttonLabels = new String[]{"Annuler", "Confirmer"};
        String defaultOption = buttonLabels[0];
        Icon icon = null;
        jLabelOption.setText("Êtes-vous sûr de vouloir supprimer?");
        return JOptionPane.showOptionDialog(this, jLabelOption,
                                            "Alerte", JOptionPane.OK_CANCEL_OPTION,
                                            JOptionPane.WARNING_MESSAGE, icon,
                                            buttonLabels, defaultOption);
    }
    
    private double calculBon(int column){
        // column==5 (HT)  |  column==8 (TTC)
        double som = 0.0;   double pt;
        try{
            for(int j = 0; j<jTableBonArticle2.getRowCount(); j++){
                pt = VisDias.formatDouble.parse((String)jTableBonArticle2.getValueAt(j, column)).doubleValue();
                som+=pt;
            }
            return som;
        }catch(Exception e){
            return -1;
        }
    }
    
    private void calculRapportPersonne(){
        double CA = 0; double RAR = 0;
        for(int i = 0; i<jTableBig.getRowCount(); i++){
            try {
                CA += VisDias.formatDouble.parse((String)jTableBig.getValueAt(i, 3)).doubleValue();
                RAR += VisDias.formatDouble.parse((String)jTableBig.getValueAt(i, 4)).doubleValue();
            } catch (ParseException ex) {
                Logger.getLogger(VisDiasGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jTextFieldResultatPersonneNbArticle.setText(VisDias.formatInt.format(jTableBig.getRowCount()));
        jTextFieldResultatPersonneCA.setText(VisDias.formatDouble.format(CA));
        jTextFieldResultatPersonneRAR.setText(VisDias.formatDouble.format(RAR));
        jDialogResultatPersonne.setVisible(true);
    }
    private void calculRapportArticle(Date dateDu, Date dateAu){
        double HT = 0; double TTC = 0;  Date[] tmpDate;
        for(int i = 0; i<jTableSmall2.getRowCount(); i++){
            try {
                HT += VisDias.formatDouble.parse((String)jTableSmall2.getValueAt(i, 5)).doubleValue() * VisDias.formatDouble.parse((String)jTableSmall2.getValueAt(i, 4)).doubleValue();
                TTC += VisDias.formatDouble.parse((String)jTableSmall2.getValueAt(i, 7)).doubleValue() * VisDias.formatDouble.parse((String)jTableSmall2.getValueAt(i, 4)).doubleValue();
            } catch (ParseException ex) {
                Logger.getLogger(VisDiasGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(dateDu != null && dateAu != null){
            jTextFieldResultatArticleDateDu.setText(dateDu.toString());
            jTextFieldResultatArticleDateAu.setText(dateAu.toString());
        }else{
            tmpDate = calculDateMinMax(jTableSmall2, 2);
            if(tmpDate[0]!=null && tmpDate[1]!=null){
                jTextFieldResultatArticleDateDu.setText(tmpDate[0].toString());
                jTextFieldResultatArticleDateAu.setText(tmpDate[1].toString());    
            }else{
                jTextFieldResultatArticleDateDu.setText("");
                jTextFieldResultatArticleDateAu.setText(""); 
            }
        }
        jTextFieldResultatArticleNbArticle.setText(VisDias.formatInt.format(jTableSmall2.getRowCount()));
        jTextFieldResultatArticlePrixHT.setText(VisDias.formatDouble.format(HT));
        jTextFieldResultatArticlePrixTTC.setText(VisDias.formatDouble.format(TTC));
        jTextFieldResultatArticlePrixTVA.setText(VisDias.formatDouble.format(TTC - HT));
        jDialogResultatArticle.setVisible(true);
    }
    private void calculRapportBon(Date dateDu, Date dateAu){
        double HT = 0; double TTC = 0;  Date[] tmpDate;
        for(int i = 0; i<jTableSmall1.getRowCount(); i++){
            try {
                HT += VisDias.formatDouble.parse((String)jTableSmall1.getValueAt(i, 3)).doubleValue();
                TTC += VisDias.formatDouble.parse((String)jTableSmall1.getValueAt(i, 4)).doubleValue();
            } catch (ParseException ex) {
                Logger.getLogger(VisDiasGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(dateDu != null && dateAu != null){
            jTextFieldResultatBonDateDu.setText(dateDu.toString());
            jTextFieldResultatBonDateAu.setText(dateAu.toString());
        }else{
            tmpDate = calculDateMinMax(jTableSmall1, 2);
            if(tmpDate[0] != null && tmpDate[1] != null){
                jTextFieldResultatBonDateDu.setText(tmpDate[0].toString());
                jTextFieldResultatBonDateAu.setText(tmpDate[1].toString());    
            }else{
                jTextFieldResultatBonDateDu.setText("");
                jTextFieldResultatBonDateAu.setText("");
            }
        }
        jTextFieldResultatBonNbArticle.setText(VisDias.formatInt.format(jTableSmall1.getRowCount()));
        jTextFieldResultatBonPrixHT.setText(VisDias.formatDouble.format(HT));
        jTextFieldResultatBonPrixTTC.setText(VisDias.formatDouble.format(TTC));
        jTextFieldResultatBonPrixTVA.setText(VisDias.formatDouble.format(TTC - HT));
        jDialogResultatBon.setVisible(true);
    }
    private void calculRapportConso(Date dateMin ,Date dateMax){
        double som = 0; Date[] tmpDate;
        for(int i=0; i<jTableSmall2.getRowCount(); i++){
            try{
                som += VisDias.formatDouble.parse((String)jTableSmall2.getValueAt(i, 7)).doubleValue();
            }catch(ParseException e){
                e.printStackTrace();
            }
        }
        if(dateMin != null && dateMax != null){
            jTextFieldResultatConsoDateDu.setText(dateMin.toString());
            jTextFieldResultatConsoDateAu.setText(dateMax.toString());
        }else{
            tmpDate = calculDateMinMax(jTableSmall2, 2);
            if(tmpDate[0] != null && tmpDate[1] != null){
                jTextFieldResultatConsoDateDu.setText(tmpDate[0].toString());
                jTextFieldResultatConsoDateAu.setText(tmpDate[1].toString());   
            }else{
                jTextFieldResultatConsoDateDu.setText("");
                jTextFieldResultatConsoDateAu.setText("");
            }
        }
        jTextFieldResultatConsoNbArticle.setText(Integer.toString(jTableSmall2.getRowCount()));
        jTextFieldResultatConsoPrixHT.setText(VisDias.formatDouble.format(som));
        
        jDialogResultatConso.setVisible(true);
    }
    private void calculRapportRegle(Date dateMin, Date dateMax){
        double som = 0; Date[] tmpDate;
        for(int i = 0; i < jTableBig.getRowCount(); i++){
            try{
                som += VisDias.formatDouble.parse((String)jTableBig.getValueAt(i, 4)).doubleValue();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(dateMin != null && dateMax != null){
            jTextFieldResultatRegleDateDu.setText(dateMin.toString());
            jTextFieldResultatRegleDateAu.setText(dateMax.toString());
        }else{
            tmpDate = calculDateMinMax(jTableBig, 3);
            if(tmpDate[0] != null && tmpDate[1] != null){
                jTextFieldResultatRegleDateDu.setText(tmpDate[0].toString());
                jTextFieldResultatRegleDateAu.setText(tmpDate[1].toString());  
            }else{
                jTextFieldResultatRegleDateDu.setText("");
                jTextFieldResultatRegleDateAu.setText("");
            }
        }
        jTextFieldResultatRegleNb.setText(Integer.toString(jTableBig.getRowCount()));
        jTextFieldResultatReglePrix.setText(VisDias.formatDouble.format(som));
        
        jDialogResultatRegle.setVisible(true);
    }
    
    private Date[] calculDateMinMax(javax.swing.JTable table, int column){
        Date[] out = new Date[2];       // [0]=Min  |  [1]=Max
        Date tmpDate;
        
        if(table.getRowCount() > 0){
            out[0] = Date.toDate((String)table.getValueAt(0, column));
            out[1] = Date.toDate((String)table.getValueAt(0, column));
            
            for(int i=0; i<table.getRowCount(); i++){
                tmpDate = Date.toDate((String)table.getValueAt(i, column));
                if(out[0].compareTo(tmpDate) == 1){
                    out[0] = tmpDate;
                }
                if(out[1].compareTo(tmpDate) == -1){
                    out[1] = tmpDate;
                }
            }
        }else{
            out[0] = null;
            out[1] = null;
        }
        
        return out;
    }
    
    public VisDiasGUI() {
        jLabelOption = new javax.swing.JLabel();
        jLabelOption.setFont(new Font("Segoe UI", 0, 12));
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        centerScreen();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        initComponents();
        this.setup();
        this.setupAccueil();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogAddPersonne = new javax.swing.JDialog();
        jTextFieldAddPersonneRAR = new javax.swing.JTextField();
        jLabelAddPersonnePrincipal = new javax.swing.JLabel();
        jTextFieldAddPersonneCA = new javax.swing.JTextField();
        jTextFieldAddPersonneAdresse = new javax.swing.JTextField();
        jLabelAddPersonneDesignation = new javax.swing.JLabel();
        jButtonAddPersonneAnnuler = new javax.swing.JButton();
        jLabelAddPersonneAdresse = new javax.swing.JLabel();
        jButtonAddPersonneConfirmer = new javax.swing.JButton();
        jLabelAddPersonneCA = new javax.swing.JLabel();
        jTextFieldAddPersonneDesignation = new javax.swing.JTextField();
        jLabelAddPersonneRAR = new javax.swing.JLabel();
        jLabelAddPersonneDA1 = new javax.swing.JLabel();
        jLabelAddPersonneDA2 = new javax.swing.JLabel();
        jDialogBonPersonne = new javax.swing.JDialog();
        jLabelBonPersonnePrincipal = new javax.swing.JLabel();
        jButtonBonPersonneSuivant = new javax.swing.JButton();
        jButtonBonPersonneAnnuler = new javax.swing.JButton();
        jScrollPaneBonPersonne = new javax.swing.JScrollPane();
        jTableBonPersonne = new javax.swing.JTable();
        jLabelBonPersonneDate = new javax.swing.JLabel();
        jSpinnerBonPersonneAnnee = new javax.swing.JSpinner();
        jSpinnerBonPersonneJour = new javax.swing.JSpinner();
        jSpinnerBonPersonneMois = new javax.swing.JSpinner();
        jLabelBonPersonneSlash1 = new javax.swing.JLabel();
        jLabelBonPersonneDesignation = new javax.swing.JLabel();
        jTextFieldBonPersonneDesignation = new javax.swing.JTextField();
        jLabelBonPersonneSlash2 = new javax.swing.JLabel();
        jDialogBonArticle = new javax.swing.JDialog();
        jLabelBonArticlePrincipal1 = new javax.swing.JLabel();
        jComboBoxBonArticleGroupe = new javax.swing.JComboBox();
        jLabelBonArticleGroupe = new javax.swing.JLabel();
        jScrollPaneBonArticle2 = new javax.swing.JScrollPane();
        jTableBonArticle2 = new javax.swing.JTable();
        jScrollPaneBonArticle1 = new javax.swing.JScrollPane();
        jTableBonArticle1 = new javax.swing.JTable();
        jButtonBonArticleAddArticle = new javax.swing.JButton();
        jButtonBonArticleAnnuler = new javax.swing.JButton();
        jButtonBonArticleConfirmer = new javax.swing.JButton();
        jLabelBonArticlePrincipal2 = new javax.swing.JLabel();
        jButtonBonArticleModifier = new javax.swing.JButton();
        jLabelBonArticleSomHT = new javax.swing.JLabel();
        jTextFieldBonArticleSomHT = new javax.swing.JTextField();
        jLabelBonArticleSomTTC = new javax.swing.JLabel();
        jTextFieldBonArticleSomTTC = new javax.swing.JTextField();
        jCheckBoxBonArticleTimbre = new javax.swing.JCheckBox();
        jCheckBoxBonArticleRAR = new javax.swing.JCheckBox();
        jDialogCompte = new javax.swing.JDialog();
        jScrollPaneCompte = new javax.swing.JScrollPane();
        jListCompte = new javax.swing.JList();
        jButtonCompteConfirmer = new javax.swing.JButton();
        jButtonCompteAnnuler = new javax.swing.JButton();
        jPasswordFieldCompteMDP = new javax.swing.JPasswordField();
        jLabelCompteMDP = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDialogAddCompte = new javax.swing.JDialog();
        jLabelAddComptePrincipal = new javax.swing.JLabel();
        jTextFieldAddCompteNom = new javax.swing.JTextField();
        jPasswordFieldAddCompteMDP = new javax.swing.JPasswordField();
        jPasswordFieldAddCompteCMDP = new javax.swing.JPasswordField();
        jLabelAddCompteNom = new javax.swing.JLabel();
        jLabelAddCompteMDP = new javax.swing.JLabel();
        jLabelAddCompteCMDP = new javax.swing.JLabel();
        jButtonAddCompteConfirmer = new javax.swing.JButton();
        jButtonAddCompteAnnuler = new javax.swing.JButton();
        jDialogAddArticle = new javax.swing.JDialog();
        jTabbedPaneAddArticle = new javax.swing.JTabbedPane();
        jPanelAddGroupeTab = new javax.swing.JPanel();
        jTextFieldAddGroupeDesignation = new javax.swing.JTextField();
        jLabelAddGroupeDesignation = new javax.swing.JLabel();
        jButtonAddGroupeConfirmer = new javax.swing.JButton();
        jButtonAddGroupeAnnuler = new javax.swing.JButton();
        jLabelAddGroupePrincipal = new javax.swing.JLabel();
        jPanelAddArticleTab = new javax.swing.JPanel();
        jLabelAddArticlePrincipal = new javax.swing.JLabel();
        jLabelAddArticleSlash1 = new javax.swing.JLabel();
        jTextFieldAddArticlePU = new javax.swing.JTextField();
        jLabelAddArticleSlash2 = new javax.swing.JLabel();
        jTextFieldAddArticleQT = new javax.swing.JTextField();
        jLabelAddArticleDate = new javax.swing.JLabel();
        jLabelAddArticleDesignation = new javax.swing.JLabel();
        jComboBoxAddArticleUnite = new javax.swing.JComboBox();
        jButtonAddArticleAnnuler = new javax.swing.JButton();
        jTextFieldAddArticleDesignation = new javax.swing.JTextField();
        jLabelAddArticleQT = new javax.swing.JLabel();
        jButtonAddArticleRemoveUnite = new javax.swing.JButton();
        jButtonAddArticleConfirmer = new javax.swing.JButton();
        jTextFieldAddArticleAddUnite = new javax.swing.JTextField();
        jLabelAddArticlePU = new javax.swing.JLabel();
        jButtonAddArticleAddUnite = new javax.swing.JButton();
        jSpinnerAddArticleMois = new javax.swing.JSpinner();
        jLabelAddArticleUnite = new javax.swing.JLabel();
        jSpinnerAddArticleJour = new javax.swing.JSpinner();
        jLabelAddArticleDA = new javax.swing.JLabel();
        jSpinnerAddArticleAnnee = new javax.swing.JSpinner();
        jLabelAddArticleGroupe = new javax.swing.JLabel();
        jComboBoxAddArticleGroupe = new javax.swing.JComboBox();
        jLabelAddArticleTVA = new javax.swing.JLabel();
        jTextFieldAddArticleTVA = new javax.swing.JTextField();
        jLabelAddArticlePourcent = new javax.swing.JLabel();
        jDialogCoordonnee = new javax.swing.JDialog();
        jLabelCoordonneePrincipal = new javax.swing.JLabel();
        jLabelCoordonneeCevilite = new javax.swing.JLabel();
        jLabelCoordonneeDesignation = new javax.swing.JLabel();
        jLabelCoordonneeAdresse = new javax.swing.JLabel();
        jLabelCoordonneeTel = new javax.swing.JLabel();
        jLabelCoordonneeRC = new javax.swing.JLabel();
        jLabelCoordonneeArt = new javax.swing.JLabel();
        jLabelCoordonneeNIF = new javax.swing.JLabel();
        jLabelCoordonneeNIS = new javax.swing.JLabel();
        jLabelCoordonneeCptBanque = new javax.swing.JLabel();
        jLabelCoordonneeFonction = new javax.swing.JLabel();
        jTextFieldCoordonneeDesignation = new javax.swing.JTextField();
        jTextFieldCoordonneeCevilite = new javax.swing.JTextField();
        jTextFieldCoordonneeAdresse = new javax.swing.JTextField();
        jTextFieldCoordonneeTel = new javax.swing.JTextField();
        jTextFieldCoordonneeRC = new javax.swing.JTextField();
        jTextFieldCoordonneeArt = new javax.swing.JTextField();
        jTextFieldCoordonneeNIS = new javax.swing.JTextField();
        jTextFieldCoordonneeNIF = new javax.swing.JTextField();
        jTextFieldCoordonneeCptBanque = new javax.swing.JTextField();
        jTextFieldCoordonneeFonction = new javax.swing.JTextField();
        jButtonCoordonneConfirmer = new javax.swing.JButton();
        jButtonCoordonneAnnuler = new javax.swing.JButton();
        jDialogResultatBon = new javax.swing.JDialog();
        jLabelResultatBonPrincipal = new javax.swing.JLabel();
        jLabelResultatBonNbArticle = new javax.swing.JLabel();
        jLabelResultatBonPrixHT = new javax.swing.JLabel();
        jLabelResultatBonPrixTTC = new javax.swing.JLabel();
        jTextFieldResultatBonNbArticle = new javax.swing.JTextField();
        jTextFieldResultatBonPrixHT = new javax.swing.JTextField();
        jTextFieldResultatBonPrixTTC = new javax.swing.JTextField();
        jButtonResultatBonOk = new javax.swing.JButton();
        jLabelResultatBonDateDu = new javax.swing.JLabel();
        jTextFieldResultatBonDateDu = new javax.swing.JTextField();
        jTextFieldResultatBonDateAu = new javax.swing.JTextField();
        jLabelResultatBonDateAu = new javax.swing.JLabel();
        jTextFieldResultatBonPrixTVA = new javax.swing.JTextField();
        jLabelResultatBonPrixTVA = new javax.swing.JLabel();
        jDialogRapportBon = new javax.swing.JDialog();
        jLabelRapportBonPrincipal = new javax.swing.JLabel();
        jLabelRapportBonDesignation = new javax.swing.JLabel();
        jLabelRapportBonDateDu = new javax.swing.JLabel();
        jLabelRapportBonDateAu = new javax.swing.JLabel();
        jSpinnerRapportBonDateDuJour = new javax.swing.JSpinner();
        jLabelRapportBonSlash1 = new javax.swing.JLabel();
        jLabelRapportBonSlash2 = new javax.swing.JLabel();
        jLabelRapportBonSlash3 = new javax.swing.JLabel();
        jLabelRapportBonSlash4 = new javax.swing.JLabel();
        jTextFieldRapportBonDesignation = new javax.swing.JTextField();
        jButtonRapportBonConfirmer = new javax.swing.JButton();
        jButtonRapportBonAnnuler = new javax.swing.JButton();
        jSpinnerRapportBonDateAuJour = new javax.swing.JSpinner();
        jSpinnerRapportBonDateAuMois = new javax.swing.JSpinner();
        jSpinnerRapportBonDateAuAnnee = new javax.swing.JSpinner();
        jCheckBoxRapportBonDate = new javax.swing.JCheckBox();
        jComboBoxRapportBonPersonne = new javax.swing.JComboBox();
        jLabelRapportBonPersonne = new javax.swing.JLabel();
        jSpinnerRapportBonDateDuMois = new javax.swing.JSpinner();
        jSpinnerRapportBonDateDuAnnee = new javax.swing.JSpinner();
        jDialogResultatArticle = new javax.swing.JDialog();
        jLabelResultatArticlePrincipal = new javax.swing.JLabel();
        jLabelResultatArticleNbArticle = new javax.swing.JLabel();
        jLabelResultatArticlePrixHT = new javax.swing.JLabel();
        jLabelResultatArticlePrixTTC = new javax.swing.JLabel();
        jTextFieldResultatArticleNbArticle = new javax.swing.JTextField();
        jTextFieldResultatArticlePrixHT = new javax.swing.JTextField();
        jTextFieldResultatArticlePrixTTC = new javax.swing.JTextField();
        jButtonResultatArticleOk = new javax.swing.JButton();
        jLabelResultatArticleDateDu = new javax.swing.JLabel();
        jTextFieldResultatArticleDateDu = new javax.swing.JTextField();
        jTextFieldResultatArticleDateAu = new javax.swing.JTextField();
        jLabelResultatArticleDateAu = new javax.swing.JLabel();
        jTextFieldResultatArticlePrixTVA = new javax.swing.JTextField();
        jLabelResultatArticlePrixTVA = new javax.swing.JLabel();
        jDialogResultatPersonne = new javax.swing.JDialog();
        jLabelResultatPersonnePrincipal = new javax.swing.JLabel();
        jLabelResultatPersonneNbArticle = new javax.swing.JLabel();
        jLabelResultatPersonneCA = new javax.swing.JLabel();
        jLabelResultatPersonneRAR = new javax.swing.JLabel();
        jTextFieldResultatPersonneNbArticle = new javax.swing.JTextField();
        jTextFieldResultatPersonneCA = new javax.swing.JTextField();
        jTextFieldResultatPersonneRAR = new javax.swing.JTextField();
        jButtonResultatPersonneOk = new javax.swing.JButton();
        jDialogRapportArticle = new javax.swing.JDialog();
        jLabelRapportArticlePrincipal = new javax.swing.JLabel();
        jLabelRapportArticleDesignation = new javax.swing.JLabel();
        jTextFieldRapportArticleDesignation = new javax.swing.JTextField();
        jButtonRapportArticleConfirmer = new javax.swing.JButton();
        jButtonRapportArticleAnnuler = new javax.swing.JButton();
        jLabelRapportArticleQt = new javax.swing.JLabel();
        jCheckBoxRapportArticleQt = new javax.swing.JCheckBox();
        jCheckBoxRapportArticleDate = new javax.swing.JCheckBox();
        jSpinnerRapportArticleDateAuMois = new javax.swing.JSpinner();
        jLabelRapportArticleSlash1 = new javax.swing.JLabel();
        jSpinnerRapportArticleDateAuAnnee = new javax.swing.JSpinner();
        jLabelRapportArticleSlash2 = new javax.swing.JLabel();
        jLabelRapportArticleSlash3 = new javax.swing.JLabel();
        jLabelRapportArticleSlash4 = new javax.swing.JLabel();
        jLabelRapportArticleDateDu = new javax.swing.JLabel();
        jLabelRapportArticleDateAu = new javax.swing.JLabel();
        jSpinnerRapportArticleDateDuAnnee = new javax.swing.JSpinner();
        jSpinnerRapportArticleDateAuJour = new javax.swing.JSpinner();
        jSpinnerRapportArticleDateDuJour = new javax.swing.JSpinner();
        jSpinnerRapportArticleDateDuMois = new javax.swing.JSpinner();
        jDialogRapportPersonne = new javax.swing.JDialog();
        jLabelRapportPersonnePrincipal = new javax.swing.JLabel();
        jLabelRapportPersonneDesignation = new javax.swing.JLabel();
        jLabelRapportPersonneRAR = new javax.swing.JLabel();
        jTextFieldRapportPersonneDesignation = new javax.swing.JTextField();
        jButtonRapportPersonneConfirmer = new javax.swing.JButton();
        jButtonRapportPersonneAnnuler = new javax.swing.JButton();
        jCheckBoxRapportPersonneRAR = new javax.swing.JCheckBox();
        jDialogImprimer = new javax.swing.JDialog();
        jLabelImprimerPrincipal = new javax.swing.JLabel();
        jComboBoxImprimerModele = new javax.swing.JComboBox();
        jButtonImprimerConfirmer = new javax.swing.JButton();
        jButtonImprimerAnnuler = new javax.swing.JButton();
        jDialogAddConso = new javax.swing.JDialog();
        jTabbedPaneAddConso = new javax.swing.JTabbedPane();
        jPanelAddGroupeConsoTab = new javax.swing.JPanel();
        jTextFieldAddGroupeConsoDesignation = new javax.swing.JTextField();
        jLabelAddGroupeConsoDesignation = new javax.swing.JLabel();
        jButtonAddGroupeConsoConfirmer = new javax.swing.JButton();
        jButtonAddGroupeConsoAnnuler = new javax.swing.JButton();
        jLabelAddGroupeConsoPrincipal = new javax.swing.JLabel();
        jPanelAddConsoTab = new javax.swing.JPanel();
        jLabelAddConsoPrincipal = new javax.swing.JLabel();
        jComboBoxAddConsoGroupeArticle = new javax.swing.JComboBox();
        jScrollPaneAddConsoArticle = new javax.swing.JScrollPane();
        jTableAddConsoArticle = new javax.swing.JTable();
        jButtonAddConsoSuivant = new javax.swing.JButton();
        jButtonAddConsoAnnuler = new javax.swing.JButton();
        jCheckBoxAddConsoArticle = new javax.swing.JCheckBox();
        jDialogAddConso1 = new javax.swing.JDialog();
        jTextFieldAddConsoQT = new javax.swing.JTextField();
        jLabelAddConsoDesignation = new javax.swing.JLabel();
        jComboBoxAddConsoUnite = new javax.swing.JComboBox();
        jButtonAddConsoAnnuler1 = new javax.swing.JButton();
        jTextFieldAddConsoDesignation = new javax.swing.JTextField();
        jLabelAddConsoQT = new javax.swing.JLabel();
        jButtonAddConsoRemoveUnite = new javax.swing.JButton();
        jButtonAddConsoConfirmer = new javax.swing.JButton();
        jTextFieldAddConsoAddUnite = new javax.swing.JTextField();
        jLabelAddConsoPU = new javax.swing.JLabel();
        jButtonAddConsoAddUnite = new javax.swing.JButton();
        jLabelAddConsoUnite = new javax.swing.JLabel();
        jLabelAddConsoDA = new javax.swing.JLabel();
        jLabelAddConsoGroupe = new javax.swing.JLabel();
        jLabelAddConsoPrincipal1 = new javax.swing.JLabel();
        jComboBoxAddConsoGroupe = new javax.swing.JComboBox();
        jTextFieldAddConsoPU = new javax.swing.JTextField();
        jCheckBoxAddConsoQtUT = new javax.swing.JCheckBox();
        jComboBoxAddConsoQtUT = new javax.swing.JComboBox();
        jTextFieldAddConsoQtUT = new javax.swing.JTextField();
        jLabelAddConsoDA1 = new javax.swing.JLabel();
        jLabelAddConsoPT = new javax.swing.JLabel();
        jTextFieldAddConsoPT = new javax.swing.JTextField();
        jSpinnerAddConsoAnnee = new javax.swing.JSpinner();
        jLabelAddConsoSlash3 = new javax.swing.JLabel();
        jLabelAddConsoSlash4 = new javax.swing.JLabel();
        jLabelAddConsoDate1 = new javax.swing.JLabel();
        jSpinnerAddConsoMois = new javax.swing.JSpinner();
        jSpinnerAddConsoJour = new javax.swing.JSpinner();
        jDialogResultatConso = new javax.swing.JDialog();
        jLabelResultatConsoPrincipal = new javax.swing.JLabel();
        jLabelResultatConsoNbArticle = new javax.swing.JLabel();
        jLabelResultatConsoPrix = new javax.swing.JLabel();
        jTextFieldResultatConsoNbArticle = new javax.swing.JTextField();
        jTextFieldResultatConsoPrixHT = new javax.swing.JTextField();
        jButtonResultatConsoOk = new javax.swing.JButton();
        jLabelResultatConsoDateDu = new javax.swing.JLabel();
        jTextFieldResultatConsoDateDu = new javax.swing.JTextField();
        jTextFieldResultatConsoDateAu = new javax.swing.JTextField();
        jLabelResultatConsoDateAu = new javax.swing.JLabel();
        jDialogRapportConso = new javax.swing.JDialog();
        jLabelRapportConsoPrincipal = new javax.swing.JLabel();
        jLabelRapportConsoDesignation = new javax.swing.JLabel();
        jLabelRapportConsoDateDu = new javax.swing.JLabel();
        jLabelRapportConsoDateAu = new javax.swing.JLabel();
        jSpinnerRapportConsoDateDuJour = new javax.swing.JSpinner();
        jLabelRapportConsoSlash1 = new javax.swing.JLabel();
        jLabelRapportConsoSlash2 = new javax.swing.JLabel();
        jLabelRapportConsoSlash3 = new javax.swing.JLabel();
        jLabelRapportConsoSlash4 = new javax.swing.JLabel();
        jTextFieldRapportConsoDesignation = new javax.swing.JTextField();
        jButtonRapportConsoConfirmer = new javax.swing.JButton();
        jButtonRapportConsoAnnuler = new javax.swing.JButton();
        jSpinnerRapportConsoDateAuJour = new javax.swing.JSpinner();
        jSpinnerRapportConsoDateAuMois = new javax.swing.JSpinner();
        jSpinnerRapportConsoDateAuAnnee = new javax.swing.JSpinner();
        jCheckBoxRapportConsoDate = new javax.swing.JCheckBox();
        jSpinnerRapportConsoDateDuMois = new javax.swing.JSpinner();
        jSpinnerRapportConsoDateDuAnnee = new javax.swing.JSpinner();
        jDialogRegle = new javax.swing.JDialog();
        jLabelRegleDesig = new javax.swing.JLabel();
        jLabelReglePersonne = new javax.swing.JLabel();
        jLabelRegleDate = new javax.swing.JLabel();
        jLabelRegleMontant = new javax.swing.JLabel();
        jLabelRegleMode = new javax.swing.JLabel();
        jLabelRegleCB = new javax.swing.JLabel();
        jComboBoxRegleMode = new javax.swing.JComboBox();
        jLabelReglePrincipal = new javax.swing.JLabel();
        jTextFieldRegleDesig = new javax.swing.JTextField();
        jComboBoxReglePersonne = new javax.swing.JComboBox();
        jSpinnerRegleAnnee = new javax.swing.JSpinner();
        jTextFieldRegleMontant = new javax.swing.JTextField();
        jTextFieldRegleModeAdd = new javax.swing.JTextField();
        jButtonRegleModeAdd = new javax.swing.JButton();
        jButtonRegleModeRemove = new javax.swing.JButton();
        jScrollPaneRegleCB = new javax.swing.JScrollPane();
        jTableRegleCB = new javax.swing.JTable();
        jButtonRegleConfirmer = new javax.swing.JButton();
        jButtonRegleCBAdd = new javax.swing.JButton();
        jButtonRegleAnnuler = new javax.swing.JButton();
        jSpinnerRegleJour = new javax.swing.JSpinner();
        jSpinnerRegleMois = new javax.swing.JSpinner();
        jLabelRegleSlash1 = new javax.swing.JLabel();
        jLabelRegleSlash2 = new javax.swing.JLabel();
        jButtonRegleCBRemove = new javax.swing.JButton();
        jDialogCb = new javax.swing.JDialog();
        jLabelCbPrincipal = new javax.swing.JLabel();
        jLabelCbBanque = new javax.swing.JLabel();
        jLabelCbAgence = new javax.swing.JLabel();
        jLabelCbNum = new javax.swing.JLabel();
        jTextFieldCbBanque = new javax.swing.JTextField();
        jTextFieldCbAgence = new javax.swing.JTextField();
        jTextFieldCbNum = new javax.swing.JTextField();
        jButtonCbConfirmer = new javax.swing.JButton();
        jButtonCbAnnuler = new javax.swing.JButton();
        jDialogRapportReglement = new javax.swing.JDialog();
        jSpinnerRapportRegleDateDuMois = new javax.swing.JSpinner();
        jLabelRapportRegleSlash2 = new javax.swing.JLabel();
        jSpinnerRapportRegleDateDuAnnee = new javax.swing.JSpinner();
        jLabelRapportRegleSlash3 = new javax.swing.JLabel();
        jLabelRapportRegleSlash4 = new javax.swing.JLabel();
        jTextFieldRapportRegleDesignation = new javax.swing.JTextField();
        jButtonRapportRegleConfirmer = new javax.swing.JButton();
        jLabelRapportReglePrincipal = new javax.swing.JLabel();
        jButtonRapportRegleAnnuler = new javax.swing.JButton();
        jLabelRapportRegleDesignation = new javax.swing.JLabel();
        jSpinnerRapportRegleDateAuJour = new javax.swing.JSpinner();
        jLabelRapportRegleDateDu = new javax.swing.JLabel();
        jSpinnerRapportRegleDateAuMois = new javax.swing.JSpinner();
        jLabelRapportRegleDateAu = new javax.swing.JLabel();
        jSpinnerRapportRegleDateAuAnnee = new javax.swing.JSpinner();
        jSpinnerRapportRegleDateDuJour = new javax.swing.JSpinner();
        jCheckBoxRapportRegleDate = new javax.swing.JCheckBox();
        jLabelRapportRegleSlash1 = new javax.swing.JLabel();
        jLabelRapportReglePersonne = new javax.swing.JLabel();
        jComboBoxRapportRegleMode = new javax.swing.JComboBox();
        jLabelRapportRegleMode = new javax.swing.JLabel();
        jButtonRapportRegleSolde = new javax.swing.JButton();
        jComboBoxRapportReglePersonne = new javax.swing.JComboBox();
        jDialogResultatRegle = new javax.swing.JDialog();
        jLabelResultatReglePrincipal = new javax.swing.JLabel();
        jLabelResultatRegleNb = new javax.swing.JLabel();
        jLabelResultatReglePrix = new javax.swing.JLabel();
        jTextFieldResultatRegleNb = new javax.swing.JTextField();
        jTextFieldResultatReglePrix = new javax.swing.JTextField();
        jButtonResultatRegleOk = new javax.swing.JButton();
        jLabelResultatRegleDateDu = new javax.swing.JLabel();
        jTextFieldResultatRegleDateDu = new javax.swing.JTextField();
        jTextFieldResultatRegleDateAu = new javax.swing.JTextField();
        jLabelResultatRegleDateAu = new javax.swing.JLabel();
        jDialogPersonneInfo = new javax.swing.JDialog();
        jTabbedPanePersonneInfo = new javax.swing.JTabbedPane();
        jPanelPersonnePayement = new javax.swing.JPanel();
        jButtonPersonnePayConfirmer = new javax.swing.JButton();
        jLabelPersonnePayPrincipal = new javax.swing.JLabel();
        jScrollPanePersonnePay = new javax.swing.JScrollPane();
        jTablePersonnePay = new javax.swing.JTable();
        jButtonPersonnePayAdd = new javax.swing.JButton();
        jButtonPersonnePayRemove = new javax.swing.JButton();
        jPanelPersonneCr = new javax.swing.JPanel();
        jButtonPersonneCrAnnuler = new javax.swing.JButton();
        jButtonPersonneCrConfirmer = new javax.swing.JButton();
        jLabelPersonneCrAdresse = new javax.swing.JLabel();
        jLabelPersonneCrTel = new javax.swing.JLabel();
        jLabelPersonneCrRC = new javax.swing.JLabel();
        jLabelPersonneCrArt = new javax.swing.JLabel();
        jLabelPersonneCrNIF = new javax.swing.JLabel();
        jLabelPersonneCrNIS = new javax.swing.JLabel();
        jLabelPersonneCrCptBanque = new javax.swing.JLabel();
        jLabelPersonneCrFonction = new javax.swing.JLabel();
        jTextFieldPersonneCrAdresse = new javax.swing.JTextField();
        jTextFieldPersonneCrTel = new javax.swing.JTextField();
        jTextFieldPersonneCrRC = new javax.swing.JTextField();
        jTextFieldPersonneCrArt = new javax.swing.JTextField();
        jTextFieldPersonneCrNIS = new javax.swing.JTextField();
        jTextFieldPersonneCrNIF = new javax.swing.JTextField();
        jTextFieldPersonneCrCptBanque = new javax.swing.JTextField();
        jTextFieldPersonneCrFonction = new javax.swing.JTextField();
        jLabelPersonneCrDesignation = new javax.swing.JLabel();
        jTextFieldPersonneCrDesignation = new javax.swing.JTextField();
        jLabelPersonneCrCevilite = new javax.swing.JLabel();
        jTextFieldPersonneCrCevilite = new javax.swing.JTextField();
        jLabelPersonneCrPrincipal = new javax.swing.JLabel();
        jDialogAddPayement = new javax.swing.JDialog();
        jButtonAddPayRegleRemove = new javax.swing.JButton();
        jTextFieldAddPayRegleAdd = new javax.swing.JTextField();
        jButtonAddPayRegleAdd = new javax.swing.JButton();
        jLabelAddPayDate = new javax.swing.JLabel();
        jLabelAddPayPT = new javax.swing.JLabel();
        jSpinnerAddPayJour = new javax.swing.JSpinner();
        jLabelAddPayDA = new javax.swing.JLabel();
        jLabelAddPaySlash1 = new javax.swing.JLabel();
        jTextFieldAddPayPT = new javax.swing.JTextField();
        jLabelAddPayPrincipal = new javax.swing.JLabel();
        jSpinnerAddPayMois = new javax.swing.JSpinner();
        jLabelAddPaySlash2 = new javax.swing.JLabel();
        jButtonAddPayAnnuler = new javax.swing.JButton();
        jSpinnerAddPayAnnee = new javax.swing.JSpinner();
        jButtonAddPayConfirmer = new javax.swing.JButton();
        jLabelAddPayRegle = new javax.swing.JLabel();
        jComboBoxAddPayRegle = new javax.swing.JComboBox();
        jToolBarOutils = new javax.swing.JToolBar();
        jButtonSauvegarde = new javax.swing.JButton();
        jButtonImprimer = new javax.swing.JButton();
        jButtonRapport = new javax.swing.JButton();
        jButtonUndo = new javax.swing.JButton();
        jSeparatorOutils = new javax.swing.JToolBar.Separator();
        jButtonAdd = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jToolBarRubriques = new javax.swing.JToolBar();
        jButtonAccueil = new javax.swing.JButton();
        jButtonClient = new javax.swing.JButton();
        jButtonFournisseur = new javax.swing.JButton();
        jButtonArticleAchat = new javax.swing.JButton();
        jButtonConso = new javax.swing.JButton();
        jButtonAchat = new javax.swing.JButton();
        jButtonArticleVente = new javax.swing.JButton();
        jButtonVente = new javax.swing.JButton();
        jButtonRecette = new javax.swing.JButton();
        jButtonDepense = new javax.swing.JButton();
        jLabelRubriqueCourante = new javax.swing.JLabel();

        jDialogAddPersonne.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogAddPersonne.setLocation(centerX-425/2,centerY-330/2);
        jDialogAddPersonne.setModal(true);
        jDialogAddPersonne.setResizable(false);
        jDialogAddPersonne.setSize(new java.awt.Dimension(425, 330));

        jTextFieldAddPersonneRAR.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldAddPersonneRAR.setText("0");

        jLabelAddPersonnePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelAddPersonnePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddPersonnePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Fournisseur.png"))); // NOI18N
        jLabelAddPersonnePrincipal.setText("XXXXXXXXXXXX");
        jLabelAddPersonnePrincipal.setIconTextGap(10);

        jTextFieldAddPersonneCA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldAddPersonneCA.setText("0");

        jTextFieldAddPersonneAdresse.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddPersonneDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddPersonneDesignation.setText("Désignation");

        jButtonAddPersonneAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddPersonneAnnuler.setText("Annuler");
        jButtonAddPersonneAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPersonneAnnulerActionPerformed(evt);
            }
        });

        jLabelAddPersonneAdresse.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddPersonneAdresse.setText("Adresse");

        jButtonAddPersonneConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddPersonneConfirmer.setText("Confirmer");
        jButtonAddPersonneConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPersonneConfirmerActionPerformed(evt);
            }
        });

        jLabelAddPersonneCA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddPersonneCA.setText("Chiffre d'affaire");

        jTextFieldAddPersonneDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddPersonneRAR.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddPersonneRAR.setText("Reste à régler");

        jLabelAddPersonneDA1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddPersonneDA1.setText(".00 DA");

        jLabelAddPersonneDA2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddPersonneDA2.setText(".00 DA");

        javax.swing.GroupLayout jDialogAddPersonneLayout = new javax.swing.GroupLayout(jDialogAddPersonne.getContentPane());
        jDialogAddPersonne.getContentPane().setLayout(jDialogAddPersonneLayout);
        jDialogAddPersonneLayout.setHorizontalGroup(
            jDialogAddPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddPersonneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogAddPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAddPersonneCA)
                    .addComponent(jLabelAddPersonneAdresse)
                    .addComponent(jLabelAddPersonneDesignation)
                    .addComponent(jLabelAddPersonneRAR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogAddPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldAddPersonneDesignation, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldAddPersonneAdresse, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogAddPersonneLayout.createSequentialGroup()
                        .addGroup(jDialogAddPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldAddPersonneRAR, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAddPersonneCA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialogAddPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAddPersonneDA1)
                            .addComponent(jLabelAddPersonneDA2))))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAddPersonneLayout.createSequentialGroup()
                .addContainerGap(243, Short.MAX_VALUE)
                .addComponent(jButtonAddPersonneAnnuler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAddPersonneConfirmer)
                .addContainerGap())
            .addComponent(jLabelAddPersonnePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogAddPersonneLayout.setVerticalGroup(
            jDialogAddPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAddPersonneLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelAddPersonnePrincipal)
                .addGap(26, 26, 26)
                .addGroup(jDialogAddPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddPersonneDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddPersonneDesignation))
                .addGap(18, 18, 18)
                .addGroup(jDialogAddPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddPersonneAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddPersonneAdresse))
                .addGap(20, 20, 20)
                .addGroup(jDialogAddPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddPersonneCA, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddPersonneCA)
                    .addComponent(jLabelAddPersonneDA1))
                .addGap(18, 18, 18)
                .addGroup(jDialogAddPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddPersonneRAR, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddPersonneRAR)
                    .addComponent(jLabelAddPersonneDA2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogAddPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddPersonneConfirmer)
                    .addComponent(jButtonAddPersonneAnnuler))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jDialogBonPersonne.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogBonPersonne.setLocation(centerX - 450/2, centerY - 410/2);
        jDialogBonPersonne.setModal(true);
        jDialogBonPersonne.setResizable(false);
        jDialogBonPersonne.setSize(new java.awt.Dimension(450, 410));

        jLabelBonPersonnePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelBonPersonnePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBonPersonnePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Bon.png"))); // NOI18N
        jLabelBonPersonnePrincipal.setText("Ajout Bon");

        jButtonBonPersonneSuivant.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonBonPersonneSuivant.setText("Suivant >");
        jButtonBonPersonneSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBonPersonneSuivantActionPerformed(evt);
            }
        });

        jButtonBonPersonneAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonBonPersonneAnnuler.setText("Annuler");
        jButtonBonPersonneAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBonPersonneAnnulerActionPerformed(evt);
            }
        });

        jScrollPaneBonPersonne.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTableBonPersonne.getTableHeader().setFont(new Font("Segoe UI", 0, 12));
        jTableBonPersonne.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTableBonPersonne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableBonPersonne.setRowHeight(22);
        jTableBonPersonne.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneBonPersonne.setViewportView(jTableBonPersonne);

        jLabelBonPersonneDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelBonPersonneDate.setText("Date");

        jSpinnerBonPersonneAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerBonPersonneAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jSpinnerBonPersonneJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerBonPersonneJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jSpinnerBonPersonneMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerBonPersonneMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabelBonPersonneSlash1.setText("/");

        jLabelBonPersonneDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelBonPersonneDesignation.setText("Désignation");

        jTextFieldBonPersonneDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelBonPersonneSlash2.setText("/");

        javax.swing.GroupLayout jDialogBonPersonneLayout = new javax.swing.GroupLayout(jDialogBonPersonne.getContentPane());
        jDialogBonPersonne.getContentPane().setLayout(jDialogBonPersonneLayout);
        jDialogBonPersonneLayout.setHorizontalGroup(
            jDialogBonPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogBonPersonneLayout.createSequentialGroup()
                .addGroup(jDialogBonPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogBonPersonneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPaneBonPersonne, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogBonPersonneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonBonPersonneAnnuler)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBonPersonneSuivant))
                    .addGroup(jDialogBonPersonneLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jDialogBonPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogBonPersonneLayout.createSequentialGroup()
                                .addComponent(jLabelBonPersonneDate)
                                .addGap(53, 53, 53)
                                .addComponent(jSpinnerBonPersonneJour, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabelBonPersonneSlash2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jSpinnerBonPersonneMois, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabelBonPersonneSlash1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jSpinnerBonPersonneAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialogBonPersonneLayout.createSequentialGroup()
                                .addComponent(jLabelBonPersonneDesignation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldBonPersonneDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabelBonPersonnePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogBonPersonneLayout.setVerticalGroup(
            jDialogBonPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogBonPersonneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBonPersonnePrincipal)
                .addGap(18, 18, 18)
                .addGroup(jDialogBonPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBonPersonneDate)
                    .addComponent(jSpinnerBonPersonneAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerBonPersonneJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBonPersonneSlash1)
                    .addComponent(jLabelBonPersonneSlash2)
                    .addComponent(jSpinnerBonPersonneMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jDialogBonPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBonPersonneDesignation)
                    .addComponent(jTextFieldBonPersonneDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneBonPersonne, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogBonPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBonPersonneSuivant)
                    .addComponent(jButtonBonPersonneAnnuler))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jDialogBonArticle.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogBonArticle.setLocation(centerX - 820/2, centerY - 620/2);
        jDialogBonArticle.setModal(true);
        jDialogBonArticle.setResizable(false);
        jDialogBonArticle.setSize(new java.awt.Dimension(820, 620));

        jLabelBonArticlePrincipal1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelBonArticlePrincipal1.setText("Article en stock");

        jComboBoxBonArticleGroupe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxBonArticleGroupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBonArticleGroupeActionPerformed(evt);
            }
        });

        jLabelBonArticleGroupe.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelBonArticleGroupe.setText("Groupe :");

        jTableBonArticle2.getTableHeader().setFont(new Font("Segoe UI", 0, 11));
        jTableBonArticle2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTableBonArticle2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableBonArticle2.setRowHeight(25);
        jTableBonArticle2.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTableBonArticle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount() == 2)
                if(jTableBonArticle2.getSelectedRow() != -1)
                jTableBonArticle2DoubleClick(jTableBonArticle2.getSelectedRow());
            }
        });
        jTableBonArticle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBonArticle2MouseClicked(evt);
            }
        });
        CellEditorListener ChangeNotification = new CellEditorListener() {
            public void editingStopped(ChangeEvent e) {
                jTableBonArticle2ValueChanged();
            }

            @Override
            public void editingCanceled(ChangeEvent e) {}
        };
        jTableBonArticle2.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
        jScrollPaneBonArticle2.setViewportView(jTableBonArticle2);

        jTableBonArticle1.getTableHeader().setFont(new Font("Segoe UI", 0, 11));
        jTableBonArticle1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTableBonArticle1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableBonArticle1.setRowHeight(25);
        jTableBonArticle1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTableBonArticle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount() == 2)
                if(jTableBonArticle1.getSelectedRow() != -1)
                jTableBonArticle1DoubleClick(jTableBonArticle1.getSelectedRow());
            }
        });
        jTableBonArticle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBonArticle1MouseClicked(evt);
            }
        });
        jTableBonArticle1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableBonArticle1KeyPressed(evt);
            }
        });
        jScrollPaneBonArticle1.setViewportView(jTableBonArticle1);

        jButtonBonArticleAddArticle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonBonArticleAddArticle.setText("Ajouter");
        jButtonBonArticleAddArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBonArticleAddArticleActionPerformed(evt);
            }
        });

        jButtonBonArticleAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonBonArticleAnnuler.setText("Annuler");
        jButtonBonArticleAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBonArticleAnnulerActionPerformed(evt);
            }
        });

        jButtonBonArticleConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonBonArticleConfirmer.setText("Confirmer");
        jButtonBonArticleConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBonArticleConfirmerActionPerformed(evt);
            }
        });

        jLabelBonArticlePrincipal2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelBonArticlePrincipal2.setText("Articles du bon");

        jButtonBonArticleModifier.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonBonArticleModifier.setText("Modifier");
        jButtonBonArticleModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBonArticleModifierActionPerformed(evt);
            }
        });

        jLabelBonArticleSomHT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelBonArticleSomHT.setText("Somme totale HT");

        jTextFieldBonArticleSomHT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelBonArticleSomTTC.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelBonArticleSomTTC.setText("Somme totale TTC");

        jTextFieldBonArticleSomTTC.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jCheckBoxBonArticleTimbre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBoxBonArticleTimbre.setText("Inclure montant timbre");
        jCheckBoxBonArticleTimbre.setIconTextGap(10);

        jCheckBoxBonArticleRAR.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBoxBonArticleRAR.setText("Somme totale payée");
        jCheckBoxBonArticleRAR.setIconTextGap(10);

        javax.swing.GroupLayout jDialogBonArticleLayout = new javax.swing.GroupLayout(jDialogBonArticle.getContentPane());
        jDialogBonArticle.getContentPane().setLayout(jDialogBonArticleLayout);
        jDialogBonArticleLayout.setHorizontalGroup(
            jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogBonArticleLayout.createSequentialGroup()
                .addGroup(jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogBonArticleLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneBonArticle1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDialogBonArticleLayout.createSequentialGroup()
                                .addComponent(jLabelBonArticlePrincipal1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(210, 210, 210)
                                .addComponent(jLabelBonArticleGroupe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxBonArticleGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBonArticleModifier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBonArticleAddArticle))
                            .addGroup(jDialogBonArticleLayout.createSequentialGroup()
                                .addGroup(jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDialogBonArticleLayout.createSequentialGroup()
                                        .addComponent(jLabelBonArticleSomTTC)
                                        .addGap(18, 18, 18)
                                        .addGroup(jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldBonArticleSomHT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldBonArticleSomTTC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabelBonArticleSomHT))
                                .addGap(41, 41, 41)
                                .addGroup(jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxBonArticleTimbre)
                                    .addComponent(jCheckBoxBonArticleRAR))
                                .addGap(169, 169, 169)
                                .addComponent(jButtonBonArticleAnnuler)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBonArticleConfirmer))))
                    .addGroup(jDialogBonArticleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneBonArticle2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelBonArticlePrincipal2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogBonArticleLayout.setVerticalGroup(
            jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogBonArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBonArticlePrincipal1)
                    .addComponent(jButtonBonArticleModifier)
                    .addComponent(jButtonBonArticleAddArticle)
                    .addComponent(jComboBoxBonArticleGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBonArticleGroupe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneBonArticle1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelBonArticlePrincipal2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneBonArticle2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBonArticleSomHT)
                    .addComponent(jTextFieldBonArticleSomHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxBonArticleTimbre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonBonArticleAnnuler)
                        .addComponent(jButtonBonArticleConfirmer))
                    .addGroup(jDialogBonArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBonArticleSomTTC)
                        .addComponent(jTextFieldBonArticleSomTTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBoxBonArticleRAR)))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jDialogCompte.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogCompte.setLocation(centerX - 350/2, centerY - 300/2);
        jDialogCompte.setModal(true);
        jDialogCompte.setResizable(false);
        jDialogCompte.setSize(new java.awt.Dimension(350, 300));

        jListCompte.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jListCompte.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListCompte.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListCompte.setFixedCellHeight(30);
        jScrollPaneCompte.setViewportView(jListCompte);

        jButtonCompteConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonCompteConfirmer.setText("Confirmer");
        jButtonCompteConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompteConfirmerActionPerformed(evt);
            }
        });

        jButtonCompteAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonCompteAnnuler.setText("Annuler");
        jButtonCompteAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompteAnnulerActionPerformed(evt);
            }
        });

        jPasswordFieldCompteMDP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelCompteMDP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCompteMDP.setText("Mot de passe :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Comptes :");

        javax.swing.GroupLayout jDialogCompteLayout = new javax.swing.GroupLayout(jDialogCompte.getContentPane());
        jDialogCompte.getContentPane().setLayout(jDialogCompteLayout);
        jDialogCompteLayout.setHorizontalGroup(
            jDialogCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCompteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogCompteLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jDialogCompteLayout.createSequentialGroup()
                        .addGroup(jDialogCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneCompte)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogCompteLayout.createSequentialGroup()
                                .addGap(0, 150, Short.MAX_VALUE)
                                .addComponent(jButtonCompteAnnuler)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCompteConfirmer))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogCompteLayout.createSequentialGroup()
                                .addComponent(jLabelCompteMDP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordFieldCompteMDP)))
                        .addContainerGap())))
        );
        jDialogCompteLayout.setVerticalGroup(
            jDialogCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCompteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldCompteMDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCompteMDP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCompteConfirmer)
                    .addComponent(jButtonCompteAnnuler))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jDialogAddCompte.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogAddCompte.setLocation(centerX - 420/2, centerY - 270/2);
        jDialogAddCompte.setModal(true);
        jDialogAddCompte.setResizable(false);
        jDialogAddCompte.setSize(new java.awt.Dimension(420, 270));

        jLabelAddComptePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelAddComptePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddComptePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/File.png"))); // NOI18N
        jLabelAddComptePrincipal.setText("Ajout Compte");
        jLabelAddComptePrincipal.setIconTextGap(10);

        jTextFieldAddCompteNom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jPasswordFieldAddCompteMDP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jPasswordFieldAddCompteCMDP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddCompteNom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddCompteNom.setText("Nom de compte");

        jLabelAddCompteMDP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddCompteMDP.setText("Mot de passe");

        jLabelAddCompteCMDP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddCompteCMDP.setText("Confirmer mot de passe");

        jButtonAddCompteConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddCompteConfirmer.setText("Confirmer");
        jButtonAddCompteConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCompteConfirmerActionPerformed(evt);
            }
        });

        jButtonAddCompteAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddCompteAnnuler.setText("Annuler");
        jButtonAddCompteAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCompteAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogAddCompteLayout = new javax.swing.GroupLayout(jDialogAddCompte.getContentPane());
        jDialogAddCompte.getContentPane().setLayout(jDialogAddCompteLayout);
        jDialogAddCompteLayout.setHorizontalGroup(
            jDialogAddCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddCompteLayout.createSequentialGroup()
                .addGroup(jDialogAddCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogAddCompteLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabelAddCompteNom))
                    .addGroup(jDialogAddCompteLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabelAddCompteMDP))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAddCompteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelAddCompteCMDP)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogAddCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldAddCompteCMDP, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPasswordFieldAddCompteMDP)
                    .addComponent(jTextFieldAddCompteNom))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAddCompteLayout.createSequentialGroup()
                .addGap(0, 104, Short.MAX_VALUE)
                .addComponent(jButtonAddCompteAnnuler)
                .addGap(68, 68, 68)
                .addComponent(jButtonAddCompteConfirmer)
                .addGap(86, 86, 86))
            .addComponent(jLabelAddComptePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogAddCompteLayout.setVerticalGroup(
            jDialogAddCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddCompteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAddComptePrincipal)
                .addGap(18, 18, 18)
                .addGroup(jDialogAddCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddCompteNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddCompteNom))
                .addGap(18, 18, 18)
                .addGroup(jDialogAddCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldAddCompteMDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddCompteMDP))
                .addGap(18, 18, 18)
                .addGroup(jDialogAddCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldAddCompteCMDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddCompteCMDP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogAddCompteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddCompteConfirmer)
                    .addComponent(jButtonAddCompteAnnuler))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jDialogAddArticle.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogAddArticle.setLocation(centerX - 450/2, centerY - 475/2);
        jDialogAddArticle.setModal(true);
        jDialogAddArticle.setResizable(false);
        jDialogAddArticle.setSize(new java.awt.Dimension(450, 475));

        jTextFieldAddGroupeDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddGroupeDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddGroupeDesignation.setText("Nom du groupe");

        jButtonAddGroupeConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddGroupeConfirmer.setText("Confirmer");
        jButtonAddGroupeConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddGroupeConfirmerActionPerformed(evt);
            }
        });

        jButtonAddGroupeAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddGroupeAnnuler.setText("Annuler");
        jButtonAddGroupeAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddGroupeAnnulerActionPerformed(evt);
            }
        });

        jLabelAddGroupePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelAddGroupePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddGroupePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/groupe.png"))); // NOI18N
        jLabelAddGroupePrincipal.setText("Ajout Groupe");
        jLabelAddGroupePrincipal.setIconTextGap(20);

        javax.swing.GroupLayout jPanelAddGroupeTabLayout = new javax.swing.GroupLayout(jPanelAddGroupeTab);
        jPanelAddGroupeTab.setLayout(jPanelAddGroupeTabLayout);
        jPanelAddGroupeTabLayout.setHorizontalGroup(
            jPanelAddGroupeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddGroupeTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddGroupeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddGroupeTabLayout.createSequentialGroup()
                        .addGap(0, 257, Short.MAX_VALUE)
                        .addComponent(jButtonAddGroupeAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddGroupeConfirmer))
                    .addGroup(jPanelAddGroupeTabLayout.createSequentialGroup()
                        .addComponent(jLabelAddGroupeDesignation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAddGroupeDesignation)))
                .addContainerGap())
            .addComponent(jLabelAddGroupePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelAddGroupeTabLayout.setVerticalGroup(
            jPanelAddGroupeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddGroupeTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAddGroupePrincipal)
                .addGap(26, 26, 26)
                .addGroup(jPanelAddGroupeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddGroupeDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddGroupeDesignation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addGroup(jPanelAddGroupeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddGroupeConfirmer)
                    .addComponent(jButtonAddGroupeAnnuler))
                .addContainerGap())
        );

        jTabbedPaneAddArticle.addTab("Groupe Article", jPanelAddGroupeTab);

        jLabelAddArticlePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelAddArticlePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddArticlePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Article.png"))); // NOI18N
        jLabelAddArticlePrincipal.setText("Ajout Article");
        jLabelAddArticlePrincipal.setToolTipText("");
        jLabelAddArticlePrincipal.setIconTextGap(20);

        jLabelAddArticleSlash1.setText("/");

        jTextFieldAddArticlePU.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddArticleSlash2.setText("/");

        jTextFieldAddArticleQT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddArticleDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddArticleDate.setText("Date");

        jLabelAddArticleDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddArticleDesignation.setText("Désignation");

        jComboBoxAddArticleUnite.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxAddArticleUnite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAddArticleAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddArticleAnnuler.setText("Annuler");
        jButtonAddArticleAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddArticleAnnulerActionPerformed(evt);
            }
        });

        jTextFieldAddArticleDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddArticleQT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddArticleQT.setText("Quantité");

        jButtonAddArticleRemoveUnite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Remove_Unite.png"))); // NOI18N
        jButtonAddArticleRemoveUnite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddArticleRemoveUniteActionPerformed(evt);
            }
        });

        jButtonAddArticleConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddArticleConfirmer.setText("Confirmer");
        jButtonAddArticleConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddArticleConfirmerActionPerformed(evt);
            }
        });

        jTextFieldAddArticleAddUnite.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddArticlePU.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddArticlePU.setText("Prix unitaire");

        jButtonAddArticleAddUnite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Add_Unite.png"))); // NOI18N
        jButtonAddArticleAddUnite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddArticleAddUniteActionPerformed(evt);
            }
        });

        jSpinnerAddArticleMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerAddArticleMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabelAddArticleUnite.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddArticleUnite.setText("Unité");

        jSpinnerAddArticleJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerAddArticleJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jLabelAddArticleDA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddArticleDA.setText(".00 DA");

        jSpinnerAddArticleAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerAddArticleAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabelAddArticleGroupe.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddArticleGroupe.setText("Groupe");

        jComboBoxAddArticleGroupe.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxAddArticleGroupe.setMaximumRowCount(20);
        jComboBoxAddArticleGroupe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelAddArticleTVA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddArticleTVA.setText("T.V.A");

        jTextFieldAddArticleTVA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddArticlePourcent.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddArticlePourcent.setText("%");

        javax.swing.GroupLayout jPanelAddArticleTabLayout = new javax.swing.GroupLayout(jPanelAddArticleTab);
        jPanelAddArticleTab.setLayout(jPanelAddArticleTabLayout);
        jPanelAddArticleTabLayout.setHorizontalGroup(
            jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddArticleTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddArticleTabLayout.createSequentialGroup()
                        .addGroup(jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAddArticleDate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAddArticleDesignation)
                            .addComponent(jLabelAddArticleUnite)
                            .addComponent(jLabelAddArticleQT)
                            .addComponent(jLabelAddArticlePU)
                            .addComponent(jLabelAddArticleGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAddArticleTabLayout.createSequentialGroup()
                                .addComponent(jTextFieldAddArticlePU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAddArticleDA))
                            .addComponent(jTextFieldAddArticleQT)
                            .addGroup(jPanelAddArticleTabLayout.createSequentialGroup()
                                .addComponent(jComboBoxAddArticleUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAddArticleRemoveUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAddArticleAddUnite)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAddArticleAddUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldAddArticleDesignation)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddArticleTabLayout.createSequentialGroup()
                                .addComponent(jSpinnerAddArticleJour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabelAddArticleSlash1)
                                .addGap(34, 34, 34)
                                .addComponent(jSpinnerAddArticleMois, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelAddArticleSlash2)
                                .addGap(34, 34, 34)
                                .addComponent(jSpinnerAddArticleAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelAddArticleTabLayout.createSequentialGroup()
                                .addComponent(jComboBoxAddArticleGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddArticleTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAddArticleAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddArticleConfirmer)
                        .addContainerGap())
                    .addGroup(jPanelAddArticleTabLayout.createSequentialGroup()
                        .addComponent(jLabelAddArticleTVA)
                        .addGap(52, 52, 52)
                        .addComponent(jTextFieldAddArticleTVA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAddArticlePourcent)
                        .addGap(57, 57, 57))))
            .addComponent(jLabelAddArticlePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelAddArticleTabLayout.setVerticalGroup(
            jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddArticleTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAddArticlePrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAddArticleGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddArticleGroupe))
                .addGap(18, 18, 18)
                .addGroup(jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddArticleDate)
                    .addComponent(jSpinnerAddArticleJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerAddArticleAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerAddArticleMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddArticleSlash1)
                    .addComponent(jLabelAddArticleSlash2))
                .addGap(18, 18, 18)
                .addGroup(jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddArticleDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddArticleDesignation))
                .addGap(18, 18, 18)
                .addGroup(jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxAddArticleUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAddArticleUnite))
                    .addComponent(jButtonAddArticleRemoveUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAddArticleAddUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddArticleAddUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddArticleQT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddArticleQT))
                .addGap(18, 18, 18)
                .addGroup(jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddArticlePU, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddArticlePU)
                    .addComponent(jLabelAddArticleDA))
                .addGap(18, 18, 18)
                .addGroup(jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddArticleTVA, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddArticleTVA)
                    .addComponent(jLabelAddArticlePourcent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAddArticleTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddArticleConfirmer)
                    .addComponent(jButtonAddArticleAnnuler))
                .addContainerGap())
        );

        jTabbedPaneAddArticle.addTab("Simple Article", jPanelAddArticleTab);

        javax.swing.GroupLayout jDialogAddArticleLayout = new javax.swing.GroupLayout(jDialogAddArticle.getContentPane());
        jDialogAddArticle.getContentPane().setLayout(jDialogAddArticleLayout);
        jDialogAddArticleLayout.setHorizontalGroup(
            jDialogAddArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneAddArticle)
        );
        jDialogAddArticleLayout.setVerticalGroup(
            jDialogAddArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddArticleLayout.createSequentialGroup()
                .addComponent(jTabbedPaneAddArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        jDialogCoordonnee.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogCoordonnee.setLocation(centerX - 540/2, centerY - 365/2);
        jDialogCoordonnee.setModal(true);
        jDialogCoordonnee.setResizable(false);
        jDialogCoordonnee.setSize(new java.awt.Dimension(540, 365));

        jLabelCoordonneePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelCoordonneePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCoordonneePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Crd.png"))); // NOI18N
        jLabelCoordonneePrincipal.setText("Coordonnée");
        jLabelCoordonneePrincipal.setIconTextGap(10);

        jLabelCoordonneeCevilite.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCoordonneeCevilite.setText("Cévilité");

        jLabelCoordonneeDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCoordonneeDesignation.setText("Raison sociale");

        jLabelCoordonneeAdresse.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCoordonneeAdresse.setText("Adresse");

        jLabelCoordonneeTel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCoordonneeTel.setText("N° Tel");

        jLabelCoordonneeRC.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCoordonneeRC.setText("N° RC");

        jLabelCoordonneeArt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCoordonneeArt.setText("N° Article");

        jLabelCoordonneeNIF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCoordonneeNIF.setText("NIF");

        jLabelCoordonneeNIS.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCoordonneeNIS.setText("NIS");

        jLabelCoordonneeCptBanque.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCoordonneeCptBanque.setText("Compte bancaire");

        jLabelCoordonneeFonction.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCoordonneeFonction.setText("Fonction");

        jTextFieldCoordonneeDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldCoordonneeCevilite.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldCoordonneeAdresse.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldCoordonneeTel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldCoordonneeRC.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldCoordonneeArt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldCoordonneeNIS.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldCoordonneeNIF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldCoordonneeCptBanque.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldCoordonneeFonction.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jButtonCoordonneConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonCoordonneConfirmer.setText("Confirmer");
        jButtonCoordonneConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCoordonneConfirmerActionPerformed(evt);
            }
        });

        jButtonCoordonneAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonCoordonneAnnuler.setText("Annuler");
        jButtonCoordonneAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCoordonneAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogCoordonneeLayout = new javax.swing.GroupLayout(jDialogCoordonnee.getContentPane());
        jDialogCoordonnee.getContentPane().setLayout(jDialogCoordonneeLayout);
        jDialogCoordonneeLayout.setHorizontalGroup(
            jDialogCoordonneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCoordonneePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialogCoordonneeLayout.createSequentialGroup()
                .addGroup(jDialogCoordonneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogCoordonneeLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jDialogCoordonneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCoordonneeDesignation)
                            .addComponent(jLabelCoordonneeAdresse)
                            .addComponent(jLabelCoordonneeRC)
                            .addComponent(jLabelCoordonneeNIF)
                            .addComponent(jLabelCoordonneeFonction))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDialogCoordonneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogCoordonneeLayout.createSequentialGroup()
                                .addComponent(jTextFieldCoordonneeFonction, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jLabelCoordonneeCptBanque)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCoordonneeCptBanque, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialogCoordonneeLayout.createSequentialGroup()
                                .addComponent(jTextFieldCoordonneeNIF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCoordonneeNIS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCoordonneeNIS, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialogCoordonneeLayout.createSequentialGroup()
                                .addComponent(jTextFieldCoordonneeRC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCoordonneeArt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCoordonneeArt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialogCoordonneeLayout.createSequentialGroup()
                                .addComponent(jTextFieldCoordonneeAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCoordonneeTel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCoordonneeTel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialogCoordonneeLayout.createSequentialGroup()
                                .addComponent(jTextFieldCoordonneeDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCoordonneeCevilite)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCoordonneeCevilite, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogCoordonneeLayout.createSequentialGroup()
                        .addContainerGap(358, Short.MAX_VALUE)
                        .addComponent(jButtonCoordonneAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCoordonneConfirmer)))
                .addContainerGap())
        );
        jDialogCoordonneeLayout.setVerticalGroup(
            jDialogCoordonneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCoordonneeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCoordonneePrincipal)
                .addGap(18, 18, 18)
                .addGroup(jDialogCoordonneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCoordonneeDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCoordonneeCevilite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCoordonneeDesignation)
                    .addComponent(jLabelCoordonneeCevilite))
                .addGap(18, 18, 18)
                .addGroup(jDialogCoordonneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCoordonneeAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCoordonneeTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCoordonneeAdresse)
                    .addComponent(jLabelCoordonneeTel))
                .addGap(18, 18, 18)
                .addGroup(jDialogCoordonneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCoordonneeRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCoordonneeArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCoordonneeRC)
                    .addComponent(jLabelCoordonneeArt))
                .addGap(18, 18, 18)
                .addGroup(jDialogCoordonneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCoordonneeNIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCoordonneeNIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCoordonneeNIF)
                    .addComponent(jLabelCoordonneeNIS))
                .addGap(18, 18, 18)
                .addGroup(jDialogCoordonneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCoordonneeCptBanque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCoordonneeFonction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCoordonneeCptBanque)
                    .addComponent(jLabelCoordonneeFonction))
                .addGap(31, 31, 31)
                .addGroup(jDialogCoordonneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCoordonneConfirmer)
                    .addComponent(jButtonCoordonneAnnuler))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jDialogResultatBon.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogResultatBon.setAlwaysOnTop(true);
        jDialogResultatBon.setLocation(centerX - 309/2, centerY - 360/2);
        jDialogResultatBon.setResizable(false);
        jDialogResultatBon.setSize(new java.awt.Dimension(309, 360));
        jDialogResultatBon.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialogResultatBonWindowClosed(evt);
            }
        });

        jLabelResultatBonPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelResultatBonPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResultatBonPrincipal.setText("Résultat");

        jLabelResultatBonNbArticle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatBonNbArticle.setText("Nombre de bon trouvé");

        jLabelResultatBonPrixHT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatBonPrixHT.setText("Montant total HT");

        jLabelResultatBonPrixTTC.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatBonPrixTTC.setText("Montant total TTC");

        jTextFieldResultatBonNbArticle.setEditable(false);
        jTextFieldResultatBonNbArticle.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatBonNbArticle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatBonNbArticle.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatBonNbArticle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldResultatBonPrixHT.setEditable(false);
        jTextFieldResultatBonPrixHT.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatBonPrixHT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatBonPrixHT.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatBonPrixHT.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldResultatBonPrixTTC.setEditable(false);
        jTextFieldResultatBonPrixTTC.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatBonPrixTTC.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatBonPrixTTC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatBonPrixTTC.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jButtonResultatBonOk.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonResultatBonOk.setText("OK");
        jButtonResultatBonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResultatBonOkActionPerformed(evt);
            }
        });

        jLabelResultatBonDateDu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatBonDateDu.setText("Du");

        jTextFieldResultatBonDateDu.setEditable(false);
        jTextFieldResultatBonDateDu.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatBonDateDu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatBonDateDu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldResultatBonDateDu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldResultatBonDateAu.setEditable(false);
        jTextFieldResultatBonDateAu.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatBonDateAu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatBonDateAu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldResultatBonDateAu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelResultatBonDateAu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatBonDateAu.setText("Au");

        jTextFieldResultatBonPrixTVA.setEditable(false);
        jTextFieldResultatBonPrixTVA.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatBonPrixTVA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatBonPrixTVA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatBonPrixTVA.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelResultatBonPrixTVA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatBonPrixTVA.setText("Montant total TVA");

        javax.swing.GroupLayout jDialogResultatBonLayout = new javax.swing.GroupLayout(jDialogResultatBon.getContentPane());
        jDialogResultatBon.getContentPane().setLayout(jDialogResultatBonLayout);
        jDialogResultatBonLayout.setHorizontalGroup(
            jDialogResultatBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelResultatBonPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialogResultatBonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogResultatBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatBonLayout.createSequentialGroup()
                        .addGroup(jDialogResultatBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatBonLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelResultatBonDateDu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldResultatBonDateDu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialogResultatBonLayout.createSequentialGroup()
                                .addGroup(jDialogResultatBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelResultatBonPrixHT)
                                    .addComponent(jLabelResultatBonPrixTTC)
                                    .addComponent(jLabelResultatBonNbArticle))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogResultatBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldResultatBonNbArticle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldResultatBonPrixHT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldResultatBonPrixTTC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatBonLayout.createSequentialGroup()
                                .addComponent(jLabelResultatBonDateAu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldResultatBonDateAu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatBonLayout.createSequentialGroup()
                        .addComponent(jLabelResultatBonPrixTVA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldResultatBonPrixTVA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatBonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonResultatBonOk)))
                .addContainerGap())
        );
        jDialogResultatBonLayout.setVerticalGroup(
            jDialogResultatBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogResultatBonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelResultatBonPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogResultatBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatBonDateDu)
                    .addComponent(jTextFieldResultatBonDateDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldResultatBonDateAu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelResultatBonDateAu))
                .addGap(18, 18, 18)
                .addGroup(jDialogResultatBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatBonNbArticle)
                    .addComponent(jTextFieldResultatBonNbArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogResultatBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatBonPrixHT)
                    .addComponent(jTextFieldResultatBonPrixHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogResultatBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatBonPrixTTC)
                    .addComponent(jTextFieldResultatBonPrixTTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogResultatBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatBonPrixTVA)
                    .addComponent(jTextFieldResultatBonPrixTVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonResultatBonOk)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jDialogRapportBon.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogRapportBon.setLocation(centerX - 400/2, centerY - 320/2);
        jDialogRapportBon.setModal(true);
        jDialogRapportBon.setResizable(false);
        jDialogRapportBon.setSize(new java.awt.Dimension(400, 320));

        jLabelRapportBonPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelRapportBonPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRapportBonPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Search.png"))); // NOI18N
        jLabelRapportBonPrincipal.setText("Recherche");

        jLabelRapportBonDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportBonDesignation.setText("Désignation spécifique");

        jLabelRapportBonDateDu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportBonDateDu.setText("Du");

        jLabelRapportBonDateAu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportBonDateAu.setText("Au");

        jSpinnerRapportBonDateDuJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportBonDateDuJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jLabelRapportBonSlash1.setText("/");

        jLabelRapportBonSlash2.setText("/");

        jLabelRapportBonSlash3.setText("/");

        jLabelRapportBonSlash4.setText("/");

        jTextFieldRapportBonDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jButtonRapportBonConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRapportBonConfirmer.setText("Confirmer");
        jButtonRapportBonConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRapportBonConfirmerActionPerformed(evt);
            }
        });

        jButtonRapportBonAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRapportBonAnnuler.setText("Annuler");
        jButtonRapportBonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRapportBonAnnulerActionPerformed(evt);
            }
        });

        jSpinnerRapportBonDateAuJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportBonDateAuJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jSpinnerRapportBonDateAuMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportBonDateAuMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jSpinnerRapportBonDateAuAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportBonDateAuAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerRapportBonDateAuAnnee.setMinimumSize(new java.awt.Dimension(45, 22));
        jSpinnerRapportBonDateAuAnnee.setPreferredSize(new java.awt.Dimension(45, 22));

        jCheckBoxRapportBonDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBoxRapportBonDate.setText("Filtrer par date");
        jCheckBoxRapportBonDate.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                jCheckBoxRapportBonDateChangeState(e.getStateChange() == ItemEvent.SELECTED);
            }
        });

        jComboBoxRapportBonPersonne.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelRapportBonPersonne.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportBonPersonne.setText("XXXXXXXXX spécifique");

        jSpinnerRapportBonDateDuMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportBonDateDuMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jSpinnerRapportBonDateDuAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportBonDateDuAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerRapportBonDateDuAnnee.setMinimumSize(new java.awt.Dimension(45, 22));
        jSpinnerRapportBonDateDuAnnee.setPreferredSize(new java.awt.Dimension(45, 22));

        javax.swing.GroupLayout jDialogRapportBonLayout = new javax.swing.GroupLayout(jDialogRapportBon.getContentPane());
        jDialogRapportBon.getContentPane().setLayout(jDialogRapportBonLayout);
        jDialogRapportBonLayout.setHorizontalGroup(
            jDialogRapportBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelRapportBonPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialogRapportBonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogRapportBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportBonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonRapportBonAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRapportBonConfirmer))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportBonLayout.createSequentialGroup()
                        .addGroup(jDialogRapportBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRapportBonDesignation)
                            .addComponent(jLabelRapportBonPersonne)
                            .addComponent(jCheckBoxRapportBonDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jDialogRapportBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxRapportBonPersonne, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldRapportBonDesignation))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportBonLayout.createSequentialGroup()
                                .addComponent(jLabelRapportBonDateDu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportBonDateDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRapportBonSlash1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportBonDateDuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRapportBonSlash2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportBonDateDuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportBonLayout.createSequentialGroup()
                                .addComponent(jLabelRapportBonDateAu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportBonDateAuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRapportBonSlash3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportBonDateAuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRapportBonSlash4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportBonDateAuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jDialogRapportBonLayout.setVerticalGroup(
            jDialogRapportBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogRapportBonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRapportBonPrincipal)
                .addGap(18, 18, 18)
                .addGroup(jDialogRapportBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRapportBonPersonne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRapportBonPersonne))
                .addGap(18, 18, 18)
                .addGroup(jDialogRapportBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRapportBonDesignation)
                    .addComponent(jTextFieldRapportBonDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDialogRapportBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogRapportBonLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jDialogRapportBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerRapportBonDateDuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportBonSlash2)
                            .addComponent(jSpinnerRapportBonDateDuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportBonSlash1)
                            .addComponent(jSpinnerRapportBonDateDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportBonDateDu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDialogRapportBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerRapportBonDateAuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportBonSlash4)
                            .addComponent(jSpinnerRapportBonDateAuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportBonSlash3)
                            .addComponent(jSpinnerRapportBonDateAuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportBonDateAu)))
                    .addGroup(jDialogRapportBonLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jCheckBoxRapportBonDate)))
                .addGap(18, 18, 18)
                .addGroup(jDialogRapportBonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRapportBonConfirmer)
                    .addComponent(jButtonRapportBonAnnuler))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jDialogResultatArticle.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogResultatArticle.setAlwaysOnTop(true);
        jDialogResultatArticle.setLocation(centerX - 314/2, centerY - 315/2);
        jDialogResultatArticle.setResizable(false);
        jDialogResultatArticle.setSize(new java.awt.Dimension(314, 315));
        jDialogResultatArticle.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialogResultatArticleWindowClosed(evt);
            }
        });

        jLabelResultatArticlePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelResultatArticlePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResultatArticlePrincipal.setText("Résultat");

        jLabelResultatArticleNbArticle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatArticleNbArticle.setText("Nombre d'article trouvé");

        jLabelResultatArticlePrixHT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatArticlePrixHT.setText("Montant total HT");

        jLabelResultatArticlePrixTTC.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatArticlePrixTTC.setText("Montant total TTC");

        jTextFieldResultatArticleNbArticle.setEditable(false);
        jTextFieldResultatArticleNbArticle.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatArticleNbArticle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatArticleNbArticle.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatArticleNbArticle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldResultatArticlePrixHT.setEditable(false);
        jTextFieldResultatArticlePrixHT.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatArticlePrixHT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatArticlePrixHT.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatArticlePrixHT.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldResultatArticlePrixTTC.setEditable(false);
        jTextFieldResultatArticlePrixTTC.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatArticlePrixTTC.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatArticlePrixTTC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatArticlePrixTTC.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jButtonResultatArticleOk.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonResultatArticleOk.setText("OK");
        jButtonResultatArticleOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResultatArticleOkActionPerformed(evt);
            }
        });

        jLabelResultatArticleDateDu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatArticleDateDu.setText("Du");

        jTextFieldResultatArticleDateDu.setEditable(false);
        jTextFieldResultatArticleDateDu.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatArticleDateDu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatArticleDateDu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldResultatArticleDateDu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldResultatArticleDateAu.setEditable(false);
        jTextFieldResultatArticleDateAu.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatArticleDateAu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatArticleDateAu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldResultatArticleDateAu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelResultatArticleDateAu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatArticleDateAu.setText("Au");

        jTextFieldResultatArticlePrixTVA.setEditable(false);
        jTextFieldResultatArticlePrixTVA.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatArticlePrixTVA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatArticlePrixTVA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatArticlePrixTVA.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelResultatArticlePrixTVA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatArticlePrixTVA.setText("Montant total TVA");

        javax.swing.GroupLayout jDialogResultatArticleLayout = new javax.swing.GroupLayout(jDialogResultatArticle.getContentPane());
        jDialogResultatArticle.getContentPane().setLayout(jDialogResultatArticleLayout);
        jDialogResultatArticleLayout.setHorizontalGroup(
            jDialogResultatArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelResultatArticlePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialogResultatArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogResultatArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogResultatArticleLayout.createSequentialGroup()
                        .addGroup(jDialogResultatArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatArticleLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelResultatArticleDateDu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldResultatArticleDateDu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialogResultatArticleLayout.createSequentialGroup()
                                .addGroup(jDialogResultatArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelResultatArticlePrixHT)
                                    .addComponent(jLabelResultatArticlePrixTTC)
                                    .addComponent(jLabelResultatArticleNbArticle))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogResultatArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldResultatArticleNbArticle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldResultatArticlePrixHT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldResultatArticlePrixTTC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatArticleLayout.createSequentialGroup()
                                .addComponent(jLabelResultatArticleDateAu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldResultatArticleDateAu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatArticleLayout.createSequentialGroup()
                        .addComponent(jLabelResultatArticlePrixTVA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldResultatArticlePrixTVA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatArticleLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonResultatArticleOk)))
                .addContainerGap())
        );
        jDialogResultatArticleLayout.setVerticalGroup(
            jDialogResultatArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogResultatArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelResultatArticlePrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogResultatArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatArticleDateDu)
                    .addComponent(jTextFieldResultatArticleDateDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldResultatArticleDateAu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelResultatArticleDateAu))
                .addGap(18, 18, 18)
                .addGroup(jDialogResultatArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatArticleNbArticle)
                    .addComponent(jTextFieldResultatArticleNbArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogResultatArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatArticlePrixHT)
                    .addComponent(jTextFieldResultatArticlePrixHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogResultatArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatArticlePrixTTC)
                    .addComponent(jTextFieldResultatArticlePrixTTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogResultatArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatArticlePrixTVA)
                    .addComponent(jTextFieldResultatArticlePrixTVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonResultatArticleOk)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jDialogResultatPersonne.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogResultatPersonne.setAlwaysOnTop(true);
        jDialogResultatPersonne.setLocation(centerX - 318/2, centerY - 245/2);
        jDialogResultatPersonne.setResizable(false);
        jDialogResultatPersonne.setSize(new java.awt.Dimension(318, 245));
        jDialogResultatPersonne.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialogResultatPersonneWindowClosed(evt);
            }
        });

        jLabelResultatPersonnePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelResultatPersonnePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResultatPersonnePrincipal.setText("Résultat");

        jLabelResultatPersonneNbArticle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatPersonneNbArticle.setText("Nombre d'entité trouvéé");

        jLabelResultatPersonneCA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatPersonneCA.setText("Chiffre d'affaire total");

        jLabelResultatPersonneRAR.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatPersonneRAR.setText("Montant restant à régler");

        jTextFieldResultatPersonneNbArticle.setEditable(false);
        jTextFieldResultatPersonneNbArticle.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatPersonneNbArticle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatPersonneNbArticle.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatPersonneNbArticle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldResultatPersonneCA.setEditable(false);
        jTextFieldResultatPersonneCA.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatPersonneCA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatPersonneCA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatPersonneCA.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldResultatPersonneRAR.setEditable(false);
        jTextFieldResultatPersonneRAR.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatPersonneRAR.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatPersonneRAR.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatPersonneRAR.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jButtonResultatPersonneOk.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonResultatPersonneOk.setText("OK");
        jButtonResultatPersonneOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResultatPersonneOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogResultatPersonneLayout = new javax.swing.GroupLayout(jDialogResultatPersonne.getContentPane());
        jDialogResultatPersonne.getContentPane().setLayout(jDialogResultatPersonneLayout);
        jDialogResultatPersonneLayout.setHorizontalGroup(
            jDialogResultatPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogResultatPersonneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogResultatPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogResultatPersonneLayout.createSequentialGroup()
                        .addComponent(jLabelResultatPersonneRAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldResultatPersonneRAR, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatPersonneLayout.createSequentialGroup()
                        .addGroup(jDialogResultatPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelResultatPersonneCA)
                            .addComponent(jLabelResultatPersonneNbArticle))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jDialogResultatPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldResultatPersonneNbArticle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldResultatPersonneCA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatPersonneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonResultatPersonneOk)))
                .addContainerGap())
            .addComponent(jLabelResultatPersonnePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogResultatPersonneLayout.setVerticalGroup(
            jDialogResultatPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogResultatPersonneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelResultatPersonnePrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogResultatPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatPersonneNbArticle)
                    .addComponent(jTextFieldResultatPersonneNbArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogResultatPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatPersonneCA)
                    .addComponent(jTextFieldResultatPersonneCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogResultatPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatPersonneRAR)
                    .addComponent(jTextFieldResultatPersonneRAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonResultatPersonneOk)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jDialogRapportArticle.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogRapportArticle.setLocation(centerX - 380/2, centerY - 315/2);
        jDialogRapportArticle.setModal(true);
        jDialogRapportArticle.setResizable(false);
        jDialogRapportArticle.setSize(new java.awt.Dimension(380, 315));
        jCheckBoxRapportArticleDate.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                jCheckBoxRapportArticleDateChangeState(e.getStateChange() == ItemEvent.SELECTED);
            }
        });

        jLabelRapportArticlePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelRapportArticlePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRapportArticlePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Search.png"))); // NOI18N
        jLabelRapportArticlePrincipal.setText("Recherche");

        jLabelRapportArticleDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportArticleDesignation.setText("Désignation spécifique");

        jTextFieldRapportArticleDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jButtonRapportArticleConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRapportArticleConfirmer.setText("Confirmer");
        jButtonRapportArticleConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRapportArticleConfirmerActionPerformed(evt);
            }
        });

        jButtonRapportArticleAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRapportArticleAnnuler.setText("Annuler");
        jButtonRapportArticleAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRapportArticleAnnulerActionPerformed(evt);
            }
        });

        jLabelRapportArticleQt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportArticleQt.setText("Quantité en stock");

        jCheckBoxRapportArticleQt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBoxRapportArticleQt.setText("Afficher quantité nulle/négative");

        jCheckBoxRapportArticleDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBoxRapportArticleDate.setText("Filtrer par date");
        jCheckBoxRapportBonDate.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                jCheckBoxRapportArticleDateChangeState(e.getStateChange() == ItemEvent.SELECTED);
            }
        });

        jSpinnerRapportArticleDateAuMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportArticleDateAuMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabelRapportArticleSlash1.setText("/");

        jSpinnerRapportArticleDateAuAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportArticleDateAuAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerRapportArticleDateAuAnnee.setMinimumSize(new java.awt.Dimension(45, 22));
        jSpinnerRapportArticleDateAuAnnee.setPreferredSize(new java.awt.Dimension(45, 22));

        jLabelRapportArticleSlash2.setText("/");

        jLabelRapportArticleSlash3.setText("/");

        jLabelRapportArticleSlash4.setText("/");

        jLabelRapportArticleDateDu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportArticleDateDu.setText("Du");

        jLabelRapportArticleDateAu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportArticleDateAu.setText("Au");

        jSpinnerRapportArticleDateDuAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportArticleDateDuAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerRapportArticleDateDuAnnee.setMinimumSize(new java.awt.Dimension(45, 22));
        jSpinnerRapportArticleDateDuAnnee.setPreferredSize(new java.awt.Dimension(45, 22));

        jSpinnerRapportArticleDateAuJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportArticleDateAuJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jSpinnerRapportArticleDateDuJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportArticleDateDuJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jSpinnerRapportArticleDateDuMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportArticleDateDuMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        javax.swing.GroupLayout jDialogRapportArticleLayout = new javax.swing.GroupLayout(jDialogRapportArticle.getContentPane());
        jDialogRapportArticle.getContentPane().setLayout(jDialogRapportArticleLayout);
        jDialogRapportArticleLayout.setHorizontalGroup(
            jDialogRapportArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelRapportArticlePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialogRapportArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogRapportArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportArticleLayout.createSequentialGroup()
                        .addComponent(jLabelRapportArticleDesignation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jTextFieldRapportArticleDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportArticleLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonRapportArticleAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRapportArticleConfirmer))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportArticleLayout.createSequentialGroup()
                        .addGroup(jDialogRapportArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxRapportArticleDate)
                            .addComponent(jLabelRapportArticleQt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialogRapportArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxRapportArticleQt)
                            .addGroup(jDialogRapportArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportArticleLayout.createSequentialGroup()
                                    .addComponent(jLabelRapportArticleDateDu)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinnerRapportArticleDateDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelRapportArticleSlash1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinnerRapportArticleDateDuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelRapportArticleSlash2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinnerRapportArticleDateDuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportArticleLayout.createSequentialGroup()
                                    .addComponent(jLabelRapportArticleDateAu)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinnerRapportArticleDateAuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelRapportArticleSlash3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinnerRapportArticleDateAuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelRapportArticleSlash4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinnerRapportArticleDateAuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jDialogRapportArticleLayout.setVerticalGroup(
            jDialogRapportArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogRapportArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRapportArticlePrincipal)
                .addGap(15, 15, 15)
                .addGroup(jDialogRapportArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRapportArticleDesignation)
                    .addComponent(jTextFieldRapportArticleDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDialogRapportArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogRapportArticleLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jCheckBoxRapportArticleDate))
                    .addGroup(jDialogRapportArticleLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jDialogRapportArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerRapportArticleDateDuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportArticleSlash2)
                            .addComponent(jSpinnerRapportArticleDateDuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportArticleSlash1)
                            .addComponent(jSpinnerRapportArticleDateDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportArticleDateDu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDialogRapportArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerRapportArticleDateAuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportArticleSlash4)
                            .addComponent(jSpinnerRapportArticleDateAuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportArticleSlash3)
                            .addComponent(jSpinnerRapportArticleDateAuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportArticleDateAu))))
                .addGap(18, 18, 18)
                .addGroup(jDialogRapportArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxRapportArticleQt)
                    .addComponent(jLabelRapportArticleQt))
                .addGap(18, 18, 18)
                .addGroup(jDialogRapportArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRapportArticleConfirmer)
                    .addComponent(jButtonRapportArticleAnnuler))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jDialogRapportPersonne.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogRapportPersonne.setLocation(centerX - 380/2, centerY - 230/2);
        jDialogRapportPersonne.setModal(true);
        jDialogRapportPersonne.setResizable(false);
        jDialogRapportPersonne.setSize(new java.awt.Dimension(380, 230));

        jLabelRapportPersonnePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelRapportPersonnePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRapportPersonnePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Search.png"))); // NOI18N
        jLabelRapportPersonnePrincipal.setText("Recherche");

        jLabelRapportPersonneDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportPersonneDesignation.setText("Désignation spécifique");

        jLabelRapportPersonneRAR.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportPersonneRAR.setText("Dette/Créance");

        jTextFieldRapportPersonneDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jButtonRapportPersonneConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRapportPersonneConfirmer.setText("Confirmer");
        jButtonRapportPersonneConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRapportPersonneConfirmerActionPerformed(evt);
            }
        });

        jButtonRapportPersonneAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRapportPersonneAnnuler.setText("Annuler");
        jButtonRapportPersonneAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRapportPersonneAnnulerActionPerformed(evt);
            }
        });

        jCheckBoxRapportPersonneRAR.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBoxRapportPersonneRAR.setText("Afficher dette/créance seulement");

        javax.swing.GroupLayout jDialogRapportPersonneLayout = new javax.swing.GroupLayout(jDialogRapportPersonne.getContentPane());
        jDialogRapportPersonne.getContentPane().setLayout(jDialogRapportPersonneLayout);
        jDialogRapportPersonneLayout.setHorizontalGroup(
            jDialogRapportPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogRapportPersonneLayout.createSequentialGroup()
                .addGroup(jDialogRapportPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportPersonneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonRapportPersonneAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRapportPersonneConfirmer))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportPersonneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDialogRapportPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRapportPersonneDesignation)
                            .addComponent(jLabelRapportPersonneRAR))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jDialogRapportPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxRapportPersonneRAR)
                            .addComponent(jTextFieldRapportPersonneDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(jLabelRapportPersonnePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogRapportPersonneLayout.setVerticalGroup(
            jDialogRapportPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogRapportPersonneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRapportPersonnePrincipal)
                .addGap(15, 15, 15)
                .addGroup(jDialogRapportPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRapportPersonneDesignation)
                    .addComponent(jTextFieldRapportPersonneDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogRapportPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxRapportPersonneRAR)
                    .addComponent(jLabelRapportPersonneRAR))
                .addGap(18, 18, 18)
                .addGroup(jDialogRapportPersonneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRapportPersonneConfirmer)
                    .addComponent(jButtonRapportPersonneAnnuler))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jDialogImprimer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogImprimer.setLocation(centerX - 220/2, centerY - 155/2);
        jDialogImprimer.setModal(true);
        jDialogImprimer.setResizable(false);
        jDialogImprimer.setSize(new java.awt.Dimension(220, 155));

        jLabelImprimerPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelImprimerPrincipal.setText("Modèle d'impression :");

        jComboBoxImprimerModele.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxImprimerModele.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bon de livraison", "Facture", "Bon de commande" }));

        jButtonImprimerConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonImprimerConfirmer.setText("Imprimer");
        jButtonImprimerConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimerConfirmerActionPerformed(evt);
            }
        });

        jButtonImprimerAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonImprimerAnnuler.setText("Annuler");
        jButtonImprimerAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimerAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogImprimerLayout = new javax.swing.GroupLayout(jDialogImprimer.getContentPane());
        jDialogImprimer.getContentPane().setLayout(jDialogImprimerLayout);
        jDialogImprimerLayout.setHorizontalGroup(
            jDialogImprimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogImprimerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogImprimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jDialogImprimerLayout.createSequentialGroup()
                        .addComponent(jButtonImprimerAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonImprimerConfirmer))
                    .addGroup(jDialogImprimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelImprimerPrincipal)
                        .addComponent(jComboBoxImprimerModele, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogImprimerLayout.setVerticalGroup(
            jDialogImprimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogImprimerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImprimerPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxImprimerModele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogImprimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImprimerConfirmer)
                    .addComponent(jButtonImprimerAnnuler))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jDialogAddConso.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogAddConso.setLocation(centerX - 450/2, centerY - 440/2);
        jDialogAddConso.setModal(true);
        jDialogAddConso.setResizable(false);
        jDialogAddConso.setSize(new java.awt.Dimension(450, 440));

        jTextFieldAddGroupeConsoDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddGroupeConsoDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddGroupeConsoDesignation.setText("Nom du groupe");

        jButtonAddGroupeConsoConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddGroupeConsoConfirmer.setText("Confirmer");
        jButtonAddGroupeConsoConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddGroupeConsoConfirmerActionPerformed(evt);
            }
        });

        jButtonAddGroupeConsoAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddGroupeConsoAnnuler.setText("Annuler");
        jButtonAddGroupeConsoAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddGroupeConsoAnnulerActionPerformed(evt);
            }
        });

        jLabelAddGroupeConsoPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelAddGroupeConsoPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddGroupeConsoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/groupe.png"))); // NOI18N
        jLabelAddGroupeConsoPrincipal.setText("Ajout Groupe");
        jLabelAddGroupeConsoPrincipal.setIconTextGap(20);

        javax.swing.GroupLayout jPanelAddGroupeConsoTabLayout = new javax.swing.GroupLayout(jPanelAddGroupeConsoTab);
        jPanelAddGroupeConsoTab.setLayout(jPanelAddGroupeConsoTabLayout);
        jPanelAddGroupeConsoTabLayout.setHorizontalGroup(
            jPanelAddGroupeConsoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddGroupeConsoTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddGroupeConsoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddGroupeConsoTabLayout.createSequentialGroup()
                        .addGap(0, 257, Short.MAX_VALUE)
                        .addComponent(jButtonAddGroupeConsoAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddGroupeConsoConfirmer))
                    .addGroup(jPanelAddGroupeConsoTabLayout.createSequentialGroup()
                        .addComponent(jLabelAddGroupeConsoDesignation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAddGroupeConsoDesignation)))
                .addContainerGap())
            .addComponent(jLabelAddGroupeConsoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelAddGroupeConsoTabLayout.setVerticalGroup(
            jPanelAddGroupeConsoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddGroupeConsoTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAddGroupeConsoPrincipal)
                .addGap(26, 26, 26)
                .addGroup(jPanelAddGroupeConsoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddGroupeConsoDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddGroupeConsoDesignation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                .addGroup(jPanelAddGroupeConsoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddGroupeConsoConfirmer)
                    .addComponent(jButtonAddGroupeConsoAnnuler))
                .addContainerGap())
        );

        jTabbedPaneAddConso.addTab("Groupe Article", jPanelAddGroupeConsoTab);

        jLabelAddConsoPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelAddConsoPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddConsoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Conso.png"))); // NOI18N
        jLabelAddConsoPrincipal.setText("Nouvelle consommation");
        jLabelAddConsoPrincipal.setToolTipText("");
        jLabelAddConsoPrincipal.setIconTextGap(20);

        jComboBoxAddConsoGroupeArticle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxAddConsoGroupeArticle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxAddConsoGroupeArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAddConsoGroupeArticleActionPerformed(evt);
            }
        });

        jTableAddConsoArticle.getTableHeader().setFont(new Font("Segoe UI", 0, 12));
        jTableAddConsoArticle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTableAddConsoArticle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableAddConsoArticle.setRowHeight(25);
        jScrollPaneAddConsoArticle.setViewportView(jTableAddConsoArticle);

        jButtonAddConsoSuivant.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddConsoSuivant.setText("Suivant >");
        jButtonAddConsoSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddConsoSuivantActionPerformed(evt);
            }
        });

        jButtonAddConsoAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddConsoAnnuler.setText("Annuler");
        jButtonAddConsoAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddConsoAnnulerActionPerformed(evt);
            }
        });

        jCheckBoxAddConsoArticle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxAddConsoArticle.setText("Soustraire d'un article existant");
        jCheckBoxAddConsoArticle.setIconTextGap(10);
        jCheckBoxAddConsoArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAddConsoArticleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAddConsoTabLayout = new javax.swing.GroupLayout(jPanelAddConsoTab);
        jPanelAddConsoTab.setLayout(jPanelAddConsoTabLayout);
        jPanelAddConsoTabLayout.setHorizontalGroup(
            jPanelAddConsoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelAddConsoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddConsoTabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAddConsoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxAddConsoGroupeArticle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneAddConsoArticle, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddConsoTabLayout.createSequentialGroup()
                        .addComponent(jButtonAddConsoAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAddConsoSuivant)))
                .addContainerGap())
            .addGroup(jPanelAddConsoTabLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jCheckBoxAddConsoArticle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAddConsoTabLayout.setVerticalGroup(
            jPanelAddConsoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddConsoTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAddConsoPrincipal)
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxAddConsoArticle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxAddConsoGroupeArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneAddConsoArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelAddConsoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddConsoSuivant)
                    .addComponent(jButtonAddConsoAnnuler))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneAddConso.addTab("Simple Article", jPanelAddConsoTab);

        javax.swing.GroupLayout jDialogAddConsoLayout = new javax.swing.GroupLayout(jDialogAddConso.getContentPane());
        jDialogAddConso.getContentPane().setLayout(jDialogAddConsoLayout);
        jDialogAddConsoLayout.setHorizontalGroup(
            jDialogAddConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneAddConso)
        );
        jDialogAddConsoLayout.setVerticalGroup(
            jDialogAddConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddConsoLayout.createSequentialGroup()
                .addComponent(jTabbedPaneAddConso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );

        jDialogAddConso1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogAddConso1.setAlwaysOnTop(true);
        jDialogAddConso1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jDialogAddConso1.setLocation(centerX - 450/2, centerY - 535/2);
        jDialogAddConso1.setModal(true);
        jDialogAddConso1.setResizable(false);
        jDialogAddConso1.setSize(new java.awt.Dimension(450, 535));

        jTextFieldAddConsoQT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddConsoDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddConsoDesignation.setText("Désignation");

        jComboBoxAddConsoUnite.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxAddConsoUnite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAddConsoAnnuler1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddConsoAnnuler1.setText("Annuler");
        jButtonAddConsoAnnuler1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddConsoAnnuler1ActionPerformed(evt);
            }
        });

        jTextFieldAddConsoDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddConsoQT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddConsoQT.setText("Quantité");

        jButtonAddConsoRemoveUnite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Remove_Unite.png"))); // NOI18N
        jButtonAddConsoRemoveUnite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddConsoRemoveUniteActionPerformed(evt);
            }
        });

        jButtonAddConsoConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddConsoConfirmer.setText("Confirmer");
        jButtonAddConsoConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddConsoConfirmerActionPerformed(evt);
            }
        });

        jTextFieldAddConsoAddUnite.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddConsoPU.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddConsoPU.setText("Prix unitaire");

        jButtonAddConsoAddUnite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Add_Unite.png"))); // NOI18N
        jButtonAddConsoAddUnite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddConsoAddUniteActionPerformed(evt);
            }
        });

        jLabelAddConsoUnite.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddConsoUnite.setText("Unité");

        jLabelAddConsoDA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddConsoDA.setText(".00 DA");

        jLabelAddConsoGroupe.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddConsoGroupe.setText("Groupe");

        jLabelAddConsoPrincipal1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelAddConsoPrincipal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddConsoPrincipal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Conso.png"))); // NOI18N
        jLabelAddConsoPrincipal1.setText("Nouvelle consommation");
        jLabelAddConsoPrincipal1.setToolTipText("");
        jLabelAddConsoPrincipal1.setIconTextGap(20);

        jComboBoxAddConsoGroupe.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxAddConsoGroupe.setMaximumRowCount(20);
        jComboBoxAddConsoGroupe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextFieldAddConsoPU.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jCheckBoxAddConsoQtUT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBoxAddConsoQtUT.setText("Inclure quantité par unité");
        jCheckBoxAddConsoQtUT.setIconTextGap(10);
        jCheckBoxAddConsoQtUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAddConsoQtUTActionPerformed(evt);
            }
        });

        jComboBoxAddConsoQtUT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxAddConsoQtUT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Conversion Manuel", "M3 X 5", "M3 X 18", "M3½ X 6", "M3½ X 9", "2,9 X 12", "2,9 X 14", "2,9 X 19" }));
        jComboBoxAddConsoQtUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAddConsoQtUTActionPerformed(evt);
            }
        });

        jTextFieldAddConsoQtUT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldAddConsoQtUT.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelAddConsoDA1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddConsoDA1.setText(".00 DA");

        jLabelAddConsoPT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddConsoPT.setText("Prix total");

        jTextFieldAddConsoPT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jSpinnerAddConsoAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerAddConsoAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabelAddConsoSlash3.setText("/");

        jLabelAddConsoSlash4.setText("/");

        jLabelAddConsoDate1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddConsoDate1.setText("Date");

        jSpinnerAddConsoMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerAddConsoMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jSpinnerAddConsoJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerAddConsoJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        javax.swing.GroupLayout jDialogAddConso1Layout = new javax.swing.GroupLayout(jDialogAddConso1.getContentPane());
        jDialogAddConso1.getContentPane().setLayout(jDialogAddConso1Layout);
        jDialogAddConso1Layout.setHorizontalGroup(
            jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelAddConsoPrincipal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialogAddConso1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAddConso1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAddConsoAnnuler1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddConsoConfirmer)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAddConso1Layout.createSequentialGroup()
                        .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDialogAddConso1Layout.createSequentialGroup()
                                .addComponent(jLabelAddConsoDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerAddConsoJour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabelAddConsoSlash3)
                                .addGap(34, 34, 34)
                                .addComponent(jSpinnerAddConsoMois, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabelAddConsoSlash4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(jSpinnerAddConsoAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogAddConso1Layout.createSequentialGroup()
                                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAddConsoPU)
                                    .addComponent(jLabelAddConsoPT))
                                .addGap(12, 12, 12)
                                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldAddConsoPT, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAddConsoPU))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAddConsoDA)
                                    .addComponent(jLabelAddConsoDA1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogAddConso1Layout.createSequentialGroup()
                                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAddConsoGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelAddConsoDesignation)
                                    .addComponent(jLabelAddConsoUnite)
                                    .addComponent(jLabelAddConsoQT))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAddConsoQT)
                                    .addGroup(jDialogAddConso1Layout.createSequentialGroup()
                                        .addComponent(jComboBoxAddConsoUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAddConsoRemoveUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldAddConsoAddUnite)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAddConsoAddUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldAddConsoDesignation)
                                    .addComponent(jComboBoxAddConsoGroupe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogAddConso1Layout.createSequentialGroup()
                                .addComponent(jComboBoxAddConsoQtUT, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAddConsoQtUT)))
                        .addGap(33, 33, 33))))
            .addGroup(jDialogAddConso1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jCheckBoxAddConsoQtUT)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialogAddConso1Layout.setVerticalGroup(
            jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddConso1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAddConsoPrincipal1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAddConsoGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddConsoGroupe))
                .addGap(18, 18, 18)
                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddConsoDate1)
                    .addComponent(jSpinnerAddConsoJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerAddConsoAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerAddConsoMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddConsoSlash3)
                    .addComponent(jLabelAddConsoSlash4))
                .addGap(18, 18, 18)
                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddConsoDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddConsoDesignation))
                .addGap(18, 18, 18)
                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxAddConsoUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAddConsoUnite))
                    .addComponent(jButtonAddConsoRemoveUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAddConsoAddUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddConsoAddUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddConsoQT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddConsoQT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxAddConsoQtUT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddConsoQtUT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAddConsoQtUT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddConsoPU, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddConsoDA)
                    .addComponent(jLabelAddConsoPU))
                .addGap(18, 18, 18)
                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddConsoPT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddConsoDA1)
                    .addComponent(jLabelAddConsoPT))
                .addGap(29, 29, 29)
                .addGroup(jDialogAddConso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddConsoConfirmer)
                    .addComponent(jButtonAddConsoAnnuler1))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jDialogResultatConso.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogResultatConso.setAlwaysOnTop(true);
        jDialogResultatConso.setLocation(centerX - 318/2, centerY - 250/2);
        jDialogResultatConso.setResizable(false);
        jDialogResultatConso.setSize(new java.awt.Dimension(318, 250));
        jDialogResultatConso.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialogResultatConsoWindowClosed(evt);
            }
        });

        jLabelResultatConsoPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelResultatConsoPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResultatConsoPrincipal.setText("Résultat");

        jLabelResultatConsoNbArticle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatConsoNbArticle.setText("Nombre d'entité trouvée");

        jLabelResultatConsoPrix.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatConsoPrix.setText("Consommation totale");

        jTextFieldResultatConsoNbArticle.setEditable(false);
        jTextFieldResultatConsoNbArticle.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatConsoNbArticle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatConsoNbArticle.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatConsoNbArticle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldResultatConsoPrixHT.setEditable(false);
        jTextFieldResultatConsoPrixHT.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatConsoPrixHT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatConsoPrixHT.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatConsoPrixHT.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jButtonResultatConsoOk.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonResultatConsoOk.setText("OK");
        jButtonResultatConsoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResultatConsoOkActionPerformed(evt);
            }
        });

        jLabelResultatConsoDateDu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatConsoDateDu.setText("Du");

        jTextFieldResultatConsoDateDu.setEditable(false);
        jTextFieldResultatConsoDateDu.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatConsoDateDu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatConsoDateDu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldResultatConsoDateDu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldResultatConsoDateAu.setEditable(false);
        jTextFieldResultatConsoDateAu.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatConsoDateAu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatConsoDateAu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldResultatConsoDateAu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelResultatConsoDateAu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatConsoDateAu.setText("Au");

        javax.swing.GroupLayout jDialogResultatConsoLayout = new javax.swing.GroupLayout(jDialogResultatConso.getContentPane());
        jDialogResultatConso.getContentPane().setLayout(jDialogResultatConsoLayout);
        jDialogResultatConsoLayout.setHorizontalGroup(
            jDialogResultatConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogResultatConsoLayout.createSequentialGroup()
                .addGroup(jDialogResultatConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatConsoLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jButtonResultatConsoOk))
                    .addGroup(jDialogResultatConsoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDialogResultatConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatConsoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelResultatConsoDateDu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldResultatConsoDateDu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialogResultatConsoLayout.createSequentialGroup()
                                .addGroup(jDialogResultatConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelResultatConsoPrix)
                                    .addComponent(jLabelResultatConsoNbArticle))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogResultatConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldResultatConsoNbArticle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldResultatConsoPrixHT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatConsoLayout.createSequentialGroup()
                                .addComponent(jLabelResultatConsoDateAu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldResultatConsoDateAu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)))))
                .addContainerGap())
            .addComponent(jLabelResultatConsoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogResultatConsoLayout.setVerticalGroup(
            jDialogResultatConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogResultatConsoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelResultatConsoPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogResultatConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatConsoDateDu)
                    .addComponent(jTextFieldResultatConsoDateDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldResultatConsoDateAu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelResultatConsoDateAu))
                .addGap(18, 18, 18)
                .addGroup(jDialogResultatConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatConsoNbArticle)
                    .addComponent(jTextFieldResultatConsoNbArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogResultatConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatConsoPrix)
                    .addComponent(jTextFieldResultatConsoPrixHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonResultatConsoOk)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jDialogRapportConso.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogRapportConso.setLocation(centerX - 380/2, centerY - 265/2);
        jDialogRapportConso.setModal(true);
        jDialogRapportConso.setResizable(false);
        jDialogRapportConso.setSize(new java.awt.Dimension(380, 265));
        jCheckBoxRapportArticleDate.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                jCheckBoxRapportArticleDateChangeState(e.getStateChange() == ItemEvent.SELECTED);
            }
        });

        jLabelRapportConsoPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelRapportConsoPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRapportConsoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Search.png"))); // NOI18N
        jLabelRapportConsoPrincipal.setText("Recherche");

        jLabelRapportConsoDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportConsoDesignation.setText("Désignation spécifique");

        jLabelRapportConsoDateDu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportConsoDateDu.setText("Du");

        jLabelRapportConsoDateAu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportConsoDateAu.setText("Au");

        jSpinnerRapportConsoDateDuJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportConsoDateDuJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jLabelRapportConsoSlash1.setText("/");

        jLabelRapportConsoSlash2.setText("/");

        jLabelRapportConsoSlash3.setText("/");

        jLabelRapportConsoSlash4.setText("/");

        jTextFieldRapportConsoDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jButtonRapportConsoConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRapportConsoConfirmer.setText("Confirmer");
        jButtonRapportConsoConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRapportConsoConfirmerActionPerformed(evt);
            }
        });

        jButtonRapportConsoAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRapportConsoAnnuler.setText("Annuler");
        jButtonRapportConsoAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRapportConsoAnnulerActionPerformed(evt);
            }
        });

        jSpinnerRapportConsoDateAuJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportConsoDateAuJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jSpinnerRapportConsoDateAuMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportConsoDateAuMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jSpinnerRapportConsoDateAuAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportConsoDateAuAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerRapportConsoDateAuAnnee.setMinimumSize(new java.awt.Dimension(45, 22));
        jSpinnerRapportConsoDateAuAnnee.setPreferredSize(new java.awt.Dimension(45, 22));

        jCheckBoxRapportConsoDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBoxRapportConsoDate.setText("Filtrer par date");
        jCheckBoxRapportConsoDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRapportConsoDateActionPerformed(evt);
            }
        });

        jSpinnerRapportConsoDateDuMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportConsoDateDuMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jSpinnerRapportConsoDateDuAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportConsoDateDuAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerRapportConsoDateDuAnnee.setMinimumSize(new java.awt.Dimension(45, 22));
        jSpinnerRapportConsoDateDuAnnee.setPreferredSize(new java.awt.Dimension(45, 22));

        javax.swing.GroupLayout jDialogRapportConsoLayout = new javax.swing.GroupLayout(jDialogRapportConso.getContentPane());
        jDialogRapportConso.getContentPane().setLayout(jDialogRapportConsoLayout);
        jDialogRapportConsoLayout.setHorizontalGroup(
            jDialogRapportConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelRapportConsoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialogRapportConsoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogRapportConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportConsoLayout.createSequentialGroup()
                        .addComponent(jLabelRapportConsoDesignation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jTextFieldRapportConsoDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportConsoLayout.createSequentialGroup()
                        .addComponent(jCheckBoxRapportConsoDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialogRapportConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportConsoLayout.createSequentialGroup()
                                .addComponent(jLabelRapportConsoDateDu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportConsoDateDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRapportConsoSlash1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportConsoDateDuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRapportConsoSlash2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportConsoDateDuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportConsoLayout.createSequentialGroup()
                                .addComponent(jLabelRapportConsoDateAu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportConsoDateAuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRapportConsoSlash3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportConsoDateAuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRapportConsoSlash4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportConsoDateAuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportConsoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonRapportConsoAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRapportConsoConfirmer)))
                .addContainerGap())
        );
        jDialogRapportConsoLayout.setVerticalGroup(
            jDialogRapportConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogRapportConsoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRapportConsoPrincipal)
                .addGap(15, 15, 15)
                .addGroup(jDialogRapportConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRapportConsoDesignation)
                    .addComponent(jTextFieldRapportConsoDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDialogRapportConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogRapportConsoLayout.createSequentialGroup()
                        .addGroup(jDialogRapportConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerRapportConsoDateDuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportConsoSlash2)
                            .addComponent(jSpinnerRapportConsoDateDuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportConsoSlash1)
                            .addComponent(jSpinnerRapportConsoDateDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportConsoDateDu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDialogRapportConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerRapportConsoDateAuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportConsoSlash4)
                            .addComponent(jSpinnerRapportConsoDateAuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportConsoSlash3)
                            .addComponent(jSpinnerRapportConsoDateAuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportConsoDateAu)))
                    .addGroup(jDialogRapportConsoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jCheckBoxRapportConsoDate)))
                .addGap(18, 18, 18)
                .addGroup(jDialogRapportConsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRapportConsoConfirmer)
                    .addComponent(jButtonRapportConsoAnnuler))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jDialogRegle.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogRegle.setLocation(centerX-480/2,centerY-600/2);
        jDialogRegle.setModal(true);
        jDialogRegle.setResizable(false);
        jDialogRegle.setSize(new java.awt.Dimension(480, 600));

        jLabelRegleDesig.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRegleDesig.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelRegleDesig.setText("Objet");

        jLabelReglePersonne.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelReglePersonne.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelReglePersonne.setText("Tireur");

        jLabelRegleDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRegleDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelRegleDate.setText("Date");

        jLabelRegleMontant.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRegleMontant.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelRegleMontant.setText("Montant");

        jLabelRegleMode.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRegleMode.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelRegleMode.setText("Mode réglement");

        jLabelRegleCB.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRegleCB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelRegleCB.setText("Compte banquaire");

        jComboBoxRegleMode.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxRegleMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelReglePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelReglePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelReglePrincipal.setText("Nouvelle Recette");
        jLabelReglePrincipal.setToolTipText("");
        jLabelReglePrincipal.setIconTextGap(10);

        jTextFieldRegleDesig.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldRegleDesig.setToolTipText("");

        jComboBoxReglePersonne.setEditable(true);
        jComboBoxReglePersonne.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxReglePersonne.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jSpinnerRegleAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRegleAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jTextFieldRegleMontant.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldRegleModeAdd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jButtonRegleModeAdd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRegleModeAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Add_Unite.png"))); // NOI18N
        jButtonRegleModeAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegleModeAddActionPerformed(evt);
            }
        });

        jButtonRegleModeRemove.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRegleModeRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Remove_Unite.png"))); // NOI18N
        jButtonRegleModeRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegleModeRemoveActionPerformed(evt);
            }
        });

        jTableRegleCB.getTableHeader().setFont(new Font("Segoe UI", 0, 12));
        jTableRegleCB.setAutoCreateRowSorter(true);
        jTableRegleCB.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTableRegleCB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableRegleCB.setRowHeight(25);
        jTableRegleCB.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneRegleCB.setViewportView(jTableRegleCB);

        jButtonRegleConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRegleConfirmer.setText("Confirmer");
        jButtonRegleConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegleConfirmerActionPerformed(evt);
            }
        });

        jButtonRegleCBAdd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRegleCBAdd.setText("Ajouter");
        jButtonRegleCBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegleCBAddActionPerformed(evt);
            }
        });

        jButtonRegleAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRegleAnnuler.setText("Annuler");
        jButtonRegleAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegleAnnulerActionPerformed(evt);
            }
        });

        jSpinnerRegleJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRegleJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jSpinnerRegleMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRegleMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabelRegleSlash1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelRegleSlash1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRegleSlash1.setText("/");

        jLabelRegleSlash2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelRegleSlash2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRegleSlash2.setText("/");

        jButtonRegleCBRemove.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRegleCBRemove.setText("Retirer");
        jButtonRegleCBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegleCBRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogRegleLayout = new javax.swing.GroupLayout(jDialogRegle.getContentPane());
        jDialogRegle.getContentPane().setLayout(jDialogRegleLayout);
        jDialogRegleLayout.setHorizontalGroup(
            jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogRegleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogRegleLayout.createSequentialGroup()
                        .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDialogRegleLayout.createSequentialGroup()
                                .addComponent(jButtonRegleAnnuler)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRegleConfirmer))
                            .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelRegleMontant)
                                .addComponent(jScrollPaneRegleCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jDialogRegleLayout.createSequentialGroup()
                                        .addComponent(jLabelRegleCB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonRegleCBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonRegleCBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jDialogRegleLayout.createSequentialGroup()
                                        .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelRegleMode)
                                            .addComponent(jLabelRegleDesig)
                                            .addComponent(jLabelReglePersonne)
                                            .addComponent(jLabelRegleDate))
                                        .addGap(18, 18, 18)
                                        .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jDialogRegleLayout.createSequentialGroup()
                                                .addComponent(jComboBoxRegleMode, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonRegleModeRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldRegleModeAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonRegleModeAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jComboBoxReglePersonne, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldRegleDesig)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRegleLayout.createSequentialGroup()
                                                        .addComponent(jSpinnerRegleJour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabelRegleSlash1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jSpinnerRegleMois, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabelRegleSlash2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jSpinnerRegleAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(jTextFieldRegleMontant, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jLabelReglePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDialogRegleLayout.setVerticalGroup(
            jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogRegleLayout.createSequentialGroup()
                .addComponent(jLabelReglePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRegleDesig, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRegleDesig))
                .addGap(18, 18, 18)
                .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxReglePersonne, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelReglePersonne))
                .addGap(18, 18, 18)
                .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerRegleAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRegleDate)
                    .addComponent(jSpinnerRegleJour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerRegleMois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRegleSlash1)
                    .addComponent(jLabelRegleSlash2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRegleMontant, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRegleMontant))
                .addGap(18, 18, 18)
                .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonRegleModeAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldRegleModeAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonRegleModeRemove, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxRegleMode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelRegleMode)))
                .addGap(18, 18, 18)
                .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegleCBAdd)
                    .addComponent(jLabelRegleCB)
                    .addComponent(jButtonRegleCBRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneRegleCB, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialogRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegleConfirmer)
                    .addComponent(jButtonRegleAnnuler)))
        );

        jDialogCb.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogCb.setLocation(centerX-400/2,centerY-300/2);
        jDialogCb.setModal(true);
        jDialogCb.setResizable(false);
        jDialogCb.setSize(new java.awt.Dimension(400, 300));

        jLabelCbPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelCbPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCbPrincipal.setText("Ajout Compte Banquaire");

        jLabelCbBanque.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCbBanque.setText("Nom banque");

        jLabelCbAgence.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCbAgence.setText("Nom agence");

        jLabelCbNum.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCbNum.setText("Numéro compte");

        jTextFieldCbBanque.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldCbAgence.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldCbNum.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jButtonCbConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonCbConfirmer.setText("Confirmer");
        jButtonCbConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCbConfirmerActionPerformed(evt);
            }
        });

        jButtonCbAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonCbAnnuler.setText("Annuler");
        jButtonCbAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCbAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogCbLayout = new javax.swing.GroupLayout(jDialogCb.getContentPane());
        jDialogCb.getContentPane().setLayout(jDialogCbLayout);
        jDialogCbLayout.setHorizontalGroup(
            jDialogCbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCbLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogCbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCbPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogCbLayout.createSequentialGroup()
                        .addComponent(jLabelCbNum)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCbNum, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogCbLayout.createSequentialGroup()
                        .addComponent(jButtonCbAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCbConfirmer))
                    .addGroup(jDialogCbLayout.createSequentialGroup()
                        .addGroup(jDialogCbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCbBanque)
                            .addComponent(jLabelCbAgence))
                        .addGap(36, 36, 36)
                        .addGroup(jDialogCbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCbAgence)
                            .addComponent(jTextFieldCbBanque))))
                .addContainerGap())
        );
        jDialogCbLayout.setVerticalGroup(
            jDialogCbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCbPrincipal)
                .addGap(28, 28, 28)
                .addGroup(jDialogCbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCbBanque)
                    .addComponent(jTextFieldCbBanque, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogCbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCbAgence, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCbAgence))
                .addGap(18, 18, 18)
                .addGroup(jDialogCbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCbNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCbNum))
                .addGap(18, 18, 18)
                .addGroup(jDialogCbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCbConfirmer)
                    .addComponent(jButtonCbAnnuler))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jDialogRapportReglement.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogRapportReglement.setLocation(centerX - 400/2, centerY - 363/2);
        jDialogRapportReglement.setModal(true);
        jDialogRapportReglement.setResizable(false);
        jDialogRapportReglement.setSize(new java.awt.Dimension(400, 363));

        jSpinnerRapportRegleDateDuMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportRegleDateDuMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabelRapportRegleSlash2.setText("/");

        jSpinnerRapportRegleDateDuAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportRegleDateDuAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerRapportRegleDateDuAnnee.setMinimumSize(new java.awt.Dimension(45, 22));
        jSpinnerRapportRegleDateDuAnnee.setPreferredSize(new java.awt.Dimension(45, 22));

        jLabelRapportRegleSlash3.setText("/");

        jLabelRapportRegleSlash4.setText("/");

        jTextFieldRapportRegleDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jButtonRapportRegleConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRapportRegleConfirmer.setText("Confirmer");
        jButtonRapportRegleConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRapportRegleConfirmerActionPerformed(evt);
            }
        });

        jLabelRapportReglePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelRapportReglePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRapportReglePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Search.png"))); // NOI18N
        jLabelRapportReglePrincipal.setText("Recherche");

        jButtonRapportRegleAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRapportRegleAnnuler.setText("Annuler");
        jButtonRapportRegleAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRapportRegleAnnulerActionPerformed(evt);
            }
        });

        jLabelRapportRegleDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportRegleDesignation.setText("Objet spécifique");

        jSpinnerRapportRegleDateAuJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportRegleDateAuJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jLabelRapportRegleDateDu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportRegleDateDu.setText("Du");

        jSpinnerRapportRegleDateAuMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportRegleDateAuMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabelRapportRegleDateAu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportRegleDateAu.setText("Au");

        jSpinnerRapportRegleDateAuAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportRegleDateAuAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerRapportRegleDateAuAnnee.setMinimumSize(new java.awt.Dimension(45, 22));
        jSpinnerRapportRegleDateAuAnnee.setPreferredSize(new java.awt.Dimension(45, 22));

        jSpinnerRapportRegleDateDuJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerRapportRegleDateDuJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jCheckBoxRapportRegleDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBoxRapportRegleDate.setText("Filtrer par date");
        jCheckBoxRapportRegleDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRapportRegleDateActionPerformed(evt);
            }
        });

        jLabelRapportRegleSlash1.setText("/");

        jLabelRapportReglePersonne.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportReglePersonne.setText("XXXXXXXXXXX");

        jComboBoxRapportRegleMode.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxRapportRegleMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelRapportRegleMode.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRapportRegleMode.setText("Mode de réglement");

        jButtonRapportRegleSolde.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRapportRegleSolde.setText("Solde actuel");
        jButtonRapportRegleSolde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRapportRegleSoldeActionPerformed(evt);
            }
        });

        jComboBoxRapportReglePersonne.setEditable(true);
        jComboBoxRapportReglePersonne.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxRapportReglePersonne.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jDialogRapportReglementLayout = new javax.swing.GroupLayout(jDialogRapportReglement.getContentPane());
        jDialogRapportReglement.getContentPane().setLayout(jDialogRapportReglementLayout);
        jDialogRapportReglementLayout.setHorizontalGroup(
            jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelRapportReglePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialogRapportReglementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportReglementLayout.createSequentialGroup()
                        .addComponent(jButtonRapportRegleSolde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRapportRegleAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRapportRegleConfirmer))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportReglementLayout.createSequentialGroup()
                        .addComponent(jLabelRapportRegleMode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxRapportRegleMode, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogRapportReglementLayout.createSequentialGroup()
                        .addComponent(jCheckBoxRapportRegleDate)
                        .addGap(59, 59, 59)
                        .addGroup(jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportReglementLayout.createSequentialGroup()
                                .addComponent(jLabelRapportRegleDateDu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportRegleDateDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRapportRegleSlash1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportRegleDateDuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRapportRegleSlash2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportRegleDateDuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportReglementLayout.createSequentialGroup()
                                .addComponent(jLabelRapportRegleDateAu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportRegleDateAuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRapportRegleSlash3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportRegleDateAuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRapportRegleSlash4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerRapportRegleDateAuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRapportReglementLayout.createSequentialGroup()
                        .addGroup(jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRapportRegleDesignation)
                            .addComponent(jLabelRapportReglePersonne))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxRapportReglePersonne, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldRapportRegleDesignation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jDialogRapportReglementLayout.setVerticalGroup(
            jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogRapportReglementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRapportReglePrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRapportRegleDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRapportRegleDesignation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRapportReglePersonne, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRapportReglePersonne))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogRapportReglementLayout.createSequentialGroup()
                        .addGroup(jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerRapportRegleDateDuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportRegleSlash2)
                            .addComponent(jSpinnerRapportRegleDateDuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportRegleSlash1)
                            .addComponent(jSpinnerRapportRegleDateDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportRegleDateDu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerRapportRegleDateAuAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportRegleSlash4)
                            .addComponent(jSpinnerRapportRegleDateAuMois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportRegleSlash3)
                            .addComponent(jSpinnerRapportRegleDateAuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRapportRegleDateAu)))
                    .addGroup(jDialogRapportReglementLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jCheckBoxRapportRegleDate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRapportRegleMode, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRapportRegleMode))
                .addGap(34, 34, 34)
                .addGroup(jDialogRapportReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRapportRegleConfirmer)
                    .addComponent(jButtonRapportRegleAnnuler)
                    .addComponent(jButtonRapportRegleSolde))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jDialogResultatRegle.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogResultatRegle.setAlwaysOnTop(true);
        jDialogResultatRegle.setLocation(centerX - 318/2, centerY - 250/2);
        jDialogResultatRegle.setResizable(false);
        jDialogResultatRegle.setSize(new java.awt.Dimension(318, 250));
        jDialogResultatRegle.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialogResultatRegleWindowClosed(evt);
            }
        });

        jLabelResultatReglePrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelResultatReglePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResultatReglePrincipal.setText("Résultat");

        jLabelResultatRegleNb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatRegleNb.setText("Nombre d'entité trouvée");

        jLabelResultatReglePrix.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatReglePrix.setText("Somme totale");

        jTextFieldResultatRegleNb.setEditable(false);
        jTextFieldResultatRegleNb.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatRegleNb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatRegleNb.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatRegleNb.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldResultatReglePrix.setEditable(false);
        jTextFieldResultatReglePrix.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatReglePrix.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatReglePrix.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldResultatReglePrix.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jButtonResultatRegleOk.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonResultatRegleOk.setText("OK");
        jButtonResultatRegleOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResultatRegleOkActionPerformed(evt);
            }
        });

        jLabelResultatRegleDateDu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatRegleDateDu.setText("Du");

        jTextFieldResultatRegleDateDu.setEditable(false);
        jTextFieldResultatRegleDateDu.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatRegleDateDu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatRegleDateDu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldResultatRegleDateDu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldResultatRegleDateAu.setEditable(false);
        jTextFieldResultatRegleDateAu.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldResultatRegleDateAu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldResultatRegleDateAu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldResultatRegleDateAu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelResultatRegleDateAu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelResultatRegleDateAu.setText("Au");

        javax.swing.GroupLayout jDialogResultatRegleLayout = new javax.swing.GroupLayout(jDialogResultatRegle.getContentPane());
        jDialogResultatRegle.getContentPane().setLayout(jDialogResultatRegleLayout);
        jDialogResultatRegleLayout.setHorizontalGroup(
            jDialogResultatRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelResultatReglePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialogResultatRegleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogResultatRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatRegleLayout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jButtonResultatRegleOk))
                    .addGroup(jDialogResultatRegleLayout.createSequentialGroup()
                        .addGroup(jDialogResultatRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatRegleLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelResultatRegleDateDu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldResultatRegleDateDu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialogResultatRegleLayout.createSequentialGroup()
                                .addGroup(jDialogResultatRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelResultatReglePrix)
                                    .addComponent(jLabelResultatRegleNb))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogResultatRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldResultatRegleNb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldResultatReglePrix, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultatRegleLayout.createSequentialGroup()
                                .addComponent(jLabelResultatRegleDateAu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldResultatRegleDateAu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)))))
                .addContainerGap())
        );
        jDialogResultatRegleLayout.setVerticalGroup(
            jDialogResultatRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogResultatRegleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelResultatReglePrincipal)
                .addGap(18, 18, 18)
                .addGroup(jDialogResultatRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatRegleDateDu)
                    .addComponent(jTextFieldResultatRegleDateDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldResultatRegleDateAu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelResultatRegleDateAu))
                .addGap(18, 18, 18)
                .addGroup(jDialogResultatRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatRegleNb)
                    .addComponent(jTextFieldResultatRegleNb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogResultatRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResultatReglePrix)
                    .addComponent(jTextFieldResultatReglePrix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonResultatRegleOk)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jDialogPersonneInfo.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogPersonneInfo.setLocation(centerX - 550/2, centerY - 430/2);
        jDialogPersonneInfo.setModal(true);
        jDialogPersonneInfo.setPreferredSize(new java.awt.Dimension(550, 430));
        jDialogPersonneInfo.setResizable(false);
        jDialogPersonneInfo.setSize(new java.awt.Dimension(550, 430));

        jButtonPersonnePayConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonPersonnePayConfirmer.setText("OK");
        jButtonPersonnePayConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPersonnePayConfirmerActionPerformed(evt);
            }
        });

        jLabelPersonnePayPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelPersonnePayPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPersonnePayPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Crd.png"))); // NOI18N
        jLabelPersonnePayPrincipal.setText("Payement");

        jTablePersonnePay.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTablePersonnePay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablePersonnePay.setRowHeight(25);
        jScrollPanePersonnePay.setViewportView(jTablePersonnePay);

        jButtonPersonnePayAdd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonPersonnePayAdd.setText("Ajouter un payement");
        jButtonPersonnePayAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPersonnePayAddActionPerformed(evt);
            }
        });

        jButtonPersonnePayRemove.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonPersonnePayRemove.setText("Retirer le payement");
        jButtonPersonnePayRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPersonnePayRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPersonnePayementLayout = new javax.swing.GroupLayout(jPanelPersonnePayement);
        jPanelPersonnePayement.setLayout(jPanelPersonnePayementLayout);
        jPanelPersonnePayementLayout.setHorizontalGroup(
            jPanelPersonnePayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPersonnePayementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPersonnePayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPersonnePayementLayout.createSequentialGroup()
                        .addGroup(jPanelPersonnePayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPersonnePayPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPanePersonnePay, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                            .addGroup(jPanelPersonnePayementLayout.createSequentialGroup()
                                .addComponent(jButtonPersonnePayAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPersonnePayRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonnePayementLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonPersonnePayConfirmer)
                        .addGap(19, 19, 19))))
        );
        jPanelPersonnePayementLayout.setVerticalGroup(
            jPanelPersonnePayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonnePayementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPersonnePayPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPersonnePayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPersonnePayAdd)
                    .addComponent(jButtonPersonnePayRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPanePersonnePay, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPersonnePayConfirmer)
                .addContainerGap())
        );

        jTabbedPanePersonneInfo.addTab("Règlement", jPanelPersonnePayement);

        jButtonPersonneCrAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonPersonneCrAnnuler.setText("Annuler");
        jButtonPersonneCrAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPersonneCrAnnulerActionPerformed(evt);
            }
        });

        jButtonPersonneCrConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonPersonneCrConfirmer.setText("Confirmer");
        jButtonPersonneCrConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPersonneCrConfirmerActionPerformed(evt);
            }
        });

        jLabelPersonneCrAdresse.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPersonneCrAdresse.setText("Adresse");

        jLabelPersonneCrTel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPersonneCrTel.setText("N° Tel");

        jLabelPersonneCrRC.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPersonneCrRC.setText("N° RC");

        jLabelPersonneCrArt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPersonneCrArt.setText("N° Article");

        jLabelPersonneCrNIF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPersonneCrNIF.setText("NIF");

        jLabelPersonneCrNIS.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPersonneCrNIS.setText("NIS");

        jLabelPersonneCrCptBanque.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPersonneCrCptBanque.setText("Compte bancaire");

        jLabelPersonneCrFonction.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPersonneCrFonction.setText("Fonction");

        jTextFieldPersonneCrAdresse.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldPersonneCrTel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldPersonneCrRC.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldPersonneCrArt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldPersonneCrNIS.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldPersonneCrNIF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldPersonneCrCptBanque.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldPersonneCrFonction.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelPersonneCrDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPersonneCrDesignation.setText("Raison sociale");

        jTextFieldPersonneCrDesignation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelPersonneCrCevilite.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPersonneCrCevilite.setText("Cévilité");

        jTextFieldPersonneCrCevilite.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelPersonneCrPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelPersonneCrPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPersonneCrPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Crd.png"))); // NOI18N
        jLabelPersonneCrPrincipal.setText("Coordonnée");
        jLabelPersonneCrPrincipal.setIconTextGap(10);

        javax.swing.GroupLayout jPanelPersonneCrLayout = new javax.swing.GroupLayout(jPanelPersonneCr);
        jPanelPersonneCr.setLayout(jPanelPersonneCrLayout);
        jPanelPersonneCrLayout.setHorizontalGroup(
            jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPersonneCrPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonneCrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelPersonneCrLayout.createSequentialGroup()
                        .addComponent(jLabelPersonneCrRC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPersonneCrRC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPersonneCrLayout.createSequentialGroup()
                        .addComponent(jLabelPersonneCrDesignation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPersonneCrDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPersonneCrLayout.createSequentialGroup()
                        .addComponent(jLabelPersonneCrAdresse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPersonneCrAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPersonneCrLayout.createSequentialGroup()
                        .addComponent(jLabelPersonneCrNIF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPersonneCrNIF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPersonneCrLayout.createSequentialGroup()
                        .addComponent(jLabelPersonneCrFonction)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPersonneCrFonction, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonneCrLayout.createSequentialGroup()
                        .addComponent(jLabelPersonneCrCevilite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPersonneCrCevilite, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonneCrLayout.createSequentialGroup()
                        .addComponent(jLabelPersonneCrArt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPersonneCrArt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonneCrLayout.createSequentialGroup()
                        .addComponent(jLabelPersonneCrTel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPersonneCrTel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonneCrLayout.createSequentialGroup()
                        .addComponent(jLabelPersonneCrNIS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPersonneCrNIS, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonneCrLayout.createSequentialGroup()
                        .addComponent(jLabelPersonneCrCptBanque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPersonneCrCptBanque, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonneCrLayout.createSequentialGroup()
                        .addComponent(jButtonPersonneCrAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPersonneCrConfirmer)))
                .addGap(19, 19, 19))
        );
        jPanelPersonneCrLayout.setVerticalGroup(
            jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonneCrLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPersonneCrPrincipal)
                .addGap(18, 18, 18)
                .addGroup(jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPersonneCrDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPersonneCrDesignation))
                    .addGroup(jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPersonneCrCevilite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPersonneCrCevilite)))
                .addGap(31, 31, 31)
                .addGroup(jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPersonneCrTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPersonneCrTel)
                    .addComponent(jTextFieldPersonneCrAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPersonneCrAdresse))
                .addGap(32, 32, 32)
                .addGroup(jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPersonneCrArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPersonneCrArt)
                    .addComponent(jTextFieldPersonneCrRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPersonneCrRC))
                .addGap(32, 32, 32)
                .addGroup(jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPersonneCrNIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPersonneCrNIS)
                    .addComponent(jTextFieldPersonneCrNIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPersonneCrNIF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPersonneCrFonction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPersonneCrFonction))
                    .addGroup(jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPersonneCrCptBanque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPersonneCrCptBanque)))
                .addGap(33, 33, 33)
                .addGroup(jPanelPersonneCrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPersonneCrConfirmer)
                    .addComponent(jButtonPersonneCrAnnuler))
                .addContainerGap())
        );

        jTabbedPanePersonneInfo.addTab("Coordonnée", jPanelPersonneCr);

        javax.swing.GroupLayout jDialogPersonneInfoLayout = new javax.swing.GroupLayout(jDialogPersonneInfo.getContentPane());
        jDialogPersonneInfo.getContentPane().setLayout(jDialogPersonneInfoLayout);
        jDialogPersonneInfoLayout.setHorizontalGroup(
            jDialogPersonneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPanePersonneInfo)
        );
        jDialogPersonneInfoLayout.setVerticalGroup(
            jDialogPersonneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogPersonneInfoLayout.createSequentialGroup()
                .addComponent(jTabbedPanePersonneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        jDialogAddPayement.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogAddPayement.setLocation(centerX - 474/2, centerY - 320/2);
        jDialogAddPayement.setModal(true);
        jDialogAddPayement.setResizable(false);
        jDialogAddPayement.setSize(new java.awt.Dimension(474, 320));

        jButtonAddPayRegleRemove.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddPayRegleRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Remove_Unite.png"))); // NOI18N
        jButtonAddPayRegleRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPayRegleRemoveActionPerformed(evt);
            }
        });

        jTextFieldAddPayRegleAdd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jButtonAddPayRegleAdd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddPayRegleAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Add_Unite.png"))); // NOI18N
        jButtonAddPayRegleAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPayRegleAddActionPerformed(evt);
            }
        });

        jLabelAddPayDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddPayDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAddPayDate.setText("Date");

        jLabelAddPayPT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddPayPT.setText("Montant");

        jSpinnerAddPayJour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerAddPayJour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jLabelAddPayDA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddPayDA.setText(".00 DA");

        jLabelAddPaySlash1.setText("/");

        jTextFieldAddPayPT.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelAddPayPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelAddPayPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddPayPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Crd.png"))); // NOI18N
        jLabelAddPayPrincipal.setText("Ajouter Payement");

        jSpinnerAddPayMois.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerAddPayMois.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabelAddPaySlash2.setText("/");

        jButtonAddPayAnnuler.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddPayAnnuler.setText("Annuler");

        jSpinnerAddPayAnnee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jSpinnerAddPayAnnee.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jButtonAddPayConfirmer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAddPayConfirmer.setText("Confirmer");
        jButtonAddPayConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPayConfirmerActionPerformed(evt);
            }
        });

        jLabelAddPayRegle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAddPayRegle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAddPayRegle.setText("Mode réglement");

        jComboBoxAddPayRegle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxAddPayRegle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jDialogAddPayementLayout = new javax.swing.GroupLayout(jDialogAddPayement.getContentPane());
        jDialogAddPayement.getContentPane().setLayout(jDialogAddPayementLayout);
        jDialogAddPayementLayout.setHorizontalGroup(
            jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAddPayementLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAddPayementLayout.createSequentialGroup()
                        .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAddPayRegle)
                            .addComponent(jLabelAddPayPT))
                        .addGap(18, 18, 18))
                    .addGroup(jDialogAddPayementLayout.createSequentialGroup()
                        .addComponent(jLabelAddPayDate)
                        .addGap(82, 82, 82)))
                .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDialogAddPayementLayout.createSequentialGroup()
                        .addComponent(jSpinnerAddPayJour)
                        .addGap(45, 45, 45)
                        .addComponent(jLabelAddPaySlash1)
                        .addGap(46, 46, 46)
                        .addComponent(jSpinnerAddPayMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabelAddPaySlash2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jSpinnerAddPayAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogAddPayementLayout.createSequentialGroup()
                        .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDialogAddPayementLayout.createSequentialGroup()
                                .addComponent(jComboBoxAddPayRegle, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAddPayRegleRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAddPayRegleAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldAddPayPT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAddPayDA)
                            .addComponent(jButtonAddPayRegleAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
            .addGroup(jDialogAddPayementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAddPayPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAddPayementLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAddPayAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddPayConfirmer)))
                .addContainerGap())
        );
        jDialogAddPayementLayout.setVerticalGroup(
            jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddPayementLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelAddPayPrincipal)
                .addGap(23, 23, 23)
                .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddPayDate)
                    .addComponent(jSpinnerAddPayJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerAddPayAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerAddPayMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddPaySlash1)
                    .addComponent(jLabelAddPaySlash2))
                .addGap(29, 29, 29)
                .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelAddPayRegle)
                                .addComponent(jComboBoxAddPayRegle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonAddPayRegleRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButtonAddPayRegleAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldAddPayRegleAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddPayPT)
                    .addComponent(jTextFieldAddPayPT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddPayDA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jDialogAddPayementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddPayConfirmer)
                    .addComponent(jButtonAddPayAnnuler))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("VisDias");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBarOutils.setBorder(null);
        jToolBarOutils.setFloatable(false);
        jToolBarOutils.setRollover(true);
        jToolBarOutils.setName(""); // NOI18N

        jButtonSauvegarde.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonSauvegarde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Sauvegarde.png"))); // NOI18N
        jButtonSauvegarde.setToolTipText("Enregistrer");
        jButtonSauvegarde.setEnabled(false);
        jButtonSauvegarde.setFocusable(false);
        jButtonSauvegarde.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSauvegarde.setMaximumSize(new java.awt.Dimension(45, 45));
        jButtonSauvegarde.setMinimumSize(new java.awt.Dimension(45, 45));
        jButtonSauvegarde.setPreferredSize(new java.awt.Dimension(45, 45));
        jButtonSauvegarde.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSauvegarde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSauvegardeActionPerformed(evt);
            }
        });
        jToolBarOutils.add(jButtonSauvegarde);

        jButtonImprimer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonImprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/print.png"))); // NOI18N
        jButtonImprimer.setToolTipText("Imprimer");
        jButtonImprimer.setFocusable(false);
        jButtonImprimer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonImprimer.setMaximumSize(new java.awt.Dimension(45, 45));
        jButtonImprimer.setMinimumSize(new java.awt.Dimension(45, 45));
        jButtonImprimer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonImprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimerActionPerformed(evt);
            }
        });
        jToolBarOutils.add(jButtonImprimer);

        jButtonRapport.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRapport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Search.png"))); // NOI18N
        jButtonRapport.setToolTipText("Recherche");
        jButtonRapport.setFocusable(false);
        jButtonRapport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRapport.setMaximumSize(new java.awt.Dimension(45, 45));
        jButtonRapport.setMinimumSize(new java.awt.Dimension(45, 45));
        jButtonRapport.setPreferredSize(new java.awt.Dimension(45, 45));
        jButtonRapport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRapportActionPerformed(evt);
            }
        });
        jToolBarOutils.add(jButtonRapport);

        jButtonUndo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Undo.png"))); // NOI18N
        jButtonUndo.setToolTipText("Annuler la suppression");
        jButtonUndo.setEnabled(false);
        jButtonUndo.setFocusable(false);
        jButtonUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUndo.setMaximumSize(new java.awt.Dimension(45, 45));
        jButtonUndo.setMinimumSize(new java.awt.Dimension(45, 45));
        jButtonUndo.setPreferredSize(new java.awt.Dimension(45, 45));
        jButtonUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUndoActionPerformed(evt);
            }
        });
        jToolBarOutils.add(jButtonUndo);
        jToolBarOutils.add(jSeparatorOutils);

        jButtonAdd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Add.png"))); // NOI18N
        jButtonAdd.setToolTipText("Ajouter");
        jButtonAdd.setFocusable(false);
        jButtonAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAdd.setMaximumSize(new java.awt.Dimension(45, 45));
        jButtonAdd.setMinimumSize(new java.awt.Dimension(45, 45));
        jButtonAdd.setPreferredSize(new java.awt.Dimension(45, 45));
        jButtonAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jToolBarOutils.add(jButtonAdd);

        jButtonRemove.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Remove.png"))); // NOI18N
        jButtonRemove.setToolTipText("Supprimer");
        jButtonRemove.setFocusable(false);
        jButtonRemove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRemove.setMaximumSize(new java.awt.Dimension(45, 45));
        jButtonRemove.setMinimumSize(new java.awt.Dimension(45, 45));
        jButtonRemove.setPreferredSize(new java.awt.Dimension(45, 45));
        jButtonRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });
        jToolBarOutils.add(jButtonRemove);

        jButtonEdit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Edit.png"))); // NOI18N
        jButtonEdit.setToolTipText("Modifier");
        jButtonEdit.setFocusable(false);
        jButtonEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEdit.setMaximumSize(new java.awt.Dimension(45, 45));
        jButtonEdit.setMinimumSize(new java.awt.Dimension(45, 45));
        jButtonEdit.setPreferredSize(new java.awt.Dimension(45, 45));
        jButtonEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jToolBarOutils.add(jButtonEdit);

        jToolBarRubriques.setBorder(null);
        jToolBarRubriques.setFloatable(false);
        jToolBarRubriques.setRollover(true);

        jButtonAccueil.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAccueil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Accueil.png"))); // NOI18N
        jButtonAccueil.setText("Accueil");
        jButtonAccueil.setFocusable(false);
        jButtonAccueil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAccueil.setIconTextGap(1);
        jButtonAccueil.setMaximumSize(new java.awt.Dimension(75, 59));
        jButtonAccueil.setMinimumSize(new java.awt.Dimension(75, 59));
        jButtonAccueil.setPreferredSize(new java.awt.Dimension(75, 59));
        jButtonAccueil.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAccueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccueilActionPerformed(evt);
            }
        });
        jToolBarRubriques.add(jButtonAccueil);

        jButtonClient.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Client.png"))); // NOI18N
        jButtonClient.setText("Client");
        jButtonClient.setEnabled(false);
        jButtonClient.setFocusable(false);
        jButtonClient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonClient.setIconTextGap(1);
        jButtonClient.setMaximumSize(new java.awt.Dimension(75, 59));
        jButtonClient.setMinimumSize(new java.awt.Dimension(75, 59));
        jButtonClient.setPreferredSize(new java.awt.Dimension(75, 59));
        jButtonClient.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientActionPerformed(evt);
            }
        });
        jToolBarRubriques.add(jButtonClient);

        jButtonFournisseur.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonFournisseur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Fournisseur.png"))); // NOI18N
        jButtonFournisseur.setText("Fournisseur");
        jButtonFournisseur.setEnabled(false);
        jButtonFournisseur.setFocusable(false);
        jButtonFournisseur.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFournisseur.setIconTextGap(1);
        jButtonFournisseur.setMaximumSize(new java.awt.Dimension(75, 59));
        jButtonFournisseur.setMinimumSize(new java.awt.Dimension(75, 59));
        jButtonFournisseur.setPreferredSize(new java.awt.Dimension(75, 59));
        jButtonFournisseur.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonFournisseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFournisseurActionPerformed(evt);
            }
        });
        jToolBarRubriques.add(jButtonFournisseur);

        jButtonArticleAchat.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonArticleAchat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Article.png"))); // NOI18N
        jButtonArticleAchat.setText("Stock activité");
        jButtonArticleAchat.setEnabled(false);
        jButtonArticleAchat.setFocusable(false);
        jButtonArticleAchat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonArticleAchat.setIconTextGap(1);
        jButtonArticleAchat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonArticleAchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArticleAchatActionPerformed(evt);
            }
        });
        jToolBarRubriques.add(jButtonArticleAchat);

        jButtonConso.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonConso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Conso.png"))); // NOI18N
        jButtonConso.setText("Consommation");
        jButtonConso.setEnabled(false);
        jButtonConso.setFocusable(false);
        jButtonConso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonConso.setIconTextGap(1);
        jButtonConso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonConso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsoActionPerformed(evt);
            }
        });
        jToolBarRubriques.add(jButtonConso);

        jButtonAchat.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAchat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Achat.png"))); // NOI18N
        jButtonAchat.setText("Achat");
        jButtonAchat.setEnabled(false);
        jButtonAchat.setFocusable(false);
        jButtonAchat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAchat.setIconTextGap(1);
        jButtonAchat.setMaximumSize(new java.awt.Dimension(75, 59));
        jButtonAchat.setMinimumSize(new java.awt.Dimension(75, 59));
        jButtonAchat.setPreferredSize(new java.awt.Dimension(75, 59));
        jButtonAchat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAchatActionPerformed(evt);
            }
        });
        jToolBarRubriques.add(jButtonAchat);

        jButtonArticleVente.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonArticleVente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Production.png"))); // NOI18N
        jButtonArticleVente.setText("Production");
        jButtonArticleVente.setEnabled(false);
        jButtonArticleVente.setFocusable(false);
        jButtonArticleVente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonArticleVente.setIconTextGap(1);
        jButtonArticleVente.setMaximumSize(new java.awt.Dimension(75, 59));
        jButtonArticleVente.setMinimumSize(new java.awt.Dimension(75, 59));
        jButtonArticleVente.setPreferredSize(new java.awt.Dimension(75, 59));
        jButtonArticleVente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonArticleVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArticleVenteActionPerformed(evt);
            }
        });
        jToolBarRubriques.add(jButtonArticleVente);

        jButtonVente.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonVente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Vente.png"))); // NOI18N
        jButtonVente.setText("Vente");
        jButtonVente.setEnabled(false);
        jButtonVente.setFocusable(false);
        jButtonVente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVente.setIconTextGap(1);
        jButtonVente.setMaximumSize(new java.awt.Dimension(75, 59));
        jButtonVente.setMinimumSize(new java.awt.Dimension(75, 59));
        jButtonVente.setPreferredSize(new java.awt.Dimension(75, 59));
        jButtonVente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVenteActionPerformed(evt);
            }
        });
        jToolBarRubriques.add(jButtonVente);

        jButtonRecette.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRecette.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Recette.png"))); // NOI18N
        jButtonRecette.setText("Crédit");
        jButtonRecette.setEnabled(false);
        jButtonRecette.setFocusable(false);
        jButtonRecette.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRecette.setIconTextGap(1);
        jButtonRecette.setMaximumSize(new java.awt.Dimension(75, 59));
        jButtonRecette.setMinimumSize(new java.awt.Dimension(75, 59));
        jButtonRecette.setPreferredSize(new java.awt.Dimension(75, 59));
        jButtonRecette.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRecette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecetteActionPerformed(evt);
            }
        });
        jToolBarRubriques.add(jButtonRecette);

        jButtonDepense.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonDepense.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Debit.png"))); // NOI18N
        jButtonDepense.setText("Débit");
        jButtonDepense.setEnabled(false);
        jButtonDepense.setFocusable(false);
        jButtonDepense.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDepense.setIconTextGap(1);
        jButtonDepense.setMaximumSize(new java.awt.Dimension(75, 59));
        jButtonDepense.setMinimumSize(new java.awt.Dimension(75, 59));
        jButtonDepense.setPreferredSize(new java.awt.Dimension(75, 59));
        jButtonDepense.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDepense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDepenseActionPerformed(evt);
            }
        });
        jToolBarRubriques.add(jButtonDepense);

        jLabelRubriqueCourante.setBackground(new java.awt.Color(210, 210, 210));
        jLabelRubriqueCourante.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabelRubriqueCourante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRubriqueCourante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Accueil.png"))); // NOI18N
        jLabelRubriqueCourante.setText("Accueil");
        jLabelRubriqueCourante.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelRubriqueCourante.setIconTextGap(20);
        jLabelRubriqueCourante.setName(""); // NOI18N
        jLabelRubriqueCourante.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBarOutils, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBarRubriques, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
            .addComponent(jLabelRubriqueCourante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBarOutils, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBarRubriques, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRubriqueCourante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccueilActionPerformed
        MODE = MODE_ACCUEIL;
        setupAccueil();
        jLabelRubriqueCourante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Accueil.png")));
        if(CompteFinance.compteActif == null)
            jLabelRubriqueCourante.setText("Accueil");
        else
            jLabelRubriqueCourante.setText("Compte : "+CompteFinance.compteActif.getIdentifiant());
    }//GEN-LAST:event_jButtonAccueilActionPerformed

    private void jButtonClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientActionPerformed
        MODE = MODE_CLIENT;
        setupOneTable();
        setupClient(null, false);
        jLabelRubriqueCourante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Client.png")));
        jLabelRubriqueCourante.setText("Liste des clients");
    }//GEN-LAST:event_jButtonClientActionPerformed

    private void jButtonFournisseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFournisseurActionPerformed
        MODE = MODE_FOURNISSEUR;
        setupOneTable();
        setupFournisseur(null, false);
        jLabelRubriqueCourante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Fournisseur.png")));
        jLabelRubriqueCourante.setText("Liste des fournisseurs");
    }//GEN-LAST:event_jButtonFournisseurActionPerformed

    private void jButtonArticleAchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArticleAchatActionPerformed
        MODE = MODE_ARTICLE_ACHAT;
        setupTwoTable(300);
        GroupeArticleAchat.groupeAchatActif = null;
        setupGroupeAchat(null, null, null, null, false, true);
        jLabelRubriqueCourante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Article.png")));
        jLabelRubriqueCourante.setText("Liste article activité");
    }//GEN-LAST:event_jButtonArticleAchatActionPerformed

    private void jButtonArticleVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArticleVenteActionPerformed
        MODE = MODE_ARTICLE_VENTE;
        setupTwoTable(300);
        GroupeArticleVente.groupeVenteActif = null;
        setupGroupeVente(null, null, null, null, false, true);
        jLabelRubriqueCourante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Production.png")));
        jLabelRubriqueCourante.setText("Liste des articles produits");
    }//GEN-LAST:event_jButtonArticleVenteActionPerformed

    private void jButtonAchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAchatActionPerformed
        MODE = MODE_BON_ACHAT;
        setupTwoTable(600);
        Bon.BonActif = null;
        setupAchat(null, null, null, true, null);
        jLabelRubriqueCourante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Achat.png")));
        jLabelRubriqueCourante.setText("Liste des bons d'achat");
    }//GEN-LAST:event_jButtonAchatActionPerformed

    private void jButtonVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVenteActionPerformed
        MODE = MODE_BON_VENTE;
        setupTwoTable(600);
        Bon.BonActif = null;
        setupVente(null, null, null, true, null);
        jLabelRubriqueCourante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Vente.png")));
        jLabelRubriqueCourante.setText("Liste des bons de vente");
    }//GEN-LAST:event_jButtonVenteActionPerformed

    private void jButtonSauvegardeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSauvegardeActionPerformed
        if(CompteFinance.compteActif != null){
            VisDias.sauvegarde("comptes/"+CompteFinance.compteActif.getIdentifiant());
        }
        jLabelOption.setText("Sauvegardé !");
        JOptionPane.showMessageDialog(null, jLabelOption, "Alerte", JOptionPane.INFORMATION_MESSAGE, null);
    }//GEN-LAST:event_jButtonSauvegardeActionPerformed

    private void jButtonRapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRapportActionPerformed
        Date todaysDate = Date.getTodayDate();
        if(MODE == MODE_CLIENT || MODE == MODE_FOURNISSEUR){
            jTextFieldRapportPersonneDesignation.setText("");
            jCheckBoxRapportPersonneRAR.setSelected(false);
            
            jDialogRapportPersonne.setVisible(true);
        }else if(MODE == MODE_ARTICLE_ACHAT || MODE == MODE_ARTICLE_VENTE){
            jTextFieldRapportArticleDesignation.setText("");
            jSpinnerRapportArticleDateDuJour.setValue(todaysDate.day);
            jSpinnerRapportArticleDateDuMois.setValue(todaysDate.month);
            jSpinnerRapportArticleDateDuAnnee.setValue(todaysDate.year);
            
            jSpinnerRapportArticleDateAuJour.setValue(todaysDate.day);
            jSpinnerRapportArticleDateAuMois.setValue(todaysDate.month);
            jSpinnerRapportArticleDateAuAnnee.setValue(todaysDate.year);
            
            jCheckBoxRapportArticleDate.setSelected(false);
            jCheckBoxRapportArticleDateChangeState(false);
            jCheckBoxRapportArticleQt.setSelected(false);
            
            jDialogRapportArticle.setVisible(true);
        }else if(MODE == MODE_BON_ACHAT || MODE == MODE_BON_VENTE){
            jComboBoxRapportBonPersonne.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Tous"}));
            if(MODE == MODE_BON_ACHAT){
                jLabelRapportBonPersonne.setText("Fournisseur spécifique");
                for(Fournisseur i : VisDias.listFournisseur){
                    jComboBoxRapportBonPersonne.addItem(i.code+" - "+i.designation);
                }
            }else{
                jLabelRapportBonPersonne.setText("Client spécifique");
                for(Client i : VisDias.listClient){
                    jComboBoxRapportBonPersonne.addItem(i.code+" - "+i.designation);
                }
            }
            jTextFieldRapportBonDesignation.setText("");
            jSpinnerRapportBonDateDuJour.setValue(todaysDate.day);
            jSpinnerRapportBonDateDuMois.setValue(todaysDate.month);
            jSpinnerRapportBonDateDuAnnee.setValue(todaysDate.year);
            
            jSpinnerRapportBonDateAuJour.setValue(todaysDate.day);
            jSpinnerRapportBonDateAuMois.setValue(todaysDate.month);
            jSpinnerRapportBonDateAuAnnee.setValue(todaysDate.year);
            jCheckBoxRapportBonDate.setSelected(false);
            jCheckBoxRapportBonDateChangeState(false);
            
            jDialogRapportBon.setVisible(true);
        }else if(MODE == MODE_CONSO){
            jTextFieldRapportConsoDesignation.setText("");
            jSpinnerRapportConsoDateDuJour.setValue(todaysDate.day);
            jSpinnerRapportConsoDateDuMois.setValue(todaysDate.month);
            jSpinnerRapportConsoDateDuAnnee.setValue(todaysDate.year);
            
            jSpinnerRapportConsoDateAuJour.setValue(todaysDate.day);
            jSpinnerRapportConsoDateAuMois.setValue(todaysDate.month);
            jSpinnerRapportConsoDateAuAnnee.setValue(todaysDate.year);
            jCheckBoxRapportConsoDate.setSelected(true);
            jCheckBoxRapportConsoDate.doClick();
            
            jDialogRapportConso.setVisible(true);
        }else if(MODE == MODE_RECETTE || MODE == MODE_DEPENSE){
            jTextFieldRapportRegleDesignation.setText("");
            
            jCheckBoxRapportRegleDate.setSelected(true);
            jCheckBoxRapportRegleDate.doClick();
            
            jSpinnerRapportRegleDateDuJour.setValue(todaysDate.day);
            jSpinnerRapportRegleDateDuMois.setValue(todaysDate.month);
            jSpinnerRapportRegleDateDuAnnee.setValue(todaysDate.year);
            
            jSpinnerRapportRegleDateAuJour.setValue(todaysDate.day);
            jSpinnerRapportRegleDateAuMois.setValue(todaysDate.month);
            jSpinnerRapportRegleDateAuAnnee.setValue(todaysDate.year);
            
            jComboBoxRapportRegleMode.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Tous"}));
            for(int i = 0; i < Reglement.listModeReg.size(); i++){
                jComboBoxRapportRegleMode.addItem(Reglement.listModeReg.get(i));
            }
            jComboBoxRapportReglePersonne.removeAllItems();
            if(MODE == MODE_RECETTE){
                jLabelRapportReglePersonne.setText("Créancier spécifique");
                for(Client i : VisDias.listClient){
                    jComboBoxRapportReglePersonne.addItem(i.designation);
                }
            }else{
                jLabelRapportReglePersonne.setText("Débiteur spécifique");
                for(Fournisseur i : VisDias.listFournisseur){
                    jComboBoxRapportReglePersonne.addItem(i.designation);
                }
            }
            jComboBoxRapportReglePersonne.setSelectedItem("");
            jDialogRapportReglement.setVisible(true);
        }
        
    }//GEN-LAST:event_jButtonRapportActionPerformed
    
    private void jCheckBoxRapportBonDateChangeState(boolean bool){
        jLabelRapportBonDateDu.setEnabled(bool);
        jSpinnerRapportBonDateDuJour.setEnabled(bool);
        jLabelRapportBonSlash1.setEnabled(bool);
        jSpinnerRapportBonDateDuMois.setEnabled(bool);
        jLabelRapportBonSlash2.setEnabled(bool);
        jSpinnerRapportBonDateDuAnnee.setEnabled(bool);
        
        jLabelRapportBonDateAu.setEnabled(bool);
        jSpinnerRapportBonDateAuJour.setEnabled(bool);
        jLabelRapportBonSlash3.setEnabled(bool);
        jSpinnerRapportBonDateAuMois.setEnabled(bool);
        jLabelRapportBonSlash4.setEnabled(bool);
        jSpinnerRapportBonDateAuAnnee.setEnabled(bool);
    }
    
    private void jCheckBoxRapportArticleDateChangeState(boolean bool){
        jLabelRapportArticleDateDu.setEnabled(bool);
        jSpinnerRapportArticleDateDuJour.setEnabled(bool);
        jLabelRapportArticleSlash1.setEnabled(bool);
        jSpinnerRapportArticleDateDuMois.setEnabled(bool);
        jLabelRapportArticleSlash2.setEnabled(bool);
        jSpinnerRapportArticleDateDuAnnee.setEnabled(bool);
        
        jLabelRapportArticleDateAu.setEnabled(bool);
        jSpinnerRapportArticleDateAuJour.setEnabled(bool);
        jLabelRapportArticleSlash3.setEnabled(bool);
        jSpinnerRapportArticleDateAuMois.setEnabled(bool);
        jLabelRapportArticleSlash4.setEnabled(bool);
        jSpinnerRapportArticleDateAuAnnee.setEnabled(bool);
    }
    
    private void jButtonUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUndoActionPerformed
        Object residu = VisDias.listCorbeille.pop();
        if(residu.getClass() == Client.class){
            VisDias.listClient.add((Client)residu);
            if(MODE == MODE_CLIENT)
                setupClient(null, false);
        }else if(residu.getClass() == Fournisseur.class){
            VisDias.listFournisseur.add((Fournisseur)residu);
            if(MODE == MODE_FOURNISSEUR)
                setupFournisseur(null, false);
        }else if(residu.getClass() == GroupeArticleAchat.class){
            VisDias.listGroupeArticleAchat.add((GroupeArticleAchat)residu);
            if(MODE == MODE_ARTICLE_ACHAT)
                setupGroupeAchat(null, null, null, null, false, false);
        }else if(residu.getClass() == GroupeArticleVente.class){
            VisDias.listGroupeArticleVente.add((GroupeArticleVente)residu);
            if(MODE == MODE_ARTICLE_VENTE)
                setupGroupeVente(null, null, null, null, false, false);
        }else if(residu.getClass() == ArticleAchat.class){
            VisDias.listArticleAchat.add((ArticleAchat)residu);
            VisDias.listGroupeArticleAchat.get(0).refArticle.add(((ArticleAchat)residu).code);
            if(MODE == MODE_ARTICLE_ACHAT)
                setupGroupeAchat(GroupeArticleAchat.groupeAchatActif, null, null, null, false, VisDias.listGroupeArticleAchat.get(0) == GroupeArticleAchat.groupeAchatActif);
        }else if(residu.getClass() == ArticleVente.class){
            VisDias.listArticleVente.add((ArticleVente)residu);
            VisDias.listGroupeArticleVente.get(0).refArticle.add(((ArticleVente)residu).code);
            if(MODE == MODE_ARTICLE_VENTE)
                setupGroupeVente(GroupeArticleVente.groupeVenteActif, null, null, null, false, VisDias.listGroupeArticleVente.get(0) == GroupeArticleVente.groupeVenteActif);
        }else if(residu.getClass() == BonAchat.class){
            VisDias.listBonAchat.add((BonAchat)residu);
            ArticleAchat tmpArt;
            for(ArticleBon i : ((BonAchat)residu).listArticleBon){
                tmpArt = ArticleAchat.get(i.refArticle);
                if(tmpArt != null)
                    tmpArt.quantiteStock += i.quantite;
            }
            Fournisseur tmpFr = Fournisseur.get(((BonAchat)residu).refPersonne);
            if(tmpFr != null){
                tmpFr.chiffreAffaire += ((BonAchat)residu).prixTTC;
            }
            if(MODE == MODE_BON_ACHAT)
                setupAchat(null, null, null, false, null);
            else if(MODE == MODE_ARTICLE_ACHAT)
                setupGroupeAchat(GroupeArticleAchat.groupeAchatActif, null, null, null, false, true);
            else if(MODE == MODE_FOURNISSEUR)
                setupFournisseur(null, false);
        }else if(residu.getClass() == BonVente.class){
            VisDias.listBonVente.add((BonVente)residu);
            ArticleVente tmpArt;
            for(ArticleBon i : ((BonVente)residu).listArticleBon){
                tmpArt = ArticleVente.get(i.refArticle);
                if(tmpArt != null)
                    tmpArt.quantiteStock -= i.quantite;
            }
            Client tmpCl = Client.get(((BonVente)residu).refPersonne);
            if(tmpCl != null){
                tmpCl.chiffreAffaire += ((BonVente)residu).prixTTC;
            }
            if(MODE == MODE_BON_VENTE)
                setupVente(null, null, null, false, null);
            else if(MODE == MODE_ARTICLE_VENTE)
                setupGroupeVente(GroupeArticleVente.groupeVenteActif, null, null, null, false, true);
            else if(MODE == MODE_CLIENT)
                setupClient(null, false);
        }else if(residu.getClass() == Consommation.class){
            VisDias.listConsommation.add((Consommation)residu);
            VisDias.listGroupeConso.get(0).refArticle.add(((Consommation)residu).code);
            if(((Consommation)residu).refArticle != null && ArticleAchat.get(((Consommation)residu).refArticle) != null){
                ArticleAchat.get(((Consommation)residu).refArticle).quantiteStock -= ((Consommation)residu).quantite;
            }
            if(MODE == MODE_CONSO)
                setupGroupeConso(GroupeConso.GroupeConsoActif, null, null, null, true);
            else if(MODE == MODE_ARTICLE_ACHAT)
                setupGroupeAchat(GroupeArticleAchat.groupeAchatActif, null, null, null, false, true);
        }else if(residu.getClass() == GroupeConso.class){
            VisDias.listGroupeConso.add((GroupeConso)residu);
            if(MODE == MODE_CONSO)
                setupGroupeConso(GroupeConso.GroupeConsoActif, null, null, null, false);
        }else if(residu.getClass() == Recette.class){
            VisDias.listRecette.add((Recette)residu);
            if(MODE == MODE_RECETTE)
                setupRecette(null, null, null, null, null);
        }else if(residu.getClass() == Depense.class){
            VisDias.listDepense.add((Depense)residu);
            if(MODE == MODE_DEPENSE)
                setupDepense(null, null, null, null, null);
        }
        
        if(VisDias.listCorbeille.isEmpty())
            jButtonUndo.setEnabled(false);
    }//GEN-LAST:event_jButtonUndoActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        if(MODE == MODE_CLIENT || MODE == MODE_FOURNISSEUR){
            Personne.personneCourante = null;
            jTextFieldAddPersonneDesignation.setText("");
            jTextFieldAddPersonneAdresse.setText("");
            jTextFieldAddPersonneCA.setText("0");
            jTextFieldAddPersonneRAR.setText("0");
            if(MODE == MODE_CLIENT){
                jLabelAddPersonnePrincipal.setText("Ajout Client");
                jLabelAddPersonnePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Client.png")));
            }else{
                jLabelAddPersonnePrincipal.setText("Ajout Fournisseur");
                jLabelAddPersonnePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Fournisseur.png")));
            }
            jDialogAddPersonne.getRootPane().setDefaultButton(jButtonAddPersonneConfirmer);
            jDialogAddPersonne.setVisible(true);
        }else if(MODE == MODE_ARTICLE_ACHAT || MODE == MODE_ARTICLE_VENTE){
            jButtonBonArticleAddArticleActionPerformed(evt);
        }else if(MODE == MODE_BON_ACHAT || MODE == MODE_BON_VENTE){
            Bon.BonCourant = null;
            setupBonPersonne("Ajout Bon", Date.getTodayDate(), "", null, true);
        }else if(MODE == MODE_CONSO){
            jTabbedPaneAddConso.setEnabledAt(0, true);
            jTabbedPaneAddConso.setEnabledAt(1, true);
            jTabbedPaneAddConso.setSelectedIndex(0);
            jLabelAddGroupeConsoPrincipal.setText("Ajout Groupe");
            jTextFieldAddGroupeConsoDesignation.setText("");
            GroupeConso.groupeCourant = null;
            Consommation.consoCourant = null;
            
            setupAddConso("Nouvelle consommation");
        }else if(MODE == MODE_RECETTE || MODE == MODE_DEPENSE){
            Reglement.reglementCourant = null;
            jDialogRegle.getRootPane().setDefaultButton(jButtonRegleConfirmer);
            setupAddReglement("", "", Date.getTodayDate(), "", null, null);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonAddCompteConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCompteConfirmerActionPerformed
        String mdp = new String(jPasswordFieldAddCompteMDP.getPassword());
        String cmdp = new String(jPasswordFieldAddCompteCMDP.getPassword());
        CompteFinance tmp;
        if(jTextFieldAddCompteNom.getText().isEmpty() || mdp.isEmpty() || cmdp.isEmpty()){
            jLabelOption.setText("Remplir toutes les rubriques");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else if(!jTextFieldAddCompteNom.getText().matches("^[a-zA-Z][a-zA-Z_-]*[a-zA-Z]$") || jTextFieldAddCompteNom.getText().length()>20){
            jLabelOption.setText("Nom de compte trop long ou contient des caractères spéciaux invalides");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else if(!mdp.matches("^[a-zA-Z0-9_.-]{2,20}$")){
            jLabelOption.setText("Mot de passe trop long ou contient des caractères spéciaux invalides");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else if(!mdp.equals(cmdp)){
            jPasswordFieldAddCompteMDP.setText("");
            jLabelOption.setText("Confirmation du mot de passe non identique");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else if(CompteFinance.get(jTextFieldAddCompteNom.getText()) != null){
            jLabelOption.setText("Nom de compte déjà existant");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            tmp = new CompteFinance(jTextFieldAddCompteNom.getText().toLowerCase(),mdp);
            VisDias.listCompteFinance.add(tmp);
            VisDias.addDir("comptes/"+tmp.getIdentifiant());
            jButtonAddCompteAnnulerActionPerformed(evt);
            jLabelOption.setText("Compte crée avec succés");
            JOptionPane.showMessageDialog(null, jLabelOption, "Information", JOptionPane.INFORMATION_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonAddCompteConfirmerActionPerformed

    private void jButtonAddCompteAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCompteAnnulerActionPerformed
        jDialogAddCompte.dispose();
    }//GEN-LAST:event_jButtonAddCompteAnnulerActionPerformed

    private void jButtonCompteConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompteConfirmerActionPerformed
        String mdp = new String(jPasswordFieldCompteMDP.getPassword());
        CompteFinance tmp;
        if(jListCompte.getSelectedValue() == null || mdp.isEmpty()){
            jLabelOption.setText("Selectionnez un compte et/ou remplir toutes les rubriques");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            tmp = CompteFinance.get((String)jListCompte.getSelectedValue());
            if(tmp.authentification(mdp)){
                if(CompteFinance.MODE_COMPTE == CompteFinance.MODE_COMPTE_LOG){
                    boolean deco = true;
                    if(CompteFinance.compteActif == tmp){
                        deco = false;
                        jLabelOption.setText("Vous êtes déjà connecté à ce compte");
                        JOptionPane.showMessageDialog(null, jLabelOption, "Information", JOptionPane.INFORMATION_MESSAGE, null);                
                    }else if(CompteFinance.compteActif != null){
                        int answer = showWarningMessage("Voulez-vous enregistrer avant de changer de compte?");
                        if(answer == JOptionPane.YES_OPTION){
                            VisDias.sauvegarde("comptes/"+CompteFinance.compteActif.getIdentifiant());
                        }else if(answer == JOptionPane.NO_OPTION){
                            
                        }else{
                            deco = false;
                        }
                    }
                    if(deco){
                        CompteFinance.compteActif = tmp;
                        jButtonSauvegarde.setEnabled(true);
                        jButtonAccueilEditCompte.setEnabled(true);
                        jButtonClient.setEnabled(true);
                        jButtonFournisseur.setEnabled(true);
                        jButtonArticleAchat.setEnabled(true);
                        jButtonConso.setEnabled(true);
                        jButtonAchat.setEnabled(true);
                        jButtonArticleVente.setEnabled(true);
                        jButtonVente.setEnabled(true);
                        jButtonRecette.setEnabled(true);
                        jButtonDepense.setEnabled(true);
                        jLabelRubriqueCourante.setText("Compte : " + tmp.getIdentifiant());
                        jLabelOption.setText("Connectée");
                        JOptionPane.showMessageDialog(null, jLabelOption, "Information", JOptionPane.INFORMATION_MESSAGE, null);
                        VisDias.restoration("comptes/"+CompteFinance.compteActif.getIdentifiant());
                    }
                }else if(confirmationRemove() == JOptionPane.NO_OPTION){
                    if(CompteFinance.compteActif == tmp){
                        jButtonSauvegarde.setEnabled(false);
                        jButtonAccueilEditCompte.setEnabled(false);
                        jButtonClient.setEnabled(false);
                        jButtonFournisseur.setEnabled(false);
                        jButtonArticleAchat.setEnabled(false);
                        jButtonConso.setEnabled(false);
                        jButtonAchat.setEnabled(false);
                        jButtonArticleVente.setEnabled(false);
                        jButtonVente.setEnabled(false);
                        jButtonRecette.setEnabled(false);
                        jButtonDepense.setEnabled(false);
                        jLabelRubriqueCourante.setText("Accueil");
                        CompteFinance.compteActif = null;
                    }
                    VisDias.removeDir("comptes/"+tmp.getIdentifiant());
                    tmp.supprimer();
                    jLabelOption.setText("Compte supprimé avec succès");
                    JOptionPane.showMessageDialog(null, jLabelOption, "Information", JOptionPane.INFORMATION_MESSAGE, null);
                }
                jButtonCompteAnnulerActionPerformed(evt);
            }else{
                jLabelOption.setText("Mot de passe incorrect");
                JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }//GEN-LAST:event_jButtonCompteConfirmerActionPerformed

    private void jButtonCompteAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompteAnnulerActionPerformed
        jDialogCompte.dispose();
    }//GEN-LAST:event_jButtonCompteAnnulerActionPerformed

    private void jButtonAddPersonneAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPersonneAnnulerActionPerformed
        jDialogAddPersonne.dispose();
    }//GEN-LAST:event_jButtonAddPersonneAnnulerActionPerformed

    private void jButtonAddPersonneConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPersonneConfirmerActionPerformed
        double tmpCA;   double tmpRAR;
        if(jTextFieldAddPersonneDesignation.getText().isEmpty()
                || jTextFieldAddPersonneAdresse.getText().isEmpty()
                || jTextFieldAddPersonneCA.getText().isEmpty()
                || jTextFieldAddPersonneRAR.getText().isEmpty()){
            jLabelOption.setText("Remplir toutes les rubriques !");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            try{
                tmpCA = VisDias.formatDouble.parse(jTextFieldAddPersonneCA.getText()).doubleValue();
                tmpRAR = VisDias.formatDouble.parse(jTextFieldAddPersonneRAR.getText()).doubleValue();
                
                if(MODE == MODE_CLIENT){
                    if(Personne.personneCourante == null){
                        Client cl = new Client(jTextFieldAddPersonneDesignation.getText(), jTextFieldAddPersonneAdresse.getText(), tmpCA, tmpRAR);
                        VisDias.listClient.add(cl);
                        ((javax.swing.table.DefaultTableModel)jTableBig.getModel()).addRow(cl.displayRow());
                    }else{
                        Personne.personneCourante.modifier(jTextFieldAddPersonneDesignation.getText(), jTextFieldAddPersonneAdresse.getText(), tmpCA, tmpRAR);
                        setupClient(null, false);
                    }
                }else{
                    if(Personne.personneCourante == null){
                        Fournisseur fr = new Fournisseur(jTextFieldAddPersonneDesignation.getText(), jTextFieldAddPersonneAdresse.getText(), tmpCA, tmpRAR);
                        VisDias.listFournisseur.add(fr);
                        ((javax.swing.table.DefaultTableModel)jTableBig.getModel()).addRow(fr.displayRow());
                    }else{
                        Personne.personneCourante.modifier(jTextFieldAddPersonneDesignation.getText(), jTextFieldAddPersonneAdresse.getText(), tmpCA, tmpRAR);
                        setupFournisseur(null, false);
                    }
                }
                jButtonAddPersonneAnnulerActionPerformed(evt);
            }catch(ParseException e){
                jLabelOption.setText("Valeurs numériques invalides");
                JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }//GEN-LAST:event_jButtonAddPersonneConfirmerActionPerformed

    private void jButtonAddArticleAddUniteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddArticleAddUniteActionPerformed
        if(!jTextFieldAddArticleAddUnite.getText().isEmpty()){
            SimpleArticle.RajouterUnite(jTextFieldAddArticleAddUnite.getText());
            jComboBoxAddArticleUnite.addItem(jTextFieldAddArticleAddUnite.getText());
            jComboBoxAddArticleUnite.setSelectedItem(jTextFieldAddArticleAddUnite.getText());
            jTextFieldAddArticleAddUnite.setText("");
        }
    }//GEN-LAST:event_jButtonAddArticleAddUniteActionPerformed

    private void jButtonAddArticleRemoveUniteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddArticleRemoveUniteActionPerformed
        if(jComboBoxAddArticleUnite.getItemCount() > 0){
            SimpleArticle.SupprimerUnite((String)jComboBoxAddArticleUnite.getSelectedItem());
            jComboBoxAddArticleUnite.removeItem((String)jComboBoxAddArticleUnite.getSelectedItem());
        }
    }//GEN-LAST:event_jButtonAddArticleRemoveUniteActionPerformed

    private void jButtonAddArticleAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddArticleAnnulerActionPerformed
        jDialogAddArticle.dispose();
    }//GEN-LAST:event_jButtonAddArticleAnnulerActionPerformed

    private void jButtonAddArticleConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddArticleConfirmerActionPerformed
        int tmpQT;      double tmpUT;    double tmpTva;       Date tmpDate;       SimpleArticle tmpArt;     GroupeArticle tmpBonGrp;
        if(jTextFieldAddArticleDesignation.getText().isEmpty() ||
                  jComboBoxAddArticleUnite.getItemCount() == 0 ||
                    jTextFieldAddArticleQT.getText().isEmpty() ||
                    jTextFieldAddArticlePU.getText().isEmpty() ||
                    jTextFieldAddArticleTVA.getText().isEmpty()){
            jLabelOption.setText("Remplir toutes les rubriques !");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            try{
                tmpQT = VisDias.formatInt.parse(jTextFieldAddArticleQT.getText()).intValue();
                tmpUT = VisDias.formatDouble.parse(jTextFieldAddArticlePU.getText()).doubleValue();
                tmpTva = VisDias.formatDouble.parse(jTextFieldAddArticleTVA.getText()).doubleValue();
                tmpDate = new Date(Integer.parseInt(jSpinnerAddArticleJour.getValue().toString()), 
                                   Integer.parseInt(jSpinnerAddArticleMois.getValue().toString()), 
                                   Integer.parseInt(jSpinnerAddArticleAnnee.getValue().toString()));
                if(MODE == MODE_ARTICLE_ACHAT || MODE == MODE_BON_ACHAT){
                    GroupeArticleAchat tmpGrA = GroupeArticleAchat.get((String)jComboBoxAddArticleGroupe.getSelectedItem());
                    if(SimpleArticle.articleCourant == null){
                        tmpArt = new ArticleAchat(jTextFieldAddArticleDesignation.getText(),
                                                  tmpDate, (String)jComboBoxAddArticleUnite.getSelectedItem(),
                                                  tmpQT, tmpUT, tmpTva);
                        tmpGrA.refArticle.add(tmpArt.code);
                        VisDias.listArticleAchat.add((ArticleAchat)tmpArt);
                        if(MODE == MODE_ARTICLE_ACHAT)
                            setupGroupeAchat(GroupeArticleAchat.groupeAchatActif, null, null, null, false, tmpGrA == GroupeArticleAchat.groupeAchatActif);
                        else if(tmpGrA == GroupeArticleAchat.get((String)jComboBoxBonArticleGroupe.getSelectedItem()))
                            ((javax.swing.table.DefaultTableModel)jTableBonArticle1.getModel()).addRow(tmpArt.displayRow());
                    }else{
                        SimpleArticle.articleCourant.modifier(jTextFieldAddArticleDesignation.getText(),
                                                              tmpDate, (String)jComboBoxAddArticleUnite.getSelectedItem(),
                                                              tmpQT, tmpUT, tmpTva, tmpUT + tmpUT*tmpTva/100);
                        if(MODE == MODE_ARTICLE_ACHAT){
                            if(GroupeArticleAchat.groupeAchatActif != tmpGrA){
                                GroupeArticleAchat.groupeAchatActif.refArticle.remove(SimpleArticle.articleCourant.code);
                                tmpGrA.refArticle.add(SimpleArticle.articleCourant.code);
                            }
                            setupGroupeAchat(GroupeArticleAchat.groupeAchatActif, null, null, null, false, true);
                        }else{
                            tmpBonGrp = GroupeArticleAchat.get((String)jComboBoxBonArticleGroupe.getSelectedItem());
                            if(tmpBonGrp != tmpGrA){
                                tmpBonGrp.refArticle.remove(SimpleArticle.articleCourant.code);
                                tmpGrA.refArticle.add(SimpleArticle.articleCourant.code);
                            }
                            jTableBonArticle1.setModel(new javax.swing.table.DefaultTableModel(
                                    ArticleAchat.display(GroupeArticleAchat.get((String)jComboBoxBonArticleGroupe.getSelectedItem()), null, null, null, false),
                                    SimpleArticle.colonne()
                                )
                                {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false, false};
                                    public boolean isCellEditable(int rowIndex, int columnIndex){
                                        return canEdit [columnIndex];
                                    }
                                }
                            );
                            jTableBonArticle1.getTableHeader().setReorderingAllowed(false);
                            centerAlignCell(jTableBonArticle1, new int[]{0, 2, 3, 4, 6});
                            rightAlignCell(jTableBonArticle1, new int[]{5, 7});
                            centerHeader(jTableBonArticle1);
                            if (jTableBonArticle1.getColumnModel().getColumnCount() > 0) {
                                jTableBonArticle1.getColumnModel().getColumn(0).setResizable(false);
                                jTableBonArticle1.getColumnModel().getColumn(0).setMaxWidth(100);
                            }
                        }
                    }
                }else if(MODE == MODE_ARTICLE_VENTE || MODE == MODE_BON_VENTE){
                    GroupeArticleVente tmpGrV = GroupeArticleVente.get((String)jComboBoxAddArticleGroupe.getSelectedItem());
                    if(SimpleArticle.articleCourant == null){
                        tmpArt = new ArticleVente(jTextFieldAddArticleDesignation.getText(),
                                                  tmpDate, (String)jComboBoxAddArticleUnite.getSelectedItem(),
                                                  tmpQT, tmpUT, tmpTva);
                        tmpGrV.refArticle.add(tmpArt.code);
                        VisDias.listArticleVente.add((ArticleVente)tmpArt);
                        if(MODE == MODE_ARTICLE_VENTE){
                            setupGroupeVente(GroupeArticleVente.groupeVenteActif, null, null, null, tmpGrV == GroupeArticleVente.groupeVenteActif, false);
                        }else if(tmpGrV == GroupeArticleVente.get((String)jComboBoxBonArticleGroupe.getSelectedItem()))
                            ((javax.swing.table.DefaultTableModel)jTableBonArticle1.getModel()).addRow(tmpArt.displayRow());
                    }else{
                        SimpleArticle.articleCourant.modifier(jTextFieldAddArticleDesignation.getText(),
                                                              tmpDate, (String)jComboBoxAddArticleUnite.getSelectedItem(),
                                                              tmpQT, tmpUT, tmpTva, tmpUT + tmpUT*tmpTva/100);
                        if(MODE == MODE_ARTICLE_VENTE){
                            if(GroupeArticleVente.groupeVenteActif != tmpGrV){
                                GroupeArticleVente.groupeVenteActif.refArticle.remove(SimpleArticle.articleCourant.code);
                                tmpGrV.refArticle.add(SimpleArticle.articleCourant.code);
                            }
                            setupGroupeVente(GroupeArticleVente.groupeVenteActif, null, null, null, false, true);
                        }else{
                            tmpBonGrp = GroupeArticleVente.get((String)jComboBoxBonArticleGroupe.getSelectedItem());
                            if(tmpBonGrp != tmpGrV){
                                tmpBonGrp.refArticle.remove(SimpleArticle.articleCourant.code);
                                tmpGrV.refArticle.add(SimpleArticle.articleCourant.code);
                            }
                            jTableBonArticle1.setModel(new javax.swing.table.DefaultTableModel(
                                    ArticleVente.display(GroupeArticleVente.get((String)jComboBoxBonArticleGroupe.getSelectedItem()), null, null, null, false),
                                    SimpleArticle.colonne()
                                )
                                {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false, false};
                                    public boolean isCellEditable(int rowIndex, int columnIndex){
                                        return canEdit [columnIndex];
                                    }
                                }
                            );
                            jTableBonArticle1.getTableHeader().setReorderingAllowed(false);
                            centerAlignCell(jTableBonArticle1, new int[]{0, 2, 3, 4, 6});
                            rightAlignCell(jTableBonArticle1, new int[]{5, 7});
                            centerHeader(jTableBonArticle1);
                            if (jTableBonArticle1.getColumnModel().getColumnCount() > 0) {
                                jTableBonArticle1.getColumnModel().getColumn(0).setResizable(false);
                                jTableBonArticle1.getColumnModel().getColumn(0).setMaxWidth(100);
                            }
                        }
                    }
                }
                jButtonAddArticleAnnulerActionPerformed(evt);
            }catch(ParseException e){
                jLabelOption.setText("Valeurs numériques invalides !");
                JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }//GEN-LAST:event_jButtonAddArticleConfirmerActionPerformed

    private void jButtonAddGroupeAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddGroupeAnnulerActionPerformed
        jDialogAddArticle.dispose();
    }//GEN-LAST:event_jButtonAddGroupeAnnulerActionPerformed

    private void jButtonAddGroupeConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddGroupeConfirmerActionPerformed
        if(jTextFieldAddGroupeDesignation.getText().isEmpty()){
            jLabelOption.setText("Remplir toutes les rubriques");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else if((MODE == MODE_ARTICLE_ACHAT || MODE == MODE_BON_ACHAT) && GroupeArticleAchat.get(jTextFieldAddGroupeDesignation.getText())!=null){
            jLabelOption.setText("Ce nom de groupe est déjà pris");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else if((MODE == MODE_ARTICLE_VENTE || MODE == MODE_BON_VENTE) && GroupeArticleVente.get(jTextFieldAddGroupeDesignation.getText())!=null){
            jLabelOption.setText("Ce nom de groupe est déjà pris");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            if(MODE == MODE_ARTICLE_ACHAT || MODE == MODE_BON_ACHAT){
                if(GroupeArticle.groupeCourant != null){
                    GroupeArticle.groupeCourant.modifier(jTextFieldAddGroupeDesignation.getText());
                    if(MODE == MODE_ARTICLE_ACHAT)
                        setupGroupeAchat(null, null, null, null, false, true);
                    else
                        jComboBoxBonArticleGroupe.setModel(new javax.swing.DefaultComboBoxModel(GroupeArticleAchat.displayCombo()));
                }else{
                    GroupeArticleAchat grpA = new GroupeArticleAchat(jTextFieldAddGroupeDesignation.getText());
                    VisDias.listGroupeArticleAchat.add(grpA);
                    if(MODE == MODE_ARTICLE_ACHAT)
                        ((javax.swing.table.DefaultTableModel)jTableSmall1.getModel()).addRow(grpA.displayRow());
                    else
                        jComboBoxBonArticleGroupe.setModel(new javax.swing.DefaultComboBoxModel(GroupeArticleAchat.displayCombo()));
                }
            }else if(MODE == MODE_ARTICLE_VENTE || MODE == MODE_BON_VENTE){
                if(GroupeArticle.groupeCourant != null){
                    GroupeArticle.groupeCourant.modifier(jTextFieldAddGroupeDesignation.getText());
                    if(MODE == MODE_ARTICLE_VENTE)
                        setupGroupeVente(null, null, null, null, false, true);
                    else
                        jComboBoxBonArticleGroupe.setModel(new javax.swing.DefaultComboBoxModel(GroupeArticleVente.displayCombo()));
                }else{
                    GroupeArticleVente grpV = new GroupeArticleVente(jTextFieldAddGroupeDesignation.getText());
                    VisDias.listGroupeArticleVente.add(grpV);
                    if(MODE == MODE_ARTICLE_VENTE)
                        ((javax.swing.table.DefaultTableModel)jTableSmall1.getModel()).addRow(grpV.displayRow());
                    else
                        jComboBoxBonArticleGroupe.setModel(new javax.swing.DefaultComboBoxModel(GroupeArticleVente.displayCombo()));
                }
            }
            if(MODE == MODE_BON_ACHAT || MODE == MODE_BON_VENTE){
                jComboBoxBonArticleGroupe.setSelectedItem((String)jTextFieldAddGroupeDesignation.getText());
                jTableBonArticle1.setModel(new javax.swing.table.DefaultTableModel(
                        ArticleVente.display(null, null, null, null, false),
                        ArticleVente.colonne()
                    )
                    {boolean[] canEdit = new boolean [] {false, false, false, false, false, false};
                        public boolean isCellEditable(int rowIndex, int columnIndex){
                            return canEdit [columnIndex];
                        }
                    }
                );
                jTableBonArticle1.getTableHeader().setReorderingAllowed(false);
                centerAlignCell(jTableBonArticle1, new int[]{0, 2, 3, 4, 6});
                rightAlignCell(jTableBonArticle1, new int[]{5, 7});
                centerHeader(jTableBonArticle1);
                if (jTableBonArticle1.getColumnModel().getColumnCount() > 0){
                    jTableBonArticle1.getColumnModel().getColumn(0).setResizable(false);
                    jTableBonArticle1.getColumnModel().getColumn(0).setMaxWidth(100);
                }
            }
            jButtonAddGroupeAnnulerActionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonAddGroupeConfirmerActionPerformed

    private void jButtonBonPersonneAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBonPersonneAnnulerActionPerformed
        jDialogBonPersonne.dispose();
    }//GEN-LAST:event_jButtonBonPersonneAnnulerActionPerformed

    private void jButtonBonPersonneSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBonPersonneSuivantActionPerformed
        Bon bn;
        int row = jTableBonPersonne.getSelectedRow();
        if(jTextFieldBonPersonneDesignation.getText().isEmpty() || row == -1){
            jLabelOption.setText("Remplir toutes les rubriques et/ou choisir une ligne dans la table");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            Date tmpDate = new Date((int)jSpinnerBonPersonneJour.getValue(),
                                    (int)jSpinnerBonPersonneMois.getValue(),
                                    (int)jSpinnerBonPersonneAnnee.getValue());
            if(Bon.BonCourant == null){
                if(MODE == MODE_BON_ACHAT){
                    bn = new BonAchat(jTextFieldBonPersonneDesignation.getText(), tmpDate, (String)jTableBonPersonne.getValueAt(row, 0));
                    VisDias.listBonAchat.add((BonAchat)bn);
                    Bon.BonCourant = bn;
                    setupAchat(null, null, null, true, null);
                    setupBon(bn, VisDias.listGroupeArticleAchat.get(0), 0.0, 0.0, false);
                }else if(MODE == MODE_BON_VENTE){
                    bn = new BonVente(jTextFieldBonPersonneDesignation.getText(), tmpDate, (String)jTableBonPersonne.getValueAt(row, 0));
                    VisDias.listBonVente.add((BonVente)bn);
                    Bon.BonCourant= bn;
                    setupVente(null, null, null, true, null);
                    setupBon(bn, VisDias.listGroupeArticleVente.get(0), 0.0, 0.0, false);
                }
            }else{
                Bon.BonCourant.modifier(jTextFieldBonPersonneDesignation.getText(), tmpDate, -1.0, -1.0);
                if(MODE == MODE_BON_ACHAT){
                    setupAchat(null, null, null, true, null);
                    setupBon(Bon.BonCourant, VisDias.listGroupeArticleAchat.get(0),
                             -1,
                             -1,
                             true);
                }else if(MODE == MODE_BON_VENTE){
                    setupVente(null, null, null, true, null);
                    setupBon(Bon.BonCourant, VisDias.listGroupeArticleVente.get(0),
                             -1,
                             -1,
                             true);
                }
            }
            jButtonBonPersonneAnnulerActionPerformed(evt);
            jDialogBonArticle.getRootPane().setDefaultButton(jButtonBonArticleConfirmer);
            jDialogBonArticle.setVisible(true);
        }
    }//GEN-LAST:event_jButtonBonPersonneSuivantActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        if(MODE == MODE_CLIENT || MODE == MODE_FOURNISSEUR){
            if(jTableBig.getSelectedRows().length == 1){
                int row = jTableBig.getSelectedRow();
                if(MODE == MODE_CLIENT){
                    Personne.personneCourante = Client.get((String)jTableBig.getValueAt(row, 0));
                    jLabelAddPersonnePrincipal.setText("Modifier Client");
                    jLabelAddPersonnePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Client.png")));
                }else{
                    Personne.personneCourante = Fournisseur.get((String)jTableBig.getValueAt(row, 0));
                    jLabelAddPersonnePrincipal.setText("Modifier Fournisseur");
                    jLabelAddPersonnePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Fournisseur.png")));
                }
                jTextFieldAddPersonneDesignation.setText(Personne.personneCourante.designation);
                jTextFieldAddPersonneAdresse.setText(Personne.personneCourante.adresse);
                jTextFieldAddPersonneCA.setText(VisDias.formatDouble.format(Personne.personneCourante.chiffreAffaire));
                jTextFieldAddPersonneRAR.setText(VisDias.formatDouble.format(Personne.personneCourante.resteRegler));
                
                jDialogAddPersonne.getRootPane().setDefaultButton(jButtonAddPersonneConfirmer);
                jDialogAddPersonne.setVisible(true);
            }
        }else if(MODE == MODE_RECETTE || MODE == MODE_DEPENSE){
            if(jTableBig.getSelectedRows().length == 1){
                int row = jTableBig.getSelectedRow();
                Reglement reg;
                if(MODE == MODE_RECETTE){
                    reg = Recette.get((String)jTableBig.getValueAt(row, 0));
                }else{
                    reg = Depense.get((String)jTableBig.getValueAt(row, 0));
                }
                Reglement.reglementCourant = reg;
                
                setupAddReglement(reg.designation, reg.personne, reg.date, VisDias.formatDouble.format(reg.montant),
                                  reg.modeReg, reg.refCB);
            }
        }else if(jTableSmall1.getSelectedRows().length == 1 || jTableSmall2.getSelectedRows().length == 1){
            int row;
            if(jTableSmall2.getSelectedRows().length == 1){
                row = jTableSmall2.getSelectedRow();
                if(MODE == MODE_ARTICLE_ACHAT || MODE == MODE_ARTICLE_VENTE){
                    jTabbedPaneAddArticle.setEnabledAt(0, false);
                    jTabbedPaneAddArticle.setEnabledAt(1, true);
                    jTabbedPaneAddArticle.setSelectedIndex(1);
                    if(MODE == MODE_ARTICLE_ACHAT){
                        SimpleArticle.articleCourant = ArticleAchat.get((String)jTableSmall2.getValueAt(row, 0));
                        jComboBoxAddArticleUnite.setSelectedItem(SimpleArticle.articleCourant.unite);
                        setupAddArticle("Article",
                                        "Modifier Article D'Achat",
                                        GroupeArticleAchat.displayCombo(),
                                        GroupeArticleAchat.groupeAchatActif,
                                        SimpleArticle.articleCourant.designation,
                                        SimpleArticle.articleCourant.dateCreation,
                                        SimpleArticle.articleCourant.unite,
                                        VisDias.formatInt.format(SimpleArticle.articleCourant.quantiteStock),
                                        VisDias.formatDouble.format(SimpleArticle.articleCourant.prixUT),
                                        VisDias.formatDouble.format(SimpleArticle.articleCourant.tva));
                    }else{
                        SimpleArticle.articleCourant = ArticleVente.get((String)jTableSmall2.getValueAt(row, 0));
                        jComboBoxAddArticleUnite.setSelectedItem(SimpleArticle.articleCourant.unite);
                        setupAddArticle("Production",
                                        "Modifier Article Production",
                                        GroupeArticleVente.displayCombo(),
                                        GroupeArticleVente.groupeVenteActif,
                                        SimpleArticle.articleCourant.designation,
                                        SimpleArticle.articleCourant.dateCreation,
                                        SimpleArticle.articleCourant.unite,
                                        VisDias.formatInt.format(SimpleArticle.articleCourant.quantiteStock),
                                        VisDias.formatDouble.format(SimpleArticle.articleCourant.prixUT),
                                        VisDias.formatDouble.format(SimpleArticle.articleCourant.tva));
                    }
                }else if(MODE == MODE_CONSO){
                    Consommation.consoCourant = Consommation.get((String)jTableSmall2.getValueAt(row, 0));
                    setupAddConso1("Modifier consommation",
                                   GroupeConso.GroupeConsoActif.designation,
                                   Consommation.consoCourant.dateConso,
                                   Consommation.consoCourant.designation,
                                   Consommation.consoCourant.unite,
                                   VisDias.formatInt.format(Consommation.consoCourant.quantite),
                                   Consommation.consoCourant.typeConso,
                                   VisDias.formatInt.format(Consommation.consoCourant.quantiteUT),
                                   VisDias.formatDouble.format(Consommation.consoCourant.prixUT),
                                   VisDias.formatDouble.format(Consommation.consoCourant.prixTT),
                                   Consommation.consoCourant.refArticle == null
                            );
                }
            }else{
                row = jTableSmall1.getSelectedRow();
                if(MODE == MODE_ARTICLE_ACHAT || MODE == MODE_ARTICLE_VENTE){
                    jTabbedPaneAddArticle.setEnabledAt(0, true);
                    jTabbedPaneAddArticle.setEnabledAt(1, false);
                    jTabbedPaneAddArticle.setSelectedIndex(0);
                    jLabelAddGroupePrincipal.setText("Modifier Groupe");
                    if(MODE == MODE_ARTICLE_ACHAT)
                        GroupeArticle.groupeCourant = GroupeArticleAchat.get((String)jTableSmall1.getValueAt(row, 0));
                    else
                        GroupeArticle.groupeCourant = GroupeArticleVente.get((String)jTableSmall1.getValueAt(row, 0));
                    jTextFieldAddGroupeDesignation.setText(GroupeArticle.groupeCourant.designation);
                   
                    jDialogAddArticle.setVisible(true);
                }else if(MODE == MODE_BON_ACHAT || MODE == MODE_BON_VENTE){
                    if(MODE == MODE_BON_ACHAT){
                        Bon.BonCourant = BonAchat.get((String)jTableSmall1.getValueAt(row, 0));
                    }else{
                        Bon.BonCourant = BonVente.get((String)jTableSmall1.getValueAt(row, 0));
                    }
                    setupBonPersonne("Modifier Bon", Bon.BonCourant.dateCreation, Bon.BonCourant.designation, Bon.BonCourant.refPersonne, false);
                }else if(MODE == MODE_CONSO){
                    GroupeConso.groupeCourant = GroupeConso.get((String)jTableSmall1.getValueAt(row, 0));
                    jTabbedPaneAddConso.setEnabledAt(0, true);
                    jTabbedPaneAddConso.setEnabledAt(1, false);
                    jTabbedPaneAddConso.setSelectedIndex(0);
                    jLabelAddGroupeConsoPrincipal.setText("Modifier Groupe");
                    jTextFieldAddGroupeConsoDesignation.setText(GroupeConso.groupeCourant.designation);

                    setupAddConso("Nouvelle consommation");
                }
            }
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonCoordonneAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCoordonneAnnulerActionPerformed
        jDialogCoordonnee.dispose();
    }//GEN-LAST:event_jButtonCoordonneAnnulerActionPerformed

    private void jButtonCoordonneConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCoordonneConfirmerActionPerformed
        CompteFinance.compteActif.getCrd().modifier(jTextFieldCoordonneeCevilite.getText(),
                                                        jTextFieldCoordonneeDesignation.getText(),
                                                        jTextFieldCoordonneeAdresse.getText(),
                                                        jTextFieldCoordonneeTel.getText(), 
                                                        jTextFieldCoordonneeRC.getText(), 
                                                        jTextFieldCoordonneeArt.getText(), 
                                                        jTextFieldCoordonneeNIF.getText(), 
                                                        jTextFieldCoordonneeNIS.getText(), 
                                                        jTextFieldCoordonneeCptBanque.getText(), 
                                                        jTextFieldCoordonneeFonction.getText());
        
        jButtonCoordonneAnnulerActionPerformed(evt);
    }//GEN-LAST:event_jButtonCoordonneConfirmerActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        int[] rows;
        if(MODE == MODE_CLIENT || MODE == MODE_FOURNISSEUR){
            rows = jTableBig.getSelectedRows();
            if(rows.length > 0){
                if(confirmationRemove() == JOptionPane.NO_OPTION){
                    Personne tmpPer;
                    if(MODE == MODE_CLIENT){
                        for(int i : rows){
                            tmpPer = Client.get((String)jTableBig.getValueAt(i, 0));
                            tmpPer.supprimer();
                            VisDias.listCorbeille.push(tmpPer);
                        }
                        setupClient(null, false);
                    }else{
                        for(int i : rows){
                            tmpPer = Fournisseur.get((String)jTableBig.getValueAt(i, 0));
                            tmpPer.supprimer();
                            VisDias.listCorbeille.push(tmpPer);
                        }
                        setupFournisseur(null, false);
                    }
                }
            }
        }else if(MODE == MODE_ARTICLE_ACHAT || MODE == MODE_ARTICLE_VENTE){
            rows = jTableSmall2.getSelectedRows();
            if(rows.length > 0){                // Remove article
                if(confirmationRemove() == JOptionPane.NO_OPTION){
                    SimpleArticle tmpArt;
                    if(MODE == MODE_ARTICLE_ACHAT){
                        for(int i : rows){
                            tmpArt = ArticleAchat.get((String)jTableSmall2.getValueAt(i, 0));
                            GroupeArticleAchat.groupeAchatActif.refArticle.remove(tmpArt.code);
                            tmpArt.supprimer();
                            VisDias.listCorbeille.push(tmpArt);
                        }
                        setupGroupeAchat(GroupeArticleAchat.groupeAchatActif, null, null, null, false, true);
                    }else{
                        for(int i : rows){
                            tmpArt = ArticleVente.get((String)jTableSmall2.getValueAt(i, 0));
                            GroupeArticleVente.groupeVenteActif.refArticle.remove(tmpArt.code);
                            tmpArt.supprimer();
                            VisDias.listCorbeille.push(tmpArt);
                        }
                    setupGroupeVente(GroupeArticleVente.groupeVenteActif, null, null, null, false, true);
                    }
                }
            }else{
                rows = jTableSmall1.getSelectedRows();
                if(rows.length > 0){            // Remove groupe
                    if(confirmationRemove() == JOptionPane.NO_OPTION){
                        GroupeArticle tmpGrp;
                        if(MODE == MODE_ARTICLE_ACHAT){
                            for(int i : rows){
                                tmpGrp = GroupeArticleAchat.get((String)jTableSmall1.getValueAt(i, 0));
                                if(!tmpGrp.refArticle.isEmpty()){
                                    ArticleAchat artA;
                                    for(String code : tmpGrp.refArticle){
                                        artA = ArticleAchat.get(code);
                                        if(artA != null){
                                            artA.supprimer();
                                        }
                                    }
                                    tmpGrp.refArticle.clear();
                                }
                                if(VisDias.listGroupeArticleAchat.indexOf(tmpGrp) == 0){
                                    jLabelOption.setText("Impossible de supprimer ce groupe");
                                    JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
                                }else{
                                    tmpGrp.supprimer();
                                    VisDias.listCorbeille.push(tmpGrp);
                                }
                            }
                            GroupeArticleAchat.groupeAchatActif = null;
                            setupGroupeAchat(null, null, null, null, false, true);
                        }else{
                            for(int i : rows){
                                tmpGrp = GroupeArticleVente.get((String)jTableSmall1.getValueAt(i, 0));
                                
                                if(!tmpGrp.refArticle.isEmpty()){
                                    ArticleVente artV;
                                    for(String code : tmpGrp.refArticle){
                                        artV = ArticleVente.get(code);
                                        if(artV != null){
                                            artV.supprimer();
                                        }
                                    }
                                    tmpGrp.refArticle.clear();
                                }
                                if(VisDias.listGroupeArticleVente.indexOf(tmpGrp) == 0){
                                    jLabelOption.setText("Impossible de supprimer ce groupe");
                                    JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
                                }else{
                                    tmpGrp.supprimer();
                                    VisDias.listCorbeille.push(tmpGrp);
                                }
                            }
                            GroupeArticleVente.groupeVenteActif = null;
                            setupGroupeVente(null, null, null, null, false, true);
                        }
                    }
                }
            }
        }else if(MODE == MODE_BON_ACHAT || MODE == MODE_BON_VENTE){
            rows = jTableSmall1.getSelectedRows();
            if(rows.length > 0){
                if(confirmationRemove() == JOptionPane.NO_OPTION){
                    if(MODE == MODE_BON_ACHAT){
                        BonAchat tmp;
                        for(int i : rows){
                            tmp = BonAchat.get((String)jTableSmall1.getValueAt(i, 0));
                            tmp.supprimer();
                            VisDias.listCorbeille.push(tmp);
                        }
                        BonAchat.BonActif = null;
                        setupAchat(null, null, null, true, null);
                    }else{
                        BonVente tmp;
                        for(int i : rows){
                            tmp = BonVente.get((String)jTableSmall1.getValueAt(i, 0));
                            tmp.supprimer();
                            VisDias.listCorbeille.push(tmp);
                        }
                        BonVente.BonActif = null;
                        setupVente(null, null, null, true, null);
                    }
                }
            }
        }else if(MODE == MODE_CONSO){
            rows = jTableSmall2.getSelectedRows();
            if(rows.length > 0){
                if(confirmationRemove() == JOptionPane.NO_OPTION){
                    Consommation tmp;
                    for(int i : rows){
                        tmp = Consommation.get((String)jTableSmall2.getValueAt(i, 0));
                        GroupeConso.GroupeConsoActif.refArticle.remove(tmp.code);
                        tmp.supprimer();
                        VisDias.listCorbeille.push(tmp);
                    }
                    setupGroupeConso(GroupeConso.GroupeConsoActif, null, null, null, true);
                }
            }else{
                rows = jTableSmall1.getSelectedRows();
                if(rows.length > 0){
                    if(confirmationRemove() == JOptionPane.NO_OPTION){
                        GroupeConso tmp;
                        for(int i : rows){
                            tmp = GroupeConso.get((String)jTableSmall1.getValueAt(i, 0));
                            if(!tmp.refArticle.isEmpty()){
                                Consommation tmpConso;
                                for(String code : tmp.refArticle){
                                    tmpConso = Consommation.get(code);
                                    if(tmpConso != null){
                                        tmpConso.supprimer();
                                    } 
                                }
                                tmp.refArticle.clear();
                            }
                            if(VisDias.listGroupeConso.indexOf(tmp) == 0){
                                jLabelOption.setText("Impossible de supprimer ce groupe");
                                JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);                                
                            }else{
                                tmp.supprimer();
                                VisDias.listCorbeille.push(tmp);
                            }
                        }
                        GroupeConso.GroupeConsoActif = null;
                        setupGroupeConso(null, null, null, null, true);
                    }
                }
            }
        }else if(MODE == MODE_RECETTE || MODE == MODE_DEPENSE){
            rows = jTableBig.getSelectedRows();
            if (rows.length > 0){
                if(confirmationRemove() == JOptionPane.NO_OPTION){
                    Reglement tmp;
                    if(MODE == MODE_RECETTE){
                        for(int i : rows){
                            tmp = Recette.get((String)jTableBig.getValueAt(i, 0));
                            ((Recette)tmp).supprimer();
                            VisDias.listCorbeille.push(tmp);
                        }
                        setupRecette(null, null, null, null, null);
                    }else{
                        for(int i : rows){
                            tmp = Depense.get((String)jTableBig.getValueAt(i, 0));
                            ((Depense)tmp).supprimer();
                            VisDias.listCorbeille.push(tmp);
                        }
                        setupDepense(null, null, null, null, null);
                    }
                }
            }
        }
        if(!VisDias.listCorbeille.isEmpty())
            jButtonUndo.setEnabled(true);
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimerActionPerformed
        int[] rows = jTableSmall1.getSelectedRows();
        if(MODE == MODE_BON_VENTE){
            if(Bon.BonActif != null){
                Bon.BonCourant = Bon.BonActif;
                jDialogImprimer.getRootPane().setDefaultButton(jButtonImprimerConfirmer);
                jDialogImprimer.setVisible(true);
            }else if(rows.length == 1){
                Bon.BonCourant = BonVente.get((String)jTableSmall1.getValueAt(jTableSmall1.getSelectedRow(), 0));
                jDialogImprimer.getRootPane().setDefaultButton(jButtonImprimerConfirmer);
                jDialogImprimer.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButtonImprimerActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(CompteFinance.compteActif != null){
            int answer = showWarningMessage("Voulez-vous enregistrer avant de quitter?");
            if(answer == JOptionPane.YES_OPTION){
                VisDias.sauvegarde("comptes/"+CompteFinance.compteActif.getIdentifiant());
                VisDias.sauvegardeCompte();
                dispose();
            }else if(answer == JOptionPane.NO_OPTION){
                VisDias.sauvegardeCompte();
                dispose();
            } 
        }else{
            VisDias.sauvegardeCompte();
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButtonRapportBonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRapportBonAnnulerActionPerformed
        jDialogRapportBon.dispose();
    }//GEN-LAST:event_jButtonRapportBonAnnulerActionPerformed

    private void jButtonRapportBonConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRapportBonConfirmerActionPerformed
        boolean bool1 = true, bool2 = false;
        Date dateDu = null;
        Date dateAu = null;
        try{
            if(jCheckBoxRapportBonDate.isSelected()){
                dateDu = new Date((int)jSpinnerRapportBonDateDuJour.getValue(),
                                  (int)jSpinnerRapportBonDateDuMois.getValue(),
                                  (int)jSpinnerRapportBonDateDuAnnee.getValue());
                dateAu = new Date((int)jSpinnerRapportBonDateAuJour.getValue(),
                                  (int)jSpinnerRapportBonDateAuMois.getValue(),
                                  (int)jSpinnerRapportBonDateAuAnnee.getValue());
                bool2 = dateDu.compareTo(dateAu) == 1;
            }
        }catch(Exception e){
            e.printStackTrace();
            bool1 = false;
        }
        if(!bool1){
            jLabelOption.setText("Valeurs numériques invalides");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else if(bool2){
            jLabelOption.setText("Intervalle de date erroné");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            String desig = jTextFieldRapportBonDesignation.getText();
            String refPer = (String)jComboBoxRapportBonPersonne.getSelectedItem();
            if(desig.isEmpty())
                desig = null;
            if(refPer.equals("Tous"))
                refPer = null;
            else
                refPer = refPer.substring(0, 7);
            
            jButtonRapportBonAnnulerActionPerformed(evt);
            if(MODE == MODE_BON_ACHAT){
                Bon.BonActif = null;
                setupAchat(desig, dateDu, dateAu, true, refPer);
                calculRapportBon(dateDu, dateAu);
            }else if(MODE == MODE_BON_VENTE){
                Bon.BonActif = null;
                setupVente(desig, dateDu, dateAu, true, refPer);
                calculRapportBon(dateDu, dateAu);
            }
        }
    }//GEN-LAST:event_jButtonRapportBonConfirmerActionPerformed

    private void jButtonResultatBonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResultatBonOkActionPerformed
        jDialogResultatBon.dispose();
        if(MODE == MODE_BON_ACHAT){
            setupAchat(null, null, null, true, null);
        }else if(MODE == MODE_BON_VENTE){
            setupVente(null, null, null, true, null);
        }
    }//GEN-LAST:event_jButtonResultatBonOkActionPerformed

    private void jButtonResultatArticleOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResultatArticleOkActionPerformed
        jDialogResultatArticle.dispose();
        if(MODE == MODE_ARTICLE_ACHAT){
            setupArticleAchat(GroupeArticleAchat.groupeAchatActif, null, null, null, false);
        }else if(MODE == MODE_ARTICLE_VENTE){
            setupArticleVente(GroupeArticleVente.groupeVenteActif, null, null, null, false);
        }
    }//GEN-LAST:event_jButtonResultatArticleOkActionPerformed

    private void jButtonResultatPersonneOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResultatPersonneOkActionPerformed
        jDialogResultatPersonne.dispose();
        if(MODE == MODE_CLIENT){
            setupClient(null, false);
        }else if(MODE == MODE_FOURNISSEUR){
            setupFournisseur(null, false);
        }
    }//GEN-LAST:event_jButtonResultatPersonneOkActionPerformed

    private void jButtonRapportArticleAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRapportArticleAnnulerActionPerformed
        jDialogRapportArticle.dispose();
    }//GEN-LAST:event_jButtonRapportArticleAnnulerActionPerformed

    private void jButtonRapportPersonneConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRapportPersonneConfirmerActionPerformed
        boolean bool1 = true;
        
        String desig = jTextFieldRapportPersonneDesignation.getText();
        if(desig.isEmpty())
            desig = null;
        bool1 = jCheckBoxRapportPersonneRAR.isSelected();
             
        jButtonRapportPersonneAnnulerActionPerformed(evt);
        if(MODE == MODE_CLIENT){
            setupClient(desig, bool1);
            calculRapportPersonne();
        }else if(MODE == MODE_FOURNISSEUR){
            setupFournisseur(desig, bool1);
            calculRapportPersonne();
        }
        
        
    }//GEN-LAST:event_jButtonRapportPersonneConfirmerActionPerformed

    private void jButtonRapportPersonneAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRapportPersonneAnnulerActionPerformed
        jDialogRapportPersonne.dispose();
    }//GEN-LAST:event_jButtonRapportPersonneAnnulerActionPerformed

    private void jButtonRapportArticleConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRapportArticleConfirmerActionPerformed
        boolean bool1 = true, bool2 = false;
        Date dateDu = null;
        Date dateAu = null;
        try{
            if(jCheckBoxRapportArticleDate.isSelected()){
                dateDu = new Date((int)jSpinnerRapportArticleDateDuJour.getValue(),
                                  (int)jSpinnerRapportArticleDateDuMois.getValue(),
                                  (int)jSpinnerRapportArticleDateDuAnnee.getValue());
                dateAu = new Date((int)jSpinnerRapportArticleDateAuJour.getValue(),
                                  (int)jSpinnerRapportArticleDateAuMois.getValue(),
                                  (int)jSpinnerRapportArticleDateAuAnnee.getValue());
                bool2 = dateDu.compareTo(dateAu) == 1;
            }
        }catch(Exception e){
            e.printStackTrace();
            bool1 = false;
        }
        if(!bool1){
            jLabelOption.setText("Valeurs numériques invalides");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else if(bool2){
            jLabelOption.setText("Intervalle de date erroné");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            String desig = jTextFieldRapportArticleDesignation.getText();
            if(desig.isEmpty())
                desig = null;
            bool2 = jCheckBoxRapportArticleQt.isSelected();
             
            jButtonRapportArticleAnnulerActionPerformed(evt);
            if(MODE == MODE_ARTICLE_ACHAT){
                setupArticleAchat(VisDias.listGroupeArticleAchat, desig, dateDu, dateAu, bool2);
                calculRapportArticle(dateDu, dateAu);
            }else if(MODE == MODE_ARTICLE_VENTE){
                setupArticleVente(VisDias.listGroupeArticleVente, desig, dateDu, dateAu, bool2);
                calculRapportArticle(dateDu, dateAu);
            }
        }
    }//GEN-LAST:event_jButtonRapportArticleConfirmerActionPerformed

    private void jButtonBonArticleModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBonArticleModifierActionPerformed
        if(jTableBonArticle1.getSelectedRows().length == 1){
            int row = jTableBonArticle1.getSelectedRow();
            jTabbedPaneAddArticle.setEnabledAt(0, false);
            jTabbedPaneAddArticle.setEnabledAt(1, true);
            jTabbedPaneAddArticle.setSelectedIndex(1);
            if(MODE == MODE_BON_ACHAT){
                SimpleArticle.articleCourant = ArticleAchat.get((String)jTableBonArticle1.getValueAt(row, 0));
                jComboBoxAddArticleUnite.setSelectedItem(SimpleArticle.articleCourant.unite);
                setupAddArticle("Article",
                    "Modifier Article D'Achat",
                    GroupeArticleAchat.displayCombo(),
                    GroupeArticleAchat.get((String)jComboBoxBonArticleGroupe.getSelectedItem()),
                    SimpleArticle.articleCourant.designation,
                    SimpleArticle.articleCourant.dateCreation,
                    SimpleArticle.articleCourant.unite,
                    VisDias.formatInt.format(SimpleArticle.articleCourant.quantiteStock),
                    VisDias.formatDouble.format(SimpleArticle.articleCourant.prixUT),
                    VisDias.formatDouble.format(SimpleArticle.articleCourant.tva));
            }else if(MODE == MODE_BON_VENTE){
                SimpleArticle.articleCourant = ArticleVente.get((String)jTableBonArticle1.getValueAt(row, 0));
                jComboBoxAddArticleUnite.setSelectedItem(SimpleArticle.articleCourant.unite);
                setupAddArticle("Production",
                    "Modifier Article Production",
                    GroupeArticleVente.displayCombo(),
                    GroupeArticleVente.get((String)jComboBoxBonArticleGroupe.getSelectedItem()),
                    SimpleArticle.articleCourant.designation,
                    SimpleArticle.articleCourant.dateCreation,
                    SimpleArticle.articleCourant.unite,
                    VisDias.formatInt.format(SimpleArticle.articleCourant.quantiteStock),
                    VisDias.formatDouble.format(SimpleArticle.articleCourant.prixUT),
                    VisDias.formatDouble.format(SimpleArticle.articleCourant.tva));
            }
        }
    }//GEN-LAST:event_jButtonBonArticleModifierActionPerformed

    private void jButtonBonArticleConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBonArticleConfirmerActionPerformed
        ArrayList<ArticleBon> tmpList = new ArrayList<ArticleBon>();
        ArticleBon tmpArtBon;   ArrayList<ArticleBon> listOldArtBon;    double oldSom;   int qt;    double pu;   double pt;    double tva;   double puTTC;   double ptTTC;
        try{
            for(int j=0; j<jTableBonArticle2.getRowCount(); j++){
                qt = VisDias.formatInt.parse((String)jTableBonArticle2.getValueAt(j, 3)).intValue();
                pu = VisDias.formatDouble.parse((String)jTableBonArticle2.getValueAt(j, 4)).doubleValue();
                pt = VisDias.formatDouble.parse((String)jTableBonArticle2.getValueAt(j, 5)).doubleValue();
                tva = VisDias.formatDouble.parse((String)jTableBonArticle2.getValueAt(j, 6)).doubleValue();
                puTTC = VisDias.formatDouble.parse((String)jTableBonArticle2.getValueAt(j, 7)).doubleValue();
                ptTTC = VisDias.formatDouble.parse((String)jTableBonArticle2.getValueAt(j, 8)).doubleValue();
                tmpArtBon = new ArticleBon((String)jTableBonArticle2.getValueAt(j, 0),
                    (String)jTableBonArticle2.getValueAt(j, 1),
                    (String)jTableBonArticle2.getValueAt(j, 2),
                    qt, pu, pt, tva, puTTC, ptTTC);
                tmpList.add(tmpArtBon);
            }
            
            pt = VisDias.formatDouble.parse((String)jTextFieldBonArticleSomHT.getText()).doubleValue();
            tva = VisDias.formatDouble.parse((String)jTextFieldBonArticleSomTTC.getText()).doubleValue();

            oldSom = Bon.BonCourant.prixTTC;
            listOldArtBon = Bon.BonCourant.listArticleBon;
            Bon.BonCourant.listArticleBon = tmpList;
            Bon.BonCourant.prixTT =  pt;
            Bon.BonCourant.prixTTC = tva;
            if(jCheckBoxBonArticleTimbre.isSelected()){
                if(tva > 25000)
                    Bon.BonCourant.prixTTC += 250.0;
                else
                    Bon.BonCourant.prixTTC += Math.round(tva/100);
            }
            if(MODE == MODE_BON_ACHAT){
                ArticleAchat tmpArt;
                Fournisseur tmpFR = Fournisseur.get(Bon.BonCourant.refPersonne);
                if(tmpFR != null){
                    tmpFR.chiffreAffaire = tmpFR.chiffreAffaire + Bon.BonCourant.prixTTC - oldSom;
                    if (jCheckBoxBonArticleRAR.isEnabled() && !jCheckBoxBonArticleRAR.isSelected())
                        tmpFR.resteRegler += Bon.BonCourant.prixTTC;
                }else{
                    jLabelOption.setText("Attention! Le fournisseur concerné est introuvable (supprimé)");
                    JOptionPane.showMessageDialog(null, jLabelOption, "Avertissement", JOptionPane.WARNING_MESSAGE, null);
                }
                for(ArticleBon i : listOldArtBon){
                    tmpArt = ArticleAchat.get(i.refArticle);
                    if(tmpArt != null){
                        tmpArt.quantiteStock -= i.quantite;
                    }
                }
                for(ArticleBon i : tmpList){
                    tmpArt = ArticleAchat.get(i.refArticle);
                    if(tmpArt != null){
                        tmpArt.quantiteStock += i.quantite;
                    }
                }
                Bon.BonCourant = null;
                setupAchat(null, null, null, true, null);
            }else if(MODE == MODE_BON_VENTE){
                ArticleVente tmpArt;
                Client tmpCL = Client.get(Bon.BonCourant.refPersonne);
                if(tmpCL != null){
                    tmpCL.chiffreAffaire = tmpCL.chiffreAffaire + Bon.BonCourant.prixTTC - oldSom;
                    if (jCheckBoxBonArticleRAR.isEnabled() && !jCheckBoxBonArticleRAR.isSelected())
                        tmpCL.resteRegler += Bon.BonCourant.prixTTC;
                }else{
                    jLabelOption.setText("Attention! Le client concerné est introuvable (supprimé)");
                    JOptionPane.showMessageDialog(null, jLabelOption, "Avertissement", JOptionPane.WARNING_MESSAGE, null);
                }
                for(ArticleBon i : listOldArtBon){
                    tmpArt = ArticleVente.get(i.refArticle);
                    if(tmpArt != null){
                        tmpArt.quantiteStock += i.quantite;
                    }
                }
                for(ArticleBon i : tmpList){
                    tmpArt = ArticleVente.get(i.refArticle);
                    if(tmpArt != null){
                        tmpArt.quantiteStock -= i.quantite;
                    }
                }
                Bon.BonCourant = null;
                setupVente(null, null, null, true, null);
            }
            jButtonBonArticleAnnulerActionPerformed(evt);
        }catch(Exception e){
            jLabelOption.setText("Valeurs numériques invalides");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButtonBonArticleConfirmerActionPerformed

    private void jButtonBonArticleAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBonArticleAnnulerActionPerformed
        jDialogBonArticle.dispose();
    }//GEN-LAST:event_jButtonBonArticleAnnulerActionPerformed

    private void jButtonBonArticleAddArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBonArticleAddArticleActionPerformed
        jTabbedPaneAddArticle.setEnabledAt(0, true);
        jTabbedPaneAddArticle.setEnabledAt(1, true);
        jLabelAddGroupePrincipal.setText("Ajout Groupe");
        jTextFieldAddGroupeDesignation.setText("");
        GroupeArticle.groupeCourant = null;
        SimpleArticle.articleCourant = null;
        if(MODE == MODE_ARTICLE_ACHAT || MODE == MODE_BON_ACHAT){
            jLabelAddArticlePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Article.png")));
            setupAddArticle("Article", "Ajout Article D'Achat", GroupeArticleAchat.displayCombo(), VisDias.listGroupeArticleAchat.get(0), "", Date.getTodayDate(), null, "", "", "");
        }else if(MODE == MODE_ARTICLE_VENTE || MODE == MODE_BON_VENTE){
            jLabelAddArticlePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Production.png")));
            setupAddArticle("Production" ,"Ajout Production", GroupeArticleVente.displayCombo(), VisDias.listGroupeArticleVente.get(0), "", Date.getTodayDate(), null, "", "", "");
        }
    }//GEN-LAST:event_jButtonBonArticleAddArticleActionPerformed

    private void jTableBonArticle1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableBonArticle1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            int[] rows = jTableBonArticle1.getSelectedRows();
            for(int i : rows){
                jTableBonArticle1DoubleClick(i);
            }
        }
    }//GEN-LAST:event_jTableBonArticle1KeyPressed

    private void jTableBonArticle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBonArticle1MouseClicked
        if(jTableBonArticle1.getSelectedRows().length > 0){
            jTableBonArticle2.clearSelection();
        }
    }//GEN-LAST:event_jTableBonArticle1MouseClicked

    private void jTableBonArticle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBonArticle2MouseClicked
        if(jTableBonArticle2.getSelectedRows().length > 0){
            jTableBonArticle1.clearSelection();
        }
    }//GEN-LAST:event_jTableBonArticle2MouseClicked

    private void jComboBoxBonArticleGroupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBonArticleGroupeActionPerformed
        if(MODE == MODE_BON_ACHAT){
            jTableBonArticle1.setModel(new javax.swing.table.DefaultTableModel(
                ArticleAchat.display(GroupeArticleAchat.get((String)jComboBoxBonArticleGroupe.getSelectedItem()), null, null, null, false),
                ArticleAchat.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        }else if(MODE == MODE_BON_VENTE){
            jTableBonArticle1.setModel(new javax.swing.table.DefaultTableModel(
                ArticleVente.display(GroupeArticleVente.get((String)jComboBoxBonArticleGroupe.getSelectedItem()), null, null, null, false),
                ArticleVente.colonne()
            )
            {boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return canEdit [columnIndex];
                }
            }
        );
        }
        jTableBonArticle1.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableBonArticle1, new int[]{0, 2, 3, 4, 6});
        rightAlignCell(jTableBonArticle1, new int[]{5, 7});
        centerHeader(jTableBonArticle1);
        if (jTableBonArticle1.getColumnModel().getColumnCount() > 0) {
            jTableBonArticle1.getColumnModel().getColumn(0).setResizable(false);
            jTableBonArticle1.getColumnModel().getColumn(0).setMaxWidth(100);
        }
    }//GEN-LAST:event_jComboBoxBonArticleGroupeActionPerformed

    private void jButtonImprimerAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimerAnnulerActionPerformed
        jDialogImprimer.dispose();
    }//GEN-LAST:event_jButtonImprimerAnnulerActionPerformed

    private void jButtonImprimerConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimerConfirmerActionPerformed
        if(!((BonVente)Bon.BonCourant).imprimer(((String)jComboBoxImprimerModele.getSelectedItem()).toUpperCase())){
            jLabelOption.setText("Impossible d'imprimer");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            try{
                File pdfFile = new File("Rapport.pdf");
                if (pdfFile.exists()){
                        if (Desktop.isDesktopSupported())
                                Desktop.getDesktop().open(pdfFile);
                }else{
                    jLabelOption.setText("Impossible d'ouvrir le modèle d'impression");
                    JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
                }
            }catch(Exception ex){
                jLabelOption.setText("Problème de l'impression");
                JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
            }
        }
        jButtonImprimerAnnulerActionPerformed(evt);
    }//GEN-LAST:event_jButtonImprimerConfirmerActionPerformed

    private void jButtonConsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsoActionPerformed
        MODE = MODE_CONSO;
        setupTwoTable(300);
        GroupeConso.GroupeConsoActif = null;
        setupGroupeConso(null, null, null, null, true);
        jLabelRubriqueCourante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Conso.png")));
        jLabelRubriqueCourante.setText("Liste des consommations");
    }//GEN-LAST:event_jButtonConsoActionPerformed

    private void jButtonAddGroupeConsoConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddGroupeConsoConfirmerActionPerformed
        if(jTextFieldAddGroupeConsoDesignation.getText().isEmpty()){
            jLabelOption.setText("Remplir toutes les rubriques !");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else if(GroupeConso.get(jTextFieldAddGroupeConsoDesignation.getText()) != null){
            jLabelOption.setText("Ce nom de groupe est déjà pris");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            if(GroupeConso.groupeCourant == null){
               VisDias.listGroupeConso.add(new GroupeConso(jTextFieldAddGroupeConsoDesignation.getText()));
            }else{
               GroupeConso.groupeCourant.modifier(jTextFieldAddGroupeConsoDesignation.getText());
            }
            setupGroupeConso(null, null, null, null, true);
            jButtonAddGroupeConsoAnnulerActionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonAddGroupeConsoConfirmerActionPerformed

    private void jButtonAddGroupeConsoAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddGroupeConsoAnnulerActionPerformed
        jDialogAddConso.dispose();
    }//GEN-LAST:event_jButtonAddGroupeConsoAnnulerActionPerformed

    private void jButtonAddConsoAnnuler1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddConsoAnnuler1ActionPerformed
        jDialogAddConso1.dispose();
    }//GEN-LAST:event_jButtonAddConsoAnnuler1ActionPerformed

    private void jButtonAddConsoRemoveUniteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddConsoRemoveUniteActionPerformed
        if(jComboBoxAddConsoUnite.getItemCount() > 0 && jComboBoxAddConsoUnite.isEnabled()){
            SimpleArticle.listUnite.remove((String)jComboBoxAddConsoUnite.getSelectedItem());
            jComboBoxAddConsoUnite.removeItem(jComboBoxAddConsoUnite.getSelectedItem());
        }
    }//GEN-LAST:event_jButtonAddConsoRemoveUniteActionPerformed

    private void jButtonAddConsoConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddConsoConfirmerActionPerformed
        if(
        jTextFieldAddConsoDesignation.getText().isEmpty()                                       ||
        jComboBoxAddConsoUnite.getItemCount() == 0                                              ||
        jTextFieldAddConsoQT.getText().isEmpty()                                                ||
        (jCheckBoxAddConsoQtUT.isSelected() && jTextFieldAddConsoQtUT.getText().isEmpty())      ||
        (jTextFieldAddConsoPU.getText().isEmpty() && jTextFieldAddConsoPT.getText().isEmpty())) {
            jLabelOption.setText("Remplir toutes les rubriques !");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            int qt;    int qtut;    int typeConso;    double prixUT;    double prixTT;    Date tmpDate;    GroupeConso grpConso;
            Consommation tmpConso;  int oldQT;  String tmpCode;
            try{
                qt = VisDias.formatInt.parse(jTextFieldAddConsoQT.getText()).intValue();
                if(jCheckBoxAddConsoQtUT.isSelected()){
                    typeConso = jComboBoxAddConsoQtUT.getSelectedIndex();
                    qtut = VisDias.formatInt.parse(jTextFieldAddConsoQtUT.getText()).intValue();
                }else{
                    typeConso = -1;
                    qtut = -1;
                }
                if(jTextFieldAddConsoPU.getText().isEmpty()){
                    prixTT = VisDias.formatDouble.parse(jTextFieldAddConsoPT.getText()).doubleValue(); 
                    prixUT = (double) prixTT / qt;
                }else if(jTextFieldAddConsoPT.getText().isEmpty()){
                    prixUT = VisDias.formatDouble.parse(jTextFieldAddConsoPU.getText()).doubleValue();
                    prixTT = (double) qt * prixUT;
                }else{
                    prixUT = VisDias.formatDouble.parse(jTextFieldAddConsoPU.getText()).doubleValue();
                    prixTT = VisDias.formatDouble.parse(jTextFieldAddConsoPT.getText()).doubleValue();  
                }
                tmpDate = new Date(Integer.parseInt(jSpinnerAddConsoJour.getValue().toString()),
                                        Integer.parseInt(jSpinnerAddConsoMois.getValue().toString()),
                                        Integer.parseInt(jSpinnerAddConsoAnnee.getValue().toString()));
                
                grpConso = GroupeConso.get((String)jComboBoxAddConsoGroupe.getSelectedItem());
                
                if(Consommation.consoCourant == null){
                    if(ArticleAchat.articleCourant != null)
                        tmpCode = ArticleAchat.articleCourant.code;
                    else
                        tmpCode = null;
                    tmpConso = new Consommation(tmpCode,
                                               jTextFieldAddConsoDesignation.getText(), tmpDate,
                                               (String)jComboBoxAddConsoUnite.getSelectedItem(),
                                                qt, prixUT, prixTT, typeConso, qtut);
                    VisDias.listConsommation.add(tmpConso);
                    grpConso.refArticle.add(tmpConso.code);
                    
                    if(ArticleAchat.articleCourant != null){
                        ArticleAchat.articleCourant.quantiteStock -= qt;
                    }

                    setupGroupeConso(GroupeConso.GroupeConsoActif, null, null, null, grpConso.equals(GroupeConso.GroupeConsoActif)); 
                }else{
                    oldQT = Consommation.consoCourant.quantite;
                    GroupeConso.GroupeConsoActif.refArticle.remove(Consommation.consoCourant.code);
                    Consommation.consoCourant.modifier(jTextFieldAddConsoDesignation.getText(), tmpDate,
                                                       (String)jComboBoxAddConsoUnite.getSelectedItem(),
                                                       qt, typeConso, qtut, prixUT, prixTT);
                    grpConso.refArticle.add(Consommation.consoCourant.code);
                    
                    if(Consommation.consoCourant.refArticle != null){
                        ArticleAchat.get(Consommation.consoCourant.refArticle).quantiteStock -= Consommation.consoCourant.quantite - oldQT;
                    }
                    
                    setupGroupeConso(GroupeConso.GroupeConsoActif, null, null, null, true);
                }
                
                jButtonAddConsoAnnuler1ActionPerformed(evt);
            }catch(ParseException e){
                jLabelOption.setText("Valeurs numériques invalides !");
                JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }//GEN-LAST:event_jButtonAddConsoConfirmerActionPerformed

    private void jButtonAddConsoAddUniteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddConsoAddUniteActionPerformed
        if(jComboBoxAddConsoUnite.isEnabled() && !jTextFieldAddConsoAddUnite.getText().isEmpty()){
            SimpleArticle.listUnite.add(jTextFieldAddConsoAddUnite.getText());
            jComboBoxAddConsoUnite.addItem(jTextFieldAddConsoAddUnite.getText());
            jComboBoxAddConsoUnite.setSelectedItem(jTextFieldAddConsoAddUnite.getText());
            jTextFieldAddConsoAddUnite.setText("");
        }
    }//GEN-LAST:event_jButtonAddConsoAddUniteActionPerformed

    private void jCheckBoxAddConsoArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAddConsoArticleActionPerformed
        jComboBoxAddConsoGroupeArticle.setEnabled(jCheckBoxAddConsoArticle.isSelected());
        jTableAddConsoArticle.setEnabled(jCheckBoxAddConsoArticle.isSelected());
    }//GEN-LAST:event_jCheckBoxAddConsoArticleActionPerformed

    private void jButtonAddConsoSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddConsoSuivantActionPerformed
        if(jCheckBoxAddConsoArticle.isSelected()){
            int row = jTableAddConsoArticle.getSelectedRow();
            if(row >= 0){
                ArticleAchat tmpArt = ArticleAchat.get((String)jTableAddConsoArticle.getValueAt(row, 0));
                ArticleAchat.articleCourant = tmpArt;
                setupAddConso1("Nouvelle consommation", null, Date.getTodayDate(), tmpArt.designation, tmpArt.unite,
                               "0", -1, "", VisDias.formatDouble.format(tmpArt.prixTTC), "", false);
                jButtonAddConsoAnnulerActionPerformed(evt);
            }else{
                jLabelOption.setText("Choisissez un article");
                JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
            }
        }else{
            jButtonAddConsoAnnulerActionPerformed(evt);
            ArticleAchat.articleCourant = null;
            setupAddConso1("Nouvelle consommation", null, Date.getTodayDate(), "", null,
                               "0", -1, "", "", "", true);
        }
    }//GEN-LAST:event_jButtonAddConsoSuivantActionPerformed

    private void jButtonAddConsoAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddConsoAnnulerActionPerformed
        jDialogAddConso.dispose();
    }//GEN-LAST:event_jButtonAddConsoAnnulerActionPerformed

    private void jCheckBoxAddConsoQtUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAddConsoQtUTActionPerformed
        jComboBoxAddConsoQtUT.setEnabled(jCheckBoxAddConsoQtUT.isSelected());
        jTextFieldAddConsoQtUT.setEditable(jCheckBoxAddConsoQtUT.isSelected() && jComboBoxAddConsoQtUT.getSelectedIndex() == 0);
        if(!jCheckBoxAddConsoQtUT.isSelected()){
            jComboBoxAddConsoQtUT.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jCheckBoxAddConsoQtUTActionPerformed

    private void jComboBoxAddConsoQtUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAddConsoQtUTActionPerformed
        int row = jComboBoxAddConsoQtUT.getSelectedIndex();
        int qt;
        if(row >= 0){
            if(row == 0){
                jTextFieldAddConsoQtUT.setText("");
                if(jCheckBoxAddConsoQtUT.isSelected())
                    jTextFieldAddConsoQtUT.setEditable(true);
            }else if(!jTextFieldAddConsoQT.getText().isEmpty()){
                try{
                    qt = VisDias.formatInt.parse(jTextFieldAddConsoQT.getText()).intValue();
                    jTextFieldAddConsoQtUT.setText(VisDias.formatInt.format(qt * Consommation.TYPE_CONV[jComboBoxAddConsoQtUT.getSelectedIndex()]));
                    jTextFieldAddConsoQtUT.setEditable(false);
                }catch(ParseException e){
                    jComboBoxAddConsoQtUT.setSelectedIndex(0);
                }
            }else{
                jComboBoxAddConsoQtUT.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_jComboBoxAddConsoQtUTActionPerformed

    private void jComboBoxAddConsoGroupeArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAddConsoGroupeArticleActionPerformed
        String[][] list = ArticleAchat.display(GroupeArticleAchat.get((String)jComboBoxAddConsoGroupeArticle.getSelectedItem()), null, null, null, false);
        String[][] lig = new String[list.length][4];
        for(int i=0; i<list.length; i++){
            lig[i][0] = list[i][0];
            lig[i][1] = list[i][1];
            lig[i][2] = list[i][3];
            lig[i][3] = list[i][4];
        }
        jTableAddConsoArticle.setModel(new javax.swing.table.DefaultTableModel(
                lig,
                new String[]{"Code", "Désignation", "Unité", "Quantité"}
                )
                {boolean[] canEdit = new boolean [] {false, false, false, false};
                    public boolean isCellEditable(int rowIndex, int columnIndex){
                        return canEdit [columnIndex];
                    }
                }
        );
        jTableAddConsoArticle.setAutoCreateRowSorter(true);
        jTableAddConsoArticle.getTableHeader().setReorderingAllowed(false);
        centerAlignCell(jTableAddConsoArticle, new int[]{0, 2, 3});
        centerHeader(jTableAddConsoArticle);
        if (jTableAddConsoArticle.getColumnModel().getColumnCount() > 0) {
            jTableAddConsoArticle.getColumnModel().getColumn(0).setResizable(false);
            jTableAddConsoArticle.getColumnModel().getColumn(0).setMaxWidth(65);
        }
    }//GEN-LAST:event_jComboBoxAddConsoGroupeArticleActionPerformed

    private void jButtonResultatConsoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResultatConsoOkActionPerformed
        jDialogResultatConso.dispose();
        setupConsommation(GroupeConso.GroupeConsoActif, null, null, null);
    }//GEN-LAST:event_jButtonResultatConsoOkActionPerformed

    private void jButtonRapportConsoConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRapportConsoConfirmerActionPerformed
        String designation = null;
        if(!jTextFieldRapportConsoDesignation.getText().isEmpty())
            designation = jTextFieldRapportConsoDesignation.getText();
        
        Date dateMin = null, dateMax = null;
        if(jCheckBoxRapportConsoDate.isSelected()){
            dateMin = new Date(Integer.parseInt(jSpinnerRapportConsoDateDuJour.getValue().toString()),
                               Integer.parseInt(jSpinnerRapportConsoDateDuMois.getValue().toString()),
                               Integer.parseInt(jSpinnerRapportConsoDateDuAnnee.getValue().toString()));
            dateMax = new Date(Integer.parseInt(jSpinnerRapportConsoDateAuJour.getValue().toString()),
                               Integer.parseInt(jSpinnerRapportConsoDateAuMois.getValue().toString()),
                               Integer.parseInt(jSpinnerRapportConsoDateAuAnnee.getValue().toString()));
        }
        if(dateMin != null && dateMin.compareTo(dateMax) == 1){
            jLabelOption.setText("Intervalle de date erroné");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            jButtonRapportConsoAnnulerActionPerformed(evt);
            setupConsommation(VisDias.listGroupeConso, designation, dateMin, dateMax);
            calculRapportConso(dateMin, dateMax);
        }
    }//GEN-LAST:event_jButtonRapportConsoConfirmerActionPerformed

    private void jButtonRapportConsoAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRapportConsoAnnulerActionPerformed
        jDialogRapportConso.dispose();
    }//GEN-LAST:event_jButtonRapportConsoAnnulerActionPerformed

    private void jCheckBoxRapportConsoDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRapportConsoDateActionPerformed
        jLabelRapportConsoDateDu.setEnabled(jCheckBoxRapportConsoDate.isSelected());
        jLabelRapportConsoDateAu.setEnabled(jCheckBoxRapportConsoDate.isSelected());
        jLabelRapportConsoSlash1.setEnabled(jCheckBoxRapportConsoDate.isSelected());
        jLabelRapportConsoSlash2.setEnabled(jCheckBoxRapportConsoDate.isSelected());
        jLabelRapportConsoSlash3.setEnabled(jCheckBoxRapportConsoDate.isSelected());
        jLabelRapportConsoSlash4.setEnabled(jCheckBoxRapportConsoDate.isSelected());
        jSpinnerRapportConsoDateDuJour.setEnabled(jCheckBoxRapportConsoDate.isSelected());
        jSpinnerRapportConsoDateDuMois.setEnabled(jCheckBoxRapportConsoDate.isSelected());
        jSpinnerRapportConsoDateDuAnnee.setEnabled(jCheckBoxRapportConsoDate.isSelected());
        jSpinnerRapportConsoDateAuJour.setEnabled(jCheckBoxRapportConsoDate.isSelected());
        jSpinnerRapportConsoDateAuMois.setEnabled(jCheckBoxRapportConsoDate.isSelected());
        jSpinnerRapportConsoDateAuAnnee.setEnabled(jCheckBoxRapportConsoDate.isSelected());
    }//GEN-LAST:event_jCheckBoxRapportConsoDateActionPerformed

    private void jDialogResultatConsoWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogResultatConsoWindowClosed
        jButtonResultatConsoOkActionPerformed(null);
    }//GEN-LAST:event_jDialogResultatConsoWindowClosed

    private void jDialogResultatPersonneWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogResultatPersonneWindowClosed
        jButtonResultatPersonneOkActionPerformed(null);
    }//GEN-LAST:event_jDialogResultatPersonneWindowClosed

    private void jDialogResultatArticleWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogResultatArticleWindowClosed
        jButtonResultatArticleOkActionPerformed(null);
    }//GEN-LAST:event_jDialogResultatArticleWindowClosed

    private void jDialogResultatBonWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogResultatBonWindowClosed
        jButtonResultatBonOkActionPerformed(null);
    }//GEN-LAST:event_jDialogResultatBonWindowClosed

    private void jButtonRecetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecetteActionPerformed
        MODE = MODE_RECETTE;
        setupOneTable();
        setupRecette(null, null, null, null, null);
        jLabelRubriqueCourante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Recette.png")));
        jLabelRubriqueCourante.setText("Liste des crédits");
    }//GEN-LAST:event_jButtonRecetteActionPerformed

    private void jButtonDepenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDepenseActionPerformed
        MODE = MODE_DEPENSE;
        setupOneTable();
        setupDepense(null, null, null, null, null);
        jLabelRubriqueCourante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visdias/Icons/Debit.png")));
        jLabelRubriqueCourante.setText("Liste des débits");
    }//GEN-LAST:event_jButtonDepenseActionPerformed

    private void jButtonRegleCBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegleCBAddActionPerformed
        jTextFieldCbBanque.setText("");
        jTextFieldCbAgence.setText("");
        jTextFieldCbNum.setText("");
        
        jDialogCb.getRootPane().setDefaultButton(jButtonCbConfirmer);
        jDialogCb.setVisible(true);
    }//GEN-LAST:event_jButtonRegleCBAddActionPerformed

    private void jButtonRegleCBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegleCBRemoveActionPerformed
        int row = jTableRegleCB.getSelectedRow();
        if(row >= 0){
            VisDias.listCompteBanquaire.remove(
                    CompteBanquaire.get((String)jTableRegleCB.getValueAt(row, 0))
            );
            ((javax.swing.table.DefaultTableModel)jTableRegleCB.getModel()).removeRow(row);
        }
    }//GEN-LAST:event_jButtonRegleCBRemoveActionPerformed

    private void jButtonCbConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCbConfirmerActionPerformed
        if(jTextFieldCbBanque.getText().isEmpty()){
            jLabelOption.setText("Spécifier le nom de la banque");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            CompteBanquaire cpt = new CompteBanquaire(jTextFieldCbBanque.getText(),
                                                      jTextFieldCbAgence.getText(),
                                                      jTextFieldCbNum.getText());
            VisDias.listCompteBanquaire.add(cpt);
            ((javax.swing.table.DefaultTableModel)jTableRegleCB.getModel()).addRow(CompteBanquaire.displayRow(cpt));
            
            jButtonCbAnnulerActionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonCbConfirmerActionPerformed

    private void jButtonCbAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCbAnnulerActionPerformed
        jDialogCb.dispose();
    }//GEN-LAST:event_jButtonCbAnnulerActionPerformed

    private void jButtonRegleModeAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegleModeAddActionPerformed
        if(!jTextFieldRegleModeAdd.getText().isEmpty()){
            Reglement.listModeReg.add(jTextFieldRegleModeAdd.getText());
            jComboBoxRegleMode.addItem(jTextFieldRegleModeAdd.getText());
            jComboBoxRegleMode.setSelectedItem(jTextFieldRegleModeAdd.getText());
            jTextFieldRegleModeAdd.setText("");
        }
    }//GEN-LAST:event_jButtonRegleModeAddActionPerformed

    private void jButtonRegleModeRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegleModeRemoveActionPerformed
        if(jComboBoxRegleMode.getItemCount() > 0){
            Reglement.listModeReg.remove((String)jComboBoxRegleMode.getSelectedItem());
            jComboBoxRegleMode.removeItem(jComboBoxRegleMode.getSelectedItem());
        }
    }//GEN-LAST:event_jButtonRegleModeRemoveActionPerformed

    private void jButtonRegleAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegleAnnulerActionPerformed
        jDialogRegle.dispose();
    }//GEN-LAST:event_jButtonRegleAnnulerActionPerformed

    private void jButtonRegleConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegleConfirmerActionPerformed
        double montant;  Date dateTmp;   Reglement reg;
        if(((String)jComboBoxReglePersonne.getSelectedItem()).isEmpty() ||
            jTextFieldRegleMontant.getText().isEmpty() ||
            jComboBoxRegleMode.getSelectedIndex() < 0 ||
            jTableRegleCB.getSelectedRow() < 0
          ){
            jLabelOption.setText("Remplir les champs nécessaires");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else if(jTableRegleCB.getSelectedRow() < 0){
            jLabelOption.setText("Sélectionner un compte banquaire");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            try{
                montant = VisDias.formatDouble.parse(jTextFieldRegleMontant.getText()).doubleValue();
                dateTmp = new Date(Integer.parseInt(jSpinnerRegleJour.getValue().toString()),
                                   Integer.parseInt(jSpinnerRegleMois.getValue().toString()),
                                   Integer.parseInt(jSpinnerRegleAnnee.getValue().toString()));
                if(Reglement.reglementCourant != null){
                    Reglement.reglementCourant.Modifier(jTextFieldRegleDesig.getText(), ((String)jComboBoxReglePersonne.getSelectedItem()),
                                                        dateTmp, montant, ((String)jComboBoxRegleMode.getSelectedItem()),
                                                        (String)jTableRegleCB.getValueAt(jTableRegleCB.getSelectedRow(), 0));
                    if(MODE == MODE_RECETTE)
                        setupRecette(null, null, null, null, null);
                    else
                        setupDepense(null, null, null, null, null);
                }else{
                    if(MODE == MODE_RECETTE){
                        reg = new Recette(jTextFieldRegleDesig.getText(), ((String)jComboBoxReglePersonne.getSelectedItem()),
                                          dateTmp, montant, ((String)jComboBoxRegleMode.getSelectedItem()), 
                                          (String)jTableRegleCB.getValueAt(jTableRegleCB.getSelectedRow(), 0));
                        VisDias.listRecette.add((Recette)reg);
                    }else{
                        reg = new Depense(jTextFieldRegleDesig.getText(), ((String)jComboBoxReglePersonne.getSelectedItem()),
                                          dateTmp, montant, ((String)jComboBoxRegleMode.getSelectedItem()), 
                                          (String)jTableRegleCB.getValueAt(jTableRegleCB.getSelectedRow(), 0));
                        VisDias.listDepense.add((Depense)reg);
                    }
                    ((javax.swing.table.DefaultTableModel)jTableBig.getModel()).addRow(Reglement.displayRow(reg));
                }
                jButtonRegleAnnulerActionPerformed(evt);
            }catch(ParseException e){
                jLabelOption.setText("Valeur numérique invalide");
                JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }//GEN-LAST:event_jButtonRegleConfirmerActionPerformed

    private void jButtonRapportRegleConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRapportRegleConfirmerActionPerformed
        String designation = null;
        if(!jTextFieldRapportRegleDesignation.getText().isEmpty())
            designation = jTextFieldRapportRegleDesignation.getText();
        
        String personne = null;
        if(!((String)jComboBoxRapportReglePersonne.getSelectedItem()).isEmpty())
            personne = (String)jComboBoxRapportReglePersonne.getSelectedItem();
        
        Date dateMin = null, dateMax = null;
        if(jCheckBoxRapportRegleDate.isSelected()){
            dateMin = new Date(Integer.parseInt(jSpinnerRapportRegleDateDuJour.getValue().toString()),
                               Integer.parseInt(jSpinnerRapportRegleDateDuMois.getValue().toString()),
                               Integer.parseInt(jSpinnerRapportRegleDateDuAnnee.getValue().toString()));
            dateMax = new Date(Integer.parseInt(jSpinnerRapportRegleDateAuJour.getValue().toString()),
                               Integer.parseInt(jSpinnerRapportRegleDateAuMois.getValue().toString()),
                               Integer.parseInt(jSpinnerRapportRegleDateAuAnnee.getValue().toString()));
        }
        
        String mode = null;
        if(!((String)jComboBoxRapportRegleMode.getSelectedItem()).equals("Tous")){
            mode = (String)jComboBoxRapportRegleMode.getSelectedItem();
        }
        
        if(dateMin != null && dateMin.compareTo(dateMax) == 1){
            jLabelOption.setText("Intervalle de date erroné");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        }else{
            if(MODE == MODE_RECETTE){
                setupRecette(designation, dateMin, dateMax, mode, personne);
            }else{
                setupDepense(designation, dateMin, dateMax, mode, personne);
            }
            jButtonRapportRegleAnnulerActionPerformed(evt);
            calculRapportRegle(dateMin, dateMax);
        }
    }//GEN-LAST:event_jButtonRapportRegleConfirmerActionPerformed

    private void jButtonRapportRegleAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRapportRegleAnnulerActionPerformed
        jDialogRapportReglement.dispose();
    }//GEN-LAST:event_jButtonRapportRegleAnnulerActionPerformed

    private void jCheckBoxRapportRegleDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRapportRegleDateActionPerformed
        jLabelRapportRegleDateDu.setEnabled(jCheckBoxRapportRegleDate.isSelected());
        jLabelRapportRegleDateAu.setEnabled(jCheckBoxRapportRegleDate.isSelected());
        jLabelRapportRegleSlash1.setEnabled(jCheckBoxRapportRegleDate.isSelected());
        jLabelRapportRegleSlash2.setEnabled(jCheckBoxRapportRegleDate.isSelected());
        jLabelRapportRegleSlash3.setEnabled(jCheckBoxRapportRegleDate.isSelected());
        jLabelRapportRegleSlash4.setEnabled(jCheckBoxRapportRegleDate.isSelected());
        jSpinnerRapportRegleDateDuJour.setEnabled(jCheckBoxRapportRegleDate.isSelected());
        jSpinnerRapportRegleDateDuMois.setEnabled(jCheckBoxRapportRegleDate.isSelected());
        jSpinnerRapportRegleDateDuAnnee.setEnabled(jCheckBoxRapportRegleDate.isSelected());
        jSpinnerRapportRegleDateAuJour.setEnabled(jCheckBoxRapportRegleDate.isSelected());
        jSpinnerRapportRegleDateAuMois.setEnabled(jCheckBoxRapportRegleDate.isSelected());
        jSpinnerRapportRegleDateAuAnnee.setEnabled(jCheckBoxRapportRegleDate.isSelected());
    }//GEN-LAST:event_jCheckBoxRapportRegleDateActionPerformed

    private void jButtonResultatRegleOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResultatRegleOkActionPerformed
        jDialogResultatRegle.dispose();
        if(MODE == MODE_RECETTE){
            setupRecette(null, null, null, null, null);
        }else if(MODE == MODE_DEPENSE){
            setupDepense(null, null, null, null, null);
        }
    }//GEN-LAST:event_jButtonResultatRegleOkActionPerformed

    private void jDialogResultatRegleWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogResultatRegleWindowClosed
        jButtonResultatRegleOkActionPerformed(null);
    }//GEN-LAST:event_jDialogResultatRegleWindowClosed

    private void jButtonRapportRegleSoldeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRapportRegleSoldeActionPerformed
        double som = 0;
        Date[] recDate = null, depDate = null;
        for (Recette i : VisDias.listRecette) {
            som += i.montant;
            if (recDate != null) {
                if (recDate[0].compareTo(i.date) == 1){
                    recDate[0] = i.date;
                } else if (recDate[1].compareTo(i.date) == -1){
                    recDate[1] = i.date;
                }
            } else {
                recDate = new Date[]{i.date, i.date};
            }
        }
        for (Depense i : VisDias.listDepense) {
            som -= i.montant;
            if (depDate != null) {
                if (depDate[0].compareTo(i.date) == 1){
                    depDate[0] = i.date;
                } else if (depDate[1].compareTo(i.date) == -1){
                    depDate[1] = i.date;
                }
            } else {
                depDate = new Date[]{i.date, i.date};
            }
        }
        if (recDate == null && depDate == null) {
            jTextFieldResultatRegleDateDu.setText("");
            jTextFieldResultatRegleDateAu.setText("");
        } else if (recDate != null && depDate == null) {
            jTextFieldResultatRegleDateDu.setText(recDate[0].toString());
            jTextFieldResultatRegleDateAu.setText(recDate[1].toString());
        } else if (recDate == null && depDate != null) {
            jTextFieldResultatRegleDateDu.setText(depDate[0].toString());
            jTextFieldResultatRegleDateAu.setText(depDate[1].toString());
        } else {
            if (recDate[0].compareTo(depDate[0]) == -1)
                jTextFieldResultatRegleDateDu.setText(recDate[0].toString());
            else
                jTextFieldResultatRegleDateDu.setText(depDate[0].toString());
            
            if (recDate[1].compareTo(depDate[1]) == 1)
                jTextFieldResultatRegleDateAu.setText(recDate[1].toString());
            else
                jTextFieldResultatRegleDateAu.setText(depDate[1].toString());
        }
        jTextFieldResultatRegleNb.setText(Integer.toString(VisDias.listRecette.size() + VisDias.listDepense.size()));
        jTextFieldResultatReglePrix.setText(VisDias.formatDouble.format(som));
        
        jButtonRapportRegleAnnulerActionPerformed(evt);
        jDialogResultatRegle.setVisible(true);
    }//GEN-LAST:event_jButtonRapportRegleSoldeActionPerformed

    private void jButtonPersonneCrConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPersonneCrConfirmerActionPerformed
        Personne.personneCourante.crd.designation = jTextFieldPersonneCrDesignation.getText();
        Personne.personneCourante.crd.cevilite = jTextFieldPersonneCrCevilite.getText();
        Personne.personneCourante.crd.adresse = jTextFieldPersonneCrAdresse.getText();
        Personne.personneCourante.crd.nArt = jTextFieldPersonneCrArt.getText();
        Personne.personneCourante.crd.nRC = jTextFieldPersonneCrRC.getText();
        Personne.personneCourante.crd.nTel = jTextFieldPersonneCrTel.getText();
        Personne.personneCourante.crd.Fonction = jTextFieldPersonneCrFonction.getText();
        Personne.personneCourante.crd.compteBancaire = jTextFieldPersonneCrCptBanque.getText();
        Personne.personneCourante.crd.NIF = jTextFieldPersonneCrNIF.getText();
        Personne.personneCourante.crd.NIS = jTextFieldPersonneCrNIS.getText();
        
        jDialogPersonneInfo.dispose();
    }//GEN-LAST:event_jButtonPersonneCrConfirmerActionPerformed

    private void jButtonPersonneCrAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPersonneCrAnnulerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPersonneCrAnnulerActionPerformed

    private void jButtonPersonnePayAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPersonnePayAddActionPerformed
        Date today = Date.getTodayDate();
        jTextFieldAddPayRegleAdd.setText("");
        jSpinnerAddPayJour.setValue(today.day);
        jSpinnerAddPayMois.setValue(today.month);
        jSpinnerAddPayAnnee.setValue(today.year);
        jTextFieldAddPayPT.setText("");
        jComboBoxAddPayRegle.setModel(new javax.swing.DefaultComboBoxModel(Reglement.displayMode()));
        
        jDialogAddPayement.getRootPane().setDefaultButton(jButtonAddPayConfirmer);
        jDialogAddPayement.setVisible(true);
    }//GEN-LAST:event_jButtonPersonnePayAddActionPerformed

    private void jButtonAddPayConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPayConfirmerActionPerformed
        double montant;  Date date;  Payement pay;
        if (jComboBoxAddPayRegle.getSelectedIndex() < 0 ||
            jTextFieldAddPayPT.getText().isEmpty()
           ){
            jLabelOption.setText("Remplir les champs nécessaires");
            JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
        } else {
            try {
                montant = VisDias.formatDouble.parse(jTextFieldAddPayPT.getText()).doubleValue();
                date = new Date(Integer.parseInt(jSpinnerAddPayJour.getValue().toString()),
                                Integer.parseInt(jSpinnerAddPayMois.getValue().toString()),
                                Integer.parseInt(jSpinnerAddPayAnnee.getValue().toString()));
                pay = new Payement(date, jComboBoxAddPayRegle.getSelectedItem().toString(), montant);
                Personne.personneCourante.listPayement.add(pay);
                ((javax.swing.table.DefaultTableModel)jTablePersonnePay.getModel()).addRow(pay.displayRow());
                
                Personne.personneCourante.resteRegler -= pay.montant;
                
                if (MODE == MODE_CLIENT) 
                    setupClient(null, false);
                else
                    setupFournisseur(null, false);
                jDialogAddPayement.dispose();
            } catch (Exception e) {
                jLabelOption.setText("Valeur numérique invalide");
                JOptionPane.showMessageDialog(null, jLabelOption, "Erreur", JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }//GEN-LAST:event_jButtonAddPayConfirmerActionPerformed

    private void jButtonPersonnePayConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPersonnePayConfirmerActionPerformed
        jDialogPersonneInfo.dispose();
    }//GEN-LAST:event_jButtonPersonnePayConfirmerActionPerformed

    private void jButtonAddPayRegleAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPayRegleAddActionPerformed
        if (!jTextFieldAddPayRegleAdd.getText().isEmpty()) {
            jComboBoxAddPayRegle.addItem(jTextFieldAddPayRegleAdd.getText());
            Reglement.listModeReg.add(jTextFieldAddPayRegleAdd.getText());
            jComboBoxAddPayRegle.setSelectedItem(jTextFieldAddPayRegleAdd.getText());
            jTextFieldAddPayRegleAdd.setText("");
        }
    }//GEN-LAST:event_jButtonAddPayRegleAddActionPerformed

    private void jButtonAddPayRegleRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPayRegleRemoveActionPerformed
        if (jComboBoxAddPayRegle.getItemCount() > 0) {
            Reglement.listModeReg.remove((String)jComboBoxAddPayRegle.getSelectedItem());
            jComboBoxAddPayRegle.removeItem(jComboBoxAddPayRegle.getSelectedItem());
        }
    }//GEN-LAST:event_jButtonAddPayRegleRemoveActionPerformed

    private void jButtonPersonnePayRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPersonnePayRemoveActionPerformed
        int[] lig = jTablePersonnePay.getSelectedRows();
        if (lig.length > 0) {
            int tmp;
            for (int i=0; i < lig.length-1; i++) {
                for (int j=i+1; j < lig.length; j++) {
                    if (lig[i] < lig[j]) {
                        tmp = lig[j];
                        lig[j] = lig[i];
                        lig[i] = tmp;
                    }
                }
            }
            for (int i : lig) {
                Personne.personneCourante.listPayement.remove(Payement.get(Personne.personneCourante, jTablePersonnePay.getValueAt(i, 0).toString()));
                try{
                    Personne.personneCourante.resteRegler += VisDias.formatDouble.parse(jTablePersonnePay.getValueAt(i, 3).toString()).doubleValue();
                } catch (Exception e) {}
                ((javax.swing.table.DefaultTableModel)jTablePersonnePay.getModel()).removeRow(i);
            }
            if (MODE == MODE_CLIENT) 
                setupClient(null, false);
            else
                setupFournisseur(null, false);
        }
    }//GEN-LAST:event_jButtonPersonnePayRemoveActionPerformed

    private void jButtonAccueilCompteActionPerformed(java.awt.event.ActionEvent evt){
        CompteFinance.MODE_COMPTE = CompteFinance.MODE_COMPTE_LOG;
        jListCompte.setListData(CompteFinance.display());
        jPasswordFieldCompteMDP.setText("");
        
        jDialogCompte.getRootPane().setDefaultButton(jButtonCompteConfirmer);
        jDialogCompte.setVisible(true);
    }
    private void jButtonAccueilAddCompteActionPerformed(java.awt.event.ActionEvent evt){
        jTextFieldAddCompteNom.setText("");
        jPasswordFieldAddCompteMDP.setText("");
        jPasswordFieldAddCompteCMDP.setText("");
        
        jDialogAddCompte.getRootPane().setDefaultButton(jButtonAddCompteConfirmer);
        jDialogAddCompte.setVisible(true);
    }
    private void jButtonAccueilEditCompteActionPerformed(java.awt.event.ActionEvent evt){
        if(CompteFinance.compteActif != null)
            setupCoordonnee(CompteFinance.compteActif.getCrd());
    }
    private void jButtonAccueilRemoveCompteActionPerformed(java.awt.event.ActionEvent evt){
        CompteFinance.MODE_COMPTE = CompteFinance.MODE_COMPTE_REMOVE;
        jListCompte.setListData(CompteFinance.display());
        jPasswordFieldCompteMDP.setText("");
        
        jDialogCompte.getRootPane().setDefaultButton(jButtonCompteConfirmer);
        jDialogCompte.setVisible(true);
    }

    private void jTableBigDoubleClick(int row){
        if(MODE == MODE_CLIENT){
            Personne.personneCourante = Client.get((String)jTableBig.getValueAt(row, 0));
            setupPayement(Personne.personneCourante);
        }else if(MODE == MODE_FOURNISSEUR){
            Personne.personneCourante = Fournisseur.get((String)jTableBig.getValueAt(row, 0));
            setupPayement(Personne.personneCourante);
        }
    }
    private void jTableSmall1DoubleClick(int row){
        if(MODE == MODE_ARTICLE_ACHAT){
            GroupeArticleAchat.groupeAchatActif = GroupeArticleAchat.get((String)jTableSmall1.getValueAt(row, 0));
            setupArticleAchat(GroupeArticleAchat.groupeAchatActif, null, null, null, false);
        }else if(MODE == MODE_ARTICLE_VENTE){
            GroupeArticleVente.groupeVenteActif = GroupeArticleVente.get((String)jTableSmall1.getValueAt(row, 0));
            setupArticleVente(GroupeArticleVente.groupeVenteActif, null, null, null, false);
        }else if(MODE == MODE_BON_ACHAT){
            Bon.BonActif = BonAchat.get((String)jTableSmall1.getValueAt(row, 0));
            setupAchat(null, null, null, true, null);
        }else if(MODE == MODE_BON_VENTE){
            Bon.BonActif = BonVente.get((String)jTableSmall1.getValueAt(row, 0));
            setupVente(null, null, null, true, null);
        }else if(MODE == MODE_CONSO){
            GroupeConso.GroupeConsoActif = GroupeConso.get((String)jTableSmall1.getValueAt(row, 0));
            setupConsommation(GroupeConso.GroupeConsoActif, null, null, null);
        }
        jTableSmall1.clearSelection();
    }
    private void jTableBonArticle1DoubleClick(int row){
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel)jTableBonArticle2.getModel();
         int qt = 0;     double ut = 0;   double tva = 0;
        try {
            qt = VisDias.formatInt.parse((String)jTableBonArticle1.getValueAt(row, 4)).intValue();
            ut = VisDias.formatDouble.parse((String)jTableBonArticle1.getValueAt(row, 5)).doubleValue();
            tva = VisDias.formatDouble.parse((String)jTableBonArticle1.getValueAt(row, 6)).doubleValue();
        } catch (ParseException ex) {
            
        }
        double pt = (double)qt*ut;
                
        model.addRow(new Object[]{jTableBonArticle1.getValueAt(row, 0),
                                  jTableBonArticle1.getValueAt(row, 1),
                                  jTableBonArticle1.getValueAt(row, 3),
                                  VisDias.formatInt.format(qt),
                                  VisDias.formatDouble.format(ut), 
                                  VisDias.formatDouble.format(pt),
                                  VisDias.formatDouble.format(tva),
                                  VisDias.formatDouble.format(ut + ut*tva/100),
                                  VisDias.formatDouble.format(pt + pt*tva/100)
                                  });
        pt = calculBon(5);
        ut = calculBon(8);
        if(pt != -1 && ut != -1){
            jTextFieldBonArticleSomHT.setText(VisDias.formatDouble.format(pt));
            jTextFieldBonArticleSomTTC.setText(VisDias.formatDouble.format(ut));
        }else{
            jTextFieldBonArticleSomHT.setText("Erreur !");
            jTextFieldBonArticleSomTTC.setText("Erreur !");
        }
    }
    private void jTableBonArticle2DoubleClick(int row){
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel)jTableBonArticle2.getModel();
        model.removeRow(row);
        double pt = calculBon(5);
        double ut = calculBon(8);
        if(pt != -1 && ut != -1){
            jTextFieldBonArticleSomHT.setText(VisDias.formatDouble.format(pt));
            jTextFieldBonArticleSomTTC.setText(VisDias.formatDouble.format(ut));
        }else{
            jTextFieldBonArticleSomHT.setText("Erreur !");
            jTextFieldBonArticleSomTTC.setText("Erreur !");
        }
    }
    private void jTableBonArticle2ValueChanged(){
        int row = jTableBonArticle2.getSelectedRow();
        int column = jTableBonArticle2.getSelectedColumn();
        if(row > -1 && column > -1){
            double tva = 0;    int qt = 0;    double pu = 0;    double pt = 0;    boolean correct = true;   boolean correct2 = true;
            try {   tva = VisDias.formatDouble.parse((String)jTableBonArticle2.getValueAt(row, 6)).intValue();
            } catch (ParseException ex) {}
            try{    qt = VisDias.formatInt.parse((String)jTableBonArticle2.getValueAt(row, 3)).intValue();
            }catch(Exception e){    jTableBonArticle2.setValueAt("Erreur", row, 3);   jTableBonArticle2.setValueAt("Erreur", row, 5);   jTableBonArticle2.setValueAt("Erreur", row, 8);   correct = false;}
            
            try{    pu = VisDias.formatDouble.parse((String)jTableBonArticle2.getValueAt(row, 4)).doubleValue();
            }catch(Exception e){    jTableBonArticle2.setValueAt("Erreur", row, 4);   jTableBonArticle2.setValueAt("Erreur", row, 5);   jTableBonArticle2.setValueAt("Erreur", row, 8);     jTableBonArticle2.setValueAt("Erreur", row, 7);    correct = false;}
            
            try{    pt = VisDias.formatDouble.parse((String)jTableBonArticle2.getValueAt(row, 5)).doubleValue();
            }catch(Exception e){    jTableBonArticle2.setValueAt("Erreur", row, 5);   jTableBonArticle2.setValueAt("Erreur", row, 8);   correct2 = false;}
            
            if((column == 3 || column == 4) && correct){
                pt = (double)qt*pu;
                jTableBonArticle2.setValueAt(VisDias.formatDouble.format(pt), row, 5);
                jTableBonArticle2.setValueAt(VisDias.formatDouble.format((double)pu + pu*tva/100), row, 7);
                jTableBonArticle2.setValueAt(VisDias.formatDouble.format((double)pt + pt*tva/100), row, 8);
            }else if(column == 5 && correct2){
                jTableBonArticle2.setValueAt(VisDias.formatDouble.format((double)pt + pt*tva/100), row, 8);
            }
            pt = calculBon(5);
            pu = calculBon(8);
            if(pt != -1 && pu != -1){
                jTextFieldBonArticleSomHT.setText(VisDias.formatDouble.format(pt));
                jTextFieldBonArticleSomTTC.setText(VisDias.formatDouble.format(pu));
            }else{
                jTextFieldBonArticleSomHT.setText("Erreur !");
                jTextFieldBonArticleSomTTC.setText("Erreur !");     
            }
        }
    }
    
    private int showWarningMessage(String message){
        String[] buttonLabels = new String[]{"Oui", "Non", "Annuler"};
        String defaultOption = buttonLabels[0];
        Icon icon = null;
        return JOptionPane.showOptionDialog(this, message,
                                            "Alerte", JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.WARNING_MESSAGE, icon,
                                            buttonLabels, defaultOption);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisDiasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisDiasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisDiasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisDiasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisDiasGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccueil;
    private javax.swing.JButton jButtonAchat;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddArticleAddUnite;
    private javax.swing.JButton jButtonAddArticleAnnuler;
    private javax.swing.JButton jButtonAddArticleConfirmer;
    private javax.swing.JButton jButtonAddArticleRemoveUnite;
    private javax.swing.JButton jButtonAddCompteAnnuler;
    private javax.swing.JButton jButtonAddCompteConfirmer;
    private javax.swing.JButton jButtonAddConsoAddUnite;
    private javax.swing.JButton jButtonAddConsoAnnuler;
    private javax.swing.JButton jButtonAddConsoAnnuler1;
    private javax.swing.JButton jButtonAddConsoConfirmer;
    private javax.swing.JButton jButtonAddConsoRemoveUnite;
    private javax.swing.JButton jButtonAddConsoSuivant;
    private javax.swing.JButton jButtonAddGroupeAnnuler;
    private javax.swing.JButton jButtonAddGroupeConfirmer;
    private javax.swing.JButton jButtonAddGroupeConsoAnnuler;
    private javax.swing.JButton jButtonAddGroupeConsoConfirmer;
    private javax.swing.JButton jButtonAddPayAnnuler;
    private javax.swing.JButton jButtonAddPayConfirmer;
    private javax.swing.JButton jButtonAddPayRegleAdd;
    private javax.swing.JButton jButtonAddPayRegleRemove;
    private javax.swing.JButton jButtonAddPersonneAnnuler;
    private javax.swing.JButton jButtonAddPersonneConfirmer;
    private javax.swing.JButton jButtonArticleAchat;
    private javax.swing.JButton jButtonArticleVente;
    private javax.swing.JButton jButtonBonArticleAddArticle;
    private javax.swing.JButton jButtonBonArticleAnnuler;
    private javax.swing.JButton jButtonBonArticleConfirmer;
    private javax.swing.JButton jButtonBonArticleModifier;
    private javax.swing.JButton jButtonBonPersonneAnnuler;
    private javax.swing.JButton jButtonBonPersonneSuivant;
    private javax.swing.JButton jButtonCbAnnuler;
    private javax.swing.JButton jButtonCbConfirmer;
    private javax.swing.JButton jButtonClient;
    private javax.swing.JButton jButtonCompteAnnuler;
    private javax.swing.JButton jButtonCompteConfirmer;
    private javax.swing.JButton jButtonConso;
    private javax.swing.JButton jButtonCoordonneAnnuler;
    private javax.swing.JButton jButtonCoordonneConfirmer;
    private javax.swing.JButton jButtonDepense;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonFournisseur;
    private javax.swing.JButton jButtonImprimer;
    private javax.swing.JButton jButtonImprimerAnnuler;
    private javax.swing.JButton jButtonImprimerConfirmer;
    private javax.swing.JButton jButtonPersonneCrAnnuler;
    private javax.swing.JButton jButtonPersonneCrConfirmer;
    private javax.swing.JButton jButtonPersonnePayAdd;
    private javax.swing.JButton jButtonPersonnePayConfirmer;
    private javax.swing.JButton jButtonPersonnePayRemove;
    private javax.swing.JButton jButtonRapport;
    private javax.swing.JButton jButtonRapportArticleAnnuler;
    private javax.swing.JButton jButtonRapportArticleConfirmer;
    private javax.swing.JButton jButtonRapportBonAnnuler;
    private javax.swing.JButton jButtonRapportBonConfirmer;
    private javax.swing.JButton jButtonRapportConsoAnnuler;
    private javax.swing.JButton jButtonRapportConsoConfirmer;
    private javax.swing.JButton jButtonRapportPersonneAnnuler;
    private javax.swing.JButton jButtonRapportPersonneConfirmer;
    private javax.swing.JButton jButtonRapportRegleAnnuler;
    private javax.swing.JButton jButtonRapportRegleConfirmer;
    private javax.swing.JButton jButtonRapportRegleSolde;
    private javax.swing.JButton jButtonRecette;
    private javax.swing.JButton jButtonRegleAnnuler;
    private javax.swing.JButton jButtonRegleCBAdd;
    private javax.swing.JButton jButtonRegleCBRemove;
    private javax.swing.JButton jButtonRegleConfirmer;
    private javax.swing.JButton jButtonRegleModeAdd;
    private javax.swing.JButton jButtonRegleModeRemove;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonResultatArticleOk;
    private javax.swing.JButton jButtonResultatBonOk;
    private javax.swing.JButton jButtonResultatConsoOk;
    private javax.swing.JButton jButtonResultatPersonneOk;
    private javax.swing.JButton jButtonResultatRegleOk;
    private javax.swing.JButton jButtonSauvegarde;
    private javax.swing.JButton jButtonUndo;
    private javax.swing.JButton jButtonVente;
    private javax.swing.JCheckBox jCheckBoxAddConsoArticle;
    private javax.swing.JCheckBox jCheckBoxAddConsoQtUT;
    private javax.swing.JCheckBox jCheckBoxBonArticleRAR;
    private javax.swing.JCheckBox jCheckBoxBonArticleTimbre;
    private javax.swing.JCheckBox jCheckBoxRapportArticleDate;
    private javax.swing.JCheckBox jCheckBoxRapportArticleQt;
    private javax.swing.JCheckBox jCheckBoxRapportBonDate;
    private javax.swing.JCheckBox jCheckBoxRapportConsoDate;
    private javax.swing.JCheckBox jCheckBoxRapportPersonneRAR;
    private javax.swing.JCheckBox jCheckBoxRapportRegleDate;
    private javax.swing.JComboBox jComboBoxAddArticleGroupe;
    private javax.swing.JComboBox jComboBoxAddArticleUnite;
    private javax.swing.JComboBox jComboBoxAddConsoGroupe;
    private javax.swing.JComboBox jComboBoxAddConsoGroupeArticle;
    private javax.swing.JComboBox jComboBoxAddConsoQtUT;
    private javax.swing.JComboBox jComboBoxAddConsoUnite;
    private javax.swing.JComboBox jComboBoxAddPayRegle;
    private javax.swing.JComboBox jComboBoxBonArticleGroupe;
    private javax.swing.JComboBox jComboBoxImprimerModele;
    private javax.swing.JComboBox jComboBoxRapportBonPersonne;
    private javax.swing.JComboBox jComboBoxRapportRegleMode;
    private javax.swing.JComboBox jComboBoxRapportReglePersonne;
    private javax.swing.JComboBox jComboBoxRegleMode;
    private javax.swing.JComboBox jComboBoxReglePersonne;
    private javax.swing.JDialog jDialogAddArticle;
    private javax.swing.JDialog jDialogAddCompte;
    private javax.swing.JDialog jDialogAddConso;
    private javax.swing.JDialog jDialogAddConso1;
    private javax.swing.JDialog jDialogAddPayement;
    private javax.swing.JDialog jDialogAddPersonne;
    private javax.swing.JDialog jDialogBonArticle;
    private javax.swing.JDialog jDialogBonPersonne;
    private javax.swing.JDialog jDialogCb;
    private javax.swing.JDialog jDialogCompte;
    private javax.swing.JDialog jDialogCoordonnee;
    private javax.swing.JDialog jDialogImprimer;
    private javax.swing.JDialog jDialogPersonneInfo;
    private javax.swing.JDialog jDialogRapportArticle;
    private javax.swing.JDialog jDialogRapportBon;
    private javax.swing.JDialog jDialogRapportConso;
    private javax.swing.JDialog jDialogRapportPersonne;
    private javax.swing.JDialog jDialogRapportReglement;
    private javax.swing.JDialog jDialogRegle;
    private javax.swing.JDialog jDialogResultatArticle;
    private javax.swing.JDialog jDialogResultatBon;
    private javax.swing.JDialog jDialogResultatConso;
    private javax.swing.JDialog jDialogResultatPersonne;
    private javax.swing.JDialog jDialogResultatRegle;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAddArticleDA;
    private javax.swing.JLabel jLabelAddArticleDate;
    private javax.swing.JLabel jLabelAddArticleDesignation;
    private javax.swing.JLabel jLabelAddArticleGroupe;
    private javax.swing.JLabel jLabelAddArticlePU;
    private javax.swing.JLabel jLabelAddArticlePourcent;
    private javax.swing.JLabel jLabelAddArticlePrincipal;
    private javax.swing.JLabel jLabelAddArticleQT;
    private javax.swing.JLabel jLabelAddArticleSlash1;
    private javax.swing.JLabel jLabelAddArticleSlash2;
    private javax.swing.JLabel jLabelAddArticleTVA;
    private javax.swing.JLabel jLabelAddArticleUnite;
    private javax.swing.JLabel jLabelAddCompteCMDP;
    private javax.swing.JLabel jLabelAddCompteMDP;
    private javax.swing.JLabel jLabelAddCompteNom;
    private javax.swing.JLabel jLabelAddComptePrincipal;
    private javax.swing.JLabel jLabelAddConsoDA;
    private javax.swing.JLabel jLabelAddConsoDA1;
    private javax.swing.JLabel jLabelAddConsoDate1;
    private javax.swing.JLabel jLabelAddConsoDesignation;
    private javax.swing.JLabel jLabelAddConsoGroupe;
    private javax.swing.JLabel jLabelAddConsoPT;
    private javax.swing.JLabel jLabelAddConsoPU;
    private javax.swing.JLabel jLabelAddConsoPrincipal;
    private javax.swing.JLabel jLabelAddConsoPrincipal1;
    private javax.swing.JLabel jLabelAddConsoQT;
    private javax.swing.JLabel jLabelAddConsoSlash3;
    private javax.swing.JLabel jLabelAddConsoSlash4;
    private javax.swing.JLabel jLabelAddConsoUnite;
    private javax.swing.JLabel jLabelAddGroupeConsoDesignation;
    private javax.swing.JLabel jLabelAddGroupeConsoPrincipal;
    private javax.swing.JLabel jLabelAddGroupeDesignation;
    private javax.swing.JLabel jLabelAddGroupePrincipal;
    private javax.swing.JLabel jLabelAddPayDA;
    private javax.swing.JLabel jLabelAddPayDate;
    private javax.swing.JLabel jLabelAddPayPT;
    private javax.swing.JLabel jLabelAddPayPrincipal;
    private javax.swing.JLabel jLabelAddPayRegle;
    private javax.swing.JLabel jLabelAddPaySlash1;
    private javax.swing.JLabel jLabelAddPaySlash2;
    private javax.swing.JLabel jLabelAddPersonneAdresse;
    private javax.swing.JLabel jLabelAddPersonneCA;
    private javax.swing.JLabel jLabelAddPersonneDA1;
    private javax.swing.JLabel jLabelAddPersonneDA2;
    private javax.swing.JLabel jLabelAddPersonneDesignation;
    private javax.swing.JLabel jLabelAddPersonnePrincipal;
    private javax.swing.JLabel jLabelAddPersonneRAR;
    private javax.swing.JLabel jLabelBonArticleGroupe;
    private javax.swing.JLabel jLabelBonArticlePrincipal1;
    private javax.swing.JLabel jLabelBonArticlePrincipal2;
    private javax.swing.JLabel jLabelBonArticleSomHT;
    private javax.swing.JLabel jLabelBonArticleSomTTC;
    private javax.swing.JLabel jLabelBonPersonneDate;
    private javax.swing.JLabel jLabelBonPersonneDesignation;
    private javax.swing.JLabel jLabelBonPersonnePrincipal;
    private javax.swing.JLabel jLabelBonPersonneSlash1;
    private javax.swing.JLabel jLabelBonPersonneSlash2;
    private javax.swing.JLabel jLabelCbAgence;
    private javax.swing.JLabel jLabelCbBanque;
    private javax.swing.JLabel jLabelCbNum;
    private javax.swing.JLabel jLabelCbPrincipal;
    private javax.swing.JLabel jLabelCompteMDP;
    private javax.swing.JLabel jLabelCoordonneeAdresse;
    private javax.swing.JLabel jLabelCoordonneeArt;
    private javax.swing.JLabel jLabelCoordonneeCevilite;
    private javax.swing.JLabel jLabelCoordonneeCptBanque;
    private javax.swing.JLabel jLabelCoordonneeDesignation;
    private javax.swing.JLabel jLabelCoordonneeFonction;
    private javax.swing.JLabel jLabelCoordonneeNIF;
    private javax.swing.JLabel jLabelCoordonneeNIS;
    private javax.swing.JLabel jLabelCoordonneePrincipal;
    private javax.swing.JLabel jLabelCoordonneeRC;
    private javax.swing.JLabel jLabelCoordonneeTel;
    private javax.swing.JLabel jLabelImprimerPrincipal;
    private javax.swing.JLabel jLabelPersonneCrAdresse;
    private javax.swing.JLabel jLabelPersonneCrArt;
    private javax.swing.JLabel jLabelPersonneCrCevilite;
    private javax.swing.JLabel jLabelPersonneCrCptBanque;
    private javax.swing.JLabel jLabelPersonneCrDesignation;
    private javax.swing.JLabel jLabelPersonneCrFonction;
    private javax.swing.JLabel jLabelPersonneCrNIF;
    private javax.swing.JLabel jLabelPersonneCrNIS;
    private javax.swing.JLabel jLabelPersonneCrPrincipal;
    private javax.swing.JLabel jLabelPersonneCrRC;
    private javax.swing.JLabel jLabelPersonneCrTel;
    private javax.swing.JLabel jLabelPersonnePayPrincipal;
    private javax.swing.JLabel jLabelRapportArticleDateAu;
    private javax.swing.JLabel jLabelRapportArticleDateDu;
    private javax.swing.JLabel jLabelRapportArticleDesignation;
    private javax.swing.JLabel jLabelRapportArticlePrincipal;
    private javax.swing.JLabel jLabelRapportArticleQt;
    private javax.swing.JLabel jLabelRapportArticleSlash1;
    private javax.swing.JLabel jLabelRapportArticleSlash2;
    private javax.swing.JLabel jLabelRapportArticleSlash3;
    private javax.swing.JLabel jLabelRapportArticleSlash4;
    private javax.swing.JLabel jLabelRapportBonDateAu;
    private javax.swing.JLabel jLabelRapportBonDateDu;
    private javax.swing.JLabel jLabelRapportBonDesignation;
    private javax.swing.JLabel jLabelRapportBonPersonne;
    private javax.swing.JLabel jLabelRapportBonPrincipal;
    private javax.swing.JLabel jLabelRapportBonSlash1;
    private javax.swing.JLabel jLabelRapportBonSlash2;
    private javax.swing.JLabel jLabelRapportBonSlash3;
    private javax.swing.JLabel jLabelRapportBonSlash4;
    private javax.swing.JLabel jLabelRapportConsoDateAu;
    private javax.swing.JLabel jLabelRapportConsoDateDu;
    private javax.swing.JLabel jLabelRapportConsoDesignation;
    private javax.swing.JLabel jLabelRapportConsoPrincipal;
    private javax.swing.JLabel jLabelRapportConsoSlash1;
    private javax.swing.JLabel jLabelRapportConsoSlash2;
    private javax.swing.JLabel jLabelRapportConsoSlash3;
    private javax.swing.JLabel jLabelRapportConsoSlash4;
    private javax.swing.JLabel jLabelRapportPersonneDesignation;
    private javax.swing.JLabel jLabelRapportPersonnePrincipal;
    private javax.swing.JLabel jLabelRapportPersonneRAR;
    private javax.swing.JLabel jLabelRapportRegleDateAu;
    private javax.swing.JLabel jLabelRapportRegleDateDu;
    private javax.swing.JLabel jLabelRapportRegleDesignation;
    private javax.swing.JLabel jLabelRapportRegleMode;
    private javax.swing.JLabel jLabelRapportReglePersonne;
    private javax.swing.JLabel jLabelRapportReglePrincipal;
    private javax.swing.JLabel jLabelRapportRegleSlash1;
    private javax.swing.JLabel jLabelRapportRegleSlash2;
    private javax.swing.JLabel jLabelRapportRegleSlash3;
    private javax.swing.JLabel jLabelRapportRegleSlash4;
    private javax.swing.JLabel jLabelRegleCB;
    private javax.swing.JLabel jLabelRegleDate;
    private javax.swing.JLabel jLabelRegleDesig;
    private javax.swing.JLabel jLabelRegleMode;
    private javax.swing.JLabel jLabelRegleMontant;
    private javax.swing.JLabel jLabelReglePersonne;
    private javax.swing.JLabel jLabelReglePrincipal;
    private javax.swing.JLabel jLabelRegleSlash1;
    private javax.swing.JLabel jLabelRegleSlash2;
    private javax.swing.JLabel jLabelResultatArticleDateAu;
    private javax.swing.JLabel jLabelResultatArticleDateDu;
    private javax.swing.JLabel jLabelResultatArticleNbArticle;
    private javax.swing.JLabel jLabelResultatArticlePrincipal;
    private javax.swing.JLabel jLabelResultatArticlePrixHT;
    private javax.swing.JLabel jLabelResultatArticlePrixTTC;
    private javax.swing.JLabel jLabelResultatArticlePrixTVA;
    private javax.swing.JLabel jLabelResultatBonDateAu;
    private javax.swing.JLabel jLabelResultatBonDateDu;
    private javax.swing.JLabel jLabelResultatBonNbArticle;
    private javax.swing.JLabel jLabelResultatBonPrincipal;
    private javax.swing.JLabel jLabelResultatBonPrixHT;
    private javax.swing.JLabel jLabelResultatBonPrixTTC;
    private javax.swing.JLabel jLabelResultatBonPrixTVA;
    private javax.swing.JLabel jLabelResultatConsoDateAu;
    private javax.swing.JLabel jLabelResultatConsoDateDu;
    private javax.swing.JLabel jLabelResultatConsoNbArticle;
    private javax.swing.JLabel jLabelResultatConsoPrincipal;
    private javax.swing.JLabel jLabelResultatConsoPrix;
    private javax.swing.JLabel jLabelResultatPersonneCA;
    private javax.swing.JLabel jLabelResultatPersonneNbArticle;
    private javax.swing.JLabel jLabelResultatPersonnePrincipal;
    private javax.swing.JLabel jLabelResultatPersonneRAR;
    private javax.swing.JLabel jLabelResultatRegleDateAu;
    private javax.swing.JLabel jLabelResultatRegleDateDu;
    private javax.swing.JLabel jLabelResultatRegleNb;
    private javax.swing.JLabel jLabelResultatReglePrincipal;
    private javax.swing.JLabel jLabelResultatReglePrix;
    private javax.swing.JLabel jLabelRubriqueCourante;
    private javax.swing.JList jListCompte;
    private javax.swing.JPanel jPanelAddArticleTab;
    private javax.swing.JPanel jPanelAddConsoTab;
    private javax.swing.JPanel jPanelAddGroupeConsoTab;
    private javax.swing.JPanel jPanelAddGroupeTab;
    private javax.swing.JPanel jPanelPersonneCr;
    private javax.swing.JPanel jPanelPersonnePayement;
    private javax.swing.JPasswordField jPasswordFieldAddCompteCMDP;
    private javax.swing.JPasswordField jPasswordFieldAddCompteMDP;
    private javax.swing.JPasswordField jPasswordFieldCompteMDP;
    private javax.swing.JScrollPane jScrollPaneAddConsoArticle;
    private javax.swing.JScrollPane jScrollPaneBonArticle1;
    private javax.swing.JScrollPane jScrollPaneBonArticle2;
    private javax.swing.JScrollPane jScrollPaneBonPersonne;
    private javax.swing.JScrollPane jScrollPaneCompte;
    private javax.swing.JScrollPane jScrollPanePersonnePay;
    private javax.swing.JScrollPane jScrollPaneRegleCB;
    private javax.swing.JToolBar.Separator jSeparatorOutils;
    private javax.swing.JSpinner jSpinnerAddArticleAnnee;
    private javax.swing.JSpinner jSpinnerAddArticleJour;
    private javax.swing.JSpinner jSpinnerAddArticleMois;
    private javax.swing.JSpinner jSpinnerAddConsoAnnee;
    private javax.swing.JSpinner jSpinnerAddConsoJour;
    private javax.swing.JSpinner jSpinnerAddConsoMois;
    private javax.swing.JSpinner jSpinnerAddPayAnnee;
    private javax.swing.JSpinner jSpinnerAddPayJour;
    private javax.swing.JSpinner jSpinnerAddPayMois;
    private javax.swing.JSpinner jSpinnerBonPersonneAnnee;
    private javax.swing.JSpinner jSpinnerBonPersonneJour;
    private javax.swing.JSpinner jSpinnerBonPersonneMois;
    private javax.swing.JSpinner jSpinnerRapportArticleDateAuAnnee;
    private javax.swing.JSpinner jSpinnerRapportArticleDateAuJour;
    private javax.swing.JSpinner jSpinnerRapportArticleDateAuMois;
    private javax.swing.JSpinner jSpinnerRapportArticleDateDuAnnee;
    private javax.swing.JSpinner jSpinnerRapportArticleDateDuJour;
    private javax.swing.JSpinner jSpinnerRapportArticleDateDuMois;
    private javax.swing.JSpinner jSpinnerRapportBonDateAuAnnee;
    private javax.swing.JSpinner jSpinnerRapportBonDateAuJour;
    private javax.swing.JSpinner jSpinnerRapportBonDateAuMois;
    private javax.swing.JSpinner jSpinnerRapportBonDateDuAnnee;
    private javax.swing.JSpinner jSpinnerRapportBonDateDuJour;
    private javax.swing.JSpinner jSpinnerRapportBonDateDuMois;
    private javax.swing.JSpinner jSpinnerRapportConsoDateAuAnnee;
    private javax.swing.JSpinner jSpinnerRapportConsoDateAuJour;
    private javax.swing.JSpinner jSpinnerRapportConsoDateAuMois;
    private javax.swing.JSpinner jSpinnerRapportConsoDateDuAnnee;
    private javax.swing.JSpinner jSpinnerRapportConsoDateDuJour;
    private javax.swing.JSpinner jSpinnerRapportConsoDateDuMois;
    private javax.swing.JSpinner jSpinnerRapportRegleDateAuAnnee;
    private javax.swing.JSpinner jSpinnerRapportRegleDateAuJour;
    private javax.swing.JSpinner jSpinnerRapportRegleDateAuMois;
    private javax.swing.JSpinner jSpinnerRapportRegleDateDuAnnee;
    private javax.swing.JSpinner jSpinnerRapportRegleDateDuJour;
    private javax.swing.JSpinner jSpinnerRapportRegleDateDuMois;
    private javax.swing.JSpinner jSpinnerRegleAnnee;
    private javax.swing.JSpinner jSpinnerRegleJour;
    private javax.swing.JSpinner jSpinnerRegleMois;
    private javax.swing.JTabbedPane jTabbedPaneAddArticle;
    private javax.swing.JTabbedPane jTabbedPaneAddConso;
    private javax.swing.JTabbedPane jTabbedPanePersonneInfo;
    private javax.swing.JTable jTableAddConsoArticle;
    private javax.swing.JTable jTableBonArticle1;
    private javax.swing.JTable jTableBonArticle2;
    private javax.swing.JTable jTableBonPersonne;
    private javax.swing.JTable jTablePersonnePay;
    private javax.swing.JTable jTableRegleCB;
    private javax.swing.JTextField jTextFieldAddArticleAddUnite;
    private javax.swing.JTextField jTextFieldAddArticleDesignation;
    private javax.swing.JTextField jTextFieldAddArticlePU;
    private javax.swing.JTextField jTextFieldAddArticleQT;
    private javax.swing.JTextField jTextFieldAddArticleTVA;
    private javax.swing.JTextField jTextFieldAddCompteNom;
    private javax.swing.JTextField jTextFieldAddConsoAddUnite;
    private javax.swing.JTextField jTextFieldAddConsoDesignation;
    private javax.swing.JTextField jTextFieldAddConsoPT;
    private javax.swing.JTextField jTextFieldAddConsoPU;
    private javax.swing.JTextField jTextFieldAddConsoQT;
    private javax.swing.JTextField jTextFieldAddConsoQtUT;
    private javax.swing.JTextField jTextFieldAddGroupeConsoDesignation;
    private javax.swing.JTextField jTextFieldAddGroupeDesignation;
    private javax.swing.JTextField jTextFieldAddPayPT;
    private javax.swing.JTextField jTextFieldAddPayRegleAdd;
    private javax.swing.JTextField jTextFieldAddPersonneAdresse;
    private javax.swing.JTextField jTextFieldAddPersonneCA;
    private javax.swing.JTextField jTextFieldAddPersonneDesignation;
    private javax.swing.JTextField jTextFieldAddPersonneRAR;
    private javax.swing.JTextField jTextFieldBonArticleSomHT;
    private javax.swing.JTextField jTextFieldBonArticleSomTTC;
    private javax.swing.JTextField jTextFieldBonPersonneDesignation;
    private javax.swing.JTextField jTextFieldCbAgence;
    private javax.swing.JTextField jTextFieldCbBanque;
    private javax.swing.JTextField jTextFieldCbNum;
    private javax.swing.JTextField jTextFieldCoordonneeAdresse;
    private javax.swing.JTextField jTextFieldCoordonneeArt;
    private javax.swing.JTextField jTextFieldCoordonneeCevilite;
    private javax.swing.JTextField jTextFieldCoordonneeCptBanque;
    private javax.swing.JTextField jTextFieldCoordonneeDesignation;
    private javax.swing.JTextField jTextFieldCoordonneeFonction;
    private javax.swing.JTextField jTextFieldCoordonneeNIF;
    private javax.swing.JTextField jTextFieldCoordonneeNIS;
    private javax.swing.JTextField jTextFieldCoordonneeRC;
    private javax.swing.JTextField jTextFieldCoordonneeTel;
    private javax.swing.JTextField jTextFieldPersonneCrAdresse;
    private javax.swing.JTextField jTextFieldPersonneCrArt;
    private javax.swing.JTextField jTextFieldPersonneCrCevilite;
    private javax.swing.JTextField jTextFieldPersonneCrCptBanque;
    private javax.swing.JTextField jTextFieldPersonneCrDesignation;
    private javax.swing.JTextField jTextFieldPersonneCrFonction;
    private javax.swing.JTextField jTextFieldPersonneCrNIF;
    private javax.swing.JTextField jTextFieldPersonneCrNIS;
    private javax.swing.JTextField jTextFieldPersonneCrRC;
    private javax.swing.JTextField jTextFieldPersonneCrTel;
    private javax.swing.JTextField jTextFieldRapportArticleDesignation;
    private javax.swing.JTextField jTextFieldRapportBonDesignation;
    private javax.swing.JTextField jTextFieldRapportConsoDesignation;
    private javax.swing.JTextField jTextFieldRapportPersonneDesignation;
    private javax.swing.JTextField jTextFieldRapportRegleDesignation;
    private javax.swing.JTextField jTextFieldRegleDesig;
    private javax.swing.JTextField jTextFieldRegleModeAdd;
    private javax.swing.JTextField jTextFieldRegleMontant;
    private javax.swing.JTextField jTextFieldResultatArticleDateAu;
    private javax.swing.JTextField jTextFieldResultatArticleDateDu;
    private javax.swing.JTextField jTextFieldResultatArticleNbArticle;
    private javax.swing.JTextField jTextFieldResultatArticlePrixHT;
    private javax.swing.JTextField jTextFieldResultatArticlePrixTTC;
    private javax.swing.JTextField jTextFieldResultatArticlePrixTVA;
    private javax.swing.JTextField jTextFieldResultatBonDateAu;
    private javax.swing.JTextField jTextFieldResultatBonDateDu;
    private javax.swing.JTextField jTextFieldResultatBonNbArticle;
    private javax.swing.JTextField jTextFieldResultatBonPrixHT;
    private javax.swing.JTextField jTextFieldResultatBonPrixTTC;
    private javax.swing.JTextField jTextFieldResultatBonPrixTVA;
    private javax.swing.JTextField jTextFieldResultatConsoDateAu;
    private javax.swing.JTextField jTextFieldResultatConsoDateDu;
    private javax.swing.JTextField jTextFieldResultatConsoNbArticle;
    private javax.swing.JTextField jTextFieldResultatConsoPrixHT;
    private javax.swing.JTextField jTextFieldResultatPersonneCA;
    private javax.swing.JTextField jTextFieldResultatPersonneNbArticle;
    private javax.swing.JTextField jTextFieldResultatPersonneRAR;
    private javax.swing.JTextField jTextFieldResultatRegleDateAu;
    private javax.swing.JTextField jTextFieldResultatRegleDateDu;
    private javax.swing.JTextField jTextFieldResultatRegleNb;
    private javax.swing.JTextField jTextFieldResultatReglePrix;
    private javax.swing.JToolBar jToolBarOutils;
    private javax.swing.JToolBar jToolBarRubriques;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JButton jButtonAccueilCompte;
    private javax.swing.JButton jButtonAccueilAddCompte;
    private javax.swing.JButton jButtonAccueilEditCompte;
    private javax.swing.JButton jButtonAccueilRemoveCompte;
    private javax.swing.JScrollPane jScrollPaneBig;
    private javax.swing.JScrollPane jScrollPaneSmall1;
    private javax.swing.JScrollPane jScrollPaneSmall2;
    private javax.swing.JTable jTableBig;
    private javax.swing.JTable jTableSmall1;
    private javax.swing.JTable jTableSmall2;    
    
    private javax.swing.JLabel jLabelOption;
    // Variables static
    final static int MODE_ACCUEIL = 0;
    final static int MODE_CLIENT = 1;
    final static int MODE_FOURNISSEUR = 2;
    final static int MODE_ARTICLE_ACHAT = 3;
    final static int MODE_ARTICLE_VENTE = 4;
    final static int MODE_BON_ACHAT = 5;
    final static int MODE_BON_VENTE = 6;
    final static int MODE_CONSO = 7;
    final static int MODE_RECETTE = 8;
    final static int MODE_DEPENSE = 9;
    
    public static int MODE = MODE_ACCUEIL;
    
    public int centerX;
    public int centerY;
    
    public static Object tmpObj = null;
    
    public static DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    public static DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    // End of variables static
    
}
