package com.Imesha;

import com.Imesha.controller.database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SearchForm {
    private JPanel StudentRoot;
    private JTextField idTextBox;
    private JButton searchButton;
    private JLabel nameLable;
    private JLabel studentNoLable;
    private JLabel adreessLable;
    private JLabel vaccinationLable;

    public final String[] vacText = {"None","Signal Vaccinated","Dual Vaccinated","Booster"};

    public SearchForm() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = idTextBox.getText();

                try {
                    // database connect
                    ResultSet resultSet = new database().getStudentDetails(id);

                    int vac = -1;
                    while (resultSet.next()){
                        nameLable.setText(resultSet.getString("Name"));
                        studentNoLable.setText(resultSet.getString("Student-No"));
                        adreessLable.setText(resultSet.getString("Address"));
                        vac = resultSet.getInt("Vaccination-status");
                    }
                    vaccinationLable.setText((vac<0 && vac>3)?"N/A":vacText[vac]);

                    //JOptionPane.showMessageDialog(null, "Success");

                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void run() {
        JFrame frame = new JFrame("Search");
        frame.setContentPane(new SearchForm().StudentRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
