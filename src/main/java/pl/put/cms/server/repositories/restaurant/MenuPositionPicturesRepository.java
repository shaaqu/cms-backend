package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.restaurant.MenuPositionPicture;

public interface MenuPositionPicturesRepository extends JpaRepository<MenuPositionPicture, Integer> {

    public MenuPositionPicture getMenuPositionPictureByMenuPosition_Id(int id);

}
