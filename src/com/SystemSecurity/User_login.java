package com.SystemSecurity;

import com.Codes.Commons;
import com.Main.Main_frame;
import com.Front.UI;
import com.Codes.AppConfig;
import com.Codes.School;
import com.Main.Defaults;
import com.Main.FormLoad;
import com.database.DBconnect;
import com.database.Sql;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public final class User_login extends javax.swing.JFrame {

    Connection conn = DBconnect.CONN;
    PreparedStatement pst = null;
    ResultSet rs = null;
    boolean exitb = false;
    public static String username = "SMS2022";
    public static School school = new School(username);

    public User_login() {
        initComponents();
        validate();
        repaint();
        doLayout();
        jButton1.setEnabled(false);
        unamebox.setBackground(UI.getTransparentColor());
        password.setBackground(UI.getTransparentColor());
        jButton5.setBackground(UI.getTransparentColor());
        user.setIcon(Commons.getImage("src\\Images\\user-white.png", user.getHeight(), user.getHeight()));
        exit.setIcon(Commons.getImage("src\\Images\\exit2.png", 32, 32));
        logo.setIcon(Commons.getImage("src\\Images\\Logo.png", logo.getWidth(), logo.getHeight()));
        jPanel4.setBackground(new Color(0, 0, 0, 0));
        this.setIconImage(AppConfig.APPICON_50);
        exit.setVisible(false);
        Minimize.setVisible(false);
        unamebox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (unamebox.getText().equals("")) {
                    unplaceholder.setText("User Name");
                } else {
                    unplaceholder.setText("");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                insertUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                insertUpdate(e);
            }
        });
        password.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (password.getText().equals("")) {
                    pwplaceholder.setText("Password");
                } else {
                    pwplaceholder.setText("");
                }
            }
        });
    }

    public User_login(String laf) {
        this();
        switch (laf) {
            case "dark": {
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            break;
            case "light": {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            break;
            default:
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Minimize = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        unamebox = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        pwplaceholder = new javax.swing.JLabel();
        unplaceholder = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        loginbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setText("jLabel6");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Table);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("System Manegement System - My Soft");
        setForeground(new java.awt.Color(51, 51, 51));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setToolTipText("Exit");
        exit.setBorder(null);
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 0, 32, 32));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 0, 32, 32));

        Minimize.setIcon(com.Codes.Commons.getImage("src\\Images\\Minimize-"+ Main_frame.getBorW() +".png", 28, 32)
        );
        Minimize.setToolTipText("Minimize");
        Minimize.setBorder(null);
        Minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimizeMouseExited(evt);
            }
        });
        Minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinimizeActionPerformed(evt);
            }
        });
        getContentPane().add(Minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 0, 32, 32));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setToolTipText("");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 0, 32, 32));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setBorder(null);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 50, 40));

        unamebox.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        unamebox.setForeground(new java.awt.Color(255, 255, 255));
        unamebox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        unamebox.setBorder(null);
        unamebox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        unamebox.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        unamebox.setSelectionColor(new java.awt.Color(204, 204, 204));
        unamebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unameboxKeyReleased(evt);
            }
        });
        jPanel1.add(unamebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 380, 40));

        password.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setBorder(null);
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 380, 40));

        pwplaceholder.setBackground(new java.awt.Color(102, 102, 102));
        pwplaceholder.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        pwplaceholder.setForeground(new java.awt.Color(255, 255, 255));
        pwplaceholder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pwplaceholder.setText("Password");
        jPanel1.add(pwplaceholder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 380, 40));

        unplaceholder.setBackground(new java.awt.Color(102, 102, 102));
        unplaceholder.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        unplaceholder.setForeground(new java.awt.Color(255, 255, 255));
        unplaceholder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unplaceholder.setText("User name");
        jPanel1.add(unplaceholder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 380, 40));

        user.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 380, 100));

        loginbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginbtn.setText("LOG IN");
        loginbtn.setBorder(null);
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });
        jPanel1.add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 350, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("CHANGE");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 80, -1));

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Forgot password or user name?");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 380, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Click to change..");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 380, -1));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 430));

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login.jpg"))); // NOI18N
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 380, 430));

        jPanel2.setBackground(UI.getNavColor());
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(UI.getNavColor()));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel2MouseMoved(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 16, 37));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("System");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Student Mannagement");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("adithyawi3@gmail.com");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));
        jPanel3.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 100, 100));

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Copyright 2022");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Developed by Adithya Wijewickrama");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 430));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ChangePasswordOption act = new ChangePasswordOption(this, User_login.username, true);
        int action = act.getAction();
        if (action == 0) {
            unamebox.setText(act.username);
            password.setText(act.password);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        String uname = unamebox.getText();
        String pword = password.getText();
        if (!uname.equals("") && !pword.equals("")) {
            String Uname = new Security(uname).user_name;
            String Pword = new Security(uname).Password;
            if (Uname!=null && Pword!=null) {
                this.dispose();
                school = new School(uname);
                FormLoad formLoad = new FormLoad();
                formLoad.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "User name or Password is incorrect", "Incorrect input", JOptionPane.ERROR_MESSAGE);
                unamebox.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(this, "User name & password can not be emty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginbtnActionPerformed

    private void unameboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unameboxKeyReleased
        char c = evt.getKeyChar();
        jButton1.setEnabled(Sql.getValue("SELECT * FROM Security WHERE Username='" + unamebox.getText() + "'", DBconnect.CONN) != null);
        if (jButton1.isEnabled()) {
            username = Sql.getValue("SELECT * FROM Security WHERE Username='" + unamebox.getText() + "'", DBconnect.CONN).toString();
        }
        if (c == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            password.requestFocus();
        }
    }//GEN-LAST:event_unameboxKeyReleased

    private void passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyReleased

    }//GEN-LAST:event_passwordKeyReleased

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseExited

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        this.setBounds(evt.getXOnScreen() - evt.getX(), evt.getYOnScreen() - evt.getY(), getWidth(), getHeight());
        validate();
        repaint();
    }//GEN-LAST:event_jPanel2MouseDragged

    private void MinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinimizeActionPerformed
        setState(ICONIFIED);
    }//GEN-LAST:event_MinimizeActionPerformed

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved
        this.setBounds(evt.getXOnScreen() - evt.getX(), evt.getYOnScreen() - evt.getY(), getWidth(), getHeight());
        validate();
        repaint();
    }//GEN-LAST:event_jPanel2MouseMoved

    private void MinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseEntered

    }//GEN-LAST:event_MinimizeMouseEntered

    private void MinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseExited
        Minimize.setVisible(false);
    }//GEN-LAST:event_MinimizeMouseExited

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered

    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        exit.setVisible(false);
    }//GEN-LAST:event_exitMouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        Minimize.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        exit.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (password.getEchoChar() != (char) 0) {
            password.setEchoChar((char) 0);
        } else {
            password.setEchoChar('•');
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        jButton5.setIcon(Commons.getImage("src\\Images\\ShowPassword-" + Main_frame.getBorW() + ".png", 30, 30));
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        jButton5.setIcon(null);
    }//GEN-LAST:event_jButton5MouseExited

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            String uname = unamebox.getText();
            String pword = password.getText();
            String Uname = new Security(uname).user_name;
            String Pword = new Security(uname).Password;
            if (Uname.equals(uname) && Pword.equals(pword)) {
                username = Uname;
                this.dispose();
                FormLoad formLoad = new FormLoad();
                formLoad.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "User name or Password is incorrect");
                unamebox.requestFocus();
            }
        }
    }//GEN-LAST:event_passwordKeyTyped

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered

    }//GEN-LAST:event_jButton1MouseEntered

    void focus(Color c) {
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            int flt = 10;

            @Override
            public void run() {
                flt++;
                jPanel4.setBackground(new Color(c.getRed(), c.getBlue(), c.getGreen(), flt));
                validate();
                repaint();
                if (flt == c.getAlpha()) {
                    cancel();
                }
            }
        };
        t.schedule(task, 10, 2);
    }

    void lost(Color c) {
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            int flt = 140;

            @Override
            public void run() {
                flt--;
                jPanel4.setBackground(new Color(c.getRed(), c.getBlue(), c.getGreen(), flt));
                validate();
                repaint();
                if (flt == 0) {
                    cancel();
                }
            }
        };
        t.schedule(task, 10, 2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Connection conn = DBconnect.CONN;
        switch (Commons.getDefault(Defaults.LookAndFeel, conn)) {
            case "dark":
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                    FlatLaf.updateUI();
                } catch (UnsupportedLookAndFeelException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                break;
            case "light":
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                break;
            default:
                break;
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new User_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Minimize;
    private javax.swing.JTable Table;
    private javax.swing.JButton exit;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loginbtn;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel pwplaceholder;
    private javax.swing.JTextField unamebox;
    private javax.swing.JLabel unplaceholder;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
