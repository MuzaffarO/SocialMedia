package epam.socialmedia;

import epam.socialmedia.model.Post;
import epam.socialmedia.model.User;
import epam.socialmedia.repository.PostRepository;
import epam.socialmedia.repository.UserRepository;
import epam.socialmedia.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PostServiceTest {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private PostService postService;

    @BeforeEach
    public void setup() {
        postRepository = mock(PostRepository.class);
        userRepository = mock(UserRepository.class);
        postService = new PostService(postRepository, userRepository);
    }

    @Test
    public void testCreatePost() {
        User user = new User();
        user.setId(1L);
        user.setUsername("alice");

        Post post = new Post();
        post.setTitle("Title");
        post.setBody("Body");
        post.setAuthor(user);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(postRepository.save(any(Post.class))).thenReturn(post);

        Post created = postService.createPost(1L, "Title", "Body");
        assertEquals("Title", created.getTitle());
    }

    @Test
    public void testLikePost() {
        User user = new User();
        user.setId(1L);
        user.setUsername("alice");

        Post post = new Post();
        post.setId(1L);
        post.setTitle("Hello");
        post.setLikedBy(new HashSet<>());

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(postRepository.save(any(Post.class))).thenReturn(post);

        postService.likePost(1L, 1L);
        assertTrue(post.getLikedBy().contains(user));
    }

    @Test
    public void testGetFeed() {
        User alice = new User();
        alice.setId(1L);
        alice.setUsername("alice");

        User bob = new User();
        bob.setId(2L);
        bob.setUsername("bob");

        Post post = new Post();
        post.setAuthor(bob);

        alice.setFollowing(Set.of(bob));
        when(userRepository.findById(1L)).thenReturn(Optional.of(alice));
        when(postRepository.findByAuthorIn(any())).thenReturn(List.of(post));

        List<Post> feed = postService.getFeed(1L);
        assertEquals(1, feed.size());
        assertEquals(bob, feed.get(0).getAuthor());
    }
}