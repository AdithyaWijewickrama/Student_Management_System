package com.HealthReport;

import com.database.Sql;
import com.database.DBconnect;
import static com.database.DBconnect.CONN;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Immunition {

    String id;

    public Immunition(String id) {
        this.id = id;
    }

    public void get(){
        
    }
    
    public void set(String name,int dose,Date date){
        try {
            Sql.Execute(!hasData(id, name,dose)?"INSERT INTO immunity VALUES('"+id+"','"+name+"','"+dose+"','"+date.getTime()+"')":"UPADATE immune_progs SET given_date='"+date.getTime()+"' WHERE id='"+id+"' AND name='"+name+"' AND dose='"+dose+"'", CONN);
        } catch (SQLException ex) {
            Logger.getLogger(Immunition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Object> gatNames() {
        return Sql.getColumn("SELECT name FROM immune_progs", 0, DBconnect.CONN);
    }

    public static boolean hasData(String id,String name){
        return Sql.getValue("SELECT id FROM immunity WHERE id='"+id+"' AND name='"+name+"'", DBconnect.CONN)!=null;
    }
    public static boolean hasData(String id,String name,int dose){
        return Sql.getValue("SELECT id FROM immunity WHERE id='"+id+"' AND name='"+name+"' AND dose='"+dose+"'", DBconnect.CONN)!=null;
    }
    
    public static int getDosses(String name) {
        try {
            return Integer.parseInt(Sql.getValueS("SELECT doses FROM immune_progs WHERE name='" + name + "'", DBconnect.CONN));
        } catch (Exception ex) {
            return 1;
        }
    }

    public static void addNew(String name, int dosses) throws Exception {
        Sql.Execute("INSERT INTO immune_progs VALUES ('" + name + "','" + dosses + "')", DBconnect.CONN);
    }

    public static void remove(String name) {
        try {
            Sql.Execute("DELETE FROM Vaccines WHERE Name='" + name + "'", DBconnect.CONN);
        } catch (Exception ex) {
            Logger.getLogger(Immunition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
