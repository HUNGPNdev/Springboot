package btvn.lesson18.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int brandId;

    @Column(name = "brandName")
    private String brandName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "brandEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductEntity> product;

    public BrandEntity() {
    }

    public BrandEntity(int brandId, String brandName, String description) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.description = description;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }
}
