package pl.put.cms.server.repositories.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.cms.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByCms_Id(int cmsId);

}
