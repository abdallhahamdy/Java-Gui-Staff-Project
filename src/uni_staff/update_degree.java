/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_staff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class update_degree extends JPanel implements ActionListener {

    JLabel m1, m2, m3, m4, m5, m6, i;
    JTextField t1, t2, t3, t4, t5, t6, id;
    JButton search_id, update_degree;
    ArrayList<domain.degree> arr;

    public update_degree() {
        this.setLayout(null);
        // init... degree label , button and textfield
        i = new JLabel("enter id student");
        m1 = new JLabel("IS");
        m2 = new JLabel("NC");
        m3 = new JLabel("IT");
        m4 = new JLabel("SC");
        m5 = new JLabel("SA");
        m6 = new JLabel("AI");
        i.setBounds(150, 20, 100, 25);
        m1.setBounds(60, 50, 50, 25);
        m2.setBounds(60, 80, 50, 25);
        m3.setBounds(60, 110, 50, 25);
        m4.setBounds(60, 140, 50, 25);
        m5.setBounds(60, 170, 50, 25);
        m6.setBounds(60, 200, 50, 25);
        add(m1);
        add(m2);
        add(m3);
        add(m4);
        add(m5);
        add(m6);
        add(i);
        id = new JTextField();
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        id.setBounds(280, 20, 50, 20);
        t1.setBounds(120, 50, 50, 20);
        t2.setBounds(120, 80, 50, 20);
        t3.setBounds(120, 110, 50, 20);
        t4.setBounds(120, 140, 50, 20);
        t5.setBounds(120, 170, 50, 20);
        t6.setBounds(120, 200, 50, 20);
        add(id);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        search_id = new JButton("search");
        search_id.setBounds(330, 20, 80, 20);
        add(search_id);
        search_id.addActionListener(this);
        update_degree = new JButton("update degree");
        update_degree.setBounds(100, 220, 120, 20);
        add(update_degree);
        update_degree.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search_id) {
            arr = database.degree_database.get_degree(Integer.parseInt(id.getText()));
            t1.setText("" + arr.get(0).getM1());
            t2.setText("" + arr.get(0).getM2());
            t3.setText("" + arr.get(0).getM3());
            t4.setText("" + arr.get(0).getM4());
            t5.setText("" + arr.get(0).getM5());
            t6.setText("" + arr.get(0).getM6());

        }
        if (e.getSource() == update_degree) {
            database.degree_database.update_degree(Integer.parseInt(id.getText()), Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()));
            JOptionPane.showMessageDialog(null, "update degree ", "update degree ", JOptionPane.INFORMATION_MESSAGE);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            id.setText("");
        }
    }
}
