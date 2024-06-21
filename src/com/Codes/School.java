package com.Codes;

import com.database.Sql;
import com.Main.Main_frame;
import static com.database.DBconnect.CONN;
import static com.database.Sql.getCovered;
import com.home.CropImage;
import java.awt.Rectangle;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class School {

    public ImageIcon profImage;
    public String Name;
    public String Email;
    public String Email_password;
    public String Address;
    public String district;
    public ImageIcon Badge;
    public String Telephone;
    public String username;

    public School(String username) {
        this.username = username;
        profImage = Sql.getImage("SELECT Image FROM schooldetails WHERE Username='" + username + "'", CONN);
        Name = Sql.getValueS("SELECT Name FROM schooldetails  WHERE Username='" + username + "'", CONN);
        Email = Sql.getValueS("SELECT Email FROM schooldetails  WHERE Username='" + username + "'", CONN);
        Email_password = Sql.getValueS("SELECT EmailPassword FROM schooldetails  WHERE Username='" + username + "'", CONN);
        Address = Sql.getValueS("SELECT Address FROM schooldetails  WHERE Username='" + username + "'", CONN);
        district = Sql.getValueS("SELECT district FROM schooldetails  WHERE Username='" + username + "'", CONN);
        Badge = Sql.getImage("SELECT Logo FROM schooldetails WHERE Username='" + username + "'", CONN);
        Telephone = Sql.getValueS("SELECT Telephone FROM schooldetails  WHERE Username='" + username + "'", CONN);
    }

    public ImageIcon getRoundImage() {
        return new ImageIcon(new CropImage(profImage.getImage(), new Rectangle(profImage.getIconWidth() > profImage.getIconHeight()
                ? (profImage.getIconWidth() - profImage.getIconHeight()) / 2 : 0,
                profImage.getIconWidth() < profImage.getIconHeight()
                ? (profImage.getIconHeight() - profImage.getIconWidth()) / 2 : 0,
                profImage.getIconWidth() > profImage.getIconHeight()
                ? profImage.getIconHeight() : profImage.getIconWidth(),
                profImage.getIconWidth() > profImage.getIconHeight()
                ? profImage.getIconHeight() : profImage.getIconWidth())).cropCircle());
    }

    public Object[] getAll() {
        return new Object[]{Name, Address, Telephone, Badge,profImage, Email, Email_password};
    }

    public void setAll(String[] data) {
        try {
            Sql.insertData("INSERT INTO ", "SchoolDetails", data, CONN);
        } catch (Exception ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getName() {
        return Name;
    }

    public void setName(String val) {
        Commons.setDefault("School_name", val, CONN);
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String val) {
        Commons.setDefault("School_email", val, CONN);
    }

    public String getEmail_password() {
        return Email_password;
    }

    public void setEmail_password(String val) {
        Commons.setDefault("School_email_password", val, CONN);
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String val) {
        Commons.setDefault("School_address", val, CONN);
    }

    public ImageIcon getBadge() {
        return Badge;
    }

    public void setBadge(String badge) {
        try {
            Sql.insertImage(CONN.prepareStatement("UPDATE Images SET Image=? WHERE" + getCovered(Main_frame.ID_NO) + "='School_logo'"), badge);
        } catch (SQLException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setImage(String img) {
        try {
            Sql.insertImage(CONN.prepareStatement("UPDATE Images SET Image=? WHERE" + getCovered(Main_frame.ID_NO) + "='School_image'"), img);
        } catch (SQLException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String val) {
        Commons.setDefault("School_phone", val, CONN);
    }
}
