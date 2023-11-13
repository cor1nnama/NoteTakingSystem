package entity;

import java.time.LocalDateTime;

public interface UserFactory {
    User createUser(String username, String password);

    User create(String username, String password);
}
