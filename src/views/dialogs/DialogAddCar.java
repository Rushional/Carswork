package views.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogAddCar extends DialogAdd {
    private JTextField textFieldModelName;
    private JTextField textFieldLicense;
    private JTextField textFieldColor;
    private CarData carData;

    public DialogAddCar(JFrame frame) {
        super(frame);
        var inputModelNameLabel = new JLabel("Введите название модели:");
        var inputModelNameLabelConstraints = new GridBagConstraints();
        inputModelNameLabelConstraints.gridx = 0;
        inputModelNameLabelConstraints.gridy = 0;
        inputModelNameLabelConstraints.anchor = GridBagConstraints.WEST;
        inputModelNameLabelConstraints.insets = new Insets(0,0,8,0);
        panel.add(inputModelNameLabel, inputModelNameLabelConstraints);

        textFieldModelName = new JTextField(20);
        var textFieldModelNameConstraints = new GridBagConstraints();
        textFieldModelNameConstraints.gridx = 0;
        textFieldModelNameConstraints.gridy = 1;
        textFieldModelNameConstraints.anchor = GridBagConstraints.WEST;
        panel.add(textFieldModelName, textFieldModelNameConstraints);

        var inputLicenseLabel = new JLabel("Введите номерной знак:");
        var inputLicenseLabelConstraints = new GridBagConstraints();
        inputLicenseLabelConstraints.gridx = 0;
        inputLicenseLabelConstraints.gridy = 2;
        inputLicenseLabelConstraints.anchor = GridBagConstraints.WEST;
        inputLicenseLabelConstraints.insets = new Insets(0,0,8,0);
        panel.add(inputLicenseLabel, inputLicenseLabelConstraints);

        textFieldLicense = new JTextField(20);
        var textFieldLicenseConstraints = new GridBagConstraints();
        textFieldLicenseConstraints.gridx = 0;
        textFieldLicenseConstraints.gridy = 3;
        textFieldLicenseConstraints.anchor = GridBagConstraints.WEST;
        panel.add(textFieldLicense, textFieldLicenseConstraints);

        var inputColorLabel = new JLabel("Введите цвет:");
        var inputColorLabelConstraints = new GridBagConstraints();
        inputColorLabelConstraints.gridx = 0;
        inputColorLabelConstraints.gridy = 4;
        inputColorLabelConstraints.anchor = GridBagConstraints.WEST;
        inputColorLabelConstraints.insets = new Insets(0,0,8,0);
        panel.add(inputColorLabel, inputColorLabelConstraints);

        textFieldColor = new JTextField(20);
        var textFieldColorConstraints = new GridBagConstraints();
        textFieldColorConstraints.gridx = 0;
        textFieldColorConstraints.gridy = 5;
        textFieldColorConstraints.anchor = GridBagConstraints.WEST;
        panel.add(textFieldColor, textFieldColorConstraints);

        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modelName;
                String license;
                String color;
                String modelNameText = textFieldModelName.getText();
                if (!modelNameText.equals("")) {
                    modelName = modelNameText;
                    String birthText = textFieldLicense.getText();
                    if (!birthText.equals("")) {
                        license = birthText;
                        String hireText = textFieldColor.getText();
                        if (!hireText.equals("")) {
                            color = hireText;
                            DialogAddCar.this.dispose();
                            carData = new CarData(modelName, license, color);
                        }
                    }
                }
            }
        });
    }

    @Override
    int getDialogHeight() {
        return 170;
    }

    @Override
    void setOkayButtonCoordinates(GridBagConstraints okayButtonConstraints) {
        okayButtonConstraints.gridx = 1;
        okayButtonConstraints.gridy = 5;
    }

    public CarData getCarData() {
        return carData;
    }
}
