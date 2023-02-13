package pl.put.cms.server.services.cms.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.cms.server.entities.cms.NavigationBarButton;
import pl.put.cms.server.entities.cms.dtos.NavigationBarButtonDto;
import pl.put.cms.server.entities.cms.dtos.NavigationBarDto;
import pl.put.cms.server.repositories.cms.NavigationBarButtonRepository;
import pl.put.cms.server.repositories.cms.NavigationBarRepository;
import pl.put.cms.server.services.cms.NavigationBarService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NavigationBarServiceImpl implements NavigationBarService {

    private final NavigationBarButtonRepository navigationBarButtonRepository;
    private final NavigationBarRepository navigationBarRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public NavigationBarServiceImpl(NavigationBarButtonRepository navigationBarButtonRepository, NavigationBarRepository navigationBarRepository) {
        this.navigationBarButtonRepository = navigationBarButtonRepository;
        this.navigationBarRepository = navigationBarRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public NavigationBarDto getNavigationBar(int cmsId) {
        NavigationBarDto navigationBarDto =
                modelMapper.map(navigationBarRepository.findByCms_Id(cmsId).get(), NavigationBarDto.class);

        return navigationBarDto;

//        return navigationBarButtonRepository.findAllByCms_Id(cmsId)
//                .stream().map(this::mapNavigationBarButtonsToDto)
//                .collect(Collectors.toList());
    }

    private NavigationBarButtonDto mapNavigationBarButtonsToDto(NavigationBarButton btn) {
        return modelMapper.map(btn, NavigationBarButtonDto.class);
    }
}
