/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UserControllerByChule;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static view.HomePage.BodyPEnal;

/**
 *
 * @author Kanishka Gunarathna
 */
public class AdminLogInToStock extends javax.swing.JFrame {

    /**
     * Creates new form LogInToSystem
     */
    public AdminLogInToStock() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        userNameTxt.requestFocus();
        setSize(620, 250);
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
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        logInButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Administrator Log In");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 10, 382, 43);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 60, 590, 10);

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name       :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 80, 136, 22);

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password         :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 120, 132, 22);

        userNameTxt.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        userNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTxtActionPerformed(evt);
            }
        });
        jPanel1.add(userNameTxt);
        userNameTxt.setBounds(170, 80, 410, 29);

        passwordTxt.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        passwordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTxtActionPerformed(evt);
            }
        });
        jPanel1.add(passwordTxt);
        passwordTxt.setBounds(170, 130, 410, 29);

        logInButton.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        logInButton.setText("Log In");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logInButton);
        logInButton.setBounds(410, 180, 85, 31);

        jButton2.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(500, 180, 91, 31);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/thinkpad_Lenovo1-5.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 620, 230);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed

        if (userNameTxt.getText() != null && passwordTxt.getPassword().length != 0) {
            UserControllerByChule userController = new UserControllerByChule();
            try {
                if (userController.verifyUser(userNameTxt.getText(), String.valueOf(passwordTxt.getPassword())) && userController.searchUser(userNameTxt.getText()).getType().equals("ADMINISTER")) {
                    BodyPEnal.removeAll();
                    NewStockPenal op = new NewStockPenal();
                    BodyPEnal.add(op);
                    op.setVisible(true);
                    op.revalidate();
                    op.repaint();
                    this.dispose();
                } else if (!userController.searchUser(userNameTxt.getText()).getType().equals("ADMINISTER")) {
                    JOptionPane.showMessageDialog(null, "This user doesn't have permission", null, JOptionPane.ERROR_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username or password incorrect", null, JOptionPane.ERROR_MESSAGE);
                    passwordTxt.setText(null);
                    userNameTxt.setText(null);
                    userNameTxt.requestFocus();
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all fields", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_logInButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void userNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTxtActionPerformed
        passwordTxt.requestFocus();
    }//GEN-LAST:event_userNameTxtActionPerformed

    private void passwordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTxtActionPerformed
        logInButton.doClick();
    }//GEN-LAST:event_passwordTxtActionPerformed

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
            java.util.logging.Logger.getLogger(AdminLogInToStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogInToStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogInToStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogInToStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogInToStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logInButton;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables
}
