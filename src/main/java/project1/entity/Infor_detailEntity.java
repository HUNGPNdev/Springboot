package project1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "infor_details")
public class Infor_detailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int i_id;

    @ManyToOne
    @JoinColumn(name = "p_id")
    private PatientEntity patient_id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "dise_info",
            joinColumns = @JoinColumn(name = "i_id"),
            inverseJoinColumns = @JoinColumn(name = "d_id"))
    private List<DiseaseEntity> disease_id;


    private String date_in;
    private String date_out;


    @ManyToMany
    @JoinTable( name = "drog_detail",
            joinColumns = @JoinColumn(name = "i_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<DrogEntity> drog_id;

    private double total_fee;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "d_id")
    private DoctorEntity doctor;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "n_id")
    private NurseEntity nurse;

    public Infor_detailEntity() {
    }

    public Infor_detailEntity(PatientEntity patient_id, List<DiseaseEntity> disease_id, String date_in,
             String date_out, List<DrogEntity> drog_id, double total_fee, DoctorEntity doctor, NurseEntity nurse) {
        this.patient_id = patient_id;
        this.disease_id = disease_id;
        this.date_in = date_in;
        this.date_out = date_out;
        this.drog_id = drog_id;
        this.total_fee = total_fee;
        this.doctor = doctor;
        this.nurse = nurse;
    }

    public Infor_detailEntity(int id, PatientEntity patient_id, List<DiseaseEntity> disease_id,
                              String date_in, String date_out, List<DrogEntity> drog_id, double total_fee,
                              DoctorEntity doctor, NurseEntity nurse) {
        this.i_id = id;
        this.patient_id = patient_id;
        this.disease_id = disease_id;
        this.date_in = date_in;
        this.date_out = date_out;
        this.drog_id = drog_id;
        this.total_fee = total_fee;
        this.doctor = doctor;
        this.nurse = nurse;
    }

    @Override
    public String toString() {
        return "Infor_detailEntity{" +
                "i_id=" + i_id +
                ", patient_id=" + patient_id +
                ", disease_id=" + disease_id +
                ", date_in='" + date_in + '\'' +
                ", date_out='" + date_out + '\'' +
                ", drog_id=" + drog_id +
                ", total_fee=" + total_fee +
                ", doctor=" + doctor +
                ", nurse=" + nurse +
                '}';
    }

    public int getId() {
        return i_id;
    }

    public void setId(int id) {
        this.i_id = id;
    }

    public PatientEntity getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(PatientEntity patient_id) {
        this.patient_id = patient_id;
    }

    public List<DiseaseEntity> getDisease_id() {
        return disease_id;
    }

    public void setDisease_id(List<DiseaseEntity> disease_id) {
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

    public List<DrogEntity> getDrog_id() {
        return drog_id;
    }

    public void setDrog_id(List<DrogEntity> drog_id) {
        this.drog_id = drog_id;
    }

    public double getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(double total_fee) {
        this.total_fee = total_fee;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public NurseEntity getNurse() {
        return nurse;
    }

    public void setNurse(NurseEntity nurse) {
        this.nurse = nurse;
    }
}
