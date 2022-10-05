
package uni_staff;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class doctor extends JFrame{
    static String depart;
    JTabbedPane tab;
    add a1;
    degree d1;
    print_degree d2;
    update_student d3;
    update_degree d4;
    public doctor(String s)
    {
        depart=s;
        
    }
     public void show_doctor_screen()
     {
         a1=new add();
         d2=new print_degree();
         d1=new degree(depart);
         d3=new update_student();
         d4=new update_degree();
         //// ..in.. main form for pro 
        setTitle("doctor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(428, 322);
        setVisible(true);
        tab=new JTabbedPane();
        tab.addTab("student", a1);
        tab.addTab("degree", d1);
        tab.addTab("print", d2);
        tab.add("update student",d3);
        tab.add("update degree",d4);
        add(tab);
     }
}
