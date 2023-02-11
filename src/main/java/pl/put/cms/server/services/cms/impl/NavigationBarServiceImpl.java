package pl.put.cms.server.services.cms.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.put.cms.server.entities.cms.NavigationBarButton;
import pl.put.cms.server.entities.cms.dtos.NavigationBarButtonDto;
import pl.put.cms.server.repositories.cms.NavigationBarButtonRepository;
import pl.put.cms.server.services.cms.NavigationBarService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NavigationBarServiceImpl implements NavigationBarService {

    private final NavigationBarButtonRepository navigationBarButtonRepository;
    private final ModelMapper modelMapper;

    public NavigationBarServiceImpl(NavigationBarButtonRepository navigationBarButtonRepository) {
        this.navigationBarButtonRepository = navigationBarButtonRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<NavigationBarButtonDto> getNavigationBarButtons(int cmsId) {
        return navigationBarButtonRepository.findAllByCms_Id(cmsId)
                .stream().map(this::mapNavigationBarButtonsToDto)
                .collect(Collectors.toList());
    }

    private NavigationBarButtonDto mapNavigationBarButtonsToDto(NavigationBarButton btn) {
        return modelMapper.map(btn, NavigationBarButtonDto.class);
    }
}
