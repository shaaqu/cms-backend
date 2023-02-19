package pl.put.cms.server.repositories.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.cms.CMS;

public interface CMSRepository extends JpaRepository<CMS, Integer> {
}
