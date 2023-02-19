package pl.put.cms.server.repositories.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.put.cms.server.entities.cms.Post;

import java.util.List;

@Repository @Transactional
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByCms_Id(int cmsId);

}
