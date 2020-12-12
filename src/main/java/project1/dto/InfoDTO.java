package project1.dto;


import java.util.Arrays;

public class InfoDTO {
    private int patient_id;
    private int[] disease_id;
    private String date_in;
    private String date_out;
    private int[] drog_id;
    private double total_fee;
    private Long doctor_id;
    private Long nurse_id;

    public InfoDTO() {
    }

    public InfoDTO(int patient_id, int[] disease_id, String date_in, String date_out, int[] drog_id, double total_fee, Long doctor_id, Long nurse_id) {
        this.patient_id = patient_id;
        this.disease_id = disease_id;
        this.date_in = date_in;
        this.date_out = date_out;
        this.drog_id = drog_id;
        this.total_fee = total_fee;
        this.doctor_id = doctor_id;
        this.nurse_id = nurse_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int[] getDisease_id() {
        return disease_id;
    }

    public void setDisease_id(int[] disease_id) {
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

    public int[] getDrog_id() {
        return drog_id;
    }

    public void setDrog_id(int[] drog_id) {
        this.drog_id = drog_id;
    }

    public double getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(double total_fee) {
        this.total_fee = total_fee;
    }

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Long getNurse_id() {
        return nurse_id;
    }

    public void setNurse_id(Long nurse_id) {
        this.nurse_id = nurse_id;
    }

    @Override
    public String toString() {
        return "InfoDTO{" +
                "patient_id=" + patient_id +
                ", disease_id=" + Arrays.toString(disease_id) +
                ", date_in='" + date_in + '\'' +
                ", date_out='" + date_out + '\'' +
                ", drog_id=" + Arrays.toString(drog_id) +
                ", total_fee=" + total_fee +
                ", doctor_id=" + doctor_id +
                ", nurse_id=" + nurse_id +
                '}';
    }
}
