package use_case.user_end.login;

import entity.User;

import java.io.IOException;

public interface LoginUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user) throws IOException;

    User get(String username);

    boolean authenticateUser(String username, String password);
}
