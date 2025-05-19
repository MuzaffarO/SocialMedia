package epam.socialmedia.repository;

import epam.socialmedia.model.Post;
import epam.socialmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthorIn(List<User> authors);
}
