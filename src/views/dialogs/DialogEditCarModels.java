package views.dialogs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The problem with this guy right here is that there is some code duplication
// between this guy and the other dialog - DialogEditServices
// But Making yet another abstract class just for these 2 is kinda inefficient:
// They have quite a lot of differences, and making the abstract class generic enough
// would require too much effort. It's not worth it right now in my opinion.
// I think it's much more efficient to just make 2 classes that are really similar
// So that's what I'm running with!
public class DialogEditCarModels extends DialogEdit {
    private double rentCost = Double.NaN;

    public DialogEditCarModels(JFrame frame) {
        super(frame);
        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                We should ensure that the string actually parses into a double
//                if it doesn't, the query won't run, so it's fine
//                But we should, because it's just better UI.
//                As of now we don't, so yeah TODO, though not a priority
                String textFieldValue = textField.getText();
                if (!textFieldValue.equals("")) {
                    rentCost = Double.parseDouble(textFieldValue);
                    DialogEditCarModels.this.dispose();
                }
            }
        });
    }

    @Override
    String getInputLabelText() {
        return "Введите стоимость аренды:";
    }

    public double getRentCost() {
        return rentCost;
    }
}
