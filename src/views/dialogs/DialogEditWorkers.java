package views.dialogs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogEditWorkers extends DialogEdit {
    private String phoneNumber = null;

    public DialogEditWorkers(JFrame frame) {
        super(frame);
        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNumber = textField.getText();
                DialogEditWorkers.this.dispose();
            }
        });
    }

    @Override
    String getInputLabelText() {
        return "Введите номер телефона:";
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
