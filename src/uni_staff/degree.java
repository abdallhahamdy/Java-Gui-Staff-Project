
package uni_staff;


import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;


public class degree extends JPanel implements ActionListener{
    JTable table; 
    static String depart;
    JScrollPane sc;
    String data [][];
    String header[]={"id","fname","lname"};
    JLabel m1,m2,m3,m4,m5,m6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton adddegree;
    int x;
    ArrayList<domain.student> arr;
    public degree(String s)
    {
        depart=s;
        this.setLayout(null);
        show_table();
    }
    public void show_table()
    {
        arr=database.student_database.get_students(depart);
        System.out.println(depart);
        // init... table 
        data=new String[arr.size()][3];
        for(int i=0;i<arr.size();i++)
        {
            data[i][0]=""+arr.get(i).getId();
            data[i][1]=arr.get(i).getFname();
            data[i][2]=arr.get(i).getLname();
        }
        table=new JTable(data,header);
        sc=new JScrollPane(table);
        sc.setBounds(0, 0,250,322);
        add(sc);
        // init... degree label , button and textfield 
        m1=new JLabel("IS");
        m2=new JLabel("NC");
        m3=new JLabel("IT");
        m4=new JLabel("SC");
        m5=new JLabel("SA");
        m6=new JLabel("AI");
        m1.setBounds(260, 20, 50, 25);
        m2.setBounds(260, 50, 50, 25);
        m3.setBounds(260, 80, 50, 25);
        m4.setBounds(260, 110, 50, 25);
        m5.setBounds(260, 140, 50, 25);
        m6.setBounds(260, 170, 50, 25);
        add(m1);add(m2);add(m3);add(m4);add(m5);add(m6);
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        t1.setBounds(320, 20, 50, 20);
        t2.setBounds(320, 50, 50, 20);
        t3.setBounds(320, 80, 50, 20);
        t4.setBounds(320, 110, 50, 20);
        t5.setBounds(320, 140, 50, 20);
        t6.setBounds(320, 170, 50, 20);
        add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);
        adddegree=new JButton("add degree");
        adddegree.setBounds(290, 220, 100, 20);
        adddegree.setBackground(Color.LIGHT_GRAY);
        adddegree.setForeground(Color.blue);
        add(adddegree);
        adddegree.addActionListener(this);
        // config ...table 
        
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer v=new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for(int i=0;i<table.getColumnCount();i++)
        {
            table.getColumnModel().getColumn(i).setCellRenderer(v);
        }
       table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
       // init event table 
       table.addMouseListener(new java.awt.event.MouseAdapter() {
          
           @Override
           public void mouseClicked(java.awt.event.MouseEvent evt)
           {
               ttmouseClicked(evt);
           }

       });
       
    }
    private void ttmouseClicked(java.awt.event.MouseEvent evt)
    {
        x=table.getSelectedRow();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            int id=arr.get(x).getId();
            database.degree_database.insert_degree(id, Integer.parseInt(t1.getText()),Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()));
            JOptionPane.showMessageDialog(null, "inserted degree", "new degree ", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ee)
        {
            
        }
    }
}
