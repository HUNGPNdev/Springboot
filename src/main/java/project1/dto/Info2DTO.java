package project1.dto;


import java.util.Arrays;

public class Info2DTO {
    private int id;
    private String patient;
    private String disease_id;
    private String date_in;
    private String date_out;
    private String drog_id;
    private double total_fee;
    private String doctor;
    private String nurse;

    public Info2DTO() {
    }

    public Info2DTO(int id, String patient, String disease_id, String date_in, String date_out, String drog_id, double total_fee, String doctor, String nurse) {
        this.id = id;
        this.patient = patient;
        this.disease_id = disease_id;
        this.date_in = date_in;
        this.date_out = date_out;
        this.drog_id = drog_id;
        this.total_fee = total_fee;
        this.doctor = doctor;
        this.nurse = nurse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Info2DTO(String patient, String disease_id, String date_in, String date_out, String drog_id, double total_fee, String doctor, String nurse) {
        this.patient = patient;
        this.disease_id = disease_id;
        this.date_in = date_in;
        this.date_out = date_out;
        this.drog_id = drog_id;
        this.total_fee = total_fee;
        this.doctor = doctor;
        this.nurse = nurse;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDisease_id() {
        return disease_id;
    }

    public void setDisease_id(String disease_id) {
        this.disease_id = disease_id;
    }

    public String getDate_in() {
        return date_in;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }

    public String getDate_out() {
        return date_out;
    }

    public void setDate_out(String date_out) {
        this.date_out = date_out;
    }

    public String getDrog_id() {
        return drog_id;
    }

    public void setDrog_id(String drog_id) {
        this.drog_id = drog_id;
    }

    public double getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(double total_fee) {
        this.total_fee = total_fee;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    @Override
    public String toString() {
        return "Info2DTO{" +
                "id=" + id +
                ", patient='" + patient + '\'' +
                ", disease_id='" + disease_id + '\'' +
                ", date_in='" + date_in + '\'' +
                ", date_out='" + date_out + '\'' +
                ", drog_id='" + drog_id + '\'' +
                ", total_fee=" + total_fee +
                ", doctor='" + doctor + '\'' +
                ", nurse='" + nurse + '\'' +
                '}';
    }
}
