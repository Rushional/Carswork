package views.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogAddService extends DialogAdd {
    private JTextField textFieldName;
    private JTextField textFieldPrice;
    private ServiceData serviceData;

    public DialogAddService(JFrame frame) {
        super(frame);
        var inputNameLabel = new JLabel("Введите название услуги:");
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

        var inputPriceLabel = new JLabel("Введите её стоимость:");
        var inputPriceLabelConstraints = new GridBagConstraints();
        inputPriceLabelConstraints.gridx = 0;
        inputPriceLabelConstraints.gridy = 2;
        inputPriceLabelConstraints.anchor = GridBagConstraints.WEST;
        inputPriceLabelConstraints.insets = new Insets(0,0,8,0);
        panel.add(inputPriceLabel, inputPriceLabelConstraints);

        textFieldPrice = new JTextField(20);
        var textFieldPriceConstraints = new GridBagConstraints();
        textFieldPriceConstraints.gridx = 0;
        textFieldPriceConstraints.gridy = 3;
        textFieldPriceConstraints.anchor = GridBagConstraints.WEST;
        panel.add(textFieldPrice, textFieldPriceConstraints);

        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                double price;
                String nameText = textFieldName.getText();
                if (!nameText.equals("")) {
                    name = nameText;
                    String priceText = textFieldPrice.getText();
                    if (!priceText.equals("")) {
                        price = Double.parseDouble(priceText);
                        DialogAddService.this.dispose();
                        serviceData = new ServiceData(name, price);
                    }
                }
            }
        });
    }

    @Override
    int getDialogHeight() {
        return 110;
    }

    public ServiceData getServiceData() {
        return serviceData;
    }

    @Override
    void setOkayButtonCoordinates(GridBagConstraints okayButtonConstraints) {
        okayButtonConstraints.gridx = 1;
        okayButtonConstraints.gridy = 3;
    }
}
