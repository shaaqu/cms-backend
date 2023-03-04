package pl.put.cms.server.controlles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.cms.server.entities.cms.dtos.NavigationBarButtonDto;
import pl.put.cms.server.entities.cms.dtos.NavigationBarDto;
import pl.put.cms.server.entities.cms.dtos.PostDto;
import pl.put.cms.server.services.cms.NavigationBarService;
import pl.put.cms.server.services.cms.PostService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cms") @Slf4j
public class CMSController {

    private final NavigationBarService navigationBarService;
    private final PostService postService;

    @Autowired
    public CMSController(NavigationBarService navigationBarService, PostService postService) {
        this.navigationBarService = navigationBarService;
        this.postService = postService;
    }

    @GetMapping("/{cmsId}/navi-bar")
    NavigationBarDto getNaviBar(@PathVariable int cmsId) {
        log.info("getting navi bar");
        return navigationBarService.getNavigationBar(cmsId);
    }

    @GetMapping("/{cmsId}/posts")
    List<PostDto> getPosts(@PathVariable int cmsId) {
        log.info("getting posts");
        return postService.getAllPosts(cmsId);
    }

    @PostMapping("/post")
    ResponseEntity<Integer> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @PutMapping("/post")
    ResponseEntity<Integer> editPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.editPost(postDto), HttpStatus.OK);
    }

    @DeleteMapping("/post/{id}")
    ResponseEntity<Integer> deletePost(@PathVariable int id) {
        return new ResponseEntity<>(postService.deletePost(id), HttpStatus.OK);
    }
}
