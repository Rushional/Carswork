package views.panels;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    public OutputPanel()
    {
        setBackground(new Color(235, 240, 255));
//        setPreferredSize(new Dimension(700, 300));
        setPreferredSize(new Dimension(500, 120));
        add(new JButton("Удалить"));
    }
}
