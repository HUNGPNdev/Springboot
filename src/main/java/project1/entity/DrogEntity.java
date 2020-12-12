package project1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "drog")
public class DrogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;

    @ManyToMany(mappedBy = "drog_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Infor_detailEntity> drog_detail;

    public DrogEntity() {
    }

    public DrogEntity(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public DrogEntity(int id, String name, double price, List<Infor_detailEntity> drog_detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.drog_detail = drog_detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
