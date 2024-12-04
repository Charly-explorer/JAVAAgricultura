/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Controller.ProductionController;
import Model.Crops.Crop;
import Model.Production.Production;
import Utils.UtilGui;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author zulay
 */
public class FrmProduction extends javax.swing.JInternalFrame implements IView<Production>{
    ProductionController controller;
    FrmSearchProduction frmShearch;
    Production production;
    FrmCrops frmCrops;
    Crop crop;
    /**
     * Creates new form FrmProduction
     */
    public FrmProduction() {
        initComponents();
        controller = new ProductionController(this);
        formatDate(LocalDate.now(),txtDate);
    }

    public void setFrmCrops(FrmCrops frmCrops) {
        this.frmCrops = frmCrops;
    }
    
    @Override
    public void show(Production ent) {
        production=ent;
        if (ent==null) {
            clear();
            return;
        }
        //txtId.setText(String.valueOf(ent.getId()));
        txtCrop.setText(String.valueOf(ent.getCrop().getId()));
        formatDate(ent.getDate(), txtDate);
        txtAmount.setValue(ent.getAmount());
        txtAmountProduction.setValue(ent.getAmount2());
        txtPorcent.setText(String.valueOf(ent.getPercentProduction()));
        txtDestiny.setText(ent.getDestiny());
    }

    @Override
    public void showAll(List<Production> ents) {
        if(frmShearch==null){
            frmShearch = new  FrmSearchProduction(null,true);
            frmShearch.setFrmProduction(this);
        }
        frmShearch.setList(ents);
        frmShearch.setVisible(true);
    }

    @Override
    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showError(String err) {
        JOptionPane.showMessageDialog(this, err, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public boolean validateRequired() {
        return UtilGui.validateFields(txtCrop,txtDate,
                txtPorcent,txtDestiny);
    }
    
    public void formatDate(LocalDate date, JTextField txt) {
        if (date == null) {
            txt.setText("");
        } else {
            txt.setText(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }
    
    private void clear() {
        UtilGui.clearTxts(
                txtCrop,
                txtDate,
                txtPorcent,
                txtDestiny
        );
    }
    
    private void SetEditableStateTxts(boolean value){
        //txtId.setEditable(value);
        txtCrop.setEditable(value);
        txtDate.setEditable(value);
        txtAmount.setValue(0);
        txtAmountProduction.setValue(0);
        txtDestiny.setEditable(value);
    }
    
    public void calculatePercent(){
        double num = 0;
        if(getJSpinerValue(txtAmount) > 0 && getJSpinerValue(txtAmountProduction) > 0)
             num = (getJSpinerValue(txtAmount)*getJSpinerValue(txtAmountProduction))/100;
        txtPorcent.setText(String.valueOf(Math.min(num,100)));
           Double.parseDouble(String.valueOf(num));
    }
    
    public int getJSpinerValue(javax.swing.JSpinner txt){
        return Integer.parseUnsignedInt(String.valueOf(txt.getValue()));
    }
    
    public Production getProduction(){
        return production;
    }

    public ProductionController getController(){
        return controller;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCrop = new javax.swing.JTextField();
        txtPorcent = new javax.swing.JTextField();
        txtDestiny = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtDate = new javax.swing.JFormattedTextField();
        txtAmount = new javax.swing.JSpinner();
        txtAmountProduction = new javax.swing.JSpinner();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 241, 203));

        jLabel1.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sostenible64.png"))); // NOI18N
        jLabel1.setText("PRODUCCION");

        jLabel3.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cultivo");

        jLabel4.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha ");

        jLabel5.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cantidad");

        jLabel6.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cantidad de Producción");

        jLabel7.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Porcentaje de Producción");

        jLabel8.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Destino");

        txtCrop.setBackground(new java.awt.Color(255, 255, 255));
        txtCrop.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtCrop.setForeground(new java.awt.Color(0, 0, 0));
        txtCrop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCropMouseClicked(evt);
            }
        });

        txtPorcent.setEditable(false);
        txtPorcent.setBackground(new java.awt.Color(255, 255, 255));
        txtPorcent.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtPorcent.setForeground(new java.awt.Color(0, 0, 0));

        txtDestiny.setBackground(new java.awt.Color(255, 255, 255));
        txtDestiny.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtDestiny.setForeground(new java.awt.Color(0, 0, 0));

        btnClear.setFont(new java.awt.Font("Candara", 1, 17)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 0, 0));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agre46.png"))); // NOI18N
        btnClear.setText("Nuevo");
        btnClear.setBorderPainted(false);
        btnClear.setContentAreaFilled(false);
        btnClear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClear.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agre.png"))); // NOI18N
        btnClear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Candara", 1, 17)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 0));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guardar48.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.setBorderPainted(false);
        btnSave.setContentAreaFilled(false);
        btnSave.setEnabled(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guaradar.png"))); // NOI18N
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Candara", 1, 17)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(0, 0, 0));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search44.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setBorderPainted(false);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/serac64.png"))); // NOI18N
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtDate.setEditable(false);
        txtDate.setBackground(new java.awt.Color(255, 255, 255));

        txtAmount.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAmount.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        txtAmount.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtAmountStateChanged(evt);
            }
        });

        txtAmountProduction.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAmountProduction.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        txtAmountProduction.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtAmountProductionStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btnSave)
                        .addGap(94, 94, 94)
                        .addComponent(btnSearch))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8)
                                .addComponent(txtDestiny)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6)
                                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                            .addComponent(txtAmountProduction))
                                        .addComponent(jLabel4))
                                    .addGap(64, 64, 64)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7)
                                            .addComponent(txtPorcent, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                            .addComponent(txtAmount)))))
                            .addComponent(txtCrop, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(195, 195, 195))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPorcent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmountProduction, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnSearch)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
        SetEditableStateTxts(true);
        formatDate(LocalDate.now(),txtDate);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!validateRequired()) {
            showError("Faltan algunos datos por ingresar");
            return;
        }
        production = new Production(
                1, 
                crop,
                getJSpinerValue(txtAmount)
                , getJSpinerValue(txtAmountProduction), 
                txtDestiny.getText()
        );
        controller.create(production);
        txtPorcent.setText(String.valueOf(production.getPercentProduction()));
        this.SetEditableStateTxts(false);
        btnSave.setEnabled(false);
//        changeStateBtns();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        controller.readAll();
//        changeStateBtns();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtCropMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCropMouseClicked
        frmCrops.controller.readAll();
        crop = frmCrops.getCrop();
        txtCrop.setText(crop.getName());
    }//GEN-LAST:event_txtCropMouseClicked

    private void txtAmountStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtAmountStateChanged
        calculatePercent();
    }//GEN-LAST:event_txtAmountStateChanged

    private void txtAmountProductionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtAmountProductionStateChanged
        calculatePercent();
    }//GEN-LAST:event_txtAmountProductionStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner txtAmount;
    private javax.swing.JSpinner txtAmountProduction;
    private javax.swing.JTextField txtCrop;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtDestiny;
    private javax.swing.JTextField txtPorcent;
    // End of variables declaration//GEN-END:variables
}
