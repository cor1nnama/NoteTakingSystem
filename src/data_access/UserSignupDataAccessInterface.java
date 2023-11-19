package data_access;
import entity.User;
import java.util.Map;

public interface UserSignupDataAccessInterface {
    boolean existsByName(String identifier);
    void save(User user);
}
