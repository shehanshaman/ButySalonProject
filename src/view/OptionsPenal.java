/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kanishka Gunarathna
 */
public class OptionsPenal extends javax.swing.JPanel {

    /**
     * Creates new form OptionsPenal
     */
    public OptionsPenal() {
        try {
            initComponents();
            optionsPenal.removeAll();
            CategorySettingsPenal op = new CategorySettingsPenal();
            optionsPenal.add(op);
            op.setVisible(true);
            op.revalidate();
            op.repaint();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException occured."+"\n"+"ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        itemSettingsButton = new javax.swing.JButton();
        categorySettingsButton = new javax.swing.JButton();
        optionsPenal = new javax.swing.JDesktopPane();
        advanceSettings = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 36)); // NOI18N
        jLabel1.setText("Edit Your Options ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(285, 0, 336, 43);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 49, 885, 10);

        itemSettingsButton.setBackground(new java.awt.Color(0, 153, 153));
        itemSettingsButton.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        itemSettingsButton.setForeground(new java.awt.Color(204, 255, 255));
        itemSettingsButton.setText("Item Settings");
        itemSettingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                itemSettingsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                itemSettingsButtonMouseExited(evt);
            }
        });
        itemSettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSettingsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(itemSettingsButton);
        itemSettingsButton.setBounds(20, 60, 274, 53);

        categorySettingsButton.setBackground(new java.awt.Color(0, 153, 153));
        categorySettingsButton.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        categorySettingsButton.setForeground(new java.awt.Color(204, 255, 255));
        categorySettingsButton.setText("Category Settings");
        categorySettingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                categorySettingsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                categorySettingsButtonMouseExited(evt);
            }
        });
        categorySettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySettingsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(categorySettingsButton);
        categorySettingsButton.setBounds(310, 60, 295, 53);

        optionsPenal.setLayout(new java.awt.BorderLayout());
        jPanel1.add(optionsPenal);
        optionsPenal.setBounds(10, 129, 870, 425);

        advanceSettings.setBackground(new java.awt.Color(0, 153, 153));
        advanceSettings.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        advanceSettings.setForeground(new java.awt.Color(204, 255, 255));
        advanceSettings.setText("Advance Functions");
        advanceSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                advanceSettingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                advanceSettingsMouseExited(evt);
            }
        });
        advanceSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advanceSettingsActionPerformed(evt);
            }
        });
        jPanel1.add(advanceSettings);
        advanceSettings.setBounds(620, 60, 260, 53);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/usercontrolBackgroundl.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 905, 565);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void itemSettingsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemSettingsButtonMouseEntered
        itemSettingsButton.setForeground(Color.black);
    }//GEN-LAST:event_itemSettingsButtonMouseEntered

    private void categorySettingsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categorySettingsButtonMouseEntered
        categorySettingsButton.setForeground(Color.black);
    }//GEN-LAST:event_categorySettingsButtonMouseEntered

    private void itemSettingsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemSettingsButtonMouseExited
        itemSettingsButton.setForeground(new Color(204, 255, 255));
    }//GEN-LAST:event_itemSettingsButtonMouseExited

    private void categorySettingsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categorySettingsButtonMouseExited
        categorySettingsButton.setForeground(new Color(204, 255, 255));
    }//GEN-LAST:event_categorySettingsButtonMouseExited

    private void advanceSettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_advanceSettingsMouseEntered
        advanceSettings.setForeground(new Color(204, 255, 255));
    }//GEN-LAST:event_advanceSettingsMouseEntered

    private void advanceSettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_advanceSettingsMouseExited
        advanceSettings.setForeground(Color.black);
    }//GEN-LAST:event_advanceSettingsMouseExited

    private void itemSettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSettingsButtonActionPerformed
        optionsPenal.removeAll();
        ItemSettingsPenal penal = new ItemSettingsPenal();
        optionsPenal.add(penal);
        penal.setVisible(true);
        penal.revalidate();
        penal.repaint();
    }//GEN-LAST:event_itemSettingsButtonActionPerformed

    private void advanceSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advanceSettingsActionPerformed
        optionsPenal.removeAll();
        BackupandResorePenal penal = new BackupandResorePenal();
        optionsPenal.add(penal);
        penal.setVisible(true);
        penal.revalidate();
        penal.repaint();
    }//GEN-LAST:event_advanceSettingsActionPerformed

    private void categorySettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySettingsButtonActionPerformed
        try {
            optionsPenal.removeAll();
            CategorySettingsPenal penal = new CategorySettingsPenal();
            optionsPenal.add(penal);
            penal.setVisible(true);
            penal.revalidate();
            penal.repaint();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException occured."+"\n"+"ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_categorySettingsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton advanceSettings;
    private javax.swing.JButton categorySettingsButton;
    private javax.swing.JButton itemSettingsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JDesktopPane optionsPenal;
    // End of variables declaration//GEN-END:variables
}