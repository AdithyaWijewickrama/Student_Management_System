package com.SystemSecurity;

import com.Front.UI;
import static com.Codes.AppConfig.SECUREICON;
import com.Communication.TrayMessage;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.AWTException;
import java.awt.TrayIcon;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ChangePasswordOption extends javax.swing.JDialog {

    int value = -1;
    public static int CLOSED = -1;
    public static int MATCHED = 0;
    public static int NOTMATCHED = 1;
    public static int CANCEL = 2;
    public String username;
    public String password;
    public ChangePasswordOption(JFrame owner, String username, boolean model) {
        super(owner, model);
        initComponents();
        this.username=username;
        jLabel1.setText(UI.wrapText(new Security(username).getQuestion(), jLabel1.getFontMetrics(jLabel1.getFont()).stringWidth(jLabel1.getText()), "left", jLabel1));
        UI.setOkButton(jButton1);
        jPasswordField1.setEchoChar(jCheckBox1.isSelected() ? (char) 0 : '•');
        jLabel7.setText(username);
        UI.genarateCenter(this, getWidth(), getHeight());
    }

    public String getPassword() {
        return jPasswordField1.getText();
    }

    public int getAction() {
        this.setVisible(true);
        
        return value;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        np = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Security");
        setMaximumSize(new java.awt.Dimension(405, 440));
        setMinimumSize(new java.awt.Dimension(405, 440));
        setPreferredSize(new java.awt.Dimension(405, 440));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Enter the answer");

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("show answer");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jPasswordField1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Security Question for change......");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 365, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jCheckBox1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", jPanel1);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("New Password");

        np.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        np.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("User name");

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("show answer");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(np)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(np, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox2)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -34, -1, 320));

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, -1));

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        switch (jTabbedPane1.getSelectedIndex()) {
            case 0 -> {
                if (jPasswordField1.getText().equals(new Security(username).getAnswer())) {
                    jTabbedPane1.setSelectedIndex(1);
                    jButton1.setText("Ok");
                    jButton2.setText("Back");
                    value = 0;
                } else {
                    try {
                        new TrayMessage("Answer is wrong", jPasswordField1.getText() + " is not the correct answer", TrayIcon.MessageType.ERROR).display();
                    } catch (AWTException | MalformedURLException ex) {
                        Logger.getLogger(ChangePasswordOption.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    value = 1;
                }
            }
            case 1 -> {
                value = 0;
                password=np.getText();
                new Security(username).setPassword(np.getText());
                JOptionPane.showMessageDialog(this, "Password updated!");
                setVisible(false);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        switch (jTabbedPane1.getSelectedIndex()) {
            case 0:
                value = 2;
                setVisible(false);
                break;
            case 1:
                jButton1.setText("Next");
                jTabbedPane1.setSelectedIndex(0);
                break;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        value = -1;
    }//GEN-LAST:event_formWindowClosing

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        jButton1.doClick(200);
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        jPasswordField1.setEchoChar(jCheckBox1.isSelected() ? (char) 0 : '•');
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void npActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npActionPerformed
        np.transferFocus();
    }//GEN-LAST:event_npActionPerformed

    private void npKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_npKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            jButton1.requestFocus();
        }
    }//GEN-LAST:event_npKeyTyped

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        np.setEchoChar(jCheckBox2.isSelected() ? (char) 0 : '•');
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ChangePasswordOption.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                ChangePasswordOption dialog = new ChangePasswordOption(User_login.username);
//                System.out.println(dialog.getAction());
//                System.exit(0);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JCheckBox jCheckBox2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JPasswordField np;
    // End of variables declaration//GEN-END:variables
}
