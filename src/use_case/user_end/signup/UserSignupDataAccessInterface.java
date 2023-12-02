package use_case.user_end.signup;
import entity.User;
import java.util.Map;

public interface UserSignupDataAccessInterface {
    boolean existsByName(String identifier);
    void save(User user);
    User get(String username);
}