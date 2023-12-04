package use_case.user_end.login;
import entity.CommonUser;
import entity.User;

public class LoginOutputData {
    User user;
    public LoginOutputData(User user){
        this.user = user;
    }
}