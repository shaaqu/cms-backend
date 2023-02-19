package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.cms.server.entities.restaurant.ContactAddress;

@Repository
public interface ContactAddressRepository extends JpaRepository<ContactAddress, Integer> {
}
