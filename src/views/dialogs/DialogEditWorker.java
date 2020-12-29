package views.dialogs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogEditWorker extends DialogEdit {
    private String phoneNumber = null;

    public DialogEditWorker(JFrame frame) {
        super(frame);
//        I know I could use lambda, but this just feels more intuitive
//        I should probably grow out of it. I think this is a sign that I'm not
//        comfortable with lambdas yet. I should work on that.
        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textFieldValue = textField.getText();
                if (!textFieldValue.equals("")) {
                    phoneNumber = textFieldValue;
                    DialogEditWorker.this.dispose();
                }
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
