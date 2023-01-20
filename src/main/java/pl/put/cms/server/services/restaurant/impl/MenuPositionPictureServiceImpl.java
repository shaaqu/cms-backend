package pl.put.cms.server.services.restaurant.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.cms.server.entities.restaurant.MenuPosition;
import pl.put.cms.server.entities.restaurant.MenuPositionPicture;
import pl.put.cms.server.entities.restaurant.dtos.MenuPositionDto;
import pl.put.cms.server.entities.restaurant.dtos.MenuPositionPictureDto;
import pl.put.cms.server.repositories.restaurant.MenuPositionPicturesRepository;
import pl.put.cms.server.services.restaurant.MenuPositionPictureService;

@Service
public class MenuPositionPictureServiceImpl implements MenuPositionPictureService {

    private final MenuPositionPicturesRepository menuPositionPicturesRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MenuPositionPictureServiceImpl(MenuPositionPicturesRepository menuPositionPicturesRepository) {
        this.menuPositionPicturesRepository = menuPositionPicturesRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public MenuPositionPictureDto getPicture(int menuPositionId) {
        return mapMenuPositionToDto(menuPositionPicturesRepository.getMenuPositionPictureByMenuPosition_Id(menuPositionId));
    }

    private MenuPositionPictureDto mapMenuPositionToDto(MenuPositionPicture menuPositionPicture) {
        return modelMapper.map(menuPositionPicture, MenuPositionPictureDto.class);
    }
}
