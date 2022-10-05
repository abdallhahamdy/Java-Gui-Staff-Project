/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_staff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class update_student extends JPanel implements ActionListener{
    JLabel fname,lname,add,depart,i;
    JTextField firstname,lastname,addr,department,id;
    JButton send;
    public update_student()
    {
        this.setLayout(null);
        // ..in.. fname,lname department,and address label 
        i=new JLabel("id student");
        fname=new JLabel("first name");
        lname=new JLabel("last name");
        add=new JLabel("address");
        depart=new JLabel("department");
        i.setBounds(50, 20, 80, 25);
        fname.setBounds(50, 50, 80, 25);
        lname.setBounds(50, 80, 80, 25);
        add.setBounds(50, 110, 80, 25);
        depart.setBounds(50, 140, 80, 25);
        add(i);add(fname);add(lname);add(add);add(depart);
        // ..in.. fname,lname department,and address text
        id=new JTextField();
        firstname=new JTextField();
        lastname=new JTextField();
        addr=new JTextField();
        department=new JTextField();
        id.setBounds(150, 20, 120, 20);
        firstname.setBounds(150, 50, 120, 20);
        lastname.setBounds(150, 80, 120, 20);
         addr.setBounds(150, 110, 120, 20);
          department.setBounds(150,140, 120, 20);
         add(id); add(firstname);add(lastname);add(addr);add(department);
        // ..in.. send data
        send=new JButton("update student");
        send.setBounds(120, 200, 120, 20);
        add(send);
        send.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        database.student_database.update_student(Integer.parseInt(id.getText()),firstname.getText(),lastname.getText(),addr.getText(), department.getText());
        JOptionPane.showMessageDialog(null, "hello  " + firstname.getText(), "update student ", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
