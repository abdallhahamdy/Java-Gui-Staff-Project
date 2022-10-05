package uni_staff;

import database.user_database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class first_screen extends JFrame implements ActionListener {

    JLabel user, pass;
    JTextField user_name;
    JPasswordField password;
    JButton signin, signup;
    image ii = new image();

    public first_screen() {

    }

    public void show_first_screen() {
        // ..in.. user and password label 
        user = new JLabel("user name");
        pass = new JLabel(" password ");
        user.setBounds(100, 70, 80, 25);
        pass.setBounds(100, 100, 80, 25);
        ii.add(user);
        ii.add(pass);
        // ..in.. user and password textfield 
        user_name = new JTextField();
        password = new JPasswordField();
        user_name.setBounds(190, 70, 150, 20);
        password.setBounds(190, 103, 150, 20);
        ii.add(user_name);
        ii.add(password);
        // ..in.. signin and sign up button  
        signin = new JButton("sign in");
        signup = new JButton("sign up");
        signin.setBounds(120, 140, 80, 20);
        signup.setBounds(210, 140, 80, 20);
        ii.add(signin);
        ii.add(signup);
        signin.addActionListener(this);
        signup.addActionListener(this);
        //// ..in.. main form for pro 
        setTitle("uni_staff");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(428, 322);
        setVisible(true);

        add(ii);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signin) {
            int i = user_database.check_user(user_name.getText(), password.getText());
            switch (i) {
                case 1:
                    JOptionPane.showMessageDialog(null, "hello doctor  " + user_name.getText(), " user ", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                     {
                        try {
                            System.out.println(user_database.get_department(user_name.getText()));
                            new doctor(user_database.get_department(user_name.getText())).show_doctor_screen();
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "password wrong", "error password", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "user wrong", "error user", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }

        if (e.getSource() == signup) {
            this.dispose();
            new sec_secreen().show_second_screen();
        }

    }
}
