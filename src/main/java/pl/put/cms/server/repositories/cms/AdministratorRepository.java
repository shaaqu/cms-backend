package pl.put.cms.server.repositories.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.cms.server.entities.cms.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
}
