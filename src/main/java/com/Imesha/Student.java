package com.Imesha;

public class Student {

    private String address;
    private String id;
    private String name;
    private int vaccinationStatus;

    public Student(String param1, String param2, String param3, int param4) {
        this.name = param1;
        this.id = param2;
        this.address = param3;
        this.vaccinationStatus = param4;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVaccinationStatus() {
        return vaccinationStatus;
    }

    public void setVaccinationStatus(int vaccinationStatus) {
        this.vaccinationStatus = vaccinationStatus;
    }
}
