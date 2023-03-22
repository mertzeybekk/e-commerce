package comIsteGelsinApp.Getir.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "unit_price")
    private double unitInPrice;


    @Column(name = "unit_stock")
    private int unitInStock;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<Order> order;
    public Product(int id, String productName, double unitInPrice, int unitInStock, Category category,List<Order>order) {
        this.id = id;
        this.productName = productName;
        this.unitInPrice = unitInPrice;
        this.unitInStock = unitInStock;
        this.category = category;
        this.order=order;
    }
public Product(){}

    public Product(String productName, double unitInPrice, int unitInStock) {
        this.productName = productName;
        this.unitInPrice = unitInPrice;
        this.unitInStock = unitInStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitInPrice() {
        return unitInPrice;
    }

    public void setUnitInPrice(double unitInPrice) {
        this.unitInPrice = unitInPrice;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
        for (Order orderName:order){
            orderName.setProduct(this);
        }
    }
}
