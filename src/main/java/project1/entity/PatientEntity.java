package project1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int p_id;
    private String name;
    private String cmnd;
    private String address;
    private String phone;
    private int age;
    @OneToMany(mappedBy = "patient_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Infor_detailEntity> infor_detail;


    public PatientEntity() {
    }

    public PatientEntity(int p_id, String name, String cmnd, String address, String phone, int age) {
        this.p_id = p_id;
        this.name = name;
        this.cmnd = cmnd;
        this.address = address;
        this.phone = phone;
        this.age = age;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Infor_detailEntity> getInfor_detail() {
        return infor_detail;
    }

    public void setInfor_detail(List<Infor_detailEntity> infor_detail) {
        this.infor_detail = infor_detail;
    }
}
