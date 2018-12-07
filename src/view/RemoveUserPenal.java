/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UserControllerByChule;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.User;

/**
 *
 * @author Kanishka Gunarathna
 */
public class RemoveUserPenal extends javax.swing.JPanel {

    /**
     * Creates new form RemoveUserPenal
     */
    public RemoveUserPenal() {
        initComponents();
        try {
            loadAllUsers();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        removeButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userComboBox = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setLayout(null);

        removeButton.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        add(removeButton);
        removeButton.setBounds(604, 296, 103, 31);

        jButton2.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jButton2.setText("Cancel");
        add(jButton2);
        jButton2.setBounds(713, 296, 91, 31);

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel2.setText("User Name               :");
        add(jLabel2);
        jLabel2.setBounds(110, 160, 176, 22);

        messageLabel.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(204, 0, 0));
        add(messageLabel);
        messageLabel.setBounds(300, 270, 0, 0);
        add(jSeparator1);
        jSeparator1.setBounds(11, 92, 827, 10);

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        jLabel1.setText("Remove User Account");
        add(jLabel1);
        jLabel1.setBounds(238, 34, 358, 44);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/fresh-green-background.jpg"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(0, 0, 860, 110);

        userComboBox.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(userComboBox);
        userComboBox.setBounds(310, 160, 350, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (userComboBox.getItemCount() > 0) {
            int com = JOptionPane.showConfirmDialog(null, "Are you sure want to do this?", "Warning", JOptionPane.YES_NO_OPTION);
            if (com == JOptionPane.YES_OPTION) {
                try {
                    int countOfAdminUsers = UserControllerByChule.getCountOfAdminUsers();
                    if (!userComboBox.getSelectedItem().toString().split("<##>")[1].trim().equals("ADMINISTER")) {
                        int deleteUser = UserControllerByChule.deleteUser(userComboBox.getSelectedItem().toString().split("<##>")[0].trim());
                        if (deleteUser > 0) {
                            JOptionPane.showMessageDialog(null, "Deleting is succed", null, JOptionPane.INFORMATION_MESSAGE);
                            loadAllUsers();
                        } else {
                            JOptionPane.showMessageDialog(null, "Deleting is not succed", null, JOptionPane.ERROR_MESSAGE);
                        }
                    } else if (userComboBox.getSelectedItem().toString().split("<##>")[1].trim().equals("ADMINISTER") && countOfAdminUsers > 1) {
                        int deleteUser = UserControllerByChule.deleteUser(userComboBox.getSelectedItem().toString().split("<##>")[0].trim());
                        if (deleteUser > 0) {
                            JOptionPane.showMessageDialog(null, "Deleting is succed", null, JOptionPane.INFORMATION_MESSAGE);
                            loadAllUsers();
                        } else {
                            JOptionPane.showMessageDialog(null, "Deleting is not succed", null, JOptionPane.ERROR_MESSAGE);
                        }
                    } else if (countOfAdminUsers <= 1) {
                        JOptionPane.showMessageDialog(null, "You can't delete this user" + "\n" + "Because this user is only one administer in the system", null, JOptionPane.ERROR_MESSAGE);
                    }

                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No users in the system", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton removeButton;
    private javax.swing.JComboBox userComboBox;
    // End of variables declaration//GEN-END:variables

    private void loadAllUsers() throws ClassNotFoundException, SQLException, IOException {
        userComboBox.removeAllItems();
        ArrayList<User> allUsers = UserControllerByChule.getAllUser();
        for (User user : allUsers) {
            userComboBox.addItem(user.getUserName().trim() + "<##>" + user.getType().trim());
        }
    }
}