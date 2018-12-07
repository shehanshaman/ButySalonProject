package view;

import controller.UserControllerByChule;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.User;

public class WelcomeAndLogIn extends javax.swing.JFrame {

    public WelcomeAndLogIn() {
        initComponents();
        setSize(730, 460);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/icon2.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        logInButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Charlemagne Std", 1, 50)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Untitled-1.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(200, 20, 400, 74);

        jSeparator1.setForeground(new java.awt.Color(51, 51, 255));
        jSeparator1.setDoubleBuffered(true);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 130, 690, 10);

        jLabel2.setBackground(new java.awt.Color(204, 255, 153));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Untitled-2.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 140, 667, 126);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 255));
        jSeparator2.setDoubleBuffered(true);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(10, 270, 704, 10);

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel3.setText("User Name    :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 300, 121, 26);

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel4.setText("Password      :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 340, 117, 26);

        userNameTxt.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        userNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTxtActionPerformed(evt);
            }
        });
        jPanel1.add(userNameTxt);
        userNameTxt.setBounds(250, 300, 260, 29);

        passwordTxt.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        passwordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTxtActionPerformed(evt);
            }
        });
        jPanel1.add(passwordTxt);
        passwordTxt.setBounds(250, 340, 260, 29);

        logInButton.setBackground(new java.awt.Color(255, 153, 153));
        logInButton.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        logInButton.setText("Log In");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logInButton);
        logInButton.setBounds(550, 370, 79, 30);

        exitButton.setBackground(new java.awt.Color(255, 153, 153));
        exitButton.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(exitButton);
        exitButton.setBounds(630, 370, 72, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/loll_1.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 290, 79, 92);

        messageLabel.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(messageLabel);
        messageLabel.setBounds(170, 380, 350, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bacgroudLog1.jpg"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 720, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed

        if (userNameTxt.getText() != null && passwordTxt.getPassword().length != 0) {
            UserControllerByChule userController = new UserControllerByChule();
            try {
                if (userController.verifyUser(userNameTxt.getText(), String.valueOf(passwordTxt.getPassword()))) {
                    User searchUser = userController.searchUser(userNameTxt.getText());
                    new HomePage(userNameTxt.getText(), searchUser.getType()).setVisible(true);
                    this.dispose();
                } else {
                    messageLabel.setText("Username or password incorrect");
                    passwordTxt.setText(null);
                    userNameTxt.setText(null);
                    userNameTxt.requestFocus();
                }
            } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException occured."+"\n"+"ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException occured."+"\n"+"ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        }
        } else {
            messageLabel.setText("Please fill all fields");
        }
    }//GEN-LAST:event_logInButtonActionPerformed

    private void userNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTxtActionPerformed
        passwordTxt.requestFocus();
    }//GEN-LAST:event_userNameTxtActionPerformed

    private void passwordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTxtActionPerformed
        logInButton.doClick();
    }//GEN-LAST:event_passwordTxtActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(WelcomeAndLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeAndLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeAndLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeAndLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeAndLogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton logInButton;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables
}
