package pl.put.cms.server.services.cms;

import pl.put.cms.server.entities.cms.dtos.SliderImageDto;

import java.util.List;

public interface SliderImageService {

    List<SliderImageDto> getSliderImages(int cmsId);

}
