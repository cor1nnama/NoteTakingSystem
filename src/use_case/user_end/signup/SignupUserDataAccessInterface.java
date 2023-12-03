package use_case.user_end.signup;

import entity.User;

public interface SignupUserDataAccessInterface {
    boolean existsByName(String identifier);
    void save(User user);
    User get(String username);
}
