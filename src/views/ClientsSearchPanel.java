package views;

import graphics.ListTuplesToTable;
import org.hibernate.Session;
import queries.GetQueryData;
import queries.QueryController;
import queries.TableData;

import javax.swing.*;
import java.awt.*;

public class ClientsSearchPanel extends JPanel {
    public ClientsSearchPanel(Session session) {
        setBackground(new Color(235, 240, 255));
        setPreferredSize(new Dimension(500, 120));
        setLayout(new GridBagLayout());
//        QueryController queryController = new QueryController(session);
//        TableData servicesTableData = queryController.getTableData(GetQueryData.selectClientPhoneByName());
//        JTable servicesTable = ListTuplesToTable.call(servicesTableData);

        JLabel inputClientsName = new JLabel("Пожалуйста, введите ФИО клиента:");
        GridBagConstraints inputClientsNameConstraints = new GridBagConstraints();
        inputClientsNameConstraints.weightx = 1;
        inputClientsNameConstraints.weighty = 1;
        inputClientsNameConstraints.gridx = 0;
        inputClientsNameConstraints.gridy = 0;
        inputClientsNameConstraints.anchor = GridBagConstraints.PAGE_START;
        inputClientsNameConstraints.insets = new Insets(10, 0, 0, 0);
//        inputClientsNameConstraints.gridwidth = 3;
        add(inputClientsName, inputClientsNameConstraints);

        JTextField nameTextField = new JTextField(" Бычков Анатолий Семёнович          ");
        GridBagConstraints nameTextFieldConstraints = new GridBagConstraints();
        nameTextFieldConstraints.weightx = 1;
        nameTextFieldConstraints.weighty = 1;
        nameTextFieldConstraints.gridx = 1;
        nameTextFieldConstraints.gridy = 0;
        nameTextFieldConstraints.anchor = GridBagConstraints.PAGE_START;
        nameTextFieldConstraints.insets = new Insets(10, 0, 0, 0);
//        nameTextFieldConstraints.gridwidth = 3;
        add(nameTextField, nameTextFieldConstraints);

        JButton getPhoneButton = new JButton("Получить телефон");
        GridBagConstraints getPhoneButtonConstraints = new GridBagConstraints();
        getPhoneButtonConstraints.weightx = 1;
        getPhoneButtonConstraints.weighty = 1;
        getPhoneButtonConstraints.gridx = 0;
        getPhoneButtonConstraints.gridy = 1;
//        getPhoneButtonConstraints.insets = new Insets(10, 0, 0, 0);
//        getPhoneButtonConstraints.gridwidth = 3;
        add(getPhoneButton, getPhoneButtonConstraints);

        JLabel outputPhoneLabel = new JLabel("Телефон клиента: +79818907264");
        GridBagConstraints outputPhoneLabelConstraints = new GridBagConstraints();
        outputPhoneLabelConstraints.weightx = 1;
        outputPhoneLabelConstraints.weighty = 1;
        outputPhoneLabelConstraints.gridx = 1;
        outputPhoneLabelConstraints.gridy = 1;
//        outputPhoneLabelConstraints.anchor = GridBagConstraints.PAGE_START;
//        outputPhoneLabelConstraints.insets = new Insets(10, 0, 0, 0);
//        outputPhoneLabelConstraints.gridwidth = 3;
        add(outputPhoneLabel, outputPhoneLabelConstraints);
    }
}
