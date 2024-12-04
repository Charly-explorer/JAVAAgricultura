/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author carlo
 */
public class FrmMenu extends javax.swing.JFrame {
 private FrmCrops frmCrop;   
 private FrmWorkers frmworkers;
 private FrmUsers frmUser;
 private FrmStroge frmStroge;  
 private FrmProduction frmPro;
 private FrmLogin frmSesion;

    /**
     * Creates new form Inicio
     */
    public FrmMenu() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frmCrop = new FrmCrops();  
        frmworkers = new FrmWorkers();  
        frmUser = new FrmUsers();
        frmStroge = new FrmStroge();
        frmPro = new FrmProduction();
    }

    public void setBtnWorkers() {
        this.btnWorkers.setEnabled(false);
    }

    public void setFrmSesion(FrmLogin frmSesion) {
        this.frmSesion = frmSesion;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/ImgDe/2.png"));
        deskTop = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(icon.getImage(),0,0,getWidth(),getHeight(),this);
            }
        };
        btnCrop = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnWorkers = new javax.swing.JButton();
        btnStroge = new javax.swing.JButton();
        btnProduction = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel de Administracion");
        setResizable(false);

        btnCrop.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        btnCrop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plan98.png"))); // NOI18N
        btnCrop.setText("Cultivos ");
        btnCrop.setBorderPainted(false);
        btnCrop.setContentAreaFilled(false);
        btnCrop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCrop.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plan64.png"))); // NOI18N
        btnCrop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCropActionPerformed(evt);
            }
        });

        btnUser.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/conexion(1).png"))); // NOI18N
        btnUser.setText("Usuarios");
        btnUser.setBorderPainted(false);
        btnUser.setContentAreaFilled(false);
        btnUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUser.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/conexion.png"))); // NOI18N
        btnUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btnWorkers.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        btnWorkers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/red(1).png"))); // NOI18N
        btnWorkers.setText("Trabajadores");
        btnWorkers.setBorderPainted(false);
        btnWorkers.setContentAreaFilled(false);
        btnWorkers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnWorkers.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/red.png"))); // NOI18N
        btnWorkers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWorkersActionPerformed(evt);
            }
        });

        btnStroge.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        btnStroge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/granero(3).png"))); // NOI18N
        btnStroge.setText("Alamacenamiento ");
        btnStroge.setBorderPainted(false);
        btnStroge.setContentAreaFilled(false);
        btnStroge.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStroge.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/granero(2).png"))); // NOI18N
        btnStroge.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStroge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStrogeActionPerformed(evt);
            }
        });

        btnProduction.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        btnProduction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sostenible98.png"))); // NOI18N
        btnProduction.setText("Producion");
        btnProduction.setBorderPainted(false);
        btnProduction.setContentAreaFilled(false);
        btnProduction.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProduction.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sostenible64.png"))); // NOI18N
        btnProduction.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductionActionPerformed(evt);
            }
        });

        btnLogOut.setText("Cerrar Sesion");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        deskTop.setLayer(btnCrop, javax.swing.JLayeredPane.DEFAULT_LAYER);
        deskTop.setLayer(btnUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
        deskTop.setLayer(btnWorkers, javax.swing.JLayeredPane.DEFAULT_LAYER);
        deskTop.setLayer(btnStroge, javax.swing.JLayeredPane.DEFAULT_LAYER);
        deskTop.setLayer(btnProduction, javax.swing.JLayeredPane.DEFAULT_LAYER);
        deskTop.setLayer(btnLogOut, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout deskTopLayout = new javax.swing.GroupLayout(deskTop);
        deskTop.setLayout(deskTopLayout);
        deskTopLayout.setHorizontalGroup(
            deskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deskTopLayout.createSequentialGroup()
                .addGroup(deskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deskTopLayout.createSequentialGroup()
                        .addContainerGap(516, Short.MAX_VALUE)
                        .addGroup(deskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUser, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnWorkers, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(122, 122, 122))
                    .addGroup(deskTopLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnLogOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(deskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrop)
                    .addComponent(btnStroge)
                    .addComponent(btnProduction))
                .addGap(57, 57, 57))
        );
        deskTopLayout.setVerticalGroup(
            deskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deskTopLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnStroge)
                .addGap(27, 27, 27)
                .addComponent(btnCrop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnProduction)
                .addContainerGap())
            .addGroup(deskTopLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnLogOut)
                .addGap(42, 42, 42)
                .addComponent(btnUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnWorkers)
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(deskTop)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deskTop, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCropActionPerformed
       this.deskTop.add(frmCrop);
       frmCrop.setLocation((this.deskTop.getWidth()-frmCrop.getWidth())/2, 
                (this.deskTop.getHeight()-frmCrop.getHeight())/2);
        frmCrop.setVisible(true);
    }//GEN-LAST:event_btnCropActionPerformed

    private void btnWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWorkersActionPerformed
       this.deskTop.add(frmworkers);
       frmworkers.setLocation((this.deskTop.getWidth()-frmworkers.getWidth())/2, 
                (this.deskTop.getHeight()-frmworkers.getHeight())/2);
        frmworkers.setVisible(true);
    }//GEN-LAST:event_btnWorkersActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
      this.deskTop.add(frmUser);
       frmUser.setLocation((this.deskTop.getWidth()-frmUser.getWidth())/2, 
                (this.deskTop.getHeight()-frmUser.getHeight())/2);
        frmUser.setVisible(true);   
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnStrogeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStrogeActionPerformed
         this.deskTop.add(frmStroge);
       frmStroge.setLocation((this.deskTop.getWidth()-frmStroge.getWidth())/2, 
                (this.deskTop.getHeight()-frmworkers.getHeight())/2);
        frmStroge.setVisible(true);
        frmStroge.setFrmProduction(frmPro);
    }//GEN-LAST:event_btnStrogeActionPerformed

    private void btnProductionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductionActionPerformed
        this.deskTop.add(frmPro);
       frmPro.setLocation((this.deskTop.getWidth()-frmPro.getWidth())/2, 
                (this.deskTop.getHeight()-frmPro.getHeight())/2);
        frmPro.setVisible(true);
        frmPro.setFrmCrops(frmCrop);
    }//GEN-LAST:event_btnProductionActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        this.dispose();
        frmSesion.setVisible(true);
        btnWorkers.setEnabled(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrop;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnProduction;
    private javax.swing.JButton btnStroge;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton btnWorkers;
    private javax.swing.JDesktopPane deskTop;
    // End of variables declaration//GEN-END:variables
}
