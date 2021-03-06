/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;

/**
 *
 * @author Kanishka Gunarathna
 */
public class CategorySettingsPenal extends javax.swing.JPanel {

    /**
     * Creates new form ItemSettingsPenal
     */
    public CategorySettingsPenal() throws ClassNotFoundException, SQLException {
        initComponents();
        categoryPenal.removeAll();
        AddnewCategory op = new AddnewCategory();
        categoryPenal.add(op);
        op.setVisible(true);
        op.revalidate();
        op.repaint();
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
        categoryPenal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        categoryPenal.setBackground(new java.awt.Color(255, 255, 255));
        categoryPenal.setLayout(new java.awt.BorderLayout());
        jPanel1.add(categoryPenal);
        categoryPenal.setBounds(219, 76, 650, 340);

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Category Settings");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(280, 10, 308, 43);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 60, 865, 10);

        jButton1.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jButton1.setText("Add New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 84, 203, 40);

        jButton2.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 138, 203, 40);

        jButton3.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jButton3.setText("Modify");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(10, 192, 203, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OptinPenartrfllll.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 890, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        categoryPenal.removeAll();
        ModifyCategoryPenal op;        
            op = new ModifyCategoryPenal();
            categoryPenal.add(op);
            op.setVisible(true);
            op.revalidate();
            op.repaint();
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        categoryPenal.removeAll();
        AddnewCategory op;        
            op = new AddnewCategory();
            categoryPenal.add(op);
            op.setVisible(true);
            op.revalidate();
            op.repaint();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        categoryPenal.removeAll();
        RemoveCategoryPenal op;        
            op = new RemoveCategoryPenal();
            categoryPenal.add(op);
            op.setVisible(true);
            op.revalidate();
            op.repaint();                
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel categoryPenal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
