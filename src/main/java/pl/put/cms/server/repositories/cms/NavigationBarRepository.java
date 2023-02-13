package pl.put.cms.server.repositories.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.cms.NavigationBar;

import java.util.Optional;

public interface NavigationBarRepository extends JpaRepository<NavigationBar, Integer> {

    Optional<NavigationBar> findByCms_Id(int cmsId);

}
