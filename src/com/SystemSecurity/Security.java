package com.SystemSecurity;

import com.database.Sql;
import static com.database.Sql.Execute;
import com.database.DBconnect;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Security {

    public static final Connection CONN = DBconnect.CONN;
    public List<Object> All;
    public String Password;
    public String user_name;
    public String Question;
    public String Answer;

    public Security(String user) {
        All = Sql.getRow("SELECT * FROM security WHERE Username='" + user + "'", CONN);
        if (All != null) {
            Password = All.get(1).toString();
            user_name = All.get(0).toString();
            Question = All.get(2).toString();
            Answer = All.get(3).toString();
        }
    }

    void setAll() {
        try {
            Execute("UPDATE security SET Username=\"" + user_name + "\",Password=\"" + Password + "\",Question=\"" + Question + "\",Answer=\"" + Answer + "\"", CONN);
        } catch (Exception ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Object> getAll() {
        return All;
    }

    public void setAll(List<Object> all) {
        All = all;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
        setAll();
    }

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String userName) {
        user_name = userName;
        setAll();
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = new Encryption().encrypt(question);
        setAll();
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
        setAll();
    }

}
