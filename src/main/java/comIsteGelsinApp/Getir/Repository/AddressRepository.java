package comIsteGelsinApp.Getir.Repository;

import comIsteGelsinApp.Getir.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
