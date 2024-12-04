/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

package View;
import Controller.CropController;
import Model.Crops.Crop;
import Model.State.CropState;
import Model.State.HarvestedCropState;
import Model.State.LostCropState;
import Model.State.RipenningCropState;
import Model.State.SownCropState;
import Utils.UtilGui;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author zulay
 */
public class FrmCrops extends javax.swing.JInternalFrame implements IView<Crop>{
    CropController controller;
    Crop crop;
    FrmShearchCrops frmShearch;
    /** Creates new form FrmCrops */
    public FrmCrops() {
        initComponents();
        controller = new CropController(this);
        formatDate(LocalDate.now(),txtSowing);
    }
    
    @Override
    public void show(Crop ent) {
        crop=ent;
        if (ent==null) {
            clear();
            return;
        }
        txtId.setText(String.valueOf(ent.getId()));
        txtName.setText(ent.getName());
        txtArea.setText(ent.getArea());
        txtType.setText(ent.getType());
        formatDate(ent.getSowingDate(), txtSowing);
        formatDate(ent.getHarvestDate(), txtHarvest);
        txtState.setText(controller.convertStateToString(ent.getState()));
    }

    @Override
    public void showAll(List<Crop> ents) {
         if(frmShearch==null){
            frmShearch = new  FrmShearchCrops(null,true);
            frmShearch.setFrmCrop(this);
        }
        frmShearch.setEnts(ents);
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
        return UtilGui.validateFields(txtId,txtName,txtArea,txtType);
    }

    public Crop getCrop() {
        return crop;
    }
    
    public void changeStateBtns() {
        UtilGui.changeStateButtons(btnChangeState,btnLostCrop);
    }

    public CropController getController() {
        return controller;
    }
    
    private void clear(){
        UtilGui.clearTxts(
                txtId,
                txtName,
                txtArea,
                txtType,
                txtSowing,
                txtHarvest,
                txtState
        );
    }
    
    public void formatDate(LocalDate date, JTextField txt) {
        if (date == null) {
            txt.setText("");
        } else {
            txt.setText(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }
    
    private void SetEditableStateTxts(boolean value){
        txtId.setEditable(value);
        txtName.setEditable(value);
        txtArea.setEditable(value);
        txtType.setEditable(value);
    }
    
    public void changeState(Crop crop){
        if(crop.getState() instanceof SownCropState){
            crop.setState(new RipenningCropState(crop));
            showMessage("Estado actualizado a maduración");
        }else if(crop.getState() instanceof RipenningCropState){
            crop.setState(new HarvestedCropState(crop));
            crop.setHarvestDate(LocalDate.now());
            formatDate(LocalDate.now(),txtHarvest);
            showMessage("Estado actualizado a cosecha");
        }
        txtState.setText(controller.convertStateToString(crop.getState()));
    }
    
    public void cancelCrop(Crop crop){
        crop.setState(new LostCropState(crop));
        showMessage("El cultivo se ha perdido");
//        controller.convertStateToString(crop.getState());
        txtState.setText(controller.convertStateToString(crop.getState()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/Img/fon5.png"));
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(icon.getImage(),0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        txtSowing = new javax.swing.JFormattedTextField();
        txtHarvest = new javax.swing.JFormattedTextField();
        txtState = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnLostCrop = new javax.swing.JButton();
        btnChangeState = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 241, 203));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plan64.png"))); // NOI18N
        jLabel1.setText("CULTIVOS");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Id");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha de Siembra");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Fecha de Cosecha");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Estado");

        jLabel7.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Area de cultivo ");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Tipo de Cultivo ");

        txtId.setBackground(new java.awt.Color(255, 255, 255));
        txtId.setForeground(new java.awt.Color(0, 0, 0));

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        txtType.setBackground(new java.awt.Color(255, 255, 255));
        txtType.setForeground(new java.awt.Color(0, 0, 0));

        txtArea.setBackground(new java.awt.Color(255, 255, 255));
        txtArea.setForeground(new java.awt.Color(0, 0, 0));
        txtArea.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSowing.setEditable(false);
        txtSowing.setBackground(new java.awt.Color(255, 255, 255));
        txtSowing.setForeground(new java.awt.Color(0, 0, 0));
        txtSowing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSowingActionPerformed(evt);
            }
        });

        txtHarvest.setEditable(false);
        txtHarvest.setBackground(new java.awt.Color(255, 255, 255));
        txtHarvest.setForeground(new java.awt.Color(0, 0, 0));

        txtState.setEditable(false);
        txtState.setBackground(new java.awt.Color(255, 255, 255));
        txtState.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtState.setForeground(new java.awt.Color(0, 0, 0));

        btnSave.setFont(new java.awt.Font("Candara", 1, 17)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 0));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guardar48.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.setBorderPainted(false);
        btnSave.setContentAreaFilled(false);
        btnSave.setDefaultCapable(false);
        btnSave.setEnabled(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guaradar.png"))); // NOI18N
        btnSave.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guaradar.png"))); // NOI18N
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
        btnSearch.setDefaultCapable(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/serac64.png"))); // NOI18N
        btnSearch.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/serac64.png"))); // NOI18N
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Candara", 1, 17)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete46.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setDefaultCapable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete64.png"))); // NOI18N
        btnDelete.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete64.png"))); // NOI18N
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnLostCrop.setFont(new java.awt.Font("Candara", 1, 17)); // NOI18N
        btnLostCrop.setForeground(new java.awt.Color(0, 0, 0));
        btnLostCrop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sigue.png"))); // NOI18N
        btnLostCrop.setText("Perdida de Cosecha");
        btnLostCrop.setBorderPainted(false);
        btnLostCrop.setContentAreaFilled(false);
        btnLostCrop.setDefaultCapable(false);
        btnLostCrop.setEnabled(false);
        btnLostCrop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLostCrop.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/siguiente64.png"))); // NOI18N
        btnLostCrop.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/siguiente64.png"))); // NOI18N
        btnLostCrop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLostCrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLostCropActionPerformed(evt);
            }
        });

        btnChangeState.setFont(new java.awt.Font("Candara", 1, 17)); // NOI18N
        btnChangeState.setForeground(new java.awt.Color(0, 0, 0));
        btnChangeState.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sigue.png"))); // NOI18N
        btnChangeState.setText("Siguiente Estado");
        btnChangeState.setBorderPainted(false);
        btnChangeState.setContentAreaFilled(false);
        btnChangeState.setEnabled(false);
        btnChangeState.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChangeState.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/siguiente64.png"))); // NOI18N
        btnChangeState.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/serac64.png"))); // NOI18N
        btnChangeState.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChangeState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeStateActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Candara", 1, 17)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 0, 0));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agre46.png"))); // NOI18N
        btnClear.setText("Nuevo");
        btnClear.setBorderPainted(false);
        btnClear.setContentAreaFilled(false);
        btnClear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClear.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agre.png"))); // NOI18N
        btnClear.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agre.png"))); // NOI18N
        btnClear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addGap(58, 58, 58)
                        .addComponent(btnSave))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(btnSearch)
                        .addGap(52, 52, 52)
                        .addComponent(btnDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnChangeState)
                .addGap(60, 60, 60)
                .addComponent(btnLostCrop)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSowing)
                        .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName)
                    .addComponent(txtArea)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(txtHarvest, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(198, 198, 198)))
                .addGap(113, 113, 113))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSowing, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHarvest, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnSearch)
                        .addComponent(btnDelete)
                        .addComponent(btnLostCrop)
                        .addComponent(btnClear))
                    .addComponent(btnChangeState))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!validateRequired()) {
            showError("Faltan algunos datos por ingresar");
            return;
        }
        crop = new Crop(
                Integer.parseInt(txtId.getText()),
                txtName.getText(),
                txtArea.getText(),
                txtType.getText()
        );
        controller.create(crop);
        this.SetEditableStateTxts(false);
        btnSave.setEnabled(false);
        changeStateBtns();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        controller.readAll();
//        btnChangeState.setEnabled(true);
//        btnLostCrop.setEnabled(true);
        changeStateBtns();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (crop==null){
            showError("No hay ningun cultivo cargado");
            return;
        }
        int option = JOptionPane.showConfirmDialog(
            this, 
            "¿Está seguro que desea eliminar el cultivo actual?",
            "Confirmar Eliminación", 
            JOptionPane.YES_NO_OPTION
        );
        if(option==JOptionPane.NO_OPTION) return;
        controller.delete(crop);
        clear();
        changeStateBtns();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnLostCropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLostCropActionPerformed
        cancelCrop(crop);
        
        controller.update(crop);
    }//GEN-LAST:event_btnLostCropActionPerformed

    private void btnChangeStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeStateActionPerformed
        changeState(crop);
        controller.update(crop);
    }//GEN-LAST:event_btnChangeStateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
        SetEditableStateTxts(true);
        formatDate(LocalDate.now(),txtSowing);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        txtState.setText("Siembra");
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtSowingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSowingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSowingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeState;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLostCrop;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtArea;
    private javax.swing.JFormattedTextField txtHarvest;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JFormattedTextField txtSowing;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables

}
