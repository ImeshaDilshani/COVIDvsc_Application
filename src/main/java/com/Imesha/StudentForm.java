package com.Imesha;

import com.Imesha.controller.database;

import javax.naming.Name;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentForm {
    private JPanel SearchRoot;
    private JTextField nameTextBox;
    private JTextField studentNoTextBox;
    private JTextField addressTextBox;
    private JComboBox vaccinationComboBox;
    private JButton submitButton;

    public StudentForm() {

        //submit btn
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextBox.getText().trim();
                String studentNo = studentNoTextBox.getText();
                String address = addressTextBox.getText();
                int vaccinationStatus = vaccinationComboBox.getSelectedIndex();
                Student std = new Student(name, studentNo, address, vaccinationStatus);

                //JOptionPane.showMessageDialog(null,std.getName()+","+std.getId()+","+std.getAddress()+","+std.getVaccinationStatus());

                try {
                    //database connect
                    database db = new database();
                    db.insertNewStudent(std);

                    JOptionPane.showMessageDialog(null, "Success");

                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void run() {
        JFrame frame = new JFrame("Student Details");
        frame.setContentPane(new StudentForm().SearchRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
