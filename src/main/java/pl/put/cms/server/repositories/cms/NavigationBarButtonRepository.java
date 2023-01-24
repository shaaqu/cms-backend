package pl.put.cms.server.repositories.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.cms.NavigationBarButton;

public interface NavigationBarButtonRepository extends JpaRepository<NavigationBarButton, Integer> {
}
