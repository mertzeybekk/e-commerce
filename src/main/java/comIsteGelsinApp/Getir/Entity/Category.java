package comIsteGelsinApp.Getir.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "category_name")
    private String categoryName;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> product;


    public Category(int id, String categoryName, List<Product> product) {
        this.id = id;
        this.categoryName = categoryName;
        this.product = product;
    }
    public Category(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
        for(Product p:product){
            p.setCategory(this);
        }
    }
}
