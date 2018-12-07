package view;

import controller.UserControllerByChule;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import models.User;
import validation.Validation;

public class CreateFirstAdminAccount extends javax.swing.JFrame {

    public CreateFirstAdminAccount() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(560, 275);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        conPassWordLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        userName = new javax.swing.JTextField();
        titleSeperator = new javax.swing.JSeparator();
        createButton = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        confirmPassword = new javax.swing.JPasswordField();
        messageLabel = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        admin = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(null);

        titleLabel.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        titleLabel.setText("Create Adminstrater Account");
        mainPanel.add(titleLabel);
        titleLabel.setBounds(102, 5, 351, 29);

        nameLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        nameLabel.setText("User Name             :");
        mainPanel.add(nameLabel);
        nameLabel.setBounds(20, 60, 139, 23);

        passwordLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        passwordLabel.setText("Password                :");
        mainPanel.add(passwordLabel);
        passwordLabel.setBounds(20, 136, 139, 23);

        conPassWordLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        conPassWordLabel.setText("Confirm Password :");
        mainPanel.add(conPassWordLabel);
        conPassWordLabel.setBounds(17, 175, 142, 23);

        cancelButton.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        mainPanel.add(cancelButton);
        cancelButton.setBounds(451, 209, 81, 25);

        userName.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        userName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userNameKeyReleased(evt);
            }
        });
        mainPanel.add(userName);
        userName.setBounds(170, 60, 374, 26);
        mainPanel.add(titleSeperator);
        titleSeperator.setBounds(10, 40, 535, 10);

        createButton.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        createButton.setText("Create");
        createButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createButtonMouseClicked(evt);
            }
        });
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        mainPanel.add(createButton);
        createButton.setBounds(362, 209, 77, 25);

        password.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        mainPanel.add(password);
        password.setBounds(171, 135, 248, 26);

        confirmPassword.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        confirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordActionPerformed(evt);
            }
        });
        mainPanel.add(confirmPassword);
        confirmPassword.setBounds(171, 172, 248, 26);

        messageLabel.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(204, 0, 0));
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainPanel.add(messageLabel);
        messageLabel.setBounds(130, 210, 210, 30);

        nameLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        nameLabel1.setText("Type                        :");
        mainPanel.add(nameLabel1);
        nameLabel1.setBounds(20, 99, 136, 23);

        admin.setBackground(new java.awt.Color(204, 204, 255));
        admin.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        admin.setSelected(true);
        admin.setText("  Admin");
        admin.setEnabled(false);
        mainPanel.add(admin);
        admin.setBounds(172, 97, 87, 31);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/craateAdim.png"))); // NOI18N
        mainPanel.add(jLabel1);
        jLabel1.setBounds(0, 0, 560, 260);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        String type = "";
        if (admin.isSelected()) {
            type = "ADMINISTER";
        } else {
            type = "GUEST";;
        }
        try {
            if (!(userName.getText().isEmpty() || confirmPassword.getPassword().length == 0) && Arrays.equals(password.getPassword(), confirmPassword.getPassword())) {
                int addUser = UserControllerByChule.addUser(new User(userName.getText(), String.valueOf(confirmPassword.getPassword()), type));
                if (addUser > 0) {
                    JOptionPane.showMessageDialog(null, "User adding is successed", null, JOptionPane.INFORMATION_MESSAGE);
                    if (UserControllerByChule.getCountOfAdminUsers() > 0) {
                        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Do you want logging to System now ?", "Logging Confirmation", JOptionPane.YES_NO_OPTION);
                        if (showConfirmDialog == JOptionPane.YES_OPTION) {
                            WelcomeAndLogIn loginForm = new WelcomeAndLogIn();
                            setVisible(false);
                            loginForm.setVisible(true);
                            loginForm.setLocationRelativeTo(null);
                        }
                    } else {
                        System.exit(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User adding is not successed", null, JOptionPane.ERROR_MESSAGE);
                }
            } else if (!Arrays.equals(password.getPassword(), confirmPassword.getPassword())) {
                messageLabel.setText("Password dosen't match");
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all fields", null, JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createButtonActionPerformed

    private void createButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createButtonMouseClicked

    }//GEN-LAST:event_createButtonMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void confirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordActionPerformed

    }//GEN-LAST:event_confirmPasswordActionPerformed

    private void userNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameKeyReleased
        Validation.validateName(userName);
    }//GEN-LAST:event_userNameKeyReleased

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
            java.util.logging.Logger.getLogger(CreateFirstAdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateFirstAdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateFirstAdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateFirstAdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateFirstAdminAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton admin;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel conPassWordLabel;
    private javax.swing.JPasswordField confirmPassword;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JSeparator titleSeperator;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
