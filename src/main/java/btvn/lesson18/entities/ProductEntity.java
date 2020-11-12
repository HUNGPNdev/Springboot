package btvn.lesson18.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(name = "productName")
    private String productName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_corler", joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "colorId"))
    private List<ColorEntity> colorEntity;

    @Column(name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brandId")
    private BrandEntity brandEntity;

    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order_details> order_details;

    public ProductEntity() {
    }

    public ProductEntity(String productName, double price, BrandEntity brandEntity) {
        this.productName = productName;
        this.price = price;
        this.brandEntity = brandEntity;
    }

    public ProductEntity(String productName, List<ColorEntity> colorEntity, double price,
                         BrandEntity brandEntity) {
        this.productName = productName;
        this.colorEntity = colorEntity;
        this.price = price;
        this.brandEntity = brandEntity;
    }

    public List<ColorEntity> getColorEntity() {
        return colorEntity;
    }

    public void setColorEntity(List<ColorEntity> colorEntity) {
        this.colorEntity = colorEntity;
    }

    public List<Order_details> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(List<Order_details> order_details) {
        this.order_details = order_details;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BrandEntity getBrandId() {
        return brandEntity;
    }

    public void setBrandId(BrandEntity brandId) {
        this.brandEntity = brandId;
    }
}
