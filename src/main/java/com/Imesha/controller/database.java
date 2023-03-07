package com.Imesha.controller;

import com.Imesha.Student;

import java.sql.*;

public class database {
    private Connection connection;

    public database() throws ClassNotFoundException, SQLException {
        //registration of drive class
        Class.forName("com.mysql.cj.jdbc.Driver");
        //db connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid-vaccination-status","root","");
    }
    public boolean insertNewStudent(Student student) throws SQLException {
        String query = "INSERT INTO `student` (`Name`,`Student-No`,`Address`,`Vaccination-status`) VALUES (?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, student.getName());
        statement.setString(2, student.getId());
        statement.setString(3, student.getAddress());
        statement.setInt(4, student.getVaccinationStatus());
        return statement.execute();
    }

    public  ResultSet getStudentDetails(String id) throws SQLException {
        String query = "SELECT * FROM student WHERE `Student-No`=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,id);
        ResultSet resultSet = statement.executeQuery();
        return statement.executeQuery();
    }

    public int getNoneVaccinatedCount() throws SQLException {
        String query = "SELECT COUNT(`Student-NO`) AS COUNT FROM student WHERE `Vaccination-status`=0;";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            return resultSet.getInt("count");
        }
        return 0;
    }

    public int getSignalVaccinatedCount() throws SQLException {
        String query = "SELECT COUNT(`Student-NO`) AS COUNT FROM student WHERE `Vaccination-status`=1;";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            return resultSet.getInt("count");
        }
        return 0;
    }

    public int getDualVaccinatedCount() throws SQLException{
        String query = "SELECT COUNT(`Student-NO`) AS COUNT FROM student WHERE `Vaccination-status`=2;";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            return resultSet.getInt("count");
        }
        return 0;
    }

    public int getBoosterVaccinatedCount() throws SQLException{
        String query = "SELECT COUNT(`Student-NO`) AS COUNT FROM student WHERE `Vaccination-status`=3;";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            return resultSet.getInt("count");
        }
        return 0;
    }


}
