/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import backup.BackupAndRestore;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Kanishka Gunarathna
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     *
     *
     */
    private String user = "Shalani";
    private String userType = "ADMINISTER";
    private NewOrderPenal op;

    public HomePage() {
        initComponents();
        loadTimeDate();
        setSize(1210, 720);
        setLocationRelativeTo(null);
        BodyPEnal.removeAll();
        NewOrderPenal op = new NewOrderPenal(user, this);
        BodyPEnal.add(op);
        op.setVisible(true);
        op.revalidate();
        op.repaint();
        setResizable(false);

    }

    public HomePage(String user, String userType) {
        initComponents();
        this.user = user;
        this.userType = userType;
        loadTimeDate();
        setSize(1210, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/icon2.png")));
        BodyPEnal.removeAll();
        NewOrderPenal op = new NewOrderPenal(user, this);
        this.op = op;
        BodyPEnal.add(op);
        op.setVisible(true);
        op.revalidate();
        op.repaint();
        newOrderButton.doClick();

    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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
        timeLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        newOrderButton = new javax.swing.JButton();
        reportButton = new javax.swing.JButton();
        optionsButton = new javax.swing.JButton();
        accountButton = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();
        BodyPEnal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        viewButton1 = new javax.swing.JButton();
        returnsButton = new javax.swing.JButton();
        newStockButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        timeLabel.setFont(new java.awt.Font("Algerian", 0, 65)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(0, 0, 204));
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(timeLabel);
        timeLabel.setBounds(10, 0, 390, 80);

        dateLabel.setFont(new java.awt.Font("Castellar", 0, 30)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(0, 0, 204));
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("jLabel1");
        jPanel1.add(dateLabel);
        dateLabel.setBounds(10, 87, 270, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(290, 100, 883, 10);

        newOrderButton.setBackground(new java.awt.Color(0, 153, 153));
        newOrderButton.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        newOrderButton.setForeground(new java.awt.Color(102, 255, 204));
        newOrderButton.setText("New Order");
        newOrderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newOrderButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newOrderButtonMouseExited(evt);
            }
        });
        newOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderButtonActionPerformed(evt);
            }
        });
        jPanel1.add(newOrderButton);
        newOrderButton.setBounds(10, 136, 270, 57);

        reportButton.setBackground(new java.awt.Color(0, 153, 153));
        reportButton.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        reportButton.setForeground(new java.awt.Color(102, 255, 204));
        reportButton.setText("Reports");
        reportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportButtonMouseExited(evt);
            }
        });
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });
        jPanel1.add(reportButton);
        reportButton.setBounds(10, 407, 270, 57);

        optionsButton.setBackground(new java.awt.Color(0, 153, 153));
        optionsButton.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        optionsButton.setForeground(new java.awt.Color(102, 255, 204));
        optionsButton.setText("Options");
        optionsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                optionsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                optionsButtonMouseExited(evt);
            }
        });
        optionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(optionsButton);
        optionsButton.setBounds(10, 475, 270, 59);

        accountButton.setBackground(new java.awt.Color(0, 153, 153));
        accountButton.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        accountButton.setForeground(new java.awt.Color(102, 255, 204));
        accountButton.setText("User Accounts");
        accountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountButtonMouseExited(evt);
            }
        });
        accountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButtonActionPerformed(evt);
            }
        });
        jPanel1.add(accountButton);
        accountButton.setBounds(10, 545, 270, 58);

        infoButton.setBackground(new java.awt.Color(0, 153, 153));
        infoButton.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        infoButton.setForeground(new java.awt.Color(102, 255, 204));
        infoButton.setText("Info");
        infoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoButtonMouseExited(evt);
            }
        });
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(infoButton);
        infoButton.setBounds(10, 614, 270, 55);

        BodyPEnal.setLayout(new java.awt.BorderLayout());
        jPanel1.add(BodyPEnal);
        BodyPEnal.setBounds(286, 110, 895, 560);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AAAAAAAAAAAAAAA.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(298, 11, 883, 80);

        viewButton1.setBackground(new java.awt.Color(0, 153, 153));
        viewButton1.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        viewButton1.setForeground(new java.awt.Color(102, 255, 204));
        viewButton1.setText("View");
        viewButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewButton1MouseExited(evt);
            }
        });
        viewButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(viewButton1);
        viewButton1.setBounds(10, 339, 270, 57);

        returnsButton.setBackground(new java.awt.Color(0, 153, 153));
        returnsButton.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        returnsButton.setForeground(new java.awt.Color(102, 255, 204));
        returnsButton.setText("Return");
        returnsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                returnsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                returnsButtonMouseExited(evt);
            }
        });
        returnsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(returnsButton);
        returnsButton.setBounds(10, 274, 270, 54);

        newStockButton.setBackground(new java.awt.Color(0, 153, 153));
        newStockButton.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        newStockButton.setForeground(new java.awt.Color(102, 255, 204));
        newStockButton.setText("New Stock");
        newStockButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newStockButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newStockButtonMouseExited(evt);
            }
        });
        newStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStockButtonActionPerformed(evt);
            }
        });
        jPanel1.add(newStockButton);
        newStockButton.setBounds(10, 204, 270, 59);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HomeBacground.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1190, 700);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newOrderButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newOrderButtonMouseEntered
        newOrderButton.setForeground(Color.black);
    }//GEN-LAST:event_newOrderButtonMouseEntered

    private void newOrderButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newOrderButtonMouseExited
        newOrderButton.setForeground(new Color(102, 255, 204));
    }//GEN-LAST:event_newOrderButtonMouseExited

    private void reportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMouseEntered
        reportButton.setForeground(Color.black);
    }//GEN-LAST:event_reportButtonMouseEntered

    private void optionsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionsButtonMouseEntered
        optionsButton.setForeground(Color.black);
    }//GEN-LAST:event_optionsButtonMouseEntered

    private void accountButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonMouseEntered
        accountButton.setForeground(Color.black);
    }//GEN-LAST:event_accountButtonMouseEntered

    private void infoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoButtonMouseEntered
        infoButton.setForeground(Color.black);
    }//GEN-LAST:event_infoButtonMouseEntered

    private void reportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMouseExited
        reportButton.setForeground(new Color(102, 255, 204));
    }//GEN-LAST:event_reportButtonMouseExited

    private void optionsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionsButtonMouseExited
        optionsButton.setForeground(new Color(102, 255, 204));
    }//GEN-LAST:event_optionsButtonMouseExited

    private void accountButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonMouseExited
        accountButton.setForeground(new Color(102, 255, 204));
    }//GEN-LAST:event_accountButtonMouseExited

    private void infoButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoButtonMouseExited
        infoButton.setForeground(new Color(102, 255, 204));
    }//GEN-LAST:event_infoButtonMouseExited

    private void viewButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewButton1MouseEntered
        viewButton1.setForeground(Color.black);
    }//GEN-LAST:event_viewButton1MouseEntered

    private void viewButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewButton1MouseExited
        viewButton1.setForeground(new Color(102, 255, 204));
    }//GEN-LAST:event_viewButton1MouseExited

    private void returnsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnsButtonMouseEntered
        returnsButton.setForeground(Color.black);
    }//GEN-LAST:event_returnsButtonMouseEntered

    private void returnsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnsButtonMouseExited
        returnsButton.setForeground(new Color(102, 255, 204));
    }//GEN-LAST:event_returnsButtonMouseExited

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        /*
                BodyPEnal.removeAll();
        InfoPenal penal = new InfoPenal();
        BodyPEnal.add(penal);
        penal.setVisible(true);
        penal.revalidate();
        penal.repaint();
         */
    }//GEN-LAST:event_infoButtonActionPerformed

    private void accountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountButtonActionPerformed
        if (userType.equals("ADMINISTER")) {
            BodyPEnal.removeAll();
            UserAccountPenal op = new UserAccountPenal();
            BodyPEnal.add(op);
            op.setVisible(true);
            op.revalidate();
            op.repaint();
        } else {
            AdminLogInToAccount adminLogInToOption = new AdminLogInToAccount();
            adminLogInToOption.setVisible(true);
        }
    }//GEN-LAST:event_accountButtonActionPerformed

    private void optionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsButtonActionPerformed

        if (userType.equals("ADMINISTER")) {
            BodyPEnal.removeAll();
            OptionsPenal op = new OptionsPenal();
            BodyPEnal.add(op);
            op.setVisible(true);
            op.revalidate();
            op.repaint();
        } else {
            AdminLogInToOption adminLogInToView = new AdminLogInToOption();
            adminLogInToView.setVisible(true);
        }
    }//GEN-LAST:event_optionsButtonActionPerformed

    private void newStockButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newStockButtonMouseEntered
        newStockButton.setForeground(Color.black);
    }//GEN-LAST:event_newStockButtonMouseEntered

    private void newStockButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newStockButtonMouseExited
        newStockButton.setForeground(new Color(102, 255, 204));
    }//GEN-LAST:event_newStockButtonMouseExited

    private void newOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderButtonActionPerformed
        BodyPEnal.removeAll();
        NewOrderPenal op = new NewOrderPenal(user, this);
        this.op = op;
        BodyPEnal.add(op);
        op.setVisible(true);
        op.revalidate();
        op.repaint();
    }//GEN-LAST:event_newOrderButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        if (userType.equals("ADMINISTER")) {
            BodyPEnal.removeAll();
            ReportMainPeal op = new ReportMainPeal();
            BodyPEnal.add(op);
            op.setVisible(true);
            op.revalidate();
            op.repaint();
        } else {
            AdminLogInToReport adminLogInToView = new AdminLogInToReport();
            adminLogInToView.setVisible(true);
        }
    }//GEN-LAST:event_reportButtonActionPerformed

    private void viewButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButton1ActionPerformed
        if (userType.equals("ADMINISTER")) {
            BodyPEnal.removeAll();
            View op = new View();
            BodyPEnal.add(op);
            op.setVisible(true);
            op.revalidate();
            op.repaint();
        } else {
            AdminLogInToView adminLogInToView = new AdminLogInToView();
            adminLogInToView.setVisible(true);
        }


    }//GEN-LAST:event_viewButton1ActionPerformed

    private void returnsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnsButtonActionPerformed
        BodyPEnal.removeAll();
        ReturnPenal op = new ReturnPenal();
        BodyPEnal.add(op);
        op.setVisible(true);
        op.revalidate();
        op.repaint();
    }//GEN-LAST:event_returnsButtonActionPerformed

    private void newStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStockButtonActionPerformed

        if (userType.equals("ADMINISTER")) {
            BodyPEnal.removeAll();
            NewStockPenal op = new NewStockPenal();
            BodyPEnal.add(op);
            op.setVisible(true);
            op.revalidate();
            op.repaint();
        } else {
            AdminLogInToStock adminLogInToView = new AdminLogInToStock();
            adminLogInToView.setVisible(true);
        }

    }//GEN-LAST:event_newStockButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "If itemcart has items, don't exit, Those items will not able to add the system", null, JOptionPane.YES_NO_OPTION);
        if (showConfirmDialog == JOptionPane.YES_OPTION) {
            File file = new File("./Backup.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException occured." + "\n" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                }
            }
            try {
                if (BackupAndRestore.writeBackUp(file.getPath()) == 0) {
                    JOptionPane.showMessageDialog(null, "Backup is successed", null, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Backup is not successed", null, JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "IOException occured.ww" + "\n" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "InterruptedException occured." + "\n" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            }
            System.exit(0);
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane BodyPEnal;
    public javax.swing.JButton accountButton;
    private javax.swing.JLabel dateLabel;
    public javax.swing.JButton infoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JButton newOrderButton;
    public javax.swing.JButton newStockButton;
    public javax.swing.JButton optionsButton;
    public javax.swing.JButton reportButton;
    public javax.swing.JButton returnsButton;
    private javax.swing.JLabel timeLabel;
    public javax.swing.JButton viewButton1;
    // End of variables declaration//GEN-END:variables

    private void loadTimeDate() {
        Thread t1;
        t1 = new Thread() {

            @Override
            public void run() {
                while (true) {
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
                    String formatedTime = dateFormat.format(date);
                    timeLabel.setText(formatedTime);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {

                    }
                }

            }

        };
        t1.start();

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String format = sdf.format(date);
        dateLabel.setText(format);

    }
}
