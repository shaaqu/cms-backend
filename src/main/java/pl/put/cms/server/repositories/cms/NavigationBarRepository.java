package pl.put.cms.server.repositories.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.cms.server.entities.cms.NavigationBar;

import java.util.Optional;

@Repository
public interface NavigationBarRepository extends JpaRepository<NavigationBar, Integer> {

    Optional<NavigationBar> findByCms_Id(int cmsId);

}
