package views.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogAddCarModel extends DialogAdd {
    private JTextField textFieldName;
    private JTextField textFieldCost;
    private CarModelData carModelData;

    public DialogAddCarModel(JFrame frame) {
        super(frame);
        var inputNameLabel = new JLabel("Введите название модели:");
        var inputNameLabelConstraints = new GridBagConstraints();
        inputNameLabelConstraints.gridx = 0;
        inputNameLabelConstraints.gridy = 0;
        inputNameLabelConstraints.anchor = GridBagConstraints.WEST;
        inputNameLabelConstraints.insets = new Insets(0,0,8,0);
        panel.add(inputNameLabel, inputNameLabelConstraints);

        textFieldName = new JTextField(20);
        var textFieldNameConstraints = new GridBagConstraints();
        textFieldNameConstraints.gridx = 0;
        textFieldNameConstraints.gridy = 1;
        textFieldNameConstraints.anchor = GridBagConstraints.WEST;
        panel.add(textFieldName, textFieldNameConstraints);

        var inputCostLabel = new JLabel("Введите стоимость аренды:");
        var inputCostLabelConstraints = new GridBagConstraints();
        inputCostLabelConstraints.gridx = 0;
        inputCostLabelConstraints.gridy = 2;
        inputCostLabelConstraints.anchor = GridBagConstraints.WEST;
        inputCostLabelConstraints.insets = new Insets(0,0,8,0);
        panel.add(inputCostLabel, inputCostLabelConstraints);

        textFieldCost = new JTextField(20);
        var textFieldCostConstraints = new GridBagConstraints();
        textFieldCostConstraints.gridx = 0;
        textFieldCostConstraints.gridy = 3;
        textFieldCostConstraints.anchor = GridBagConstraints.WEST;
        panel.add(textFieldCost, textFieldCostConstraints);

        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                double cost;
                String nameText = textFieldName.getText();
                if (!nameText.equals("")) {
                    name = nameText;
                    String costText = textFieldCost.getText();
                    if (!costText.equals("")) {
                        cost = Double.parseDouble(costText);
                        DialogAddCarModel.this.dispose();
                        carModelData = new CarModelData(name, cost);
                    }
                }
            }
        });
    }

    @Override
    int getDialogHeight() {
        return 110;
    }

    public CarModelData getCarModelData() {
        return carModelData;
    }

    @Override
    void setOkayButtonCoordinates(GridBagConstraints okayButtonConstraints) {
        okayButtonConstraints.gridx = 1;
        okayButtonConstraints.gridy = 3;
    }
}
