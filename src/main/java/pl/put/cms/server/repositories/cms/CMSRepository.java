package pl.put.cms.server.repositories.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.cms.server.entities.cms.CMS;

@Repository
public interface CMSRepository extends JpaRepository<CMS, Integer> {
}
