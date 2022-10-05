package database;

import static database.student_database.connect;
import domain.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class degree_database {

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }

    public static void insert_degree(int id, int m1, int m2, int m3, int m4, int m5, int m6) throws SQLException {
        try {
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into degree values(?,?,?,?,?,?,?,?)");

            p.setInt(1, id);
            p.setInt(2, m1);
            p.setInt(3, m2);
            p.setInt(4, m3);
            p.setInt(5, m4);
            p.setInt(6, m5);
            p.setInt(7, m6);
            p.setInt(8, m1 + m2 + m3 + m4 + m5 + m6);
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }

    public static ArrayList<domain.degree> get_degree(int id) {
        ArrayList<domain.degree> list = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from degree where id=?");) {
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new domain.degree(r.getInt("id"), r.getInt("m1"), r.getInt("m2"), r.getInt("m3"), r.getInt("m4"), r.getInt("m5"), r.getInt("m6")));
            }

        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
        return list;
    }

    public static void update_degree(int id, int m1, int m2, int m3, int m4, int m5, int m6) {
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("update degree set m1=? ,m2=? ,m3=? ,m4=? ,m5=? ,m6=? where id=?");) {

            p.setInt(1, m1);
            p.setInt(2, m2);
            p.setInt(3, m3);
            p.setInt(4, m4);
            p.setInt(5, m5);
            p.setInt(6, m6);
            p.setInt(7, id);
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }
}
