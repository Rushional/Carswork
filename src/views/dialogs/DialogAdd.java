package views.dialogs;

import javax.swing.*;

abstract class DialogAdd extends Dialog {
    DialogAdd(JFrame frame) {
        super(frame);
    }

    @Override
    int getDialogWidth() {
        return 380;
    }
}
