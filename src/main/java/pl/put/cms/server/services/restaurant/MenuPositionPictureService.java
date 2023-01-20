package pl.put.cms.server.services.restaurant;

import pl.put.cms.server.entities.restaurant.dtos.MenuPositionPictureDto;

public interface MenuPositionPictureService {

    public MenuPositionPictureDto getPicture(int menuPositionId);

}
