package pl.put.cms.server.repositories.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.cms.NavigationBarButton;

import java.util.List;

public interface NavigationBarButtonRepository extends JpaRepository<NavigationBarButton, Integer> {

    List<NavigationBarButton> findAllByCms_Id(int cmsId);

}
