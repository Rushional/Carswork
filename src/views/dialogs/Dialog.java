package views.dialogs;

import javax.swing.*;
import java.awt.*;

public abstract class Dialog extends JDialog {
    public Dialog(JFrame frame) {
        super(frame, ModalityType.APPLICATION_MODAL);
        setSize(300, 200);
        setUndecorated(true);
        setLocationRelativeTo(frame);
        setLayout(new GridBagLayout());
    }
}
