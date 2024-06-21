package com.Codes;

import com.MarksReport.Marks;
import static com.database.DBconnect.CONN;
import com.database.Sql;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestClass {

    public static void main(String[] args) {
        for (int i = 1; i <= 13; i++) {
            HashSet<Object> idset=new HashSet<>();
            for (Object id : Sql.getColumn(String.format("SELECT ID FROM grade%02d", i),0,CONN)) {
                idset.add(id);
            }
            for (Object id : idset) {
                List<Object> terms = Sql.getColumn(String.format("SELECT term FROM grade%02d where ID='"+id+"'", i), 0, CONN);
                for (Object term : terms) {
                    try {
                        new Marks((String)id, (String)term, i).updateMarks();
                    } catch (Exception ex) {
                        Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
