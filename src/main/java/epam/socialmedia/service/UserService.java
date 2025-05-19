package epam.socialmedia.service;

import epam.socialmedia.model.User;
import epam.socialmedia.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepo;
    public UserService(UserRepository repo) { this.userRepo = repo; }

    public User createUser(String username) {
        User user = new User();
        user.setUsername(username);
        return userRepo.save(user);
    }

    public void follow(Long followerId, Long followeeId) {
        User follower = userRepo.findById(followerId).orElseThrow();
        User followee = userRepo.findById(followeeId).orElseThrow();
        follower.getFollowing().add(followee);
        userRepo.save(follower);
    }
}