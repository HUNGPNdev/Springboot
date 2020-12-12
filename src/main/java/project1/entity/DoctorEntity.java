package project1.entity;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long d_id;
    private String name;
    private String cmnd;
    private int age;
    private String address;
    private String rank_c;
    private int seniority;
    private String degree;
    private String phone;

    @Override
    public String toString() {
        return "DoctorEntity{" +
                "d_id=" + d_id +
                ", name='" + name + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", rank_c='" + rank_c + '\'' +
                ", seniority=" + seniority +
                ", degree='" + degree + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @OneToOne(mappedBy = "doctor")
    private Infor_detailEntity infoDoc;

    public DoctorEntity() {
    }

    public DoctorEntity(Long d_id, String name, String cmnd, int age, String address, String rank_c,
                        int seniority, String degree, String phone) {
        this.d_id = d_id;
        this.name = name;
        this.cmnd = cmnd;
        this.age = age;
        this.address = address;
        this.rank_c = rank_c;
        this.seniority = seniority;
        this.degree = degree;
        this.phone = phone;
    }

    public DoctorEntity(Long d_id, String name, String cmnd, int age, String address, String rank_c,
                        int seniority, String degree, String phone, Infor_detailEntity infoDoc) {
        this.d_id = d_id;
        this.name = name;
        this.cmnd = cmnd;
        this.age = age;
        this.address = address;
        this.rank_c = rank_c;
        this.seniority = seniority;
        this.degree = degree;
        this.phone = phone;
        this.infoDoc = infoDoc;
    }

    public Long getD_id() {
        return d_id;
    }

    public void setD_id(Long d_id) {
        this.d_id = d_id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRank_c() {
        return rank_c;
    }

    public void setRank_c(String rank_c) {
        this.rank_c = rank_c;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Infor_detailEntity getInfoDoc() {
        return infoDoc;
    }

    public void setInfoDoc(Infor_detailEntity infoDoc) {
        this.infoDoc = infoDoc;
    }
}
