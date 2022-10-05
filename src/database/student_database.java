package database;

import domain.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class student_database {

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }

    public static void insert_student(String fname, String lname, String address, String depart) throws SQLException {
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("insert into student (fname,lname,address,department) values(?,?,?,?)");) {
            p.setString(1, fname);
            p.setString(2, lname);
            p.setString(3, address);
            p.setString(4, depart);
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }

    public static ArrayList<student> get_students(String de) {
        ArrayList<student> list = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from student where department=?");) {
            p.setString(1, de);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new student(r.getInt("id"), r.getString("fname"), r.getString("lname"), r.getString("address"), r.getString("department")));
            }

        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
        return list;
    }
    public static ArrayList<student> get_students_and_degree() {
        ArrayList<student> list = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from student,degree where degree.id=student.id");) {

            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new student(r.getInt("id"), r.getString("fname"), r.getString("lname"), r.getString("sum")+"", r.getString("department")));
            }

        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
        return list;
    }
    public static void update_student(int id,String fname, String lname, String address, String depart)
    {
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("update student set fname=? ,lname=? ,address=? ,department=? where id=?");) {
            p.setString(1, fname);
            p.setString(2, lname);
            p.setString(3, address);
            p.setString(4, depart);
            p.setInt(5, id);
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }

}
