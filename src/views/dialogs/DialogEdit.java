package views.dialogs;

import javax.swing.*;
import java.awt.*;

// TODO: the dialogs should get the current value of the entry and out it into the textBox
//  as initial text. Not critical, just better UI.
public abstract class DialogEdit extends Dialog {
    JTextField textField;
    JButton okayButton;

    public DialogEdit(JFrame frame) {
        super(frame);
        var inputLabel = new JLabel(getInputLabelText());
        var inputLabelConstraints = new GridBagConstraints();
        inputLabelConstraints.gridx = 0;
        inputLabelConstraints.gridy = 0;
        inputLabelConstraints.insets = new Insets(0,0,10,0);
        panel.add(inputLabel, inputLabelConstraints);

        textField = new JTextField(10);
        var textFieldConstraints = new GridBagConstraints();
        textFieldConstraints.gridx = 0;
        textFieldConstraints.gridy = 1;
        textFieldConstraints.anchor = GridBagConstraints.WEST;
        panel.add(textField, textFieldConstraints);

        okayButton = new JButton("Готово");
        var okayButtonConstraints = new GridBagConstraints();
        okayButtonConstraints.gridx = 1;
        okayButtonConstraints.gridy = 1;
        okayButtonConstraints.anchor = GridBagConstraints.WEST;
        panel.add(okayButton, okayButtonConstraints);
    }

    @Override
    int getDialogWidth() {
        return 380;
    }

    @Override
    int getDialogHeight() {
        return 100;
    }

    abstract String getInputLabelText();
}
