package views.dialogs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogEditService extends DialogEdit {
    private double servicePrice = Double.NaN;

    public DialogEditService(JFrame frame) {
        super(frame);
        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textFieldValue = textField.getText();
                if (!textFieldValue.equals("")) {
                    servicePrice = Double.parseDouble(textFieldValue);
                    DialogEditService.this.dispose();
                }
            }
        });
    }

    @Override
    String getInputLabelText() {
        return "Введите цену услуги:";
    }

    public double getRentCost() {
        return servicePrice;
    }
}
