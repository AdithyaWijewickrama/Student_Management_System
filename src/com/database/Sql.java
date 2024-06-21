package com.database;

import Standard.array;
import com.Codes.Commons;
import com.Codes.ImageWriter;
import static com.database.DBconnect.CONN;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Sql {

    public static String getCovered(String str) {
        return "\"" + str + "\"";
    }

    public static String getCoveredt(String str) {
        return "`" + str + "`";
    }

    public static String getCoveredLike(String str) {
        return "\"%" + str + "%\"";
    }

    public static void Execute(String sql, Connection conn) throws SQLException {
        PreparedStatement pst1 = conn.prepareStatement(sql);
        System.out.println("Executing query:" + sql);
        pst1.execute();
    }

    public static void insertImage(PreparedStatement pst, String img) throws FileNotFoundException,
            IOException,
            SQLException {
//        FileInputStream in = new FileInputStream(new File(img));
//        pst.setBlob(1, in);
        pst.setBytes(1, Commons.getBytes(new File(img)).toByteArray());
        pst.execute();
    }

    public static ImageIcon getImage(String sql, Connection conn) {
        try {
            ResultSet r = ExecuteSQL(sql, conn);
            if (r.next()) {
                return new ImageIcon(r.getBytes(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static File getTempImage(String sql, Connection conn) {
        try {
            ResultSet r = ExecuteSQL(sql, conn);
            File f = null;
            if (r.next()) {
                f = File.createTempFile("SMS TempFiles(Do not delete)", ".jpg");
                f.deleteOnExit();
                ImageIO.write(ImageWriter.getImage(new ImageIcon(r.getBytes(1))), "jpg", f);
            }
            return f;
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void insertFile(PreparedStatement pst, File f)
            throws FileNotFoundException, IOException, SQLException {
        if (f.exists()) {
            pst.setBytes(1, Commons.getBytes(f).toByteArray());
            pst.execute();
        }
    }

    public static byte[] getFile(String sql, Connection conn) {
        try {
            ResultSet r = ExecuteSQL(sql, conn);
            if (r.next()) {
                return r.getBytes(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<Object> getRow(String sql, Connection conn) {
        try {
            List<List<Object>> list = getNestedList(ExecuteSQL(sql, conn));
            return list.isEmpty() ? null : list.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Object getValue(String sql, Connection conn) {
        List<List<Object>> list;
        try {
            list = getNestedList(ExecuteSQL(sql, conn));
            return list.isEmpty() ? null : list.get(0).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getValueS(String sql, Connection conn) {
        Object val = getValue(sql, conn);
        return val == null ? null : val.toString();
    }

    public static List<Object> getColumn(String sql, int columnIdx, Connection conn) {
        System.out.println(sql);
        System.out.println(sql);
        try {
            ResultSet rst = ExecuteSQL(sql, conn);
            List<Object> col = new ArrayList<>();
            getNestedList(rst).forEach((ele) -> {
                col.add(ele.get(columnIdx));
            });
            return col;
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet ExecuteSQL(String sql, Connection conn) throws SQLException {
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        System.out.println("Executing query(return):" + sql);
        return rs;
    }

    public static List<List<Object>> getNestedList(ResultSet rs) {
        try {
            List<List<Object>> rows = new ArrayList<>();
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            while (rs.next()) {
                List<Object> newRow = new ArrayList<>();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.add(rs.getObject(i));
                }
                rows.add(newRow);
            }
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getInsertableData(String pre, String table, String data[]) {
        String sql = "" + pre + "\"" + table + "\" VALUES ('";
        sql = sql.concat(String.join("','", data)).concat("')");
        return sql;
    }

    public static void insertData(String pre, String table, List<Object> data, Connection conn) {
        String[] a = new String[data.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = "?";
        }
        String sql = pre + "\"" + table + "\" VALUES (" + String.join(",", a) + ")";
        try {
            PreparedStatement rs = conn.prepareStatement(sql);
            int i = 1;
            for (Object o : data) {
                rs.setObject(i, o);
                i++;
            }
            rs.execute();
        } catch (SQLException ex) {
            System.err.println("Error :" + sql);
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getInsertableData(String pre, String table, Object data[]) {
        String sql = "" + pre + "" + getCoveredt(table) + " VALUES ('";
        sql = sql.concat(String.join("','", array.getStr(data))).concat("')");
        return sql;
    }

    public static void InsertDataByColumns(String table, Connection conn, int rows, String def, Object[]... data) throws Exception {
        for (int i = 0; i < rows; i++) {
            Object[] sql = new Object[data.length];
            for (int j = 0; j < data.length; j++) {
                Object s = def;
                try {
                    s = data[j][i];
                } catch (Exception e) {
                }
                sql[j] = s;
            }
            insertData("INSERT INTO ", table, sql, conn);
        }
    }

    public static void insertDataToColumns(String table, Connection conn, List<Object>... data) throws Exception {
        for (int i = 0; i < data.length; i++) {
            List<Object> sql = new ArrayList<>();
            for (int j = 0; j < data.length; j++) {
                sql.add(data[i].get(j));
            }
            insertData("INSERT INTO ", table, sql, conn);
        }
    }

    public static void insertData(String pre, String table, Object data[][], Connection conn) throws SQLException {
        for (Object[] data1 : data) {
            insertData(pre, table, Arrays.asList(data1), conn);
        }
    }

    public static void insertData(String pre, List<List<Object>> data, String table, Connection conn) throws SQLException {
        for (List<Object> data1 : data) {
            insertData(pre, table, data1, conn);
        }
    }

    public static void insertData(String pre, String table, Object data[], Connection conn) throws SQLException {
        insertData(pre, table, Arrays.asList(data), conn);
    }

    public static void insertDataToColumn(String table, String column, Object data[], Connection conn) throws SQLException {
        String sql;
        for (Object data1 : data) {
            sql = "INSERT INTO \"" + table + "\" (\"" + column + "\") VALUES (\"" + data1 + "\")";
            Execute(sql, conn);
        }
    }

    public static void insertDataToColumns(String string, Connection CONN, ArrayList<Double> marks) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        System.out.println(getTempImage("select image from images where ID='3099'", CONN).getAbsolutePath());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
