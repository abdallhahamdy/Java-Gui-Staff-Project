
package uni_staff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class add extends JPanel implements ActionListener{
    JLabel fname,lname,add,depart;
    JTextField firstname,lastname,addr,department;
    JButton send;
    public add()
    {
        this.setLayout(null);
        // ..in.. fname,lname department,and address label 
        fname=new JLabel("first name");
        lname=new JLabel("last name");
        add=new JLabel("address");
        depart=new JLabel("department");
        fname.setBounds(50, 50, 80, 25);
        lname.setBounds(50, 80, 80, 25);
        add.setBounds(50, 110, 80, 25);
        depart.setBounds(50, 140, 80, 25);
        add(fname);add(lname);add(add);add(depart);
        // ..in.. fname,lname department,and address text
        firstname=new JTextField();
        lastname=new JTextField();
        addr=new JTextField();
        department=new JTextField();
        firstname.setBounds(150, 50, 120, 20);
        lastname.setBounds(150, 80, 120, 20);
         addr.setBounds(150, 110, 120, 20);
          department.setBounds(150,140, 120, 20);
          add(firstname);add(lastname);add(addr);add(department);
        // ..in.. send data
        send=new JButton("send data");
        send.setBounds(120, 200, 100, 20);
        add(send);
        send.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==send)
        {
            try {
                database.student_database.insert_student(firstname.getText(), lastname.getText(), addr.getText(), department.getText());
                JOptionPane.showMessageDialog(null, "hello  " + firstname.getText(), "new student ", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    
}
