package uni_staff;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class image extends JPanel {

    private ImageIcon i;

    public image() {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        i = new ImageIcon(getClass().getResource("..\\img\\v1.jpg"));
        i.paintIcon(this, g, 0, 0);
    }

}
