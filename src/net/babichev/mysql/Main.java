package net.babichev.mysql;

import net.babichev.libs.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class Main {

    public static void main(String[] args) {

        String query = "SELECT * FROM `graph`";
//        String query = "INSERT INTO `examples`(`id`, `name`) VALUES (null, 'hello world')";

        DataBase db = new DataBase("java", "localhost", 3306, "root", "");

        try {
            PreparedStatement ps = db.connect().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("v1: " + rs.getString("v1") + "; v2: " + rs.getString("v2"));
            }
        }
        catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        finally {
            db.disconnect();
        }
    }
}
