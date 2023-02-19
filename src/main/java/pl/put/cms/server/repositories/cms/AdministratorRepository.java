package pl.put.cms.server.repositories.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.cms.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
}
