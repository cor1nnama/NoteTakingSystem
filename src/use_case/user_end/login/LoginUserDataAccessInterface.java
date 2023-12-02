package use_case.user_end.login;

import entity.User;

public interface LoginUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);

    boolean authenticateUser(String username, String password);
}
