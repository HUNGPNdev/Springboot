package project1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "disease")
public class DiseaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int d_id;
    private String name;
    private double price;

    @ManyToMany(mappedBy = "disease_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Infor_detailEntity> disInfo;

    public DiseaseEntity() {
    }

    public DiseaseEntity(int id, String name, double price) {
        this.d_id = id;
        this.name = name;
        this.price = price;
    }

    public DiseaseEntity(int d_id, String name, double price, List<Infor_detailEntity> disInfo) {
        this.d_id = d_id;
        this.name = name;
        this.price = price;
        this.disInfo = disInfo;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Infor_detailEntity> getDisInfo() {
        return disInfo;
    }

    public void setDisInfo(List<Infor_detailEntity> disInfo) {
        this.disInfo = disInfo;
    }
}
