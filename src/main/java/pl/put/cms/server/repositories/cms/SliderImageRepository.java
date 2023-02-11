package pl.put.cms.server.repositories.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.cms.SliderImage;

import java.util.List;

public interface SliderImageRepository extends JpaRepository<SliderImage, Integer> {

    List<SliderImage> findAllByCms_id(int cmsId);

}
