/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import controller.ItemControllerByChule;
import controller.OrderControllerByDilan;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.OrderDetail;

/**
 *
 * @author pavilion 15
 */
public class AnnualReport extends javax.swing.JDialog {

    /**
     * Creates new form DailyReport
     */
    DefaultTableModel tableModel;
    int rowCount = 0;

    public AnnualReport(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) cart.getModel();
        tableModel.setRowCount(0);
        tableModel.addRow(new Object[]{"IT0001", "100", "150", "2", "1"});//14        
        tableModel.addRow(new Object[]{"IT0001", "120", "130", "5", "1"});
        tableModel.addRow(new Object[]{"IT0001", "100", "150", "3", "1"});
        tableModel.addRow(new Object[]{"IT0001", "135", "145", "4", "1"});

        tableModel.addRow(new Object[]{"IT0002", "200", "300", "9", "1"});
        tableModel.addRow(new Object[]{"IT0002", "250", "350", "8", "1"});
        tableModel.addRow(new Object[]{"IT0002", "210", "320", "6", "1"});//30
        tableModel.addRow(new Object[]{"IT0002", "200", "300", "7", "1"});

        tableModel.addRow(new Object[]{"IT0003", "200", "300", "1", "1"});//4
        tableModel.addRow(new Object[]{"IT0003", "120", "400", "1", "1"});
        tableModel.addRow(new Object[]{"IT0003", "500", "700", "1", "1"});
        tableModel.addRow(new Object[]{"IT0003", "400", "800", "1", "1"});
        rowCount = tableModel.getRowCount();
    }

    public AnnualReport(java.awt.Frame parent, boolean modal, String year) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        yearLabel.setText(year);
        tableModel = (DefaultTableModel) cart.getModel();
        tableModel.setRowCount(0);
        OrderControllerByDilan controller = new OrderControllerByDilan();
        ItemControllerByChule itemController=new ItemControllerByChule();
        try {
            ArrayList<OrderDetail> allOrderedItemsByDate = controller.getAllOrderedItemsByYear(year);
            for (OrderDetail orderDetail : allOrderedItemsByDate) {
                tableModel.addRow(new String[]{orderDetail.getItemCode(),
                    itemController.searchItem(orderDetail.getItemCode()).getItemName(), 
                    String.valueOf(orderDetail.getSupplierPrice()), 
                    String.valueOf(orderDetail.getSellingPrice()), 
                    String.valueOf(orderDetail.getOrderQty()), 
                    String.valueOf(orderDetail.getTotalPerEachItem())
                });
            }
            totalDiscounts.setText(String.valueOf(controller.getDiscountsByYear(year)));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException occured."+"\n"+"ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException occured."+"\n"+"ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        }
        rowCount = tableModel.getRowCount();        
        if (tableModel.getRowCount() > 0) {
            filtAllData();
            amountLabel.setText(""+(setTotal()-Double.parseDouble(totalDiscounts.getText().trim())));
        }
        if(rowCount==0){
            showButton.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cart = new javax.swing.JTable();
        amountLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalDiscounts = new javax.swing.JLabel();
        showButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(204, 0, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 70)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Queen's  Palace");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Annual Summery");

        yearLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        yearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearLabel.setText("sas");

        cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ITEMCODE", "NAME", "BUYINGPRICE", "SELLINGPRICE", "QTY", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cart);
        if (cart.getColumnModel().getColumnCount() > 0) {
            cart.getColumnModel().getColumn(1).setResizable(false);
        }

        amountLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        amountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amountLabel.setText("0.0");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Income :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("Total Discounts :");

        totalDiscounts.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        totalDiscounts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalDiscounts.setText("0.0");

        showButton.setBackground(new java.awt.Color(255, 255, 255));
        showButton.setFont(new java.awt.Font("Times New Roman", 3, 26)); // NOI18N
        showButton.setText("Show Other Details");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalDiscounts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalDiscounts, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        new ViewAnnualOrders(null, true, yearLabel.getText().trim()).setVisible(true);
    }//GEN-LAST:event_showButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AnnualReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnnualReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnnualReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnnualReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AnnualReport dialog = new AnnualReport(new javax.swing.JFrame(), true);                
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTable cart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton showButton;
    private javax.swing.JLabel totalDiscounts;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
private void filtAllData() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                if (i == j) {
                    continue;
                }
                if (getSameRows(i, j)) {
                    removeSameRows(i, j);
                    j-=1;
                }
            }
        }
    }

    private boolean getSameRows(int i, int j) {
        boolean check1 = tableModel.getValueAt(i, 0).toString().equals(tableModel.getValueAt(j, 0).toString());
        boolean check2 = tableModel.getValueAt(i, 2).toString().equals(tableModel.getValueAt(j, 2).toString());
        boolean check3 = tableModel.getValueAt(i, 3).toString().equals(tableModel.getValueAt(j, 3).toString());
        return check1 && check2 && check3;
    }

    private void removeSameRows(int i, int j) {
        int newQty = Integer.parseInt(tableModel.getValueAt(i, 4).toString()) + Integer.parseInt(tableModel.getValueAt(j, 4).toString());
        double newTotal = Double.parseDouble(tableModel.getValueAt(i, 5).toString()) + Double.parseDouble(tableModel.getValueAt(j, 5).toString());
        tableModel.setValueAt(newQty, i, 4);
        tableModel.setValueAt(newTotal, i, 5);
        tableModel.removeRow(j);
        rowCount--;
    }

    private double setTotal() {
        double total = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            total += Double.parseDouble(tableModel.getValueAt(i, 5).toString().trim());
        }
        return total;
    }
}
