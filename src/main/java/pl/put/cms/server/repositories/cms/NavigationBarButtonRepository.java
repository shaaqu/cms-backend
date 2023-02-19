package pl.put.cms.server.repositories.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.cms.server.entities.cms.NavigationBarButton;

import java.util.List;

@Repository
public interface NavigationBarButtonRepository extends JpaRepository<NavigationBarButton, Integer> {

}
