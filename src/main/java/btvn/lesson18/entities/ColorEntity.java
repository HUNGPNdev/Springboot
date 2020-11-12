package btvn.lesson18.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "color")
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long colorId;

    @Column
    private String colorName;


    @ManyToMany(mappedBy = "colorEntity")
    private List<ProductEntity> product;

    public ColorEntity() {
    }

    public ColorEntity(long colorId, String colorName, ProductEntity product) {
        this.colorId = colorId;
        this.colorName = colorName;
    }

    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }

    public long getColorId() {
        return colorId;
    }

    public void setColorId(long colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
