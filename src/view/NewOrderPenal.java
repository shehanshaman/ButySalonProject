/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import comboSearch.ComboSearch;
import controller.CreditController;
import controller.ItemControllerByChule;
import controller.ItemControllerByDilan;
import controller.OrderControllerByDilan;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.Item;
import models.OrderDetail;
import models.Orders;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import validation.Validation;

/**
 *
 * @author Kanishka Gunarathna
 */
public class NewOrderPenal extends javax.swing.JPanel {

    private DefaultTableModel tableModel = new DefaultTableModel();
    private int duplicatedRow = -1;
    private String itemCodeFor = "";
    private String userName = "";
    private ComboSearch comboSearch;
    public String returnOrderId = "";

    public void setUserName(String userName) {
        this.userName = userName;
    }
    private HomePage page;
    private NewOrderPenal panel;

    /**
     * Creates new form NewOrderPenal
     */
    public NewOrderPenal() {
        initComponents();
        tableModel = (DefaultTableModel) itemCart.getModel();
        OrderControllerByDilan orderController = new OrderControllerByDilan();
        try {
            orderId.setText(orderController.getNewOrderId());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        }
        itemCode.requestFocus();
    }

    public NewOrderPenal(String userName, HomePage page) {
        initComponents();
        this.userName = userName;
        tableModel = (DefaultTableModel) itemCart.getModel();
        OrderControllerByDilan orderController = new OrderControllerByDilan();
        confirm.setEnabled(false);
        this.panel = this;
        try {
            orderId.setText(orderController.getNewOrderId());
            fillCustomerDetailCombo();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        }
        this.page = page;
        itemCode.requestFocus();
        itemCodeRButton.setSelected(true);
        itemNames.setEnabled(false);
        itemCode.setEnabled(true);
        orderQty.setEnabled(false);
        buttonGroup1.add(itemNameRButton);
        buttonGroup1.add(itemCodeRButton);
        itemCode.setText(null);
        itemCode.requestFocus();
        resetAllFields();
        ComboSearch search = new ComboSearch();
        search.setSearchableCombo(itemNames, true, "No items");
        JTextField txt = (JTextField) itemNames.getEditor().getEditorComponent();
        txt.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    if (itemNames.getSelectedIndex() != -1) {
                        amount.requestFocus();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    if (itemNames.getSelectedIndex() != -1) {
                        orderQty.requestFocus();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_F4) {
                    itemCode.setText(null);
                    new LogInSystem(page, panel, new JFrame(), true).setVisible(true);
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        itemCode = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        itemName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        qtyOnHand = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sellingPrice = new javax.swing.JTextField();
        orderQty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        orderId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        totalAmount = new javax.swing.JTextField();
        addToCart = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        amount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        balance = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemCart = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        discountAmount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        netTotalAmount = new javax.swing.JTextField();
        itemNames = new javax.swing.JComboBox();
        itemCodeRButton = new javax.swing.JRadioButton();
        itemNameRButton = new javax.swing.JRadioButton();
        discountCBox = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        creditAmount = new javax.swing.JTextField();
        creditCBox = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 36)); // NOI18N
        jLabel2.setText("New Order");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(340, 10, 197, 43);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 55, 890, 10);

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 20)); // NOI18N
        jLabel1.setText("Item Code      :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 140, 142, 29);

        itemCode.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        itemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCodeActionPerformed(evt);
            }
        });
        itemCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemCodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemCodeKeyReleased(evt);
            }
        });
        jPanel1.add(itemCode);
        itemCode.setBounds(230, 140, 190, 32);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel3.setText("Item Name    :");

        itemName.setEditable(false);
        itemName.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel4.setText("Qty On Hand :");

        qtyOnHand.setEditable(false);
        qtyOnHand.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel5.setText("Selling Price  :");

        sellingPrice.setEditable(false);
        sellingPrice.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(qtyOnHand, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(itemName)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyOnHand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(471, 70, 420, 130);

        orderQty.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        orderQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                orderQtyFocusGained(evt);
            }
        });
        orderQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderQtyActionPerformed(evt);
            }
        });
        orderQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                orderQtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                orderQtyKeyReleased(evt);
            }
        });
        jPanel1.add(orderQty);
        orderQty.setBounds(230, 180, 160, 32);

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 0, 20)); // NOI18N
        jLabel6.setText("Order QTY     :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(70, 180, 142, 29);

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 1, 20)); // NOI18N
        jLabel7.setText("Order ID        :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(80, 60, 140, 29);

        orderId.setEditable(false);
        orderId.setBackground(new java.awt.Color(255, 204, 204));
        orderId.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jPanel1.add(orderId);
        orderId.setBounds(230, 60, 160, 32);

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel8.setText("Total       :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 440, 117, 29);

        totalAmount.setEditable(false);
        totalAmount.setBackground(new java.awt.Color(255, 204, 204));
        totalAmount.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        totalAmount.setText("0.0");
        totalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmountActionPerformed(evt);
            }
        });
        jPanel1.add(totalAmount);
        totalAmount.setBounds(160, 440, 160, 32);

        addToCart.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        addToCart.setText("Add");
        addToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartActionPerformed(evt);
            }
        });
        jPanel1.add(addToCart);
        addToCart.setBounds(790, 250, 90, 25);

        remove.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove);
        remove.setBounds(790, 290, 91, 25);

        amount.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                amountFocusGained(evt);
            }
        });
        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });
        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountKeyReleased(evt);
            }
        });
        jPanel1.add(amount);
        amount.setBounds(160, 490, 160, 32);

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel9.setText("Amount  :");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 490, 118, 29);

        balance.setEditable(false);
        balance.setBackground(new java.awt.Color(255, 204, 204));
        balance.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        balance.setText("0.0");
        jPanel1.add(balance);
        balance.setBounds(470, 480, 160, 32);

        jLabel10.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel10.setText("Balance  :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(340, 480, 120, 34);

        cancel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel);
        cancel.setBounds(810, 500, 83, 31);

        confirm.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        jPanel1.add(confirm);
        confirm.setBounds(720, 500, 93, 31);

        itemCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEMCODE", "NAME", "QTY", "PRICE", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(itemCart);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 220, 710, 210);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/-colorful-wallpaper-hd-color-background-high-r-a-ibackgroundz.com.jpg"))); // NOI18N
        jLabel11.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabel11PropertyChange(evt);
            }
        });
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 0, 900, 60);

        jLabel12.setFont(new java.awt.Font("Lucida Bright", 1, 22)); // NOI18N
        jLabel12.setText("Discount  :");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(340, 520, 119, 34);

        discountAmount.setEditable(false);
        discountAmount.setBackground(new java.awt.Color(255, 204, 204));
        discountAmount.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        discountAmount.setText("0.0");
        jPanel1.add(discountAmount);
        discountAmount.setBounds(470, 520, 160, 32);

        jLabel13.setFont(new java.awt.Font("Lucida Bright", 1, 22)); // NOI18N
        jLabel13.setText("Net Tot  :");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(340, 440, 120, 30);

        netTotalAmount.setEditable(false);
        netTotalAmount.setBackground(new java.awt.Color(255, 204, 204));
        netTotalAmount.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        netTotalAmount.setText("0.0");
        jPanel1.add(netTotalAmount);
        netTotalAmount.setBounds(470, 440, 160, 32);

        itemNames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemNamesItemStateChanged(evt);
            }
        });
        itemNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNamesActionPerformed(evt);
            }
        });
        itemNames.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemNamesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemNamesKeyReleased(evt);
            }
        });
        jPanel1.add(itemNames);
        itemNames.setBounds(50, 100, 400, 30);

        itemCodeRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCodeRButtonActionPerformed(evt);
            }
        });
        jPanel1.add(itemCodeRButton);
        itemCodeRButton.setBounds(20, 140, 20, 21);

        itemNameRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameRButtonActionPerformed(evt);
            }
        });
        jPanel1.add(itemNameRButton);
        itemNameRButton.setBounds(20, 100, 20, 21);

        discountCBox.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        discountCBox.setText("Add a Discount");
        discountCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountCBoxActionPerformed(evt);
            }
        });
        jPanel1.add(discountCBox);
        discountCBox.setBounds(740, 370, 150, 31);

        jLabel14.setFont(new java.awt.Font("Lucida Bright", 1, 22)); // NOI18N
        jLabel14.setText("Credits :");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(650, 430, 110, 30);

        creditAmount.setEditable(false);
        creditAmount.setBackground(new java.awt.Color(255, 204, 204));
        creditAmount.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        creditAmount.setText("0.0");
        jPanel1.add(creditAmount);
        creditAmount.setBounds(650, 460, 240, 32);

        creditCBox.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        creditCBox.setText("Add a Credit");
        creditCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditCBoxActionPerformed(evt);
            }
        });
        jPanel1.add(creditCBox);
        creditCBox.setBounds(740, 330, 150, 31);

        jButton1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton1.setText("Reset Credit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(740, 213, 140, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void itemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCodeActionPerformed
        try {
            ItemControllerByDilan itemController = new ItemControllerByDilan();
            if (itemCode.getText() != null && itemController.searchItem(itemCode.getText()) != null) {
                Item searchItem = itemController.searchItem(itemCode.getText());
                itemName.setText(searchItem.getItemName());
                qtyOnHand.setText(String.valueOf(searchItem.getQtyOnHand()));
                sellingPrice.setText(String.valueOf(searchItem.getSellingprice()));
                orderQty.requestFocus();
                itemCode.setEnabled(false);
                orderQty.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "There is no such item in system ", null, JOptionPane.ERROR_MESSAGE);
                resetAllFields();

            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemCodeActionPerformed

    private void orderQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderQtyActionPerformed
        ItemControllerByDilan itemController = new ItemControllerByDilan();
        try {
            if (itemCode.getText() != null && orderQty.getText() != null && Integer.parseInt(orderQty.getText().trim()) <= itemController.searchItem(itemCode.getText()).getQtyOnHand() && Integer.parseInt(orderQty.getText().trim()) > 0) {

                itemCodeFor = itemCode.getText();
                addToCart.doClick();
                itemCode.setEnabled(true);
                resetAllFields();
                //Item searchItem = itemController.searchItem(itemCode.getText());
                //qtyOnHand.setText(String.valueOf(searchItem.getQtyOnHand()));                
            } else if (itemCode.getText() == null) {
                JOptionPane.showMessageDialog(null, "Please select a item", null, JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Enter valid order Qty ", null, JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Enter qty", null, JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_orderQtyActionPerformed

    private void addToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartActionPerformed
        if (!(itemCode.getText().isEmpty() || orderQty.getText().isEmpty() || itemName.getText().isEmpty() || qtyOnHand.getText().isEmpty() || sellingPrice.getText().isEmpty())) {
            ItemControllerByDilan controller = new ItemControllerByDilan();
            try {
                if (avoidItemDuplication(itemCode.getText())) {
                    String[] item = {itemCode.getText(), itemName.getText(), orderQty.getText(), sellingPrice.getText().trim(), String.valueOf(getEachTotal())};
                    tableModel.addRow(item);
                    totalAmount.setText(String.valueOf(getFullTotal()));
                    netTotalAmount.setText(String.valueOf(getNetTotal()));
                    controller.updateItemQty(itemCodeFor, Integer.parseInt(qtyOnHand.getText()) - Integer.parseInt(orderQty.getText()));
                } else {
                    String[] options = {"Replace", "Update", "Cancel"};
                    int respond = JOptionPane.showOptionDialog(null, "This item already in the cart" + "\n" + "What you want to do?", null, 0, JOptionPane.ERROR_MESSAGE, null, options, 1);
                    switch (respond) {
                        case 0:
                            String[] item = {
                                itemCode.getText(),
                                itemName.getText(),
                                orderQty.getText(),
                                sellingPrice.getText().trim(),
                                String.valueOf(getEachTotal())
                            };
                            controller.updateItemQty(itemCodeFor, controller.searchItem(itemCodeFor).getQtyOnHand() + Integer.parseInt(itemCart.getValueAt(duplicatedRow, 2).toString()) - Integer.parseInt(orderQty.getText()));
                            tableModel.removeRow(duplicatedRow);
                            tableModel.insertRow(duplicatedRow, item);
                            totalAmount.setText(String.valueOf(getFullTotal()));
                            netTotalAmount.setText(String.valueOf(getNetTotal()));
                            itemCode.setEnabled(true);
                            break;

                        case 1:
                            controller.updateItemQty(itemCodeFor, controller.searchItem(itemCodeFor).getQtyOnHand() - Integer.parseInt(orderQty.getText()));
                            itemCart.setValueAt(String.valueOf(Integer.parseInt(itemCart.getValueAt(duplicatedRow, 2).toString()) + Integer.parseInt(orderQty.getText())), duplicatedRow, 2);
                            itemCart.setValueAt(String.valueOf(getEachTotal(Integer.parseInt(itemCart.getValueAt(duplicatedRow, 2).toString()))), duplicatedRow, 4);
                            totalAmount.setText(String.valueOf(getFullTotal()));
                            netTotalAmount.setText(String.valueOf(getNetTotal()));
                            itemCode.setEnabled(true);
                            break;
                    }

                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
            }
            resetAllFields();
            setEnableAllButtons(false);
        }
    }//GEN-LAST:event_addToCartActionPerformed

    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        if (!totalAmount.getText().isEmpty() && !amount.getText().isEmpty() && (Double.parseDouble(amount.getText().trim()) >= Double.parseDouble(netTotalAmount.getText().trim())) && (amount.getText().trim().matches("[\\d]+[.]{1}[\\d]{2}") || amount.getText().trim().matches("[\\d]+")) && tableModel.getRowCount() > 0) {
            balance.setText("" + ((Double.parseDouble(amount.getText()) - Double.parseDouble(netTotalAmount.getText()))));
            confirm.setEnabled(true);
            confirm.doClick();
        } else if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Cart dosen't have any items", null, JOptionPane.ERROR_MESSAGE);
            confirm.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Enter a valid amount", null, JOptionPane.ERROR_MESSAGE);
            confirm.setEnabled(false);
        }
    }//GEN-LAST:event_amountActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed

        if (itemCart.getSelectedRow() != -1) {
            ItemControllerByDilan controller = new ItemControllerByDilan();
            try {
                controller.updateItemQty(itemCart.getValueAt(itemCart.getSelectedRow(), 0).toString(), controller.searchItem(itemCart.getValueAt(itemCart.getSelectedRow(), 0).toString()).getQtyOnHand() + Integer.parseInt(itemCart.getValueAt(itemCart.getSelectedRow(), 2).toString()));
                tableModel.removeRow(itemCart.getSelectedRow());
                totalAmount.setText(String.valueOf(getFullTotal()));
                netTotalAmount.setText(String.valueOf(getNetTotal()));
                if (itemCart.getRowCount() == 0) {
                    setEnableAllButtons(true);
                }
                itemCode.requestFocus();
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please Select Row");
        }

    }//GEN-LAST:event_removeActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        if (tableModel.getRowCount() > 0) {
            ItemControllerByDilan controller = new ItemControllerByDilan();
            for (int i = 0; i < itemCart.getRowCount(); i++) {
                try {
                    controller.updateItemQty(itemCart.getValueAt(i, 0).toString(), controller.searchItem(itemCart.getValueAt(i, 0).toString()).getQtyOnHand() + Integer.parseInt(itemCart.getValueAt(i, 2).toString()));
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
                }
            }
            try {
                new CreditController().removeCredits(returnOrderId.trim());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewOrderPenal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(NewOrderPenal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(NewOrderPenal.class.getName()).log(Level.SEVERE, null, ex);
            }
            setEnableAllButtons(true);
            tableModel.setRowCount(0);
            totalAmount.setText(null);
            amount.setText("0.0");
            balance.setText("0.0");
            confirm.setEnabled(false);
            netTotalAmount.setText("0.0");
            discountAmount.setText("0.0");
            itemCode.setText(null);
            if (itemCodeRButton.isSelected()) {
                itemCode.requestFocus();
            } else {
                JTextField txt = (JTextField) itemNames.getEditor().getEditorComponent();
                txt.setText(null);
                txt.requestFocus();
            }
            resetAfterAll();
        }
    }//GEN-LAST:event_cancelActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        if (amount.getText() != null && tableModel.getRowCount() > 0 && !amount.getText().isEmpty()) {
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh-mm-ss a");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            ArrayList<OrderDetail> orderDetailList = new ArrayList<>();
            ItemControllerByDilan itemController = new ItemControllerByDilan();
            OrderControllerByDilan orderController = new OrderControllerByDilan();

            try {
                for (int i = 0; i < itemCart.getRowCount(); i++) {
                    OrderDetail orderDetail = new OrderDetail(orderId.getText(), String.valueOf(itemCart.getValueAt(i, 0)), itemController.searchItem(String.valueOf(itemCart.getValueAt(i, 0))).getSupplierPrice(), itemController.searchItem(String.valueOf(itemCart.getValueAt(i, 0))).getSellingprice(), Integer.parseInt(itemCart.getValueAt(i, 2).toString()), Double.parseDouble(itemCart.getValueAt(i, 4).toString()));
                    orderDetailList.add(orderDetail);
                }
                boolean addOrder = orderController.addOrder(new Orders().setOrderId(orderId.getText()).setDate(dateFormat.format(date)).setTime(timeFormat.format(date)).setUserName(userName.trim()).setTotal(Double.parseDouble(totalAmount.getText().trim())).setDiscountAmount(Double.parseDouble(discountAmount.getText().trim())), orderDetailList);
                if (addOrder) {
                    JOptionPane.showMessageDialog(null, "Order adding is successfull", null, JOptionPane.INFORMATION_MESSAGE);
                    confirm.setEnabled(false);
                    new CreditController().removeAllCredits();
                    if (Double.parseDouble(netTotalAmount.getText().trim()) < 0) {
                        int res = JOptionPane.showConfirmDialog(null, "Net total is less than 0\nDo you want to 0 it ?", "", JOptionPane.YES_NO_OPTION);
                        if (res == JOptionPane.YES_OPTION) {
                            netTotalAmount.setText("0.0");
                            balance.setText(amount.getText().trim());
                        }
                    }
                    printBill();
                    tableModel.setRowCount(0);
                    resetAllFields();
                    resetAfterAll();
                    try {
                        OrderControllerByDilan orderController2 = new OrderControllerByDilan();
                        orderId.setText(orderController2.getNewOrderId());
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);

                    }
                    setEnableAllButtons(true);
                    confirm.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Order adding is not successfull", null, JOptionPane.ERROR_MESSAGE);
                    cancel.doClick();
                    tableModel.setRowCount(0);
                    resetAllFields();
                    resetAfterAll();
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no items in the cart", null, JOptionPane.ERROR_MESSAGE);
            resetAllFields();
            resetAfterAll();
        }

        /*Orders orders;
         try {
         boolean addOrder = OrderControllerByDilan.addOrder(orders, orderDetailList);
         if (addOrder) {
         JOptionPane.showMessageDialog(this, "Order saved successfully ...");
         } else {
         JOptionPane.showMessageDialog(this, "Order saved fail ...");
         }
         } catch (ClassNotFoundException | SQLException ex) {
            
         }*/

    }//GEN-LAST:event_confirmActionPerformed

    private void orderQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderQtyKeyReleased
        Validation.validateQty(orderQty);
    }//GEN-LAST:event_orderQtyKeyReleased

    private void amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyReleased
        Validation.validateprice(amount);
    }//GEN-LAST:event_amountKeyReleased

    private void orderQtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderQtyFocusGained

    }//GEN-LAST:event_orderQtyFocusGained

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost

    }//GEN-LAST:event_formFocusLost

    private void jLabel11PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel11PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11PropertyChange

    private void orderQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderQtyKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            itemCode.setEnabled(true);
            resetAllFields();
        }
    }//GEN-LAST:event_orderQtyKeyPressed

    private void itemCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemCodeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            if (tableModel.getRowCount() > 0) {
                amount.requestFocus();
                itemCode.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "There is no items in the cart", "Reminding", JOptionPane.ERROR_MESSAGE);
                itemCode.setText(null);
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_F4) {
            itemCode.setText(null);
            new LogInSystem(page, this, new JFrame(), true).setVisible(true);
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            itemCodeRButton.setSelected(false);
            itemCode.setEnabled(false);
            itemNames.setEnabled(true);
            itemNameRButton.setSelected(true);
            JTextField txt = (JTextField) itemNames.getEditor().getEditorComponent();
            txt.setText(null);
            txt.requestFocus();

        }
    }//GEN-LAST:event_itemCodeKeyPressed

    private void totalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmountActionPerformed

    private void itemCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemCodeKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_F) {
            JOptionPane.showMessageDialog(null, "There is no items in the cart", "Reminding", JOptionPane.ERROR_MESSAGE);
            itemCode.setText(null);

        } else if (evt.getKeyCode() == KeyEvent.VK_L) {
            itemCode.setText(null);
        }
    }//GEN-LAST:event_itemCodeKeyReleased

    private void amountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountFocusGained
        amount.setText(null);
        if (tableModel.getRowCount() == 0) {
            if (itemCodeRButton.isSelected()) {
                itemCode.setText(null);
                itemCode.requestFocus();
            } else {
                JTextField txt = (JTextField) itemNames.getEditor().getEditorComponent();
                txt.setText(null);
                txt.requestFocus();
            }
        }
    }//GEN-LAST:event_amountFocusGained

    private void itemNameRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameRButtonActionPerformed
        if (itemNameRButton.isSelected()) {
            itemNames.setEnabled(true);
            itemCode.setEnabled(false);
            itemCode.setText(null);
            JTextField txt = (JTextField) itemNames.getEditor().getEditorComponent();
            txt.setText(null);
            txt.requestFocus();
            if (itemNames.getItemCount() > 0 && itemNames.getSelectedItem() != null && itemNames.getSelectedItem().toString().trim().length() > 1 && itemNames.getSelectedItem().toString().trim().split("<##>").length == 3) {
                try {
                    ItemControllerByChule itemController = new ItemControllerByChule();
                    Item searchItem = itemController.searchItem(itemNames.getSelectedItem().toString().trim().split("<##>")[1]);
                    if (searchItem != null) {
                        itemCode.setText(searchItem.getItemCode());
                        itemName.setText(searchItem.getItemName());
                        qtyOnHand.setText(String.valueOf(searchItem.getQtyOnHand()));
                        sellingPrice.setText(String.valueOf(searchItem.getSellingprice()));
                        orderQty.requestFocus();
                        itemCode.setEnabled(false);
                        orderQty.setEnabled(true);
                    }
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_itemNameRButtonActionPerformed

    private void itemCodeRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCodeRButtonActionPerformed
        if (itemCodeRButton.isSelected()) {
            itemNames.setEnabled(false);
            itemCode.setEnabled(true);
            itemCode.setText(null);
            resetAllFields();

        }
    }//GEN-LAST:event_itemCodeRButtonActionPerformed

    private void itemNamesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemNamesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNamesKeyReleased

    private void itemNamesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemNamesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            orderQty.requestFocus();
        }
    }//GEN-LAST:event_itemNamesKeyPressed

    private void itemNamesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemNamesItemStateChanged

        if (itemNames.getItemCount() > 0 && itemNames.getSelectedItem().toString().trim().length() > 1 && itemNames.getSelectedIndex() != -1 && itemNames.getSelectedItem().toString().trim().split("<##>").length == 3) {
            try {
                ItemControllerByChule itemController = new ItemControllerByChule();
                Item searchItem = itemController.searchItem(itemNames.getSelectedItem().toString().trim().split("<##>")[1]);
                if (searchItem != null) {
                    itemCode.setText(searchItem.getItemCode());
                    itemName.setText(searchItem.getItemName());
                    qtyOnHand.setText(String.valueOf(searchItem.getQtyOnHand()));
                    sellingPrice.setText(String.valueOf(searchItem.getSellingprice()));
                    itemCode.setEnabled(false);
                    orderQty.setEnabled(true);
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "ClassNotFoundException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "SQLException occured. Please restart the system", null, JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + "ex.getMessage", null, JOptionPane.ERROR_MESSAGE);
            }
        } else if (itemNames.getSelectedItem() != null && itemNames.getSelectedItem().toString().trim().length() <= 1) {
            resetAllFields();
            JTextField txt = (JTextField) itemNames.getEditor().getEditorComponent();
            txt.setText(null);
            txt.requestFocus();
        }
    }//GEN-LAST:event_itemNamesItemStateChanged

    private void itemNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNamesActionPerformed

    private void discountCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountCBoxActionPerformed
        if (tableModel.getRowCount() > 0 && discountCBox.isSelected()) {
            new DiscountFrame(new JFrame(), true, this).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Cart dosen't have any items", null, JOptionPane.ERROR_MESSAGE);
            discountCBox.setSelected(false);
        }
    }//GEN-LAST:event_discountCBoxActionPerformed

    private void creditCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditCBoxActionPerformed
        if (tableModel.getRowCount() > 0 && creditCBox.isSelected()) {
            new CreditFrame(new JFrame(), true, this).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Cart dosen't have any items", null, JOptionPane.ERROR_MESSAGE);
            creditCBox.setSelected(false);
        }
    }//GEN-LAST:event_creditCBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        netTotalAmount.setText(String.valueOf(Double.parseDouble(netTotalAmount.getText().trim()) + Double.parseDouble(creditAmount.getText().trim())));
        creditAmount.setText("0.0");
        creditCBox.setEnabled(true);
        returnOrderId = "";
    }//GEN-LAST:event_jButton1ActionPerformed
    private double getFullTotal() {
        double total = 0;
        for (int i = 0; i < itemCart.getRowCount(); i++) {
            total += Double.parseDouble(tableModel.getValueAt(i, 4).toString());
        }
        return total;
    }

    private double getNetTotal() {
        double total = 0;
        for (int i = 0; i < itemCart.getRowCount(); i++) {
            total += Double.parseDouble(tableModel.getValueAt(i, 4).toString());
        }
        return total - Double.parseDouble(discountAmount.getText().trim()) - Double.parseDouble(creditAmount.getText().trim());
    }

    private double getEachTotal() {
        return Double.parseDouble(sellingPrice.getText()) * Integer.parseInt(orderQty.getText());
    }

    private double getEachTotal(int qty) {
        return qty * Double.parseDouble(sellingPrice.getText());
    }

    private boolean avoidItemDuplication(String itemCode) {
        if (itemCart.getRowCount() > 0) {
            boolean rtn = true;
            for (int i = 0; i < itemCart.getRowCount(); ++i) {
                if (itemCode.equals(tableModel.getValueAt(i, 0).toString())) {
                    duplicatedRow = i;
                    return false;
                } else {
                    rtn = true;
                }
            }
            return rtn;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCart;
    public javax.swing.JTextField amount;
    public javax.swing.JTextField balance;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancel;
    public javax.swing.JButton confirm;
    public javax.swing.JTextField creditAmount;
    public javax.swing.JCheckBox creditCBox;
    public javax.swing.JTextField discountAmount;
    public javax.swing.JCheckBox discountCBox;
    private javax.swing.JTable itemCart;
    private javax.swing.JTextField itemCode;
    private javax.swing.JRadioButton itemCodeRButton;
    private javax.swing.JTextField itemName;
    private javax.swing.JRadioButton itemNameRButton;
    private javax.swing.JComboBox itemNames;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextField netTotalAmount;
    private javax.swing.JTextField orderId;
    private javax.swing.JTextField orderQty;
    private javax.swing.JTextField qtyOnHand;
    private javax.swing.JButton remove;
    private javax.swing.JTextField sellingPrice;
    public javax.swing.JTextField totalAmount;
    // End of variables declaration//GEN-END:variables

    private void resetAllFields() {
        itemName.setText(null);
        qtyOnHand.setText(null);
        sellingPrice.setText(null);
        itemCode.setText(null);
        orderQty.setText(null);
        if (itemCodeRButton.isSelected()) {
            itemCode.requestFocus();
            itemCode.setEnabled(true);
        } else {
            itemCode.setEnabled(false);
            JTextField txt = (JTextField) itemNames.getEditor().getEditorComponent();
            txt.setText(null);
            txt.requestFocus();
        }
        orderQty.setEnabled(false);
        confirm.setEnabled(false);
    }

    private void resetAfterAll() {
        amount.setText(null);
        totalAmount.setText(String.valueOf(0.0));
        discountAmount.setText(String.valueOf(0.0));
        balance.setText(String.valueOf(0.0));
        netTotalAmount.setText(String.valueOf(0.0));
        creditAmount.setText(String.valueOf(0.0));
        creditCBox.setEnabled(true);
        returnOrderId = "";
        if (itemCodeRButton.isSelected()) {
            itemCode.requestFocus();
        } else {
            JTextField txt = (JTextField) itemNames.getEditor().getEditorComponent();
            txt.setText(null);
            txt.requestFocus();
        }
    }

    private void printBill() {
        try {
            //JasperReport compileReport = JasperCompileManager.compileReport("./src/Report/Bill.jrxml");
            HashMap<String, Object> date = new HashMap<>();
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = new Date();
            String formatedTime = timeFormat.format(date1);
            String formatedDate = dateFormat.format(date1);
            String presentage = String.format("%1$.2f", (Double.parseDouble(discountAmount.getText().trim()) / Double.parseDouble(totalAmount.getText().trim())) * 100) + "%";
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("BIINO", orderId.getText().trim());
            parameters.put("USER", userName.trim());
            parameters.put("DATE", formatedDate.trim());
            parameters.put("TIME", formatedTime.trim());
            parameters.put("TOTAL", totalAmount.getText().trim());
            parameters.put("AMO", amount.getText().trim());
            parameters.put("BALANCE", balance.getText().trim());
            parameters.put("DIS", presentage);
            parameters.put("CREDIT", creditAmount.getText().trim());
            parameters.put("NET", netTotalAmount.getText().trim());
            JRTableModelDataSource source = new JRTableModelDataSource(tableModel);
            JasperPrint fillReport = JasperFillManager.fillReport("./src/Report/Bill.jasper", parameters, source);
            JasperViewer.viewReport(fillReport, false);
            /*
            boolean printPage = JasperPrintManager.printReport(fillReport, false);
            if (printPage) {
                JOptionPane.showMessageDialog(null, "Bill was Printed");
            } else {
                JOptionPane.showMessageDialog(null, "Bill was not Printed");
            }
             */
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Something wrong with the bill\nSystem is not able to print the bill", "", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void disableAllFields(boolean value) {
        orderQty.setEnabled(value);
        amount.setEnabled(value);
    }

    public void cancelDoClick() {
        cancel.doClick();
    }

    private void setEnableAllButtons(boolean bool) {
        page.accountButton.setEnabled(bool);
        page.newOrderButton.setEnabled(bool);
        page.newStockButton.setEnabled(bool);
        page.optionsButton.setEnabled(bool);
        page.reportButton.setEnabled(bool);
        page.returnsButton.setEnabled(bool);
        page.viewButton1.setEnabled(bool);
        page.infoButton.setEnabled(bool);
    }

    private void fillCustomerDetailCombo() throws ClassNotFoundException, SQLException, IOException {
        ArrayList<Item> items = new ItemControllerByChule().getAllItems();
        itemNames.addItem("");
        if (items.size() > 0) {
            for (Item item : items) {
                itemNames.addItem(item.getItemName().trim() + "<##>" + item.getItemCode().trim() + "<##>" + item.getSellingprice());
            }

        }

    }
}
