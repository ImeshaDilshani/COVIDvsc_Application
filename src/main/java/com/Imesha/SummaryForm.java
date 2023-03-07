package com.Imesha;

import com.Imesha.controller.database;

import javax.swing.*;
import java.sql.*;

public class SummaryForm {
    private JPanel SummaryRoot;
    private JLabel singalLabel;
    private JLabel duelLabel;
    private JLabel boosterLable;
    private JLabel noneLabel;

    public SummaryForm() {
        getSummary();
    }


    public static void run() {
        JFrame frame = new JFrame("Summary");
        frame.setContentPane(new SummaryForm().SummaryRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void getSummary(){
        try {
            int nonevaccCount = new database().getNoneVaccinatedCount();
            int singalvaccCount = new database().getSignalVaccinatedCount();
            int dualvaccCount = new database().getDualVaccinatedCount();
            int boostervaccCount = new database().getBoosterVaccinatedCount();
            noneLabel.setText(String.valueOf(nonevaccCount));
            singalLabel.setText(String.valueOf(nonevaccCount));
            duelLabel.setText(String.valueOf(nonevaccCount));
            boosterLable.setText(String.valueOf(nonevaccCount));
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}


