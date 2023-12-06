package use_case.user_end.signup;
import entity.User;

import java.io.IOException;
import java.util.Map;

public interface UserSignupDataAccessInterface {
    boolean existsByName(String identifier);
    void save(User user) throws IOException;
    User get(String username);
}
