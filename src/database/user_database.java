package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import domain.user;
import java.sql.ResultSet;

public class user_database {
    
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }

    public static void insert_user(String user, String pass, String depart) throws SQLException {
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("insert into user values(?,?,?)");) {
            p.setString(1, user);
            p.setString(2, pass);
            p.setString(3, depart);
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }

    public static ArrayList<user> get_users() {
        ArrayList<user> list = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from user");) {
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new user(r.getString("user_name"), r.getString("password"), r.getString("department")));
            }
            r.close();

        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }

        return list;
    }

    public static int check_user(String user, String pass) {
        ArrayList<user> arr = get_users();
        int x = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getUser_name().equalsIgnoreCase(user)) {
                if (arr.get(i).getPassword().equalsIgnoreCase(pass)) {
                    x = 1;
                    break;

                } else {
                    x = 2;
                    break;
                }
            } else {
                x = 0;
            }
        }
        return x;
    }

    public static String get_department(String user) throws SQLException {
        try (
                Connection con = connect();
                PreparedStatement ps = con.prepareStatement("select department from user where user_name=?");) {

            ps.setString(1, user);
            ResultSet r = ps.executeQuery();
            return r.getString("department");

        } catch (SQLException ee) {

        }

        return null;
    }

}
