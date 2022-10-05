/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_staff;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import static uni_staff.degree.depart;

/**
 *
 * @author user
 */
public class print_degree extends JPanel implements ActionListener{
    JTable table; 
    JScrollPane sc;
    String data [][];
    String header[]={"id","fname","lname","degree"};
    JButton print;
    ArrayList<domain.student> arr;
    public print_degree()
    {
        this.setLayout(null);
        show_table();
    }
    public void show_table()
    {
        arr=database.student_database.get_students_and_degree();
        
        // init... table
        print=new JButton("print degree");
        data=new String[arr.size()][4];
        for(int i=0;i<arr.size();i++)
        {
            data[i][0]=""+arr.get(i).getId();
            data[i][1]=arr.get(i).getFname();
            data[i][2]=arr.get(i).getLname();
            data[i][3]=arr.get(i).getAddress();
        }
        print.setBounds(180, 0, 120, 20);
        print.setBackground(Color.LIGHT_GRAY);
        print.setForeground(Color.blue);
        add(print);
        print.addActionListener(this);
        table=new JTable(data,header);
        sc=new JScrollPane(table);
        sc.setBounds(20, 30,350,250);
        add(sc);
        
        
       
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
       
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MessageFormat h=new MessageFormat("student degree ");
        MessageFormat f=new MessageFormat("page {1}");
        try{
            table.print(JTable.PrintMode.NORMAL,h,f);
        }catch(Exception ee)
        {
            System.out.println(ee.getMessage());
        }
        }
    }
    

