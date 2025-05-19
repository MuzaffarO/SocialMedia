package epam.socialmedia.controller;
import epam.socialmedia.model.Post;
import epam.socialmedia.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService service;
    public PostController(PostService s) { this.service = s; }

    @PostMapping
    public Post create(@RequestParam Long userId, @RequestParam String title, @RequestParam String body) {
        return service.createPost(userId, title, body);
    }

    @GetMapping("/feed/{userId}")
    public List<Post> feed(@PathVariable Long userId) {
        return service.getFeed(userId);
    }

    @PostMapping("/{postId}/like")
    public void like(@PathVariable Long postId, @RequestParam Long userId) {
        service.likePost(postId, userId);
    }
}