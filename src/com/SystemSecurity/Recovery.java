package com.SystemSecurity;

import static com.Codes.AppConfig.SECUREICON;
import com.Communication.TrayMessage;
import static com.SystemSecurity.User_login.username;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.TrayIcon;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class Recovery extends javax.swing.JDialog {
    Connection conn = Security.CONN;
    private String Question;
    private String Answer;

    public Recovery() {
        initComponents();
        Question = new Security(username).getQuestion();
        Answer = new Security(username).getAnswer();
        setData();
        this.setIconImage(SECUREICON.getImage());
        setModalityType(ModalityType.APPLICATION_MODAL);
    }

    void setData() {
        qbox.setSelectedItem(Question);
        abox.setText(Answer);
    }

    public void Update(){
        try {
            new Security(username).setAnswer(Answer);
            new Security(username).setQuestion(Question);
            new TrayMessage("Chages saved",SECUREICON.getImage(), "Changes saved!\nNEW QUESTION\t:'" + Question + "'\nNew answer\t:'" + Answer + "'","Saved", TrayIcon.MessageType.INFO).display();
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Recovery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AWTException ex) {
            Logger.getLogger(Recovery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        qbox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        u = new javax.swing.JTextField();
        p = new javax.swing.JPasswordField();
        abox = new javax.swing.JPasswordField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Password Recovery Information");
        setMinimumSize(new java.awt.Dimension(440, 310));
        setPreferredSize(new java.awt.Dimension(440, 310));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        qbox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        qbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your First School?", "What is your Fathers Name?", "What is your favorite Movie?", "What is your best friends Name?", "What is your favorite Subject?", "Who is your favorite Author?", "Who is your favorite Person?" }));
        qbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qboxActionPerformed(evt);
            }
        });
        qbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qboxKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Answer");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Question");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("?");
        jButton1.setToolTipText("HELP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setIcon(com.Codes.Commons.getImage("src\\Images\\ShowPassword-black.png", 24, 18));
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(27, 110, 240));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Current Password");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Current User Name");

        u.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        u.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                uKeyTyped(evt);
            }
        });

        p.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pKeyTyped(evt);
            }
        });

        jButton5.setIcon(com.Codes.Commons.getImage("src\\Images\\ShowPassword-black.png", 24, 18));
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(u)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p)
                        .addGap(0, 0, 0)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qbox, 0, 403, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(abox)
                        .addGap(0, 0, 0)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)))
                .addGap(3, 3, 3)
                .addComponent(u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(qbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(abox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(17, 17, 17))
        );

        setSize(new java.awt.Dimension(433, 311));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void qboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qboxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String ps = new Security(username).getPassword();
        String un = username;
        Question = qbox.getSelectedItem().toString();
        Answer = abox.getText();
        if (ps.equals(p.getText()) && un.equals(u.getText())) {
            int t = JOptionPane.showConfirmDialog(this, "Are you sure want to change security Q & A");
            try {
                if (t == 0) {
                    Update();
                    this.dispose();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "The entered Password or User name is incorrect!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this, "SECURITY QUESTION:\nIf you forgot your user name or password, to change it we ask you an qustion.\nAnd you've to answer that question correctly.\nChoose a question and type a suitable answer for that question that you won't forget!\n\nEX:\nQuestion:> What is your Fathers Name?\nAnswer:> Edward Mc.Donald");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String password = p.getText();
        String cpassword = new Security(username).getPassword();
        if (password.equals(cpassword)) {
            if (abox.getEchoChar() != (char) 0) {
                abox.setEchoChar((char) 0);
            } else {
                abox.setEchoChar('•');
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(this,"Password is incorrect");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void uKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            p.requestFocus();
        }
    }//GEN-LAST:event_uKeyTyped

    private void pKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            qbox.requestFocus();
        }
    }//GEN-LAST:event_pKeyTyped

    private void qboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qboxKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            abox.requestFocus();
        }
    }//GEN-LAST:event_qboxKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (p.getEchoChar() != (char) 0) {
                p.setEchoChar((char) 0);
            } else {
                p.setEchoChar('•');
            }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recovery().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField abox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField p;
    private javax.swing.JComboBox<String> qbox;
    private javax.swing.JTextField u;
    // End of variables declaration//GEN-END:variables
}
