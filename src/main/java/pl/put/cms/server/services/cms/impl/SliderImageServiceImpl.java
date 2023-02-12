package pl.put.cms.server.services.cms.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.cms.server.entities.cms.SliderImage;
import pl.put.cms.server.entities.cms.dtos.SliderImageDto;
import pl.put.cms.server.repositories.cms.SliderImageRepository;
import pl.put.cms.server.services.cms.SliderImageService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SliderImageServiceImpl implements SliderImageService {

    private final SliderImageRepository sliderImageRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SliderImageServiceImpl(SliderImageRepository sliderImageRepository) {
        this.sliderImageRepository = sliderImageRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<SliderImageDto> getSliderImages(int cmsId) {
        return sliderImageRepository.findAllByCms_id(cmsId)
                .stream().map(this::mapSliderImageToDto)
                .collect(Collectors.toList());
    }

    private SliderImageDto mapSliderImageToDto(SliderImage sliderImage) {
        return modelMapper.map(sliderImage, SliderImageDto.class);
    }
}
