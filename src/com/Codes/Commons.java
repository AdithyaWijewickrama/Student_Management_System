package com.Codes;

import com.database.Sql;
import static com.database.Sql.Execute;
import static com.database.Sql.ExecuteSQL;
import com.Main.Defaults;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import net.proteanit.sql.DbUtils;

public class Commons {

    public static Date date = Calendar.getInstance().getTime();
    public static final String EMPTYSTRING = "";
    public static final String APPNAME = "Student Management System";

    public static ByteArrayOutputStream getBytes(File f) throws FileNotFoundException, IOException {
        if (f != null) {
            FileInputStream in = new FileInputStream(f);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int r; (r = in.read(buf)) != -1;) {
                bout.write(buf, 0, r);
            }
            return bout;
        } else {
            return null;
        }
    }
    public static void CopytoClipboard(String text) {
        java.awt.datatransfer.Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection sel = new StringSelection(text);
        clip.setContents(sel, sel);
    }

    public static int showConfMsg(String e) {
        return JOptionPane.showConfirmDialog(null, e);
    }

    public static void showMsg(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    public static String getDefault(String id, Connection conn) {
        return (String) Sql.getValue("SELECT Value FROM Defaults WHERE ID='" + id + "'", conn);
    }

    public static void setDefault(String ID, String val, Connection conn) {
        try {
            Execute("DELETE FROM Defaults WHERE ID=\"" + ID + "\"", conn);
            Execute("INSERT INTO Defaults (ID,Value) VALUES (\"" + ID + "\",\"" + val + "\")", conn);
        } catch (Exception ex) {
            Logger.getLogger(Commons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String getDefault(Defaults id, Connection conn) {
        return (String) Sql.getValue("SELECT Value FROM Defaults WHERE ID='" + id + "'", conn);
    }

    public static void setDefault(Defaults ID, String val, Connection conn) {
        try {
            Execute("INSERT OR REPLACE INTO Defaults (ID,Value) VALUES (\"" + ID + "\",\"" + val + "\")", conn);
        } catch (Exception ex) {
            Logger.getLogger(Commons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int getInt(String val) {
        try {
            Integer.parseInt(val);
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static double getDouble(String val) {
        try {
            Double.parseDouble(val);
            return Double.parseDouble(val);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static boolean tableIsSelected(JTable table) {
        if (table.getSelectedRow() == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static void showMsg(String e) {
        JOptionPane.showMessageDialog(null, e);
    }

    public static void setHoverColor(JComponent comp, Color EntColor, Color ExtColor) {
        comp.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                comp.setBackground(EntColor);
                comp.setForeground(EntColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                comp.setBackground(ExtColor);
            }
        });
    }

    public static void setToConsume(JTextField txt, char c) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if (key == c) {
                    e.consume();
                }
            }
        });
    }

    public static void setToOnlyDigits(JTextField txt) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if (key != KeyEvent.VK_BACK_SPACE && key != KeyEvent.VK_DELETE && !Character.isDigit(key)) {
                    e.consume();
                }
            }
        });
    }

    public static void setToOnlyDigitsWITHb(JTextField txt, boolean b) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (b) {
                    e.consume();
                }
            }
        });
    }

    public static void setToOnlyDigitsORb(JTextField txt, boolean b) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if (key != KeyEvent.VK_BACK_SPACE || key != KeyEvent.VK_DELETE || !Character.isDigit(key) || b) {
                    e.consume();
                }
            }
        });
    }
    public static void CopyPasteFile(String CurrentPath, String NewPath) {
        try {
            FileInputStream in = new FileInputStream(CurrentPath);
            FileOutputStream out = new FileOutputStream(NewPath);
            BufferedOutputStream bout;
            try (BufferedInputStream bin = new BufferedInputStream(in)) {
                bout = new BufferedOutputStream(out);
                int bi = 0;
                while (bi != -1) {
                    bi = bin.read();
                    bout.write(bi);
                }
            }
            bout.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static String CurrentDate() {
        return showDate(date);
    }

    public static Date currentDate() {
        return date;
    }

    public static String join(String del,List<Object> li){
        String r="";
        for (int i = 0; i < li.size(); i++) {
            r=r.concat(li.get(i)+(i==li.size()-1?"":del));
        }
        return r;
    }
    
    public static String CurrentTime() {
        return String.format("%02d:%02d:%02d", date.getHours(),date.getMinutes(),date.getSeconds());
    }

    public static void tableload(String sql, JTable table, Connection conn) {
        try {
            table.setModel(DbUtils.resultSetToTableModel(ExecuteSQL(sql, conn)));
        } catch (SQLException ex) {
            System.err.println(sql);
            Logger.getLogger(Commons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void openFile(String Path_Name) throws IOException {
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + Path_Name);
    }

    public static ImageIcon getImage(String ImagePath, int Width, int Height) {
        ImageIcon Imge;
        if (ImagePath == null) {
            return null;
        }
        Imge = new ImageIcon(ImagePath);
        if (Width == 0) {
            Width = Imge.getIconWidth();
        }
        if (Height == 0) {
            Height = Imge.getIconHeight();
        }
        java.awt.Image img = Imge.getImage();
        java.awt.Image newimg = img.getScaledInstance(Width, Height, 25);
        ImageIcon i = new ImageIcon(newimg);
        return i;
    }

    public static ImageIcon getImage(ImageIcon Image, int Width, int Height) {
        if (Image == null) {
            return null;
        }
        if (Width == 0) {
            Width = Image.getIconWidth();
        }
        if (Height == 0) {
            Height = Image.getIconHeight();
        }
        java.awt.Image img = Image.getImage();
        java.awt.Image newimg = img.getScaledInstance(Width, Height, 25);
        ImageIcon i = new ImageIcon(newimg);
        return i;
    }

    public static void clear(Container comp) {
        for (Object c : comp.getComponents()) {
            if(c instanceof JTextComponent){
                ((JTextComponent)c).setText("");
            }
        }
    }

    public static String showDate(Date d) {
        return String.format("%04d-%02d-%02d", d.getYear()+1900, d.getMonth()+1, d.getDate());
    }

    public static String showDate(int y, int m, int d) {
        return String.format("%04d-%02d-%02d", y, m, d);
    }

    public static String ShowTime(int h, int min, int s) {
        return String.format("%02d:%02d:%02d", h, min, s);
    }

    public static String getApplicationDir() {
        return new File("").getAbsolutePath();
    }
    public static void main(String[] args) {
        System.out.println(showDate(date));
    }
}