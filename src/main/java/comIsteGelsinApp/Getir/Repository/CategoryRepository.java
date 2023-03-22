package comIsteGelsinApp.Getir.Repository;

import comIsteGelsinApp.Getir.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
