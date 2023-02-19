package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.restaurant.ContactAddress;

public interface ContactAddressRepository extends JpaRepository<ContactAddress, Integer> {
}
