package com.SystemSecurity;

import static com.Codes.Commons.showMsg;
import com.Front.UI;
import static com.SystemSecurity.User_login.username;
import com.database.DBconnect;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Change extends javax.swing.JDialog {

    Connection conn = DBconnect.CONN;

    public Change() {
        initComponents();
        setModalityType(ModalityType.APPLICATION_MODAL);
    }

    public void setInfo(String preUser, String prePass, String newUser, String newPass) {
        jTextField2.setText(preUser);
        jTextField1.setText(prePass);
        jTextField4.setText(newUser);
        jTextField3.setText(newPass);
    }

    public void changeUAndP(String currentUsername, String currentPassword, String typedUsername, String typedPassword, String newUsername, String newPassword) {
        if (currentUsername.equals(typedUsername) && currentPassword.equals(typedPassword)) {
            try {
                new Security(username).setUsername(newUsername);
                new Security(username).setPassword(newPassword);
                UI.genarateCenter(jDialog1, 340, 350);
                setInfo(currentUsername, currentPassword, newUsername, newPassword);
                jDialog1.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ok = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        u = new javax.swing.JTextField();
        nu = new javax.swing.JTextField();
        p = new javax.swing.JPasswordField();
        np = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();

        jDialog1.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jLabel1.setText("Your User name and Password have changed");

        jLabel4.setText("Changes saved");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Previous user name");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Previous password");

        jTextField1.setEditable(false);

        jTextField2.setEditable(false);

        jLabel8.setText("Changed to :");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Current password");

        jTextField3.setEditable(false);

        jTextField4.setEditable(false);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Current user name");

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4))
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1))
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialog1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(17, 17, 17))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addGap(4, 4, 4)
                .addComponent(jLabel11)
                .addGap(4, 4, 4)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel10)
                .addGap(4, 4, 4)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change password & Username");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(325, 300));
        setMinimumSize(new java.awt.Dimension(325, 300));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Current Password");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("New User Name");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Current User Name");

        ok.setBackground(new java.awt.Color(0, 102, 255));
        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        u.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        u.setNextFocusableComponent(p);
        u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uActionPerformed(evt);
            }
        });
        u.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                uKeyTyped(evt);
            }
        });

        nu.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nu.setNextFocusableComponent(np);
        nu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuActionPerformed(evt);
            }
        });
        nu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nuKeyTyped(evt);
            }
        });

        p.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        p.setNextFocusableComponent(nu);
        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pActionPerformed(evt);
            }
        });
        p.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pKeyTyped(evt);
            }
        });

        np.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        np.setNextFocusableComponent(ok);
        np.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                npActionPerformed(evt);
            }
        });
        np.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                npKeyTyped(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("New Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(u, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nu, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(np, javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addGap(4, 4, 4)
                .addComponent(np, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancel)
                    .addComponent(ok))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        String un = u.getText();
        String pw = p.getText();
        String nun = nu.getText();
        String npsw = np.getText();
        String cPs = new Security(username).getPassword();
        String cUn = username;
        if (un.equals(cUn) && pw.equals(cPs)) {
            int l = JOptionPane.showConfirmDialog(null, "Are you sure want to change your User name and Password?");
            if (l == 0) {
                changeUAndP(cUn, cPs, un, pw, nun, npsw);
                setInfo(cUn, cPs, npsw, npsw);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter the correct current Password and User name");
        }
    }//GEN-LAST:event_okActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void uKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            p.requestFocus();
        }
    }//GEN-LAST:event_uKeyTyped

    private void pKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            nu.requestFocus();
        }
    }//GEN-LAST:event_pKeyTyped

    private void nuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            np.requestFocus();
        }
    }//GEN-LAST:event_nuKeyTyped

    private void npKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_npKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            ok.requestFocus();
        }
    }//GEN-LAST:event_npKeyTyped

    private void uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uActionPerformed
        u.transferFocus();
    }//GEN-LAST:event_uActionPerformed

    private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed
        p.transferFocus();
    }//GEN-LAST:event_pActionPerformed

    private void nuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuActionPerformed
        nu.transferFocus();
    }//GEN-LAST:event_nuActionPerformed

    private void npActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npActionPerformed
        np.transferFocus();
    }//GEN-LAST:event_npActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jDialog1.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(new Encryption().decrypt("adiwije"));
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            showMsg(e);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Change c = new Change();
                UI.genarateCenter(c, 415, 300);
                c.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPasswordField np;
    private javax.swing.JTextField nu;
    private javax.swing.JButton ok;
    private javax.swing.JPasswordField p;
    private javax.swing.JTextField u;
    // End of variables declaration//GEN-END:variables
}
