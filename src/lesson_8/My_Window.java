package lesson_8;

import javax.swing.*;
import java.awt.*;


public class My_Window extends JFrame {
    public My_Window() {
        setTitle("Калькулятор");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        JTextField jtf = new JTextField();
        jtf.setEditable(false);
        Color color = new Color(0xA6C63B17, true);
        add(jtf, BorderLayout.PAGE_START);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        char[] chars = {'7', '8', '9', '/', '4', '5', '6', '*', '1', '2', '3', '-', '0', '.', '=', '+'};
        for (int i = 0; i < chars.length; i++) {
            JButton button = new JButton(String.valueOf(chars[i]));
            button.setBackground(Color.LIGHT_GRAY);
            button.addActionListener(new ButtonListener(jtf));
            panel.add(button);
        }
        add(panel, BorderLayout.CENTER);
        JButton button_c = new JButton("C");
        button_c.setBackground(color);
        add(button_c, BorderLayout.PAGE_END);
        setVisible(true);
    }
}
