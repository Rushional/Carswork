package views.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogAddWorker extends DialogAdd {
    private JTextField textFieldName;
    private JTextField textFieldPhone;
    private JTextField textFieldBirth;
    private JTextField textFieldHire;
    private WorkerData workerData;

    public DialogAddWorker(JFrame frame) {
        super(frame);
        var inputNameLabel = new JLabel("Введите ФИО:");
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

        var inputPhoneLabel = new JLabel("Введите номер телефона:");
        var inputPhoneLabelConstraints = new GridBagConstraints();
        inputPhoneLabelConstraints.gridx = 0;
        inputPhoneLabelConstraints.gridy = 2;
        inputPhoneLabelConstraints.anchor = GridBagConstraints.WEST;
        inputPhoneLabelConstraints.insets = new Insets(0,0,8,0);
        panel.add(inputPhoneLabel, inputPhoneLabelConstraints);

        textFieldPhone = new JTextField(20);
        var textFieldPhoneConstraints = new GridBagConstraints();
        textFieldPhoneConstraints.gridx = 0;
        textFieldPhoneConstraints.gridy = 3;
        textFieldPhoneConstraints.anchor = GridBagConstraints.WEST;
        panel.add(textFieldPhone, textFieldPhoneConstraints);

        var inputBirthLabel = new JLabel("Введите дату рождения:");
        var inputBirthLabelConstraints = new GridBagConstraints();
        inputBirthLabelConstraints.gridx = 0;
        inputBirthLabelConstraints.gridy = 4;
        inputBirthLabelConstraints.anchor = GridBagConstraints.WEST;
        inputBirthLabelConstraints.insets = new Insets(0,0,8,0);
        panel.add(inputBirthLabel, inputBirthLabelConstraints);

        textFieldBirth = new JTextField(20);
        var textFieldBirthConstraints = new GridBagConstraints();
        textFieldBirthConstraints.gridx = 0;
        textFieldBirthConstraints.gridy = 5;
        textFieldBirthConstraints.anchor = GridBagConstraints.WEST;
        panel.add(textFieldBirth, textFieldBirthConstraints);

        var inputHireLabel = new JLabel("Введите дату принятия на работу:");
        var inputHireLabelConstraints = new GridBagConstraints();
        inputHireLabelConstraints.gridx = 0;
        inputHireLabelConstraints.gridy = 6;
        inputHireLabelConstraints.anchor = GridBagConstraints.WEST;
        inputHireLabelConstraints.insets = new Insets(0,0,8,0);
        panel.add(inputHireLabel, inputHireLabelConstraints);

        textFieldHire = new JTextField(20);
        var textFieldHireConstraints = new GridBagConstraints();
        textFieldHireConstraints.gridx = 0;
        textFieldHireConstraints.gridy = 7;
        textFieldHireConstraints.anchor = GridBagConstraints.WEST;
        panel.add(textFieldHire, textFieldHireConstraints);

        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                String phone;
                String birth;
                String hire;
                String nameText = textFieldName.getText();
                if (!nameText.equals("")) {
                    name = nameText;
                    phone = textFieldPhone.getText();
                    String birthText = textFieldBirth.getText();
                    if (!birthText.equals("")) {
                        birth = birthText;
                        String hireText = textFieldHire.getText();
                        if (!hireText.equals("")) {
                            hire = hireText;
                            DialogAddWorker.this.dispose();
                            workerData = new WorkerData(name, phone, birth, hire);
                        }
                    }
                }
            }
        });
    }

    @Override
    void setOkayButtonCoordinates(GridBagConstraints okayButtonConstraints) {
        okayButtonConstraints.gridx = 1;
        okayButtonConstraints.gridy = 7;
    }

    @Override
    int getDialogHeight() {
        return 210;
    }

    public WorkerData getWorkerData() {
        return workerData;
    }
}
