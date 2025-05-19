package epam.socialmedia.controller;

import epam.socialmedia.model.User;
import epam.socialmedia.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;
    public UserController(UserService s) { this.service = s; }

    @PostMapping
    public User create(@RequestParam String username) {
        return service.createUser(username);
    }

    @PostMapping("/{id}/follow/{targetId}")
    public void follow(@PathVariable Long id, @PathVariable Long targetId) {
        service.follow(id, targetId);
    }
}