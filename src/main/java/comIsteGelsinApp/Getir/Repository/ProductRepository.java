package comIsteGelsinApp.Getir.Repository;

import comIsteGelsinApp.Getir.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "Select * from product WHERE unit_price < :price",nativeQuery = true)
    List<Product> getProductWithMinimumPrice(double price);
}
