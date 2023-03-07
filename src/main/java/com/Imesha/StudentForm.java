package com.Imesha;

import javax.swing.*;

public class Student {
    private JPanel SearchRoot;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JButton submitButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Search");
        frame.setContentPane(new Student().SearchRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
