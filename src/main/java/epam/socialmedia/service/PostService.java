package epam.socialmedia.service;

import epam.socialmedia.model.Post;
import epam.socialmedia.model.User;
import epam.socialmedia.repository.PostRepository;
import epam.socialmedia.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public PostService(PostRepository p, UserRepository u) {
        this.postRepo = p;
        this.userRepo = u;
    }

    public Post createPost(Long userId, String title, String body) {
        User user = userRepo.findById(userId).orElseThrow();
        Post post = new Post();
        post.setAuthor(user);
        post.setTitle(title);
        post.setBody(body);
        return postRepo.save(post);
    }

    public List<Post> getFeed(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        List<User> followed = new ArrayList<>(user.getFollowing());
        return postRepo.findByAuthorIn(followed);
    }

    public void likePost(Long postId, Long userId) {
        Post post = postRepo.findById(postId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();
        post.getLikedBy().add(user);
        postRepo.save(post);
    }
}