package data_access;

import entity.CommonUser;
import entity.User;
import use_case.user_end.login.LoginUserDataAccessInterface;
import use_case.user_end.signup.UserSignupDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements UserSignupDataAccessInterface, LoginUserDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();

    public InMemoryUserDataAccessObject (){
        CommonUser user1 = new CommonUser("Imtiaz", "password_I");
        CommonUser user2 = new CommonUser("Daniel", "password_D");
        users.put("Imtiaz", user1);
        users.put("Daniel", user1);
    }


    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public void save(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public User get(String username) {
        return null;
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        return false;
    }
}
