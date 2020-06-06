package lesson_8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private JTextField jtf;

    public ButtonListener(JTextField jtf) {
        this.jtf = jtf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        jtf.setText(button.getText());
    }
}
