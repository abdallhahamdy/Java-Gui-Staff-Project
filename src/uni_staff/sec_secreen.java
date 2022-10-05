package uni_staff;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class sec_secreen extends JFrame implements ActionListener {

    image ii = new image();
    JLabel user, pass, depart, note;
    JTextField user_name, password, department;
    JButton send, back;

    public sec_secreen() {

    }

    public void show_second_screen() {
        // ..in.. user department,and password label 
        user = new JLabel("user name");
        pass = new JLabel("password");
        depart = new JLabel("department");
        note = new JLabel("enter department (cs,is or it ) only ");
        user.setBounds(10, 50, 80, 25);
        pass.setBounds(10, 80, 80, 25);
        depart.setBounds(10, 110, 80, 25);
        note.setBounds(230, 110, 200, 25);

        ii.add(user);
        ii.add(pass);
        ii.add(depart);
        ii.add(note);
        // ..in.. user department,and password textfield
        user_name = new JTextField();
        password = new JTextField();
        department = new JTextField();
        user_name.setBounds(100, 50, 120, 18);
        password.setBounds(100, 80, 120, 18);
        department.setBounds(100, 110, 120, 18);
        ii.add(user_name);
        ii.add(password);
        ii.add(department);
        // ..in.. send data ,back button
        send = new JButton("send data");
        back = new JButton("back");
        send.setBounds(180, 150, 110, 20);
        back.setBounds(0, 0, 70, 20);
        back.setBackground(Color.red);
        back.setForeground(Color.yellow);
        ii.add(send);
        ii.add(back);
        send.addActionListener(this);
        back.addActionListener(this);
        //// ..in.. main form for pro 
        setTitle("log up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(428, 322);
        setVisible(true);
        add(ii);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
            new first_screen().show_first_screen();
        }
        if (e.getSource() == send) {
            try {
                String t1 = department.getText();
                if (t1.equalsIgnoreCase("cs") || t1.equalsIgnoreCase("is") || t1.equalsIgnoreCase("it")) {
                    database.user_database.insert_user(user_name.getText(), password.getText(), department.getText());
                    JOptionPane.showMessageDialog(null, "hello doctor  " + user_name.getText(), "new user ", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new first_screen().show_first_screen();
                } else {
                    JOptionPane.showMessageDialog(null, "department is not exist", "error department", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}
