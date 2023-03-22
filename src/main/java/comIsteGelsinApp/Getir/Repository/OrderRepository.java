package comIsteGelsinApp.Getir.Repository;

import comIsteGelsinApp.Getir.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
