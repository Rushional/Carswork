package interface_interaction;

import javax.swing.*;
import java.awt.*;

public class CarWorksComboBox extends JComboBox {
    //TO DO change constructor so that it gets ints instead of strings and then converts them into strings
    public CarWorksComboBox(String[] carIds) {
        super(carIds);
        setPreferredSize(new Dimension(200, 30));
    }
}
