package epam.socialmedia;

import epam.socialmedia.model.User;
import epam.socialmedia.repository.UserRepository;
import epam.socialmedia.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void setup() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("alice");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User created = userService.createUser("alice");
        assertEquals("alice", created.getUsername());
    }

    @Test
    public void testFollowUser() {
        User alice = new User();
        alice.setId(1L);
        alice.setUsername("alice");
        alice.setFollowing(new HashSet<>());

        User bob = new User();
        bob.setId(2L);
        bob.setUsername("bob");

        when(userRepository.findById(1L)).thenReturn(Optional.of(alice));
        when(userRepository.findById(2L)).thenReturn(Optional.of(bob));
        when(userRepository.save(any(User.class))).thenReturn(alice);

        userService.follow(1L, 2L);
        assertTrue(alice.getFollowing().contains(bob));
    }
}