package views.panels;

import javax.swing.*;

public abstract class TablePanel extends JPanel {
    private JTable currentJTable;

//    This class removes the current shown panel and immediately starts displaying another one
    abstract void replaceTable(JTable replacementTable);
}
