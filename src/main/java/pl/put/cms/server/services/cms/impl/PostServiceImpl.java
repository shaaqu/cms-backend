package pl.put.cms.server.services.cms.impl;

import org.modelmapper.ModelMapper;
import pl.put.cms.server.entities.cms.Post;
import pl.put.cms.server.entities.cms.dtos.PostDto;
import pl.put.cms.server.repositories.cms.PostRepository;
import pl.put.cms.server.services.cms.PostService;

import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<PostDto> getAllPosts(int cmsId) {
        return postRepository.findAllByCms_Id(cmsId)
                .stream().map(this::mapPostToDto)
                .collect(Collectors.toList());
    }

    private PostDto mapPostToDto(Post post) {
        return modelMapper.map(post, PostDto.class);
    }
}
