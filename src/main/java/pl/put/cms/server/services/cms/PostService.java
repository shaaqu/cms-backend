package pl.put.cms.server.services.cms;

import pl.put.cms.server.entities.cms.dtos.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> getAllPosts(int cmsId);

}
