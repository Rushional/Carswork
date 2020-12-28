package views.dialogs;

import javax.swing.*;
import java.awt.*;

public abstract class Dialog extends JDialog {
    JPanel panel;

    public Dialog(JFrame frame) {
        super(frame, ModalityType.APPLICATION_MODAL);
//        This is needed to calculate the position of the dialog
//        But the actual size is determined by the size of the panel
//        So this size should duplicate that
        setSize(getDialogWidth(), getDialogHeight());
        setUndecorated(true);
        setLocationRelativeTo(frame);
        setLayout(new GridBagLayout());
        GridBagConstraints panelConstraints = new GridBagConstraints();
        panelConstraints.fill = GridBagConstraints.BOTH;
        panel = new JPanel();
//        panel.setBorder(BorderFactory.createLineBorder(new Color(65, 76, 145), 2));
        panel.setBorder(BorderFactory.createMatteBorder(2,2,2,1, new Color(65, 76, 145)));
//        Panel settings
        GridBagLayout panelLayout = new GridBagLayout();
        panel.setLayout(panelLayout);
        panel.setBackground(new Color(173, 196, 228));
        panel.setPreferredSize(new Dimension(getDialogWidth(), getDialogHeight()));
        add(panel, panelConstraints);
    }

    abstract int getDialogWidth();

    abstract int getDialogHeight();
}
