package pl.put.cms.server.services.cms.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.put.cms.server.entities.cms.Post;
import pl.put.cms.server.entities.cms.dtos.CreatePostDto;
import pl.put.cms.server.entities.cms.dtos.PostDto;
import pl.put.cms.server.repositories.cms.PostRepository;
import pl.put.cms.server.services.cms.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Service
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

    public int createPost(CreatePostDto postDto) {
        return postRepository.save(modelMapper.map(postDto, Post.class)).getId();
    }

    public int editPost(PostDto postDto) {
        return postRepository.save(modelMapper.map(postDto, Post.class)).getId();
    }

    @Override
    public int deletePost(int postId) {
        return 0;
    }

    private PostDto mapPostToDto(Post post) {
        return modelMapper.map(post, PostDto.class);
    }
}
